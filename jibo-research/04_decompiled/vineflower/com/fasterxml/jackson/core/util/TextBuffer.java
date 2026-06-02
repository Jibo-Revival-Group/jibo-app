package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.NumberInput;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public final class TextBuffer {
   static final char[] a = new char[0];
   private final BufferRecycler b;
   private char[] c;
   private int d;
   private int e;
   private ArrayList<char[]> f;
   private boolean g = false;
   private int h;
   private char[] i;
   private int j;
   private String k;
   private char[] l;

   public TextBuffer(BufferRecycler var1) {
      this.b = var1;
   }

   private char[] c(int var1) {
      char[] var2;
      if (this.b != null) {
         var2 = this.b.b(2, var1);
      } else {
         var2 = new char[Math.max(var1, 1000)];
      }

      return var2;
   }

   private void d(int var1) {
      int var2 = this.e;
      this.e = 0;
      char[] var4 = this.c;
      this.c = null;
      int var3 = this.d;
      this.d = -1;
      var1 = var2 + var1;
      if (this.i == null || var1 > this.i.length) {
         this.i = this.c(var1);
      }

      if (var2 > 0) {
         System.arraycopy(var4, var3, this.i, 0, var2);
      }

      this.h = 0;
      this.j = var2;
   }

   private void e(int var1) {
      var1 = 1000;
      if (this.f == null) {
         this.f = new ArrayList<>();
      }

      char[] var3 = this.i;
      this.g = true;
      this.f.add(var3);
      this.h += var3.length;
      this.j = 0;
      int var2 = var3.length;
      var2 += var2 >> 1;
      if (var2 >= 1000) {
         if (var2 > 262144) {
            var1 = 262144;
         } else {
            var1 = var2;
         }
      }

      this.i = this.f(var1);
   }

   private char[] f(int var1) {
      return new char[var1];
   }

   private void o() {
      this.g = false;
      this.f.clear();
      this.h = 0;
      this.j = 0;
   }

   private char[] p() {
      char[] var5;
      if (this.k != null) {
         var5 = this.k.toCharArray();
      } else if (this.d >= 0) {
         int var1 = this.e;
         if (var1 < 1) {
            var5 = a;
         } else {
            int var2 = this.d;
            if (var2 == 0) {
               var5 = Arrays.copyOf(this.c, var1);
            } else {
               var5 = Arrays.copyOfRange(this.c, var2, var1 + var2);
            }
         }
      } else {
         int var7 = this.c();
         if (var7 < 1) {
            var5 = a;
         } else {
            var5 = this.f(var7);
            if (this.f != null) {
               int var3 = this.f.size();
               int var9 = 0;
               var7 = 0;

               while (var9 < var3) {
                  char[] var6 = this.f.get(var9);
                  int var4 = var6.length;
                  System.arraycopy(var6, 0, var5, var7, var4);
                  var7 += var4;
                  var9++;
               }
            } else {
               var7 = 0;
            }

            System.arraycopy(this.i, 0, var5, var7, this.j);
         }
      }

      return var5;
   }

   public void a() {
      if (this.b == null) {
         this.b();
      } else if (this.i != null) {
         this.b();
         char[] var1 = this.i;
         this.i = null;
         this.b.a(2, var1);
      }
   }

   public void a(int var1) {
      this.j = var1;
   }

   public void a(String var1) {
      this.c = null;
      this.d = -1;
      this.e = 0;
      this.k = var1;
      this.l = null;
      if (this.g) {
         this.o();
      }

      this.j = 0;
   }

   public void a(char[] var1, int var2, int var3) {
      this.k = null;
      this.l = null;
      this.c = var1;
      this.d = var2;
      this.e = var3;
      if (this.g) {
         this.o();
      }
   }

   public String b(int var1) {
      this.j = var1;
      String var2;
      if (this.h > 0) {
         var2 = this.f();
      } else {
         var1 = this.j;
         if (var1 == 0) {
            var2 = "";
         } else {
            var2 = new String(this.i, 0, var1);
         }

         this.k = var2;
      }

      return var2;
   }

   public void b() {
      this.d = -1;
      this.j = 0;
      this.e = 0;
      this.c = null;
      this.k = null;
      this.l = null;
      if (this.g) {
         this.o();
      }
   }

   public void b(char[] var1, int var2, int var3) {
      this.c = null;
      this.d = -1;
      this.e = 0;
      this.k = null;
      this.l = null;
      if (this.g) {
         this.o();
      } else if (this.i == null) {
         this.i = this.c(var3);
      }

      this.h = 0;
      this.j = 0;
      this.c(var1, var2, var3);
   }

   public int c() {
      int var1;
      if (this.d >= 0) {
         var1 = this.e;
      } else if (this.l != null) {
         var1 = this.l.length;
      } else if (this.k != null) {
         var1 = this.k.length();
      } else {
         var1 = this.h + this.j;
      }

      return var1;
   }

   public void c(char[] var1, int var2, int var3) {
      if (this.d >= 0) {
         this.d(var3);
      }

      this.k = null;
      this.l = null;
      char[] var7 = this.i;
      int var6 = var7.length - this.j;
      if (var6 >= var3) {
         System.arraycopy(var1, var2, var7, this.j, var3);
         this.j += var3;
      } else {
         int var5 = var2;
         int var4 = var3;
         if (var6 > 0) {
            System.arraycopy(var1, var2, var7, this.j, var6);
            var5 = var2 + var6;
            var4 = var3 - var6;
         }

         do {
            this.e(var4);
            int var8 = Math.min(this.i.length, var4);
            System.arraycopy(var1, var5, this.i, 0, var8);
            this.j += var8;
            var5 += var8;
            var2 = var4 - var8;
            var4 = var2;
         } while (var2 > 0);
      }
   }

   public int d() {
      int var1;
      if (this.d >= 0) {
         var1 = this.d;
      } else {
         var1 = 0;
      }

      return var1;
   }

   public char[] e() {
      char[] var1;
      if (this.d >= 0) {
         var1 = this.c;
      } else if (this.l != null) {
         var1 = this.l;
      } else if (this.k != null) {
         var1 = this.k.toCharArray();
         this.l = var1;
      } else if (!this.g) {
         if (this.i == null) {
            var1 = a;
         } else {
            var1 = this.i;
         }
      } else {
         var1 = this.g();
      }

      return var1;
   }

   public String f() {
      if (this.k == null) {
         if (this.l != null) {
            this.k = new String(this.l);
         } else if (this.d >= 0) {
            if (this.e < 1) {
               String var3 = "";
               this.k = "";
               return var3;
            }

            this.k = new String(this.c, this.d, this.e);
         } else {
            int var1 = this.h;
            int var2 = this.j;
            if (var1 == 0) {
               String var7;
               if (var2 == 0) {
                  var7 = "";
               } else {
                  var7 = new String(this.i, 0, var2);
               }

               this.k = var7;
            } else {
               StringBuilder var4 = new StringBuilder(var1 + var2);
               if (this.f != null) {
                  var2 = this.f.size();

                  for (int var5 = 0; var5 < var2; var5++) {
                     char[] var8 = this.f.get(var5);
                     var4.append(var8, 0, var8.length);
                  }
               }

               var4.append(this.i, 0, this.j);
               this.k = var4.toString();
            }
         }
      }

      return this.k;
   }

   public char[] g() {
      char[] var2 = this.l;
      char[] var1 = var2;
      if (var2 == null) {
         var1 = this.p();
         this.l = var1;
      }

      return var1;
   }

   public BigDecimal h() throws NumberFormatException {
      BigDecimal var1;
      if (this.l != null) {
         var1 = NumberInput.a(this.l);
      } else if (this.d >= 0 && this.c != null) {
         var1 = NumberInput.c(this.c, this.d, this.e);
      } else if (this.h == 0 && this.i != null) {
         var1 = NumberInput.c(this.i, 0, this.j);
      } else {
         var1 = NumberInput.a(this.g());
      }

      return var1;
   }

   public double i() throws NumberFormatException {
      return NumberInput.a(this.f());
   }

   public char[] j() {
      if (this.d >= 0) {
         this.d(1);
      } else {
         char[] var1 = this.i;
         if (var1 == null) {
            this.i = this.c(0);
         } else if (this.j >= var1.length) {
            this.e(1);
         }
      }

      return this.i;
   }

   public char[] k() {
      this.d = -1;
      this.j = 0;
      this.e = 0;
      this.c = null;
      this.k = null;
      this.l = null;
      if (this.g) {
         this.o();
      }

      char[] var2 = this.i;
      char[] var1 = var2;
      if (var2 == null) {
         var1 = this.c(0);
         this.i = var1;
      }

      return var1;
   }

   public int l() {
      return this.j;
   }

   public char[] m() {
      int var1 = 1000;
      if (this.f == null) {
         this.f = new ArrayList<>();
      }

      this.g = true;
      this.f.add(this.i);
      int var2 = this.i.length;
      this.h += var2;
      this.j = 0;
      var2 += var2 >> 1;
      if (var2 >= 1000) {
         if (var2 > 262144) {
            var1 = 262144;
         } else {
            var1 = var2;
         }
      }

      char[] var3 = this.f(var1);
      this.i = var3;
      return var3;
   }

   public char[] n() {
      char[] var4 = this.i;
      int var3 = var4.length;
      int var2 = (var3 >> 1) + var3;
      int var1 = var2;
      if (var2 > 262144) {
         var1 = (var3 >> 2) + var3;
      }

      var4 = Arrays.copyOf(var4, var1);
      this.i = var4;
      return var4;
   }

   @Override
   public String toString() {
      return this.f();
   }
}
