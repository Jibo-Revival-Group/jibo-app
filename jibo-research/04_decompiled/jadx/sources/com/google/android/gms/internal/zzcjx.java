package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzcjx implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AtomicReference f7484a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ boolean f7485b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcjn f7486c;

    zzcjx(zzcjn zzcjnVar, AtomicReference atomicReference, boolean z) {
        this.f7486c = zzcjnVar;
        this.f7484a = atomicReference;
        this.f7485b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7486c.mo7861i().m8346a(this.f7484a, this.f7485b);
    }
}
