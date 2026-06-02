package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;

public final class NumberInput {
   static final String a = String.valueOf(Long.MIN_VALUE).substring(1);
   static final String b = String.valueOf(Long.MAX_VALUE);

   public static double a(String var0) throws NumberFormatException {
      double var1;
      if ("2.2250738585072012e-308".equals(var0)) {
         var1 = Double.MIN_VALUE;
      } else {
         var1 = Double.parseDouble(var0);
      }

      return var1;
   }

   public static int a(char[] var0, int var1, int var2) {
      int var6 = var0[var1] - '0';
      int var3 = var6;
      int var5 = var1;
      int var4 = var2;
      if (var2 > 4) {
         var3 = var1 + 1;
         int var8 = var0[var3];
         var4 = var3 + 1;
         int var16 = var0[var4];
         var5 = var4 + 1;
         int var21 = var0[var5];
         int var7 = var5 + 1;
         var8 = (((var6 * 10 + (var8 - 48)) * 10 + (var16 - 48)) * 10 + (var21 - 48)) * 10 + (var0[var7] - '0');
         var2 -= 4;
         var3 = var8;
         var5 = var7;
         var4 = var2;
         if (var2 > 4) {
            var16 = var7 + 1;
            char var14 = var0[var16];
            var21 = var16 + 1;
            char var19 = var0[var21];
            var21++;
            var8 = (((var8 * 10 + (var14 - '0')) * 10 + (var19 - '0')) * 10 + (var0[var21] - '0')) * 10 + (var0[var21 + 1] - '0');
            return var8;
         }
      }

      var1 = var3;
      if (var4 > 1) {
         var5++;
         var2 = var3 * 10 + (var0[var5] - '0');
         var1 = var2;
         if (var4 > 2) {
            var3 = var5 + 1;
            var2 = var2 * 10 + (var0[var3] - '0');
            var1 = var2;
            if (var4 > 3) {
               var1 = var2 * 10 + (var0[var3 + 1] - '0');
            }
         }
      }

      return var1;
   }

   public static BigDecimal a(char[] var0) throws NumberFormatException {
      return c(var0, 0, var0.length);
   }

   public static boolean a(char[] var0, int var1, int var2, boolean var3) {
      boolean var6 = true;
      String var7;
      if (var3) {
         var7 = a;
      } else {
         var7 = b;
      }

      int var4 = var7.length();
      if (var2 < var4) {
         var3 = var6;
      } else if (var2 > var4) {
         var3 = false;
      } else {
         var2 = 0;

         while (true) {
            var3 = var6;
            if (var2 >= var4) {
               break;
            }

            int var5 = var0[var1 + var2] - var7.charAt(var2);
            if (var5 != 0) {
               if (var5 < 0) {
                  var3 = true;
               } else {
                  var3 = false;
               }
               break;
            }

            var2++;
         }
      }

      return var3;
   }

   public static long b(char[] var0, int var1, int var2) {
      var2 -= 9;
      long var3 = a(var0, var1, var2);
      return a(var0, var2 + var1, 9) + var3 * 1000000000L;
   }

   public static BigDecimal b(String var0) throws NumberFormatException {
      try {
         return new BigDecimal(var0);
      } catch (NumberFormatException var2) {
         throw c(var0);
      }
   }

   private static NumberFormatException c(String var0) {
      return new NumberFormatException("Value \"" + var0 + "\" can not be represented as BigDecimal");
   }

   public static BigDecimal c(char[] var0, int var1, int var2) throws NumberFormatException {
      try {
         return new BigDecimal(var0, var1, var2);
      } catch (NumberFormatException var4) {
         throw c(new String(var0, var1, var2));
      }
   }
}
