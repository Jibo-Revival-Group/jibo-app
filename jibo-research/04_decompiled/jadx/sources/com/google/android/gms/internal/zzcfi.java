package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzt;

/* JADX INFO: loaded from: classes.dex */
final class zzcfi extends zzt {

    /* JADX INFO: renamed from: a */
    private final zzci<LocationListener> f7015a;

    @Override // com.google.android.gms.location.zzs
    /* JADX INFO: renamed from: a */
    public final synchronized void mo7836a(Location location) {
        this.f7015a.m7170a(new zzcfj(this, location));
    }
}
