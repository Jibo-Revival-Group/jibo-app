package com.google.android.gms.internal;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
final class zzcgt implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgs f7134a;

    zzcgt(zzcgs zzcgsVar) {
        this.f7134a = zzcgsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f7134a.f7130a.m8235h().m8173a(this);
            return;
        }
        boolean zM8017b = this.f7134a.m8017b();
        zzcgs.m8011a(this.f7134a, 0L);
        if (zM8017b && this.f7134a.f7133e) {
            this.f7134a.mo8015a();
        }
    }
}
