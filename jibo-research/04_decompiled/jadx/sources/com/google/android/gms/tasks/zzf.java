package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
final class zzf implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Task f8411a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zze f8412b;

    zzf(zze zzeVar, Task task) {
        this.f8412b = zzeVar;
        this.f8411a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8412b.f8409b) {
            if (this.f8412b.f8410c != null) {
                this.f8412b.f8410c.mo7001a(this.f8411a);
            }
        }
    }
}
