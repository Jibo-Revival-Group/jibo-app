package com.salesforce.androidsdk.analytics.model;

import com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceAppAttributes {
   private String a;
   private String b;
   private String c;
   private String d;
   private String e;
   private String f;
   private String g;
   private String h;
   private String i;

   public DeviceAppAttributes(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
      this.h = var8;
      this.i = var9;
   }

   public DeviceAppAttributes(JSONObject var1) {
      if (var1 != null) {
         this.a = var1.optString("appVersion");
         this.b = var1.optString("appName");
         this.c = var1.optString("osVersion");
         this.d = var1.optString("osName");
         this.e = var1.optString("nativeAppType");
         this.f = var1.optString("mobileSdkVersion");
         this.g = var1.optString("deviceModel");
         this.h = var1.optString("deviceId");
         this.i = var1.optString("clientId");
      }
   }

   public JSONObject a() {
      JSONObject var2 = new JSONObject();

      try {
         var2.put("appVersion", this.a);
         var2.put("appName", this.b);
         var2.put("osVersion", this.c);
         var2.put("osName", this.d);
         var2.put("nativeAppType", this.e);
         var2.put("mobileSdkVersion", this.f);
         var2.put("deviceModel", this.g);
         var2.put("deviceId", this.h);
         var2.put("clientId", this.i);
      } catch (JSONException var3) {
         SalesforceAnalyticsLogger.a(null, "DeviceAppAttributes", "Exception thrown while attempting to convert to JSON", var3);
      }

      return var2;
   }
}
