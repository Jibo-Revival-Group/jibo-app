package com.google.android.gms.location.places;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public interface GeoDataApi {
    /* JADX INFO: renamed from: a */
    PendingResult<AutocompletePredictionBuffer> mo8763a(GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter);

    /* JADX INFO: renamed from: a */
    PendingResult<PlaceBuffer> mo8764a(GoogleApiClient googleApiClient, String... strArr);
}
