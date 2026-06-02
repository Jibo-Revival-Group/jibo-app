package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcju implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ long f7468a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcjn f7469b;

    zzcju(zzcjn zzcjnVar, long j) {
        this.f7469b = zzcjnVar;
        this.f7468a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7469b.mo7873u().f7266k.m8137a(this.f7468a);
        this.f7469b.mo7872t().m8100D().m8109a("Session timeout duration set", Long.valueOf(this.f7468a));
    }
}
