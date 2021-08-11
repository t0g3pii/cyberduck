package ch.cyberduck.core.sds;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.Credentials;
import ch.cyberduck.core.DisabledListProgressListener;
import ch.cyberduck.core.PasswordCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Session;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.VersionIdProvider;
import ch.cyberduck.core.preferences.HostPreferences;
import ch.cyberduck.core.preferences.PreferencesFactory;
import ch.cyberduck.core.sds.io.swagger.client.ApiException;
import ch.cyberduck.core.sds.io.swagger.client.api.NodesApi;
import ch.cyberduck.core.sds.io.swagger.client.api.UserApi;
import ch.cyberduck.core.sds.io.swagger.client.model.FileFileKeys;
import ch.cyberduck.core.sds.io.swagger.client.model.MissingKeysResponse;
import ch.cyberduck.core.sds.io.swagger.client.model.UserFileKeySetBatchRequest;
import ch.cyberduck.core.sds.io.swagger.client.model.UserFileKeySetRequest;
import ch.cyberduck.core.sds.io.swagger.client.model.UserIdFileIdItem;
import ch.cyberduck.core.sds.io.swagger.client.model.UserKeyPairContainer;
import ch.cyberduck.core.sds.io.swagger.client.model.UserUserPublicKey;
import ch.cyberduck.core.sds.triplecrypt.TripleCryptConverter;
import ch.cyberduck.core.sds.triplecrypt.TripleCryptExceptionMappingService;
import ch.cyberduck.core.sds.triplecrypt.TripleCryptKeyPair;
import ch.cyberduck.core.shared.AbstractSchedulerFeature;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.dracoon.sdk.crypto.Crypto;
import com.dracoon.sdk.crypto.error.CryptoException;
import com.dracoon.sdk.crypto.error.CryptoSystemException;
import com.dracoon.sdk.crypto.error.InvalidFileKeyException;
import com.dracoon.sdk.crypto.error.InvalidKeyPairException;
import com.dracoon.sdk.crypto.error.InvalidPasswordException;
import com.dracoon.sdk.crypto.error.UnknownVersionException;
import com.dracoon.sdk.crypto.model.EncryptedFileKey;
import com.dracoon.sdk.crypto.model.PlainFileKey;
import com.dracoon.sdk.crypto.model.UserKeyPair;
import com.dracoon.sdk.crypto.model.UserPrivateKey;

import static java.util.stream.Collectors.groupingBy;

public class SDSMissingFileKeysSchedulerFeature extends AbstractSchedulerFeature<List<UserFileKeySetRequest>, SDSApiClient> {
    private static final Logger log = Logger.getLogger(SDSMissingFileKeysSchedulerFeature.class);

    public SDSMissingFileKeysSchedulerFeature() {
        this(PreferencesFactory.get().getLong("sds.encryption.missingkeys.scheduler.period"));
    }

    public SDSMissingFileKeysSchedulerFeature(final long period) {
        super(period);
    }

