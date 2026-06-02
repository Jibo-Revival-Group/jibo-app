package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationServices;

public final class zzceb implements FusedLocationProviderApi {
   @Override
   public final Location a(GoogleApiClient var1) {
      zzcfk var3 = LocationServices.a(var1);

      try {
         var4 = var3.e();
      } catch (Exception var2) {
         var4 = null;
      }

      return var4;
   }

   @Override
   public final LocationAvailability b(GoogleApiClient var1) {
      zzcfk var3 = LocationServices.a(var1);

      try {
         var4 = var3.x();
      } catch (Exception var2) {
         var4 = null;
      }

      return var4;
   }
}
