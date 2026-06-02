package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpResponseBody;
import java.io.IOException;
import java.io.Reader;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceOkHttpResponseBody implements HttpResponseBody {

    /* JADX INFO: renamed from: a */
    private final ResponseBody f13476a;

    /* JADX INFO: renamed from: a */
    public static HttpResponseBody m13790a(ResponseBody responseBody) {
        return new SalesforceOkHttpResponseBody(responseBody);
    }

    SalesforceOkHttpResponseBody(ResponseBody responseBody) {
        this.f13476a = responseBody;
    }

    @Override // com.salesforce.android.service.common.http.HttpResponseBody
    /* JADX INFO: renamed from: a */
    public BufferedSource mo13775a() {
        return this.f13476a.mo15513c();
    }

    @Override // com.salesforce.android.service.common.http.HttpResponseBody
    /* JADX INFO: renamed from: b */
    public Reader mo13776b() {
        return this.f13476a.m15825e();
    }

    @Override // com.salesforce.android.service.common.http.HttpResponseBody
    /* JADX INFO: renamed from: c */
    public String mo13777c() throws IOException {
        return this.f13476a.m15826f();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f13476a.close();
    }
}
