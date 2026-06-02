package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zzcz;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzd {

    /* JADX INFO: renamed from: a */
    private zzcz f6455a;

    /* JADX INFO: renamed from: b */
    private Looper f6456b;

    /* JADX INFO: renamed from: a */
    public final GoogleApi.zza m7258a() {
        if (this.f6455a == null) {
            this.f6455a = new com.google.android.gms.common.api.internal.zzg();
        }
        if (this.f6456b == null) {
            this.f6456b = Looper.getMainLooper();
        }
        return new GoogleApi.zza(this.f6455a, this.f6456b);
    }

    /* JADX INFO: renamed from: a */
    public final zzd m7259a(zzcz zzczVar) {
        zzbq.m7374a(zzczVar, "StatusExceptionMapper must not be null.");
        this.f6455a = zzczVar;
        return this;
    }
}
