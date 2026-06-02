package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzq;

/* JADX INFO: loaded from: classes.dex */
final class zzcfe extends zzq {

    /* JADX INFO: renamed from: a */
    private final zzci<LocationCallback> f7012a;

    @Override // com.google.android.gms.location.zzp
    /* JADX INFO: renamed from: a */
    public final void mo7834a(LocationAvailability locationAvailability) {
        this.f7012a.m7170a(new zzcfg(this, locationAvailability));
    }

    @Override // com.google.android.gms.location.zzp
    /* JADX INFO: renamed from: a */
    public final void mo7835a(LocationResult locationResult) {
        this.f7012a.m7170a(new zzcff(this, locationResult));
    }
}
