package com.google.api.client.util.store;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Throwables;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class FileDataStoreFactory extends AbstractDataStoreFactory {
    private static final Logger LOGGER = Logger.getLogger(FileDataStoreFactory.class.getName());
    private final File dataDirectory;

    public FileDataStoreFactory(File file) throws Throwable {
        File canonicalFile = file.getCanonicalFile();
        this.dataDirectory = canonicalFile;
        if (IOUtils.isSymbolicLink(canonicalFile)) {
            String strValueOf = String.valueOf(String.valueOf(canonicalFile));
            throw new IOException(new StringBuilder(strValueOf.length() + 31).append("unable to use a symbolic link: ").append(strValueOf).toString());
        }
        if (!canonicalFile.exists() && !canonicalFile.mkdirs()) {
            String strValueOf2 = String.valueOf(String.valueOf(canonicalFile));
            throw new IOException(new StringBuilder(strValueOf2.length() + 28).append("unable to create directory: ").append(strValueOf2).toString());
        }
        setPermissionsToOwnerOnly(canonicalFile);
    }

    public final File getDataDirectory() {
        return this.dataDirectory;
    }

    @Override // com.google.api.client.util.store.AbstractDataStoreFactory
    protected <V extends Serializable> DataStore<V> createDataStore(String str) throws IOException {
        return new FileDataStore(this, this.dataDirectory, str);
    }

    static class FileDataStore<V extends Serializable> extends AbstractMemoryDataStore<V> {
        private final File dataFile;

        FileDataStore(FileDataStoreFactory fileDataStoreFactory, File file, String str) throws IOException {
            super(fileDataStoreFactory, str);
            this.dataFile = new File(file, str);
            if (IOUtils.isSymbolicLink(this.dataFile)) {
                String strValueOf = String.valueOf(String.valueOf(this.dataFile));
                throw new IOException(new StringBuilder(strValueOf.length() + 31).append("unable to use a symbolic link: ").append(strValueOf).toString());
            }
            if (this.dataFile.createNewFile()) {
                this.keyValueMap = Maps.newHashMap();
                save();
            } else {
                this.keyValueMap = (HashMap) IOUtils.deserialize(new FileInputStream(this.dataFile));
            }
        }

        @Override // com.google.api.client.util.store.AbstractMemoryDataStore
        void save() throws IOException {
            IOUtils.serialize(this.keyValueMap, new FileOutputStream(this.dataFile));
        }

        @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
        public FileDataStoreFactory getDataStoreFactory() {
            return (FileDataStoreFactory) super.getDataStoreFactory();
        }
    }

    static void setPermissionsToOwnerOnly(File file) throws Throwable {
        try {
            Method method = File.class.getMethod("setReadable", Boolean.TYPE, Boolean.TYPE);
            Method method2 = File.class.getMethod("setWritable", Boolean.TYPE, Boolean.TYPE);
            Method method3 = File.class.getMethod("setExecutable", Boolean.TYPE, Boolean.TYPE);
            if (!((Boolean) method.invoke(file, false, false)).booleanValue() || !((Boolean) method2.invoke(file, false, false)).booleanValue() || !((Boolean) method3.invoke(file, false, false)).booleanValue()) {
                Logger logger = LOGGER;
                String strValueOf = String.valueOf(String.valueOf(file));
                logger.warning(new StringBuilder(strValueOf.length() + 44).append("unable to change permissions for everybody: ").append(strValueOf).toString());
            }
            if (!((Boolean) method.invoke(file, true, true)).booleanValue() || !((Boolean) method2.invoke(file, true, true)).booleanValue() || !((Boolean) method3.invoke(file, true, true)).booleanValue()) {
                Logger logger2 = LOGGER;
                String strValueOf2 = String.valueOf(String.valueOf(file));
                logger2.warning(new StringBuilder(strValueOf2.length() + 40).append("unable to change permissions for owner: ").append(strValueOf2).toString());
            }
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e2) {
        } catch (NoSuchMethodException e3) {
            Logger logger3 = LOGGER;
            String strValueOf3 = String.valueOf(String.valueOf(file));
            logger3.warning(new StringBuilder(strValueOf3.length() + 93).append("Unable to set permissions for ").append(strValueOf3).append(", likely because you are running a version of Java prior to 1.6").toString());
        } catch (SecurityException e4) {
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            Throwables.propagateIfPossible(cause, IOException.class);
            throw new RuntimeException(cause);
        }
    }
}
