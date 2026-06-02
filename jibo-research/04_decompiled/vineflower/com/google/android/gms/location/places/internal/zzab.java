package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlacesOptions;
import java.util.Locale;

public final class zzab extends com.google.android.gms.common.internal.zzab<zzq> {
   private final zzat d;
   private final Locale e = Locale.getDefault();

   private zzab(
      Context var1,
      Looper var2,
      com.google.android.gms.common.internal.zzr var3,
      GoogleApiClient.ConnectionCallbacks var4,
      GoogleApiClient.OnConnectionFailedListener var5,
      String var6,
      PlacesOptions var7
   ) {
      super(var1, var2, 67, var3, var4, var5);
      String var8;
      if (var3.b() != null) {
         var8 = var3.b().name;
      } else {
         var8 = null;
      }

      this.d = new zzat(var6, this.e, var8, null, 0);
   }

   @Override
   protected final String b() {
      return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
   }

   @Override
   protected final String b_() {
      return "com.google.android.gms.location.places.PlaceDetectionApi";
   }
}
