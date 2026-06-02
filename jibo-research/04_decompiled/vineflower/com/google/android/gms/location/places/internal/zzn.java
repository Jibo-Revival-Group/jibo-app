package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

public final class zzn extends com.google.android.gms.common.internal.zzab<zzs> {
   private final zzat d;

   private zzn(
      Context var1,
      Looper var2,
      com.google.android.gms.common.internal.zzr var3,
      GoogleApiClient.ConnectionCallbacks var4,
      GoogleApiClient.OnConnectionFailedListener var5,
      String var6,
      PlacesOptions var7
   ) {
      super(var1, var2, 65, var3, var4, var5);
      Locale var9 = Locale.getDefault();
      String var8;
      if (var3.b() != null) {
         var8 = var3.b().name;
      } else {
         var8 = null;
      }

      this.d = new zzat(var6, var9, var8, null, 0);
   }

   public final void a(com.google.android.gms.location.places.zzm var1, String var2, LatLngBounds var3, AutocompleteFilter var4) throws RemoteException {
      zzbq.a(var1, "callback == null");
      if (var2 == null) {
         var2 = "";
      }

      if (var4 == null) {
         var4 = new AutocompleteFilter.Builder().a();
      }

      ((zzs)this.v()).a(var2, var3, var4, this.d, var1);
   }

   public final void a(com.google.android.gms.location.places.zzm var1, List<String> var2) throws RemoteException {
      zzbq.a(var1, "callback == null");
      ((zzs)this.v()).a(var2, this.d, var1);
   }

   @Override
   protected final String b() {
      return "com.google.android.gms.location.places.internal.IGooglePlacesService";
   }

   @Override
   protected final String b_() {
      return "com.google.android.gms.location.places.GeoDataApi";
   }
}
