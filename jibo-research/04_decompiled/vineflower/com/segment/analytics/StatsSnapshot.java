package com.segment.analytics;

import java.util.Map;

public class StatsSnapshot {
   public final long flushCount;
   public final long flushEventCount;
   public final float integrationOperationAverageDuration;
   public final long integrationOperationCount;
   public final long integrationOperationDuration;
   public final Map<String, Long> integrationOperationDurationByIntegration;
   public final long timestamp;

   public StatsSnapshot(long var1, long var3, long var5, long var7, long var9, Map<String, Long> var11) {
      this.timestamp = var1;
      this.flushCount = var3;
      this.flushEventCount = var5;
      this.integrationOperationCount = var7;
      this.integrationOperationDuration = var9;
      float var12;
      if (var7 == 0L) {
         var12 = 0.0F;
      } else {
         var12 = (float)var9 / (float)var7;
      }

      this.integrationOperationAverageDuration = var12;
      this.integrationOperationDurationByIntegration = var11;
   }

   @Override
   public String toString() {
      return "StatsSnapshot{timestamp="
         + this.timestamp
         + ", flushCount="
         + this.flushCount
         + ", flushEventCount="
         + this.flushEventCount
         + ", integrationOperationCount="
         + this.integrationOperationCount
         + ", integrationOperationDuration="
         + this.integrationOperationDuration
         + ", integrationOperationAverageDuration="
         + this.integrationOperationAverageDuration
         + ", integrationOperationDurationByIntegration="
         + this.integrationOperationDurationByIntegration
         + '}';
   }
}
