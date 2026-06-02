package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcis implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgi f7387a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcir f7388b;

    zzcis(zzcir zzcirVar, zzcgi zzcgiVar) {
        this.f7388b = zzcirVar;
        this.f7387a = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7388b.f7384a.m8209G();
        this.f7388b.f7384a.m8223b(this.f7387a);
    }
}
