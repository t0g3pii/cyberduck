package ch.cyberduck.core.onedrive;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Directory;
import ch.cyberduck.core.features.Write;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.log4j.Logger;
import org.nuxeo.onedrive.client.OneDriveAPIException;
import org.nuxeo.onedrive.client.OneDriveJsonRequest;
import org.nuxeo.onedrive.client.OneDriveJsonResponse;

import java.net.URL;

import com.eclipsesource.json.JsonObject;

public class OneDriveDirectoryFeature implements Directory {
    private static final Logger log = Logger.getLogger(OneDriveDirectoryFeature.class);

    private final OneDriveSession session;

    public OneDriveDirectoryFeature(OneDriveSession session) {
        this.session = session;
    }

    @Override
    public void mkdir(final Path file) throws BackgroundException {
        this.mkdir(file, null, new TransferStatus());
    }

    @Override
    public void mkdir(final Path file, final String region, final TransferStatus status) throws BackgroundException {
        if(file.isRoot() || file.getParent().isRoot()) {
            throw new BackgroundException("Cannot create directory here", "Create directory in container");
        }

        // evaluating query
        StringBuilder builder = session.getBaseUrlStringBuilder();
        final Path parent = file.getParent();
        PathContainerService pathContainerService = new PathContainerService();
        session.resolveDriveQueryPath(parent, builder, pathContainerService);
        session.resolveChildrenPath(parent, builder, pathContainerService);

        final URL apiUrl = session.getUrl(builder);

        try {
            OneDriveJsonRequest request = new OneDriveJsonRequest(session.getClient(), apiUrl, "POST");
            JsonObject requestObject = new JsonObject();
            requestObject.add("name", file.getName());
            requestObject.add("folder", new JsonObject());
            OneDriveJsonResponse response = request.send();
            final int responseCode = response.getResponseCode();
            if(responseCode != 201) {
                log.error(String.format("Folder could not be created %s. API answered %d", file.getAbsolute(), responseCode));
            }
        }
        catch(OneDriveAPIException e) {
            throw new BackgroundException(e);
        }
    }

    @Override
    public Directory withWriter(final Write writer) {
        return null;
    }
}
