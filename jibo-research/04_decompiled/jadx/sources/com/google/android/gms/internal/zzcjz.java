package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzcjz implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AtomicReference f7488a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcjn f7489b;

    zzcjz(zzcjn zzcjnVar, AtomicReference atomicReference) {
        this.f7489b = zzcjnVar;
        this.f7488a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7489b.mo7861i().m8343a(this.f7488a);
    }
}
