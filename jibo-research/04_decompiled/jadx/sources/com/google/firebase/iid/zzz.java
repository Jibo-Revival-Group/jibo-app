package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzz {

    /* JADX INFO: renamed from: b */
    private static final long f8703b = TimeUnit.DAYS.toMillis(7);

    /* JADX INFO: renamed from: a */
    final String f8704a;

    /* JADX INFO: renamed from: c */
    private String f8705c;

    /* JADX INFO: renamed from: d */
    private long f8706d;

    private zzz(String str, String str2, long j) {
        this.f8704a = str;
        this.f8705c = str2;
        this.f8706d = j;
    }

    /* JADX INFO: renamed from: a */
    static zzz m9188a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new zzz(str, null, 0L);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzz(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e) {
            String strValueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 23).append("Failed to parse token: ").append(strValueOf).toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    static String m9189a(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e) {
            String strValueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 24).append("Failed to encode token: ").append(strValueOf).toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    final boolean m9190b(String str) {
        return System.currentTimeMillis() > this.f8706d + f8703b || !str.equals(this.f8705c);
    }
}
