package com.salesforce.androidsdk.rest;

import android.content.Context;
import com.salesforce.androidsdk.R;

public class ApiVersionStrings {
   public static String a(Context var0) {
      String var1 = "v39.0";
      if (var0 != null) {
         var1 = var0.getString(R.string.api_version);
      }

      return var1;
   }
}
