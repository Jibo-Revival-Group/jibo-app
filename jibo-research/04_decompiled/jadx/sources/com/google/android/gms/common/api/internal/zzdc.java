package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzdc implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ LifecycleCallback f6375a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f6376b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzdb f6377c;

    zzdc(zzdb zzdbVar, LifecycleCallback lifecycleCallback, String str) {
        this.f6377c = zzdbVar;
        this.f6375a = lifecycleCallback;
        this.f6376b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f6377c.f6373c > 0) {
            this.f6375a.mo6952a(this.f6377c.f6374d != null ? this.f6377c.f6374d.getBundle(this.f6376b) : null);
        }
        if (this.f6377c.f6373c >= 2) {
            this.f6375a.mo6954b();
        }
        if (this.f6377c.f6373c >= 3) {
            this.f6375a.mo6956c();
        }
        if (this.f6377c.f6373c >= 4) {
            this.f6375a.mo6957d();
        }
        if (this.f6377c.f6373c >= 5) {
            this.f6375a.m6958e();
        }
    }
}
