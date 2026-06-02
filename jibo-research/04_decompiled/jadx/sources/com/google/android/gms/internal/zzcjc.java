package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcjc implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcha f7417a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcgi f7418b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcir f7419c;

    zzcjc(zzcir zzcirVar, zzcha zzchaVar, zzcgi zzcgiVar) {
        this.f7419c = zzcirVar;
        this.f7417a = zzchaVar;
        this.f7418b = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7419c.f7384a.m8209G();
        this.f7419c.f7384a.m8216a(this.f7417a, this.f7418b);
    }
}
