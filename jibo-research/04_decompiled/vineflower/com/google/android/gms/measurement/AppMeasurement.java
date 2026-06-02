package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.api.internal.zzbz;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcim;
import com.google.android.gms.internal.zzcln;
import com.google.android.gms.internal.zzclq;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;

@Deprecated
@Keep
public class AppMeasurement {
   public static final String CRASH_ORIGIN = "crash";
   public static final String FCM_ORIGIN = "fcm";
   private final zzcim zziwf;

   public AppMeasurement(zzcim var1) {
      zzbq.a(var1);
      this.zziwf = var1;
   }

   @Deprecated
   @Keep
   public static AppMeasurement getInstance(Context var0) {
      return zzcim.a(var0).m();
   }

   @Keep
   public void beginAdUnitExposure(String var1) {
      this.zziwf.A().a(var1);
   }

   @Keep
   protected void clearConditionalUserProperty(String var1, String var2, Bundle var3) {
      this.zziwf.l().b(var1, var2, var3);
   }

   @Keep
   protected void clearConditionalUserPropertyAs(String var1, String var2, String var3, Bundle var4) {
      this.zziwf.l().a(var1, var2, var3, var4);
   }

   @Keep
   public void endAdUnitExposure(String var1) {
      this.zziwf.A().b(var1);
   }

   @Keep
   public long generateEventId() {
      return this.zziwf.o().y();
   }

   @Keep
   public String getAppInstanceId() {
      return this.zziwf.l().z();
   }

