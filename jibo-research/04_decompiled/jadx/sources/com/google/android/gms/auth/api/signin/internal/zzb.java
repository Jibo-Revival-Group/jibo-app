package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcu;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzb extends AsyncTaskLoader<Void> implements zzcu {

    /* JADX INFO: renamed from: f */
    private Semaphore f6033f;

    /* JADX INFO: renamed from: g */
    private Set<GoogleApiClient> f6034g;

    public zzb(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.f6033f = new Semaphore(0);
        this.f6034g = set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.support.v4.content.AsyncTaskLoader
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final Void mo1824d() {
        int i = 0;
        Iterator<GoogleApiClient> it = this.f6034g.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                try {
                    this.f6033f.tryAcquire(i2, 5L, TimeUnit.SECONDS);
                    return null;
                } catch (InterruptedException e) {
                    Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
            i = it.next().mo6894a(this) ? i2 + 1 : i2;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcu
    /* JADX INFO: renamed from: h */
    public final void mo6767h() {
        this.f6033f.release();
    }

    @Override // android.support.v4.content.Loader
    /* JADX INFO: renamed from: i */
    protected final void mo1844i() {
        this.f6033f.drainPermits();
        m1870t();
    }
}
