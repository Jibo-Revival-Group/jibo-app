package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfku extends zzfjm<zzfku> {
   public String a = "";
   public String b = "";
   public long c = 0L;
   public String d = "";
   public long e = 0L;
   public long f = 0L;
   public String g = "";
   public String h = "";
   public String i = "";
   public String j = "";
   public String k = "";
   public int l = 0;
   public zzfkt[] m = zzfkt.a();

   public zzfku() {
      this.H = null;
      this.I = -1;
   }

   public static zzfku a(byte[] var0) throws zzfjr {
      return zzfjs.a(new zzfku(), var0);
   }

   @Override
   public final void a(zzfjk var1) throws IOException {
      if (this.a != null && !this.a.equals("")) {
         var1.a(1, this.a);
      }

      if (this.b != null && !this.b.equals("")) {
         var1.a(2, this.b);
      }

      if (this.c != 0L) {
         var1.b(3, this.c);
      }

      if (this.d != null && !this.d.equals("")) {
         var1.a(4, this.d);
      }

      if (this.e != 0L) {
         var1.b(5, this.e);
      }

      if (this.f != 0L) {
         var1.b(6, this.f);
      }

      if (this.g != null && !this.g.equals("")) {
         var1.a(7, this.g);
      }

      if (this.h != null && !this.h.equals("")) {
         var1.a(8, this.h);
      }

      if (this.i != null && !this.i.equals("")) {
         var1.a(9, this.i);
      }

      if (this.j != null && !this.j.equals("")) {
         var1.a(10, this.j);
      }

      if (this.k != null && !this.k.equals("")) {
         var1.a(11, this.k);
      }

      if (this.l != 0) {
         var1.a(12, this.l);
      }

      if (this.m != null && this.m.length > 0) {
         for (int var2 = 0; var2 < this.m.length; var2++) {
            zzfkt var3 = this.m[var2];
            if (var3 != null) {
               var1.a(13, var3);
            }
         }
      }

      super.a(var1);
   }

   @Override
   protected final int b() {
      int var2 = super.b();
      int var1 = var2;
      if (this.a != null) {
         var1 = var2;
         if (!this.a.equals("")) {
            var1 = var2 + zzfjk.b(1, this.a);
         }
      }

      var2 = var1;
      if (this.b != null) {
         var2 = var1;
         if (!this.b.equals("")) {
            var2 = var1 + zzfjk.b(2, this.b);
         }
      }

      var1 = var2;
      if (this.c != 0L) {
         var1 = var2 + zzfjk.d(3, this.c);
      }

      var2 = var1;
      if (this.d != null) {
         var2 = var1;
         if (!this.d.equals("")) {
            var2 = var1 + zzfjk.b(4, this.d);
         }
      }

      var1 = var2;
      if (this.e != 0L) {
         var1 = var2 + zzfjk.d(5, this.e);
      }

      int var3 = var1;
      if (this.f != 0L) {
         var3 = var1 + zzfjk.d(6, this.f);
      }

      var2 = var3;
      if (this.g != null) {
         var2 = var3;
         if (!this.g.equals("")) {
            var2 = var3 + zzfjk.b(7, this.g);
         }
      }

      var1 = var2;
      if (this.h != null) {
         var1 = var2;
         if (!this.h.equals("")) {
            var1 = var2 + zzfjk.b(8, this.h);
         }
      }

      var2 = var1;
      if (this.i != null) {
         var2 = var1;
         if (!this.i.equals("")) {
            var2 = var1 + zzfjk.b(9, this.i);
         }
      }

      var1 = var2;
      if (this.j != null) {
         var1 = var2;
         if (!this.j.equals("")) {
            var1 = var2 + zzfjk.b(10, this.j);
         }
      }

      var2 = var1;
      if (this.k != null) {
         var2 = var1;
         if (!this.k.equals("")) {
            var2 = var1 + zzfjk.b(11, this.k);
         }
      }

      var1 = var2;
      if (this.l != 0) {
         var1 = var2 + zzfjk.b(12, this.l);
      }

      var2 = var1;
      if (this.m != null) {
         var2 = var1;
         if (this.m.length > 0) {
            var2 = 0;

            while (var2 < this.m.length) {
               zzfkt var4 = this.m[var2];
               var3 = var1;
               if (var4 != null) {
                  var3 = var1 + zzfjk.b(13, var4);
               }

               var2++;
               var1 = var3;
            }

            var2 = var1;
         }
      }

      return var2;
   }
}
