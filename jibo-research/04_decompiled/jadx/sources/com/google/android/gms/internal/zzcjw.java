package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcjw implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f7479a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7480b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ Object f7481c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ long f7482d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ zzcjn f7483e;

    zzcjw(zzcjn zzcjnVar, String str, String str2, Object obj, long j) {
        this.f7483e = zzcjnVar;
        this.f7479a = str;
        this.f7480b = str2;
        this.f7481c = obj;
        this.f7482d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7483e.m8269a(this.f7479a, this.f7480b, this.f7481c, this.f7482d);
    }
}
