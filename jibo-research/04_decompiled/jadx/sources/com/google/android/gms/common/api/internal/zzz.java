package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;

/* JADX INFO: loaded from: classes.dex */
public final class zzz<O extends Api.ApiOptions> extends GoogleApi<O> {

    /* JADX INFO: renamed from: b */
    private final Api.zze f6451b;

    /* JADX INFO: renamed from: c */
    private final zzt f6452c;

    /* JADX INFO: renamed from: d */
    private final com.google.android.gms.common.internal.zzr f6453d;

    /* JADX INFO: renamed from: e */
    private final Api.zza<? extends zzcxd, zzcxe> f6454e;

    public zzz(Context context, Api<O> api, Looper looper, Api.zze zzeVar, zzt zztVar, com.google.android.gms.common.internal.zzr zzrVar, Api.zza<? extends zzcxd, zzcxe> zzaVar) {
        super(context, api, looper);
        this.f6451b = zzeVar;
        this.f6452c = zztVar;
        this.f6453d = zzrVar;
        this.f6454e = zzaVar;
        this.f6093a.m7109a(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    /* JADX INFO: renamed from: a */
    public final Api.zze mo6873a(Looper looper, zzbo<O> zzboVar) {
        this.f6452c.m7234a(zzboVar);
        return this.f6451b;
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    /* JADX INFO: renamed from: a */
    public final zzcv mo6875a(Context context, Handler handler) {
        return new zzcv(context, handler, this.f6453d, this.f6454e);
    }

    /* JADX INFO: renamed from: g */
    public final Api.zze m7257g() {
        return this.f6451b;
    }
}
