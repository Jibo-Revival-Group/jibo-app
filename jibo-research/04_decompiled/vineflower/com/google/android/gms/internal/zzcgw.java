package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;

final class zzcgw {
   final String a;
   final String b;
   final long c;
   final long d;
   final long e;
   final long f;
   final Long g;
   final Long h;
   final Boolean i;

   zzcgw(String var1, String var2, long var3, long var5, long var7, long var9, Long var11, Long var12, Boolean var13) {
      zzbq.a(var1);
      zzbq.a(var2);
      boolean var14;
      if (var3 >= 0L) {
         var14 = true;
      } else {
         var14 = false;
      }

      zzbq.b(var14);
      if (var5 >= 0L) {
         var14 = true;
      } else {
         var14 = false;
      }

      zzbq.b(var14);
      if (var9 >= 0L) {
         var14 = true;
      } else {
         var14 = false;
      }

      zzbq.b(var14);
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var5;
      this.e = var7;
      this.f = var9;
      this.g = var11;
      this.h = var12;
      this.i = var13;
   }

   final zzcgw a() {
      return new zzcgw(this.a, this.b, this.c + 1L, this.d + 1L, this.e, this.f, this.g, this.h, this.i);
   }

   final zzcgw a(long var1) {
      return new zzcgw(this.a, this.b, this.c, this.d, var1, this.f, this.g, this.h, this.i);
   }

   final zzcgw a(Long var1, Long var2, Boolean var3) {
      if (var3 != null && !var3) {
         var3 = null;
      }

      return new zzcgw(this.a, this.b, this.c, this.d, this.e, this.f, var1, var2, var3);
   }

   final zzcgw b(long var1) {
      return new zzcgw(this.a, this.b, this.c, this.d, this.e, var1, this.g, this.h, this.i);
   }
}
