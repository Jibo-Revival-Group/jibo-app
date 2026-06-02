package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcjt implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ long f7466a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcjn f7467b;

    zzcjt(zzcjn zzcjnVar, long j) {
        this.f7467b = zzcjnVar;
        this.f7466a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7467b.mo7873u().f7265j.m8137a(this.f7466a);
        this.f7467b.mo7872t().m8100D().m8109a("Minimum session duration set", Long.valueOf(this.f7466a));
    }
}
