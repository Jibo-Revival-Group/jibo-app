package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzciy implements Callable<List<zzclp>> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f7403a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7404b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f7405c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ zzcir f7406d;

    zzciy(zzcir zzcirVar, String str, String str2, String str3) {
        this.f7406d = zzcirVar;
        this.f7403a = str;
        this.f7404b = str2;
        this.f7405c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzclp> call() throws Exception {
        this.f7406d.f7384a.m8209G();
        return this.f7406d.f7384a.m8244q().m7983a(this.f7403a, this.f7404b, this.f7405c);
    }
}
