package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzciv implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgl f7395a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcir f7396b;

    zzciv(zzcir zzcirVar, zzcgl zzcglVar) {
        this.f7396b = zzcirVar;
        this.f7395a = zzcglVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7396b.f7384a.m8209G();
        this.f7396b.f7384a.m8224b(this.f7395a);
    }
}
