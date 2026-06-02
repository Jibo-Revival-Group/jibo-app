package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public class StreetViewPanoramaLink extends zzbfm {
   public static final Creator<StreetViewPanoramaLink> CREATOR = new zzn();
   public final String a;
   public final float b;

   public StreetViewPanoramaLink(String var1, float var2) {
      this.a = var1;
      float var3 = var2;
      if (var2 <= 0.0) {
         var3 = var2 % 360.0F + 360.0F;
      }

      this.b = var3 % 360.0F;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof StreetViewPanoramaLink)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.a.equals(var1.a) || Float.floatToIntBits(this.b) != Float.floatToIntBits(var1.b)) {
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
      return zzbg.a(this).a("panoId", this.a).a("bearing", this.b).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a, false);
      zzbfp.a(var1, 3, this.b);
      zzbfp.a(var1, var2);
   }
}
