package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public class StreetViewPanoramaLocation extends zzbfm {
   public static final Creator<StreetViewPanoramaLocation> CREATOR = new zzo();
   public final StreetViewPanoramaLink[] a;
   public final LatLng b;
   public final String c;

   public StreetViewPanoramaLocation(StreetViewPanoramaLink[] var1, LatLng var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof StreetViewPanoramaLocation)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.c.equals(var1.c) || !this.b.equals(var1.b)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.b, this.c});
   }

   @Override
   public String toString() {
      return zzbg.a(this).a("panoId", this.c).a("position", this.b.toString()).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a, var2, false);
      zzbfp.a(var1, 3, this.b, var2, false);
      zzbfp.a(var1, 4, this.c, false);
      zzbfp.a(var1, var3);
   }
}
