package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.util.LogTime;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
class DecodeJob<A, T, Z> {
    private static final FileOpener DEFAULT_FILE_OPENER = new FileOpener();
    private final DiskCacheProvider diskCacheProvider;
    private final DiskCacheStrategy diskCacheStrategy;
    private final DataFetcher<A> fetcher;
    private final FileOpener fileOpener;
    private final int height;
    private volatile boolean isCancelled;
    private final DataLoadProvider<A, T> loadProvider;
    private final Priority priority;
    private final EngineKey resultKey;
    private final ResourceTranscoder<T, Z> transcoder;
    private final Transformation<T> transformation;
    private final int width;

    interface DiskCacheProvider {
        DiskCache getDiskCache();
    }

    public DecodeJob(EngineKey engineKey, int i, int i2, DataFetcher<A> dataFetcher, DataLoadProvider<A, T> dataLoadProvider, Transformation<T> transformation, ResourceTranscoder<T, Z> resourceTranscoder, DiskCacheProvider diskCacheProvider, DiskCacheStrategy diskCacheStrategy, Priority priority) {
        this(engineKey, i, i2, dataFetcher, dataLoadProvider, transformation, resourceTranscoder, diskCacheProvider, diskCacheStrategy, priority, DEFAULT_FILE_OPENER);
    }

    DecodeJob(EngineKey engineKey, int i, int i2, DataFetcher<A> dataFetcher, DataLoadProvider<A, T> dataLoadProvider, Transformation<T> transformation, ResourceTranscoder<T, Z> resourceTranscoder, DiskCacheProvider diskCacheProvider, DiskCacheStrategy diskCacheStrategy, Priority priority, FileOpener fileOpener) {
        this.resultKey = engineKey;
        this.width = i;
        this.height = i2;
        this.fetcher = dataFetcher;
        this.loadProvider = dataLoadProvider;
        this.transformation = transformation;
        this.transcoder = resourceTranscoder;
        this.diskCacheProvider = diskCacheProvider;
        this.diskCacheStrategy = diskCacheStrategy;
        this.priority = priority;
        this.fileOpener = fileOpener;
    }

    public Resource<Z> decodeResultFromCache() throws Exception {
        if (!this.diskCacheStrategy.cacheResult()) {
            return null;
        }
        long jM5581a = LogTime.m5581a();
        Resource<T> resourceLoadFromCache = loadFromCache(this.resultKey);
        if (Log.isLoggable("DecodeJob", 2)) {
            logWithTimeAndKey("Decoded transformed from cache", jM5581a);
        }
        long jM5581a2 = LogTime.m5581a();
        Resource<Z> resourceTranscode = transcode(resourceLoadFromCache);
        if (Log.isLoggable("DecodeJob", 2)) {
            logWithTimeAndKey("Transcoded transformed from cache", jM5581a2);
            return resourceTranscode;
        }
        return resourceTranscode;
    }

    public Resource<Z> decodeSourceFromCache() throws Exception {
        if (!this.diskCacheStrategy.cacheSource()) {
            return null;
        }
        long jM5581a = LogTime.m5581a();
        Resource<T> resourceLoadFromCache = loadFromCache(this.resultKey.getOriginalKey());
        if (Log.isLoggable("DecodeJob", 2)) {
            logWithTimeAndKey("Decoded source from cache", jM5581a);
        }
        return transformEncodeAndTranscode(resourceLoadFromCache);
    }

    public Resource<Z> decodeFromSource() throws Exception {
        return transformEncodeAndTranscode(decodeSource());
    }

    public void cancel() {
        this.isCancelled = true;
        this.fetcher.cancel();
    }

    private Resource<Z> transformEncodeAndTranscode(Resource<T> resource) {
        long jM5581a = LogTime.m5581a();
        Resource<T> resourceTransform = transform(resource);
        if (Log.isLoggable("DecodeJob", 2)) {
            logWithTimeAndKey("Transformed resource from source", jM5581a);
        }
        writeTransformedToCache(resourceTransform);
        long jM5581a2 = LogTime.m5581a();
        Resource<Z> resourceTranscode = transcode(resourceTransform);
        if (Log.isLoggable("DecodeJob", 2)) {
            logWithTimeAndKey("Transcoded transformed from source", jM5581a2);
        }
        return resourceTranscode;
    }

