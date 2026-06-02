package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzcht implements Runnable {

    /* JADX INFO: renamed from: a */
    private final zzchs f7238a;

    /* JADX INFO: renamed from: b */
    private final int f7239b;

    /* JADX INFO: renamed from: c */
    private final Throwable f7240c;

    /* JADX INFO: renamed from: d */
    private final byte[] f7241d;

    /* JADX INFO: renamed from: e */
    private final String f7242e;

    /* JADX INFO: renamed from: f */
    private final Map<String, List<String>> f7243f;

    private zzcht(String str, zzchs zzchsVar, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzbq.m7373a(zzchsVar);
        this.f7238a = zzchsVar;
        this.f7239b = i;
        this.f7240c = th;
        this.f7241d = bArr;
        this.f7242e = str;
        this.f7243f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7238a.mo8116a(this.f7242e, this.f7239b, this.f7240c, this.f7241d, this.f7243f);
    }
}
