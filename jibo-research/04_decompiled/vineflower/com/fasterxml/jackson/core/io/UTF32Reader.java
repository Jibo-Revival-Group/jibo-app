package com.fasterxml.jackson.core.io;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class UTF32Reader extends Reader {
   protected final IOContext a;
   protected InputStream b;
   protected byte[] c;
   protected int d;
   protected int e;
   protected final boolean f;
   protected char g;
   protected int h;
   protected int i;
   protected final boolean j;
   protected char[] k;

   public UTF32Reader(IOContext var1, InputStream var2, byte[] var3, int var4, int var5, boolean var6) {
      boolean var7 = false;
      super();
      this.g = 0;
      this.h = 0;
      this.i = 0;
      this.k = null;
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      var6 = var7;
      if (var2 != null) {
         var6 = true;
      }

      this.j = var6;
   }

   private void a() {
      byte[] var1 = this.c;
      if (var1 != null) {
         this.c = null;
         this.a.a(var1);
      }
   }

   private void a(int var1, int var2) throws IOException {
      int var3 = this.i;
      int var4 = this.h;
      throw new CharConversionException(
         "Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + var1 + ", needed " + var2 + ", at char #" + var4 + ", byte #" + (var3 + var1) + ")"
      );
   }

   private void a(int var1, int var2, String var3) throws IOException {
      int var4 = this.i;
      int var5 = this.d;
      int var6 = this.h;
      throw new CharConversionException(
         "Invalid UTF-32 character 0x" + Integer.toHexString(var1) + var3 + " at char #" + (var6 + var2) + ", byte #" + (var4 + var5 - 1) + ")"
      );
   }

   private void a(char[] var1, int var2, int var3) throws IOException {
      throw new ArrayIndexOutOfBoundsException("read(buf," + var2 + "," + var3 + "), cbuf[" + var1.length + "]");
   }

   private boolean a(int var1) throws IOException {
      boolean var3 = false;
      this.i = this.i + (this.e - var1);
      if (var1 > 0) {
         if (this.d > 0) {
            System.arraycopy(this.c, this.d, this.c, 0, var1);
            this.d = 0;
         }

         this.e = var1;
      } else {
         this.d = 0;
         if (this.b == null) {
            var1 = -1;
         } else {
            var1 = this.b.read(this.c);
         }

         if (var1 < 1) {
            this.e = 0;
            if (var1 < 0) {
               boolean var2 = var3;
               if (this.j) {
                  this.a();
                  var2 = var3;
               }

               return var2;
            }

            this.b();
         }

         this.e = var1;
      }

      while (this.e < 4) {
         if (this.b == null) {
            var1 = -1;
         } else {
            var1 = this.b.read(this.c, this.e, this.c.length - this.e);
         }

         if (var1 < 1) {
            if (var1 < 0) {
               if (this.j) {
                  this.a();
               }

               this.a(this.e, 4);
            }

            this.b();
         }

         this.e += var1;
      }

      return true;
   }

   private void b() throws IOException {
      throw new IOException("Strange I/O stream, returned 0 bytes on read");
   }

   @Override
   public void close() throws IOException {
      InputStream var1 = this.b;
      if (var1 != null) {
         this.b = null;
         this.a();
         var1.close();
      }
   }

   @Override
   public int read() throws IOException {
      if (this.k == null) {
         this.k = new char[1];
      }

      int var1;
      if (this.read(this.k, 0, 1) < 1) {
         var1 = -1;
      } else {
         var1 = this.k[0];
      }

      return var1;
   }

   @Override
   public int read(char[] var1, int var2, int var3) throws IOException {
      int var4;
      if (this.c == null) {
         var4 = -1;
      } else {
         var4 = var3;
         if (var3 >= 1) {
            if (var2 < 0 || var2 + var3 > var1.length) {
               this.a(var1, var2, var3);
            }

            int var7 = var3 + var2;
            if (this.g != 0) {
               var3 = var2 + 1;
               var1[var2] = this.g;
               this.g = 0;
            } else {
               var3 = this.e - this.d;
               if (var3 < 4 && !this.a(var3)) {
                  byte var21 = -1;
                  return var21;
               }

               var3 = var2;
            }

            while (var3 < var7) {
               var4 = this.d;
               if (this.f) {
                  byte var8 = this.c[var4];
                  byte var6 = this.c[var4 + 1];
                  byte var5 = this.c[var4 + 2];
                  var4 = this.c[var4 + 3] & 255 | var8 << 24 | (var6 & 255) << 16 | (var5 & 255) << 8;
               } else {
                  byte var15 = this.c[var4];
                  byte var20 = this.c[var4 + 1];
                  byte var18 = this.c[var4 + 2];
                  var4 = this.c[var4 + 3] << 24 | var15 & 255 | (var20 & 255) << 8 | (var18 & 255) << 16;
               }

               this.d += 4;
               int var17;
               if (var4 > 65535) {
                  if (var4 > 1114111) {
                     this.a(var4, var3 - var2, "(above " + Integer.toHexString(1114111) + ") ");
                  }

                  var17 = var4 - 65536;
                  var4 = var3 + 1;
                  var1[var3] = (char)(55296 + (var17 >> 10));
                  int var19 = var17 & 1023 | 56320;
                  var17 = var19;
                  var3 = var4;
                  if (var4 >= var7) {
                     this.g = (char)var19;
                     var3 = var4;
                     break;
                  }
               } else {
                  var17 = var4;
               }

               var4 = var3 + 1;
               var1[var3] = (char)var17;
               var3 = var4;
               if (this.d >= this.e) {
                  var3 = var4;
                  break;
               }
            }

            var4 = var3 - var2;
            this.h += var4;
         }
      }

      return var4;
   }
}
