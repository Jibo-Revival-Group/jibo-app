package com.amazonaws.util;

import com.amazonaws.metrics.ServiceMetricType;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public enum AWSServiceMetrics implements ServiceMetricType {
    HttpClientGetConnectionTime("HttpClient");

    private final String serviceName;

    AWSServiceMetrics(String str) {
        this.serviceName = str;
    }
}
