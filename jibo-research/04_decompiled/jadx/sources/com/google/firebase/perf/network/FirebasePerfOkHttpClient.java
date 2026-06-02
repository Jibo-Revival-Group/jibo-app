package com.google.firebase.perf.network;

import android.support.annotation.Keep;
import com.google.android.gms.internal.zzevv;
import com.google.android.gms.internal.zzevz;
import com.google.android.gms.internal.zzewn;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes.dex */
public class FirebasePerfOkHttpClient {
    private FirebasePerfOkHttpClient() {
    }

    /* JADX INFO: renamed from: a */
    static void m9270a(Response response, zzevv zzevvVar, long j, long j2) throws IOException {
        Request requestM15791a = response.m15791a();
        if (requestM15791a == null) {
            return;
        }
        zzevvVar.m8532a(requestM15791a.m15765a().m15646a().toString());
        zzevvVar.m8536b(requestM15791a.m15766b());
        if (requestM15791a.m15769d() != null) {
            long jMo14285b = requestM15791a.m15769d().mo14285b();
            if (jMo14285b != -1) {
                zzevvVar.m8531a(jMo14285b);
            }
        }
        ResponseBody responseBodyM15798h = response.m15798h();
        if (responseBodyM15798h != null) {
            long jMo15512b = responseBodyM15798h.mo15512b();
            if (jMo15512b != -1) {
                zzevvVar.m8535b(jMo15512b);
            }
            MediaType mediaTypeMo15511a = responseBodyM15798h.mo15511a();
            if (mediaTypeMo15511a != null) {
                zzevvVar.m8539c(mediaTypeMo15511a.toString());
            }
        }
        zzevvVar.m8530a(response.m15793c());
        zzevvVar.m8538c(j);
        zzevvVar.m8543f(j2);
        zzevvVar.m8541d();
    }

    @Keep
    public static void enqueue(Call call, Callback callback) {
        zzewn zzewnVar = new zzewn();
        call.mo15536a(new zzg(callback, zzevz.m8561a(), zzewnVar, zzewnVar.m8601b()));
    }

    @Keep
    public static Response execute(Call call) throws IOException {
        zzevv zzevvVarM8529a = zzevv.m8529a(zzevz.m8561a());
        zzewn zzewnVar = new zzewn();
        long jM8601b = zzewnVar.m8601b();
        try {
            Response responseMo15537b = call.mo15537b();
            m9270a(responseMo15537b, zzevvVarM8529a, jM8601b, zzewnVar.m8602c());
            return responseMo15537b;
        } catch (IOException e) {
            Request requestMo15535a = call.mo15535a();
            if (requestMo15535a != null) {
                HttpUrl httpUrlM15765a = requestMo15535a.m15765a();
                if (httpUrlM15765a != null) {
                    zzevvVarM8529a.m8532a(httpUrlM15765a.m15646a().toString());
                }
                if (requestMo15535a.m15766b() != null) {
                    zzevvVarM8529a.m8536b(requestMo15535a.m15766b());
                }
            }
            zzevvVarM8529a.m8538c(jM8601b);
            zzevvVarM8529a.m8543f(zzewnVar.m8602c());
            zzh.m9330a(zzevvVarM8529a);
            throw e;
        }
    }
}
