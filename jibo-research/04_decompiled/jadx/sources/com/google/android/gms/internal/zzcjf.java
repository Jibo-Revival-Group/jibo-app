package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcjf implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcln f7426a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcgi f7427b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcir f7428c;

    zzcjf(zzcir zzcirVar, zzcln zzclnVar, zzcgi zzcgiVar) {
        this.f7428c = zzcirVar;
        this.f7426a = zzclnVar;
        this.f7427b = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7428c.f7384a.m8209G();
        this.f7428c.f7384a.m8226b(this.f7426a, this.f7427b);
    }
}
