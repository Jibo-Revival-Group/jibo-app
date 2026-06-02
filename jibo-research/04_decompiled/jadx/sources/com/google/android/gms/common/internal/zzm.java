package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class zzm implements zzj {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzd f6628a;

    public zzm(zzd zzdVar) {
        this.f6628a = zzdVar;
    }

    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: a */
    public final void mo7054a(ConnectionResult connectionResult) {
        if (connectionResult.m6821b()) {
            this.f6628a.m7423a((zzan) null, this.f6628a.mo7313o());
        } else if (this.f6628a.f6612v != null) {
            this.f6628a.f6612v.mo7317a(connectionResult);
        }
    }
}
