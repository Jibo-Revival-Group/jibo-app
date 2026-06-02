package com.google.android.gms.internal;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzcje implements Callable<byte[]> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcha f7423a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7424b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcir f7425c;

    zzcje(zzcir zzcirVar, zzcha zzchaVar, String str) {
        this.f7425c = zzcirVar;
        this.f7423a = zzchaVar;
        this.f7424b = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        this.f7425c.f7384a.m8209G();
        return this.f7425c.f7384a.m8228b(this.f7423a, this.f7424b);
    }
}
