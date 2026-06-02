package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzciz implements Callable<List<zzcgl>> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgi f7407a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7408b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f7409c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ zzcir f7410d;

    zzciz(zzcir zzcirVar, zzcgi zzcgiVar, String str, String str2) {
        this.f7410d = zzcirVar;
        this.f7407a = zzcgiVar;
        this.f7408b = str;
        this.f7409c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzcgl> call() throws Exception {
        this.f7410d.f7384a.m8209G();
        return this.f7410d.f7384a.m8244q().m7994b(this.f7407a.f7087a, this.f7408b, this.f7409c);
    }
}
