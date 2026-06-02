package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class FetchedAppSettingsManager {
   private static final String APPLICATION_FIELDS = "fields";
   private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
   private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
   private static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
   private static final String APP_SETTING_APP_EVENTS_FEATURE_BITMASK = "app_events_feature_bitmask";
   private static final String APP_SETTING_APP_EVENTS_SESSION_TIMEOUT = "app_events_session_timeout";
   private static final String APP_SETTING_CUSTOM_TABS_ENABLED = "gdpv4_chrome_custom_tabs_enabled";
   private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
   private static final String[] APP_SETTING_FIELDS = new String[]{
      "supports_implicit_sdk_logging",
      "gdpv4_nux_content",
      "gdpv4_nux_enabled",
      "gdpv4_chrome_custom_tabs_enabled",
      "android_dialog_configs",
      "android_sdk_error_categories",
      "app_events_session_timeout",
      "app_events_feature_bitmask",
      "seamless_login",
      "smart_login_bookmark_icon_url",
      "smart_login_menu_icon_url"
   };
   private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
   private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
   private static final String APP_SETTING_SMART_LOGIN_OPTIONS = "seamless_login";
   private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
   private static final int AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 8;
   private static final String SMART_LOGIN_BOOKMARK_ICON_URL = "smart_login_bookmark_icon_url";
   private static final String SMART_LOGIN_MENU_ICON_URL = "smart_login_menu_icon_url";
   private static Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap<>();
   private static AtomicBoolean loadingSettings = new AtomicBoolean(false);

   private static JSONObject getAppSettingsQueryResponse(String var0) {
      Bundle var1 = new Bundle();
      var1.putString("fields", TextUtils.join(",", APP_SETTING_FIELDS));
      GraphRequest var2 = GraphRequest.newGraphPathRequest(null, var0, null);
      var2.setSkipClientToken(true);
      var2.setParameters(var1);
      return var2.executeAndWait().getJSONObject();
   }

   public static FetchedAppSettings getAppSettingsWithoutQuery(String var0) {
      FetchedAppSettings var1;
      if (var0 != null) {
         var1 = fetchedAppSettings.get(var0);
      } else {
         var1 = null;
      }

      return var1;
   }

   public static void loadAppSettingsAsync() {
      Context var1 = FacebookSdk.getApplicationContext();
      String var3 = FacebookSdk.getApplicationId();
      boolean var0 = loadingSettings.compareAndSet(false, true);
      if (!Utility.isNullOrEmpty(var3) && !fetchedAppSettings.containsKey(var3) && var0) {
         String var2 = String.format("com.facebook.internal.APP_SETTINGS.%s", var3);
         FacebookSdk.getExecutor().execute(new Runnable(var1, var2, var3) {
            final String val$applicationId;
            final Context val$context;
            final String val$settingsKey;

            {
               this.val$context = var1;
               this.val$settingsKey = var2x;
               this.val$applicationId = var3x;
            }

            @Override
            public void run() {
               SharedPreferences var2x = this.val$context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
               String var3x = var2x.getString(this.val$settingsKey, null);
               if (!Utility.isNullOrEmpty(var3x)) {
                  JSONObject var1x;
                  try {
                     var1x = new JSONObject(var3x);
                  } catch (JSONException var4) {
                     Utility.logd("FacebookSDK", var4);
                     var1x = null;
                  }

                  if (var1x != null) {
                     FetchedAppSettingsManager.parseAppSettingsFromJSON(this.val$applicationId, var1x);
                  }
               }

               JSONObject var5 = FetchedAppSettingsManager.getAppSettingsQueryResponse(this.val$applicationId);
               if (var5 != null) {
                  FetchedAppSettingsManager.parseAppSettingsFromJSON(this.val$applicationId, var5);
                  var2x.edit().putString(this.val$settingsKey, var5.toString()).apply();
               }

               AutomaticAnalyticsLogger.logActivateAppEvent();
               FetchedAppSettingsManager.loadingSettings.set(false);
            }
         });
      }
   }

   private static FetchedAppSettings parseAppSettingsFromJSON(String var0, JSONObject var1) {
      JSONArray var3 = var1.optJSONArray("android_sdk_error_categories");
      FacebookRequestErrorClassification var5;
      if (var3 == null) {
         var5 = FacebookRequestErrorClassification.getDefaultErrorClassification();
      } else {
         var5 = FacebookRequestErrorClassification.createFromJSON(var3);
      }

      boolean var2;
      if ((var1.optInt("app_events_feature_bitmask", 0) & 8) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      FetchedAppSettings var4 = new FetchedAppSettings(
         var1.optBoolean("supports_implicit_sdk_logging", false),
         var1.optString("gdpv4_nux_content", ""),
         var1.optBoolean("gdpv4_nux_enabled", false),
         var1.optBoolean("gdpv4_chrome_custom_tabs_enabled", false),
         var1.optInt("app_events_session_timeout", Constants.getDefaultAppEventsSessionTimeoutInSeconds()),
         SmartLoginOption.parseOptions(var1.optLong("seamless_login")),
         parseDialogConfigurations(var1.optJSONObject("android_dialog_configs")),
         var2,
         var5,
         var1.optString("smart_login_bookmark_icon_url"),
         var1.optString("smart_login_menu_icon_url")
      );
      fetchedAppSettings.put(var0, var4);
      return var4;
   }

   private static Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations(JSONObject var0) {
      HashMap var3 = new HashMap();
      if (var0 != null) {
         JSONArray var5 = var0.optJSONArray("data");
         if (var5 != null) {
            for (int var1 = 0; var1 < var5.length(); var1++) {
               FetchedAppSettings.DialogFeatureConfig var4 = FetchedAppSettings.DialogFeatureConfig.parseDialogConfig(var5.optJSONObject(var1));
               if (var4 != null) {
                  String var6 = var4.getDialogName();
                  Map var2 = (Map)var3.get(var6);
                  Map var7 = var2;
                  if (var2 == null) {
                     var7 = new HashMap();
                     var3.put(var6, var7);
                  }

                  var7.put(var4.getFeatureName(), var4);
               }
            }
         }
      }

      return var3;
   }

   public static FetchedAppSettings queryAppSettings(String var0, boolean var1) {
      FetchedAppSettings var3;
      if (!var1 && fetchedAppSettings.containsKey(var0)) {
         var3 = fetchedAppSettings.get(var0);
      } else {
         JSONObject var2 = getAppSettingsQueryResponse(var0);
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = parseAppSettingsFromJSON(var0, var2);
         }
      }

      return var3;
   }
}
