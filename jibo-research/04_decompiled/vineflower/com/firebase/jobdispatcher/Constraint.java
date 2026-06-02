package com.firebase.jobdispatcher;

public final class Constraint {
   static final int[] a = new int[]{2, 1, 4, 8};

   static int a(int[] var0) {
      int var1 = 0;
      int var3 = 0;
      if (var0 != null) {
         int var4 = var0.length;
         int var2 = 0;

         while (true) {
            var3 = var1;
            if (var2 >= var4) {
               break;
            }

            var3 = var0[var2];
            var2++;
            var1 |= var3;
         }
      }

      return var3;
   }

   static int[] a(int var0) {
      int var4 = 0;
      int[] var6 = a;
      int var5 = var6.length;
      int var2 = 0;
      int var1 = 0;

      while (var2 < var5) {
         int var3 = var6[var2];
         byte var10;
         if ((var0 & var3) == var3) {
            var10 = 1;
         } else {
            var10 = 0;
         }

         var1 += var10;
         var2++;
      }

      int[] var7 = new int[var1];
      var6 = a;
      var5 = var6.length;
      var2 = 0;
      var1 = var4;

      while (var2 < var5) {
         var4 = var6[var2];
         if ((var0 & var4) == var4) {
            int var11 = var1 + 1;
            var7[var1] = var4;
            var1 = var11;
         }

         var2++;
      }

      return var7;
   }
}
