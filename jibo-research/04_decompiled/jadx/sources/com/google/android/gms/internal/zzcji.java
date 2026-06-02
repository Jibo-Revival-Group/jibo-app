package com.google.android.gms.internal;

import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes.dex */
final class zzcji implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgi f7434a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcir f7435b;

    zzcji(zzcir zzcirVar, zzcgi zzcgiVar) {
        this.f7435b = zzcirVar;
        this.f7434a = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws PackageManager.NameNotFoundException {
        this.f7435b.f7384a.m8209G();
        this.f7435b.f7384a.m8230c(this.f7434a);
    }
}
