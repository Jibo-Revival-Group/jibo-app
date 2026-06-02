package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzcja implements Callable<List<zzcgl>> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f7411a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7412b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f7413c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ zzcir f7414d;

    zzcja(zzcir zzcirVar, String str, String str2, String str3) {
        this.f7414d = zzcirVar;
        this.f7411a = str;
        this.f7412b = str2;
        this.f7413c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzcgl> call() throws Exception {
        this.f7414d.f7384a.m8209G();
        return this.f7414d.f7384a.m8244q().m7994b(this.f7411a, this.f7412b, this.f7413c);
    }
}
