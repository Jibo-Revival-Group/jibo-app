package com.google.android.gms.location;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;

@Deprecated
public interface FusedLocationProviderApi {
   Location a(GoogleApiClient var1);

   LocationAvailability b(GoogleApiClient var1);
}
