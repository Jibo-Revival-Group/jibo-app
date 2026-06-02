package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
final class zzh implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Task f8416a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzg f8417b;

    zzh(zzg zzgVar, Task task) {
        this.f8417b = zzgVar;
        this.f8416a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8417b.f8414b) {
            if (this.f8417b.f8415c != null) {
                this.f8417b.f8415c.mo8924a(this.f8416a.mo8932d());
            }
        }
    }
}
