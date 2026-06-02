package com.google.maps.internal;

import com.google.api.client.http.HttpMethods;
import com.google.gson.FieldNamingPolicy;

/* JADX INFO: loaded from: classes.dex */
public class ApiConfig {
    public String path;
    public FieldNamingPolicy fieldNamingPolicy = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
    public String hostName = "https://maps.googleapis.com";
    public boolean supportsClientId = true;
    public String requestVerb = HttpMethods.GET;

    public ApiConfig(String str) {
        this.path = str;
    }

    public ApiConfig fieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        this.fieldNamingPolicy = fieldNamingPolicy;
        return this;
    }

    public ApiConfig hostName(String str) {
        this.hostName = str;
        return this;
    }

    public ApiConfig supportsClientId(boolean z) {
        this.supportsClientId = z;
        return this;
    }

    public ApiConfig requestVerb(String str) {
        this.requestVerb = str;
        return this;
    }
}
