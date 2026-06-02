package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult extends zzbfm implements ReflectedParcelable {
   public static final Creator<LocationResult> CREATOR = new zzx();
   static final List<Location> a = Collections.emptyList();
   private final List<Location> b;

   LocationResult(List<Location> var1) {
      this.b = var1;
   }

   public final List<Location> a() {
      return this.b;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2;
      if (!(var1 instanceof LocationResult)) {
         var2 = false;
      } else {
         var1 = var1;
         if (var1.b.size() != this.b.size()) {
            var2 = false;
         } else {
            Iterator var7 = var1.b.iterator();
            Iterator var3 = this.b.iterator();

            while (true) {
               if (!var7.hasNext()) {
                  var2 = true;
                  break;
               }

               Location var4 = (Location)var3.next();
               Location var5 = (Location)var7.next();
               if (var4.getTime() != var5.getTime()) {
                  var2 = false;
                  break;
               }
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      Iterator var4 = this.b.iterator();
      int var1 = 17;

      while (var4.hasNext()) {
         long var2 = ((Location)var4.next()).getTime();
         var1 = (int)(var2 ^ var2 >>> 32) + var1 * 31;
      }

      return var1;
   }

   @Override
   public final String toString() {
      String var1 = String.valueOf(this.b);
      return new StringBuilder(String.valueOf(var1).length() + 27).append("LocationResult[locations: ").append(var1).append("]").toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.c(var1, 1, this.a(), false);
      zzbfp.a(var1, var2);
   }
}
