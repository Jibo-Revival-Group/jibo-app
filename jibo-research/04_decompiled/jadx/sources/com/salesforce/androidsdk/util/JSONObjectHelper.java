package com.salesforce.androidsdk.util;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JSONObjectHelper {
    /* JADX INFO: renamed from: a */
    public static Object m15011a(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.opt(str);
    }

    /* JADX INFO: renamed from: a */
    public static Object m15010a(JSONArray jSONArray, int i) {
        if (jSONArray.isNull(i)) {
            return null;
        }
        return jSONArray.opt(i);
    }
}
