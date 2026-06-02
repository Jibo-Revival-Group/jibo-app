package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
final class zzm extends zzm.zza<zzn> {

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f8206b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ LatLngBounds f8207c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ AutocompleteFilter f8208d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzm(zzh zzhVar, Api api, GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
        super(api, googleApiClient);
        this.f8206b = str;
        this.f8207c = latLngBounds;
        this.f8208d = autocompleteFilter;
    }

    @Override // com.google.android.gms.common.api.internal.zzm
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ void mo6778a(Api.zzb zzbVar) throws RemoteException {
        ((zzn) zzbVar).m8800a(new com.google.android.gms.location.places.zzm(this), this.f8206b, this.f8207c, this.f8208d);
    }
}
