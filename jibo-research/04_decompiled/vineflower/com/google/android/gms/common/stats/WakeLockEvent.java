package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbfp;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
   public static final Creator<WakeLockEvent> CREATOR = new zzd();
   private int a;
   private final long b;
   private int c;
   private final String d;
   private final String e;
   private final String f;
   private final int g;
   private final List<String> h;
   private final String i;
   private final long j;
   private int k;
   private final String l;
   private final float m;
   private final long n;
   private long o;

   WakeLockEvent(
      int var1,
      long var2,
      int var4,
      String var5,
      int var6,
      List<String> var7,
      String var8,
      long var9,
      int var11,
      String var12,
      String var13,
      float var14,
      long var15,
      String var17
   ) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var5;
      this.e = var12;
      this.f = var17;
      this.g = var6;
      this.o = -1L;
      this.h = var7;
      this.i = var8;
      this.j = var9;
      this.k = var11;
      this.l = var13;
      this.m = var14;
      this.n = var15;
   }

   @Override
   public final long a() {
      return this.b;
   }

   @Override
   public final int b() {
      return this.c;
   }

   @Override
   public final long c() {
      return this.o;
   }

   @Override
   public final String d() {
      String var8 = this.d;
      int var2 = this.g;
      String var4;
      if (this.h == null) {
         var4 = "";
      } else {
         var4 = TextUtils.join(",", this.h);
      }

      int var3 = this.k;
      String var5;
      if (this.e == null) {
         var5 = "";
      } else {
         var5 = this.e;
      }

      String var6;
      if (this.l == null) {
         var6 = "";
      } else {
         var6 = this.l;
      }

      float var1 = this.m;
      String var7;
      if (this.f == null) {
         var7 = "";
      } else {
         var7 = this.f;
      }

      return new StringBuilder(
            String.valueOf("\t").length()
               + 37
               + String.valueOf(var8).length()
               + String.valueOf("\t").length()
               + String.valueOf("\t").length()
               + String.valueOf(var4).length()
               + String.valueOf("\t").length()
               + String.valueOf("\t").length()
               + String.valueOf(var5).length()
               + String.valueOf("\t").length()
               + String.valueOf(var6).length()
               + String.valueOf("\t").length()
               + String.valueOf("\t").length()
               + String.valueOf(var7).length()
         )
         .append("\t")
         .append(var8)
         .append("\t")
         .append(var2)
         .append("\t")
         .append(var4)
         .append("\t")
         .append(var3)
         .append("\t")
         .append(var5)
         .append("\t")
         .append(var6)
         .append("\t")
         .append(var1)
         .append("\t")
         .append(var7)
         .toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.a());
      zzbfp.a(var1, 4, this.d, false);
      zzbfp.a(var1, 5, this.g);
      zzbfp.b(var1, 6, this.h, false);
      zzbfp.a(var1, 8, this.j);
      zzbfp.a(var1, 10, this.e, false);
      zzbfp.a(var1, 11, this.b());
      zzbfp.a(var1, 12, this.i, false);
      zzbfp.a(var1, 13, this.l, false);
      zzbfp.a(var1, 14, this.k);
      zzbfp.a(var1, 15, this.m);
      zzbfp.a(var1, 16, this.n);
      zzbfp.a(var1, 17, this.f, false);
      zzbfp.a(var1, var2);
   }
}
