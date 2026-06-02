package com.google.android.gms.common.util;

import java.util.regex.Pattern;

public final class zzu {
   private static final Pattern a = Pattern.compile("\\$\\{(.*?)\\}");

   public static boolean a(String var0) {
      boolean var1;
      if (var0 != null && !var0.trim().isEmpty()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }
}
