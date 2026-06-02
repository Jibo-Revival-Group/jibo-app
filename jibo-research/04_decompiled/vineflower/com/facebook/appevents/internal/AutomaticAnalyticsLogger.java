package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Validate;

public class AutomaticAnalyticsLogger {
   private static final String TAG = AutomaticAnalyticsLogger.class.getCanonicalName();

   public static void logActivateAppEvent() {
      Context var2 = FacebookSdk.getApplicationContext();
      String var1 = FacebookSdk.getApplicationId();
      boolean var0 = FacebookSdk.getAutoLogAppEventsEnabled();
      Validate.notNull(var2, "context");
      if (var0) {
         if (var2 instanceof Application) {
            AppEventsLogger.activateApp((Application)var2, var1);
         } else {
            Log.w(
               TAG,
               "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context."
            );
         }
      }
   }

   public static void logActivityTimeSpentEvent(String var0, long var1) {
      Context var3 = FacebookSdk.getApplicationContext();
      String var4 = FacebookSdk.getApplicationId();
      Validate.notNull(var3, "context");
      FetchedAppSettings var6 = FetchedAppSettingsManager.queryAppSettings(var4, false);
      if (var6 != null && var6.getAutomaticLoggingEnabled() && var1 > 0L) {
         AppEventsLogger var5 = AppEventsLogger.newLogger(var3);
         Bundle var7 = new Bundle(1);
         var7.putCharSequence("fb_aa_time_spent_view_name", var0);
         var5.logEvent("fb_aa_time_spent_on_view", var1, var7);
      }
   }
}
