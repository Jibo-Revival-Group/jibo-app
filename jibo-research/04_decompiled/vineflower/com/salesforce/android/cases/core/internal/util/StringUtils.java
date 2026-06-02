package com.salesforce.android.cases.core.internal.util;

import android.text.Html;
import android.text.Spanned;

public class StringUtils {
   public static boolean a(String var0) {
      boolean var1;
      if (var0 != null && var0.trim().length() != 0) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean b(String var0) {
      boolean var1;
      if (!a(var0)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static String c(String var0) {
      if (!a(var0)) {
         var0 = var0.replace("\"", "");
      }

      return var0;
   }

   public static String d(String var0) {
      if (!a(var0)) {
         Spanned var1 = Html.fromHtml(var0);
         if (var1 != null) {
            var0 = var1.toString().trim();
         }
      }

      return var0;
   }
}
