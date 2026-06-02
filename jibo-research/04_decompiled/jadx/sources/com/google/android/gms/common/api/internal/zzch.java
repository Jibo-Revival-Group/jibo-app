package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzch implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ LifecycleCallback f6343a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f6344b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcg f6345c;

    zzch(zzcg zzcgVar, LifecycleCallback lifecycleCallback, String str) {
        this.f6345c = zzcgVar;
        this.f6343a = lifecycleCallback;
        this.f6344b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f6345c.f6341c > 0) {
            this.f6343a.mo6952a(this.f6345c.f6342d != null ? this.f6345c.f6342d.getBundle(this.f6344b) : null);
        }
        if (this.f6345c.f6341c >= 2) {
            this.f6343a.mo6954b();
        }
        if (this.f6345c.f6341c >= 3) {
            this.f6343a.mo6956c();
        }
        if (this.f6345c.f6341c >= 4) {
            this.f6343a.mo6957d();
        }
        if (this.f6345c.f6341c >= 5) {
            this.f6343a.m6958e();
        }
    }
}
