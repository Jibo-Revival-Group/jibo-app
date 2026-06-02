package com.amazonaws.internal.config;

/* JADX INFO: loaded from: classes.dex */
public class HttpClientConfig {
    private final String serviceName;

    HttpClientConfig(String str) {
        this.serviceName = str;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String toString() {
        return "serviceName: " + this.serviceName;
    }
}
