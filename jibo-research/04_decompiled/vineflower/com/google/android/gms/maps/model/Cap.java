package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public class Cap extends zzbfm {
   public static final Creator<Cap> CREATOR = new zzb();
   private static final String a = Cap.class.getSimpleName();
   private final int b;
   private final BitmapDescriptor c;
   private final Float d;

   protected Cap(int var1) {
      this(var1, (BitmapDescriptor)null, null);
   }

   Cap(int var1, IBinder var2, Float var3) {
      BitmapDescriptor var4;
      if (var2 == null) {
         var4 = null;
      } else {
         var4 = new BitmapDescriptor(IObjectWrapper.zza.a(var2));
      }

      this(var1, var4, var3);
   }

   private Cap(int var1, BitmapDescriptor var2, Float var3) {
      boolean var4;
      if (var3 != null && var3 > 0.0F) {
         var4 = true;
      } else {
         var4 = false;
      }

      boolean var5;
      if (var1 == 3 && (var2 == null || !var4)) {
         var5 = false;
      } else {
         var5 = true;
      }

      zzbq.b(var5, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", var1, var2, var3));
      this.b = var1;
      this.c = var2;
      this.d = var3;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof Cap)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.b != var1.b || !zzbg.a(this.c, var1.c) || !zzbg.a(this.d, var1.d)) {
               var2 = false;
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
      int var1 = this.b;
      return new StringBuilder(23).append("[Cap: type=").append(var1).append("]").toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.b);
      IBinder var3;
      if (this.c == null) {
         var3 = null;
      } else {
         var3 = this.c.a().asBinder();
      }

      zzbfp.a(var1, 3, var3, false);
      zzbfp.a(var1, 4, this.d, false);
      zzbfp.a(var1, var2);
   }
}
