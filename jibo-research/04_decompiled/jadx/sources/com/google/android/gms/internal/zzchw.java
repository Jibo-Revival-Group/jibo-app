package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzchw implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ boolean f7254a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzchv f7255b;

    zzchw(zzchv zzchvVar, boolean z) {
        this.f7255b = zzchvVar;
        this.f7254a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7255b.f7251b.m8222a(this.f7254a);
    }
}