    private void writeTransformedToCache(Resource<T> resource) {
        if (resource != null && this.diskCacheStrategy.cacheResult()) {
            long jM5581a = LogTime.m5581a();
            this.diskCacheProvider.getDiskCache().put(this.resultKey, new SourceWriter(this.loadProvider.getEncoder(), resource));
            if (Log.isLoggable("DecodeJob", 2)) {
                logWithTimeAndKey("Wrote transformed from source to cache", jM5581a);
            }
        }
    }

    private Resource<T> decodeSource() throws Exception {
        try {
            long jM5581a = LogTime.m5581a();
            A aLoadData = this.fetcher.loadData(this.priority);
            if (Log.isLoggable("DecodeJob", 2)) {
                logWithTimeAndKey("Fetched data", jM5581a);
            }
            if (!this.isCancelled) {
                return decodeFromSourceData(aLoadData);
            }
            return null;
        } finally {
            this.fetcher.cleanup();
        }
    }

    private Resource<T> decodeFromSourceData(A a) throws IOException {
        if (this.diskCacheStrategy.cacheSource()) {
            return cacheAndDecodeSourceData(a);
        }
        long jM5581a = LogTime.m5581a();
        Resource<T> resourceDecode = this.loadProvider.getSourceDecoder().decode(a, this.width, this.height);
        if (Log.isLoggable("DecodeJob", 2)) {
            logWithTimeAndKey("Decoded from source", jM5581a);
            return resourceDecode;
        }
        return resourceDecode;
    }

    private Resource<T> cacheAndDecodeSourceData(A a) throws IOException {
        long jM5581a = LogTime.m5581a();
        this.diskCacheProvider.getDiskCache().put(this.resultKey.getOriginalKey(), new SourceWriter(this.loadProvider.getSourceEncoder(), a));
        if (Log.isLoggable("DecodeJob", 2)) {
            logWithTimeAndKey("Wrote source to cache", jM5581a);
        }
        long jM5581a2 = LogTime.m5581a();
        Resource<T> resourceLoadFromCache = loadFromCache(this.resultKey.getOriginalKey());
        if (Log.isLoggable("DecodeJob", 2) && resourceLoadFromCache != null) {
            logWithTimeAndKey("Decoded source from cache", jM5581a2);
        }
        return resourceLoadFromCache;
    }

    private Resource<T> loadFromCache(Key key) throws IOException {
        Resource<T> resourceDecode = null;
        File file = this.diskCacheProvider.getDiskCache().get(key);
        if (file != null) {
            try {
                resourceDecode = this.loadProvider.getCacheDecoder().decode(file, this.width, this.height);
                if (resourceDecode == null) {
                    this.diskCacheProvider.getDiskCache().delete(key);
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    this.diskCacheProvider.getDiskCache().delete(key);
                }
                throw th;
            }
        }
        return resourceDecode;
    }

    private Resource<T> transform(Resource<T> resource) {
        if (resource == null) {
            return null;
        }
        Resource<T> resourceTransform = this.transformation.transform(resource, this.width, this.height);
        if (!resource.equals(resourceTransform)) {
            resource.recycle();
            return resourceTransform;
        }
        return resourceTransform;
    }

    private Resource<Z> transcode(Resource<T> resource) {
        if (resource == null) {
            return null;
        }
        return this.transcoder.transcode(resource);
    }

    private void logWithTimeAndKey(String str, long j) {
        Log.v("DecodeJob", str + " in " + LogTime.m5580a(j) + ", key: " + this.resultKey);
    }

    class SourceWriter<DataType> implements DiskCache.Writer {
        private final DataType data;
        private final Encoder<DataType> encoder;

        public SourceWriter(Encoder<DataType> encoder, DataType datatype) {
            this.encoder = encoder;
            this.data = datatype;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
        public boolean write(File file) {
            boolean zEncode = false;
            OutputStream outputStreamM5423a = null;
            try {
                try {
                    outputStreamM5423a = DecodeJob.this.fileOpener.m5423a(file);
                    zEncode = this.encoder.encode(this.data, outputStreamM5423a);
                    if (outputStreamM5423a != null) {
                        try {
                            outputStreamM5423a.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable th) {
                    if (outputStreamM5423a != null) {
                        try {
                            outputStreamM5423a.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "Failed to find file to write to disk cache", e3);
                }
                if (outputStreamM5423a != null) {
                    try {
                        outputStreamM5423a.close();
                    } catch (IOException e4) {
                    }
                }
            }
            return zEncode;
        }
    }

    static class FileOpener {
        FileOpener() {
        }

        /* JADX INFO: renamed from: a */
        public OutputStream m5423a(File file) throws FileNotFoundException {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }
}
