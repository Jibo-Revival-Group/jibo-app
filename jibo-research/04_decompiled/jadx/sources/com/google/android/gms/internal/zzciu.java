package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzciu implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgl f7392a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcgi f7393b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcir f7394c;

    zzciu(zzcir zzcirVar, zzcgl zzcglVar, zzcgi zzcgiVar) {
        this.f7394c = zzcirVar;
        this.f7392a = zzcglVar;
        this.f7393b = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7394c.f7384a.m8209G();
        this.f7394c.f7384a.m8215a(this.f7392a, this.f7393b);
    }
}
