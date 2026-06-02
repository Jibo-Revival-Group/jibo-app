package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.HttpRequestBuilder;
import com.salesforce.android.service.common.http.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceOkHttpRequest implements HttpRequest {

    /* JADX INFO: renamed from: a */
    protected Request f13473a;

    /* JADX INFO: renamed from: c */
    public static HttpRequestBuilder m13788c() {
        return new Builder();
    }

    /* JADX INFO: renamed from: a */
    public static HttpRequest m13787a(Request request) {
        return new SalesforceOkHttpRequest(request);
    }

    SalesforceOkHttpRequest(Request request) {
        this.f13473a = request;
    }

    SalesforceOkHttpRequest(Builder builder) {
        this.f13473a = builder.f13474a.m15784c();
    }

    @Override // com.salesforce.android.service.common.http.HttpRequest
    /* JADX INFO: renamed from: a */
    public HttpUrl mo13763a() {
        return SalesforceHttpUrl.m13784a(this.f13473a.m15765a());
    }

    @Override // com.salesforce.android.service.common.http.HttpRequest
    /* JADX INFO: renamed from: b */
    public Request mo13764b() {
        return this.f13473a;
    }

    public String toString() {
        return this.f13473a.toString();
    }

    public static class Builder implements HttpRequestBuilder {

        /* JADX INFO: renamed from: a */
        protected final Request.Builder f13474a = new Request.Builder();

        @Override // com.salesforce.android.service.common.http.HttpRequestBuilder
        /* JADX INFO: renamed from: a */
        public HttpRequestBuilder mo13767a(String str, String str2) {
            this.f13474a.m15782b(str, str2);
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpRequestBuilder
        /* JADX INFO: renamed from: a */
        public HttpRequestBuilder mo13768a(okhttp3.HttpUrl httpUrl) {
            this.f13474a.m15778a(httpUrl);
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpRequestBuilder
        /* JADX INFO: renamed from: a */
        public HttpRequestBuilder mo13766a(String str) {
            this.f13474a.m15774a(str);
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpRequestBuilder
        /* JADX INFO: renamed from: a */
        public HttpRequestBuilder mo13765a() {
            this.f13474a.m15773a();
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpRequestBuilder
        /* JADX INFO: renamed from: a */
        public HttpRequestBuilder mo13769a(RequestBody requestBody) {
            this.f13474a.m15779a(requestBody);
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpRequestBuilder
        /* JADX INFO: renamed from: b */
        public HttpRequestBuilder mo13770b() {
            this.f13474a.m15780b();
            return this;
        }

        @Override // com.salesforce.android.service.common.http.HttpRequestBuilder
        /* JADX INFO: renamed from: c */
        public HttpRequest mo13771c() {
            return new SalesforceOkHttpRequest(this);
        }
    }
}
