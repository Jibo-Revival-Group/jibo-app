package com.google.android.gms.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zzcjv implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f7470a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7471b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ long f7472c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ Bundle f7473d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ boolean f7474e;

    /* JADX INFO: renamed from: f */
    private /* synthetic */ boolean f7475f;

    /* JADX INFO: renamed from: g */
    private /* synthetic */ boolean f7476g;

    /* JADX INFO: renamed from: h */
    private /* synthetic */ String f7477h;

    /* JADX INFO: renamed from: i */
    private /* synthetic */ zzcjn f7478i;

    zzcjv(zzcjn zzcjnVar, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.f7478i = zzcjnVar;
        this.f7470a = str;
        this.f7471b = str2;
        this.f7472c = j;
        this.f7473d = bundle;
        this.f7474e = z;
        this.f7475f = z2;
        this.f7476g = z3;
        this.f7477h = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7478i.m8273b(this.f7470a, this.f7471b, this.f7472c, this.f7473d, this.f7474e, this.f7475f, this.f7476g, this.f7477h);
    }
}
