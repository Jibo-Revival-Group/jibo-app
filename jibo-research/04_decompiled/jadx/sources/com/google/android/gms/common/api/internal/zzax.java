package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
final class zzax implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzao f6226a;

    private zzax(zzao zzaoVar) {
        this.f6226a = zzaoVar;
    }

    /* synthetic */ zzax(zzao zzaoVar, zzap zzapVar) {
        this(zzaoVar);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public final void mo6914a(int i) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public final void mo6915a(Bundle bundle) {
        this.f6226a.f6201k.mo8496a(new zzav(this.f6226a));
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    /* JADX INFO: renamed from: a */
    public final void mo6916a(ConnectionResult connectionResult) {
        this.f6226a.f6192b.lock();
        try {
            if (this.f6226a.m7030a(connectionResult)) {
                this.f6226a.m7046g();
                this.f6226a.m7041e();
            } else {
                this.f6226a.m7033b(connectionResult);
            }
        } finally {
            this.f6226a.f6192b.unlock();
        }
    }
}
