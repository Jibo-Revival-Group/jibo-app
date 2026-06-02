package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import java.io.Serializable;
import java.util.Locale;

class FacebookTimeSpentData implements Serializable {
   private static final long APP_ACTIVATE_SUPPRESSION_PERIOD_IN_MILLISECONDS = 300000L;
   private static final long FIRST_TIME_LOAD_RESUME_TIME = -1L;
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
   private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000L;
   private static final long NUM_MILLISECONDS_IDLE_TO_BE_NEW_SESSION = 60000L;
   private static final String TAG = FacebookTimeSpentData.class.getCanonicalName();
   private static final long serialVersionUID = 1L;
   private String firstOpenSourceApplication;
   private int interruptionCount;
   private boolean isAppActive;
   private boolean isWarmLaunch;
   private long lastActivateEventLoggedTime;
   private long lastResumeTime;
   private long lastSuspendTime;
   private long millisecondsSpentInSession;

   FacebookTimeSpentData() {
      this.resetSession();
   }

   private FacebookTimeSpentData(long var1, long var3, long var5, int var7) {
      this.resetSession();
      this.lastResumeTime = var1;
      this.lastSuspendTime = var3;
      this.millisecondsSpentInSession = var5;
      this.interruptionCount = var7;
   }

   private FacebookTimeSpentData(long var1, long var3, long var5, int var7, String var8) {
      this.resetSession();
      this.lastResumeTime = var1;
      this.lastSuspendTime = var3;
      this.millisecondsSpentInSession = var5;
      this.interruptionCount = var7;
      this.firstOpenSourceApplication = var8;
   }

   private static int getQuantaIndex(long var0) {
      int var2 = 0;

      while (var2 < INACTIVE_SECONDS_QUANTA.length && INACTIVE_SECONDS_QUANTA[var2] < var0) {
         var2++;
      }

      return var2;
   }

   private boolean isColdLaunch() {
      boolean var1;
      if (!this.isWarmLaunch) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.isWarmLaunch = true;
      return var1;
   }

   private void logAppDeactivatedEvent(AppEventsLogger var1, long var2) {
      Bundle var4 = new Bundle();
      var4.putInt("fb_mobile_app_interruptions", this.interruptionCount);
      var4.putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", getQuantaIndex(var2)));
      var4.putString("fb_mobile_launch_source", this.firstOpenSourceApplication);
      var1.logEvent("fb_mobile_deactivate_app", this.millisecondsSpentInSession / 1000L, var4);
      this.resetSession();
   }

   private void resetSession() {
      this.isAppActive = false;
      this.lastResumeTime = -1L;
      this.lastSuspendTime = -1L;
      this.interruptionCount = 0;
      this.millisecondsSpentInSession = 0L;
   }

   private boolean wasSuspendedEver() {
      boolean var1;
      if (this.lastSuspendTime != -1L) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private Object writeReplace() {
      return new FacebookTimeSpentData.SerializationProxyV2(
         this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication
      );
   }

   void onResume(AppEventsLogger var1, long var2, String var4) {
      long var7 = 0L;
      if (this.isColdLaunch() || var2 - this.lastActivateEventLoggedTime > 300000L) {
         Bundle var9 = new Bundle();
         var9.putString("fb_mobile_launch_source", var4);
         var1.logEvent("fb_mobile_activate_app", var9);
         this.lastActivateEventLoggedTime = var2;
         if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            var1.flush();
         }
      }

      if (this.isAppActive) {
         Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Resume for active app");
      } else {
         long var5;
         if (this.wasSuspendedEver()) {
            var5 = var2 - this.lastSuspendTime;
         } else {
            var5 = 0L;
         }

         if (var5 < 0L) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
            var5 = var7;
         }

         if (var5 > 60000L) {
            this.logAppDeactivatedEvent(var1, var5);
         } else if (var5 > 1000L) {
            this.interruptionCount++;
         }

         if (this.interruptionCount == 0) {
            this.firstOpenSourceApplication = var4;
         }

         this.lastResumeTime = var2;
         this.isAppActive = true;
      }
   }

   void onSuspend(AppEventsLogger var1, long var2) {
      long var4 = 0L;
      if (!this.isAppActive) {
         Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Suspend for inactive app");
      } else {
         long var6 = var2 - this.lastResumeTime;
         if (var6 < 0L) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
         } else {
            var4 = var6;
         }

         this.millisecondsSpentInSession += var4;
         this.lastSuspendTime = var2;
         this.isAppActive = false;
      }
   }

   private static class SerializationProxyV1 implements Serializable {
      private static final long serialVersionUID = 6L;
      private final int interruptionCount;
      private final long lastResumeTime;
      private final long lastSuspendTime;
      private final long millisecondsSpentInSession;

      SerializationProxyV1(long var1, long var3, long var5, int var7) {
         this.lastResumeTime = var1;
         this.lastSuspendTime = var3;
         this.millisecondsSpentInSession = var5;
         this.interruptionCount = var7;
      }

      private Object readResolve() {
         return new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount);
      }
   }

   private static class SerializationProxyV2 implements Serializable {
      private static final long serialVersionUID = 6L;
      private final String firstOpenSourceApplication;
      private final int interruptionCount;
      private final long lastResumeTime;
      private final long lastSuspendTime;
      private final long millisecondsSpentInSession;

      SerializationProxyV2(long var1, long var3, long var5, int var7, String var8) {
         this.lastResumeTime = var1;
         this.lastSuspendTime = var3;
         this.millisecondsSpentInSession = var5;
         this.interruptionCount = var7;
         this.firstOpenSourceApplication = var8;
      }

      private Object readResolve() {
         return new FacebookTimeSpentData(
            this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication
         );
      }
   }
}
