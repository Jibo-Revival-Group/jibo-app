package com.salesforce.androidsdk.util;

import com.salesforce.androidsdk.analytics.logger.SalesforceLogger;
import com.salesforce.androidsdk.app.SalesforceSDKManager;

public class SalesforceSDKLogger {
   private static SalesforceLogger a() {
      return SalesforceLogger.a("SalesforceSDK", SalesforceSDKManager.a().k());
   }

   public static void a(String var0, String var1) {
      a().a(var0, var1);
   }

   public static void a(String var0, String var1, Throwable var2) {
      a().a(var0, var1, var2);
   }

   public static void b(String var0, String var1) {
      a().b(var0, var1);
   }

   public static void b(String var0, String var1, Throwable var2) {
      a().b(var0, var1, var2);
   }

   public static void c(String var0, String var1) {
      a().c(var0, var1);
   }

   public static void c(String var0, String var1, Throwable var2) {
      a().c(var0, var1, var2);
   }
}
