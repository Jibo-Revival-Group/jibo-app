package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.internal.zzcl;
import com.google.android.gms.location.LocationListener;

/* JADX INFO: loaded from: classes.dex */
final class zzcfj implements zzcl<LocationListener> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Location f7016a;

    zzcfj(zzcfi zzcfiVar, Location location) {
        this.f7016a = location;
    }

    @Override // com.google.android.gms.common.api.internal.zzcl
    /* JADX INFO: renamed from: a */
    public final void mo7172a() {
    }

    @Override // com.google.android.gms.common.api.internal.zzcl
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void mo7173a(LocationListener locationListener) {
        locationListener.m8742a(this.f7016a);
    }
}
