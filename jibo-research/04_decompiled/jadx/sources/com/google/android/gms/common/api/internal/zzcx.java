package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzcxq;

/* JADX INFO: loaded from: classes.dex */
final class zzcx implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcxq f6369a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcv f6370b;

    zzcx(zzcv zzcvVar, zzcxq zzcxqVar) {
        this.f6370b = zzcvVar;
        this.f6369a = zzcxqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6370b.m7181b(this.f6369a);
    }
}
