package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcld implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcim f7580a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ Runnable f7581b;

    zzcld(zzcla zzclaVar, zzcim zzcimVar, Runnable runnable) {
        this.f7580a = zzcimVar;
        this.f7581b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7580a.m8209G();
        this.f7580a.m8220a(this.f7581b);
        this.f7580a.m8207E();
    }
}
