package com.segment.analytics;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Stats {
   private static final String STATS_THREAD_NAME = "Segment-Stats";
   long flushCount;
   long flushEventCount;
   final Stats.StatsHandler handler;
   long integrationOperationCount;
   long integrationOperationDuration;
   Map<String, Long> integrationOperationDurationByIntegration = new HashMap<>();
   final HandlerThread statsThread = new HandlerThread("Segment-Stats", 10);

   Stats() {
      this.statsThread.start();
      this.handler = new Stats.StatsHandler(this.statsThread.getLooper(), this);
   }

   StatsSnapshot createSnapshot() {
      return new StatsSnapshot(
         System.currentTimeMillis(),
         this.flushCount,
         this.flushEventCount,
         this.integrationOperationCount,
         this.integrationOperationDuration,
         Collections.unmodifiableMap(this.integrationOperationDurationByIntegration)
      );
   }

   void dispatchFlush(int var1) {
      this.handler.sendMessage(this.handler.obtainMessage(1, var1, 0));
   }

   void dispatchIntegrationOperation(String var1, long var2) {
      this.handler.sendMessage(this.handler.obtainMessage(2, new Pair(var1, var2)));
   }

   void performFlush(int var1) {
      this.flushCount++;
      this.flushEventCount += var1;
   }

   void performIntegrationOperation(Pair<String, Long> var1) {
      this.integrationOperationCount++;
      long var2 = this.integrationOperationDuration;
      this.integrationOperationDuration = (Long)var1.second + var2;
      Long var4 = this.integrationOperationDurationByIntegration.get(var1.first);
      if (var4 == null) {
         this.integrationOperationDurationByIntegration.put((String)var1.first, (Long)var1.second);
      } else {
         this.integrationOperationDurationByIntegration.put((String)var1.first, var4 + (Long)var1.second);
      }
   }

   void shutdown() {
      this.statsThread.quit();
   }

   private static class StatsHandler extends Handler {
      static final int TRACK_FLUSH = 1;
      static final int TRACK_INTEGRATION_OPERATION = 2;
      private final Stats stats;

      StatsHandler(Looper var1, Stats var2) {
         super(var1);
         this.stats = var2;
      }

      public void handleMessage(Message var1) {
         switch (var1.what) {
            case 1:
               this.stats.performFlush(var1.arg1);
               break;
            case 2:
               this.stats.performIntegrationOperation((Pair<String, Long>)var1.obj);
               break;
            default:
               throw new AssertionError("Unknown Stats handler message: " + var1);
         }
      }
   }
}
