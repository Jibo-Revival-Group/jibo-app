package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbq;

public final class zzcib {
   private String a;
   private final String b;
   private final String c;
   private final long d;
   private zzchx e;

   private zzcib(zzchx var1, String var2, long var3) {
      this.e = var1;
      super();
      zzbq.a(var2);
      boolean var5;
      if (var3 > 0L) {
         var5 = true;
      } else {
         var5 = false;
      }

      zzbq.b(var5);
      this.a = String.valueOf(var2).concat(":start");
      this.b = String.valueOf(var2).concat(":count");
      this.c = String.valueOf(var2).concat(":value");
      this.d = var3;
   }

   private final void b() {
      this.e.c();
      long var1 = this.e.k().a();
      Editor var3 = zzchx.a(this.e).edit();
      var3.remove(this.b);
      var3.remove(this.c);
      var3.putLong(this.a, var1);
      var3.apply();
   }

   private final long c() {
      return zzchx.a(this.e).getLong(this.a, 0L);
   }

   public final Pair<String, Long> a() {
      this.e.c();
      this.e.c();
      long var1 = this.c();
      if (var1 == 0L) {
         this.b();
         var1 = 0L;
      } else {
         var1 = Math.abs(var1 - this.e.k().a());
      }

      Pair var3;
      if (var1 < this.d) {
         var3 = null;
      } else if (var1 > this.d << 1) {
         this.b();
         var3 = null;
      } else {
         String var6 = zzchx.a(this.e).getString(this.c, null);
         var1 = zzchx.a(this.e).getLong(this.b, 0L);
         this.b();
         if (var6 != null && var1 > 0L) {
            var3 = new Pair(var6, var1);
         } else {
            var3 = zzchx.a;
         }
      }

      return var3;
   }

   public final void a(String var1, long var2) {
      this.e.c();
      if (this.c() == 0L) {
         this.b();
      }

      String var5 = var1;
      if (var1 == null) {
         var5 = "";
      }

      var2 = zzchx.a(this.e).getLong(this.b, 0L);
      if (var2 <= 0L) {
         Editor var6 = zzchx.a(this.e).edit();
         var6.putString(this.c, var5);
         var6.putLong(this.b, 1L);
         var6.apply();
      } else {
         boolean var4;
         if ((this.e.p().z().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / (var2 + 1L)) {
            var4 = true;
         } else {
            var4 = false;
         }

         Editor var7 = zzchx.a(this.e).edit();
         if (var4) {
            var7.putString(this.c, var5);
         }

         var7.putLong(this.b, var2 + 1L);
         var7.apply();
      }
   }
}
