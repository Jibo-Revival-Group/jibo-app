package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzcl;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;

/* JADX INFO: loaded from: classes.dex */
final class zzcfg implements zzcl<LocationCallback> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ LocationAvailability f7014a;

    zzcfg(zzcfe zzcfeVar, LocationAvailability locationAvailability) {
        this.f7014a = locationAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.zzcl
    /* JADX INFO: renamed from: a */
    public final void mo7172a() {
    }

    @Override // com.google.android.gms.common.api.internal.zzcl
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void mo7173a(LocationCallback locationCallback) {
        locationCallback.m8740a(this.f7014a);
    }
}
