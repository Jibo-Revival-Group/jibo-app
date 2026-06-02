package com.salesforce.androidsdk.config;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.salesforce.androidsdk.R;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.config.RuntimeConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BootConfig {

    /* JADX INFO: renamed from: a */
    private static final String f14174a = "www" + System.getProperty("file.separator") + "bootconfig.json";

    /* JADX INFO: renamed from: k */
    private static BootConfig f14175k = null;

    /* JADX INFO: renamed from: b */
    private String f14176b;

    /* JADX INFO: renamed from: c */
    private String f14177c;

    /* JADX INFO: renamed from: d */
    private String[] f14178d;

    /* JADX INFO: renamed from: e */
    private boolean f14179e;

    /* JADX INFO: renamed from: f */
    private String f14180f;

    /* JADX INFO: renamed from: g */
    private String f14181g;

    /* JADX INFO: renamed from: h */
    private boolean f14182h;

    /* JADX INFO: renamed from: i */
    private boolean f14183i;

    /* JADX INFO: renamed from: j */
    private String f14184j;

    /* JADX INFO: renamed from: a */
    public static BootConfig m14502a(Context context) {
        if (f14175k == null) {
            f14175k = new BootConfig();
            if (SalesforceSDKManager.m14403a().m14419A()) {
                f14175k.m14505c(context);
            } else {
                f14175k.m14506d(context);
            }
            f14175k.m14504b(context);
        }
        return f14175k;
    }

    /* JADX INFO: renamed from: b */
    private void m14504b(Context context) {
        RuntimeConfig runtimeConfigM14524a = RuntimeConfig.m14524a(context);
        String strM14529a = runtimeConfigM14524a.m14529a(RuntimeConfig.ConfigKey.ManagedAppOAuthID);
        String strM14529a2 = runtimeConfigM14524a.m14529a(RuntimeConfig.ConfigKey.ManagedAppCallbackURL);
        if (!TextUtils.isEmpty(strM14529a)) {
            this.f14176b = strM14529a;
        }
        if (!TextUtils.isEmpty(strM14529a2)) {
            this.f14177c = strM14529a2;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m14505c(Context context) {
        m14503a(m14507e(context));
    }

    /* JADX INFO: renamed from: d */
    private void m14506d(Context context) {
        Resources resources = context.getResources();
        this.f14176b = resources.getString(R.string.remoteAccessConsumerKey);
        this.f14177c = resources.getString(R.string.oauthRedirectURI);
        this.f14178d = resources.getStringArray(R.array.oauthScopes);
        this.f14184j = resources.getString(R.string.androidPushNotificationClientId);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String m14507e(android.content.Context r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r2 = 0
            java.util.Scanner r1 = new java.util.Scanner     // Catch: java.io.IOException -> L20 java.lang.Throwable -> L44
            android.content.res.AssetManager r0 = r6.getAssets()     // Catch: java.io.IOException -> L20 java.lang.Throwable -> L44
            java.lang.String r3 = com.salesforce.androidsdk.config.BootConfig.f14174a     // Catch: java.io.IOException -> L20 java.lang.Throwable -> L44
            java.io.InputStream r0 = r0.open(r3)     // Catch: java.io.IOException -> L20 java.lang.Throwable -> L44
            r1.<init>(r0)     // Catch: java.io.IOException -> L20 java.lang.Throwable -> L44
            java.lang.String r0 = "\\A"
            java.util.Scanner r0 = r1.useDelimiter(r0)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L47
            java.lang.String r0 = r0.next()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L47
            if (r1 == 0) goto L1f
            r1.close()
        L1f:
            return r0
        L20:
            r0 = move-exception
            r1 = r2
        L22:
            com.salesforce.androidsdk.config.BootConfig$BootConfigException r2 = new com.salesforce.androidsdk.config.BootConfig$BootConfigException     // Catch: java.lang.Throwable -> L3d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3d
            r3.<init>()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r4 = "Failed to open "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r4 = com.salesforce.androidsdk.config.BootConfig.f14174a     // Catch: java.lang.Throwable -> L3d
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3d
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L3d
            throw r2     // Catch: java.lang.Throwable -> L3d
        L3d:
            r0 = move-exception
        L3e:
            if (r1 == 0) goto L43
            r1.close()
        L43:
            throw r0
        L44:
            r0 = move-exception
            r1 = r2
            goto L3e
        L47:
            r0 = move-exception
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.config.BootConfig.m14507e(android.content.Context):java.lang.String");
    }

    /* JADX INFO: renamed from: a */
    private void m14503a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f14176b = jSONObject.getString("remoteAccessConsumerKey");
            this.f14177c = jSONObject.getString("oauthRedirectURI");
            JSONArray jSONArray = jSONObject.getJSONArray("oauthScopes");
            this.f14178d = new String[jSONArray.length()];
            for (int i = 0; i < this.f14178d.length; i++) {
                this.f14178d[i] = jSONArray.getString(i);
            }
            this.f14179e = jSONObject.getBoolean("isLocal");
            this.f14180f = jSONObject.getString("startPage");
            this.f14181g = jSONObject.getString("errorPage");
            this.f14184j = jSONObject.optString("androidPushNotificationClientId");
            this.f14182h = jSONObject.optBoolean("shouldAuthenticate", true);
            this.f14183i = jSONObject.optBoolean("attemptOfflineLoad", true);
        } catch (JSONException e) {
            throw new BootConfigException("Failed to parse " + f14174a, e);
        }
    }

    /* JADX INFO: renamed from: a */
    public String m14508a() {
        return this.f14176b;
    }

    /* JADX INFO: renamed from: b */
    public String m14509b() {
        return this.f14177c;
    }

    /* JADX INFO: renamed from: c */
    public String[] m14510c() {
        return this.f14178d;
    }

    /* JADX INFO: renamed from: d */
    public String m14511d() {
        return this.f14184j;
    }

    public static class BootConfigException extends RuntimeException {
        public BootConfigException(String str, Throwable th) {
            super(str, th);
        }
    }
}
