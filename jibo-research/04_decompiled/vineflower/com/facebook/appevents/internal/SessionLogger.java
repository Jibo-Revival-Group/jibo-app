package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Logger;
import java.util.Locale;

class SessionLogger {
   private static final long[] INACTIVE_SECONDS_QUANTA = new long[]{
      300000L,
      900000L,
      1800000L,
      3600000L,
      21600000L,
      43200000L,
      86400000L,
      172800000L,
      259200000L,
      604800000L,
      1209600000L,
      1814400000L,
      2419200000L,
      5184000000L,
      7776000000L,
      10368000000L,
      12960000000L,
      15552000000L,
      31536000000L
   };
   private static final String TAG = SessionLogger.class.getCanonicalName();

   private static int getQuantaIndex(long var0) {
      int var2 = 0;

      while (var2 < INACTIVE_SECONDS_QUANTA.length && INACTIVE_SECONDS_QUANTA[var2] < var0) {
         var2++;
      }

      return var2;
   }

   public static void logActivateApp(Context var0, String var1, SourceApplicationInfo var2, String var3) {
      String var4;
      if (var2 != null) {
         var4 = var2.toString();
      } else {
         var4 = "Unclassified";
      }

      Bundle var6 = new Bundle();
      var6.putString("fb_mobile_launch_source", var4);
      InternalAppEventsLogger var5 = new InternalAppEventsLogger(var1, var3, null);
      var5.logEvent("fb_mobile_activate_app", var6);
      if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
         var5.flush();
      }
   }

   private static void logClockSkewEvent() {
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
   }

   public static void logDeactivateApp(Context var0, String var1, SessionInfo var2, String var3) {
      Long var6 = var2.getDiskRestoreTime() - var2.getSessionLastEventTime();
      Long var4 = var6;
      if (var6 < 0L) {
         var4 = 0L;
         logClockSkewEvent();
      }

      Long var5 = var2.getSessionLength();
      Long var7 = var5;
      if (var5 < 0L) {
         logClockSkewEvent();
         var7 = 0L;
      }

      Bundle var10 = new Bundle();
      var10.putInt("fb_mobile_app_interruptions", var2.getInterruptionCount());
      var10.putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", getQuantaIndex(var4)));
      SourceApplicationInfo var8 = var2.getSourceApplicationInfo();
      String var9;
      if (var8 != null) {
         var9 = var8.toString();
      } else {
         var9 = "Unclassified";
      }

      var10.putString("fb_mobile_launch_source", var9);
      var10.putLong("_logTime", var2.getSessionLastEventTime() / 1000L);
      new InternalAppEventsLogger(var1, var3, null).logEvent("fb_mobile_deactivate_app", var7 / 1000L, var10);
   }
}
