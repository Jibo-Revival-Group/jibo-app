package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzcix implements Callable<List<zzclp>> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgi f7399a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7400b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f7401c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ zzcir f7402d;

    zzcix(zzcir zzcirVar, zzcgi zzcgiVar, String str, String str2) {
        this.f7402d = zzcirVar;
        this.f7399a = zzcgiVar;
        this.f7400b = str;
        this.f7401c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzclp> call() throws Exception {
        this.f7402d.f7384a.m8209G();
        return this.f7402d.f7384a.m8244q().m7983a(this.f7399a.f7087a, this.f7400b, this.f7401c);
    }
}
