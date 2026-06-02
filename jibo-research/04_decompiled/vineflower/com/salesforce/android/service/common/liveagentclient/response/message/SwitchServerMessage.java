package com.salesforce.android.service.common.liveagentclient.response.message;

import com.google.gson.annotations.SerializedName;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwitchServerMessage {
   @SerializedName(a = "newUrl")
   private String mNewServerUrl;

   public String a() {
      return this.mNewServerUrl;
   }

   public String b() {
      String var1 = null;
      if (this.mNewServerUrl != null) {
         Matcher var2 = Pattern.compile("https://(.*)/chat").matcher(this.mNewServerUrl);
         if (var2.find()) {
            var1 = var2.group(1);
         }
      }

      return var1;
   }
}
