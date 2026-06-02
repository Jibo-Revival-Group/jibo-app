package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzckx implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzche f7568a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcku f7569b;

    zzckx(zzcku zzckuVar, zzche zzcheVar) {
        this.f7569b = zzckuVar;
        this.f7568a = zzcheVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f7569b) {
            zzcku.m8349a(this.f7569b, false);
            if (!this.f7569b.f7561a.m8347y()) {
                this.f7569b.f7561a.mo7872t().m8100D().m8108a("Connected to remote service");
                this.f7569b.f7561a.m8339a(this.f7568a);
            }
        }
    }
}
