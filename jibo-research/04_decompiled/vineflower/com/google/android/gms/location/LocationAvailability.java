package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class LocationAvailability extends zzbfm implements ReflectedParcelable {
   public static final Creator<LocationAvailability> CREATOR = new zzv();
   @Deprecated
   private int a;
   @Deprecated
   private int b;
   private long c;
   private int d;
   private zzae[] e;

   LocationAvailability(int var1, int var2, int var3, long var4, zzae[] var6) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.e = var6;
   }

   public final boolean a() {
      boolean var1;
      if (this.d < 1000) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (this.a != var1.a || this.b != var1.b || this.c != var1.c || this.d != var1.d || !Arrays.equals(this.e, var1.e)) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.d, this.a, this.b, this.c, this.e});
   }

   @Override
   public final String toString() {
      boolean var1 = this.a();
      return new StringBuilder(48).append("LocationAvailability[isLocationAvailable: ").append(var1).append("]").toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, 4, this.d);
      zzbfp.a(var1, 5, this.e, var2, false);
      zzbfp.a(var1, var3);
   }
}
