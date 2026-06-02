package com.google.android.gms.iid;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class zzc implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Intent f6800a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ Intent f6801b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzb f6802c;

    zzc(zzb zzbVar, Intent intent, Intent intent2) {
        this.f6802c = zzbVar;
        this.f6800a = intent;
        this.f6801b = intent2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6802c.handleIntent(this.f6800a);
        this.f6802c.m7617a(this.f6801b);
    }
}
