package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class LatLngBounds extends zzbfm implements ReflectedParcelable {
   public static final Creator<LatLngBounds> CREATOR = new zze();
   public final LatLng a;
   public final LatLng b;

   public LatLngBounds(LatLng var1, LatLng var2) {
      zzbq.a(var1, "null southwest");
      zzbq.a(var2, "null northeast");
      boolean var3;
      if (var2.a >= var1.a) {
         var3 = true;
      } else {
         var3 = false;
      }

      zzbq.b(var3, "southern latitude exceeds northern latitude (%s > %s)", var1.a, var2.a);
      this.a = var1;
      this.b = var2;
   }

   public static LatLngBounds a(Context var0, AttributeSet var1) {
      Object var5 = null;
      LatLngBounds var3 = (LatLngBounds)var5;
      if (var0 != null) {
         if (var1 == null) {
            var3 = (LatLngBounds)var5;
         } else {
            TypedArray var8 = var0.getResources().obtainAttributes(var1, R.styleable.MapAttrs);
            Float var6;
            if (var8.hasValue(R.styleable.MapAttrs_latLngBoundsSouthWestLatitude)) {
               var6 = var8.getFloat(R.styleable.MapAttrs_latLngBoundsSouthWestLatitude, 0.0F);
            } else {
               var6 = null;
            }

            Float var7;
            if (var8.hasValue(R.styleable.MapAttrs_latLngBoundsSouthWestLongitude)) {
               var7 = var8.getFloat(R.styleable.MapAttrs_latLngBoundsSouthWestLongitude, 0.0F);
            } else {
               var7 = null;
            }

            Float var2;
            if (var8.hasValue(R.styleable.MapAttrs_latLngBoundsNorthEastLatitude)) {
               var2 = var8.getFloat(R.styleable.MapAttrs_latLngBoundsNorthEastLatitude, 0.0F);
            } else {
               var2 = null;
            }

            Float var4;
            if (var8.hasValue(R.styleable.MapAttrs_latLngBoundsNorthEastLongitude)) {
               var4 = var8.getFloat(R.styleable.MapAttrs_latLngBoundsNorthEastLongitude, 0.0F);
            } else {
               var4 = null;
            }

            var3 = (LatLngBounds)var5;
            if (var6 != null) {
               var3 = (LatLngBounds)var5;
               if (var7 != null) {
                  var3 = (LatLngBounds)var5;
                  if (var2 != null) {
                     var3 = (LatLngBounds)var5;
                     if (var4 != null) {
                        var3 = new LatLngBounds(new LatLng(var6.floatValue(), var7.floatValue()), new LatLng(var2.floatValue(), var4.floatValue()));
                     }
                  }
               }
            }
         }
      }

      return var3;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof LatLngBounds)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.a.equals(var1.a) || !this.b.equals(var1.b)) {
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
      return zzbg.a(this).a("southwest", this.a).a("northeast", this.b).toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a, var2, false);
      zzbfp.a(var1, 3, this.b, var2, false);
      zzbfp.a(var1, var3);
   }
}
