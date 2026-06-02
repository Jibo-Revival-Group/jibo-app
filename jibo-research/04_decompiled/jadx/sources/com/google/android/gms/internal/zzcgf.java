package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcgf implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f7055a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ long f7056b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcgd f7057c;

    zzcgf(zzcgd zzcgdVar, String str, long j) {
        this.f7057c = zzcgdVar;
        this.f7055a = str;
        this.f7056b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7057c.m7849b(this.f7055a, this.f7056b);
    }
}
