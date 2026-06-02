package com.google.zxing.common;

import java.util.Arrays;

public final class BitArray implements Cloneable {
   private int[] a;
   private int b;

   public BitArray() {
      this.b = 0;
      this.a = new int[1];
   }

   BitArray(int[] var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   private void b(int var1) {
      if (var1 > this.a.length * 32) {
         int[] var2 = c(var1);
         System.arraycopy(this.a, 0, var2, 0, this.a.length);
         this.a = var2;
      }
   }

   private static int[] c(int var0) {
      return new int[(var0 + 31) / 32];
   }

   public int a() {
      return this.b;
   }

   public void a(int var1, int var2) {
      if (var2 >= 0 && var2 <= 32) {
         this.b(this.b + var2);

         while (var2 > 0) {
            boolean var3;
            if ((var1 >> var2 - 1 & 1) == 1) {
               var3 = true;
            } else {
               var3 = false;
            }

            this.a(var3);
            var2--;
         }
      } else {
         throw new IllegalArgumentException("Num bits must be between 0 and 32");
      }
   }

   public void a(int var1, byte[] var2, int var3, int var4) {
      for (int var5 = 0; var5 < var4; var5++) {
         int var6 = 0;
         int var7 = 0;

         while (var6 < 8) {
            int var8 = var7;
            if (this.a(var1)) {
               var8 = var7 | 1 << 7 - var6;
            }

            var1++;
            var6++;
            var7 = var8;
         }

         var2[var3 + var5] = (byte)var7;
      }
   }

   public void a(BitArray var1) {
      int var3 = var1.b;
      this.b(this.b + var3);

      for (int var2 = 0; var2 < var3; var2++) {
         this.a(var1.a(var2));
      }
   }

   public void a(boolean var1) {
      this.b(this.b + 1);
      if (var1) {
         int[] var3 = this.a;
         int var2 = this.b / 32;
         var3[var2] |= 1 << (this.b & 31);
      }

      this.b++;
   }

   public boolean a(int var1) {
      boolean var2 = true;
      if ((this.a[var1 / 32] & 1 << (var1 & 31)) == 0) {
         var2 = false;
      }

      return var2;
   }

   public int b() {
      return (this.b + 7) / 8;
   }

   public void b(BitArray var1) {
      if (this.a.length != var1.a.length) {
         throw new IllegalArgumentException("Sizes don't match");
      }

      for (int var2 = 0; var2 < this.a.length; var2++) {
         int[] var3 = this.a;
         var3[var2] ^= var1.a[var2];
      }
   }

   public BitArray c() {
      return new BitArray((int[])this.a.clone(), this.b);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof BitArray)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (this.b == var1.b) {
            var2 = var3;
            if (Arrays.equals(this.a, var1.a)) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.b * 31 + Arrays.hashCode(this.a);
   }

   @Override
   public String toString() {
      StringBuilder var3 = new StringBuilder(this.b);

      for (int var2 = 0; var2 < this.b; var2++) {
         if ((var2 & 7) == 0) {
            var3.append(' ');
         }

         char var1;
         if (this.a(var2)) {
            var1 = 'X';
         } else {
            var1 = '.';
         }

         var3.append(var1);
      }

      return var3.toString();
   }
}
