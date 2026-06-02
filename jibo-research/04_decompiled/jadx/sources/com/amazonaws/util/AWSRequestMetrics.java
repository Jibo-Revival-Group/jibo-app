package com.amazonaws.util;

import com.amazonaws.metrics.MetricType;
import com.amazonaws.metrics.RequestMetricType;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class AWSRequestMetrics {
    protected final TimingInfo timingInfo;

    public enum Field implements RequestMetricType {
        AWSErrorCode,
        AWSRequestID,
        BytesProcessed,
        ClientExecuteTime,
        CredentialsRequestTime,
        Exception,
        HttpRequestTime,
        RedirectLocation,
        RequestMarshallTime,
        RequestSigningTime,
        ResponseProcessingTime,
        RequestCount,
        RetryCount,
        HttpClientRetryCount,
        HttpClientSendRequestTime,
        HttpClientReceiveResponseTime,
        HttpClientPoolAvailableCount,
        HttpClientPoolLeasedCount,
        HttpClientPoolPendingCount,
        RetryPauseTime,
        ServiceEndpoint,
        ServiceName,
        StatusCode
    }

    public AWSRequestMetrics() {
        this.timingInfo = TimingInfo.startTiming();
    }

    protected AWSRequestMetrics(TimingInfo timingInfo) {
        this.timingInfo = timingInfo;
    }

    public void addProperty(MetricType metricType, Object obj) {
    }

    public void addProperty(String str, Object obj) {
    }

    public void endEvent(MetricType metricType) {
    }

    public void endEvent(String str) {
    }

    public final TimingInfo getTimingInfo() {
        return this.timingInfo;
    }

    public void incrementCounter(MetricType metricType) {
    }

    public void incrementCounter(String str) {
    }

    public void log() {
    }

    public void setCounter(MetricType metricType, long j) {
    }

    public void setCounter(String str, long j) {
    }

    public void startEvent(MetricType metricType) {
    }

    public void startEvent(String str) {
    }
}
