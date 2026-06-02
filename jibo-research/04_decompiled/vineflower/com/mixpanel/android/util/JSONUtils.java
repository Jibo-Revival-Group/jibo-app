package com.mixpanel.android.util;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
   public static String a(JSONObject var0, String var1) throws JSONException {
      String var2;
      if (var0.has(var1) && !var0.isNull(var1)) {
         var2 = var0.getString(var1);
      } else {
         var2 = null;
      }

      return var2;
   }
}
