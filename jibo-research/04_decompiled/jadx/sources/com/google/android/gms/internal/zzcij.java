package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.lang.Thread;

/* JADX INFO: loaded from: classes.dex */
final class zzcij implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a */
    private final String f7324a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcih f7325b;

    public zzcij(zzcih zzcihVar, String str) {
        this.f7325b = zzcihVar;
        zzbq.m7373a(str);
        this.f7324a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f7325b.mo7872t().m8106y().m8109a(this.f7324a, th);
    }
}
