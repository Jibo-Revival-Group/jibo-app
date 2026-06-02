package com.amazonaws.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TimingInfo {
   private Long endTimeNano;
   private final Long startEpochTimeMilli;
   private final long startTimeNano;

   protected TimingInfo(Long var1, long var2, Long var4) {
      this.startEpochTimeMilli = var1;
      this.startTimeNano = var2;
      this.endTimeNano = var4;
   }

   public static double durationMilliOf(long var0, long var2) {
      return TimeUnit.NANOSECONDS.toMicros(var2 - var0) / 1000.0;
   }

   public static TimingInfo startTiming() {
      return new TimingInfo(System.currentTimeMillis(), System.nanoTime(), null);
   }

   public static TimingInfo startTimingFullSupport() {
      return new TimingInfoFullSupport(System.currentTimeMillis(), System.nanoTime(), null);
   }

   public static TimingInfo startTimingFullSupport(long var0) {
      return new TimingInfoFullSupport(null, var0, null);
   }

   public static TimingInfo unmodifiableTimingInfo(long var0, Long var2) {
      return new TimingInfoUnmodifiable(null, var0, var2);
   }

   public void addSubMeasurement(String var1, TimingInfo var2) {
   }

   public TimingInfo endTiming() {
      this.endTimeNano = System.nanoTime();
      return this;
   }

   public Map<String, Number> getAllCounters() {
      return Collections.emptyMap();
   }

   public Number getCounter(String var1) {
      return null;
   }

   public final long getEndTimeNano() {
      long var1;
      if (this.endTimeNano == null) {
         var1 = -1L;
      } else {
         var1 = this.endTimeNano;
      }

      return var1;
   }

   public final long getStartTimeNano() {
      return this.startTimeNano;
   }

   public Map<String, List<TimingInfo>> getSubMeasurementsByName() {
      return Collections.emptyMap();
   }

   @Deprecated
   public final double getTimeTakenMillis() {
      Double var3 = this.getTimeTakenMillisIfKnown();
      double var1;
      if (var3 == null) {
         var1 = -1.0;
      } else {
         var1 = var3;
      }

      return var1;
   }

   public final Double getTimeTakenMillisIfKnown() {
      Double var1;
      if (this.isEndTimeKnown()) {
         var1 = durationMilliOf(this.startTimeNano, this.endTimeNano);
      } else {
         var1 = null;
      }

      return var1;
   }

   public void incrementCounter(String var1) {
   }

   public final boolean isEndTimeKnown() {
      boolean var1;
      if (this.endTimeNano != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void setCounter(String var1, long var2) {
   }

   @Override
   public final String toString() {
      return String.valueOf(this.getTimeTakenMillis());
   }
}
