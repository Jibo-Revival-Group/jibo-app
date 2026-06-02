package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

public interface SettingsJsonTransform {
   SettingsData a(CurrentTimeProvider var1, JSONObject var2) throws JSONException;
}
