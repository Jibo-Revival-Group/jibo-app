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
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class WriterBasedJsonGenerator extends JsonGeneratorImpl {
   protected static final char[] t = CharTypes.g();
   protected SerializableString A;
   protected final Writer u;
   protected char[] v;
   protected int w = 0;
   protected int x = 0;
   protected int y;
   protected char[] z;

   public WriterBasedJsonGenerator(IOContext var1, int var2, ObjectCodec var3, Writer var4) {
      super(var1, var2, var3);
      this.u = var4;
      this.v = var1.h();
      this.y = this.v.length;
   }

   private int a(char[] var1, int var2, int var3, char var4, int var5) throws IOException, JsonGenerationException {
      if (var5 >= 0) {
         if (var2 > 1 && var2 < var3) {
            var2 -= 2;
            var1[var2] = '\\';
            var1[var2 + 1] = (char)var5;
         } else {
            char[] var6 = this.z;
            var1 = var6;
            if (var6 == null) {
               var1 = this.n();
            }

            var1[1] = (char)var5;
            this.u.write(var1, 0, 2);
         }
      } else if (var5 != -2) {
         if (var2 > 5 && var2 < var3) {
            var2 -= 6;
            var3 = var2 + 1;
            var1[var2] = '\\';
            var2 = var3 + 1;
            var1[var3] = 'u';
            if (var4 > 255) {
               var3 = var4 >> 8 & 0xFF;
               var5 = var2 + 1;
               var1[var2] = t[var3 >> 4];
               var2 = var5 + 1;
               var1[var5] = t[var3 & 15];
               var4 = (char)(var4 & 0xFF);
            } else {
               var3 = var2 + 1;
               var1[var2] = '0';
               var2 = var3 + 1;
               var1[var3] = '0';
            }

            var3 = var2 + 1;
            var1[var2] = t[var4 >> 4];
            var1[var3] = t[var4 & 15];
            var2 = var3 - 5;
         } else {
            char[] var20 = this.z;
            var1 = var20;
            if (var20 == null) {
               var1 = this.n();
            }

            this.w = this.x;
            if (var4 > 255) {
               var3 = var4 >> 8 & 0xFF;
               var4 &= 255;
               var1[10] = t[var3 >> 4];
               var1[11] = t[var3 & 15];
               var1[12] = t[var4 >> 4];
               var1[13] = t[var4 & 15];
               this.u.write(var1, 8, 6);
            } else {
               var1[6] = t[var4 >> 4];
               var1[7] = t[var4 & 15];
               this.u.write(var1, 2, 6);
            }
         }
      } else {
         String var21;
         if (this.A == null) {
            var21 = this.r.a(var4).a();
         } else {
            var21 = this.A.a();
            this.A = null;
         }

         var4 = var21.length();
         if (var2 >= var4 && var2 < var3) {
            var2 -= var4;
            var21.getChars(0, var4, var1, var2);
         } else {
            this.u.write(var21);
         }
      }

      return var2;
   }

   private void a(char var1, int var2) throws IOException, JsonGenerationException {
      if (var2 >= 0) {
         if (this.x >= 2) {
            var1 = this.x - 2;
            this.w = var1;
            this.v[var1] = '\\';
            this.v[var1 + 1] = (char)var2;
         } else {
            char[] var5 = this.z;
            char[] var4 = var5;
            if (var5 == null) {
               var4 = this.n();
            }

            this.w = this.x;
            var4[1] = (char)var2;
            this.u.write(var4, 0, 2);
         }
      } else if (var2 != -2) {
         if (this.x >= 6) {
            char[] var17 = this.v;
            var2 = this.x - 6;
            this.w = var2;
            var17[var2] = '\\';
            var17[++var2] = 'u';
            if (var1 > 255) {
               int var3 = var1 >> 8 & 0xFF;
               var17[++var2] = t[var3 >> 4];
               var17[++var2] = t[var3 & 15];
               var1 = (char)(var1 & 0xFF);
            } else {
               var17[++var2] = '0';
               var17[++var2] = '0';
            }

            var17[++var2] = t[var1 >> 4];
            var17[var2 + 1] = t[var1 & 15];
         } else {
            char[] var20 = this.z;
            char[] var18 = var20;
            if (var20 == null) {
               var18 = this.n();
            }

            this.w = this.x;
            if (var1 > 255) {
               var2 = var1 >> 8 & 0xFF;
               var1 &= 255;
               var18[10] = t[var2 >> 4];
               var18[11] = t[var2 & 15];
               var18[12] = t[var1 >> 4];
               var18[13] = t[var1 & 15];
               this.u.write(var18, 8, 6);
            } else {
               var18[6] = t[var1 >> 4];
               var18[7] = t[var1 & 15];
               this.u.write(var18, 2, 6);
            }
         }
      } else {
         String var19;
         if (this.A == null) {
            var19 = this.r.a(var1).a();
         } else {
            var19 = this.A.a();
            this.A = null;
         }

         var1 = var19.length();
         if (this.x >= var1) {
            var2 = this.x - var1;
            this.w = var2;
            var19.getChars(0, var1, this.v, var2);
         } else {
            this.w = this.x;
            this.u.write(var19);
         }
      }
   }

   private void b(int var1, int var2) throws IOException, JsonGenerationException {
      int var5 = this.x + var1;
      int[] var7 = this.p;
      int var4 = Math.min(var7.length, var2 + 1);

      while (this.x < var5) {
         char var3;
         while (true) {
            var3 = this.v[this.x];
            if (var3 < var4) {
               var1 = var7[var3];
               if (var1 != 0) {
                  break;
               }
            } else if (var3 > var2) {
               var1 = -1;
               break;
            }

            var1 = this.x + 1;
            this.x = var1;
            if (var1 >= var5) {
               return;
            }
         }

         int var6 = this.x - this.w;
         if (var6 > 0) {
            this.u.write(this.v, this.w, var6);
         }

         this.x++;
         this.a(var3, var1);
      }
   }

   private void b(long var1) throws IOException {
      if (this.x + 23 >= this.y) {
         this.l();
      }

      char[] var4 = this.v;
      int var3 = this.x++;
      var4[var3] = '"';
      this.x = NumberOutput.a(var1, this.v, this.x);
      var4 = this.v;
      var3 = this.x++;
      var4[var3] = '"';
   }

   private void c(int var1) throws IOException {
      if (this.x + 13 >= this.y) {
         this.l();
      }

      char[] var3 = this.v;
      int var2 = this.x++;
      var3[var2] = '"';
      this.x = NumberOutput.a(var1, this.v, this.x);
      var3 = this.v;
      var1 = this.x++;
      var3[var1] = '"';
   }

   private void c(int var1, int var2) throws IOException, JsonGenerationException {
      int var4 = 0;
      int[] var10 = this.p;
      int var9 = Math.min(var10.length, var2 + 1);
      int var6 = 0;
      int var5 = 0;

      while (var5 < var1) {
         int var8 = var4;

         char var3;
         while (true) {
            var3 = this.v[var5];
            if (var3 < var9) {
               var4 = var10[var3];
               if (var4 != 0) {
                  break;
               }
            } else {
               var4 = var8;
               if (var3 > var2) {
                  var4 = -1;
                  break;
               }
            }

            int var7 = var5 + 1;
            var8 = var4;
            var5 = var7;
            if (var7 >= var1) {
               var5 = var7;
               break;
            }
         }

         int var11 = var5 - var6;
         if (var11 > 0) {
            this.u.write(this.v, var6, var11);
            if (var5 >= var1) {
               break;
            }
         }

         var6 = this.a(this.v, ++var5, var1, var3, var4);
      }
   }

   private void d(int var1) throws IOException {
      int var3 = this.x + var1;
      int[] var6 = this.p;
      var1 = var6.length;

      label23:
      while (this.x < var3) {
         int var8;
         do {
            int var4 = this.v[this.x];
            if (var4 < var1 && var6[var4] != 0) {
               var4 = this.x - this.w;
               if (var4 > 0) {
                  this.u.write(this.v, this.w, var4);
               }

               char[] var5 = this.v;
               var4 = this.x++;
               char var2 = var5[var4];
               this.a(var2, var6[var2]);
               continue label23;
            }

            var8 = this.x + 1;
            this.x = var8;
         } while (var8 < var3);

         return;
      }
   }

   private void e(int var1) throws IOException {
      int[] var7 = this.p;
      int var6 = var7.length;
      int var3 = 0;
      int var4 = 0;

      while (var3 < var1) {
         char var2;
         while (true) {
            var2 = this.v[var3];
            if (var2 < var6 && var7[var2] != 0) {
               break;
            }

            int var5 = var3 + 1;
            var3 = var5;
            if (var5 >= var1) {
               var3 = var5;
               break;
            }
         }

         int var8 = var3 - var4;
         if (var8 > 0) {
            this.u.write(this.v, var4, var8);
            if (var3 >= var1) {
               break;
            }
         }

         var4 = this.a(this.v, ++var3, var1, var2, var7[var2]);
      }
   }

   private void f(int var1) throws IOException, JsonGenerationException {
      int var4 = this.x + var1;
      int[] var9 = this.p;
      int var3;
      if (this.q < 1) {
         var3 = 65535;
      } else {
         var3 = this.q;
      }

      int var5 = Math.min(var9.length, var3 + 1);
      CharacterEscapes var7 = this.r;

      while (this.x < var4) {
         char var2;
         while (true) {
            var2 = this.v[this.x];
            if (var2 < var5) {
               var1 = var9[var2];
               if (var1 != 0) {
                  break;
               }
            } else {
               if (var2 > var3) {
                  var1 = -1;
                  break;
               }

               SerializableString var8 = var7.a(var2);
               this.A = var8;
               if (var8 != null) {
                  var1 = -2;
                  break;
               }
            }

            var1 = this.x + 1;
            this.x = var1;
            if (var1 >= var4) {
               return;
            }
         }

         int var6 = this.x - this.w;
         if (var6 > 0) {
            this.u.write(this.v, this.w, var6);
         }

         this.x++;
         this.a(var2, var1);
      }
   }

   private void g(int var1) throws IOException, JsonGenerationException {
      int var4 = 0;
      int[] var12 = this.p;
      int var5;
      if (this.q < 1) {
         var5 = 65535;
      } else {
         var5 = this.q;
      }

      int var9 = Math.min(var12.length, var5 + 1);
      CharacterEscapes var11 = this.r;
      int var6 = 0;
      int var3 = 0;

      while (var4 < var1) {
         int var8 = var3;

         char var2;
         while (true) {
            var2 = this.v[var4];
            if (var2 < var9) {
               var3 = var12[var2];
               if (var3 != 0) {
                  break;
               }
            } else {
               if (var2 > var5) {
                  var3 = -1;
                  break;
               }

               SerializableString var10 = var11.a(var2);
               this.A = var10;
               var3 = var8;
               if (var10 != null) {
                  var3 = -2;
                  break;
               }
            }

            int var7 = var4 + 1;
            var8 = var3;
            var4 = var7;
            if (var7 >= var1) {
               var4 = var7;
               break;
            }
         }

         int var13 = var4 - var6;
         if (var13 > 0) {
            this.u.write(this.v, var6, var13);
            if (var4 >= var1) {
               break;
            }
         }

         var6 = this.a(this.v, ++var4, var1, var2, var3);
      }
   }

   private void h(String var1) throws IOException {
      int var3 = this.y - this.x;
      var1.getChars(0, var3, this.v, this.x);
      this.x += var3;
      this.l();
      int var2 = var1.length() - var3;

      while (var2 > this.y) {
         int var4 = this.y;
         var1.getChars(var3, var3 + var4, this.v, 0);
         this.w = 0;
         this.x = var4;
         this.l();
         var3 += var4;
         var2 -= var4;
      }

      var1.getChars(var3, var3 + var2, this.v, 0);
      this.w = 0;
      this.x = var2;
   }

   private void i(String var1) throws IOException {
      if (this.x >= this.y) {
         this.l();
      }

      char[] var3 = this.v;
      int var2 = this.x++;
      var3[var2] = '"';
      this.c(var1);
      if (this.x >= this.y) {
         this.l();
      }

      char[] var4 = this.v;
      var2 = this.x++;
      var4[var2] = '"';
   }

   private void j(String var1) throws IOException {
      int var2 = var1.length();
      if (var2 > this.y) {
         this.k(var1);
      } else {
         if (this.x + var2 > this.y) {
            this.l();
         }

         var1.getChars(0, var2, this.v, this.x);
         if (this.r != null) {
            this.f(var2);
         } else if (this.q != 0) {
            this.b(var2, this.q);
         } else {
            this.d(var2);
         }
      }
   }

   private void k(String var1) throws IOException {
      this.l();
      int var5 = var1.length();
      int var2 = 0;

      int var6;
      do {
         int var4 = this.y;
         var6 = var4;
         if (var2 + var4 > var5) {
            var6 = var5 - var2;
         }

         var1.getChars(var2, var2 + var6, this.v, 0);
         if (this.r != null) {
            this.g(var6);
         } else if (this.q != 0) {
            this.c(var6, this.q);
         } else {
            this.e(var6);
         }

         var6 = var2 + var6;
         var2 = var6;
      } while (var6 < var5);
   }

   private final void m() throws IOException {
      if (this.x + 4 >= this.y) {
         this.l();
      }

      int var1 = this.x;
      char[] var2 = this.v;
      var2[var1] = 'n';
      var2[++var1] = 'u';
      var2[++var1] = 'l';
      var2[++var1] = 'l';
      this.x = var1 + 1;
   }

   private char[] n() {
      char[] var1 = new char[14];
      var1[0] = '\\';
      var1[2] = '\\';
      var1[3] = 'u';
      var1[4] = '0';
      var1[5] = '0';
      var1[8] = '\\';
      var1[9] = 'u';
      this.z = var1;
      return var1;
   }

   @Override
   public void a(char var1) throws IOException {
      if (this.x >= this.y) {
         this.l();
      }

      char[] var3 = this.v;
      int var2 = this.x++;
      var3[var2] = var1;
   }

   @Override
   public void a(double var1) throws IOException {
      if (!this.k && (!this.a(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS) || !Double.isNaN(var1) && !Double.isInfinite(var1))) {
         this.f("write a number");
         this.c(String.valueOf(var1));
      } else {
         this.b(String.valueOf(var1));
      }
   }

   @Override
   public void a(float var1) throws IOException {
      if (!this.k && (!this.a(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS) || !Float.isNaN(var1) && !Float.isInfinite(var1))) {
         this.f("write a number");
         this.c(String.valueOf(var1));
      } else {
         this.b(String.valueOf(var1));
      }
   }

   @Override
   public void a(long var1) throws IOException {
      this.f("write a number");
      if (this.k) {
         this.b(var1);
      } else {
         if (this.x + 21 >= this.y) {
            this.l();
         }

         this.x = NumberOutput.a(var1, this.v, this.x);
      }
   }

   @Override
   public void a(String var1) throws IOException {
      boolean var3 = true;
      int var2 = this.l.a(var1);
      if (var2 == 4) {
         this.e("Can not write a field name, expecting a value");
      }

      if (var2 != 1) {
         var3 = false;
      }

      this.a(var1, var3);
   }

   protected void a(String var1, boolean var2) throws IOException {
      if (this.a != null) {
         this.b(var1, var2);
      } else {
         if (this.x + 1 >= this.y) {
            this.l();
         }

         if (var2) {
            char[] var4 = this.v;
            int var3 = this.x++;
            var4[var3] = ',';
         }

         if (!this.a(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            this.j(var1);
         } else {
            char[] var8 = this.v;
            int var6 = this.x++;
            var8[var6] = '"';
            this.j(var1);
            if (this.x >= this.y) {
               this.l();
            }

            char[] var5 = this.v;
            var6 = this.x++;
            var5[var6] = '"';
         }
      }
   }

   @Override
   public void a(BigDecimal var1) throws IOException {
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

         this.i(var2);
      } else if (this.a(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)) {
         this.c(var1.toPlainString());
      } else {
         this.c(var1.toString());
      }
   }

   @Override
   public void a(BigInteger var1) throws IOException {
      this.f("write a number");
      if (var1 == null) {
         this.m();
      } else if (this.k) {
         this.i(var1.toString());
      } else {
         this.c(var1.toString());
      }
   }

   @Override
   public void a(boolean var1) throws IOException {
      this.f("write a boolean value");
      if (this.x + 5 >= this.y) {
         this.l();
      }

      int var2 = this.x;
      char[] var3 = this.v;
      if (var1) {
         var3[var2] = 't';
         var3[++var2] = 'r';
         var3[++var2] = 'u';
         var3[++var2] = 'e';
      } else {
         var3[var2] = 'f';
         var3[++var2] = 'a';
         var3[++var2] = 'l';
         var3[++var2] = 's';
         var3[++var2] = 'e';
      }

      this.x = var2 + 1;
   }

   @Override
   public void a(char[] var1, int var2, int var3) throws IOException {
      if (var3 < 32) {
         if (var3 > this.y - this.x) {
            this.l();
         }

         System.arraycopy(var1, var2, this.v, this.x, var3);
         this.x += var3;
      } else {
         this.l();
         this.u.write(var1, var2, var3);
      }
   }

   @Override
   public void b(int var1) throws IOException {
      this.f("write a number");
      if (this.k) {
         this.c(var1);
      } else {
         if (this.x + 11 >= this.y) {
            this.l();
         }

         this.x = NumberOutput.a(var1, this.v, this.x);
      }
   }

   @Override
   public void b(SerializableString var1) throws IOException {
      this.c(var1.a());
   }

   @Override
   public void b(String var1) throws IOException {
      this.f("write a string");
      if (var1 == null) {
         this.m();
      } else {
         if (this.x >= this.y) {
            this.l();
         }

         char[] var3 = this.v;
         int var2 = this.x++;
         var3[var2] = '"';
         this.j(var1);
         if (this.x >= this.y) {
            this.l();
         }

         char[] var4 = this.v;
         var2 = this.x++;
         var4[var2] = '"';
      }
   }

   protected void b(String var1, boolean var2) throws IOException, JsonGenerationException {
      if (var2) {
         this.a.c(this);
      } else {
         this.a.h(this);
      }

      if (this.a(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
         if (this.x >= this.y) {
            this.l();
         }

         char[] var4 = this.v;
         int var3 = this.x++;
         var4[var3] = '"';
         this.j(var1);
         if (this.x >= this.y) {
            this.l();
         }

         char[] var5 = this.v;
         var3 = this.x++;
         var5[var3] = '"';
      } else {
         this.j(var1);
      }
   }

   @Override
   public void c() throws IOException, JsonGenerationException {
      this.f("start an array");
      this.l = this.l.g();
      if (this.a != null) {
         this.a.e(this);
      } else {
         if (this.x >= this.y) {
            this.l();
         }

         char[] var2 = this.v;
         int var1 = this.x++;
         var2[var1] = '[';
      }
   }

   @Override
   public void c(String var1) throws IOException {
      int var4 = var1.length();
      int var3 = this.y - this.x;
      int var2 = var3;
      if (var3 == 0) {
         this.l();
         var2 = this.y - this.x;
      }

      if (var2 >= var4) {
         var1.getChars(0, var4, this.v, this.x);
         this.x += var4;
      } else {
         this.h(var1);
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
      this.x = 0;
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
   public void d() throws IOException, JsonGenerationException {
      if (!this.l.a()) {
         this.e("Current context not an ARRAY but " + this.l.d());
      }

      if (this.a != null) {
         this.a.b(this, this.l.e());
      } else {
         if (this.x >= this.y) {
            this.l();
         }

         char[] var2 = this.v;
         int var1 = this.x++;
         var2[var1] = ']';
      }

      this.l = this.l.i();
   }

   @Override
   public void d(String var1) throws IOException {
      this.f("write a number");
      if (this.k) {
         this.i(var1);
      } else {
         this.c(var1);
      }
   }

   @Override
   public void e() throws IOException, JsonGenerationException {
      this.f("start an object");
      this.l = this.l.h();
      if (this.a != null) {
         this.a.b(this);
      } else {
         if (this.x >= this.y) {
            this.l();
         }

         char[] var2 = this.v;
         int var1 = this.x++;
         var2[var1] = '{';
      }
   }

   @Override
   public void f() throws IOException, JsonGenerationException {
      if (!this.l.c()) {
         this.e("Current context not an object but " + this.l.d());
      }

      if (this.a != null) {
         this.a.a(this, this.l.e());
      } else {
         if (this.x >= this.y) {
            this.l();
         }

         char[] var2 = this.v;
         int var1 = this.x++;
         var2[var1] = '}';
      }

      this.l = this.l.i();
   }

   @Override
   protected void f(String var1) throws IOException {
      if (this.a != null) {
         this.g(var1);
      } else {
         int var3 = this.l.j();
         if (var3 == 5) {
            this.e("Can not " + var1 + ", expecting field name");
         }

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
                  this.c(this.s.a());
               }

               return;
            default:
               return;
         }

         if (this.x >= this.y) {
            this.l();
         }

         this.v[this.x] = (char)var2;
         this.x++;
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
   public void g() throws IOException {
      this.f("write a null");
      this.m();
   }

   protected void g(String var1) throws IOException {
      int var2 = this.l.j();
      if (var2 == 5) {
         this.e("Can not " + var1 + ", expecting field name");
      }

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
   protected void j() {
      char[] var1 = this.v;
      if (var1 != null) {
         this.v = null;
         this.o.b(var1);
      }
   }

   protected void l() throws IOException {
      int var2 = this.x - this.w;
      if (var2 > 0) {
         int var1 = this.w;
         this.w = 0;
         this.x = 0;
         this.u.write(this.v, var1, var2);
      }
   }
}
