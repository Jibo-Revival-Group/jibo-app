package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public class StreetViewPanoramaOrientation extends zzbfm {
   public static final Creator<StreetViewPanoramaOrientation> CREATOR = new zzp();
   public final float a;
   public final float b;

   public StreetViewPanoramaOrientation(float var1, float var2) {
      boolean var3;
      if (-90.0F <= var1 && var1 <= 90.0F) {
         var3 = true;
      } else {
         var3 = false;
      }

      zzbq.b(var3, new StringBuilder(62).append("Tilt needs to be between -90 and 90 inclusive: ").append(var1).toString());
      this.a = 0.0F + var1;
      var1 = var2;
      if (var2 <= 0.0) {
         var1 = var2 % 360.0F + 360.0F;
      }

      this.b = var1 % 360.0F;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof StreetViewPanoramaOrientation)) {
            var2 = false;
         } else {
            var1 = var1;
            if (Float.floatToIntBits(this.a) != Float.floatToIntBits(var1.a) || Float.floatToIntBits(this.b) != Float.floatToIntBits(var1.b)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b});
   }

   @Override
   public String toString() {
      return zzbg.a(this).a("tilt", this.a).a("bearing", this.b).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a);
      zzbfp.a(var1, 3, this.b);
      zzbfp.a(var1, var2);
   }

   public static final class Builder {
      public float a;
      public float b;

      public final StreetViewPanoramaOrientation.Builder a(float var1) {
         this.b = var1;
         return this;
      }

      public final StreetViewPanoramaOrientation a() {
         return new StreetViewPanoramaOrientation(this.b, this.a);
      }

      public final StreetViewPanoramaOrientation.Builder b(float var1) {
         this.a = var1;
         return this;
      }
   }
}
