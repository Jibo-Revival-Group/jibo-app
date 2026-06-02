package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfjj {
   private final byte[] a;
   private final int b;
   private final int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h = Integer.MAX_VALUE;
   private int i;
   private int j = 64;
   private int k = 67108864;

   private zzfjj(byte[] var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      var3 = var2 + var3;
      this.d = var3;
      this.c = var3;
      this.f = var2;
   }

   public static zzfjj a(byte[] var0, int var1, int var2) {
      return new zzfjj(var0, 0, var2);
   }

   private final void f(int var1) throws IOException {
      if (var1 < 0) {
         throw zzfjr.b();
      }

      if (this.f + var1 > this.h) {
         this.f(this.h - this.f);
         throw zzfjr.a();
      }

      if (var1 <= this.d - this.f) {
         this.f += var1;
      } else {
         throw zzfjr.a();
      }
   }

   private final void n() {
      this.d = this.d + this.e;
      int var1 = this.d;
      if (var1 > this.h) {
         this.e = var1 - this.h;
         this.d = this.d - this.e;
      } else {
         this.e = 0;
      }
   }

   private final byte o() throws IOException {
      if (this.f == this.d) {
         throw zzfjr.a();
      }

      byte[] var2 = this.a;
      int var1 = this.f++;
      return var2[var1];
   }

   public final int a() throws IOException {
      int var1 = 0;
      if (this.f == this.d) {
         this.g = 0;
      } else {
         this.g = this.h();
         if (this.g == 0) {
            throw new zzfjr("Protocol message contained an invalid tag (zero).");
         }

         var1 = this.g;
      }

      return var1;
   }

   public final void a(int var1) throws zzfjr {
      if (this.g != var1) {
         throw new zzfjr("Protocol message end-group tag did not match expected tag.");
      }
   }

   public final void a(zzfjs var1) throws IOException {
      int var2 = this.h();
      if (this.i >= this.j) {
         throw zzfjr.d();
      }

      var2 = this.c(var2);
      this.i++;
      var1.a(this);
      this.a(0);
      this.i--;
      this.d(var2);
   }

   public final byte[] a(int var1, int var2) {
      byte[] var4;
      if (var2 == 0) {
         var4 = zzfjv.h;
      } else {
         var4 = new byte[var2];
         int var3 = this.b;
         System.arraycopy(this.a, var3 + var1, var4, 0, var2);
      }

      return var4;
   }

   public final long b() throws IOException {
      return this.i();
   }

   final void b(int var1, int var2) {
      if (var1 > this.f - this.b) {
         var2 = this.f;
         int var3 = this.b;
         throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(var1).append(" is beyond current ").append(var2 - var3).toString());
      }

      if (var1 < 0) {
         throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(var1).toString());
      }

      this.f = this.b + var1;
      this.g = var2;
   }

   public final boolean b(int var1) throws IOException {
      boolean var3 = true;
      switch (var1 & 7) {
         case 0:
            this.h();
            break;
         case 1:
            this.k();
            break;
         case 2:
            this.f(this.h());
            break;
         case 3:
            int var2;
            do {
               var2 = this.a();
            } while (var2 != 0 && this.b(var2));

            this.a(var1 >>> 3 << 3 | 4);
            break;
         case 4:
            var3 = false;
            break;
         case 5:
            this.j();
            break;
         default:
            throw new zzfjr("Protocol message tag had invalid wire type.");
      }

      return var3;
   }

   public final int c() throws IOException {
      return this.h();
   }

   public final int c(int var1) throws zzfjr {
      if (var1 < 0) {
         throw zzfjr.b();
      }

      var1 = this.f + var1;
      int var2 = this.h;
      if (var1 > var2) {
         throw zzfjr.a();
      }

      this.h = var1;
      this.n();
      return var2;
   }

   public final void d(int var1) {
      this.h = var1;
      this.n();
   }

   public final boolean d() throws IOException {
      boolean var1;
      if (this.h() != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final String e() throws IOException {
      int var1 = this.h();
      if (var1 < 0) {
         throw zzfjr.b();
      }

      if (var1 > this.d - this.f) {
         throw zzfjr.a();
      }

      String var2 = new String(this.a, this.f, var1, zzfjq.a);
      this.f += var1;
      return var2;
   }

   public final void e(int var1) {
      this.b(var1, this.g);
   }

   public final byte[] f() throws IOException {
      int var1 = this.h();
      if (var1 < 0) {
         throw zzfjr.b();
      }

      byte[] var2;
      if (var1 == 0) {
         var2 = zzfjv.h;
      } else {
         if (var1 > this.d - this.f) {
            throw zzfjr.a();
         }

         var2 = new byte[var1];
         System.arraycopy(this.a, this.f, var2, 0, var1);
         this.f += var1;
      }

      return var2;
   }

   public final long g() throws IOException {
      long var1 = this.i();
      return -(var1 & 1L) ^ var1 >>> 1;
   }

   public final int h() throws IOException {
      int var1 = this.o();
      if (var1 < 0) {
         int var2 = var1 & 127;
         int var4 = this.o();
         if (var4 >= 0) {
            var1 = var2 | var4 << 7;
         } else {
            var4 = var2 | (var4 & 127) << 7;
            int var7 = this.o();
            if (var7 >= 0) {
               var1 = var4 | var7 << 14;
            } else {
               var4 |= (var7 & 127) << 14;
               int var3 = this.o();
               if (var3 >= 0) {
                  var1 = var4 | var3 << 21;
               } else {
                  var7 = this.o();
                  var3 = var4 | (var3 & 127) << 21 | var7 << 28;
                  var1 = var3;
                  if (var7 < 0) {
                     var7 = 0;

                     while (true) {
                        if (var7 >= 5) {
                           throw zzfjr.c();
                        }

                        var1 = var3;
                        if (this.o() >= 0) {
                           break;
                        }

                        var7++;
                     }
                  }
               }
            }
         }
      }

      return var1;
   }

   public final long i() throws IOException {
      byte var1 = 0;
      long var3 = 0L;

      while (var1 < 64) {
         byte var2 = this.o();
         var3 |= (long)(var2 & 127) << var1;
         if ((var2 & 128) == 0) {
            return var3;
         }

         var1 += 7;
      }

      throw zzfjr.c();
   }

   public final int j() throws IOException {
      return this.o() & 0xFF | (this.o() & 0xFF) << 8 | (this.o() & 0xFF) << 16 | (this.o() & 0xFF) << 24;
   }

   public final long k() throws IOException {
      byte var4 = this.o();
      byte var7 = this.o();
      byte var5 = this.o();
      byte var1 = this.o();
      byte var2 = this.o();
      byte var6 = this.o();
      byte var8 = this.o();
      byte var3 = this.o();
      long var9 = var4;
      return (var7 & 255L) << 8
         | var9 & 255L
         | (var5 & 255L) << 16
         | (var1 & 255L) << 24
         | (var2 & 255L) << 32
         | (var6 & 255L) << 40
         | (var8 & 255L) << 48
         | (var3 & 255L) << 56;
   }

   public final int l() {
      int var1;
      if (this.h == Integer.MAX_VALUE) {
         var1 = -1;
      } else {
         var1 = this.f;
         var1 = this.h - var1;
      }

      return var1;
   }

   public final int m() {
      return this.f - this.b;
   }
}
