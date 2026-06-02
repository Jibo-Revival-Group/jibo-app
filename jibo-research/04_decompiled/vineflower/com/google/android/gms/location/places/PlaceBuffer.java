package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzas;

public class PlaceBuffer extends AbstractDataBuffer<Place> implements Result {
   private final Status b;
   private final String c;

   public PlaceBuffer(DataHolder var1) {
      super(var1);
      this.b = PlacesStatusCodes.c(var1.b());
      if (var1 != null && var1.c() != null) {
         this.c = var1.c().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
      } else {
         this.c = null;
      }
   }

   @Override
   public Status a() {
      return this.b;
   }

   public Place b(int var1) {
      return new zzas(this.a, var1);
   }
}
