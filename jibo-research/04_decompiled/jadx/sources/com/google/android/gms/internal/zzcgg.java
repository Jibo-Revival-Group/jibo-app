package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcgg implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ long f7058a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcgd f7059b;

    zzcgg(zzcgd zzcgdVar, long j) {
        this.f7059b = zzcgdVar;
        this.f7058a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7059b.m7847b(this.f7058a);
    }
}
