package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.executor.Prioritized;
import com.bumptech.glide.request.ResourceCallback;

/* JADX INFO: loaded from: classes.dex */
class EngineRunnable implements Prioritized, Runnable {
    private final DecodeJob<?, ?, ?> decodeJob;
    private volatile boolean isCancelled;
    private final EngineRunnableManager manager;
    private final Priority priority;
    private Stage stage = Stage.CACHE;

    interface EngineRunnableManager extends ResourceCallback {
        void submitForSource(EngineRunnable engineRunnable);
    }

    private enum Stage {
        CACHE,
        SOURCE
    }

    public EngineRunnable(EngineRunnableManager engineRunnableManager, DecodeJob<?, ?, ?> decodeJob, Priority priority) {
        this.manager = engineRunnableManager;
        this.decodeJob = decodeJob;
        this.priority = priority;
    }

    public void cancel() {
        this.isCancelled = true;
        this.decodeJob.cancel();
    }

    @Override // java.lang.Runnable
    public void run() {
        Resource<?> resourceDecode;
        Exception exc = null;
        if (!this.isCancelled) {
            try {
                resourceDecode = decode();
            } catch (Exception e) {
                if (Log.isLoggable("EngineRunnable", 2)) {
                    Log.v("EngineRunnable", "Exception decoding", e);
                }
                exc = e;
                resourceDecode = null;
            }
            if (this.isCancelled) {
                if (resourceDecode != null) {
                    resourceDecode.recycle();
                }
            } else if (resourceDecode == null) {
                onLoadFailed(exc);
            } else {
                onLoadComplete(resourceDecode);
            }
        }
    }

    private boolean isDecodingFromCache() {
        return this.stage == Stage.CACHE;
    }

    private void onLoadComplete(Resource resource) {
        this.manager.onResourceReady(resource);
    }

    private void onLoadFailed(Exception exc) {
        if (isDecodingFromCache()) {
            this.stage = Stage.SOURCE;
            this.manager.submitForSource(this);
        } else {
            this.manager.onException(exc);
        }
    }

    private Resource<?> decode() throws Exception {
        return isDecodingFromCache() ? decodeFromCache() : decodeFromSource();
    }

    private Resource<?> decodeFromCache() throws Exception {
        Resource<?> resourceDecodeResultFromCache;
        try {
            resourceDecodeResultFromCache = this.decodeJob.decodeResultFromCache();
        } catch (Exception e) {
            if (Log.isLoggable("EngineRunnable", 3)) {
                Log.d("EngineRunnable", "Exception decoding result from cache: " + e);
            }
            resourceDecodeResultFromCache = null;
        }
        if (resourceDecodeResultFromCache == null) {
            return this.decodeJob.decodeSourceFromCache();
        }
        return resourceDecodeResultFromCache;
    }

    private Resource<?> decodeFromSource() throws Exception {
        return this.decodeJob.decodeFromSource();
    }

    @Override // com.bumptech.glide.load.engine.executor.Prioritized
    public int getPriority() {
        return this.priority.ordinal();
    }
}
