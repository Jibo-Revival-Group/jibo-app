package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.zzp;
import com.google.android.gms.location.zzq;
import com.google.android.gms.location.zzs;
import com.google.android.gms.location.zzt;

public final class zzcfq extends zzbfm {
   public static final Creator<zzcfq> CREATOR = new zzcfr();
   private int a;
   private zzcfo b;
   private zzs c;
   private PendingIntent d;
   private zzp e;
   private zzceu f;

   zzcfq(int var1, zzcfo var2, IBinder var3, PendingIntent var4, IBinder var5, IBinder var6) {
      Object var7 = null;
      super();
      this.a = var1;
      this.b = var2;
      zzs var8;
      if (var3 == null) {
         var8 = null;
      } else {
         var8 = zzt.a(var3);
      }

      this.c = var8;
      this.d = var4;
      zzp var9;
      if (var5 == null) {
         var9 = null;
      } else {
         var9 = zzq.a(var5);
      }

      this.e = var9;
      zzceu var10;
      if (var6 == null) {
         var10 = (zzceu)var7;
      } else {
         var10 = (zzceu)var7;
         if (var6 != null) {
            IInterface var11 = var6.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (var11 instanceof zzceu) {
               var10 = (zzceu)var11;
            } else {
               var10 = new zzcew(var6);
            }
         }
      }

      this.f = var10;
   }

   public static zzcfq a(zzp var0, zzceu var1) {
      IBinder var2 = var0.asBinder();
      IBinder var3;
      if (var1 != null) {
         var3 = var1.asBinder();
      } else {
         var3 = null;
      }

      return new zzcfq(2, null, null, null, var2, var3);
   }

   public static zzcfq a(zzs var0, zzceu var1) {
      IBinder var2 = var0.asBinder();
      IBinder var3;
      if (var1 != null) {
         var3 = var1.asBinder();
      } else {
         var3 = null;
      }

      return new zzcfq(2, null, var2, null, null, var3);
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
      zzbfp.a(var1, 4, this.d, var2, false);
      if (this.e == null) {
         var4 = null;
      } else {
         var4 = this.e.asBinder();
      }

      zzbfp.a(var1, 5, var4, false);
      if (this.f == null) {
         var4 = (IBinder)var5;
      } else {
         var4 = this.f.asBinder();
      }

      zzbfp.a(var1, 6, var4, false);
      zzbfp.a(var1, var3);
   }
}
