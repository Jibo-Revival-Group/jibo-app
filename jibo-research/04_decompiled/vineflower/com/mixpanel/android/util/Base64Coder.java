package com.mixpanel.android.util;

public class Base64Coder {
   private static char[] a = new char[64];
   private static byte[] b;

   static {
      byte var3 = 0;
      char var0 = 'A';

      int var1;
      for (var1 = 0; var0 <= 'Z'; var1++) {
         a[var1] = var0++;
      }

      for (char var5 = 'a'; var5 <= 'z'; var1++) {
         a[var1] = var5++;
      }

      for (char var6 = '0'; var6 <= '9'; var1++) {
         a[var1] = var6++;
      }

      char[] var4 = a;
      int var2 = var1 + 1;
      var4[var1] = '+';
      a[var2] = '/';
      b = new byte[128];
      var2 = 0;

      while (true) {
         var1 = var3;
         if (var2 >= b.length) {
            while (var1 < 64) {
               b[a[var1]] = (byte)var1;
               var1++;
            }

            return;
         }

         b[var2] = -1;
         var2++;
      }
   }

   public static String a(String var0) {
      return new String(a(var0.getBytes()));
   }

   public static char[] a(byte[] var0) {
      return a(var0, var0.length);
   }

   public static char[] a(byte[] var0, int var1) {
      int var8 = (var1 * 4 + 2) / 3;
      char[] var10 = new char[(var1 + 2) / 3 * 4];
      int var13 = 0;

      for (int var3 = 0; var3 < var1; var13++) {
         int var5 = var3 + 1;
         int var9 = var0[var3] & 255;
         if (var5 < var1) {
            var3 = var0[var5] & 255;
            int var6 = var5 + 1;
            var5 = var3;
            var3 = var6;
         } else {
            byte var16 = 0;
            var3 = var5;
            var5 = var16;
         }

         int var17;
         if (var3 < var1) {
            int var7 = var3 + 1;
            var17 = var0[var3] & 255;
            var3 = var7;
         } else {
            var17 = 0;
         }

         int var18 = var13 + 1;
         var10[var13] = a[var9 >>> 2];
         var13 = var18 + 1;
         var10[var18] = a[(var9 & 3) << 4 | var5 >>> 4];
         char var2;
         if (var13 < var8) {
            var2 = a[(var5 & 15) << 2 | var17 >>> 6];
         } else {
            var2 = '=';
         }

         var10[var13] = var2;
         if (++var13 < var8) {
            var2 = a[var17 & 63];
         } else {
            var2 = '=';
         }

         var10[var13] = var2;
      }

      return var10;
   }
}
