package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpResponse;
import com.salesforce.android.service.common.http.HttpResponseBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceOkHttpResponse implements HttpResponse {

    /* JADX INFO: renamed from: a */
    private final Response f13475a;

    /* JADX INFO: renamed from: a */
    public static HttpResponse m13789a(Response response) {
        return new SalesforceOkHttpResponse(response);
    }

    SalesforceOkHttpResponse(Response response) {
        this.f13475a = response;
    }

    @Override // com.salesforce.android.service.common.http.HttpResponse
    /* JADX INFO: renamed from: c */
    public HttpResponseBody mo13774c() {
        return SalesforceOkHttpResponseBody.m13790a(this.f13475a.m15798h());
    }

    @Override // com.salesforce.android.service.common.http.HttpResponse
    /* JADX INFO: renamed from: a */
    public int mo13772a() {
        return this.f13475a.m15793c();
    }

    @Override // com.salesforce.android.service.common.http.HttpResponse
    /* JADX INFO: renamed from: b */
    public boolean mo13773b() {
        return this.f13475a.m15794d();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f13475a.close();
    }

    public String toString() {
        return this.f13475a.toString();
    }
}
