package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public final class zzh implements GeoDataApi {
    @Override // com.google.android.gms.location.places.GeoDataApi
    /* JADX INFO: renamed from: a */
    public final PendingResult<AutocompletePredictionBuffer> mo8763a(GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
        return googleApiClient.mo6889a(new zzm(this, Places.f8122a, googleApiClient, str, latLngBounds, autocompleteFilter));
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    /* JADX INFO: renamed from: a */
    public final PendingResult<PlaceBuffer> mo8764a(GoogleApiClient googleApiClient, String... strArr) {
        zzbq.m7383b(strArr != null, "placeIds == null");
        zzbq.m7383b(strArr.length > 0, "placeIds is empty");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            zzbq.m7383b(str != null, "placeId == null");
            zzbq.m7383b(!str.isEmpty(), "placeId is empty");
        }
        return googleApiClient.mo6889a(new zzl(this, Places.f8122a, googleApiClient, strArr));
    }
}
