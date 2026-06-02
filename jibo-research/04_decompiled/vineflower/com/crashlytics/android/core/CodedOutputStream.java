package com.crashlytics.android.core;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class CodedOutputStream implements Flushable {
   private final byte[] a;
   private final int b;
   private int c;
   private final OutputStream d;

   private CodedOutputStream(OutputStream var1, byte[] var2) {
      this.d = var1;
      this.a = var2;
      this.c = 0;
      this.b = var2.length;
   }

   public static CodedOutputStream a(OutputStream var0) {
      return a(var0, 4096);
   }

   public static CodedOutputStream a(OutputStream var0, int var1) {
      return new CodedOutputStream(var0, new byte[var1]);
   }

   private void a() throws IOException {
      if (this.d == null) {
         throw new CodedOutputStream.OutOfSpaceException();
      }

      this.d.write(this.a, 0, this.c);
      this.c = 0;
   }

   public static int b(float var0) {
      return 4;
   }

   public static int b(int var0, float var1) {
      return j(var0) + b(var1);
   }

   public static int b(int var0, long var1) {
      return j(var0) + b(var1);
   }

   public static int b(int var0, ByteString var1) {
      return j(var0) + b(var1);
   }

   public static int b(int var0, boolean var1) {
      return j(var0) + b(var1);
   }

   public static int b(long var0) {
      return d(var0);
   }

   public static int b(ByteString var0) {
      return l(var0.a()) + var0.a();
   }

   public static int b(boolean var0) {
      return 1;
   }

   public static int d(int var0, int var1) {
      return j(var0) + f(var1);
   }

   public static int d(long var0) {
      byte var2;
      if ((-128L & var0) == 0L) {
         var2 = 1;
      } else if ((-16384L & var0) == 0L) {
         var2 = 2;
      } else if ((-2097152L & var0) == 0L) {
         var2 = 3;
      } else if ((-268435456L & var0) == 0L) {
         var2 = 4;
      } else if ((-34359738368L & var0) == 0L) {
         var2 = 5;
      } else if ((-4398046511104L & var0) == 0L) {
         var2 = 6;
      } else if ((-562949953421312L & var0) == 0L) {
         var2 = 7;
      } else if ((-72057594037927936L & var0) == 0L) {
         var2 = 8;
      } else if ((Long.MIN_VALUE & var0) == 0L) {
         var2 = 9;
      } else {
         var2 = 10;
      }

      return var2;
   }

   public static int e(int var0) {
      if (var0 >= 0) {
         var0 = l(var0);
      } else {
         var0 = 10;
      }

      return var0;
   }

   public static int e(int var0, int var1) {
      return j(var0) + g(var1);
   }

   public static int f(int var0) {
      return l(var0);
   }

   public static int f(int var0, int var1) {
      return j(var0) + h(var1);
   }

   public static int g(int var0) {
      return e(var0);
   }

   public static int h(int var0) {
      return l(n(var0));
   }

   public static int j(int var0) {
      return l(WireFormat.a(var0, 0));
   }

   public static int l(int var0) {
      byte var1;
      if ((var0 & -128) == 0) {
         var1 = 1;
      } else if ((var0 & -16384) == 0) {
         var1 = 2;
      } else if ((-2097152 & var0) == 0) {
         var1 = 3;
      } else if ((-268435456 & var0) == 0) {
         var1 = 4;
      } else {
         var1 = 5;
      }

      return var1;
   }

   public static int n(int var0) {
      return var0 << 1 ^ var0 >> 31;
   }

   public void a(byte var1) throws IOException {
      if (this.c == this.b) {
         this.a();
      }

      byte[] var3 = this.a;
      int var2 = this.c++;
      var3[var2] = var1;
   }

   public void a(float var1) throws IOException {
      this.m(Float.floatToRawIntBits(var1));
   }

   public void a(int var1) throws IOException {
      if (var1 >= 0) {
         this.k(var1);
      } else {
         this.c((long)var1);
      }
   }

   public void a(int var1, float var2) throws IOException {
      this.g(var1, 5);
      this.a(var2);
   }

   public void a(int var1, int var2) throws IOException {
      this.g(var1, 0);
      this.b(var2);
   }

   public void a(int var1, long var2) throws IOException {
      this.g(var1, 0);
      this.a(var2);
   }

   public void a(int var1, ByteString var2) throws IOException {
      this.g(var1, 2);
      this.a(var2);
   }

   public void a(int var1, boolean var2) throws IOException {
      this.g(var1, 0);
      this.a(var2);
   }

   public void a(long var1) throws IOException {
      this.c(var1);
   }

   public void a(ByteString var1) throws IOException {
      this.k(var1.a());
      this.c(var1);
   }

   public void a(ByteString var1, int var2, int var3) throws IOException {
      if (this.b - this.c >= var3) {
         var1.a(this.a, var2, this.c, var3);
         this.c += var3;
      } else {
         int var5 = this.b - this.c;
         var1.a(this.a, var2, this.c, var5);
         int var4 = var2 + var5;
         var2 = var3 - var5;
         this.c = this.b;
         this.a();
         if (var2 <= this.b) {
            var1.a(this.a, var4, 0, var2);
            this.c = var2;
         } else {
            InputStream var6 = var1.b();
            if (var4 != var6.skip(var4)) {
               throw new IllegalStateException("Skip failed.");
            }

            while (var2 > 0) {
               var3 = Math.min(var2, this.b);
               var4 = var6.read(this.a, 0, var3);
               if (var4 != var3) {
                  throw new IllegalStateException("Read failed.");
               }

               this.d.write(this.a, 0, var4);
               var2 -= var4;
            }
         }
      }
   }

   public void a(boolean var1) throws IOException {
      byte var2;
      if (var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.i(var2);
   }

   public void a(byte[] var1) throws IOException {
      this.a(var1, 0, var1.length);
   }

   public void a(byte[] var1, int var2, int var3) throws IOException {
      if (this.b - this.c >= var3) {
         System.arraycopy(var1, var2, this.a, this.c, var3);
         this.c += var3;
      } else {
         int var4 = this.b - this.c;
         System.arraycopy(var1, var2, this.a, this.c, var4);
         var2 += var4;
         var3 -= var4;
         this.c = this.b;
         this.a();
         if (var3 <= this.b) {
            System.arraycopy(var1, var2, this.a, 0, var3);
            this.c = var3;
         } else {
            this.d.write(var1, var2, var3);
         }
      }
   }

   public void b(int var1) throws IOException {
      this.k(var1);
   }

   public void b(int var1, int var2) throws IOException {
      this.g(var1, 0);
      this.c(var2);
   }

   public void c(int var1) throws IOException {
      this.a(var1);
   }

   public void c(int var1, int var2) throws IOException {
      this.g(var1, 0);
      this.d(var2);
   }

   public void c(long var1) throws IOException {
      while ((-128L & var1) != 0L) {
         this.i((int)var1 & 127 | 128);
         var1 >>>= 7;
      }

      this.i((int)var1);
   }

   public void c(ByteString var1) throws IOException {
      this.a(var1, 0, var1.a());
   }

   public void d(int var1) throws IOException {
      this.k(n(var1));
   }

   @Override
   public void flush() throws IOException {
      if (this.d != null) {
         this.a();
      }
   }

   public void g(int var1, int var2) throws IOException {
      this.k(WireFormat.a(var1, var2));
   }

   public void i(int var1) throws IOException {
      this.a((byte)var1);
   }

   public void k(int var1) throws IOException {
      while ((var1 & -128) != 0) {
         this.i(var1 & 127 | 128);
         var1 >>>= 7;
      }

      this.i(var1);
   }

   public void m(int var1) throws IOException {
      this.i(var1 & 0xFF);
      this.i(var1 >> 8 & 0xFF);
      this.i(var1 >> 16 & 0xFF);
      this.i(var1 >> 24 & 0xFF);
   }

   static class OutOfSpaceException extends IOException {
      OutOfSpaceException() {
         super("CodedOutputStream was writing to a flat byte array and ran out of space.");
      }
   }
}
