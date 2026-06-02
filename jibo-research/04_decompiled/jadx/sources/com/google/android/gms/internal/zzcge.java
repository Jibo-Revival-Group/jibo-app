package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcge implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f7052a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ long f7053b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcgd f7054c;

    zzcge(zzcgd zzcgdVar, String str, long j) {
        this.f7054c = zzcgdVar;
        this.f7052a = str;
        this.f7053b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7054c.m7845a(this.f7052a, this.f7053b);
    }
}
