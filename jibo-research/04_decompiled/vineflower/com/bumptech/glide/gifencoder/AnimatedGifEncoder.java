package com.bumptech.glide.gifencoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Bitmap.Config;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

public class AnimatedGifEncoder {
   private int a;
   private int b;
   private Integer c = null;
   private int d;
   private int e = -1;
   private int f = 0;
   private boolean g = false;
   private OutputStream h;
   private Bitmap i;
   private byte[] j;
   private byte[] k;
   private int l;
   private byte[] m;
   private boolean[] n = new boolean[256];
   private int o = 7;
   private int p = -1;
   private boolean q = false;
   private boolean r = true;
   private boolean s = false;
   private int t = 10;
   private boolean u;

   private void a(String var1) throws IOException {
      for (int var2 = 0; var2 < var1.length(); var2++) {
         this.h.write((byte)var1.charAt(var2));
      }
   }

   private int b(int var1) {
      int var4 = 0;
      int var3;
      if (this.m == null) {
         var3 = -1;
      } else {
         int var5 = Color.red(var1);
         int var6 = Color.green(var1);
         int var8 = Color.blue(var1);
         int var2 = 16777216;
         int var7 = this.m.length;
         var1 = 0;

         while (true) {
            var3 = var1;
            if (var4 >= var7) {
               break;
            }

            byte[] var11 = this.m;
            int var10 = var4 + 1;
            var3 = var5 - (var11[var4] & 255);
            var11 = this.m;
            int var9 = var10 + 1;
            var10 = var6 - (var11[var10] & 255);
            var4 = var8 - (this.m[var9] & 255);
            var3 = var3 * var3 + var10 * var10 + var4 * var4;
            var4 = var9 / 3;
            if (this.n[var4] && var3 < var2) {
               var2 = var4;
               var1 = var3;
            } else {
               var3 = var2;
               var2 = var1;
               var1 = var3;
            }

            var3 = var2;
            var4 = var9 + 1;
            var2 = var1;
            var1 = var3;
         }
      }

      return var3;
   }

   private void b() {
      int var2 = this.j.length;
      int var4 = var2 / 3;
      this.k = new byte[var4];
      NeuQuant var8 = new NeuQuant(this.j, var2, this.t);
      this.m = var8.d();

      for (byte var10 = 0; var10 < this.m.length; var10 += 3) {
         byte var1 = this.m[var10];
         this.m[var10] = this.m[var10 + 2];
         this.m[var10 + 2] = var1;
         this.n[var10 / 3] = false;
      }

      var2 = 0;
      int var3 = 0;

      while (var2 < var4) {
         byte[] var9 = this.j;
         int var7 = var3 + 1;
         int var5 = var9[var3];
         var9 = this.j;
         int var6 = var7 + 1;
         byte var13 = var9[var7];
         var9 = this.j;
         var3 = var6 + 1;
         var5 = var8.a(var5 & 0xFF, var13 & 255, var9[var6] & 255);
         this.n[var5] = true;
         this.k[var2] = (byte)var5;
         var2++;
      }

      this.j = null;
      this.l = 8;
      this.o = 7;
      if (this.c != null) {
         this.d = this.b(this.c);
      } else if (this.u) {
         this.d = this.b(0);
      }
   }

   private void c() {
      boolean var10 = false;
      int var4 = this.i.getWidth();
      int var3 = this.i.getHeight();
      if (var4 != this.a || var3 != this.b) {
         Bitmap var11 = Bitmap.createBitmap(this.a, this.b, Config.ARGB_8888);
         new Canvas(var11).drawBitmap(var11, 0.0F, 0.0F, null);
         this.i = var11;
      }

      int[] var16 = new int[var4 * var3];
      this.i.getPixels(var16, 0, var4, 0, 0, var4, var3);
      this.j = new byte[var16.length * 3];
      this.u = false;
      int var7 = var16.length;
      var3 = 0;
      int var6 = 0;
      int var5 = 0;

      while (var3 < var7) {
         int var8 = var16[var3];
         var4 = var6;
         if (var8 == 0) {
            var4 = var6 + 1;
         }

         byte[] var12 = this.j;
         var6 = var5 + 1;
         var12[var5] = (byte)(var8 & 0xFF);
         var12 = this.j;
         int var9 = var6 + 1;
         var12[var6] = (byte)(var8 >> 8 & 0xFF);
         var12 = this.j;
         var5 = var9 + 1;
         var12[var9] = (byte)(var8 >> 16 & 0xFF);
         var3++;
         var6 = var4;
      }

      double var1 = (double)(var6 * 100) / var16.length;
      if (var1 > 4.0) {
         var10 = true;
      }

      this.u = var10;
      if (Log.isLoggable("AnimatedGifEncoder", 3)) {
         Log.d("AnimatedGifEncoder", "got pixels for frame with " + var1 + "% transparent pixels");
      }
   }

