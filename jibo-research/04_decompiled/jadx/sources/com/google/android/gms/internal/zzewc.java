package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzewc implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzewv f7864a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ int f7865b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzevz f7866c;

    zzewc(zzevz zzevzVar, zzewv zzewvVar, int i) {
        this.f7866c = zzevzVar;
        this.f7864a = zzewvVar;
        this.f7865b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7866c.m8568b(this.f7864a, this.f7865b);
    }
}
