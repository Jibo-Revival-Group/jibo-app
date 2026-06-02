package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzbt extends zzbfm {
   public static final Creator<zzbt> CREATOR = new zzbu();
   private int a;
   private IBinder b;
   private ConnectionResult c;
   private boolean d;
   private boolean e;

   zzbt(int var1, IBinder var2, ConnectionResult var3, boolean var4, boolean var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public final zzan a() {
      IBinder var2 = this.b;
      zzan var1;
      if (var2 == null) {
         var1 = null;
      } else {
         var1 = var2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
         if (var1 instanceof zzan) {
            var1 = var1;
         } else {
            var1 = new zzap(var2);
         }
      }

      return var1;
   }

   public final ConnectionResult b() {
      return this.c;
   }

   public final boolean c() {
      return this.d;
   }

   public final boolean d() {
      return this.e;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof zzbt)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.c.equals(var1.c) || !this.a().equals(var1.a())) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, false);
      zzbfp.a(var1, 3, this.c, var2, false);
      zzbfp.a(var1, 4, this.d);
      zzbfp.a(var1, 5, this.e);
      zzbfp.a(var1, var3);
   }
}
