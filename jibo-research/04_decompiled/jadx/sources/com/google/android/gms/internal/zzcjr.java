package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzcjr implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AtomicReference f7455a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7456b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f7457c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ String f7458d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ zzcjn f7459e;

    zzcjr(zzcjn zzcjnVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f7459e = zzcjnVar;
        this.f7455a = atomicReference;
        this.f7456b = str;
        this.f7457c = str2;
        this.f7458d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7459e.f7441p.m8250w().m8344a(this.f7455a, this.f7456b, this.f7457c, this.f7458d);
    }
}
