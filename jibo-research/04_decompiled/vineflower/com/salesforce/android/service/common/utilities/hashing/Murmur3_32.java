package com.salesforce.android.service.common.utilities.hashing;

public class Murmur3_32 {
   public static int a(CharSequence var0, int var1) {
      return a(var0, 0, var0.length(), var1);
   }

   public static int a(CharSequence var0, int var1, int var2, int var3) {
      int var8 = var1 + var2;
      byte var15 = 0;
      int var6 = 0;
      int var7 = 0;
      int var5 = var3;
      var3 = var1;

      while (var3 < var8) {
         var1 = var3 + 1;
         int var4 = var0.charAt(var3);
         byte var17;
         if (var4 < 128) {
            var17 = 8;
         } else if (var4 < 2048) {
            var4 = (var4 & 63 | 128) << 8 | var4 >> 6 | 192;
            var17 = 16;
         } else if (var4 >= 55296 && var4 <= 57343 && var1 < var8) {
            var4 = (var0.charAt(var1) & 1023) + (var4 - 55232 << 10);
            var17 = 32;
            var1++;
            var4 = (var4 >> 18 | 240) & 0xFF | (var4 >> 12 & 63 | 128) << 8 | (var4 >> 6 & 63 | 128) << 16 | (var4 & 63 | 128) << 24;
         } else {
            var4 = (var4 & 63 | 128) << 16 | var4 >> 12 | 224 | (var4 >> 6 & 63 | 128) << 8;
            var17 = 24;
         }

         var7 |= var4 << var6;
         var6 += var17;
         if (var6 >= 32) {
            var7 *= -862048943;
            var5 = (var7 >>> 17 | var7 << 15) * 461845907 ^ var5;
            var5 = -430675100 + (var5 >>> 19 | var5 << 13) * 5;
            var6 -= 32;
            if (var6 != 0) {
               var17 = var4 >>> var17 - var6;
            } else {
               var17 = 0;
            }

            var4 = var6;
            var15 += 4;
         } else {
            var4 = var6;
            var17 = var7;
         }

         var6 = var4;
         var7 = var17;
         var3 = var1;
      }

      var3 = var15;
      var1 = var5;
      if (var6 > 0) {
         var3 = var15 + (var6 >> 3);
         var1 = -862048943 * var7;
         var1 = var5 ^ (var1 >>> 17 | var1 << 15) * 461845907;
      }

      var1 ^= var3;
      var1 = (var1 ^ var1 >>> 16) * -2048144789;
      var1 = (var1 ^ var1 >>> 13) * -1028477387;
      return var1 ^ var1 >>> 16;
   }
}
