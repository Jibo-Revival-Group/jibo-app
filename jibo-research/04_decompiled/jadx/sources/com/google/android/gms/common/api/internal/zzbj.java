package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
abstract class zzbj {

    /* JADX INFO: renamed from: a */
    private final zzbh f6281a;

    protected zzbj(zzbh zzbhVar) {
        this.f6281a = zzbhVar;
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo7023a();

    /* JADX INFO: renamed from: a */
    public final void m7087a(zzbi zzbiVar) {
        zzbiVar.f6271f.lock();
        try {
            if (zzbiVar.f6279n != this.f6281a) {
                return;
            }
            mo7023a();
        } finally {
            zzbiVar.f6271f.unlock();
        }
    }
}
