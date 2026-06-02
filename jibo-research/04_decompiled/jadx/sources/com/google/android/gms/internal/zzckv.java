package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzckv implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzche f7564a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcku f7565b;

    zzckv(zzcku zzckuVar, zzche zzcheVar) {
        this.f7565b = zzckuVar;
        this.f7564a = zzcheVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f7565b) {
            zzcku.m8349a(this.f7565b, false);
            if (!this.f7565b.f7561a.m8347y()) {
                this.f7565b.f7561a.mo7872t().m8101E().m8108a("Connected to service");
                this.f7565b.f7561a.m8339a(this.f7564a);
            }
        }
    }
}
