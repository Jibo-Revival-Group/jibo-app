package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzewd implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ boolean f7867a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzevz f7868b;

    zzewd(zzevz zzevzVar, boolean z) {
        this.f7868b = zzevzVar;
        this.f7867a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7868b.m8573b(this.f7867a);
    }
}
