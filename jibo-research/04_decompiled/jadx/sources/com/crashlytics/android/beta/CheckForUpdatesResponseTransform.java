package com.crashlytics.android.beta;

import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class CheckForUpdatesResponseTransform {
    CheckForUpdatesResponseTransform() {
    }

    /* JADX INFO: renamed from: a */
    public CheckForUpdatesResponse m5705a(JSONObject jSONObject) throws IOException {
        if (jSONObject == null) {
            return null;
        }
        return new CheckForUpdatesResponse(jSONObject.optString("url", null), jSONObject.optString("version_string", null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
    }
}
