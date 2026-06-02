package com.google.android.gms.internal;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
final class zzbhc implements Runnable {

    /* JADX INFO: renamed from: a */
    private final Runnable f6982a;

    /* JADX INFO: renamed from: b */
    private final int f6983b;

    public zzbhc(Runnable runnable, int i) {
        this.f6982a = runnable;
        this.f6983b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f6983b);
        this.f6982a.run();
    }
}
