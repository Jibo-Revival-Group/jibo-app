package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class LocationRequest extends zzbfm implements ReflectedParcelable {
   public static final Creator<LocationRequest> CREATOR = new zzw();
   private int a;
   private long b;
   private long c;
   private boolean d;
   private long e;
   private int f;
   private float g;
   private long h;

   public LocationRequest() {
      this.a = 102;
      this.b = 3600000L;
      this.c = 600000L;
      this.d = false;
      this.e = Long.MAX_VALUE;
      this.f = Integer.MAX_VALUE;
      this.g = 0.0F;
      this.h = 0L;
   }

   LocationRequest(int var1, long var2, long var4, boolean var6, long var7, int var9, float var10, long var11) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var6;
      this.e = var7;
      this.f = var9;
      this.g = var10;
      this.h = var11;
   }

   public final long a() {
      long var3 = this.h;
      long var1 = var3;
      if (var3 < this.b) {
         var1 = this.b;
      }

      return var1;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof LocationRequest)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.a != var1.a
               || this.b != var1.b
               || this.c != var1.c
               || this.d != var1.d
               || this.e != var1.e
               || this.f != var1.f
               || this.g != var1.g
               || this.a() != var1.a()) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b, this.g, this.h});
   }

   @Override
   public final String toString() {
      StringBuilder var7 = new StringBuilder();
      StringBuilder var6 = var7.append("Request[");
      String var5;
      switch (this.a) {
         case 100:
            var5 = "PRIORITY_HIGH_ACCURACY";
            break;
         case 101:
         case 103:
         default:
            var5 = "???";
            break;
         case 102:
            var5 = "PRIORITY_BALANCED_POWER_ACCURACY";
            break;
         case 104:
            var5 = "PRIORITY_LOW_POWER";
            break;
         case 105:
            var5 = "PRIORITY_NO_POWER";
      }

      var6.append(var5);
      if (this.a != 105) {
         var7.append(" requested=");
         var7.append(this.b).append("ms");
      }

      var7.append(" fastest=");
      var7.append(this.c).append("ms");
      if (this.h > this.b) {
         var7.append(" maxWait=");
         var7.append(this.h).append("ms");
      }

      if (this.g > 0.0F) {
         var7.append(" smallestDisplacement=");
         var7.append(this.g).append("m");
      }

      if (this.e != Long.MAX_VALUE) {
         long var3 = this.e;
         long var1 = SystemClock.elapsedRealtime();
         var7.append(" expireIn=");
         var7.append(var3 - var1).append("ms");
      }

      if (this.f != Integer.MAX_VALUE) {
         var7.append(" num=").append(this.f);
      }

      var7.append(']');
      return var7.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, 4, this.d);
      zzbfp.a(var1, 5, this.e);
      zzbfp.a(var1, 6, this.f);
      zzbfp.a(var1, 7, this.g);
      zzbfp.a(var1, 8, this.h);
      zzbfp.a(var1, var2);
   }
}
