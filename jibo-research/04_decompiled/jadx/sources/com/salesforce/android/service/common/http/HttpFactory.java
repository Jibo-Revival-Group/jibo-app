package com.salesforce.android.service.common.http;

import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpClient;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpRequest;

/* JADX INFO: loaded from: classes.dex */
public class HttpFactory {
    /* JADX INFO: renamed from: a */
    public static HttpClientBuilder m13755a() {
        return SalesforceOkHttpClient.m13786b();
    }

    /* JADX INFO: renamed from: b */
    public static HttpRequestBuilder m13756b() {
        return SalesforceOkHttpRequest.m13788c();
    }
}
