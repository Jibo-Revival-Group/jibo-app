package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzo {
   private static final Pattern a = Pattern.compile("\\\\.");
   private static final Pattern b = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

   public static String a(String var0) {
      String var1 = var0;
      if (!TextUtils.isEmpty(var0)) {
         Matcher var3 = b.matcher(var0);
         StringBuffer var2 = null;

         while (var3.find()) {
            StringBuffer var4 = var2;
            if (var2 == null) {
               var4 = new StringBuffer();
            }

            switch (var3.group().charAt(0)) {
               case '\b':
                  var3.appendReplacement(var4, "\\\\b");
                  var2 = var4;
                  break;
               case '\t':
                  var3.appendReplacement(var4, "\\\\t");
                  var2 = var4;
                  break;
               case '\n':
                  var3.appendReplacement(var4, "\\\\n");
                  var2 = var4;
                  break;
               case '\f':
                  var3.appendReplacement(var4, "\\\\f");
                  var2 = var4;
                  break;
               case '\r':
                  var3.appendReplacement(var4, "\\\\r");
                  var2 = var4;
                  break;
               case '"':
                  var3.appendReplacement(var4, "\\\\\\\"");
                  var2 = var4;
                  break;
               case '/':
                  var3.appendReplacement(var4, "\\\\/");
                  var2 = var4;
                  break;
               case '\\':
                  var3.appendReplacement(var4, "\\\\\\\\");
                  var2 = var4;
                  break;
               default:
                  var2 = var4;
            }
         }

         if (var2 == null) {
            var1 = var0;
         } else {
            var3.appendTail(var2);
            var1 = var2.toString();
         }
      }

      return var1;
   }
}
