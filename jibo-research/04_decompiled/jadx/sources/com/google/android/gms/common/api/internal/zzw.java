package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzw implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzv f6448a;

    zzw(zzv zzvVar) {
        this.f6448a = zzvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6448a.f6446m.lock();
        try {
            this.f6448a.m7252h();
        } finally {
            this.f6448a.f6446m.unlock();
        }
    }
}
