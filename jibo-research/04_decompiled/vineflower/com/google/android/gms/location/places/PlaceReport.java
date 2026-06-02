package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbi;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public class PlaceReport extends zzbfm implements ReflectedParcelable {
   public static final Creator<PlaceReport> CREATOR = new zzl();
   private int a;
   private final String b;
   private final String c;
   private final String d;

   PlaceReport(int var1, String var2, String var3, String var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public String a() {
      return this.b;
   }

   public String b() {
      return this.c;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof PlaceReport)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (zzbg.a(this.b, var1.b)) {
            var2 = var3;
            if (zzbg.a(this.c, var1.c)) {
               var2 = var3;
               if (zzbg.a(this.d, var1.d)) {
                  var2 = true;
               }
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.b, this.c, this.d});
   }

   @Override
   public String toString() {
      zzbi var1 = zzbg.a(this);
      var1.a("placeId", this.b);
      var1.a("tag", this.c);
      if (!"unknown".equals(this.d)) {
         var1.a("source", this.d);
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.a(), false);
      zzbfp.a(var1, 3, this.b(), false);
      zzbfp.a(var1, 4, this.d, false);
      zzbfp.a(var1, var2);
   }
}
