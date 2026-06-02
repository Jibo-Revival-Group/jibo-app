package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface SettingsJsonTransform {
    /* JADX INFO: renamed from: a */
    SettingsData mo15446a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException;
}
