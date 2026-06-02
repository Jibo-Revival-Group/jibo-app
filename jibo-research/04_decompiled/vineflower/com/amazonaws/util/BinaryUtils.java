package com.amazonaws.util;

import java.util.Locale;

public class BinaryUtils {
   public static String toHex(byte[] var0) {
      StringBuilder var4 = new StringBuilder(var0.length * 2);

      for (int var1 = 0; var1 < var0.length; var1++) {
         String var3 = Integer.toHexString(var0[var1]);
         String var2;
         if (var3.length() == 1) {
            var4.append("0");
            var2 = var3;
         } else {
            var2 = var3;
            if (var3.length() == 8) {
               var2 = var3.substring(6);
            }
         }

         var4.append(var2);
      }

      return var4.toString().toLowerCase(Locale.getDefault());
   }
}
