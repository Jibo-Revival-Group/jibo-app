package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Locale;

public final class zzcfs extends zzbfm {
   public static final Creator<zzcfs> CREATOR = new zzcft();
   private final String a;
   private final long b;
   private final short c;
   private final double d;
   private final double e;
   private final float f;
   private final int g;
   private final int h;
   private final int i;

   public zzcfs(String var1, int var2, short var3, double var4, double var6, float var8, long var9, int var11, int var12) {
      if (var1 == null || var1.length() > 100) {
         var1 = String.valueOf(var1);
         if (var1.length() != 0) {
            var1 = "requestId is null or too long: ".concat(var1);
         } else {
            var1 = new String("requestId is null or too long: ");
         }

         throw new IllegalArgumentException(var1);
      } else {
         if (var8 <= 0.0F) {
            throw new IllegalArgumentException(new StringBuilder(31).append("invalid radius: ").append(var8).toString());
         }

         if (var4 > 90.0 || var4 < -90.0) {
            throw new IllegalArgumentException(new StringBuilder(42).append("invalid latitude: ").append(var4).toString());
         }

         if (!(var6 > 180.0) && !(var6 < -180.0)) {
            int var13 = var2 & 7;
            if (var13 == 0) {
               throw new IllegalArgumentException(new StringBuilder(46).append("No supported transition specified: ").append(var2).toString());
            }

            this.c = var3;
            this.a = var1;
            this.d = var4;
            this.e = var6;
            this.f = var8;
            this.b = var9;
            this.g = var13;
            this.h = var11;
            this.i = var12;
         } else {
            throw new IllegalArgumentException(new StringBuilder(43).append("invalid longitude: ").append(var6).toString());
         }
      }
   }

   public final String a() {
      return this.a;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 == null) {
            var2 = false;
         } else if (!(var1 instanceof zzcfs)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.f != var1.f) {
               var2 = false;
            } else if (this.d != var1.d) {
               var2 = false;
            } else if (this.e != var1.e) {
               var2 = false;
            } else if (this.c != var1.c) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      long var2 = Double.doubleToLongBits(this.d);
      int var1 = (int)(var2 ^ var2 >>> 32);
      var2 = Double.doubleToLongBits(this.e);
      return ((((var1 + 31) * 31 + (int)(var2 ^ var2 >>> 32)) * 31 + Float.floatToIntBits(this.f)) * 31 + this.c) * 31 + this.g;
   }

   @Override
   public final String toString() {
      Locale var2 = Locale.US;
      String var1;
      switch (this.c) {
         case 1:
            var1 = "CIRCLE";
            break;
         default:
            var1 = null;
      }

      return String.format(
         var2,
         "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]",
         var1,
         this.a.replaceAll("\\p{C}", "?"),
         this.g,
         this.d,
         this.e,
         this.f,
         this.h / 1000,
         this.i,
         this.b
      );
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a(), false);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, 4, this.d);
      zzbfp.a(var1, 5, this.e);
      zzbfp.a(var1, 6, this.f);
      zzbfp.a(var1, 7, this.g);
      zzbfp.a(var1, 8, this.h);
      zzbfp.a(var1, 9, this.i);
      zzbfp.a(var1, var2);
   }
}
