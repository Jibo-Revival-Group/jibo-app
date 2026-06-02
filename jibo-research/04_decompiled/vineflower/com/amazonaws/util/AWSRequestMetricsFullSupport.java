package com.amazonaws.util;

import com.amazonaws.metrics.MetricType;
import com.jibo.aws.integration.util.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public class AWSRequestMetricsFullSupport extends AWSRequestMetrics {
   private static final Object COMMA_SEPARATOR = ", ";
   private static final Object KEY_VALUE_SEPARATOR = "=";
   public static final String TAG = a.a(AWSRequestMetricsFullSupport.class);
   private final Map<String, TimingInfo> eventsBeingProfiled;
   private final Map<String, List<Object>> properties = new HashMap<>();

   public AWSRequestMetricsFullSupport() {
      super(TimingInfo.startTimingFullSupport());
      this.eventsBeingProfiled = new HashMap<>();
   }

   private void keyValueFormat(Object var1, Object var2, StringBuilder var3) {
      var3.append(var1).append(KEY_VALUE_SEPARATOR).append(var2).append(COMMA_SEPARATOR);
   }

   @Override
   public void addProperty(MetricType var1, Object var2) {
      this.addProperty(var1.name(), var2);
   }

   @Override
   public void addProperty(String var1, Object var2) {
      List var4 = this.properties.get(var1);
      List var3 = var4;
      if (var4 == null) {
         var3 = new ArrayList();
         this.properties.put(var1, var3);
      }

      var3.add(var2);
   }

   @Override
   public void endEvent(MetricType var1) {
      this.endEvent(var1.name());
   }

   @Override
   public void endEvent(String var1) {
      TimingInfo var2 = this.eventsBeingProfiled.get(var1);
      if (var2 == null) {
         a.c(TAG, "Trying to end an event which was never started: " + var1);
      } else {
         var2.endTiming();
         this.timingInfo.addSubMeasurement(var1, TimingInfo.unmodifiableTimingInfo(var2.getStartTimeNano(), var2.getEndTimeNano()));
      }
   }

   @Override
   public void incrementCounter(MetricType var1) {
      this.incrementCounter(var1.name());
   }

   @Override
   public void incrementCounter(String var1) {
      this.timingInfo.incrementCounter(var1);
   }

   @Override
   public void log() {
      StringBuilder var1 = new StringBuilder();

      for (Entry var2 : this.properties.entrySet()) {
         this.keyValueFormat(var2.getKey(), var2.getValue(), var1);
      }

      for (Entry var6 : this.timingInfo.getAllCounters().entrySet()) {
         this.keyValueFormat(var6.getKey(), var6.getValue(), var1);
      }

      for (Entry var5 : this.timingInfo.getSubMeasurementsByName().entrySet()) {
         this.keyValueFormat(var5.getKey(), var5.getValue(), var1);
      }

      a.b(TAG, var1.toString());
   }

   @Override
   public void setCounter(MetricType var1, long var2) {
      this.setCounter(var1.name(), var2);
   }

   @Override
   public void setCounter(String var1, long var2) {
      this.timingInfo.setCounter(var1, var2);
   }

   @Override
   public void startEvent(MetricType var1) {
      this.startEvent(var1.name());
   }

   @Override
   public void startEvent(String var1) {
      this.eventsBeingProfiled.put(var1, TimingInfo.startTimingFullSupport(System.nanoTime()));
   }
}
