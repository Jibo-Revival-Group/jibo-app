package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class UTF8JsonGenerator extends JsonGeneratorImpl {
   private static final byte[] D = new byte[]{110, 117, 108, 108};
   private static final byte[] E = new byte[]{116, 114, 117, 101};
   private static final byte[] F = new byte[]{102, 97, 108, 115, 101};
   static final byte[] t = CharTypes.h();
   protected final int A;
   protected boolean B;
   protected boolean C;
   protected final OutputStream u;
   protected byte[] v;
   protected int w;
   protected final int x;
   protected final int y;
   protected char[] z;

   public UTF8JsonGenerator(IOContext var1, int var2, ObjectCodec var3, OutputStream var4) {
      boolean var5 = true;
      super(var1, var2, var3);
      this.w = 0;
      this.u = var4;
      this.B = true;
      this.v = var1.f();
      this.x = this.v.length;
      this.y = this.x >> 3;
      this.z = var1.h();
      this.A = this.z.length;
      if (this.a(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
         this.a(127);
      }

      if (JsonGenerator.Feature.QUOTE_FIELD_NAMES.enabledIn(var2)) {
         var5 = false;
      }

      this.C = var5;
   }

   private final int a(int var1, char[] var2, int var3, int var4) throws IOException {
      if (var1 >= 55296 && var1 <= 57343) {
         if (var3 >= var4 || var2 == null) {
            this.e("Split surrogate on writeRaw() input (last character)");
         }

         this.b(var1, var2[var3]);
         var3++;
      } else {
         byte[] var5 = this.v;
         var4 = this.w++;
         var5[var4] = (byte)(var1 >> 12 | 224);
         var4 = this.w++;
         var5[var4] = (byte)(var1 >> 6 & 63 | 128);
         var4 = this.w++;
         var5[var4] = (byte)(var1 & 63 | 128);
      }

      return var3;
   }

   private final int a(byte[] var1, int var2, int var3, byte[] var4, int var5) throws IOException, JsonGenerationException {
      int var7 = var4.length;
      if (var2 + var7 > var3) {
         this.w = var2;
         this.l();
         int var6 = this.w;
         if (var7 > var1.length) {
            this.u.write(var4, 0, var7);
            return var6;
         }

         System.arraycopy(var4, 0, var1, var6, var7);
         var2 = var6 + var7;
      }

      int var8 = var2;
      if (var5 * 6 + var2 > var3) {
         this.l();
         var8 = this.w;
      }

      return var8;
   }

   private final int a(byte[] var1, int var2, SerializableString var3, int var4) throws IOException, JsonGenerationException {
      byte[] var7 = var3.b();
      int var5 = var7.length;
      if (var5 > 6) {
         var2 = this.a(var1, var2, this.x, var7, var4);
      } else {
         System.arraycopy(var7, 0, var1, var2, var5);
         var2 = var5 + var2;
      }

      return var2;
   }

   private final void a(String var1, int var2, int var3) throws IOException {
      int var5;
      do {
         var5 = Math.min(this.y, var3);
         if (this.w + var5 > this.x) {
            this.l();
         }

         this.b(var1, var2, var5);
         var2 += var5;
         var5 = var3 - var5;
         var3 = var5;
      } while (var5 > 0);
   }

   private final void a(String var1, boolean var2) throws IOException {
      if (var2) {
         if (this.w >= this.x) {
            this.l();
         }

         byte[] var6 = this.v;
         int var3 = this.w++;
         var6[var3] = 34;
      }

      int var8 = var1.length();
      int var4 = 0;

      while (var8 > 0) {
         int var5 = Math.min(this.y, var8);
         if (this.w + var5 > this.x) {
            this.l();
         }

         this.b(var1, var4, var5);
         var4 += var5;
         var8 -= var5;
      }

      if (var2) {
         if (this.w >= this.x) {
            this.l();
         }

         byte[] var7 = this.v;
         var8 = this.w++;
         var7[var8] = 34;
      }
   }

   private final void a(byte[] var1) throws IOException {
      int var2 = var1.length;
      if (this.w + var2 > this.x) {
         this.l();
         if (var2 > 512) {
            this.u.write(var1, 0, var2);
            return;
         }
      }

      System.arraycopy(var1, 0, this.v, this.w, var2);
      this.w += var2;
   }

   private final void b(long var1) throws IOException {
      if (this.w + 23 >= this.x) {
         this.l();
      }

      byte[] var4 = this.v;
      int var3 = this.w++;
      var4[var3] = 34;
      this.w = NumberOutput.a(var1, this.v, this.w);
      var4 = this.v;
      var3 = this.w++;
      var4[var3] = 34;
   }

   private final void b(String var1, int var2, int var3) throws IOException {
      int var5 = var3 + var2;
      int var4 = this.w;
      byte[] var6 = this.v;
      int[] var7 = this.p;
      var3 = var2;

      for (var2 = var4; var3 < var5; var2++) {
         char var10 = var1.charAt(var3);
         if (var10 > 127 || var7[var10] != 0) {
            break;
         }

         var6[var2] = (byte)var10;
         var3++;
      }

      this.w = var2;
      if (var3 < var5) {
         if (this.r != null) {
            this.e(var1, var3, var5);
         } else if (this.q == 0) {
            this.c(var1, var3, var5);
         } else {
            this.d(var1, var3, var5);
         }
      }
   }

   private final void b(char[] var1, int var2, int var3) throws IOException, JsonGenerationException {
      int var5 = this.x;
      byte[] var7 = this.v;

      label29:
      while (var2 < var3) {
         int var9;
         do {
            int var4 = var1[var2];
            if (var4 >= 128) {
               if (this.w + 3 >= this.x) {
                  this.l();
               }

               var4 = var2 + 1;
               char var8 = var1[var2];
               if (var8 < 2048) {
                  int var11 = this.w++;
                  var7[var11] = (byte)(var8 >> 6 | 192);
                  var11 = this.w++;
                  var7[var11] = (byte)(var8 & 63 | 128);
                  var2 = var4;
               } else {
                  var2 = this.a(var8, var1, var4, var3);
               }
               continue label29;
            }

            if (this.w >= var5) {
               this.l();
            }

            int var6 = this.w++;
            var7[var6] = (byte)var4;
            var9 = var2 + 1;
            var2 = var9;
         } while (var9 < var3);

         return;
      }
   }

   private final int c(int var1, int var2) throws IOException {
      byte[] var5 = this.v;
      if (var1 >= 55296 && var1 <= 57343) {
         int var11 = var2 + 1;
         var5[var2] = 92;
         var2 = var11 + 1;
         var5[var11] = 117;
         var11 = var2 + 1;
         var5[var2] = t[var1 >> 12 & 15];
         var2 = var11 + 1;
         var5[var11] = t[var1 >> 8 & 15];
         var11 = var2 + 1;
         var5[var2] = t[var1 >> 4 & 15];
         var2 = var11 + 1;
         var5[var11] = t[var1 & 15];
         var1 = var2;
      } else {
         int var3 = var2 + 1;
         var5[var2] = (byte)(var1 >> 12 | 224);
         int var4 = var3 + 1;
         var5[var3] = (byte)(var1 >> 6 & 63 | 128);
         var2 = var4 + 1;
         var5[var4] = (byte)(var1 & 63 | 128);
         var1 = var2;
      }

      return var1;
   }

   private final void c(int var1) throws IOException {
      if (this.w + 13 >= this.x) {
         this.l();
      }

      byte[] var3 = this.v;
      int var2 = this.w++;
      var3[var2] = 34;
      this.w = NumberOutput.a(var1, this.v, this.w);
      var3 = this.v;
      var1 = this.w++;
      var3[var1] = 34;
   }

   private final void c(String var1, int var2, int var3) throws IOException {
      if (this.w + (var3 - var2) * 6 > this.x) {
         this.l();
      }

      int var5 = this.w;
      byte[] var8 = this.v;
      int[] var7 = this.p;
      int var4 = var2;
      var2 = var5;

      while (var4 < var3) {
         var5 = var4 + 1;
         int var10 = var1.charAt(var4);
         if (var10 <= 127) {
            if (var7[var10] == 0) {
               var8[var2] = (byte)var10;
               var2++;
               var4 = var5;
            } else {
               int var6 = var7[var10];
               if (var6 > 0) {
                  var10 = var2 + 1;
                  var8[var2] = 92;
                  var2 = var10 + 1;
                  var8[var10] = (byte)var6;
                  var4 = var5;
               } else {
                  var2 = this.d(var10, var2);
                  var4 = var5;
               }
            }
         } else {
            if (var10 <= 2047) {
               int var13 = var2 + 1;
               var8[var2] = (byte)(var10 >> 6 | 192);
               var2 = var13 + 1;
               var8[var13] = (byte)(var10 & 63 | 128);
            } else {
               var2 = this.c(var10, var2);
            }

            var4 = var5;
         }
      }

      this.w = var2;
   }

   private final void c(char[] var1, int var2, int var3) throws IOException {
      int var5;
      do {
         var5 = Math.min(this.y, var3);
         if (this.w + var5 > this.x) {
            this.l();
         }

         this.d(var1, var2, var5);
         var2 += var5;
         var5 = var3 - var5;
         var3 = var5;
      } while (var5 > 0);
   }

   private int d(int var1, int var2) throws IOException {
      byte[] var5 = this.v;
      int var3 = var2 + 1;
      var5[var2] = 92;
      var2 = var3 + 1;
      var5[var3] = 117;
      if (var1 > 255) {
         int var4 = var1 >> 8 & 0xFF;
         var3 = var2 + 1;
         var5[var2] = t[var4 >> 4];
         var2 = var3 + 1;
         var5[var3] = t[var4 & 15];
         var1 &= 255;
      } else {
         var3 = var2 + 1;
         var5[var2] = 48;
         var2 = var3 + 1;
         var5[var3] = 48;
      }

      var3 = var2 + 1;
      var5[var2] = t[var1 >> 4];
      var5[var3] = t[var1 & 15];
      return var3 + 1;
   }

   private final void d(String var1, int var2, int var3) throws IOException {
      if (this.w + (var3 - var2) * 6 > this.x) {
         this.l();
      }

      int var5 = this.w;
      byte[] var8 = this.v;
      int[] var9 = this.p;
      int var6 = this.q;
      int var4 = var2;
      var2 = var5;

      while (var4 < var3) {
         var5 = var4 + 1;
         int var11 = var1.charAt(var4);
         if (var11 <= 127) {
            if (var9[var11] == 0) {
               var8[var2] = (byte)var11;
               var2++;
               var4 = var5;
            } else {
               int var7 = var9[var11];
               if (var7 > 0) {
                  var11 = var2 + 1;
                  var8[var2] = 92;
                  var2 = var11 + 1;
                  var8[var11] = (byte)var7;
                  var4 = var5;
               } else {
                  var2 = this.d(var11, var2);
                  var4 = var5;
               }
            }
         } else if (var11 > var6) {
            var2 = this.d(var11, var2);
            var4 = var5;
         } else {
            if (var11 <= 2047) {
               int var14 = var2 + 1;
               var8[var2] = (byte)(var11 >> 6 | 192);
               var2 = var14 + 1;
               var8[var14] = (byte)(var11 & 63 | 128);
            } else {
               var2 = this.c(var11, var2);
            }

            var4 = var5;
         }
      }

      this.w = var2;
   }

   private final void d(char[] var1, int var2, int var3) throws IOException {
      int var4 = var3 + var2;
      var3 = this.w;
      byte[] var7 = this.v;
      int[] var6 = this.p;

      while (var2 < var4) {
         char var5 = var1[var2];
         if (var5 > 127 || var6[var5] != 0) {
            break;
         }

         var7[var3] = (byte)var5;
         var2++;
         var3++;
      }

      this.w = var3;
      if (var2 < var4) {
         if (this.r != null) {
            this.g(var1, var2, var4);
         } else if (this.q == 0) {
            this.e(var1, var2, var4);
         } else {
            this.f(var1, var2, var4);
         }
      }
   }

   private final void e(String var1, int var2, int var3) throws IOException {
      if (this.w + (var3 - var2) * 6 > this.x) {
         this.l();
      }

      int var5 = this.w;
      byte[] var9 = this.v;
      int[] var8 = this.p;
      int var6;
      if (this.q <= 0) {
         var6 = 65535;
      } else {
         var6 = this.q;
      }

      CharacterEscapes var10 = this.r;
      int var4 = var2;
      var2 = var5;

      while (var4 < var3) {
         var5 = var4 + 1;
         int var13 = var1.charAt(var4);
         if (var13 <= 127) {
            if (var8[var13] == 0) {
               var9[var2] = (byte)var13;
               var2++;
               var4 = var5;
            } else {
               int var7 = var8[var13];
               if (var7 > 0) {
                  var13 = var2 + 1;
                  var9[var2] = 92;
                  var2 = var13 + 1;
                  var9[var13] = (byte)var7;
                  var4 = var5;
               } else if (var7 == -2) {
                  SerializableString var11 = var10.a(var13);
                  if (var11 == null) {
                     this.e(
                        "Invalid custom escape definitions; custom escape not found for character code 0x"
                           + Integer.toHexString(var13)
                           + ", although was supposed to have one"
                     );
                  }

                  var2 = this.a(var9, var2, var11, var3 - var5);
                  var4 = var5;
               } else {
                  var2 = this.d(var13, var2);
                  var4 = var5;
               }
            }
         } else if (var13 > var6) {
            var2 = this.d(var13, var2);
            var4 = var5;
         } else {
            SerializableString var17 = var10.a(var13);
            if (var17 != null) {
               var2 = this.a(var9, var2, var17, var3 - var5);
               var4 = var5;
            } else {
               if (var13 <= 2047) {
                  int var16 = var2 + 1;
                  var9[var2] = (byte)(var13 >> 6 | 192);
                  var2 = var16 + 1;
                  var9[var16] = (byte)(var13 & 63 | 128);
               } else {
                  var2 = this.c(var13, var2);
               }

               var4 = var5;
            }
         }
      }

      this.w = var2;
   }

   private final void e(char[] var1, int var2, int var3) throws IOException {
      if (this.w + (var3 - var2) * 6 > this.x) {
         this.l();
      }

      int var5 = this.w;
      byte[] var8 = this.v;
      int[] var7 = this.p;
      int var4 = var2;
      var2 = var5;

      while (var4 < var3) {
         var5 = var4 + 1;
         int var6 = var1[var4];
         if (var6 <= 127) {
            if (var7[var6] == 0) {
               var8[var2] = (byte)var6;
               var2++;
               var4 = var5;
            } else {
               var4 = var7[var6];
               if (var4 > 0) {
                  var6 = var2 + 1;
                  var8[var2] = 92;
                  var2 = var6 + 1;
                  var8[var6] = (byte)var4;
                  var4 = var5;
               } else {
                  var2 = this.d(var6, var2);
                  var4 = var5;
               }
            }
         } else {
            if (var6 <= 2047) {
               var4 = var2 + 1;
               var8[var2] = (byte)(var6 >> 6 | 192);
               var2 = var4 + 1;
               var8[var4] = (byte)(var6 & 63 | 128);
            } else {
               var2 = this.c(var6, var2);
            }

            var4 = var5;
         }
      }

      this.w = var2;
   }

   private final void f(char[] var1, int var2, int var3) throws IOException {
      if (this.w + (var3 - var2) * 6 > this.x) {
         this.l();
      }

      int var5 = this.w;
      byte[] var8 = this.v;
      int[] var9 = this.p;
      int var6 = this.q;
      int var4 = var2;
      var2 = var5;

      while (var4 < var3) {
         var5 = var4 + 1;
         int var11 = var1[var4];
         if (var11 <= 127) {
            if (var9[var11] == 0) {
               var8[var2] = (byte)var11;
               var2++;
               var4 = var5;
            } else {
               int var7 = var9[var11];
               if (var7 > 0) {
                  var11 = var2 + 1;
                  var8[var2] = 92;
                  var2 = var11 + 1;
                  var8[var11] = (byte)var7;
                  var4 = var5;
               } else {
                  var2 = this.d(var11, var2);
                  var4 = var5;
               }
            }
         } else if (var11 > var6) {
            var2 = this.d(var11, var2);
            var4 = var5;
         } else {
            if (var11 <= 2047) {
               int var14 = var2 + 1;
               var8[var2] = (byte)(var11 >> 6 | 192);
               var2 = var14 + 1;
               var8[var14] = (byte)(var11 & 63 | 128);
            } else {
               var2 = this.c(var11, var2);
            }

            var4 = var5;
         }
      }

      this.w = var2;
   }

   private final void g(char[] var1, int var2, int var3) throws IOException {
      if (this.w + (var3 - var2) * 6 > this.x) {
         this.l();
      }

      int var5 = this.w;
      byte[] var10 = this.v;
      int[] var8 = this.p;
      int var6;
      if (this.q <= 0) {
         var6 = 65535;
      } else {
         var6 = this.q;
      }

      CharacterEscapes var9 = this.r;
      int var4 = var2;
      var2 = var5;

      while (var4 < var3) {
         var5 = var4 + 1;
         int var13 = var1[var4];
         if (var13 <= 127) {
            if (var8[var13] == 0) {
               var10[var2] = (byte)var13;
               var2++;
               var4 = var5;
            } else {
               int var7 = var8[var13];
               if (var7 > 0) {
                  var13 = var2 + 1;
                  var10[var2] = 92;
                  var2 = var13 + 1;
                  var10[var13] = (byte)var7;
                  var4 = var5;
               } else if (var7 == -2) {
                  SerializableString var11 = var9.a(var13);
                  if (var11 == null) {
                     this.e(
                        "Invalid custom escape definitions; custom escape not found for character code 0x"
                           + Integer.toHexString(var13)
                           + ", although was supposed to have one"
                     );
                  }

                  var2 = this.a(var10, var2, var11, var3 - var5);
                  var4 = var5;
               } else {
                  var2 = this.d(var13, var2);
                  var4 = var5;
               }
            }
         } else if (var13 > var6) {
            var2 = this.d(var13, var2);
            var4 = var5;
         } else {
            SerializableString var17 = var9.a(var13);
            if (var17 != null) {
               var2 = this.a(var10, var2, var17, var3 - var5);
               var4 = var5;
            } else {
               if (var13 <= 2047) {
                  int var16 = var2 + 1;
                  var10[var2] = (byte)(var13 >> 6 | 192);
                  var2 = var16 + 1;
                  var10[var16] = (byte)(var13 & 63 | 128);
               } else {
                  var2 = this.c(var13, var2);
               }

               var4 = var5;
            }
         }
      }

      this.w = var2;
   }

   private final void h(String var1) throws IOException {
      if (this.w >= this.x) {
         this.l();
      }

      byte[] var3 = this.v;
      int var2 = this.w++;
      var3[var2] = 34;
      this.c(var1);
      if (this.w >= this.x) {
         this.l();
      }

      byte[] var4 = this.v;
      var2 = this.w++;
      var4[var2] = 34;
   }

   private final void m() throws IOException {
      if (this.w + 4 >= this.x) {
         this.l();
      }

      System.arraycopy(D, 0, this.v, this.w, 4);
      this.w += 4;
   }

   @Override
   public void a(char var1) throws IOException, JsonGenerationException {
      if (this.w + 3 >= this.x) {
         this.l();
      }

      byte[] var3 = this.v;
      if (var1 <= 127) {
         int var2 = this.w++;
         var3[var2] = (byte)var1;
      } else if (var1 < 2048) {
         int var4 = this.w++;
         var3[var4] = (byte)(var1 >> 6 | 192);
         var4 = this.w++;
         var3[var4] = (byte)(var1 & 63 | 128);
      } else {
         this.a(var1, null, 0, 0);
      }
   }

   @Override
   public void a(double var1) throws IOException, JsonGenerationException {
      if (!this.k && (!Double.isNaN(var1) && !Double.isInfinite(var1) || !this.a(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
         this.f("write a number");
         this.c(String.valueOf(var1));
      } else {
         this.b(String.valueOf(var1));
      }
   }

   @Override
   public void a(float var1) throws IOException, JsonGenerationException {
      if (!this.k && (!Float.isNaN(var1) && !Float.isInfinite(var1) || !this.a(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
         this.f("write a number");
         this.c(String.valueOf(var1));
      } else {
         this.b(String.valueOf(var1));
      }
   }

   @Override
   public void a(long var1) throws IOException, JsonGenerationException {
      this.f("write a number");
      if (this.k) {
         this.b(var1);
      } else {
         if (this.w + 21 >= this.x) {
            this.l();
         }

         this.w = NumberOutput.a(var1, this.v, this.w);
      }
   }

   @Override
   public void a(String var1) throws IOException {
      if (this.a != null) {
         this.g(var1);
      } else {
         int var2 = this.l.a(var1);
         if (var2 == 4) {
            this.e("Can not write a field name, expecting a value");
         }

         if (var2 == 1) {
            if (this.w >= this.x) {
               this.l();
            }

            byte[] var4 = this.v;
            var2 = this.w++;
            var4[var2] = 44;
         }

         if (this.C) {
            this.a(var1, false);
         } else {
            int var3 = var1.length();
            if (var3 > this.A) {
               this.a(var1, true);
            } else {
               if (this.w >= this.x) {
                  this.l();
               }

               byte[] var9 = this.v;
               var2 = this.w++;
               var9[var2] = 34;
               if (var3 <= this.y) {
                  if (this.w + var3 > this.x) {
                     this.l();
                  }

                  this.b(var1, 0, var3);
               } else {
                  this.a(var1, 0, var3);
               }

               if (this.w >= this.x) {
                  this.l();
               }

               byte[] var5 = this.v;
               var2 = this.w++;
               var5[var2] = 34;
            }
         }
      }
   }

   protected final void a(String var1, int var2) throws IOException {
      switch (var2) {
         case 0:
            if (this.l.a()) {
               this.a.g(this);
            } else if (this.l.c()) {
               this.a.h(this);
            }
            break;
         case 1:
            this.a.f(this);
            break;
         case 2:
            this.a.d(this);
            break;
         case 3:
            this.a.a(this);
            break;
         default:
            this.h();
      }
   }

   @Override
   public void a(BigDecimal var1) throws IOException, JsonGenerationException {
      this.f("write a number");
      if (var1 == null) {
         this.m();
      } else if (this.k) {
         String var2;
         if (this.a(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)) {
            var2 = var1.toPlainString();
         } else {
            var2 = var1.toString();
         }

         this.h(var2);
      } else if (this.a(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)) {
         this.c(var1.toPlainString());
      } else {
         this.c(var1.toString());
      }
   }

   @Override
   public void a(BigInteger var1) throws IOException, JsonGenerationException {
      this.f("write a number");
      if (var1 == null) {
         this.m();
      } else if (this.k) {
         this.h(var1.toString());
      } else {
         this.c(var1.toString());
      }
   }

   @Override
   public void a(boolean var1) throws IOException, JsonGenerationException {
      this.f("write a boolean value");
      if (this.w + 5 >= this.x) {
         this.l();
      }

      byte[] var3;
      if (var1) {
         var3 = E;
      } else {
         var3 = F;
      }

      int var2 = var3.length;
      System.arraycopy(var3, 0, this.v, this.w, var2);
      this.w += var2;
   }

   @Override
   public final void a(char[] var1, int var2, int var3) throws IOException, JsonGenerationException {
      int var4 = var3 + var3 + var3;
      if (this.w + var4 > this.x) {
         if (this.x < var4) {
            this.b(var1, var2, var3);
            return;
         }

         this.l();
      }

      var4 = var3 + var2;

      label27:
      while (var2 < var4) {
         do {
            int var5 = var1[var2];
            if (var5 > 127) {
               var3 = var2 + 1;
               char var7 = var1[var2];
               if (var7 < 2048) {
                  byte[] var14 = this.v;
                  var5 = this.w++;
                  var14[var5] = (byte)(var7 >> 6 | 192);
                  var14 = this.v;
                  var5 = this.w++;
                  var14[var5] = (byte)(var7 & 63 | 128);
                  var2 = var3;
               } else {
                  var2 = this.a(var7, var1, var3, var4);
               }
               continue label27;
            }

            byte[] var6 = this.v;
            int var8 = this.w++;
            var6[var8] = (byte)var5;
            var3 = var2 + 1;
            var2 = var3;
         } while (var3 < var4);

         return;
      }
   }

   @Override
   public void b(int var1) throws IOException, JsonGenerationException {
      this.f("write a number");
      if (this.w + 11 >= this.x) {
         this.l();
      }

      if (this.k) {
         this.c(var1);
      } else {
         this.w = NumberOutput.a(var1, this.v, this.w);
      }
   }

   protected final void b(int var1, int var2) throws IOException {
      var1 = this.a(var1, var2);
      if (this.w + 4 > this.x) {
         this.l();
      }

      byte[] var3 = this.v;
      var2 = this.w++;
      var3[var2] = (byte)(var1 >> 18 | 240);
      var2 = this.w++;
      var3[var2] = (byte)(var1 >> 12 & 63 | 128);
      var2 = this.w++;
      var3[var2] = (byte)(var1 >> 6 & 63 | 128);
      var2 = this.w++;
      var3[var2] = (byte)(var1 & 63 | 128);
   }

   @Override
   public void b(SerializableString var1) throws IOException, JsonGenerationException {
      byte[] var2 = var1.b();
      if (var2.length > 0) {
         this.a(var2);
      }
   }

   @Override
   public void b(String var1) throws IOException {
      this.f("write a string");
      if (var1 == null) {
         this.m();
      } else {
         int var2 = var1.length();
         if (var2 > this.y) {
            this.a(var1, true);
         } else {
            if (this.w + var2 >= this.x) {
               this.l();
            }

            byte[] var4 = this.v;
            int var3 = this.w++;
            var4[var3] = 34;
            this.b(var1, 0, var2);
            if (this.w >= this.x) {
               this.l();
            }

            byte[] var5 = this.v;
            var2 = this.w++;
            var5[var2] = 34;
         }
      }
   }

   @Override
   public final void c() throws IOException {
      this.f("start an array");
      this.l = this.l.g();
      if (this.a != null) {
         this.a.e(this);
      } else {
         if (this.w >= this.x) {
            this.l();
         }

         byte[] var2 = this.v;
         int var1 = this.w++;
         var2[var1] = 91;
      }
   }

   @Override
   public void c(String var1) throws IOException, JsonGenerationException {
      int var2 = var1.length();
      int var3 = 0;

      while (var2 > 0) {
         char[] var6 = this.z;
         int var5 = var6.length;
         int var4 = var5;
         if (var2 < var5) {
            var4 = var2;
         }

         var1.getChars(var3, var3 + var4, var6, 0);
         this.a(var6, 0, var4);
         var3 += var4;
         var2 -= var4;
      }
   }

   @Override
   public void close() throws IOException {
      super.close();
      if (this.v != null && this.a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
         while (true) {
            JsonWriteContext var1 = this.i();
            if (var1.a()) {
               this.d();
            } else {
               if (!var1.c()) {
                  break;
               }

               this.f();
            }
         }
      }

      this.l();
      this.w = 0;
      if (this.u != null) {
         if (this.o.c() || this.a(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
            this.u.close();
         } else if (this.a(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this.u.flush();
         }
      }

      this.j();
   }

   @Override
   public final void d() throws IOException {
      if (!this.l.a()) {
         this.e("Current context not an ARRAY but " + this.l.d());
      }

      if (this.a != null) {
         this.a.b(this, this.l.e());
      } else {
         if (this.w >= this.x) {
            this.l();
         }

         byte[] var2 = this.v;
         int var1 = this.w++;
         var2[var1] = 93;
      }

      this.l = this.l.i();
   }

   @Override
   public void d(String var1) throws IOException, JsonGenerationException {
      this.f("write a number");
      if (this.k) {
         this.h(var1);
      } else {
         this.c(var1);
      }
   }

   @Override
   public final void e() throws IOException {
      this.f("start an object");
      this.l = this.l.h();
      if (this.a != null) {
         this.a.b(this);
      } else {
         if (this.w >= this.x) {
            this.l();
         }

         byte[] var2 = this.v;
         int var1 = this.w++;
         var2[var1] = 123;
      }
   }

   @Override
   public final void f() throws IOException {
      if (!this.l.c()) {
         this.e("Current context not an object but " + this.l.d());
      }

      if (this.a != null) {
         this.a.a(this, this.l.e());
      } else {
         if (this.w >= this.x) {
            this.l();
         }

         byte[] var2 = this.v;
         int var1 = this.w++;
         var2[var1] = 125;
      }

      this.l = this.l.i();
   }

   @Override
   protected final void f(String var1) throws IOException {
      int var3 = this.l.j();
      if (var3 == 5) {
         this.e("Can not " + var1 + ", expecting field name");
      }

      if (this.a == null) {
         byte var2;
         switch (var3) {
            case 1:
               var2 = 44;
               break;
            case 2:
               var2 = 58;
               break;
            case 3:
               if (this.s != null) {
                  byte[] var4 = this.s.b();
                  if (var4.length > 0) {
                     this.a(var4);
                     return;
                  }
               }

               return;
            default:
               return;
         }

         if (this.w >= this.x) {
            this.l();
         }

         this.v[this.w] = var2;
         this.w++;
      } else {
         this.a(var1, var3);
      }
   }

   @Override
   public void flush() throws IOException {
      this.l();
      if (this.u != null && this.a(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
         this.u.flush();
      }
   }

   @Override
   public void g() throws IOException, JsonGenerationException {
      this.f("write a null");
      this.m();
   }

   protected final void g(String var1) throws IOException {
      int var2 = this.l.a(var1);
      if (var2 == 4) {
         this.e("Can not write a field name, expecting a value");
      }

      if (var2 == 1) {
         this.a.c(this);
      } else {
         this.a.h(this);
      }

      if (this.C) {
         this.a(var1, false);
      } else {
         int var3 = var1.length();
         if (var3 > this.A) {
            this.a(var1, true);
         } else {
            if (this.w >= this.x) {
               this.l();
            }

            byte[] var4 = this.v;
            var2 = this.w++;
            var4[var2] = 34;
            var1.getChars(0, var3, this.z, 0);
            if (var3 <= this.y) {
               if (this.w + var3 > this.x) {
                  this.l();
               }

               this.d(this.z, 0, var3);
            } else {
               this.c(this.z, 0, var3);
            }

            if (this.w >= this.x) {
               this.l();
            }

            byte[] var5 = this.v;
            var2 = this.w++;
            var5[var2] = 34;
         }
      }
   }

   @Override
   protected void j() {
      byte[] var1 = this.v;
      if (var1 != null && this.B) {
         this.v = null;
         this.o.b(var1);
      }

      char[] var2 = this.z;
      if (var2 != null) {
         this.z = null;
         this.o.b(var2);
      }
   }

   protected final void l() throws IOException {
      int var1 = this.w;
      if (var1 > 0) {
         this.w = 0;
         this.u.write(this.v, 0, var1);
      }
   }
}
