package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzcjs implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AtomicReference f7460a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7461b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f7462c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ String f7463d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ boolean f7464e;

    /* JADX INFO: renamed from: f */
    private /* synthetic */ zzcjn f7465f;

    zzcjs(zzcjn zzcjnVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f7465f = zzcjnVar;
        this.f7460a = atomicReference;
        this.f7461b = str;
        this.f7462c = str2;
        this.f7463d = str3;
        this.f7464e = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7465f.f7441p.m8250w().m8345a(this.f7460a, this.f7461b, this.f7462c, this.f7463d, this.f7464e);
    }
}
