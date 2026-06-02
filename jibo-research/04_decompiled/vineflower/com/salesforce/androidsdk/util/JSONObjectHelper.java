package com.salesforce.androidsdk.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONObjectHelper {
   public static Object a(JSONArray var0, int var1) {
      Object var2;
      if (var0.isNull(var1)) {
         var2 = null;
      } else {
         var2 = var0.opt(var1);
      }

      return var2;
   }

   public static Object a(JSONObject var0, String var1) {
      Object var2;
      if (var0.isNull(var1)) {
         var2 = null;
      } else {
         var2 = var0.opt(var1);
      }

      return var2;
   }
}
