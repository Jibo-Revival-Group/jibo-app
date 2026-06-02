package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class VisibleRegion extends zzbfm {
   public static final Creator<VisibleRegion> CREATOR = new zzu();
   public final LatLng a;
   public final LatLng b;
   public final LatLng c;
   public final LatLng d;
   public final LatLngBounds e;

   public VisibleRegion(LatLng var1, LatLng var2, LatLng var3, LatLng var4, LatLngBounds var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof VisibleRegion)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.a.equals(var1.a) || !this.b.equals(var1.b) || !this.c.equals(var1.c) || !this.d.equals(var1.d) || !this.e.equals(var1.e)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d, this.e});
   }

   @Override
   public final String toString() {
      return zzbg.a(this).a("nearLeft", this.a).a("nearRight", this.b).a("farLeft", this.c).a("farRight", this.d).a("latLngBounds", this.e).toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a, var2, false);
      zzbfp.a(var1, 3, this.b, var2, false);
      zzbfp.a(var1, 4, this.c, var2, false);
      zzbfp.a(var1, 5, this.d, var2, false);
      zzbfp.a(var1, 6, this.e, var2, false);
      zzbfp.a(var1, var3);
   }
}
