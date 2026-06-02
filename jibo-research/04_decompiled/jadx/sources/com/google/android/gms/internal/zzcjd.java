package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcjd implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcha f7420a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7421b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcir f7422c;

    zzcjd(zzcir zzcirVar, zzcha zzchaVar, String str) {
        this.f7422c = zzcirVar;
        this.f7420a = zzchaVar;
        this.f7421b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7422c.f7384a.m8209G();
        this.f7422c.f7384a.m8217a(this.f7420a, this.f7421b);
    }
}
