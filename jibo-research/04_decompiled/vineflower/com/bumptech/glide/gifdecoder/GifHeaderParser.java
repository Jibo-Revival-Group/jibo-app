package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class GifHeaderParser {
   private final byte[] a = new byte[256];
   private ByteBuffer b;
   private GifHeader c;
   private int d = 0;

   private int[] a(int var1) {
      int var2 = 0;
      byte[] var9 = new byte[var1 * 3];

      int[] var8;
      try {
         this.b.get(var9);
         var8 = new int[256];
      } catch (BufferUnderflowException var10) {
         Object var7 = null;
         if (Log.isLoggable("GifHeaderParser", 3)) {
            Log.d("GifHeaderParser", "Format Error Reading Color Table", var10);
         }

         this.c.b = 1;
         return (int[])var7;
      }

      int var3 = 0;

      while (true) {
         int[] var12 = var8;
         if (var2 >= var1) {
            return var12;
         }

         int var6 = var3 + 1;
         byte var5 = var9[var3];
         int var4 = var6 + 1;
         byte var11 = var9[var6];
         var3 = var4 + 1;
         var8[var2] = (var5 & 255) << 16 | 0xFF000000 | (var11 & 255) << 8 | var9[var4] & 255;
         var2++;
      }
   }

   private void c() {
      this.b = null;
      Arrays.fill(this.a, (byte)0);
      this.c = new GifHeader();
      this.d = 0;
   }

   private void d() {
      boolean var1 = false;

      while (!var1 && !this.o()) {
         switch (this.m()) {
            case 33:
               switch (this.m()) {
                  case 1:
                     this.k();
                     continue;
                  case 249:
                     this.c.d = new GifFrame();
                     this.e();
                     continue;
                  case 254:
                     this.k();
                     continue;
                  case 255:
                     this.l();
                     String var3 = "";

                     for (int var2 = 0; var2 < 11; var2++) {
                        var3 = var3 + (char)this.a[var2];
                     }

                     if (var3.equals("NETSCAPE2.0")) {
                        this.g();
                     } else {
                        this.k();
                     }
                     continue;
                  default:
                     this.k();
                     continue;
               }
            case 44:
               if (this.c.d == null) {
                  this.c.d = new GifFrame();
               }

               this.f();
               break;
            case 59:
               var1 = true;
               break;
            default:
               this.c.b = 1;
         }
      }
   }

   private void e() {
      boolean var3 = true;
      this.m();
      int var1 = this.m();
      this.c.d.g = (var1 & 28) >> 2;
      if (this.c.d.g == 0) {
         this.c.d.g = 1;
      }

      GifFrame var4 = this.c.d;
      if ((var1 & 1) == 0) {
         var3 = false;
      }

      var4.f = var3;
      int var2 = this.n();
      var1 = var2;
      if (var2 < 3) {
         var1 = 10;
      }

      this.c.d.i = var1 * 10;
      this.c.d.h = this.m();
      this.m();
   }

   private void f() {
      boolean var4 = true;
      this.c.d.a = this.n();
      this.c.d.b = this.n();
      this.c.d.c = this.n();
      this.c.d.d = this.n();
      int var2 = this.m();
      boolean var1;
      if ((var2 & 128) != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      int var3 = (int)Math.pow(2.0, (var2 & 7) + 1);
      GifFrame var5 = this.c.d;
      if ((var2 & 64) == 0) {
         var4 = false;
      }

      var5.e = var4;
      if (var1) {
         this.c.d.k = this.a(var3);
      } else {
         this.c.d.k = null;
      }

      this.c.d.j = this.b.position();
      this.j();
      if (!this.o()) {
         GifHeader var6 = this.c;
         var6.c++;
         this.c.e.add(this.c.d);
      }
   }

   private void g() {
      do {
         this.l();
         if (this.a[0] == 1) {
            byte var2 = this.a[1];
            byte var1 = this.a[2];
            this.c.m = var2 & 255 | (var1 & 255) << 8;
         }
      } while (this.d > 0 && !this.o());
   }

   private void h() {
      String var2 = "";

      for (int var1 = 0; var1 < 6; var1++) {
         var2 = var2 + (char)this.m();
      }

      if (!var2.startsWith("GIF")) {
         this.c.b = 1;
      } else {
         this.i();
         if (this.c.h && !this.o()) {
            this.c.a = this.a(this.c.i);
            this.c.l = this.c.a[this.c.j];
         }
      }
   }

   private void i() {
      this.c.f = this.n();
      this.c.g = this.n();
      int var1 = this.m();
      GifHeader var3 = this.c;
      boolean var2;
      if ((var1 & 128) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      var3.h = var2;
      this.c.i = 2 << (var1 & 7);
      this.c.j = this.m();
      this.c.k = this.m();
   }

   private void j() {
      this.m();
      this.k();
   }

   private void k() {
      int var1;
      do {
         var1 = this.m();
         ((Buffer)this.b).position(this.b.position() + var1);
      } while (var1 > 0);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private int l() {
      int var3 = 0;
      int var1 = 0;
      this.d = this.m();
      if (this.d > 0) {
         int var2 = 0;

         while (true) {
            int var4 = var2;
            var3 = var1;

            label42: {
               label41: {
                  Exception var5;
                  label50: {
                     try {
                        if (var1 >= this.d) {
                           break;
                        }
                     } catch (Exception var8) {
                        var5 = var8;
                        if (!Log.isLoggable("GifHeaderParser", 3)) {
                           break label41;
                        }
                        break label50;
                     }

                     var4 = var2;

                     try {
                        var2 = this.d - var1;
                     } catch (Exception var7) {
                        var5 = var7;
                        if (!Log.isLoggable("GifHeaderParser", 3)) {
                           break label41;
                        }
                        break label50;
                     }

                     var4 = var2;

                     try {
                        this.b.get(this.a, var1, var2);
                        break label42;
                     } catch (Exception var6) {
                        var5 = var6;
                        if (!Log.isLoggable("GifHeaderParser", 3)) {
                           break label41;
                        }
                     }
                  }

                  Log.d("GifHeaderParser", "Error Reading Block n: " + var1 + " count: " + var4 + " blockSize: " + this.d, var5);
               }

               this.c.b = 1;
               var3 = var1;
               break;
            }

            var1 += var2;
         }
      }

      return var3;
   }

   private int m() {
      byte var1 = 0;

      byte var2;
      try {
         var2 = this.b.get();
      } catch (Exception var4) {
         this.c.b = 1;
         return var1;
      }

      return var2 & 0xFF;
   }

   private int n() {
      return this.b.getShort();
   }

   private boolean o() {
      boolean var1;
      if (this.c.b != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public GifHeaderParser a(byte[] var1) {
      this.c();
      if (var1 != null) {
         this.b = ByteBuffer.wrap(var1);
         ((Buffer)this.b).rewind();
         this.b.order(ByteOrder.LITTLE_ENDIAN);
      } else {
         this.b = null;
         this.c.b = 2;
      }

      return this;
   }

   public void a() {
      this.b = null;
      this.c = null;
   }

   public GifHeader b() {
      if (this.b == null) {
         throw new IllegalStateException("You must call setData() before parseHeader()");
      }

      GifHeader var1;
      if (this.o()) {
         var1 = this.c;
      } else {
         this.h();
         if (!this.o()) {
            this.d();
            if (this.c.c < 0) {
               this.c.b = 1;
            }
         }

         var1 = this.c;
      }

      return var1;
   }
}
