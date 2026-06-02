package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class zzas extends zzbj {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ConnectionResult f6218a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzar f6219b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzas(zzar zzarVar, zzbh zzbhVar, ConnectionResult connectionResult) {
        super(zzbhVar);
        this.f6219b = zzarVar;
        this.f6218a = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.zzbj
    /* JADX INFO: renamed from: a */
    public final void mo7023a() {
        this.f6219b.f6216a.m7033b(this.f6218a);
    }
}
