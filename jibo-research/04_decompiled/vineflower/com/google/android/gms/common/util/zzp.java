package com.google.android.gms.common.util;

import java.util.HashMap;
import java.util.Iterator;

public final class zzp {
   public static void a(StringBuilder var0, HashMap<String, String> var1) {
      var0.append("{");
      Iterator var4 = var1.keySet().iterator();
      boolean var2 = true;

      while (var4.hasNext()) {
         String var5 = (String)var4.next();
         if (!var2) {
            var0.append(",");
         } else {
            var2 = false;
         }

         String var3 = (String)var1.get(var5);
         var0.append("\"").append(var5).append("\":");
         if (var3 == null) {
            var0.append("null");
         } else {
            var0.append("\"").append(var3).append("\"");
         }
      }

      var0.append("}");
   }
}
