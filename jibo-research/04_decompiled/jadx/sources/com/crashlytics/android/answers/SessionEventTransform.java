package com.crashlytics.android.answers;

import android.annotation.TargetApi;
import android.os.Build;
import com.facebook.share.internal.ShareConstants;
import io.fabric.sdk.android.services.events.EventTransform;
import java.io.IOException;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class SessionEventTransform implements EventTransform<SessionEvent> {
    SessionEventTransform() {
    }

    @Override // io.fabric.sdk.android.services.events.EventTransform
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] mo5680a(SessionEvent sessionEvent) throws IOException {
        return m5681b(sessionEvent).toString().getBytes(HTTP.UTF_8);
    }

    @TargetApi(9)
    /* JADX INFO: renamed from: b */
    public JSONObject m5681b(SessionEvent sessionEvent) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            SessionEventMetadata sessionEventMetadata = sessionEvent.f5075a;
            jSONObject.put("appBundleId", sessionEventMetadata.f5091a);
            jSONObject.put("executionId", sessionEventMetadata.f5092b);
            jSONObject.put("installationId", sessionEventMetadata.f5093c);
            jSONObject.put("androidId", sessionEventMetadata.f5094d);
            jSONObject.put("advertisingId", sessionEventMetadata.f5095e);
            jSONObject.put("limitAdTrackingEnabled", sessionEventMetadata.f5096f);
            jSONObject.put("betaDeviceToken", sessionEventMetadata.f5097g);
            jSONObject.put("buildId", sessionEventMetadata.f5098h);
            jSONObject.put("osVersion", sessionEventMetadata.f5099i);
            jSONObject.put("deviceModel", sessionEventMetadata.f5100j);
            jSONObject.put("appVersionCode", sessionEventMetadata.f5101k);
            jSONObject.put("appVersionName", sessionEventMetadata.f5102l);
            jSONObject.put("timestamp", sessionEvent.f5076b);
            jSONObject.put(ShareConstants.MEDIA_TYPE, sessionEvent.f5077c.toString());
            if (sessionEvent.f5078d != null) {
                jSONObject.put("details", new JSONObject(sessionEvent.f5078d));
            }
            jSONObject.put("customType", sessionEvent.f5079e);
            if (sessionEvent.f5080f != null) {
                jSONObject.put("customAttributes", new JSONObject(sessionEvent.f5080f));
            }
            jSONObject.put("predefinedType", sessionEvent.f5081g);
            if (sessionEvent.f5082h != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(sessionEvent.f5082h));
            }
            return jSONObject;
        } catch (JSONException e) {
            if (Build.VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
