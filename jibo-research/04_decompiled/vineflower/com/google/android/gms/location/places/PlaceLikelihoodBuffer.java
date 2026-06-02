package com.google.android.gms.location.places;

import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.location.places.internal.zzah;
import com.google.android.gms.location.places.internal.zzaj;
import java.util.Comparator;

public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
   private static final Comparator<zzah> b = new zzi();
   private final String c;
   private final int d;
   private final Status e;
   private final boolean f;

   public PlaceLikelihoodBuffer(DataHolder var1, int var2) {
      this(var1, false, var2);
   }

   private PlaceLikelihoodBuffer(DataHolder var1, boolean var2, int var3) {
      super(var1);
      this.e = PlacesStatusCodes.c(var1.b());
      switch (var3) {
         case 100:
         case 101:
         case 102:
         case 103:
         case 104:
         case 105:
         case 106:
         case 107:
         case 108:
            this.d = var3;
            this.f = false;
            if (var1 != null && var1.c() != null) {
               this.c = var1.c().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
            } else {
               this.c = null;
            }

            return;
         default:
            throw new IllegalArgumentException(new StringBuilder(27).append("invalid source: ").append(var3).toString());
      }
   }

   public static int a(Bundle var0) {
      return var0.getInt("com.google.android.gms.location.places.PlaceLikelihoodBuffer.SOURCE_EXTRA_KEY");
   }

   @Override
   public Status a() {
      return this.e;
   }

   public PlaceLikelihood b(int var1) {
      return new zzaj(this.a, var1);
   }

   @Override
   public String toString() {
      return zzbg.a(this).a("status", this.a()).a("attributions", this.c).toString();
   }
}
