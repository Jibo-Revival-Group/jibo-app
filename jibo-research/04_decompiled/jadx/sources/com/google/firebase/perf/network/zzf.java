package com.google.firebase.perf.network;

import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* JADX INFO: loaded from: classes.dex */
public final class zzf<T> implements ResponseHandler<T> {

    /* JADX INFO: renamed from: a */
    private final ResponseHandler<? extends T> f8773a;

    /* JADX INFO: renamed from: b */
    private final zzewn f8774b;

    /* JADX INFO: renamed from: c */
    private final zzevv f8775c;

    public zzf(ResponseHandler<? extends T> responseHandler, zzewn zzewnVar, zzevv zzevvVar) {
        this.f8773a = responseHandler;
        this.f8774b = zzewnVar;
        this.f8775c = zzevvVar;
    }

    @Override // org.apache.http.client.ResponseHandler
    public final T handleResponse(HttpResponse httpResponse) throws IOException {
        this.f8775c.m8543f(this.f8774b.m8602c());
        this.f8775c.m8530a(httpResponse.getStatusLine().getStatusCode());
        Long lM9328a = zzh.m9328a((HttpMessage) httpResponse);
        if (lM9328a != null) {
            this.f8775c.m8535b(lM9328a.longValue());
        }
        String strM9329a = zzh.m9329a(httpResponse);
        if (strM9329a != null) {
            this.f8775c.m8539c(strM9329a);
        }
        this.f8775c.m8541d();
        return this.f8773a.handleResponse(httpResponse);
    }
}
