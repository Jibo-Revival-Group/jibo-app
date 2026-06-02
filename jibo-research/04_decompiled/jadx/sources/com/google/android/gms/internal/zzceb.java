package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationServices;

/* JADX INFO: loaded from: classes.dex */
public final class zzceb implements FusedLocationProviderApi {
    @Override // com.google.android.gms.location.FusedLocationProviderApi
    /* JADX INFO: renamed from: a */
    public final Location mo7822a(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.m8745a(googleApiClient).m7837e();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    /* JADX INFO: renamed from: b */
    public final LocationAvailability mo7823b(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.m8745a(googleApiClient).m7838x();
        } catch (Exception e) {
            return null;
        }
    }
}
