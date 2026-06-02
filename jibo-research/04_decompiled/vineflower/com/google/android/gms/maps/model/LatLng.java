package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class LatLng extends zzbfm implements ReflectedParcelable {
   public static final Creator<LatLng> CREATOR = new zzf();
   public final double a;
   public final double b;

   public LatLng(double var1, double var3) {
      if (-180.0 <= var3 && var3 < 180.0) {
         this.b = var3;
      } else {
         this.b = ((var3 - 180.0) % 360.0 + 360.0) % 360.0 - 180.0;
      }

      this.a = Math.max(-90.0, Math.min(90.0, var1));
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof LatLng)) {
            var2 = false;
         } else {
            var1 = var1;
            if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(var1.a) || Double.doubleToLongBits(this.b) != Double.doubleToLongBits(var1.b)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      long var2 = Double.doubleToLongBits(this.a);
      int var1 = (int)(var2 ^ var2 >>> 32);
      var2 = Double.doubleToLongBits(this.b);
      return (var1 + 31) * 31 + (int)(var2 ^ var2 >>> 32);
   }

   @Override
   public final String toString() {
      double var3 = this.a;
      double var1 = this.b;
      return new StringBuilder(60).append("lat/lng: (").append(var3).append(",").append(var1).append(")").toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a);
      zzbfp.a(var1, 3, this.b);
      zzbfp.a(var1, var2);
   }
}
