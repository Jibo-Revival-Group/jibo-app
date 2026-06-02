package com.google.android.gms.location.places;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.maps.model.LatLngBounds;

public interface GeoDataApi {
   PendingResult<AutocompletePredictionBuffer> a(GoogleApiClient var1, String var2, LatLngBounds var3, AutocompleteFilter var4);

   PendingResult<PlaceBuffer> a(GoogleApiClient var1, String... var2);
}
