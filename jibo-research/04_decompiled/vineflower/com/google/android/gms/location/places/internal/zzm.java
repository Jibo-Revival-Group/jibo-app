package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;

final class zzm extends com.google.android.gms.location.places.zzm.zza<zzn> {
   private String b;
   private LatLngBounds c;
   private AutocompleteFilter d;

   zzm(zzh var1, Api var2, GoogleApiClient var3, String var4, LatLngBounds var5, AutocompleteFilter var6) {
      this.b = var4;
      this.c = var5;
      this.d = var6;
      super(var2, var3);
   }
}
