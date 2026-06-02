package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
abstract class zzay implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzao f6227a;

    private zzay(zzao zzaoVar) {
        this.f6227a = zzaoVar;
    }

    /* synthetic */ zzay(zzao zzaoVar, zzap zzapVar) {
        this(zzaoVar);
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo7055a();

    @Override // java.lang.Runnable
    public void run() {
        this.f6227a.f6192b.lock();
        try {
            if (Thread.interrupted()) {
                return;
            }
            mo7055a();
            return;
        } catch (RuntimeException e) {
            this.f6227a.f6191a.m7083a(e);
            return;
        } finally {
            this.f6227a.f6192b.unlock();
        }
        this.f6227a.f6192b.unlock();
    }
}
