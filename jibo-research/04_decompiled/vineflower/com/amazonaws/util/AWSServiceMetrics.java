package com.amazonaws.util;

import com.amazonaws.metrics.ServiceMetricType;

@Deprecated
public enum AWSServiceMetrics implements ServiceMetricType {
   HttpClientGetConnectionTime("HttpClient");

   private static final AWSServiceMetrics[] $VALUES = new AWSServiceMetrics[]{AWSServiceMetrics.HttpClientGetConnectionTime};
   private final String serviceName;

   AWSServiceMetrics(String var3) {
      this.serviceName = var3;
   }
}
