package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzcjh implements Callable<List<zzclp>> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgi f7432a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcir f7433b;

    zzcjh(zzcir zzcirVar, zzcgi zzcgiVar) {
        this.f7433b = zzcirVar;
        this.f7432a = zzcgiVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzclp> call() throws Exception {
        this.f7433b.f7384a.m8209G();
        return this.f7433b.f7384a.m8244q().m7981a(this.f7432a.f7087a);
    }
}
