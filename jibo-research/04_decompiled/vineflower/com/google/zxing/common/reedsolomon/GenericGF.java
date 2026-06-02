package com.google.zxing.common.reedsolomon;

public final class GenericGF {
   public static final GenericGF a = new GenericGF(4201, 4096, 1);
   public static final GenericGF b = new GenericGF(1033, 1024, 1);
   public static final GenericGF c = new GenericGF(67, 64, 1);
   public static final GenericGF d = new GenericGF(19, 16, 1);
   public static final GenericGF e = new GenericGF(285, 256, 0);
   public static final GenericGF f = new GenericGF(301, 256, 1);
   public static final GenericGF g = f;
   public static final GenericGF h = c;
   private final int[] i;
   private final int[] j;
   private final GenericGFPoly k;
   private final GenericGFPoly l;
   private final int m;
   private final int n;
   private final int o;

   public GenericGF(int var1, int var2, int var3) {
      this.n = var1;
      this.m = var2;
      this.o = var3;
      this.i = new int[var2];
      this.j = new int[var2];
      int var4 = 0;
      var3 = 1;

      while (var4 < var2) {
         this.i[var4] = var3;
         int var5 = var3 * 2;
         var3 = var5;
         if (var5 >= var2) {
            var3 = (var5 ^ var1) & var2 - 1;
         }

         var4++;
      }

      var1 = 0;

      while (var1 < var2 - 1) {
         this.j[this.i[var1]] = var1++;
      }

      this.k = new GenericGFPoly(this, new int[]{0});
      this.l = new GenericGFPoly(this, new int[]{1});
   }

   static int b(int var0, int var1) {
      return var0 ^ var1;
   }

   int a(int var1) {
      return this.i[var1];
   }

   GenericGFPoly a() {
      return this.k;
   }

   GenericGFPoly a(int var1, int var2) {
      if (var1 < 0) {
         throw new IllegalArgumentException();
      }

      GenericGFPoly var3;
      if (var2 == 0) {
         var3 = this.k;
      } else {
         int[] var4 = new int[var1 + 1];
         var4[0] = var2;
         var3 = new GenericGFPoly(this, var4);
      }

      return var3;
   }

   public int b() {
      return this.o;
   }

   int b(int var1) {
      if (var1 == 0) {
         throw new IllegalArgumentException();
      } else {
         return this.j[var1];
      }
   }

   int c(int var1) {
      if (var1 == 0) {
         throw new ArithmeticException();
      } else {
         return this.i[this.m - this.j[var1] - 1];
      }
   }

   int c(int var1, int var2) {
      if (var1 != 0 && var2 != 0) {
         var1 = this.i[(this.j[var1] + this.j[var2]) % (this.m - 1)];
      } else {
         var1 = 0;
      }

      return var1;
   }

   @Override
   public String toString() {
      return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
   }
}
