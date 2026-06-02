package com.salesforce.android.cases.core.internal.http;

import java.io.IOException;
import java.util.Locale;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
public class ServiceCaseInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a */
    private final long f12315a;

    ServiceCaseInterceptor(long j) {
        this.f12315a = j;
    }

    @Override // okhttp3.Interceptor
    /* JADX INFO: renamed from: a */
    public Response mo12243a(Interceptor.Chain chain) throws IOException {
        Request requestMo15692a = chain.mo15692a();
        if (requestMo15692a.m15764a("force_caching") == null) {
            return chain.mo15693a(requestMo15692a);
        }
        return chain.mo15693a(requestMo15692a).m15799i().m15809a(HttpHeaders.CACHE_CONTROL, String.format(Locale.getDefault(), "max-age=%d, only-if-cached, max-stale=0", Long.valueOf(this.f12315a))).m15816a();
    }
}
