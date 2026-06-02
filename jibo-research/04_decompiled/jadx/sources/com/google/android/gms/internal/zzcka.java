package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzcka implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcjn f7490a;

    zzcka(zzcjn zzcjnVar) {
        this.f7490a = zzcjnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcjn zzcjnVar = this.f7490a;
        zzcjnVar.mo7855c();
        zzcjnVar.m8259Q();
        zzcjnVar.mo7872t().m8100D().m8108a("Resetting analytics data (FE)");
        zzcjnVar.mo7861i().m8332A();
    }
}
