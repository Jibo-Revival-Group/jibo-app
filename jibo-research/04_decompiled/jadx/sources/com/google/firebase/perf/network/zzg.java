package com.google.firebase.perf.network;

import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzevz;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public final class zzg implements Callback {

    /* JADX INFO: renamed from: a */
    private final Callback f8776a;

    /* JADX INFO: renamed from: b */
    private final zzevv f8777b;

    /* JADX INFO: renamed from: c */
    private final long f8778c;

    /* JADX INFO: renamed from: d */
    private final zzewn f8779d;

    public zzg(Callback callback, zzevz zzevzVar, zzewn zzewnVar, long j) {
        this.f8776a = callback;
        this.f8777b = zzevv.m8529a(zzevzVar);
        this.f8778c = j;
        this.f8779d = zzewnVar;
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call call, IOException iOException) {
        Request requestMo15535a = call.mo15535a();
        if (requestMo15535a != null) {
            HttpUrl httpUrlM15765a = requestMo15535a.m15765a();
            if (httpUrlM15765a != null) {
                this.f8777b.m8532a(httpUrlM15765a.m15646a().toString());
            }
            if (requestMo15535a.m15766b() != null) {
                this.f8777b.m8536b(requestMo15535a.m15766b());
            }
        }
        this.f8777b.m8538c(this.f8778c);
        this.f8777b.m8543f(this.f8779d.m8602c());
        zzh.m9330a(this.f8777b);
        this.f8776a.onFailure(call, iOException);
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call call, Response response) throws IOException {
        FirebasePerfOkHttpClient.m9270a(response, this.f8777b, this.f8778c, this.f8779d.m8602c());
        this.f8776a.onResponse(call, response);
    }
}
