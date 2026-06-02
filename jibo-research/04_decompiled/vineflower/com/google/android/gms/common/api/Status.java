package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class Status extends zzbfm implements Result, ReflectedParcelable {
   public static final Creator<Status> CREATOR = new zzg();
   public static final Status a = new Status(0);
   public static final Status b = new Status(14);
   public static final Status c = new Status(8);
   public static final Status d = new Status(15);
   public static final Status e = new Status(16);
   public static final Status f = new Status(17);
   private static Status g = new Status(18);
   private int h;
   private final int i;
   private final String j;
   private final PendingIntent k;

   public Status(int var1) {
      this(var1, null);
   }

   Status(int var1, int var2, String var3, PendingIntent var4) {
      this.h = var1;
      this.i = var2;
      this.j = var3;
      this.k = var4;
   }

   public Status(int var1, String var2) {
      this(1, var1, var2, null);
   }

   public Status(int var1, String var2, PendingIntent var3) {
      this(1, var1, var2, var3);
   }

   @Override
   public final Status a() {
      return this;
   }

   public final String b() {
      return this.j;
   }

   public final boolean c() {
      boolean var1;
      if (this.i <= 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final int d() {
      return this.i;
   }

   public final String e() {
      String var1;
      if (this.j != null) {
         var1 = this.j;
      } else {
         var1 = CommonStatusCodes.a(this.i);
      }

      return var1;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof Status)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (this.h == var1.h) {
            var2 = var3;
            if (this.i == var1.i) {
               var2 = var3;
               if (zzbg.a(this.j, var1.j)) {
                  var2 = var3;
                  if (zzbg.a(this.k, var1.k)) {
                     var2 = true;
                  }
               }
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.h, this.i, this.j, this.k});
   }

   @Override
   public final String toString() {
      return zzbg.a(this).a("statusCode", this.e()).a("resolution", this.k).toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.d());
      zzbfp.a(var1, 2, this.b(), false);
      zzbfp.a(var1, 3, this.k, var2, false);
      zzbfp.a(var1, 1000, this.h);
      zzbfp.a(var1, var3);
   }
}
