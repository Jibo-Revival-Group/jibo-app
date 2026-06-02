package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
final class zzcke implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzckf f7505a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzckc f7506b;

    zzcke(zzckc zzckcVar, zzckf zzckfVar) {
        this.f7506b = zzckcVar;
        this.f7505a = zzckfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7506b.m8306a(this.f7505a);
        this.f7506b.f7492a = null;
        this.f7506b.mo7861i().m8342a((AppMeasurement.zzb) null);
    }
}
