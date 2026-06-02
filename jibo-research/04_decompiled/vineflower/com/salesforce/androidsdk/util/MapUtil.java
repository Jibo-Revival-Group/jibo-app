package com.salesforce.androidsdk.util;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapUtil {
   public static Bundle a(Map<String, String> var0, List<String> var1, Bundle var2) {
      Bundle var4 = var2;
      if (var0 != null) {
         var4 = var2;
         if (var1 != null) {
            var4 = var2;
            if (!var0.isEmpty()) {
               if (var1.isEmpty()) {
                  var4 = var2;
               } else {
                  Bundle var3 = var2;
                  if (var2 == null) {
                     var3 = new Bundle();
                  }

                  Iterator var5 = var1.iterator();

                  while (true) {
                     var4 = var3;
                     if (!var5.hasNext()) {
                        break;
                     }

                     String var6 = (String)var5.next();
                     if (!TextUtils.isEmpty(var6)) {
                        var3.putString(var6, (String)var0.get(var6));
                     }
                  }
               }
            }
         }
      }

      return var4;
   }

   public static Map<String, String> a(Bundle var0, List<String> var1, Map<String, String> var2) {
      Map var4 = var2;
      if (var0 != null) {
         var4 = var2;
         if (var1 != null) {
            var4 = var2;
            if (!var0.isEmpty()) {
               if (var1.isEmpty()) {
                  var4 = var2;
               } else {
                  Map var3 = var2;
                  if (var2 == null) {
                     var3 = new HashMap();
                  }

                  Iterator var5 = var1.iterator();

                  while (true) {
                     var4 = var3;
                     if (!var5.hasNext()) {
                        break;
                     }

                     String var6 = (String)var5.next();
                     if (!TextUtils.isEmpty(var6)) {
                        var3.put(var6, var0.getString(var6));
                     }
                  }
               }
            }
         }
      }

      return var4;
   }
}
