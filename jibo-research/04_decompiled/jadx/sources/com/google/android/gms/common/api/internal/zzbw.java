package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes.dex */
public final class zzbw<O extends Api.ApiOptions> extends zzak {

    /* JADX INFO: renamed from: a */
    private final GoogleApi<O> f6328a;

    public zzbw(GoogleApi<O> googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f6328a = googleApi;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: a */
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T mo6889a(T t) {
        return (T) this.f6328a.m6876a(t);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: a */
    public final void mo6892a(zzdg zzdgVar) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: b */
    public final Context mo6895b() {
        return this.f6328a.m6883f();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: b */
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T mo6896b(T t) {
        return (T) this.f6328a.m6878b(t);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: b */
    public final void mo6898b(zzdg zzdgVar) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: c */
    public final Looper mo6899c() {
        return this.f6328a.m6882e();
    }
}
