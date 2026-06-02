package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpCall;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpClientBuilder;
import com.salesforce.android.service.common.http.HttpRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceOkHttpClient implements HttpClient {

    /* JADX INFO: renamed from: a */
    protected final OkHttpClient f13471a;

    /* JADX INFO: renamed from: a */
    public static HttpClient m13785a(OkHttpClient okHttpClient) {
        return new SalesforceOkHttpClient(okHttpClient);
    }

    /* JADX INFO: renamed from: b */
    public static HttpClientBuilder m13786b() {
        return new Builder();
    }

    SalesforceOkHttpClient(OkHttpClient okHttpClient) {
        this.f13471a = okHttpClient;
    }

    @Override // com.salesforce.android.service.common.http.HttpClient
    /* JADX INFO: renamed from: a */
    public HttpCall mo13745a(HttpRequest httpRequest) {
        return SalesforceHttpCall.m13783a(this.f13471a.mo15540a(httpRequest.mo13764b()));
    }

    @Override // com.salesforce.android.service.common.http.HttpClient
    /* JADX INFO: renamed from: a */
    public HttpClientBuilder mo13746a() {
        return new Builder(this);
    }

    public static class Builder implements HttpClientBuilder {

        /* JADX INFO: renamed from: a */
        protected final OkHttpClient.Builder f13472a;

        public Builder() {
            this.f13472a = new OkHttpClient.Builder();
        }

        protected Builder(SalesforceOkHttpClient salesforceOkHttpClient) {
            this.f13472a = salesforceOkHttpClient.f13471a.m15731y();
        }

        @Override // com.salesforce.android.service.common.http.HttpClientBuilder
        /* JADX INFO: renamed from: a */
        public HttpClientBuilder mo13752a(Interceptor interceptor) {
            this.f13472a.m15751a(interceptor);
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpClientBuilder
        /* JADX INFO: renamed from: a */
        public HttpClientBuilder mo13748a(long j, TimeUnit timeUnit) {
            this.f13472a.m15743a(j, timeUnit);
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpClientBuilder
        /* JADX INFO: renamed from: b */
        public HttpClientBuilder mo13753b(long j, TimeUnit timeUnit) {
            this.f13472a.m15753b(j, timeUnit);
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpClientBuilder
        /* JADX INFO: renamed from: a */
        public HttpClientBuilder mo13751a(Cache cache) {
            this.f13472a.m15749a(cache);
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpClientBuilder
        /* JADX INFO: renamed from: a */
        public HttpClientBuilder mo13750a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            this.f13472a.m15747a(sSLSocketFactory, x509TrustManager);
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpClientBuilder
        /* JADX INFO: renamed from: a */
        public HttpClientBuilder mo13749a(List<ConnectionSpec> list) {
            this.f13472a.m15745a(list);
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpClientBuilder
        /* JADX INFO: renamed from: b */
        public HttpClientBuilder mo13754b(Interceptor interceptor) {
            this.f13472a.m15754b(interceptor);
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpClientBuilder
        /* JADX INFO: renamed from: a */
        public HttpClient mo13747a() {
            return new SalesforceOkHttpClient(this.f13472a.m15752a());
        }
    }
}
