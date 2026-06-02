package org.apache.http.util;

public final class TextUtils {
   public static boolean containsBlanks(CharSequence var0) {
      boolean var3 = false;
      boolean var2;
      if (var0 == null) {
         var2 = var3;
      } else {
         int var1 = 0;

         while (true) {
            var2 = var3;
            if (var1 >= var0.length()) {
               break;
            }

            if (Character.isWhitespace(var0.charAt(var1))) {
               var2 = true;
               break;
            }

            var1++;
         }
      }

      return var2;
   }

   public static boolean isBlank(CharSequence var0) {
      boolean var3 = false;
      boolean var2;
      if (var0 == null) {
         var2 = true;
      } else {
         int var1 = 0;

         while (true) {
            if (var1 >= var0.length()) {
               var2 = true;
               break;
            }

            var2 = var3;
            if (!Character.isWhitespace(var0.charAt(var1))) {
               break;
            }

            var1++;
         }
      }

      return var2;
   }

   public static boolean isEmpty(CharSequence var0) {
      boolean var1 = true;
      if (var0 != null && var0.length() != 0) {
         var1 = false;
      }

      return var1;
   }
}
