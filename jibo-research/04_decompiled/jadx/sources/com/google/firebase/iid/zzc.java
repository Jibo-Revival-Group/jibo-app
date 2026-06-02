package com.google.firebase.iid;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class zzc implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Intent f8641a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ Intent f8642b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzb f8643c;

    zzc(zzb zzbVar, Intent intent, Intent intent2) {
        this.f8643c = zzbVar;
        this.f8641a = intent;
        this.f8642b = intent2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8643c.mo9117b(this.f8641a);
        this.f8643c.m9126d(this.f8642b);
    }
}
