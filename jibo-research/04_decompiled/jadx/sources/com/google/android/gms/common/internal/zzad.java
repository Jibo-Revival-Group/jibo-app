package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
final class zzad implements zzg {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ GoogleApiClient.OnConnectionFailedListener f6528a;

    zzad(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f6528a = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.internal.zzg
    /* JADX INFO: renamed from: a */
    public final void mo7317a(ConnectionResult connectionResult) {
        this.f6528a.mo6916a(connectionResult);
    }
}
