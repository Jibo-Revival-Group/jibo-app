package com.amazonaws.util;

import com.amazonaws.metrics.MetricType;
import com.amazonaws.metrics.RequestMetricType;

@Deprecated
public class AWSRequestMetrics {
   protected final TimingInfo timingInfo;

   public AWSRequestMetrics() {
      this.timingInfo = TimingInfo.startTiming();
   }

   protected AWSRequestMetrics(TimingInfo var1) {
      this.timingInfo = var1;
   }

   public void addProperty(MetricType var1, Object var2) {
   }

   public void addProperty(String var1, Object var2) {
   }

   public void endEvent(MetricType var1) {
   }

   public void endEvent(String var1) {
   }

   public final TimingInfo getTimingInfo() {
      return this.timingInfo;
   }

   public void incrementCounter(MetricType var1) {
   }

   public void incrementCounter(String var1) {
   }

   public void log() {
   }

   public void setCounter(MetricType var1, long var2) {
   }

   public void setCounter(String var1, long var2) {
   }

   public void startEvent(MetricType var1) {
   }

   public void startEvent(String var1) {
   }

   public enum Field implements RequestMetricType {
      AWSErrorCode,
      AWSRequestID,
      BytesProcessed,
      ClientExecuteTime,
      CredentialsRequestTime,
      Exception,
      HttpClientPoolAvailableCount,
      HttpClientPoolLeasedCount,
      HttpClientPoolPendingCount,
      HttpClientReceiveResponseTime,
      HttpClientRetryCount,
      HttpClientSendRequestTime,
      HttpRequestTime,
      RedirectLocation,
      RequestCount,
      RequestMarshallTime,
      RequestSigningTime,
      ResponseProcessingTime,
      RetryCount,
      RetryPauseTime,
      ServiceEndpoint,
      ServiceName,
      StatusCode;

      private static final AWSRequestMetrics.Field[] $VALUES = new AWSRequestMetrics.Field[]{
         AWSRequestMetrics.Field.AWSErrorCode,
         AWSRequestMetrics.Field.AWSRequestID,
         AWSRequestMetrics.Field.BytesProcessed,
         AWSRequestMetrics.Field.ClientExecuteTime,
         AWSRequestMetrics.Field.CredentialsRequestTime,
         AWSRequestMetrics.Field.Exception,
         AWSRequestMetrics.Field.HttpRequestTime,
         AWSRequestMetrics.Field.RedirectLocation,
         AWSRequestMetrics.Field.RequestMarshallTime,
         AWSRequestMetrics.Field.RequestSigningTime,
         AWSRequestMetrics.Field.ResponseProcessingTime,
         AWSRequestMetrics.Field.RequestCount,
         AWSRequestMetrics.Field.RetryCount,
         AWSRequestMetrics.Field.HttpClientRetryCount,
         AWSRequestMetrics.Field.HttpClientSendRequestTime,
         AWSRequestMetrics.Field.HttpClientReceiveResponseTime,
         AWSRequestMetrics.Field.HttpClientPoolAvailableCount,
         AWSRequestMetrics.Field.HttpClientPoolLeasedCount,
         AWSRequestMetrics.Field.HttpClientPoolPendingCount,
         AWSRequestMetrics.Field.RetryPauseTime,
         AWSRequestMetrics.Field.ServiceEndpoint,
         AWSRequestMetrics.Field.ServiceName,
         AWSRequestMetrics.Field.StatusCode
      };
   }
}