   @Keep
   protected List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String var1, String var2) {
      return this.zziwf.l().a(var1, var2);
   }

   @Keep
   protected List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(String var1, String var2, String var3) {
      return this.zziwf.l().a(var1, var2, var3);
   }

   @Keep
   public String getCurrentScreenClass() {
      AppMeasurement.zzb var1 = this.zziwf.v().z();
      String var2;
      if (var1 != null) {
         var2 = var1.c;
      } else {
         var2 = null;
      }

      return var2;
   }

   @Keep
   public String getCurrentScreenName() {
      AppMeasurement.zzb var1 = this.zziwf.v().z();
      String var2;
      if (var1 != null) {
         var2 = var1.b;
      } else {
         var2 = null;
      }

      return var2;
   }

   @Keep
   public String getGmpAppId() {
      String var1;
      try {
         var1 = zzbz.a();
      } catch (IllegalStateException var2) {
         this.zziwf.f().y().a("getGoogleAppId failed with exception", var2);
         var1 = null;
      }

      return var1;
   }

   @Keep
   protected int getMaxUserProperties(String var1) {
      this.zziwf.l();
      zzbq.a(var1);
      return 25;
   }

   @Keep
   protected Map<String, Object> getUserProperties(String var1, String var2, boolean var3) {
      return this.zziwf.l().a(var1, var2, var3);
   }

   public Map<String, Object> getUserProperties(boolean var1) {
      List var3 = this.zziwf.l().b(var1);
      ArrayMap var2 = new ArrayMap(var3.size());

      for (zzcln var5 : var3) {
         var2.put(var5.a, var5.a());
      }

      return var2;
   }

   @Keep
   protected Map<String, Object> getUserPropertiesAs(String var1, String var2, String var3, boolean var4) {
      return this.zziwf.l().a(var1, var2, var3, var4);
   }

   public final void logEvent(String var1, Bundle var2) {
      Bundle var5 = var2;
      if (var2 == null) {
         var5 = new Bundle();
      }

      if (!"_iap".equals(var1)) {
         int var4 = this.zziwf.o().b(var1);
         if (var4 != 0) {
            this.zziwf.o();
            String var6 = zzclq.a(var1, 40, true);
            int var3;
            if (var1 != null) {
               var3 = var1.length();
            } else {
               var3 = 0;
            }

            this.zziwf.o().a(var4, "_ev", var6, var3);
            return;
         }
      }

      this.zziwf.l().a("app", var1, var5, true);
   }

   @Keep
   public void logEventInternal(String var1, String var2, Bundle var3) {
      Bundle var4 = var3;
      if (var3 == null) {
         var4 = new Bundle();
      }

      this.zziwf.l().a(var1, var2, var4);
   }

   public void logEventInternalNoInterceptor(String var1, String var2, Bundle var3, long var4) {
      if (var3 == null) {
         var3 = new Bundle();
      }

      this.zziwf.l().a(var1, var2, var3, var4);
   }

   public void registerOnMeasurementEventListener(AppMeasurement.OnEventListener var1) {
      this.zziwf.l().a(var1);
   }

   @Keep
   public void registerOnScreenChangeCallback(AppMeasurement.zza var1) {
      this.zziwf.v().a(var1);
   }

   @Keep
   protected void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty var1) {
      this.zziwf.l().a(var1);
   }

   @Keep
   protected void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty var1) {
      this.zziwf.l().b(var1);
   }

   public void setEventInterceptor(AppMeasurement.EventInterceptor var1) {
      this.zziwf.l().a(var1);
   }

   @Deprecated
   public void setMeasurementEnabled(boolean var1) {
      this.zziwf.l().a(var1);
   }

   public final void setMinimumSessionDuration(long var1) {
      this.zziwf.l().a(var1);
   }

   public final void setSessionTimeoutDuration(long var1) {
      this.zziwf.l().b(var1);
   }

   public final void setUserProperty(String var1, String var2) {
      int var4 = this.zziwf.o().d(var1);
      if (var4 != 0) {
         this.zziwf.o();
         var2 = zzclq.a(var1, 24, true);
         int var3;
         if (var1 != null) {
            var3 = var1.length();
         } else {
            var3 = 0;
         }

         this.zziwf.o().a(var4, "_ev", var2, var3);
      } else {
         this.setUserPropertyInternal("app", var1, var2);
      }
   }

   public void setUserPropertyInternal(String var1, String var2, Object var3) {
      this.zziwf.l().a(var1, var2, var3);
   }

   public void unregisterOnMeasurementEventListener(AppMeasurement.OnEventListener var1) {
      this.zziwf.l().b(var1);
   }

   @Keep
   public void unregisterOnScreenChangeCallback(AppMeasurement.zza var1) {
      this.zziwf.v().b(var1);
   }

   public static class ConditionalUserProperty {
      @Keep
      public boolean mActive;
      @Keep
      public String mAppId;
      @Keep
      public long mCreationTimestamp;
      @Keep
      public String mExpiredEventName;
      @Keep
      public Bundle mExpiredEventParams;
      @Keep
      public String mName;
      @Keep
      public String mOrigin;
      @Keep
      public long mTimeToLive;
      @Keep
      public String mTimedOutEventName;
      @Keep
      public Bundle mTimedOutEventParams;
      @Keep
      public String mTriggerEventName;
      @Keep
      public long mTriggerTimeout;
      @Keep
      public String mTriggeredEventName;
      @Keep
      public Bundle mTriggeredEventParams;
      @Keep
      public long mTriggeredTimestamp;
      @Keep
      public Object mValue;

      public ConditionalUserProperty() {
      }

      public ConditionalUserProperty(AppMeasurement.ConditionalUserProperty var1) {
         zzbq.a(var1);
         this.mAppId = var1.mAppId;
         this.mOrigin = var1.mOrigin;
         this.mCreationTimestamp = var1.mCreationTimestamp;
         this.mName = var1.mName;
         if (var1.mValue != null) {
            this.mValue = zzclq.b(var1.mValue);
            if (this.mValue == null) {
               this.mValue = var1.mValue;
            }
         }

         this.mValue = var1.mValue;
         this.mActive = var1.mActive;
         this.mTriggerEventName = var1.mTriggerEventName;
         this.mTriggerTimeout = var1.mTriggerTimeout;
         this.mTimedOutEventName = var1.mTimedOutEventName;
         if (var1.mTimedOutEventParams != null) {
            this.mTimedOutEventParams = new Bundle(var1.mTimedOutEventParams);
         }

         this.mTriggeredEventName = var1.mTriggeredEventName;
         if (var1.mTriggeredEventParams != null) {
            this.mTriggeredEventParams = new Bundle(var1.mTriggeredEventParams);
         }

         this.mTriggeredTimestamp = var1.mTriggeredTimestamp;
         this.mTimeToLive = var1.mTimeToLive;
         this.mExpiredEventName = var1.mExpiredEventName;
         if (var1.mExpiredEventParams != null) {
            this.mExpiredEventParams = new Bundle(var1.mExpiredEventParams);
         }
      }
   }

   public static final class Event extends FirebaseAnalytics.Event {
      public static final String[] a = new String[]{
         "app_clear_data",
         "app_exception",
         "app_remove",
         "app_upgrade",
         "app_install",
         "app_update",
         "firebase_campaign",
         "error",
         "first_open",
         "first_visit",
         "in_app_purchase",
         "notification_dismiss",
         "notification_foreground",
         "notification_open",
         "notification_receive",
         "os_update",
         "session_start",
         "user_engagement",
         "ad_exposure",
         "adunit_exposure",
         "ad_query",
         "ad_activeview",
         "ad_impression",
         "ad_click",
         "screen_view",
         "firebase_extra_parameter"
      };
      public static final String[] b = new String[]{
         "_cd",
         "_ae",
         "_ui",
         "_ug",
         "_in",
         "_au",
         "_cmp",
         "_err",
         "_f",
         "_v",
         "_iap",
         "_nd",
         "_nf",
         "_no",
         "_nr",
         "_ou",
         "_s",
         "_e",
         "_xa",
         "_xu",
         "_aq",
         "_aa",
         "_ai",
         "_ac",
         "_vs",
         "_ep"
      };

      public static String a(String var0) {
         return zzclq.a(var0, a, b);
      }
   }

   public interface EventInterceptor {
      void a(String var1, String var2, Bundle var3, long var4);
   }

   public interface OnEventListener {
      void a(String var1, String var2, Bundle var3, long var4);
   }

   public static final class Param extends FirebaseAnalytics.Param {
      public static final String[] a = new String[]{
         "firebase_conversion",
         "engagement_time_msec",
         "exposure_time",
         "ad_event_id",
         "ad_unit_id",
         "firebase_error",
         "firebase_error_value",
         "firebase_error_length",
         "firebase_event_origin",
         "firebase_screen",
         "firebase_screen_class",
         "firebase_screen_id",
         "firebase_previous_screen",
         "firebase_previous_class",
         "firebase_previous_id",
         "message_device_time",
         "message_id",
         "message_name",
         "message_time",
         "previous_app_version",
         "previous_os_version",
         "topic",
         "update_with_analytics",
         "previous_first_open_count",
         "system_app",
         "system_app_update",
         "previous_install_count",
         "firebase_event_id",
         "firebase_extra_params_ct",
         "firebase_group_name",
         "firebase_list_length",
         "firebase_index",
         "firebase_event_name"
      };
      public static final String[] b = new String[]{
         "_c",
         "_et",
         "_xt",
         "_aeid",
         "_ai",
         "_err",
         "_ev",
         "_el",
         "_o",
         "_sn",
         "_sc",
         "_si",
         "_pn",
         "_pc",
         "_pi",
         "_ndt",
         "_nmid",
         "_nmn",
         "_nmt",
         "_pv",
         "_po",
         "_nt",
         "_uwa",
         "_pfo",
         "_sys",
         "_sysu",
         "_pin",
         "_eid",
         "_epc",
         "_gn",
         "_ll",
         "_i",
         "_en"
      };

      public static String a(String var0) {
         return zzclq.a(var0, a, b);
      }
   }

   public static final class UserProperty extends FirebaseAnalytics.UserProperty {
      public static final String[] a = new String[]{
         "firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install"
      };
      public static final String[] b = new String[]{"_ln", "_fot", "_fvt", "_ldl", "_id", "_fi"};

      public static String a(String var0) {
         return zzclq.a(var0, a, b);
      }
   }

   public interface zza {
      boolean a(AppMeasurement.zzb var1, AppMeasurement.zzb var2);
   }

   public static class zzb {
      public String b;
      public String c;
      public long d;

      public zzb() {
      }

      public zzb(AppMeasurement.zzb var1) {
         this.b = var1.b;
         this.c = var1.c;
         this.d = var1.d;
      }
   }
}
