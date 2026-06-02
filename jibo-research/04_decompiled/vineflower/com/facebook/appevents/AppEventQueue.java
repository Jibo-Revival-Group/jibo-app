package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;

class AppEventQueue {
   private static final int FLUSH_PERIOD_IN_SECONDS = 15;
   private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
   private static final String TAG = AppEventQueue.class.getName();
   private static volatile AppEventCollection appEventCollection = new AppEventCollection();
   private static final Runnable flushRunnable = new Runnable() {
      @Override
      public void run() {
         AppEventQueue.scheduledFuture = null;
         if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            AppEventQueue.flushAndWait(FlushReason.TIMER);
         }
      }
   };
   private static ScheduledFuture scheduledFuture;
   private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

   public static void add(AccessTokenAppIdPair var0, AppEvent var1) {
      singleThreadExecutor.execute(new Runnable(var0, var1) {
         final AccessTokenAppIdPair val$accessTokenAppId;
         final AppEvent val$appEvent;

         {
            this.val$accessTokenAppId = var1;
            this.val$appEvent = var2;
         }

         @Override
         public void run() {
            AppEventQueue.appEventCollection.addEvent(this.val$accessTokenAppId, this.val$appEvent);
            if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY && AppEventQueue.appEventCollection.getEventCount() > 100) {
               AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD);
            } else if (AppEventQueue.scheduledFuture == null) {
               AppEventQueue.scheduledFuture = AppEventQueue.singleThreadExecutor.schedule(AppEventQueue.flushRunnable, 15L, TimeUnit.SECONDS);
            }
         }
      });
   }

   private static GraphRequest buildRequestForSession(AccessTokenAppIdPair var0, SessionEventsState var1, boolean var2, FlushStatistics var3) {
      String var6 = var0.getApplicationId();
      FetchedAppSettings var9 = FetchedAppSettingsManager.queryAppSettings(var6, false);
      GraphRequest var7 = GraphRequest.newPostRequest(null, String.format("%s/activities", var6), null, null);
      Bundle var8 = var7.getParameters();
      Bundle var11 = var8;
      if (var8 == null) {
         var11 = new Bundle();
      }

      var11.putString("access_token", var0.getAccessTokenString());
      String var12 = AppEventsLogger.getPushNotificationsRegistrationId();
      if (var12 != null) {
         var11.putString("device_token", var12);
      }

      var7.setParameters(var11);
      boolean var5;
      if (var9 != null) {
         var5 = var9.supportsImplicitLogging();
      } else {
         var5 = false;
      }

      int var4 = var1.populateRequest(var7, FacebookSdk.getApplicationContext(), var5, var2);
      GraphRequest var10;
      if (var4 == 0) {
         var10 = null;
      } else {
         var3.numEvents += var4;
         var7.setCallback(new GraphRequest.Callback(var0, var7, var1, var3) {
            final AccessTokenAppIdPair val$accessTokenAppId;
            final SessionEventsState val$appEvents;
            final FlushStatistics val$flushState;
            final GraphRequest val$postRequest;

            {
               this.val$accessTokenAppId = var1;
               this.val$postRequest = var2x;
               this.val$appEvents = var3x;
               this.val$flushState = var4x;
            }

            @Override
            public void onCompleted(GraphResponse var1) {
               AppEventQueue.handleResponse(this.val$accessTokenAppId, this.val$postRequest, var1, this.val$appEvents, this.val$flushState);
            }
         });
         var10 = var7;
      }

      return var10;
   }

   public static void flush(FlushReason var0) {
      singleThreadExecutor.execute(new Runnable(var0) {
         final FlushReason val$reason;

         {
            this.val$reason = var1;
         }

         @Override
         public void run() {
            AppEventQueue.flushAndWait(this.val$reason);
         }
      });
   }

   static void flushAndWait(FlushReason var0) {
      PersistedEvents var1 = AppEventStore.readAndClearStore();
      appEventCollection.addPersistedEvents(var1);

      try {
         var3 = sendEventsToServer(var0, appEventCollection);
      } catch (Exception var2) {
         Log.w(TAG, "Caught unexpected exception while flushing app events: ", var2);
         return;
      }

      if (var3 != null) {
         Intent var4 = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
         var4.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", var3.numEvents);
         var4.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", var3.result);
         LocalBroadcastManager.a(FacebookSdk.getApplicationContext()).a(var4);
      }
   }

   public static Set<AccessTokenAppIdPair> getKeySet() {
      return appEventCollection.keySet();
   }

   private static void handleResponse(AccessTokenAppIdPair var0, GraphRequest var1, GraphResponse var2, SessionEventsState var3, FlushStatistics var4) {
      FacebookRequestError var8 = var2.getError();
      FlushResult var7 = FlushResult.SUCCESS;
      String var6;
      FlushResult var11;
      if (var8 != null) {
         if (var8.getErrorCode() == -1) {
            var11 = FlushResult.NO_CONNECTIVITY;
            var6 = "Failed: No Connectivity";
         } else {
            var6 = String.format("Failed:\n  Response: %s\n  Error %s", var2.toString(), var8.toString());
            var11 = FlushResult.SERVER_ERROR;
         }
      } else {
         var6 = "Success";
         var11 = var7;
      }

      if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
         String var12 = (String)var1.getTag();

         try {
            JSONArray var9 = new JSONArray(var12);
            var13 = var9.toString(2);
         } catch (JSONException var10) {
            var13 = "<Can't encode events for debug logging>";
         }

         Logger.log(
            LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", var1.getGraphObject().toString(), var6, var13
         );
      }

      boolean var5;
      if (var8 != null) {
         var5 = true;
      } else {
         var5 = false;
      }

      var3.clearInFlightAndStats(var5);
      if (var11 == FlushResult.NO_CONNECTIVITY) {
         FacebookSdk.getExecutor().execute(new Runnable(var0, var3) {
            final AccessTokenAppIdPair val$accessTokenAppId;
            final SessionEventsState val$appEvents;

            {
               this.val$accessTokenAppId = var1;
               this.val$appEvents = var2x;
            }

            @Override
            public void run() {
               AppEventStore.persistEvents(this.val$accessTokenAppId, this.val$appEvents);
            }
         });
      }

      if (var11 != FlushResult.SUCCESS && var4.result != FlushResult.NO_CONNECTIVITY) {
         var4.result = var11;
      }
   }

   public static void persistToDisk() {
      singleThreadExecutor.execute(new Runnable() {
         @Override
         public void run() {
            AppEventStore.persistEvents(AppEventQueue.appEventCollection);
            AppEventQueue.appEventCollection = new AppEventCollection();
         }
      });
   }

   private static FlushStatistics sendEventsToServer(FlushReason var0, AppEventCollection var1) {
      FlushStatistics var3 = new FlushStatistics();
      boolean var2 = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
      ArrayList var5 = new ArrayList();

      for (AccessTokenAppIdPair var6 : var1.keySet()) {
         GraphRequest var9 = buildRequestForSession(var6, var1.get(var6), var2, var3);
         if (var9 != null) {
            var5.add(var9);
         }
      }

      FlushStatistics var8;
      if (var5.size() > 0) {
         Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", var3.numEvents, var0.toString());
         Iterator var7 = var5.iterator();

         while (var7.hasNext()) {
            ((GraphRequest)var7.next()).executeAndWait();
         }

         var8 = var3;
      } else {
         var8 = null;
      }

      return var8;
   }
}
