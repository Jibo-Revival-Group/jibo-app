package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class UTF8Writer extends Writer {
   private final IOContext a;
   private OutputStream b;
   private byte[] c;
   private final int d;
   private int e;
   private int f = 0;

   public UTF8Writer(IOContext var1, OutputStream var2) {
      this.a = var1;
      this.b = var2;
      this.c = var1.f();
      this.d = this.c.length - 4;
      this.e = 0;
   }

   protected static void b(int var0) throws IOException {
      throw new IOException(c(var0));
   }

   protected static String c(int var0) {
      String var1;
      if (var0 > 1114111) {
         var1 = "Illegal character point (0x" + Integer.toHexString(var0) + ") to output; max is 0x10FFFF as per RFC 4627";
      } else if (var0 >= 55296) {
         if (var0 <= 56319) {
            var1 = "Unmatched first part of surrogate pair (0x" + Integer.toHexString(var0) + ")";
         } else {
            var1 = "Unmatched second part of surrogate pair (0x" + Integer.toHexString(var0) + ")";
         }
      } else {
         var1 = "Illegal character point (0x" + Integer.toHexString(var0) + ") to output";
      }

      return var1;
   }

   protected int a(int var1) throws IOException {
      int var2 = this.f;
      this.f = 0;
      if (var1 >= 56320 && var1 <= 57343) {
         return (var2 - 55296 << 10) + 65536 + (var1 - 56320);
      } else {
         throw new IOException(
            "Broken surrogate pair: first char 0x" + Integer.toHexString(var2) + ", second 0x" + Integer.toHexString(var1) + "; illegal combination"
         );
      }
   }

   @Override
   public Writer append(char var1) throws IOException {
      this.write(var1);
      return this;
   }

   @Override
   public void close() throws IOException {
      if (this.b != null) {
         if (this.e > 0) {
            this.b.write(this.c, 0, this.e);
            this.e = 0;
         }

         OutputStream var2 = this.b;
         this.b = null;
         byte[] var3 = this.c;
         if (var3 != null) {
            this.c = null;
            this.a.b(var3);
         }

         var2.close();
         int var1 = this.f;
         this.f = 0;
         if (var1 > 0) {
            b(var1);
         }
      }
   }

   @Override
   public void flush() throws IOException {
      if (this.b != null) {
         if (this.e > 0) {
            this.b.write(this.c, 0, this.e);
            this.e = 0;
         }

         this.b.flush();
      }
   }

   @Override
   public void write(int var1) throws IOException {
      int var2;
      if (this.f > 0) {
         var2 = this.a(var1);
      } else {
         var2 = var1;
         if (var1 >= 55296) {
            var2 = var1;
            if (var1 <= 57343) {
               if (var1 > 56319) {
                  b(var1);
               }

               this.f = var1;
               return;
            }
         }
      }

      if (this.e >= this.d) {
         this.b.write(this.c, 0, this.e);
         this.e = 0;
      }

      if (var2 < 128) {
         byte[] var5 = this.c;
         var1 = this.e++;
         var5[var1] = (byte)var2;
      } else {
         var1 = this.e;
         if (var2 < 2048) {
            byte[] var13 = this.c;
            int var3 = var1 + 1;
            var13[var1] = (byte)(var2 >> 6 | 192);
            var13 = this.c;
            var1 = var3 + 1;
            var13[var3] = (byte)(var2 & 63 | 128);
         } else if (var2 <= 65535) {
            byte[] var15 = this.c;
            int var10 = var1 + 1;
            var15[var1] = (byte)(var2 >> 12 | 224);
            var15 = this.c;
            int var4 = var10 + 1;
            var15[var10] = (byte)(var2 >> 6 & 63 | 128);
            var15 = this.c;
            var1 = var4 + 1;
            var15[var4] = (byte)(var2 & 63 | 128);
         } else {
            if (var2 > 1114111) {
               b(var2);
            }

            byte[] var18 = this.c;
            int var11 = var1 + 1;
            var18[var1] = (byte)(var2 >> 18 | 240);
            var18 = this.c;
            var1 = var11 + 1;
            var18[var11] = (byte)(var2 >> 12 & 63 | 128);
            var18 = this.c;
            var11 = var1 + 1;
            var18[var1] = (byte)(var2 >> 6 & 63 | 128);
            var18 = this.c;
            var1 = var11 + 1;
            var18[var11] = (byte)(var2 & 63 | 128);
         }

         this.e = var1;
      }
   }

   @Override
   public void write(String var1) throws IOException {
      this.write(var1, 0, var1.length());
   }

   @Override
   public void write(String var1, int var2, int var3) throws IOException {
      if (var3 < 2) {
         if (var3 == 1) {
            this.write(var1.charAt(var2));
         }
      } else {
         int var4 = var2;
         int var5 = var3;
         if (this.f > 0) {
            char var15 = var1.charAt(var2);
            var5 = var3 - 1;
            this.write(this.a(var15));
            var4 = var2 + 1;
         }

         var2 = this.e;
         byte[] var10 = this.c;
         int var8 = this.d;
         int var9 = var5 + var4;
         var3 = var4;

         label70:
         while (true) {
            label62:
            while (true) {
               var4 = var2;
               if (var3 >= var9) {
                  break label70;
               }

               var4 = var2;
               if (var2 >= var8) {
                  this.b.write(var10, 0, var2);
                  var4 = 0;
               }

               var5 = var3 + 1;
               int var6 = var1.charAt(var3);
               if (var6 < 128) {
                  var2 = var4 + 1;
                  var10[var4] = (byte)var6;
                  var3 = var9 - var5;
                  var4 = var8 - var2;
                  if (var3 <= var4) {
                     var4 = var3;
                  }

                  var3 = var5;

                  while (true) {
                     if (var3 >= var4 + var5) {
                        continue label62;
                     }

                     var6 = var3 + 1;
                     char var7 = var1.charAt(var3);
                     if (var7 >= 128) {
                        var3 = var6;
                        var18 = var7;
                        break label62;
                     }

                     var10[var2] = (byte)var7;
                     var2++;
                     var3 = var6;
                  }
               }

               var3 = var5;
               char var22 = (char)var6;
               var2 = var4;
               var18 = var22;
               break;
            }

            if (var18 < 2048) {
               var5 = var2 + 1;
               var10[var2] = (byte)(var18 >> 6 | 192);
               var2 = var5 + 1;
               var10[var5] = (byte)(var18 & 63 | 128);
            } else if (var18 >= '\ud800' && var18 <= '\udfff') {
               if (var18 > '\udbff') {
                  this.e = var2;
                  b(var18);
               }

               this.f = var18;
               if (var3 >= var9) {
                  var4 = var2;
                  break;
               }

               var4 = this.a(var1.charAt(var3));
               if (var4 > 1114111) {
                  this.e = var2;
                  b(var4);
               }

               var5 = var2 + 1;
               var10[var2] = (byte)(var4 >> 18 | 240);
               var2 = var5 + 1;
               var10[var5] = (byte)(var4 >> 12 & 63 | 128);
               var5 = var2 + 1;
               var10[var2] = (byte)(var4 >> 6 & 63 | 128);
               var2 = var5 + 1;
               var10[var5] = (byte)(var4 & 63 | 128);
               var3++;
            } else {
               var5 = var2 + 1;
               var10[var2] = (byte)(var18 >> '\f' | 224);
               int var28 = var5 + 1;
               var10[var5] = (byte)(var18 >> 6 & 63 | 128);
               var2 = var28 + 1;
               var10[var28] = (byte)(var18 & 63 | 128);
            }
         }

         this.e = var4;
      }
   }

   @Override
   public void write(char[] var1) throws IOException {
      this.write(var1, 0, var1.length);
   }

   @Override
   public void write(char[] var1, int var2, int var3) throws IOException {
      if (var3 < 2) {
         if (var3 == 1) {
            this.write(var1[var2]);
         }
      } else {
         int var4 = var2;
         int var5 = var3;
         if (this.f > 0) {
            char var15 = var1[var2];
            var5 = var3 - 1;
            this.write(this.a(var15));
            var4 = var2 + 1;
         }

         var2 = this.e;
         byte[] var10 = this.c;
         int var8 = this.d;
         int var9 = var5 + var4;
         var3 = var4;

         label71:
         while (true) {
            label63:
            while (true) {
               var4 = var2;
               if (var3 >= var9) {
                  break label71;
               }

               var4 = var2;
               if (var2 >= var8) {
                  this.b.write(var10, 0, var2);
                  var4 = 0;
               }

               var5 = var3 + 1;
               int var6 = var1[var3];
               if (var6 < 128) {
                  var2 = var4 + 1;
                  var10[var4] = (byte)var6;
                  var4 = var9 - var5;
                  var3 = var8 - var2;
                  if (var4 > var3) {
                     var4 = var3;
                  }

                  var3 = var5;

                  while (true) {
                     if (var3 >= var4 + var5) {
                        continue label63;
                     }

                     var6 = var3 + 1;
                     char var7 = var1[var3];
                     if (var7 >= 128) {
                        var3 = var6;
                        var18 = var7;
                        break label63;
                     }

                     var10[var2] = (byte)var7;
                     var2++;
                     var3 = var6;
                  }
               }

               var3 = var5;
               char var22 = (char)var6;
               var2 = var4;
               var18 = var22;
               break;
            }

            if (var18 < 2048) {
               var5 = var2 + 1;
               var10[var2] = (byte)(var18 >> 6 | 192);
               var2 = var5 + 1;
               var10[var5] = (byte)(var18 & 63 | 128);
            } else if (var18 >= '\ud800' && var18 <= '\udfff') {
               if (var18 > '\udbff') {
                  this.e = var2;
                  b(var18);
               }

               this.f = var18;
               if (var3 >= var9) {
                  var4 = var2;
                  break;
               }

               var4 = this.a(var1[var3]);
               if (var4 > 1114111) {
                  this.e = var2;
                  b(var4);
               }

               var5 = var2 + 1;
               var10[var2] = (byte)(var4 >> 18 | 240);
               var2 = var5 + 1;
               var10[var5] = (byte)(var4 >> 12 & 63 | 128);
               var5 = var2 + 1;
               var10[var2] = (byte)(var4 >> 6 & 63 | 128);
               var2 = var5 + 1;
               var10[var5] = (byte)(var4 & 63 | 128);
               var3++;
            } else {
               var5 = var2 + 1;
               var10[var2] = (byte)(var18 >> '\f' | 224);
               int var28 = var5 + 1;
               var10[var5] = (byte)(var18 >> 6 & 63 | 128);
               var2 = var28 + 1;
               var10[var28] = (byte)(var18 & 63 | 128);
            }
         }

         this.e = var4;
      }
   }
}
