package com.salesforce.androidsdk.smartstore.store;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SoupSpec {

    /* JADX INFO: renamed from: a */
    public static final String[] f14337a = {"externalStorage"};

    /* JADX INFO: renamed from: b */
    private String f14338b;

    /* JADX INFO: renamed from: c */
    private List<String> f14339c;

    public SoupSpec(String str) {
        this.f14338b = str;
        this.f14339c = Collections.emptyList();
    }

    public SoupSpec(String str, String... strArr) {
        this.f14338b = str;
        if (strArr != null) {
            this.f14339c = Arrays.asList(strArr);
        } else {
            this.f14339c = Collections.emptyList();
        }
    }

    /* JADX INFO: renamed from: a */
    public String m14806a() {
        return this.f14338b;
    }

    /* JADX INFO: renamed from: b */
    public List<String> m14807b() {
        return this.f14339c;
    }

    /* JADX INFO: renamed from: a */
    public static SoupSpec m14805a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("features");
        if (jSONArrayOptJSONArray == null) {
            return new SoupSpec(jSONObject.getString("name"));
        }
        String[] strArr = new String[jSONArrayOptJSONArray.length()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < jSONArrayOptJSONArray.length()) {
                strArr[i2] = (String) jSONArrayOptJSONArray.get(i2);
                i = i2 + 1;
            } else {
                return new SoupSpec(jSONObject.getString("name"), strArr);
            }
        }
    }
}
