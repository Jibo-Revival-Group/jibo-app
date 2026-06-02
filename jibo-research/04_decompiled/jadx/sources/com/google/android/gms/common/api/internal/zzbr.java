package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class zzbr implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ConnectionResult f6316a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzbo f6317b;

    zzbr(zzbo zzboVar, ConnectionResult connectionResult) {
        this.f6317b = zzboVar;
        this.f6316a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6317b.mo6916a(this.f6316a);
    }
}
