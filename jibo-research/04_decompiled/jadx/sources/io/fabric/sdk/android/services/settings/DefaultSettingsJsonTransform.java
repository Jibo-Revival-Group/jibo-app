package io.fabric.sdk.android.services.settings;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    DefaultSettingsJsonTransform() {
    }

    @Override // io.fabric.sdk.android.services.settings.SettingsJsonTransform
    /* JADX INFO: renamed from: a */
    public SettingsData mo15446a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException {
        int iOptInt = jSONObject.optInt("settings_version", 0);
        int iOptInt2 = jSONObject.optInt("cache_duration", 3600);
        return new SettingsData(m15438a(currentTimeProvider, iOptInt2, jSONObject), m15439a(jSONObject.getJSONObject("app")), m15443e(jSONObject.getJSONObject("session")), m15444f(jSONObject.getJSONObject("prompt")), m15441c(jSONObject.getJSONObject("features")), m15442d(jSONObject.getJSONObject("analytics")), m15445g(jSONObject.getJSONObject("beta")), iOptInt, iOptInt2);
    }

    /* JADX INFO: renamed from: a */
    private AppSettingsData m15439a(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("identifier");
        String string2 = jSONObject.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        String string3 = jSONObject.getString("url");
        String string4 = jSONObject.getString("reports_url");
        boolean zOptBoolean = jSONObject.optBoolean("update_required", false);
        AppIconSettingsData appIconSettingsDataM15440b = null;
        if (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) {
            appIconSettingsDataM15440b = m15440b(jSONObject.getJSONObject("icon"));
        }
        return new AppSettingsData(string, string2, string3, string4, zOptBoolean, appIconSettingsDataM15440b);
    }

    /* JADX INFO: renamed from: b */
    private AppIconSettingsData m15440b(JSONObject jSONObject) throws JSONException {
        return new AppIconSettingsData(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    /* JADX INFO: renamed from: c */
    private FeaturesSettingsData m15441c(JSONObject jSONObject) {
        return new FeaturesSettingsData(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    /* JADX INFO: renamed from: d */
    private AnalyticsSettingsData m15442d(JSONObject jSONObject) {
        return new AnalyticsSettingsData(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    /* JADX INFO: renamed from: e */
    private SessionSettingsData m15443e(JSONObject jSONObject) throws JSONException {
        return new SessionSettingsData(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false), jSONObject.optInt("max_complete_sessions_count", 4));
    }

    /* JADX INFO: renamed from: f */
    private PromptSettingsData m15444f(JSONObject jSONObject) throws JSONException {
        return new PromptSettingsData(jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_TITLE, "Send Crash Report?"), jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    /* JADX INFO: renamed from: g */
    private BetaSettingsData m15445g(JSONObject jSONObject) throws JSONException {
        return new BetaSettingsData(jSONObject.optString("update_endpoint", SettingsJsonConstants.f14796a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    /* JADX INFO: renamed from: a */
    private long m15438a(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return currentTimeProvider.mo15215a() + (1000 * j);
    }
}
