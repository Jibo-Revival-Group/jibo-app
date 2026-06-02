package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzcgl extends zzbfm {
   public static final Creator<zzcgl> CREATOR = new zzcgm();
   public String a;
   public String b;
   public zzcln c;
   public long d;
   public boolean e;
   public String f;
   public zzcha g;
   public long h;
   public zzcha i;
   public long j;
   public zzcha k;
   private int l;

   zzcgl(int var1, String var2, String var3, zzcln var4, long var5, boolean var7, String var8, zzcha var9, long var10, zzcha var12, long var13, zzcha var15) {
      this.l = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var7;
      this.f = var8;
      this.g = var9;
      this.h = var10;
      this.i = var12;
      this.j = var13;
      this.k = var15;
   }

   zzcgl(zzcgl var1) {
      this.l = 1;
      zzbq.a(var1);
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
      this.h = var1.h;
      this.i = var1.i;
      this.j = var1.j;
      this.k = var1.k;
   }

   zzcgl(String var1, String var2, zzcln var3, long var4, boolean var6, String var7, zzcha var8, long var9, zzcha var11, long var12, zzcha var14) {
      this.l = 1;
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var6;
      this.f = var7;
      this.g = var8;
      this.h = var9;
      this.i = var11;
      this.j = var12;
      this.k = var14;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.l);
      zzbfp.a(var1, 2, this.a, false);
      zzbfp.a(var1, 3, this.b, false);
      zzbfp.a(var1, 4, this.c, var2, false);
      zzbfp.a(var1, 5, this.d);
      zzbfp.a(var1, 6, this.e);
      zzbfp.a(var1, 7, this.f, false);
      zzbfp.a(var1, 8, this.g, var2, false);
      zzbfp.a(var1, 9, this.h);
      zzbfp.a(var1, 10, this.i, var2, false);
      zzbfp.a(var1, 11, this.j);
      zzbfp.a(var1, 12, this.k, var2, false);
      zzbfp.a(var1, var3);
   }
}
