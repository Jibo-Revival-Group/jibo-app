package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

class DefaultSettingsJsonTransform implements SettingsJsonTransform {
   private long a(CurrentTimeProvider var1, long var2, JSONObject var4) throws JSONException {
      if (var4.has("expires_at")) {
         var2 = var4.getLong("expires_at");
      } else {
         var2 = var1.a() + 1000L * var2;
      }

      return var2;
   }

   private AppSettingsData a(JSONObject var1) throws JSONException {
      String var5 = var1.getString("identifier");
      String var7 = var1.getString("status");
      String var8 = var1.getString("url");
      String var6 = var1.getString("reports_url");
      boolean var2 = var1.optBoolean("update_required", false);
      Object var4 = null;
      AppIconSettingsData var3 = (AppIconSettingsData)var4;
      if (var1.has("icon")) {
         var3 = (AppIconSettingsData)var4;
         if (var1.getJSONObject("icon").has("hash")) {
            var3 = this.b(var1.getJSONObject("icon"));
         }
      }

      return new AppSettingsData(var5, var7, var8, var6, var2, var3);
   }

   private AppIconSettingsData b(JSONObject var1) throws JSONException {
      return new AppIconSettingsData(var1.getString("hash"), var1.getInt("width"), var1.getInt("height"));
   }

   private FeaturesSettingsData c(JSONObject var1) {
      return new FeaturesSettingsData(
         var1.optBoolean("prompt_enabled", false),
         var1.optBoolean("collect_logged_exceptions", true),
         var1.optBoolean("collect_reports", true),
         var1.optBoolean("collect_analytics", false)
      );
   }

   private AnalyticsSettingsData d(JSONObject var1) {
      return new AnalyticsSettingsData(
         var1.optString("url", "https://e.crashlytics.com/spi/v2/events"),
         var1.optInt("flush_interval_secs", 600),
         var1.optInt("max_byte_size_per_file", 8000),
         var1.optInt("max_file_count_per_send", 1),
         var1.optInt("max_pending_send_file_count", 100),
         var1.optBoolean("track_custom_events", true),
         var1.optBoolean("track_predefined_events", true),
         var1.optInt("sampling_rate", 1),
         var1.optBoolean("flush_on_background", true)
      );
   }

   private SessionSettingsData e(JSONObject var1) throws JSONException {
      return new SessionSettingsData(
         var1.optInt("log_buffer_size", 64000),
         var1.optInt("max_chained_exception_depth", 8),
         var1.optInt("max_custom_exception_events", 64),
         var1.optInt("max_custom_key_value_pairs", 64),
         var1.optInt("identifier_mask", 255),
         var1.optBoolean("send_session_without_crash", false),
         var1.optInt("max_complete_sessions_count", 4)
      );
   }

   private PromptSettingsData f(JSONObject var1) throws JSONException {
      return new PromptSettingsData(
         var1.optString("title", "Send Crash Report?"),
         var1.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."),
         var1.optString("send_button_title", "Send"),
         var1.optBoolean("show_cancel_button", true),
         var1.optString("cancel_button_title", "Don't Send"),
         var1.optBoolean("show_always_send_button", true),
         var1.optString("always_send_button_title", "Always Send")
      );
   }

   private BetaSettingsData g(JSONObject var1) throws JSONException {
      return new BetaSettingsData(var1.optString("update_endpoint", SettingsJsonConstants.a), var1.optInt("update_suspend_duration", 3600));
   }

   @Override
   public SettingsData a(CurrentTimeProvider var1, JSONObject var2) throws JSONException {
      int var4 = var2.optInt("settings_version", 0);
      int var3 = var2.optInt("cache_duration", 3600);
      AppSettingsData var8 = this.a(var2.getJSONObject("app"));
      SessionSettingsData var10 = this.e(var2.getJSONObject("session"));
      PromptSettingsData var9 = this.f(var2.getJSONObject("prompt"));
      FeaturesSettingsData var5 = this.c(var2.getJSONObject("features"));
      AnalyticsSettingsData var6 = this.d(var2.getJSONObject("analytics"));
      BetaSettingsData var7 = this.g(var2.getJSONObject("beta"));
      return new SettingsData(this.a(var1, var3, var2), var8, var10, var9, var5, var6, var7, var4, var3);
   }
}
