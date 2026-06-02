package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zzbd implements GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzda f6259a;

    zzbd(zzba zzbaVar, zzda zzdaVar) {
        this.f6259a = zzdaVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    /* JADX INFO: renamed from: a */
    public final void mo6916a(ConnectionResult connectionResult) {
        this.f6259a.m6942a(new Status(8));
    }
}
