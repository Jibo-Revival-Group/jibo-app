package com.google.android.gms.common.util;

public final class zzl {
   public static String a(byte[] var0, int var1, int var2, boolean var3) {
      String var7;
      if (var0 != null && var0.length != 0 && var2 > 0 && var2 <= var0.length) {
         StringBuilder var6 = new StringBuilder((var2 + 16 - 1) / 16 * 57);
         int var4 = 0;
         int var5 = var2;
         var1 = 0;

         while (var5 > 0) {
            if (var1 == 0) {
               if (var2 < 65536) {
                  var6.append(String.format("%04X:", var4));
               } else {
                  var6.append(String.format("%08X:", var4));
               }
            } else if (var1 == 8) {
               var6.append(" -");
            }

            var6.append(String.format(" %02X", var0[var4] & 255));
            var5--;
            if (++var1 == 16 || var5 == 0) {
               var6.append('\n');
               var1 = 0;
            }

            var4++;
         }

         var7 = var6.toString();
      } else {
         var7 = null;
      }

      return var7;
   }
}
