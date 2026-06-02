package com.crashlytics.android.beta;

import java.io.IOException;
import org.json.JSONObject;

class CheckForUpdatesResponseTransform {
   public CheckForUpdatesResponse a(JSONObject var1) throws IOException {
      String var2 = null;
      CheckForUpdatesResponse var5;
      if (var1 == null) {
         var5 = var2;
      } else {
         String var3 = var1.optString("url", null);
         String var4 = var1.optString("version_string", null);
         var2 = var1.optString("build_version", null);
         var5 = new CheckForUpdatesResponse(
            var3, var4, var1.optString("display_version", null), var2, var1.optString("identifier", null), var1.optString("instance_identifier", null)
         );
      }

      return var5;
   }
}
