package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzchn implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f7231a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzchm f7232b;

    zzchn(zzchm zzchmVar, String str) {
        this.f7232b = zzchmVar;
        this.f7231a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzchx zzchxVarM8232e = this.f7232b.f7441p.m8232e();
        if (zzchxVarM8232e.m8258P()) {
            zzchxVarM8232e.f7257b.m8141a(this.f7231a, 1L);
        } else {
            this.f7232b.m8103a(6, "Persisted config not initialized. Not logging error/warn");
        }
    }
}
