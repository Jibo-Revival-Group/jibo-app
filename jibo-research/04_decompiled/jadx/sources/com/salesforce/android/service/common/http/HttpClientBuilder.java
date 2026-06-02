package com.salesforce.android.service.common.http;

import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: classes.dex */
public interface HttpClientBuilder {
    /* JADX INFO: renamed from: a */
    HttpClient mo13747a();

    /* JADX INFO: renamed from: a */
    HttpClientBuilder mo13748a(long j, TimeUnit timeUnit);

    /* JADX INFO: renamed from: a */
    HttpClientBuilder mo13749a(List<ConnectionSpec> list);

    /* JADX INFO: renamed from: a */
    HttpClientBuilder mo13750a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager);

    /* JADX INFO: renamed from: a */
    HttpClientBuilder mo13751a(Cache cache);

    /* JADX INFO: renamed from: a */
    HttpClientBuilder mo13752a(Interceptor interceptor);

    /* JADX INFO: renamed from: b */
    HttpClientBuilder mo13753b(long j, TimeUnit timeUnit);

    /* JADX INFO: renamed from: b */
    HttpClientBuilder mo13754b(Interceptor interceptor);
}
