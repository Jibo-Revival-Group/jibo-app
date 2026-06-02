package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzcl;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

/* JADX INFO: loaded from: classes.dex */
final class zzcff implements zzcl<LocationCallback> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ LocationResult f7013a;

    zzcff(zzcfe zzcfeVar, LocationResult locationResult) {
        this.f7013a = locationResult;
    }

    @Override // com.google.android.gms.common.api.internal.zzcl
    /* JADX INFO: renamed from: a */
    public final void mo7172a() {
    }

    @Override // com.google.android.gms.common.api.internal.zzcl
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void mo7173a(LocationCallback locationCallback) {
        locationCallback.m8741a(this.f7013a);
    }
}
