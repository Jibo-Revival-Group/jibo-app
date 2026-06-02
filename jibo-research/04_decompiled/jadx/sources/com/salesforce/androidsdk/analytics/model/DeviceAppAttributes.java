package com.salesforce.androidsdk.analytics.model;

import android.content.Context;
import com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DeviceAppAttributes {

    /* JADX INFO: renamed from: a */
    private String f14029a;

    /* JADX INFO: renamed from: b */
    private String f14030b;

    /* JADX INFO: renamed from: c */
    private String f14031c;

    /* JADX INFO: renamed from: d */
    private String f14032d;

    /* JADX INFO: renamed from: e */
    private String f14033e;

    /* JADX INFO: renamed from: f */
    private String f14034f;

    /* JADX INFO: renamed from: g */
    private String f14035g;

    /* JADX INFO: renamed from: h */
    private String f14036h;

    /* JADX INFO: renamed from: i */
    private String f14037i;

    public DeviceAppAttributes(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f14029a = str;
        this.f14030b = str2;
        this.f14031c = str3;
        this.f14032d = str4;
        this.f14033e = str5;
        this.f14034f = str6;
        this.f14035g = str7;
        this.f14036h = str8;
        this.f14037i = str9;
    }

    public DeviceAppAttributes(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f14029a = jSONObject.optString("appVersion");
            this.f14030b = jSONObject.optString("appName");
            this.f14031c = jSONObject.optString("osVersion");
            this.f14032d = jSONObject.optString("osName");
            this.f14033e = jSONObject.optString("nativeAppType");
            this.f14034f = jSONObject.optString("mobileSdkVersion");
            this.f14035g = jSONObject.optString("deviceModel");
            this.f14036h = jSONObject.optString("deviceId");
            this.f14037i = jSONObject.optString("clientId");
        }
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m14334a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appVersion", this.f14029a);
            jSONObject.put("appName", this.f14030b);
            jSONObject.put("osVersion", this.f14031c);
            jSONObject.put("osName", this.f14032d);
            jSONObject.put("nativeAppType", this.f14033e);
            jSONObject.put("mobileSdkVersion", this.f14034f);
            jSONObject.put("deviceModel", this.f14035g);
            jSONObject.put("deviceId", this.f14036h);
            jSONObject.put("clientId", this.f14037i);
        } catch (JSONException e) {
            SalesforceAnalyticsLogger.m14396a((Context) null, "DeviceAppAttributes", "Exception thrown while attempting to convert to JSON", e);
        }
        return jSONObject;
    }
}
