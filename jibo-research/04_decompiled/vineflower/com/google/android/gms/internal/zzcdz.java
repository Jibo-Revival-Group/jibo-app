package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.zzm;
import com.google.android.gms.location.zzn;

public final class zzcdz extends zzbfm {
   public static final Creator<zzcdz> CREATOR = new zzcea();
   private int a;
   private zzcdx b;
   private zzm c;
   private zzceu d;

   zzcdz(int var1, zzcdx var2, IBinder var3, IBinder var4) {
      Object var5 = null;
      super();
      this.a = var1;
      this.b = var2;
      zzm var6;
      if (var3 == null) {
         var6 = null;
      } else {
         var6 = zzn.a(var3);
      }

      this.c = var6;
      zzceu var7;
      if (var4 == null) {
         var7 = (zzceu)var5;
      } else {
         var7 = (zzceu)var5;
         if (var4 != null) {
            IInterface var8 = var4.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (var8 instanceof zzceu) {
               var7 = (zzceu)var8;
            } else {
               var7 = new zzcew(var4);
            }
         }
      }

      this.d = var7;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Object var5 = null;
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, var2, false);
      IBinder var4;
      if (this.c == null) {
         var4 = null;
      } else {
         var4 = this.c.asBinder();
      }

      zzbfp.a(var1, 3, var4, false);
      if (this.d == null) {
         var4 = (IBinder)var5;
      } else {
         var4 = this.d.asBinder();
      }

      zzbfp.a(var1, 4, var4, false);
      zzbfp.a(var1, var3);
   }
}
