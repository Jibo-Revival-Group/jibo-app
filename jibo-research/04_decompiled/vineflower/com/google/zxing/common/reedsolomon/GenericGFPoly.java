package com.google.zxing.common.reedsolomon;

final class GenericGFPoly {
   private final GenericGF a;
   private final int[] b;

   GenericGFPoly(GenericGF var1, int[] var2) {
      if (var2.length == 0) {
         throw new IllegalArgumentException();
      }

      this.a = var1;
      int var4 = var2.length;
      if (var4 > 1 && var2[0] == 0) {
         int var3 = 1;

         while (var3 < var4 && var2[var3] == 0) {
            var3++;
         }

         if (var3 == var4) {
            this.b = new int[]{0};
         } else {
            this.b = new int[var4 - var3];
            System.arraycopy(var2, var3, this.b, 0, this.b.length);
         }
      } else {
         this.b = var2;
      }
   }

   int a(int var1) {
      return this.b[this.b.length - 1 - var1];
   }

   GenericGFPoly a(int var1, int var2) {
      if (var1 < 0) {
         throw new IllegalArgumentException();
      }

      GenericGFPoly var4;
      if (var2 == 0) {
         var4 = this.a.a();
      } else {
         int var3 = this.b.length;
         int[] var6 = new int[var3 + var1];

         for (int var5 = 0; var5 < var3; var5++) {
            var6[var5] = this.a.c(this.b[var5], var2);
         }

         var4 = new GenericGFPoly(this.a, var6);
      }

      return var4;
   }

   GenericGFPoly a(GenericGFPoly var1) {
      if (!this.a.equals(var1.a)) {
         throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
      }

      if (!this.c()) {
         if (var1.c()) {
            var1 = this;
         } else {
            int[] var4 = this.b;
            int[] var5 = var1.b;
            int[] var6;
            if (var4.length > var5.length) {
               var6 = var5;
            } else {
               var6 = var4;
               var4 = var5;
            }

            var5 = new int[var4.length];
            int var3 = var4.length - var6.length;
            System.arraycopy(var4, 0, var5, 0, var3);

            for (int var2 = var3; var2 < var4.length; var2++) {
               var5[var2] = GenericGF.b(var6[var2 - var3], var4[var2]);
            }

            var1 = new GenericGFPoly(this.a, var5);
         }
      }

      return var1;
   }

   int[] a() {
      return this.b;
   }

   int b() {
      return this.b.length - 1;
   }

   GenericGFPoly b(GenericGFPoly var1) {
      if (!this.a.equals(var1.a)) {
         throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
      }

      if (!this.c() && !var1.c()) {
         int[] var7 = this.b;
         int var5 = var7.length;
         int[] var8 = var1.b;
         int var4 = var8.length;
         int[] var10 = new int[var5 + var4 - 1];

         for (int var2 = 0; var2 < var5; var2++) {
            int var6 = var7[var2];

            for (int var3 = 0; var3 < var4; var3++) {
               var10[var2 + var3] = GenericGF.b(var10[var2 + var3], this.a.c(var6, var8[var3]));
            }
         }

         var1 = new GenericGFPoly(this.a, var10);
      } else {
         var1 = this.a.a();
      }

      return var1;
   }

   boolean c() {
      boolean var1 = false;
      if (this.b[0] == 0) {
         var1 = true;
      }

      return var1;
   }

   GenericGFPoly[] c(GenericGFPoly var1) {
      if (!this.a.equals(var1.a)) {
         throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
      }

      if (var1.c()) {
         throw new IllegalArgumentException("Divide by 0");
      }

      GenericGFPoly var5 = this.a.a();
      int var2 = var1.a(var1.b());
      var2 = this.a.c(var2);
      GenericGFPoly var6 = this;

      while (var6.b() >= var1.b() && !var6.c()) {
         int var3 = var6.b() - var1.b();
         int var4 = this.a.c(var6.a(var6.b()), var2);
         GenericGFPoly var7 = var1.a(var3, var4);
         var5 = var5.a(this.a.a(var3, var4));
         var6 = var6.a(var7);
      }

      return new GenericGFPoly[]{var5, var6};
   }

   @Override
   public String toString() {
      StringBuilder var4 = new StringBuilder(this.b() * 8);

      for (int var1 = this.b(); var1 >= 0; var1--) {
         int var3 = this.a(var1);
         if (var3 != 0) {
            int var2;
            if (var3 < 0) {
               var4.append(" - ");
               var2 = -var3;
            } else {
               var2 = var3;
               if (var4.length() > 0) {
                  var4.append(" + ");
                  var2 = var3;
               }
            }

            if (var1 == 0 || var2 != 1) {
               var2 = this.a.b(var2);
               if (var2 == 0) {
                  var4.append('1');
               } else if (var2 == 1) {
                  var4.append('a');
               } else {
                  var4.append("a^");
                  var4.append(var2);
               }
            }

            if (var1 != 0) {
               if (var1 == 1) {
                  var4.append('x');
               } else {
                  var4.append("x^");
                  var4.append(var1);
               }
            }
         }
      }

      return var4.toString();
   }
}
