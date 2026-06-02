package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;

/* JADX INFO: loaded from: classes.dex */
final class zzclk {

    /* JADX INFO: renamed from: a */
    private final zzd f7592a;

    /* JADX INFO: renamed from: b */
    private long f7593b;

    public zzclk(zzd zzdVar) {
        zzbq.m7373a(zzdVar);
        this.f7592a = zzdVar;
    }

    /* JADX INFO: renamed from: a */
    public final void m8375a() {
        this.f7593b = this.f7592a.mo7497b();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m8376a(long j) {
        return this.f7593b == 0 || this.f7592a.mo7497b() - this.f7593b >= 3600000;
    }

    /* JADX INFO: renamed from: b */
    public final void m8377b() {
        this.f7593b = 0L;
    }
}
