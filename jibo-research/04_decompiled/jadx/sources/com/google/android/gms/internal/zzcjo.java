package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcjo implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ boolean f7449a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcjn f7450b;

    zzcjo(zzcjn zzcjnVar, boolean z) {
        this.f7450b = zzcjnVar;
        this.f7449a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7450b.m8276c(this.f7449a);
    }
}
