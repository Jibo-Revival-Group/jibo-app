package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public class StreetViewPanoramaCamera extends zzbfm implements ReflectedParcelable {
   public static final Creator<StreetViewPanoramaCamera> CREATOR = new zzm();
   public final float a;
   public final float b;
   public final float c;
   private final StreetViewPanoramaOrientation d;

   public StreetViewPanoramaCamera(float var1, float var2, float var3) {
      boolean var5;
      if (-90.0F <= var2 && var2 <= 90.0F) {
         var5 = true;
      } else {
         var5 = false;
      }

      zzbq.b(var5, new StringBuilder(62).append("Tilt needs to be between -90 and 90 inclusive: ").append(var2).toString());
      float var4 = var1;
      if (var1 <= 0.0) {
         var4 = 0.0F;
      }

      this.a = var4;
      this.b = var2 + 0.0F;
      if (var3 <= 0.0) {
         var1 = var3 % 360.0F + 360.0F;
      } else {
         var1 = var3;
      }

      this.c = var1 % 360.0F;
      this.d = new StreetViewPanoramaOrientation.Builder().a(var2).b(var3).a();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof StreetViewPanoramaCamera)) {
            var2 = false;
         } else {
            var1 = var1;
            if (Float.floatToIntBits(this.a) != Float.floatToIntBits(var1.a)
               || Float.floatToIntBits(this.b) != Float.floatToIntBits(var1.b)
               || Float.floatToIntBits(this.c) != Float.floatToIntBits(var1.c)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
   }

   @Override
   public String toString() {
      return zzbg.a(this).a("zoom", this.a).a("tilt", this.b).a("bearing", this.c).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a);
      zzbfp.a(var1, 3, this.b);
      zzbfp.a(var1, 4, this.c);
      zzbfp.a(var1, var2);
   }
}
