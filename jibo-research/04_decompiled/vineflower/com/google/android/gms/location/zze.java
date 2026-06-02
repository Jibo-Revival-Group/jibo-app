package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class zze extends zzbfm {
   public static final Creator<zze> CREATOR = new zzf();
   private boolean a;
   private long b;
   private float c;
   private long d;
   private int e;

   public zze() {
      this(true, 50L, 0.0F, Long.MAX_VALUE, Integer.MAX_VALUE);
   }

   zze(boolean var1, long var2, float var4, long var5, int var7) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var5;
      this.e = var7;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof zze)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.a != var1.a || this.b != var1.b || Float.compare(this.c, var1.c) != 0 || this.d != var1.d || this.e != var1.e) {
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
      StringBuilder var5 = new StringBuilder();
      var5.append("DeviceOrientationRequest[mShouldUseMag=").append(this.a);
      var5.append(" mMinimumSamplingPeriodMs=").append(this.b);
      var5.append(" mSmallestAngleChangeRadians=").append(this.c);
      if (this.d != Long.MAX_VALUE) {
         long var3 = this.d;
         long var1 = SystemClock.elapsedRealtime();
         var5.append(" expireIn=");
         var5.append(var3 - var1).append("ms");
      }

      if (this.e != Integer.MAX_VALUE) {
         var5.append(" num=").append(this.e);
      }

      var5.append(']');
      return var5.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, 4, this.d);
      zzbfp.a(var1, 5, this.e);
      zzbfp.a(var1, var2);
   }
}
