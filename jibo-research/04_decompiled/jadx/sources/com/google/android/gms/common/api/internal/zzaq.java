package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class zzaq implements com.google.android.gms.common.internal.zzj {

    /* JADX INFO: renamed from: a */
    private final WeakReference<zzao> f6213a;

    /* JADX INFO: renamed from: b */
    private final Api<?> f6214b;

    /* JADX INFO: renamed from: c */
    private final boolean f6215c;

    public zzaq(zzao zzaoVar, Api<?> api, boolean z) {
        this.f6213a = new WeakReference<>(zzaoVar);
        this.f6214b = api;
        this.f6215c = z;
    }

    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: a */
    public final void mo7054a(ConnectionResult connectionResult) {
        zzao zzaoVar = this.f6213a.get();
        if (zzaoVar == null) {
            return;
        }
        com.google.android.gms.common.internal.zzbq.m7379a(Looper.myLooper() == zzaoVar.f6191a.f6269d.mo6899c(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        zzaoVar.f6192b.lock();
        try {
            if (zzaoVar.m7035b(0)) {
                if (!connectionResult.m6821b()) {
                    zzaoVar.m7034b(connectionResult, this.f6214b, this.f6215c);
                }
                if (zzaoVar.m7040d()) {
                    zzaoVar.m7041e();
                }
            }
        } finally {
            zzaoVar.f6192b.unlock();
        }
    }
}
