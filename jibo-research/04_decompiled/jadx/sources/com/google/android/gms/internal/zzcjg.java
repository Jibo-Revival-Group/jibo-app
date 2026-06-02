package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcjg implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcln f7429a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcgi f7430b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcir f7431c;

    zzcjg(zzcir zzcirVar, zzcln zzclnVar, zzcgi zzcgiVar) {
        this.f7431c = zzcirVar;
        this.f7429a = zzclnVar;
        this.f7430b = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7431c.f7384a.m8209G();
        this.f7431c.f7384a.m8219a(this.f7429a, this.f7430b);
    }
}
