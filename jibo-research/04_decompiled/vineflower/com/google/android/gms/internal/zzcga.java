package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.places.PlacesStatusCodes;

@Deprecated
public final class zzcga extends zzd<zzcfz> implements Result {
   private final Status b;

   public zzcga(DataHolder var1) {
      this(var1, PlacesStatusCodes.c(var1.b()));
   }

   private zzcga(DataHolder var1, Status var2) {
      super(var1, zzcfz.CREATOR);
      boolean var3;
      if (var1 != null && var1.b() != var2.d()) {
         var3 = false;
      } else {
         var3 = true;
      }

      zzbq.b(var3);
      this.b = var2;
   }

   @Override
   public final Status a() {
      return this.b;
   }
}
