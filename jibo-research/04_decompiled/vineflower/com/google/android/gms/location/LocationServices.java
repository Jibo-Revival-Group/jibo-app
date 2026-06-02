package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzceb;
import com.google.android.gms.internal.zzceq;
import com.google.android.gms.internal.zzcfk;
import com.google.android.gms.internal.zzcfv;

public class LocationServices {
   public static final Api<Object> a = new Api<>("LocationServices.API", LocationServices.f, LocationServices.e);
   @Deprecated
   public static final FusedLocationProviderApi b = new zzceb();
   @Deprecated
   public static final GeofencingApi c = new zzceq();
   @Deprecated
   public static final SettingsApi d = new zzcfv();
   private static final Api.zzf<zzcfk> e = new Api.zzf<>();
   private static final Api.zza<zzcfk, Object> f = new zzy();

   public static zzcfk a(GoogleApiClient var0) {
      boolean var2 = true;
      boolean var1;
      if (var0 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      zzbq.b(var1, "GoogleApiClient parameter is required.");
      zzcfk var3 = var0.a(e);
      if (var3 != null) {
         var1 = var2;
      } else {
         var1 = false;
      }

      zzbq.a(var1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
      return var3;
   }
}
