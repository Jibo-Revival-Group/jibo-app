package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
final class zzbv implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ConnectionResult f6326a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzbu f6327b;

    zzbv(zzbu zzbuVar, ConnectionResult connectionResult) {
        this.f6327b = zzbuVar;
        this.f6326a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f6326a.m6821b()) {
            ((zzbo) this.f6327b.f6320a.f6296m.get(this.f6327b.f6322c)).mo6916a(this.f6326a);
            return;
        }
        zzbu.m7148a(this.f6327b, true);
        if (this.f6327b.f6321b.mo6864i()) {
            this.f6327b.m7147a();
        } else {
            this.f6327b.f6321b.m6857a(null, Collections.emptySet());
        }
    }
}
