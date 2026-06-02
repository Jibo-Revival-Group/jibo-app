package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ActivityLifecycleTracker {
   private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";
   private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000L;
   private static final String TAG = ActivityLifecycleTracker.class.getCanonicalName();
   private static String appId;
   private static long currentActivityAppearTime;
   private static volatile ScheduledFuture currentFuture;
   private static volatile SessionInfo currentSession;
   private static AtomicInteger foregroundActivityCount = new AtomicInteger(0);
   private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
   private static AtomicBoolean tracking = new AtomicBoolean(false);

   private static void cancelCurrentTask() {
      if (currentFuture != null) {
         currentFuture.cancel(false);
      }

      currentFuture = null;
   }

   public static UUID getCurrentSessionGuid() {
      UUID var0;
      if (currentSession != null) {
         var0 = currentSession.getSessionId();
      } else {
         var0 = null;
      }

      return var0;
   }

   private static int getSessionTimeoutInSeconds() {
      FetchedAppSettings var1 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
      int var0;
      if (var1 == null) {
         var0 = Constants.getDefaultAppEventsSessionTimeoutInSeconds();
      } else {
         var0 = var1.getSessionTimeoutInSeconds();
      }

      return var0;
   }

   public static boolean isTracking() {
      return tracking.get();
   }

   public static void onActivityCreated(Activity var0) {
      long var1 = System.currentTimeMillis();
      Runnable var3 = new Runnable(var0.getApplicationContext(), Utility.getActivityName(var0), var1, SourceApplicationInfo.Factory.create(var0)) {
         final String val$activityName;
         final Context val$applicationContext;
         final long val$currentTime;
         final SourceApplicationInfo val$sourceApplicationInfo;

         {
            this.val$applicationContext = var1;
            this.val$activityName = var2;
            this.val$currentTime = var3x;
            this.val$sourceApplicationInfo = var5;
         }

         @Override
         public void run() {
            if (ActivityLifecycleTracker.currentSession == null) {
               SessionInfo var1x = SessionInfo.getStoredSessionInfo();
               if (var1x != null) {
                  SessionLogger.logDeactivateApp(this.val$applicationContext, this.val$activityName, var1x, ActivityLifecycleTracker.appId);
               }

               ActivityLifecycleTracker.currentSession = new SessionInfo(this.val$currentTime, null);
               ActivityLifecycleTracker.currentSession.setSourceApplicationInfo(this.val$sourceApplicationInfo);
               SessionLogger.logActivateApp(this.val$applicationContext, this.val$activityName, this.val$sourceApplicationInfo, ActivityLifecycleTracker.appId);
            }
         }
      };
      singleThreadExecutor.execute(var3);
   }

   private static void onActivityPaused(Activity var0) {
      if (foregroundActivityCount.decrementAndGet() < 0) {
         foregroundActivityCount.set(0);
         Log.w(
            TAG,
            "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method"
         );
      }

      cancelCurrentTask();
      Runnable var1 = new Runnable(System.currentTimeMillis(), var0.getApplicationContext(), Utility.getActivityName(var0)) {
         final String val$activityName;
         final Context val$applicationContext;
         final long val$currentTime;

         {
            this.val$currentTime = var1;
            this.val$applicationContext = var3;
            this.val$activityName = var4;
         }

         @Override
         public void run() {
            long var1x = 0L;
            if (ActivityLifecycleTracker.currentSession == null) {
               ActivityLifecycleTracker.currentSession = new SessionInfo(this.val$currentTime, null);
            }

            ActivityLifecycleTracker.currentSession.setSessionLastEventTime(this.val$currentTime);
            if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
               Runnable var5 = new Runnable(this) {
                  final <unrepresentable> this$0;

                  {
                     this.this$0 = var1;
                  }

                  @Override
                  public void run() {
                     if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                        SessionLogger.logDeactivateApp(
                           this.this$0.val$applicationContext,
                           this.this$0.val$activityName,
                           ActivityLifecycleTracker.currentSession,
                           ActivityLifecycleTracker.appId
                        );
                        SessionInfo.clearSavedSessionFromDisk();
                        ActivityLifecycleTracker.currentSession = null;
                     }

                     ActivityLifecycleTracker.currentFuture = null;
                  }
               };
               ActivityLifecycleTracker.currentFuture = ActivityLifecycleTracker.singleThreadExecutor
                  .schedule(var5, ActivityLifecycleTracker.getSessionTimeoutInSeconds(), TimeUnit.SECONDS);
            }

            long var3 = ActivityLifecycleTracker.currentActivityAppearTime;
            if (var3 > 0L) {
               var1x = (this.val$currentTime - var3) / 1000L;
            }

            AutomaticAnalyticsLogger.logActivityTimeSpentEvent(this.val$activityName, var1x);
            ActivityLifecycleTracker.currentSession.writeSessionToDisk();
         }
      };
      singleThreadExecutor.execute(var1);
   }

   public static void onActivityResumed(Activity var0) {
      foregroundActivityCount.incrementAndGet();
      cancelCurrentTask();
      long var1 = System.currentTimeMillis();
      currentActivityAppearTime = var1;
      Runnable var3 = new Runnable(var1, var0.getApplicationContext(), Utility.getActivityName(var0)) {
         final String val$activityName;
         final Context val$applicationContext;
         final long val$currentTime;

         {
            this.val$currentTime = var1;
            this.val$applicationContext = var3x;
            this.val$activityName = var4;
         }

         @Override
         public void run() {
            if (ActivityLifecycleTracker.currentSession == null) {
               ActivityLifecycleTracker.currentSession = new SessionInfo(this.val$currentTime, null);
               SessionLogger.logActivateApp(this.val$applicationContext, this.val$activityName, null, ActivityLifecycleTracker.appId);
            } else if (ActivityLifecycleTracker.currentSession.getSessionLastEventTime() != null) {
               long var1x = this.val$currentTime - ActivityLifecycleTracker.currentSession.getSessionLastEventTime();
               if (var1x > ActivityLifecycleTracker.getSessionTimeoutInSeconds() * 1000) {
                  SessionLogger.logDeactivateApp(
                     this.val$applicationContext, this.val$activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId
                  );
                  SessionLogger.logActivateApp(this.val$applicationContext, this.val$activityName, null, ActivityLifecycleTracker.appId);
                  ActivityLifecycleTracker.currentSession = new SessionInfo(this.val$currentTime, null);
               } else if (var1x > 1000L) {
                  ActivityLifecycleTracker.currentSession.incrementInterruptionCount();
               }
            }

            ActivityLifecycleTracker.currentSession.setSessionLastEventTime(this.val$currentTime);
            ActivityLifecycleTracker.currentSession.writeSessionToDisk();
         }
      };
      singleThreadExecutor.execute(var3);
   }

   public static void startTracking(Application var0, String var1) {
      if (tracking.compareAndSet(false, true)) {
         appId = var1;
         var0.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity var1, Bundle var2) {
               AppEventUtility.assertIsMainThread();
               ActivityLifecycleTracker.onActivityCreated(var1);
            }

            public void onActivityDestroyed(Activity var1) {
            }

            public void onActivityPaused(Activity var1) {
               AppEventUtility.assertIsMainThread();
               ActivityLifecycleTracker.onActivityPaused(var1);
            }

            public void onActivityResumed(Activity var1) {
               AppEventUtility.assertIsMainThread();
               ActivityLifecycleTracker.onActivityResumed(var1);
            }

            public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
            }

            public void onActivityStarted(Activity var1) {
            }

            public void onActivityStopped(Activity var1) {
               AppEventsLogger.onContextStop();
            }
         });
      }
   }
}
