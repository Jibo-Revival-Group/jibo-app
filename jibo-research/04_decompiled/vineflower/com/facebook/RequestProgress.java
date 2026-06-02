package com.facebook;

import android.os.Handler;

class RequestProgress {
   private final Handler callbackHandler;
   private long lastReportedProgress;
   private long maxProgress;
   private long progress;
   private final GraphRequest request;
   private final long threshold;

   RequestProgress(Handler var1, GraphRequest var2) {
      this.request = var2;
      this.callbackHandler = var1;
      this.threshold = FacebookSdk.getOnProgressThreshold();
   }

   void addProgress(long var1) {
      this.progress += var1;
      if (this.progress >= this.lastReportedProgress + this.threshold || this.progress >= this.maxProgress) {
         this.reportProgress();
      }
   }

   void addToMax(long var1) {
      this.maxProgress += var1;
   }

   long getMaxProgress() {
      return this.maxProgress;
   }

   long getProgress() {
      return this.progress;
   }

   void reportProgress() {
      if (this.progress > this.lastReportedProgress) {
         GraphRequest.OnProgressCallback var5 = this.request.getCallback();
         if (this.maxProgress > 0L && var5 instanceof GraphRequest.OnProgressCallback) {
            long var1 = this.progress;
            long var3 = this.maxProgress;
            var5 = var5;
            if (this.callbackHandler == null) {
               var5.onProgress(var1, var3);
            } else {
               this.callbackHandler.post(new Runnable(this, var5, var1, var3) {
                  final RequestProgress this$0;
                  final GraphRequest.OnProgressCallback val$callbackCopy;
                  final long val$currentCopy;
                  final long val$maxProgressCopy;

                  {
                     this.this$0 = var1;
                     this.val$callbackCopy = var2;
                     this.val$currentCopy = var3x;
                     this.val$maxProgressCopy = var5x;
                  }

                  @Override
                  public void run() {
                     this.val$callbackCopy.onProgress(this.val$currentCopy, this.val$maxProgressCopy);
                  }
               });
            }

            this.lastReportedProgress = this.progress;
         }
      }
   }
}
