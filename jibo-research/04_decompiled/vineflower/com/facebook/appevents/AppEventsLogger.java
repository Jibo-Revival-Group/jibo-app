package com.facebook.appevents;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import bolts.AppLinks;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEventsLogger {
   public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
   public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
   public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
   private static final String APP_EVENT_NAME_PUSH_OPENED = "fb_mobile_push_opened";
   public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
   private static final String APP_EVENT_PUSH_PARAMETER_ACTION = "fb_push_action";
   private static final String APP_EVENT_PUSH_PARAMETER_CAMPAIGN = "fb_push_campaign";
   private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
   private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
   private static final String PUSH_PAYLOAD_CAMPAIGN_KEY = "campaign";
   private static final String PUSH_PAYLOAD_KEY = "fb_push_payload";
   private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
   private static final String TAG = AppEventsLogger.class.getCanonicalName();
   private static String anonymousAppDeviceGUID;
   private static ScheduledThreadPoolExecutor backgroundExecutor;
   private static String externalAnalyticsUserID;
   private static AppEventsLogger.FlushBehavior flushBehavior = AppEventsLogger.FlushBehavior.AUTO;
   private static boolean isActivateAppEventRequested;
   private static boolean isOpenedByApplink;
   private static String pushNotificationsRegistrationId;
   private static String sourceApplication;
   private static Object staticLock = new Object();
   private final AccessTokenAppIdPair accessTokenAppId;
   private final String contextName;

   private AppEventsLogger(Context var1, String var2, AccessToken var3) {
      this(Utility.getActivityName(var1), var2, var3);
   }

   protected AppEventsLogger(String var1, String var2, AccessToken var3) {
      Validate.sdkInitialized();
      this.contextName = var1;
      AccessToken var4 = var3;
      if (var3 == null) {
         var4 = AccessToken.getCurrentAccessToken();
      }

      if (var4 == null || var2 != null && !var2.equals(var4.getApplicationId())) {
         var1 = var2;
         if (var2 == null) {
            var1 = Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext());
         }

         this.accessTokenAppId = new AccessTokenAppIdPair(null, var1);
      } else {
         this.accessTokenAppId = new AccessTokenAppIdPair(var4);
      }

      initializeTimersIfNeeded();
   }

   public static void activateApp(Application var0) {
      activateApp(var0, null);
   }

   public static void activateApp(Application var0, String var1) {
      if (!FacebookSdk.isInitialized()) {
         throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
      }

      AnalyticsUserIDStore.initStore();
      String var2 = var1;
      if (var1 == null) {
         var2 = FacebookSdk.getApplicationId();
      }

      FacebookSdk.publishInstallAsync(var0, var2);
      ActivityLifecycleTracker.startTracking(var0, var2);
   }

   @Deprecated
   public static void activateApp(Context var0) {
      if (ActivityLifecycleTracker.isTracking()) {
         Log.w(TAG, "activateApp events are being logged automatically. There's no need to call activateApp explicitly, this is safe to remove.");
      } else {
         FacebookSdk.sdkInitialize(var0);
         activateApp(var0, Utility.getMetadataApplicationId(var0));
      }
   }

   @Deprecated
   public static void activateApp(Context var0, String var1) {
      if (ActivityLifecycleTracker.isTracking()) {
         Log.w(TAG, "activateApp events are being logged automatically. There's no need to call activateApp explicitly, this is safe to remove.");
      } else {
         if (var0 == null || var1 == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
         }

         AnalyticsUserIDStore.initStore();
         if (var0 instanceof Activity) {
            setSourceApplication((Activity)var0);
         } else {
            resetSourceApplication();
            Log.d(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
         }

         FacebookSdk.publishInstallAsync(var0, var1);
         AppEventsLogger var5 = new AppEventsLogger(var0, var1, null);
         long var2 = System.currentTimeMillis();
         String var4 = getSourceApplication();
         backgroundExecutor.execute(new Runnable(var5, var2, var4) {
            final long val$eventTime;
            final AppEventsLogger val$logger;
            final String val$sourceApplicationInfo;

            {
               this.val$logger = var1;
               this.val$eventTime = var2x;
               this.val$sourceApplicationInfo = var4x;
            }

            @Override
            public void run() {
               this.val$logger.logAppSessionResumeEvent(this.val$eventTime, this.val$sourceApplicationInfo);
            }
         });
      }
   }

   public static void clearUserID() {
      AnalyticsUserIDStore.setUserID(null);
   }

   @Deprecated
   public static void deactivateApp(Context var0) {
      if (ActivityLifecycleTracker.isTracking()) {
         Log.w(TAG, "deactivateApp events are being logged automatically. There's no need to call deactivateApp, this is safe to remove.");
      } else {
         deactivateApp(var0, Utility.getMetadataApplicationId(var0));
      }
   }

   @Deprecated
   public static void deactivateApp(Context var0, String var1) {
      if (ActivityLifecycleTracker.isTracking()) {
         Log.w(TAG, "deactivateApp events are being logged automatically. There's no need to call deactivateApp, this is safe to remove.");
      } else {
         if (var0 == null || var1 == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
         }

         resetSourceApplication();
         AppEventsLogger var4 = new AppEventsLogger(var0, var1, null);
         long var2 = System.currentTimeMillis();
         backgroundExecutor.execute(new Runnable(var4, var2) {
            final long val$eventTime;
            final AppEventsLogger val$logger;

            {
               this.val$logger = var1;
               this.val$eventTime = var2x;
            }

            @Override
            public void run() {
               this.val$logger.logAppSessionSuspendEvent(this.val$eventTime);
            }
         });
      }
   }

   static void eagerFlush() {
      if (getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
         AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
      }
   }

   static Executor getAnalyticsExecutor() {
      if (backgroundExecutor == null) {
         initializeTimersIfNeeded();
      }

      return backgroundExecutor;
   }

   public static String getAnonymousAppDeviceGUID(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/facebook/appevents/AppEventsLogger.anonymousAppDeviceGUID Ljava/lang/String;
      // 03: ifnonnull 67
      // 06: getstatic com/facebook/appevents/AppEventsLogger.staticLock Ljava/lang/Object;
      // 09: astore 1
      // 0a: aload 1
      // 0b: monitorenter
      // 0c: getstatic com/facebook/appevents/AppEventsLogger.anonymousAppDeviceGUID Ljava/lang/String;
      // 0f: ifnonnull 65
      // 12: aload 0
      // 13: ldc "com.facebook.sdk.appEventPreferences"
      // 15: bipush 0
      // 16: invokevirtual android/content/Context.getSharedPreferences (Ljava/lang/String;I)Landroid/content/SharedPreferences;
      // 19: ldc_w "anonymousAppDeviceGUID"
      // 1c: aconst_null
      // 1d: invokeinterface android/content/SharedPreferences.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 22: putstatic com/facebook/appevents/AppEventsLogger.anonymousAppDeviceGUID Ljava/lang/String;
      // 25: getstatic com/facebook/appevents/AppEventsLogger.anonymousAppDeviceGUID Ljava/lang/String;
      // 28: ifnonnull 65
      // 2b: new java/lang/StringBuilder
      // 2e: astore 2
      // 2f: aload 2
      // 30: invokespecial java/lang/StringBuilder.<init> ()V
      // 33: aload 2
      // 34: ldc_w "XZ"
      // 37: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3a: invokestatic java/util/UUID.randomUUID ()Ljava/util/UUID;
      // 3d: invokevirtual java/util/UUID.toString ()Ljava/lang/String;
      // 40: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 43: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 46: putstatic com/facebook/appevents/AppEventsLogger.anonymousAppDeviceGUID Ljava/lang/String;
      // 49: aload 0
      // 4a: ldc "com.facebook.sdk.appEventPreferences"
      // 4c: bipush 0
      // 4d: invokevirtual android/content/Context.getSharedPreferences (Ljava/lang/String;I)Landroid/content/SharedPreferences;
      // 50: invokeinterface android/content/SharedPreferences.edit ()Landroid/content/SharedPreferences$Editor; 1
      // 55: ldc_w "anonymousAppDeviceGUID"
      // 58: getstatic com/facebook/appevents/AppEventsLogger.anonymousAppDeviceGUID Ljava/lang/String;
      // 5b: invokeinterface android/content/SharedPreferences$Editor.putString (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor; 3
      // 60: invokeinterface android/content/SharedPreferences$Editor.apply ()V 1
      // 65: aload 1
      // 66: monitorexit
      // 67: getstatic com/facebook/appevents/AppEventsLogger.anonymousAppDeviceGUID Ljava/lang/String;
      // 6a: areturn
      // 6b: astore 0
      // 6c: aload 1
      // 6d: monitorexit
      // 6e: aload 0
      // 6f: athrow
      // try (6 -> 39): 43 null
      // try (39 -> 41): 43 null
      // try (44 -> 46): 43 null
   }

   public static AppEventsLogger.FlushBehavior getFlushBehavior() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/facebook/appevents/AppEventsLogger.staticLock Ljava/lang/Object;
      // 03: astore 0
      // 04: aload 0
      // 05: monitorenter
      // 06: getstatic com/facebook/appevents/AppEventsLogger.flushBehavior Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;
      // 09: astore 1
      // 0a: aload 0
      // 0b: monitorexit
      // 0c: aload 1
      // 0d: areturn
      // 0e: astore 1
      // 0f: aload 0
      // 10: monitorexit
      // 11: aload 1
      // 12: athrow
      // try (4 -> 8): 10 null
      // try (11 -> 13): 10 null
   }

   static String getPushNotificationsRegistrationId() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/facebook/appevents/AppEventsLogger.staticLock Ljava/lang/Object;
      // 03: astore 0
      // 04: aload 0
      // 05: monitorenter
      // 06: getstatic com/facebook/appevents/AppEventsLogger.pushNotificationsRegistrationId Ljava/lang/String;
      // 09: astore 1
      // 0a: aload 0
      // 0b: monitorexit
      // 0c: aload 1
      // 0d: areturn
      // 0e: astore 1
      // 0f: aload 0
      // 10: monitorexit
      // 11: aload 1
      // 12: athrow
      // try (4 -> 8): 10 null
      // try (11 -> 13): 10 null
   }

   static String getSourceApplication() {
      String var0 = "Unclassified";
      if (isOpenedByApplink) {
         var0 = "Applink";
      }

      String var1 = var0;
      if (sourceApplication != null) {
         var1 = var0 + "(" + sourceApplication + ")";
      }

      return var1;
   }

   public static String getUserID() {
      return AnalyticsUserIDStore.getUserID();
   }

   private static void initializeTimersIfNeeded() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/facebook/appevents/AppEventsLogger.staticLock Ljava/lang/Object;
      // 03: astore 0
      // 04: aload 0
      // 05: monitorenter
      // 06: getstatic com/facebook/appevents/AppEventsLogger.backgroundExecutor Ljava/util/concurrent/ScheduledThreadPoolExecutor;
      // 09: ifnull 0f
      // 0c: aload 0
      // 0d: monitorexit
      // 0e: return
      // 0f: new java/util/concurrent/ScheduledThreadPoolExecutor
      // 12: astore 1
      // 13: aload 1
      // 14: bipush 1
      // 15: invokespecial java/util/concurrent/ScheduledThreadPoolExecutor.<init> (I)V
      // 18: aload 1
      // 19: putstatic com/facebook/appevents/AppEventsLogger.backgroundExecutor Ljava/util/concurrent/ScheduledThreadPoolExecutor;
      // 1c: aload 0
      // 1d: monitorexit
      // 1e: new com/facebook/appevents/AppEventsLogger$4
      // 21: dup
      // 22: invokespecial com/facebook/appevents/AppEventsLogger$4.<init> ()V
      // 25: astore 0
      // 26: getstatic com/facebook/appevents/AppEventsLogger.backgroundExecutor Ljava/util/concurrent/ScheduledThreadPoolExecutor;
      // 29: aload 0
      // 2a: lconst_0
      // 2b: ldc2_w 86400
      // 2e: getstatic java/util/concurrent/TimeUnit.SECONDS Ljava/util/concurrent/TimeUnit;
      // 31: invokevirtual java/util/concurrent/ScheduledThreadPoolExecutor.scheduleAtFixedRate (Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
      // 34: pop
      // 35: goto 0e
      // 38: astore 1
      // 39: aload 0
      // 3a: monitorexit
      // 3b: aload 1
      // 3c: athrow
      // try (4 -> 8): 30 null
      // try (9 -> 18): 30 null
      // try (31 -> 33): 30 null
   }

   private void logAppSessionResumeEvent(long var1, String var3) {
      AppEventsLogger.PersistedAppSessionInfo.onResume(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, var1, var3);
   }

   private void logAppSessionSuspendEvent(long var1) {
      AppEventsLogger.PersistedAppSessionInfo.onSuspend(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, var1);
   }

   private static void logEvent(Context var0, AppEvent var1, AccessTokenAppIdPair var2) {
      AppEventQueue.add(var2, var1);
      if (!var1.getIsImplicit() && !isActivateAppEventRequested) {
         if (var1.getName() == "fb_mobile_activate_app") {
            isActivateAppEventRequested = true;
         } else {
            Logger.log(
               LoggingBehavior.APP_EVENTS,
               "AppEvents",
               "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events."
            );
         }
      }
   }

   private void logEvent(String var1, Double var2, Bundle var3, boolean var4, UUID var5) {
      try {
         AppEvent var6 = new AppEvent(this.contextName, var1, var2, var3, var4, var5);
         logEvent(FacebookSdk.getApplicationContext(), var6, this.accessTokenAppId);
      } catch (JSONException var7) {
         Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", var7.toString());
      } catch (FacebookException var8) {
         Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", var8.toString());
      }
   }

   public static AppEventsLogger newLogger(Context var0) {
      return new AppEventsLogger(var0, null, null);
   }

   public static AppEventsLogger newLogger(Context var0, AccessToken var1) {
      return new AppEventsLogger(var0, null, var1);
   }

   public static AppEventsLogger newLogger(Context var0, String var1) {
      return new AppEventsLogger(var0, var1, null);
   }

   public static AppEventsLogger newLogger(Context var0, String var1, AccessToken var2) {
      return new AppEventsLogger(var0, var1, var2);
   }

   private static void notifyDeveloperError(String var0) {
      Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", var0);
   }

   public static void onContextStop() {
      AppEventQueue.persistToDisk();
   }

   static void resetSourceApplication() {
      sourceApplication = null;
      isOpenedByApplink = false;
   }

   public static void setFlushBehavior(AppEventsLogger.FlushBehavior param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/facebook/appevents/AppEventsLogger.staticLock Ljava/lang/Object;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: aload 0
      // 07: putstatic com/facebook/appevents/AppEventsLogger.flushBehavior Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;
      // 0a: aload 1
      // 0b: monitorexit
      // 0c: return
      // 0d: astore 0
      // 0e: aload 1
      // 0f: monitorexit
      // 10: aload 0
      // 11: athrow
      // try (4 -> 8): 9 null
      // try (10 -> 12): 9 null
   }

   public static void setPushNotificationsRegistrationId(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/facebook/appevents/AppEventsLogger.staticLock Ljava/lang/Object;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/facebook/appevents/AppEventsLogger.pushNotificationsRegistrationId Ljava/lang/String;
      // 09: aload 0
      // 0a: invokestatic com/facebook/internal/Utility.stringsEqualOrEmpty (Ljava/lang/String;Ljava/lang/String;)Z
      // 0d: ifne 2f
      // 10: aload 0
      // 11: putstatic com/facebook/appevents/AppEventsLogger.pushNotificationsRegistrationId Ljava/lang/String;
      // 14: invokestatic com/facebook/FacebookSdk.getApplicationContext ()Landroid/content/Context;
      // 17: invokestatic com/facebook/appevents/AppEventsLogger.newLogger (Landroid/content/Context;)Lcom/facebook/appevents/AppEventsLogger;
      // 1a: astore 0
      // 1b: aload 0
      // 1c: ldc_w "fb_mobile_obtain_push_token"
      // 1f: invokevirtual com/facebook/appevents/AppEventsLogger.logEvent (Ljava/lang/String;)V
      // 22: invokestatic com/facebook/appevents/AppEventsLogger.getFlushBehavior ()Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;
      // 25: getstatic com/facebook/appevents/AppEventsLogger$FlushBehavior.EXPLICIT_ONLY Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;
      // 28: if_acmpeq 2f
      // 2b: aload 0
      // 2c: invokevirtual com/facebook/appevents/AppEventsLogger.flush ()V
      // 2f: aload 1
      // 30: monitorexit
      // 31: return
      // 32: astore 0
      // 33: aload 1
      // 34: monitorexit
      // 35: aload 0
      // 36: athrow
      // try (4 -> 21): 24 null
      // try (21 -> 23): 24 null
      // try (25 -> 27): 24 null
   }

   private static void setSourceApplication(Activity var0) {
      ComponentName var1 = var0.getCallingActivity();
      if (var1 != null) {
         String var3 = var1.getPackageName();
         if (var3.equals(var0.getPackageName())) {
            resetSourceApplication();
            return;
         }

         sourceApplication = var3;
      }

      Intent var2 = var0.getIntent();
      if (var2 != null && !var2.getBooleanExtra("_fbSourceApplicationHasBeenSet", false)) {
         Bundle var4 = AppLinks.a(var2);
         if (var4 == null) {
            resetSourceApplication();
         } else {
            isOpenedByApplink = true;
            Bundle var5 = var4.getBundle("referer_app_link");
            if (var5 == null) {
               sourceApplication = null;
            } else {
               sourceApplication = var5.getString("package");
               var2.putExtra("_fbSourceApplicationHasBeenSet", true);
            }
         }
      } else {
         resetSourceApplication();
      }
   }

   static void setSourceApplication(String var0, boolean var1) {
      sourceApplication = var0;
      isOpenedByApplink = var1;
   }

   public static void setUserID(String var0) {
      AnalyticsUserIDStore.setUserID(var0);
   }

   public static void updateUserProperties(Bundle var0, GraphRequest.Callback var1) {
      updateUserProperties(var0, FacebookSdk.getApplicationId(), var1);
   }

   public static void updateUserProperties(Bundle var0, String var1, GraphRequest.Callback var2) {
      String var3 = getUserID();
      if (var3 != null && !var3.isEmpty()) {
         getAnalyticsExecutor()
            .execute(
               new Runnable(var3, var0, var1, var2) {
                  final String val$applicationID;
                  final GraphRequest.Callback val$callback;
                  final Bundle val$parameters;
                  final String val$userID;

                  {
                     this.val$userID = var1;
                     this.val$parameters = var2x;
                     this.val$applicationID = var3x;
                     this.val$callback = var4;
                  }

                  @Override
                  public void run() {
                     Bundle var2x = new Bundle();
                     var2x.putString("user_unique_id", this.val$userID);
                     var2x.putBundle("custom_data", this.val$parameters);
                     AttributionIdentifiers var1x = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                     if (var1x != null && var1x.getAndroidAdvertiserId() != null) {
                        var2x.putString("advertiser_id", var1x.getAndroidAdvertiserId());
                     }

                     Bundle var5 = new Bundle();

                     try {
                        JSONObject var7 = BundleJSONConverter.convertToJSON(var2x);
                        JSONArray var3x = new JSONArray();
                        var3x.put(var7);
                        var5.putString("data", var3x.toString());
                     } catch (JSONException var4) {
                        throw new FacebookException("Failed to construct request", var4);
                     }

                     GraphRequest var6 = new GraphRequest(
                        AccessToken.getCurrentAccessToken(),
                        String.format(Locale.US, "%s/user_properties", this.val$applicationID),
                        var5,
                        HttpMethod.POST,
                        this.val$callback
                     );
                     var6.setSkipClientToken(true);
                     var6.executeAsync();
                  }
               }
            );
      } else {
         Logger.log(LoggingBehavior.APP_EVENTS, TAG, "AppEventsLogger userID cannot be null or empty");
      }
   }

   public void flush() {
      AppEventQueue.flush(FlushReason.EXPLICIT);
   }

   public String getApplicationId() {
      return this.accessTokenAppId.getApplicationId();
   }

   public boolean isValidForAccessToken(AccessToken var1) {
      AccessTokenAppIdPair var2 = new AccessTokenAppIdPair(var1);
      return this.accessTokenAppId.equals(var2);
   }

   public void logEvent(String var1) {
      this.logEvent(var1, null);
   }

   public void logEvent(String var1, double var2) {
      this.logEvent(var1, var2, null);
   }

   public void logEvent(String var1, double var2, Bundle var4) {
      this.logEvent(var1, var2, var4, false, ActivityLifecycleTracker.getCurrentSessionGuid());
   }

   public void logEvent(String var1, Bundle var2) {
      this.logEvent(var1, null, var2, false, ActivityLifecycleTracker.getCurrentSessionGuid());
   }

   public void logPurchase(BigDecimal var1, Currency var2) {
      this.logPurchase(var1, var2, null);
   }

   public void logPurchase(BigDecimal var1, Currency var2, Bundle var3) {
      if (var1 == null) {
         notifyDeveloperError("purchaseAmount cannot be null");
      } else if (var2 == null) {
         notifyDeveloperError("currency cannot be null");
      } else {
         Bundle var4 = var3;
         if (var3 == null) {
            var4 = new Bundle();
         }

         var4.putString("fb_currency", var2.getCurrencyCode());
         this.logEvent("fb_mobile_purchase", var1.doubleValue(), var4);
         eagerFlush();
      }
   }

   public void logPushNotificationOpen(Bundle var1) {
      this.logPushNotificationOpen(var1, null);
   }

   public void logPushNotificationOpen(Bundle var1, String var2) {
      Bundle var3 = null;

      try {
         String var4 = var1.getString("fb_push_payload");
         if (Utility.isNullOrEmpty(var4)) {
            return;
         }

         JSONObject var7 = new JSONObject(var4);
         var6 = var7.getString("campaign");
      } catch (JSONException var5) {
         var6 = var3;
      }

      if (var6 == null) {
         Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Malformed payload specified for logging a push notification open.");
      } else {
         var3 = new Bundle();
         var3.putString("fb_push_campaign", var6);
         if (var2 != null) {
            var3.putString("fb_push_action", var2);
         }

         this.logEvent("fb_mobile_push_opened", var3);
      }
   }

   public void logSdkEvent(String var1, Double var2, Bundle var3) {
      this.logEvent(var1, var2, var3, true, ActivityLifecycleTracker.getCurrentSessionGuid());
   }

   public enum FlushBehavior {
      AUTO,
      EXPLICIT_ONLY;

      private static final AppEventsLogger.FlushBehavior[] $VALUES = new AppEventsLogger.FlushBehavior[]{
         AppEventsLogger.FlushBehavior.AUTO, AppEventsLogger.FlushBehavior.EXPLICIT_ONLY
      };
   }

   static class PersistedAppSessionInfo {
      private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
      private static final Runnable appSessionInfoFlushRunnable = new Runnable() {
         @Override
         public void run() {
            AppEventsLogger.PersistedAppSessionInfo.saveAppSessionInformation(FacebookSdk.getApplicationContext());
         }
      };
      private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap;
      private static boolean hasChanges = false;
      private static boolean isLoaded = false;
      private static final Object staticLock = new Object();

      private static FacebookTimeSpentData getTimeSpentData(Context var0, AccessTokenAppIdPair var1) {
         restoreAppSessionInformation(var0);
         FacebookTimeSpentData var2 = appSessionInfoMap.get(var1);
         FacebookTimeSpentData var3 = var2;
         if (var2 == null) {
            var3 = new FacebookTimeSpentData();
            appSessionInfoMap.put(var1, var3);
         }

         return var3;
      }

      static void onResume(Context param0, AccessTokenAppIdPair param1, AppEventsLogger param2, long param3, String param5) {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
         //
         // Bytecode:
         // 00: getstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.staticLock Ljava/lang/Object;
         // 03: astore 6
         // 05: aload 6
         // 07: monitorenter
         // 08: aload 0
         // 09: aload 1
         // 0a: invokestatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.getTimeSpentData (Landroid/content/Context;Lcom/facebook/appevents/AccessTokenAppIdPair;)Lcom/facebook/appevents/FacebookTimeSpentData;
         // 0d: aload 2
         // 0e: lload 3
         // 0f: aload 5
         // 11: invokevirtual com/facebook/appevents/FacebookTimeSpentData.onResume (Lcom/facebook/appevents/AppEventsLogger;JLjava/lang/String;)V
         // 14: invokestatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.onTimeSpentDataUpdate ()V
         // 17: aload 6
         // 19: monitorexit
         // 1a: return
         // 1b: astore 0
         // 1c: aload 6
         // 1e: monitorexit
         // 1f: aload 0
         // 20: athrow
         // try (4 -> 14): 15 null
         // try (16 -> 18): 15 null
      }

      static void onSuspend(Context param0, AccessTokenAppIdPair param1, AppEventsLogger param2, long param3) {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
         //
         // Bytecode:
         // 00: getstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.staticLock Ljava/lang/Object;
         // 03: astore 5
         // 05: aload 5
         // 07: monitorenter
         // 08: aload 0
         // 09: aload 1
         // 0a: invokestatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.getTimeSpentData (Landroid/content/Context;Lcom/facebook/appevents/AccessTokenAppIdPair;)Lcom/facebook/appevents/FacebookTimeSpentData;
         // 0d: aload 2
         // 0e: lload 3
         // 0f: invokevirtual com/facebook/appevents/FacebookTimeSpentData.onSuspend (Lcom/facebook/appevents/AppEventsLogger;J)V
         // 12: invokestatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.onTimeSpentDataUpdate ()V
         // 15: aload 5
         // 17: monitorexit
         // 18: return
         // 19: astore 0
         // 1a: aload 5
         // 1c: monitorexit
         // 1d: aload 0
         // 1e: athrow
         // try (4 -> 13): 14 null
         // try (15 -> 17): 14 null
      }

      private static void onTimeSpentDataUpdate() {
         if (!hasChanges) {
            hasChanges = true;
            AppEventsLogger.backgroundExecutor.schedule(appSessionInfoFlushRunnable, 30L, TimeUnit.SECONDS);
         }
      }

      private static void restoreAppSessionInformation(Context param0) {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 000: aconst_null
         // 001: astore 2
         // 002: getstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.staticLock Ljava/lang/Object;
         // 005: astore 5
         // 007: aload 5
         // 009: monitorenter
         // 00a: getstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.isLoaded Z
         // 00d: istore 1
         // 00e: iload 1
         // 00f: ifne 05d
         // 012: new java/io/ObjectInputStream
         // 015: astore 3
         // 016: aload 3
         // 017: aload 0
         // 018: ldc "AppEventsLogger.persistedsessioninfo"
         // 01a: invokevirtual android/content/Context.openFileInput (Ljava/lang/String;)Ljava/io/FileInputStream;
         // 01d: invokespecial java/io/ObjectInputStream.<init> (Ljava/io/InputStream;)V
         // 020: aload 3
         // 021: astore 2
         // 022: aload 3
         // 023: invokevirtual java/io/ObjectInputStream.readObject ()Ljava/lang/Object;
         // 026: checkcast java/util/HashMap
         // 029: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.appSessionInfoMap Ljava/util/Map;
         // 02c: aload 3
         // 02d: astore 2
         // 02e: getstatic com/facebook/LoggingBehavior.APP_EVENTS Lcom/facebook/LoggingBehavior;
         // 031: ldc "AppEvents"
         // 033: ldc "App session info loaded"
         // 035: invokestatic com/facebook/internal/Logger.log (Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
         // 038: aload 3
         // 039: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
         // 03c: aload 0
         // 03d: ldc "AppEventsLogger.persistedsessioninfo"
         // 03f: invokevirtual android/content/Context.deleteFile (Ljava/lang/String;)Z
         // 042: pop
         // 043: getstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.appSessionInfoMap Ljava/util/Map;
         // 046: ifnonnull 055
         // 049: new java/util/HashMap
         // 04c: astore 0
         // 04d: aload 0
         // 04e: invokespecial java/util/HashMap.<init> ()V
         // 051: aload 0
         // 052: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.appSessionInfoMap Ljava/util/Map;
         // 055: bipush 1
         // 056: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.isLoaded Z
         // 059: bipush 0
         // 05a: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.hasChanges Z
         // 05d: aload 5
         // 05f: monitorexit
         // 060: return
         // 061: astore 3
         // 062: aload 2
         // 063: astore 3
         // 064: aload 3
         // 065: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
         // 068: aload 0
         // 069: ldc "AppEventsLogger.persistedsessioninfo"
         // 06b: invokevirtual android/content/Context.deleteFile (Ljava/lang/String;)Z
         // 06e: pop
         // 06f: getstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.appSessionInfoMap Ljava/util/Map;
         // 072: ifnonnull 081
         // 075: new java/util/HashMap
         // 078: astore 0
         // 079: aload 0
         // 07a: invokespecial java/util/HashMap.<init> ()V
         // 07d: aload 0
         // 07e: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.appSessionInfoMap Ljava/util/Map;
         // 081: bipush 1
         // 082: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.isLoaded Z
         // 085: bipush 0
         // 086: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.hasChanges Z
         // 089: goto 05d
         // 08c: astore 0
         // 08d: aload 5
         // 08f: monitorexit
         // 090: aload 0
         // 091: athrow
         // 092: astore 4
         // 094: aconst_null
         // 095: astore 3
         // 096: aload 3
         // 097: astore 2
         // 098: invokestatic com/facebook/appevents/AppEventsLogger.access$200 ()Ljava/lang/String;
         // 09b: astore 6
         // 09d: aload 3
         // 09e: astore 2
         // 09f: new java/lang/StringBuilder
         // 0a2: astore 7
         // 0a4: aload 3
         // 0a5: astore 2
         // 0a6: aload 7
         // 0a8: invokespecial java/lang/StringBuilder.<init> ()V
         // 0ab: aload 3
         // 0ac: astore 2
         // 0ad: aload 6
         // 0af: aload 7
         // 0b1: ldc "Got unexpected exception restoring app session info: "
         // 0b3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 0b6: aload 4
         // 0b8: invokevirtual java/lang/Exception.toString ()Ljava/lang/String;
         // 0bb: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 0be: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 0c1: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
         // 0c4: pop
         // 0c5: aload 3
         // 0c6: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
         // 0c9: aload 0
         // 0ca: ldc "AppEventsLogger.persistedsessioninfo"
         // 0cc: invokevirtual android/content/Context.deleteFile (Ljava/lang/String;)Z
         // 0cf: pop
         // 0d0: getstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.appSessionInfoMap Ljava/util/Map;
         // 0d3: ifnonnull 0e2
         // 0d6: new java/util/HashMap
         // 0d9: astore 0
         // 0da: aload 0
         // 0db: invokespecial java/util/HashMap.<init> ()V
         // 0de: aload 0
         // 0df: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.appSessionInfoMap Ljava/util/Map;
         // 0e2: bipush 1
         // 0e3: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.isLoaded Z
         // 0e6: bipush 0
         // 0e7: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.hasChanges Z
         // 0ea: goto 05d
         // 0ed: astore 3
         // 0ee: aconst_null
         // 0ef: astore 2
         // 0f0: aload 2
         // 0f1: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
         // 0f4: aload 0
         // 0f5: ldc "AppEventsLogger.persistedsessioninfo"
         // 0f7: invokevirtual android/content/Context.deleteFile (Ljava/lang/String;)Z
         // 0fa: pop
         // 0fb: getstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.appSessionInfoMap Ljava/util/Map;
         // 0fe: ifnonnull 10d
         // 101: new java/util/HashMap
         // 104: astore 0
         // 105: aload 0
         // 106: invokespecial java/util/HashMap.<init> ()V
         // 109: aload 0
         // 10a: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.appSessionInfoMap Ljava/util/Map;
         // 10d: bipush 1
         // 10e: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.isLoaded Z
         // 111: bipush 0
         // 112: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.hasChanges Z
         // 115: aload 3
         // 116: athrow
         // 117: astore 3
         // 118: goto 0f0
         // 11b: astore 4
         // 11d: goto 096
         // 120: astore 2
         // 121: goto 064
         // try (6 -> 8): 72 null
         // try (10 -> 17): 50 java/io/FileNotFoundException
         // try (10 -> 17): 77 java/lang/Exception
         // try (10 -> 17): 123 null
         // try (19 -> 23): 150 java/io/FileNotFoundException
         // try (19 -> 23): 148 java/lang/Exception
         // try (19 -> 23): 146 null
         // try (25 -> 29): 150 java/io/FileNotFoundException
         // try (25 -> 29): 148 java/lang/Exception
         // try (25 -> 29): 146 null
         // try (29 -> 43): 72 null
         // try (43 -> 47): 72 null
         // try (47 -> 49): 72 null
         // try (53 -> 67): 72 null
         // try (67 -> 71): 72 null
         // try (73 -> 75): 72 null
         // try (82 -> 84): 146 null
         // try (86 -> 88): 146 null
         // try (90 -> 92): 146 null
         // try (94 -> 104): 146 null
         // try (104 -> 118): 72 null
         // try (118 -> 122): 72 null
         // try (126 -> 140): 72 null
         // try (140 -> 146): 72 null
      }

      static void saveAppSessionInformation(Context param0) {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 00: getstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.staticLock Ljava/lang/Object;
         // 03: astore 4
         // 05: aload 4
         // 07: monitorenter
         // 08: getstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.hasChanges Z
         // 0b: istore 1
         // 0c: iload 1
         // 0d: ifeq 47
         // 10: new java/io/ObjectOutputStream
         // 13: astore 2
         // 14: new java/io/BufferedOutputStream
         // 17: astore 3
         // 18: aload 3
         // 19: aload 0
         // 1a: ldc "AppEventsLogger.persistedsessioninfo"
         // 1c: bipush 0
         // 1d: invokevirtual android/content/Context.openFileOutput (Ljava/lang/String;I)Ljava/io/FileOutputStream;
         // 20: invokespecial java/io/BufferedOutputStream.<init> (Ljava/io/OutputStream;)V
         // 23: aload 2
         // 24: aload 3
         // 25: invokespecial java/io/ObjectOutputStream.<init> (Ljava/io/OutputStream;)V
         // 28: aload 2
         // 29: astore 0
         // 2a: aload 2
         // 2b: getstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.appSessionInfoMap Ljava/util/Map;
         // 2e: invokevirtual java/io/ObjectOutputStream.writeObject (Ljava/lang/Object;)V
         // 31: aload 2
         // 32: astore 0
         // 33: bipush 0
         // 34: putstatic com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo.hasChanges Z
         // 37: aload 2
         // 38: astore 0
         // 39: getstatic com/facebook/LoggingBehavior.APP_EVENTS Lcom/facebook/LoggingBehavior;
         // 3c: ldc "AppEvents"
         // 3e: ldc "App session info saved"
         // 40: invokestatic com/facebook/internal/Logger.log (Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
         // 43: aload 2
         // 44: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
         // 47: aload 4
         // 49: monitorexit
         // 4a: return
         // 4b: astore 3
         // 4c: aconst_null
         // 4d: astore 2
         // 4e: aload 2
         // 4f: astore 0
         // 50: invokestatic com/facebook/appevents/AppEventsLogger.access$200 ()Ljava/lang/String;
         // 53: astore 6
         // 55: aload 2
         // 56: astore 0
         // 57: new java/lang/StringBuilder
         // 5a: astore 5
         // 5c: aload 2
         // 5d: astore 0
         // 5e: aload 5
         // 60: invokespecial java/lang/StringBuilder.<init> ()V
         // 63: aload 2
         // 64: astore 0
         // 65: aload 6
         // 67: aload 5
         // 69: ldc "Got unexpected exception while writing app session info: "
         // 6b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 6e: aload 3
         // 6f: invokevirtual java/lang/Exception.toString ()Ljava/lang/String;
         // 72: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 75: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 78: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
         // 7b: pop
         // 7c: aload 2
         // 7d: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
         // 80: goto 47
         // 83: astore 0
         // 84: aload 4
         // 86: monitorexit
         // 87: aload 0
         // 88: athrow
         // 89: astore 0
         // 8a: aconst_null
         // 8b: astore 2
         // 8c: aload 0
         // 8d: astore 3
         // 8e: aload 2
         // 8f: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
         // 92: aload 3
         // 93: athrow
         // 94: astore 3
         // 95: aload 0
         // 96: astore 2
         // 97: goto 8e
         // 9a: astore 3
         // 9b: goto 4e
         // try (4 -> 6): 71 null
         // try (8 -> 21): 41 java/lang/Exception
         // try (8 -> 21): 76 null
         // try (23 -> 26): 89 java/lang/Exception
         // try (23 -> 26): 85 null
         // try (28 -> 30): 89 java/lang/Exception
         // try (28 -> 30): 85 null
         // try (32 -> 36): 89 java/lang/Exception
         // try (32 -> 36): 85 null
         // try (36 -> 38): 71 null
         // try (38 -> 40): 71 null
         // try (46 -> 48): 85 null
         // try (50 -> 52): 85 null
         // try (54 -> 56): 85 null
         // try (58 -> 68): 85 null
         // try (68 -> 70): 71 null
         // try (72 -> 74): 71 null
         // try (81 -> 85): 71 null
      }
   }
}
