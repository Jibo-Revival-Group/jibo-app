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

public final class zzh implements GeoDataApi {
   @Override
   public final PendingResult<AutocompletePredictionBuffer> a(GoogleApiClient var1, String var2, LatLngBounds var3, AutocompleteFilter var4) {
      return var1.a(new zzm(this, Places.a, var1, var2, var3, var4));
   }

   @Override
   public final PendingResult<PlaceBuffer> a(GoogleApiClient var1, String... var2) {
      boolean var5;
      if (var2 != null) {
         var5 = true;
      } else {
         var5 = false;
      }

      zzbq.b(var5, "placeIds == null");
      if (var2.length > 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      zzbq.b(var5, "placeIds is empty");

      for (String var6 : var2) {
         if (var6 != null) {
            var5 = true;
         } else {
            var5 = false;
         }

         zzbq.b(var5, "placeId == null");
         if (!var6.isEmpty()) {
            var5 = true;
         } else {
            var5 = false;
         }

         zzbq.b(var5, "placeId is empty");
      }

      return var1.a(new zzl(this, Places.a, var1, var2));
   }
}
