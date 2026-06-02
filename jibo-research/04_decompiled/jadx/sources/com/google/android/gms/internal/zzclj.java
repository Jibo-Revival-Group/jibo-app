package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzclj implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ long f7590a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzclf f7591b;

    zzclj(zzclf zzclfVar, long j) {
        this.f7591b = zzclfVar;
        this.f7590a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7591b.m8370b(this.f7590a);
    }
}