   private void c(int var1) throws IOException {
      this.h.write(var1 & 0xFF);
      this.h.write(var1 >> 8 & 0xFF);
   }

   private void d() throws IOException {
      this.h.write(33);
      this.h.write(249);
      this.h.write(4);
      int var1;
      byte var2;
      if (this.c == null && !this.u) {
         var1 = 0;
         var2 = 0;
      } else {
         var2 = 1;
         var1 = 2;
      }

      if (this.p >= 0) {
         var1 = this.p & 7;
      }

      this.h.write(var1 << 2 | 0 | 0 | var2);
      this.c(this.f);
      this.h.write(this.d);
      this.h.write(0);
   }

   private void e() throws IOException {
      this.h.write(44);
      this.c(0);
      this.c(0);
      this.c(this.a);
      this.c(this.b);
      if (this.r) {
         this.h.write(0);
      } else {
         this.h.write(this.o | 128);
      }
   }

   private void f() throws IOException {
      this.c(this.a);
      this.c(this.b);
      this.h.write(this.o | 240);
      this.h.write(0);
      this.h.write(0);
   }

   private void g() throws IOException {
      this.h.write(33);
      this.h.write(255);
      this.h.write(11);
      this.a("NETSCAPE2.0");
      this.h.write(3);
      this.h.write(1);
      this.c(this.e);
      this.h.write(0);
   }

   private void h() throws IOException {
      this.h.write(this.m, 0, this.m.length);
      int var2 = this.m.length;

      for (int var1 = 0; var1 < 768 - var2; var1++) {
         this.h.write(0);
      }
   }

   private void i() throws IOException {
      new LZWEncoder(this.a, this.b, this.k, this.l).b(this.h);
   }

   public void a(int var1) {
      this.f = Math.round(var1 / 10.0F);
   }

   public void a(int var1, int var2) {
      if (!this.g || this.r) {
         this.a = var1;
         this.b = var2;
         if (this.a < 1) {
            this.a = 320;
         }

         if (this.b < 1) {
            this.b = 240;
         }

         this.s = true;
      }
   }

   public boolean a() {
      boolean var1 = false;
      if (this.g) {
         this.g = false;

         label19: {
            try {
               this.h.write(59);
               this.h.flush();
               if (this.q) {
                  this.h.close();
               }
            } catch (IOException var3) {
               var1 = false;
               break label19;
            }

            var1 = true;
         }

         this.d = 0;
         this.h = null;
         this.i = null;
         this.j = null;
         this.k = null;
         this.m = null;
         this.q = false;
         this.r = true;
      }

      return var1;
   }

   public boolean a(Bitmap var1) {
      boolean var2;
      if (var1 != null && this.g) {
         var2 = true;

         try {
            if (!this.s) {
               this.a(var1.getWidth(), var1.getHeight());
            }

            this.i = var1;
            this.c();
            this.b();
            if (this.r) {
               this.f();
               this.h();
               if (this.e >= 0) {
                  this.g();
               }
            }

            this.d();
            this.e();
            if (!this.r) {
               this.h();
            }

            this.i();
            this.r = false;
         } catch (IOException var3) {
            var2 = false;
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   public boolean a(OutputStream var1) {
      boolean var2 = false;
      if (var1 != null) {
         var2 = true;
         this.q = false;
         this.h = var1;

         try {
            this.a("GIF89a");
         } catch (IOException var3) {
            var2 = false;
         }

         this.g = var2;
      }

      return var2;
   }
}
