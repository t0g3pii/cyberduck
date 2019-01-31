package ch.cyberduck.core.worker;

/*
 * Copyright (c) 2002-2015 David Kocher. All rights reserved.
 * http://cyberduck.ch/
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
 *
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.LocaleFactory;
import ch.cyberduck.core.MappingMimeTypeService;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Session;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Encryption;
import ch.cyberduck.core.features.Redundancy;
import ch.cyberduck.core.features.Touch;
import ch.cyberduck.core.features.UnixPermission;
import ch.cyberduck.core.transfer.TransferStatus;

import java.text.MessageFormat;
import java.util.EnumSet;
import java.util.Objects;

public class TouchWorker extends Worker<Path> {

    private final Path file;

    public TouchWorker(final Path file) {
        this.file = file;
    }

    @Override
    public Path run(final Session<?> session) throws BackgroundException {
        final Touch feature = session.getFeature(Touch.class);
        final TransferStatus status = new TransferStatus()
            .exists(false)
            .length(0L)
            .withMime(new MappingMimeTypeService().getMime(file.getName()));
        final Encryption encryption = session.getFeature(Encryption.class);
        if(encryption != null) {
            status.setEncryption(encryption.getDefault(file));
        }
        final Redundancy redundancy = session.getFeature(Redundancy.class);
        if(redundancy != null) {
            status.setStorageClass(redundancy.getDefault());
        }
        status.setTimestamp(System.currentTimeMillis());
        final UnixPermission permission = session.getFeature(UnixPermission.class);
        if(permission != null) {
            status.setPermission(permission.getDefault(EnumSet.of(Path.Type.file)));
        }
        return feature.touch(file, status);
    }

    @Override
    public Path initialize() {
        return file;
    }

    @Override
    public String getActivity() {
        return MessageFormat.format(LocaleFactory.localizedString("Uploading {0}", "Status"),
            file.getName());
    }

    @Override
    public boolean equals(final Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        final TouchWorker that = (TouchWorker) o;
        return Objects.equals(file, that.file);

    }

    @Override
    public int hashCode() {
        return file != null ? file.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TouchWorker{");
        sb.append("file=").append(file);
        sb.append('}');
        return sb.toString();
    }
}
