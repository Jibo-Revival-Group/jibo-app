package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
abstract class zzcgs {

    /* JADX INFO: renamed from: b */
    private static volatile Handler f7129b;

    /* JADX INFO: renamed from: a */
    private final zzcim f7130a;

    /* JADX INFO: renamed from: c */
    private final Runnable f7131c;

    /* JADX INFO: renamed from: d */
    private volatile long f7132d;

    /* JADX INFO: renamed from: e */
    private boolean f7133e;

    zzcgs(zzcim zzcimVar) {
        zzbq.m7373a(zzcimVar);
        this.f7130a = zzcimVar;
        this.f7133e = true;
        this.f7131c = new zzcgt(this);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ long m8011a(zzcgs zzcgsVar, long j) {
        zzcgsVar.f7132d = 0L;
        return 0L;
    }

    /* JADX INFO: renamed from: d */
    private final Handler m8014d() {
        Handler handler;
        if (f7129b != null) {
            return f7129b;
        }
        synchronized (zzcgs.class) {
            if (f7129b == null) {
                f7129b = new Handler(this.f7130a.m8247t().getMainLooper());
            }
            handler = f7129b;
        }
        return handler;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo8015a();

    /* JADX INFO: renamed from: a */
    public final void m8016a(long j) {
        m8018c();
        if (j >= 0) {
            this.f7132d = this.f7130a.m8248u().mo7496a();
            if (m8014d().postDelayed(this.f7131c, j)) {
                return;
            }
            this.f7130a.m8233f().m8106y().m8109a("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m8017b() {
        return this.f7132d != 0;
    }

    /* JADX INFO: renamed from: c */
    public final void m8018c() {
        this.f7132d = 0L;
        m8014d().removeCallbacks(this.f7131c);
    }
}
