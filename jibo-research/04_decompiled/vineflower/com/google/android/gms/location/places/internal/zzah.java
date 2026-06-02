package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.location.places.PlaceLikelihood;
import java.util.Arrays;

public final class zzah extends zzbfm implements PlaceLikelihood {
   public static final Creator<zzah> CREATOR = new zzai();
   private PlaceEntity a;
   private float b;

   zzah(PlaceEntity var1, float var2) {
      this.a = var1;
      this.b = var2;
   }

   public final float a() {
      return this.b;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof zzah)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.a.equals(var1.a) || this.b != var1.b) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b});
   }

   @Override
   public final String toString() {
      return zzbg.a(this).a("place", this.a).a("likelihood", this.b).toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a, var2, false);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, var3);
   }
}
