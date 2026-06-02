package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class zzo extends zze {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzd f6631a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzo(zzd zzdVar, int i, Bundle bundle) {
        super(zzdVar, i, null);
        this.f6631a = zzdVar;
    }

    @Override // com.google.android.gms.common.internal.zze
    /* JADX INFO: renamed from: a */
    protected final void mo7441a(ConnectionResult connectionResult) {
        this.f6631a.f6592b.mo7054a(connectionResult);
        this.f6631a.m7422a(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.zze
    /* JADX INFO: renamed from: a */
    protected final boolean mo7443a() {
        this.f6631a.f6592b.mo7054a(ConnectionResult.f6064a);
        return true;
    }
}
