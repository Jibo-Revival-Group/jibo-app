package com.amazonaws.metrics;

public abstract class MetricCollector {
   public static final MetricCollector NONE = new MetricCollector() {
      @Override
      public RequestMetricCollector getRequestMetricCollector() {
         return RequestMetricCollector.NONE;
      }

      @Override
      public boolean isEnabled() {
         return false;
      }

      @Override
      public boolean stop() {
         return true;
      }
   };

   public abstract RequestMetricCollector getRequestMetricCollector();

   public abstract boolean isEnabled();

   public abstract boolean stop();

   public interface Factory {
      MetricCollector getInstance();
   }
}
