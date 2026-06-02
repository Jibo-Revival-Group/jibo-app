package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzciw implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgl f7397a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcir f7398b;

    zzciw(zzcir zzcirVar, zzcgl zzcglVar) {
        this.f7398b = zzcirVar;
        this.f7397a = zzcglVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7398b.f7384a.m8209G();
        this.f7398b.f7384a.m8214a(this.f7397a);
    }
}
