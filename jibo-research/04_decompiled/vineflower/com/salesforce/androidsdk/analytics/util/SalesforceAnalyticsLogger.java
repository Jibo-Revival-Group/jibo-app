package com.salesforce.androidsdk.analytics.util;

import android.content.Context;
import android.util.Log;
import com.salesforce.androidsdk.analytics.logger.SalesforceLogger;

public class SalesforceAnalyticsLogger {
   private static void a(Context var0, SalesforceLogger.Level var1, String var2, String var3) {
      if (var0 != null) {
         SalesforceLogger.a("SalesforceAnalytics", var0).a(var1, var2, var3);
      } else {
         a(var1, var2, var3);
      }
   }

   private static void a(Context var0, SalesforceLogger.Level var1, String var2, String var3, Throwable var4) {
      if (var0 != null) {
         SalesforceLogger.a("SalesforceAnalytics", var0).a(var1, var2, var3, var4);
      } else {
         a(var1, var2, var3, var4);
      }
   }

   public static void a(Context var0, String var1, String var2) {
      a(var0, SalesforceLogger.Level.ERROR, var1, var2);
   }

   public static void a(Context var0, String var1, String var2, Throwable var3) {
      a(var0, SalesforceLogger.Level.ERROR, var1, var2, var3);
   }

   private static void a(SalesforceLogger.Level var0, String var1, String var2) {
      switch (<unrepresentable>.a[var0.ordinal()]) {
         case 1:
            break;
         case 2:
            Log.e(var1, var2);
            break;
         case 3:
            Log.w(var1, var2);
            break;
         case 4:
            Log.i(var1, var2);
            break;
         case 5:
            Log.d(var1, var2);
            break;
         case 6:
            Log.v(var1, var2);
            break;
         default:
            Log.d(var1, var2);
      }
   }

   private static void a(SalesforceLogger.Level var0, String var1, String var2, Throwable var3) {
      switch (<unrepresentable>.a[var0.ordinal()]) {
         case 1:
            break;
         case 2:
            Log.e(var1, var2, var3);
            break;
         case 3:
            Log.w(var1, var2, var3);
            break;
         case 4:
            Log.i(var1, var2, var3);
            break;
         case 5:
            Log.d(var1, var2, var3);
            break;
         case 6:
            Log.v(var1, var2, var3);
            break;
         default:
            Log.d(var1, var2, var3);
      }
   }

   public static void b(Context var0, String var1, String var2) {
      a(var0, SalesforceLogger.Level.DEBUG, var1, var2);
   }

   public static void b(Context var0, String var1, String var2, Throwable var3) {
      a(var0, SalesforceLogger.Level.WARN, var1, var2, var3);
   }
}
