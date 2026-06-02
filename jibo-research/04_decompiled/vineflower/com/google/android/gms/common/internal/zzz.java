package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzz extends zzbfm {
   public static final Creator<zzz> CREATOR = new zzaa();
   String a;
   IBinder b;
   Scope[] c;
   Bundle d;
   Account e;
   com.google.android.gms.common.zzc[] f;
   private int g = 3;
   private int h;
   private int i = com.google.android.gms.common.zzf.b;

   public zzz(int var1) {
      this.h = var1;
   }

   zzz(int var1, int var2, int var3, String var4, IBinder var5, Scope[] var6, Bundle var7, Account var8, com.google.android.gms.common.zzc[] var9) {
      Object var11 = null;
      Object var10 = null;
      super();
      this.g = var1;
      this.h = var2;
      this.i = var3;
      if ("com.google.android.gms".equals(var4)) {
         this.a = "com.google.android.gms";
      } else {
         this.a = var4;
      }

      if (var1 < 2) {
         Account var12 = (Account)var11;
         if (var5 != null) {
            zzan var13;
            if (var5 == null) {
               var13 = (zzan)var10;
            } else {
               IInterface var14 = var5.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
               if (var14 instanceof zzan) {
                  var13 = (zzan)var14;
               } else {
                  var13 = new zzap(var5);
               }
            }

            var12 = zza.a(var13);
         }

         this.e = var12;
      } else {
         this.b = var5;
         this.e = var8;
      }

      this.c = var6;
      this.d = var7;
      this.f = var9;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.g);
      zzbfp.a(var1, 2, this.h);
      zzbfp.a(var1, 3, this.i);
      zzbfp.a(var1, 4, this.a, false);
      zzbfp.a(var1, 5, this.b, false);
      zzbfp.a(var1, 6, this.c, var2, false);
      zzbfp.a(var1, 7, this.d, false);
      zzbfp.a(var1, 8, this.e, var2, false);
      zzbfp.a(var1, 10, this.f, var2, false);
      zzbfp.a(var1, var3);
   }
}