    @Override
    public List<UserFileKeySetRequest> operate(final Session<SDSApiClient> client, final PasswordCallback callback, final Path file) throws BackgroundException {
        final SDSSession session = (SDSSession) client;
        final SDSNodeIdProvider nodeid = (SDSNodeIdProvider) session._getFeature(VersionIdProvider.class);
        try {
            final UserAccountWrapper account = session.userAccount();
            if(!account.isEncryptionEnabled()) {
                log.warn(String.format("No key pair found in user account %s", account));
                return Collections.emptyList();
            }
            final List<UserFileKeySetRequest> processed = new ArrayList<>();
            final UserKeyPairContainer userKeyPairContainer = session.keyPair();
            final UserKeyPair keyPair = TripleCryptConverter.toCryptoUserKeyPair(userKeyPairContainer);
            final TripleCryptKeyPair triplecrypt = new TripleCryptKeyPair();
            final Credentials passphrase = triplecrypt.unlock(callback, session.getHost(), keyPair);
            final UserKeyPairContainer userKeyPairContainerDeprecated = session.keyPairDeprecated();
            Credentials passphraseDeprecated = passphrase;
            if(userKeyPairContainerDeprecated != null) {
                passphraseDeprecated = triplecrypt.unlock(callback, session.getHost(), TripleCryptConverter.toCryptoUserKeyPair(userKeyPairContainerDeprecated));
            }
            // Null when operating from scheduler. File reference is set for post upload.
            final Long fileId = file != null ? Long.parseLong(nodeid.getVersionId(file, new DisabledListProgressListener())) : null;
            UserFileKeySetBatchRequest request;
            do {
                if(log.isDebugEnabled()) {
                    log.debug(String.format("Request a list of missing file keys for file %s", file));
                }
                request = new UserFileKeySetBatchRequest();
                final MissingKeysResponse missingKeys = new NodesApi(session.getClient()).requestMissingFileKeys(
                    null, null, null, fileId, null, null, null);
                final Map<Long, List<UserUserPublicKey>> userPublicKeys = missingKeys.getUsers().stream().collect(groupingBy(UserUserPublicKey::getId));
                final Map<Long, List<FileFileKeys>> files = missingKeys.getFiles().stream().collect(groupingBy(FileFileKeys::getId));
                for(UserIdFileIdItem item : missingKeys.getItems()) {
                    for(FileFileKeys fileKey : files.get(item.getFileId())) {
                        final EncryptedFileKey encryptedFileKey = TripleCryptConverter.toCryptoEncryptedFileKey(fileKey.getFileKeyContainer());
                        final UserKeyPairContainer keyPairForDecryption = session.getKeyPairForFileKey(encryptedFileKey.getVersion());
                        for(UserUserPublicKey userPublicKey : userPublicKeys.get(item.getUserId())) {
                            final EncryptedFileKey fk = this.encryptFileKey(
                                TripleCryptConverter.toCryptoUserPrivateKey(keyPairForDecryption.getPrivateKeyContainer()),
                                encryptedFileKey.getVersion() == EncryptedFileKey.Version.RSA2048_AES256GCM ? passphraseDeprecated : passphrase,
                                userPublicKey, fileKey);
                            final UserFileKeySetRequest keySetRequest = new UserFileKeySetRequest()
                                .fileId(item.getFileId())
                                .userId(item.getUserId())
                                .fileKey(TripleCryptConverter.toSwaggerFileKey(fk));
                            if(log.isDebugEnabled()) {
                                log.debug(String.format("Missing file key processed for file %d and user %d", item.getFileId(), item.getUserId()));
                            }
                            request.addItemsItem(keySetRequest);
                        }
                    }
                }
                if(!request.getItems().isEmpty()) {
                    if(log.isDebugEnabled()) {
                        log.debug(String.format("Set file keys with %s", request));
                    }
                    new NodesApi(session.getClient()).setUserFileKeys(request, StringUtils.EMPTY);
                    processed.addAll(request.getItems());
                }
            }
            while(!request.getItems().isEmpty());
            this.deleteDeprecatedKeyPair(session);
            return processed;
        }
        catch(ApiException e) {
            throw new SDSExceptionMappingService(nodeid).map(e);
        }
        catch(CryptoException e) {
            throw new TripleCryptExceptionMappingService().map(e);
        }
    }

    private void deleteDeprecatedKeyPair(final SDSSession session) throws ApiException, BackgroundException {
        if(new HostPreferences(session.getHost()).getBoolean("sds.encryption.missingkeys.delete.deprecated")) {
            if(session.keyPairDeprecated() != null && !session.keyPairDeprecated().equals(session.keyPair())) {
                final MissingKeysResponse missingKeys = new NodesApi(session.getClient()).requestMissingFileKeys(
                    null, 1, null, null, session.userAccount().getId(), "previous_user_key", null);
                if(missingKeys.getItems().isEmpty()) {
                    log.debug("No more deprecated fileKeys to migrate - deleting deprecated key pair");
                    new UserApi(session.getClient()).removeUserKeyPair(session.keyPairDeprecated().getPublicKeyContainer().getVersion(), null);
                    session.resetUserKeyPairs();
                }
            }
        }
    }

    private EncryptedFileKey encryptFileKey(final UserPrivateKey privateKey, final Credentials passphrase,
                                            final UserUserPublicKey pubkey, final FileFileKeys fileKeys)
        throws InvalidFileKeyException, InvalidKeyPairException, InvalidPasswordException, CryptoSystemException, UnknownVersionException {
        final PlainFileKey plainFileKey = Crypto.decryptFileKey(
            TripleCryptConverter.toCryptoEncryptedFileKey(fileKeys.getFileKeyContainer()), privateKey, passphrase.getPassword());
        return Crypto.encryptFileKey(
            plainFileKey, TripleCryptConverter.toCryptoUserPublicKey(pubkey.getPublicKeyContainer()));
    }
}
