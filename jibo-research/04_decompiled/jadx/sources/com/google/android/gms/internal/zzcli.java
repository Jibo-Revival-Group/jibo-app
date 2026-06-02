package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcli implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ long f7588a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzclf f7589b;

    zzcli(zzclf zzclfVar, long j) {
        this.f7589b = zzclfVar;
        this.f7588a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7589b.m8367a(this.f7588a);
    }
}
