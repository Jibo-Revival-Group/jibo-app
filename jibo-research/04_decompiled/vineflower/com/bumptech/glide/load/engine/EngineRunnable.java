package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.executor.Prioritized;
import com.bumptech.glide.request.ResourceCallback;

class EngineRunnable implements Prioritized, Runnable {
   private final DecodeJob<?, ?, ?> decodeJob;
   private volatile boolean isCancelled;
   private final EngineRunnable.EngineRunnableManager manager;
   private final Priority priority;
   private EngineRunnable.Stage stage;

   public EngineRunnable(EngineRunnable.EngineRunnableManager var1, DecodeJob<?, ?, ?> var2, Priority var3) {
      this.manager = var1;
      this.decodeJob = var2;
      this.stage = EngineRunnable.Stage.CACHE;
      this.priority = var3;
   }

   private Resource<?> decode() throws Exception {
      Resource var1;
      if (this.isDecodingFromCache()) {
         var1 = this.decodeFromCache();
      } else {
         var1 = this.decodeFromSource();
      }

      return var1;
   }

   private Resource<?> decodeFromCache() throws Exception {
      Resource var1;
      try {
         var1 = this.decodeJob.decodeResultFromCache();
      } catch (Exception var3) {
         if (Log.isLoggable("EngineRunnable", 3)) {
            Log.d("EngineRunnable", "Exception decoding result from cache: " + var3);
         }

         var1 = null;
      }

      Resource var2 = var1;
      if (var1 == null) {
         var2 = this.decodeJob.decodeSourceFromCache();
      }

      return var2;
   }

   private Resource<?> decodeFromSource() throws Exception {
      return this.decodeJob.decodeFromSource();
   }

   private boolean isDecodingFromCache() {
      boolean var1;
      if (this.stage == EngineRunnable.Stage.CACHE) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void onLoadComplete(Resource var1) {
      this.manager.onResourceReady(var1);
   }

   private void onLoadFailed(Exception var1) {
      if (this.isDecodingFromCache()) {
         this.stage = EngineRunnable.Stage.SOURCE;
         this.manager.submitForSource(this);
      } else {
         this.manager.onException(var1);
      }
   }

   public void cancel() {
      this.isCancelled = true;
      this.decodeJob.cancel();
   }

   @Override
   public int getPriority() {
      return this.priority.ordinal();
   }

   @Override
   public void run() {
      Exception var2 = null;
      if (!this.isCancelled) {
         Resource var1;
         try {
            var1 = this.decode();
         } catch (Exception var3) {
            var2 = var3;
            if (Log.isLoggable("EngineRunnable", 2)) {
               Log.v("EngineRunnable", "Exception decoding", var3);
            }

            var1 = null;
         }

         if (this.isCancelled) {
            if (var1 != null) {
               var1.recycle();
            }
         } else if (var1 == null) {
            this.onLoadFailed(var2);
         } else {
            this.onLoadComplete(var1);
         }
      }
   }

   interface EngineRunnableManager extends ResourceCallback {
      void submitForSource(EngineRunnable var1);
   }

   private enum Stage {
      CACHE,
      SOURCE;

      private static final EngineRunnable.Stage[] $VALUES = new EngineRunnable.Stage[]{EngineRunnable.Stage.CACHE, EngineRunnable.Stage.SOURCE};
   }
}
