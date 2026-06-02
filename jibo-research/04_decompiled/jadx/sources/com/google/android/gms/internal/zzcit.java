package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcit implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgl f7389a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcgi f7390b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcir f7391c;

    zzcit(zzcir zzcirVar, zzcgl zzcglVar, zzcgi zzcgiVar) {
        this.f7391c = zzcirVar;
        this.f7389a = zzcglVar;
        this.f7390b = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7391c.f7384a.m8209G();
        this.f7391c.f7384a.m8225b(this.f7389a, this.f7390b);
    }
}
