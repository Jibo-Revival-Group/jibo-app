package com.bumptech.glide.gifencoder;

import java.io.IOException;
import java.io.OutputStream;

class LZWEncoder {
   int a;
   int b = 12;
   int c;
   int d = 4096;
   int[] e = new int[5003];
   int[] f = new int[5003];
   int g = 5003;
   int h = 0;
   boolean i = false;
   int j;
   int k;
   int l;
   int m = 0;
   int n = 0;
   int[] o = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
   int p;
   byte[] q = new byte[256];
   private int r;
   private int s;
   private byte[] t;
   private int u;
   private int v;
   private int w;

   LZWEncoder(int var1, int var2, byte[] var3, int var4) {
      this.r = var1;
      this.s = var2;
      this.t = var3;
      this.u = Math.max(2, var4);
   }

   private int a() {
      int var1;
      if (this.v == 0) {
         var1 = -1;
      } else {
         this.v--;
         byte[] var2 = this.t;
         var1 = this.w++;
         var1 = var2[var1] & 255;
      }

      return var1;
   }

   void a(byte var1, OutputStream var2) throws IOException {
      byte[] var4 = this.q;
      int var3 = this.p++;
      var4[var3] = var1;
      if (this.p >= 254) {
         this.c(var2);
      }
   }

   void a(int var1) {
      for (int var2 = 0; var2 < var1; var2++) {
         this.e[var2] = -1;
      }
   }

   void a(int var1, OutputStream var2) throws IOException {
      int var4 = 0;
      this.j = var1;
      this.i = false;
      this.a = this.j;
      this.c = this.b(this.a);
      this.k = 1 << var1 - 1;
      this.l = this.k + 1;
      this.h = this.k + 2;
      this.p = 0;
      int var3 = this.a();

      for (int var11 = this.g; var11 < 65536; var11 *= 2) {
         var4++;
      }

      int var8 = this.g;
      this.a(var8);
      this.b(this.k, var2);
      var1 = var3;

      label44:
      while (true) {
         int var5 = this.a();
         if (var5 == -1) {
            this.b(var1, var2);
            this.b(this.l, var2);
            return;
         }

         int var9 = (var5 << this.b) + var1;
         var3 = var5 << 8 - var4 ^ var1;
         if (this.e[var3] == var9) {
            var1 = this.f[var3];
         } else {
            int var6 = var3;
            if (this.e[var3] >= 0) {
               var6 = var8 - var3;
               int var7 = var3;
               if (var3 == 0) {
                  var6 = 1;
                  var7 = var3;
               }

               do {
                  var7 -= var6;
                  var3 = var7;
                  if (var7 < 0) {
                     var3 = var7 + var8;
                  }

                  if (this.e[var3] == var9) {
                     var1 = this.f[var3];
                     continue label44;
                  }

                  var7 = var3;
               } while (this.e[var3] >= 0);

               var6 = var3;
            }

            this.b(var1, var2);
            if (this.h < this.d) {
               int[] var10 = this.f;
               var1 = this.h++;
               var10[var6] = var1;
               this.e[var6] = var9;
               var1 = var5;
            } else {
               this.a(var2);
               var1 = var5;
            }
         }
      }
   }

   void a(OutputStream var1) throws IOException {
      this.a(this.g);
      this.h = this.k + 2;
      this.i = true;
      this.b(this.k, var1);
   }

   final int b(int var1) {
      return (1 << var1) - 1;
   }

   void b(int var1, OutputStream var2) throws IOException {
      this.m = this.m & this.o[this.n];
      if (this.n > 0) {
         this.m = this.m | var1 << this.n;
      } else {
         this.m = var1;
      }

      for (this.n = this.n + this.a; this.n >= 8; this.n -= 8) {
         this.a((byte)(this.m & 0xFF), var2);
         this.m >>= 8;
      }

      if (this.h > this.c || this.i) {
         if (this.i) {
            int var3 = this.j;
            this.a = var3;
            this.c = this.b(var3);
            this.i = false;
         } else {
            this.a++;
            if (this.a == this.b) {
               this.c = this.d;
            } else {
               this.c = this.b(this.a);
            }
         }
      }

      if (var1 == this.l) {
         while (this.n > 0) {
            this.a((byte)(this.m & 0xFF), var2);
            this.m >>= 8;
            this.n -= 8;
         }

         this.c(var2);
      }
   }

   void b(OutputStream var1) throws IOException {
      var1.write(this.u);
      this.v = this.r * this.s;
      this.w = 0;
      this.a(this.u + 1, var1);
      var1.write(0);
   }

   void c(OutputStream var1) throws IOException {
      if (this.p > 0) {
         var1.write(this.p);
         var1.write(this.q, 0, this.p);
         this.p = 0;
      }
   }
}
