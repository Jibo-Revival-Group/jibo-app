package com.google.android.gms.internal;

import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes.dex */
final class zzcjb implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgi f7415a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcir f7416b;

    zzcjb(zzcir zzcirVar, zzcgi zzcgiVar) {
        this.f7416b = zzcirVar;
        this.f7415a = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws PackageManager.NameNotFoundException {
        this.f7416b.f7384a.m8209G();
        this.f7416b.f7384a.m8213a(this.f7415a);
    }
}
