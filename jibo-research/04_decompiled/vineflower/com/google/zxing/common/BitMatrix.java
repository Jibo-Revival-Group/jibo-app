package com.google.zxing.common;

import java.util.Arrays;

public final class BitMatrix implements Cloneable {
   private final int a;
   private final int b;
   private final int c;
   private final int[] d;

   public BitMatrix(int var1, int var2) {
      if (var1 >= 1 && var2 >= 1) {
         this.a = var1;
         this.b = var2;
         this.c = (var1 + 31) / 32;
         this.d = new int[this.c * var2];
      } else {
         throw new IllegalArgumentException("Both dimensions must be greater than 0");
      }
   }

   private BitMatrix(int var1, int var2, int var3, int[] var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public int a() {
      return this.a;
   }

   public String a(String var1, String var2) {
      return this.a(var1, var2, System.lineSeparator());
   }

   public String a(String var1, String var2, String var3) {
      StringBuilder var7 = new StringBuilder(this.b * (this.a + 1));

      for (int var4 = 0; var4 < this.b; var4++) {
         for (int var5 = 0; var5 < this.a; var5++) {
            String var6;
            if (this.a(var5, var4)) {
               var6 = var1;
            } else {
               var6 = var2;
            }

            var7.append(var6);
         }

         var7.append(var3);
      }

      return var7.toString();
   }

   public void a(int var1, int var2, int var3, int var4) {
      if (var2 < 0 || var1 < 0) {
         throw new IllegalArgumentException("Left and top must be nonnegative");
      }

      if (var4 >= 1 && var3 >= 1) {
         int var5 = var1 + var3;
         var4 = var2 + var4;
         if (var4 <= this.b && var5 <= this.a) {
            while (var2 < var4) {
               int var6 = this.c;

               for (int var9 = var1; var9 < var5; var9++) {
                  int[] var8 = this.d;
                  int var7 = var9 / 32 + var2 * var6;
                  var8[var7] |= 1 << (var9 & 31);
               }

               var2++;
            }
         } else {
            throw new IllegalArgumentException("The region must fit inside the matrix");
         }
      } else {
         throw new IllegalArgumentException("Height and width must be at least 1");
      }
   }

   public boolean a(int var1, int var2) {
      int var3 = this.c;
      int var4 = var1 / 32;
      boolean var5;
      if ((this.d[var3 * var2 + var4] >>> (var1 & 31) & 1) != 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      return var5;
   }

   public int b() {
      return this.b;
   }

   public BitMatrix c() {
      return new BitMatrix(this.a, this.b, this.c, (int[])this.d.clone());
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof BitMatrix)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (this.a == var1.a) {
            var2 = var3;
            if (this.b == var1.b) {
               var2 = var3;
               if (this.c == var1.c) {
                  var2 = var3;
                  if (Arrays.equals(this.d, var1.d)) {
                     var2 = true;
                  }
               }
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return (((this.a * 31 + this.a) * 31 + this.b) * 31 + this.c) * 31 + Arrays.hashCode(this.d);
   }

   @Override
   public String toString() {
      return this.a("X ", "  ");
   }
}
