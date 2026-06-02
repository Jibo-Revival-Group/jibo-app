package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;

public final class zzcgi extends zzbfm {
   public static final Creator<zzcgi> CREATOR = new zzcgj();
   public final String a;
   public final String b;
   public final String c;
   public final String d;
   public final long e;
   public final long f;
   public final String g;
   public final boolean h;
   public final boolean i;
   public final long j;
   public final String k;
   public final long l;
   public final long m;
   public final int n;
   public final boolean o;

   zzcgi(
      String var1,
      String var2,
      String var3,
      long var4,
      String var6,
      long var7,
      long var9,
      String var11,
      boolean var12,
      boolean var13,
      String var14,
      long var15,
      long var17,
      int var19,
      boolean var20
   ) {
      zzbq.a(var1);
      this.a = var1;
      var1 = var2;
      if (TextUtils.isEmpty(var2)) {
         var1 = null;
      }

      this.b = var1;
      this.c = var3;
      this.j = var4;
      this.d = var6;
      this.e = var7;
      this.f = var9;
      this.g = var11;
      this.h = var12;
      this.i = var13;
      this.k = var14;
      this.l = var15;
      this.m = var17;
      this.n = var19;
      this.o = var20;
   }

   zzcgi(
      String var1,
      String var2,
      String var3,
      String var4,
      long var5,
      long var7,
      String var9,
      boolean var10,
      boolean var11,
      long var12,
      String var14,
      long var15,
      long var17,
      int var19,
      boolean var20
   ) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.j = var12;
      this.d = var4;
      this.e = var5;
      this.f = var7;
      this.g = var9;
      this.h = var10;
      this.i = var11;
      this.k = var14;
      this.l = var15;
      this.m = var17;
      this.n = var19;
      this.o = var20;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a, false);
      zzbfp.a(var1, 3, this.b, false);
      zzbfp.a(var1, 4, this.c, false);
      zzbfp.a(var1, 5, this.d, false);
      zzbfp.a(var1, 6, this.e);
      zzbfp.a(var1, 7, this.f);
      zzbfp.a(var1, 8, this.g, false);
      zzbfp.a(var1, 9, this.h);
      zzbfp.a(var1, 10, this.i);
      zzbfp.a(var1, 11, this.j);
      zzbfp.a(var1, 12, this.k, false);
      zzbfp.a(var1, 13, this.l);
      zzbfp.a(var1, 14, this.m);
      zzbfp.a(var1, 15, this.n);
      zzbfp.a(var1, 16, this.o);
      zzbfp.a(var1, var2);
   }
}
