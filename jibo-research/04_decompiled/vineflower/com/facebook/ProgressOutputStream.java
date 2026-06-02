package com.facebook;

import android.os.Handler;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
   private long batchProgress;
   private RequestProgress currentRequestProgress;
   private long lastReportedProgress;
   private long maxProgress;
   private final Map<GraphRequest, RequestProgress> progressMap;
   private final GraphRequestBatch requests;
   private final long threshold;

   ProgressOutputStream(OutputStream var1, GraphRequestBatch var2, Map<GraphRequest, RequestProgress> var3, long var4) {
      super(var1);
      this.requests = var2;
      this.progressMap = var3;
      this.maxProgress = var4;
      this.threshold = FacebookSdk.getOnProgressThreshold();
   }

   private void addProgress(long var1) {
      if (this.currentRequestProgress != null) {
         this.currentRequestProgress.addProgress(var1);
      }

      this.batchProgress += var1;
      if (this.batchProgress >= this.lastReportedProgress + this.threshold || this.batchProgress >= this.maxProgress) {
         this.reportBatchProgress();
      }
   }

   private void reportBatchProgress() {
      if (this.batchProgress > this.lastReportedProgress) {
         for (GraphRequestBatch.OnProgressCallback var3 : this.requests.getCallbacks()) {
            if (var3 instanceof GraphRequestBatch.OnProgressCallback) {
               Handler var2 = this.requests.getCallbackHandler();
               var3 = var3;
               if (var2 == null) {
                  var3.onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
               } else {
                  var2.post(new Runnable(this, var3) {
                     final ProgressOutputStream this$0;
                     final GraphRequestBatch.OnProgressCallback val$progressCallback;

                     {
                        this.this$0 = var1;
                        this.val$progressCallback = var2x;
                     }

                     @Override
                     public void run() {
                        this.val$progressCallback.onBatchProgress(this.this$0.requests, this.this$0.batchProgress, this.this$0.maxProgress);
                     }
                  });
               }
            }
         }

         this.lastReportedProgress = this.batchProgress;
      }
   }

   @Override
   public void close() throws IOException {
      super.close();
      Iterator var1 = this.progressMap.values().iterator();

      while (var1.hasNext()) {
         ((RequestProgress)var1.next()).reportProgress();
      }

      this.reportBatchProgress();
   }

   long getBatchProgress() {
      return this.batchProgress;
   }

   long getMaxProgress() {
      return this.maxProgress;
   }

   @Override
   public void setCurrentRequest(GraphRequest var1) {
      RequestProgress var2;
      if (var1 != null) {
         var2 = this.progressMap.get(var1);
      } else {
         var2 = null;
      }

      this.currentRequestProgress = var2;
   }

   @Override
   public void write(int var1) throws IOException {
      this.out.write(var1);
      this.addProgress(1L);
   }

   @Override
   public void write(byte[] var1) throws IOException {
      this.out.write(var1);
      this.addProgress(var1.length);
   }

   @Override
   public void write(byte[] var1, int var2, int var3) throws IOException {
      this.out.write(var1, var2, var3);
      this.addProgress(var3);
   }
}
