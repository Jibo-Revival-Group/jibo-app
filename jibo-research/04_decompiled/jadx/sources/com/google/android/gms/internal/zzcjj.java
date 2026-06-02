package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
final class zzcjj implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f7436a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7437b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f7438c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ long f7439d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ zzcir f7440e;

    zzcjj(zzcir zzcirVar, String str, String str2, String str3, long j) {
        this.f7440e = zzcirVar;
        this.f7436a = str;
        this.f7437b = str2;
        this.f7438c = str3;
        this.f7439d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f7436a == null) {
            this.f7440e.f7384a.m8249v().m8312a(this.f7437b, (AppMeasurement.zzb) null);
            return;
        }
        AppMeasurement.zzb zzbVar = new AppMeasurement.zzb();
        zzbVar.f8396b = this.f7438c;
        zzbVar.f8397c = this.f7436a;
        zzbVar.f8398d = this.f7439d;
        this.f7440e.f7384a.m8249v().m8312a(this.f7437b, zzbVar);
    }
}
