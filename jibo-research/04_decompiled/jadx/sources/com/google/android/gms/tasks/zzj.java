package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
final class zzj implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Task f8421a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzi f8422b;

    zzj(zzi zziVar, Task task) {
        this.f8422b = zziVar;
        this.f8421a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8422b.f8419b) {
            if (this.f8422b.f8420c != null) {
                this.f8422b.f8420c.mo8925a(this.f8421a.mo8931c());
            }
        }
    }
}
