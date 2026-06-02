package com.salesforce.android.service.common.http.okhttp;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.salesforce.android.service.common.http.HttpCall;
import com.salesforce.android.service.common.http.HttpResponse;
import java.io.IOException;
import okhttp3.Call;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceHttpCall implements HttpCall {

    /* JADX INFO: renamed from: a */
    private final Call f13469a;

    /* JADX INFO: renamed from: a */
    public static HttpCall m13783a(Call call) {
        return new SalesforceHttpCall(call);
    }

    SalesforceHttpCall(Call call) {
        this.f13469a = call;
    }

    @Override // com.salesforce.android.service.common.http.HttpCall
    /* JADX INFO: renamed from: a */
    public HttpResponse mo13744a() throws IOException {
        return SalesforceOkHttpResponse.m13789a(FirebasePerfOkHttpClient.execute(this.f13469a));
    }
}
