package com.salesforce.androidsdk.config;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.RestrictionsManager;
import android.os.Build;
import android.os.Bundle;
import com.salesforce.androidsdk.analytics.EventBuilderHelper;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RuntimeConfig {

    /* JADX INFO: renamed from: d */
    private static RuntimeConfig f14192d = null;

    /* JADX INFO: renamed from: a */
    private final ExecutorService f14193a = Executors.newFixedThreadPool(1);

    /* JADX INFO: renamed from: b */
    private boolean f14194b;

    /* JADX INFO: renamed from: c */
    private Bundle f14195c;

    public enum ConfigKey {
        AppServiceHosts,
        AppServiceHostLabels,
        ManagedAppOAuthID,
        ManagedAppCallbackURL,
        RequireCertAuth,
        ManagedAppCertAlias,
        OnlyShowAuthorizedHosts
    }

    private RuntimeConfig(Context context) {
        this.f14194b = false;
        this.f14195c = null;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f14195c = m14526b(context);
            this.f14194b = m14528c(context);
            if (this.f14194b && this.f14195c != null && !this.f14195c.isEmpty()) {
                SalesforceSDKManager.m14403a().m14439e("MM");
                if (m14532c(ConfigKey.RequireCertAuth).booleanValue()) {
                    SalesforceSDKManager.m14403a().m14439e("CT");
                }
            }
            this.f14193a.execute(new Runnable() { // from class: com.salesforce.androidsdk.config.RuntimeConfig.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("mdmIsActive", RuntimeConfig.this.f14194b);
                        if (RuntimeConfig.this.f14195c != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            for (String str : RuntimeConfig.this.f14195c.keySet()) {
                                jSONObject2.put(str, JSONObject.wrap(RuntimeConfig.this.f14195c.get(str)));
                            }
                            jSONObject.put("mdmConfigs", jSONObject2);
                        }
                    } catch (JSONException e) {
                        SalesforceSDKLogger.m15016a("RuntimeConfig", "Exception thrown while creating JSON", e);
                    }
                    EventBuilderHelper.m14289b("mdmConfiguration", null, "RuntimeConfig", jSONObject);
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    public static RuntimeConfig m14524a(Context context) {
        if (f14192d == null) {
            f14192d = new RuntimeConfig(context);
        }
        return f14192d;
    }

    /* JADX INFO: renamed from: a */
    public boolean m14530a() {
        return this.f14194b;
    }

    /* JADX INFO: renamed from: a */
    public String m14529a(ConfigKey configKey) {
        if (this.f14195c == null) {
            return null;
        }
        return this.f14195c.getString(configKey.name());
    }

    /* JADX INFO: renamed from: b */
    public String[] m14531b(ConfigKey configKey) {
        if (this.f14195c == null) {
            return null;
        }
        return this.f14195c.getStringArray(configKey.name());
    }

    /* JADX INFO: renamed from: c */
    public Boolean m14532c(ConfigKey configKey) {
        return Boolean.valueOf(this.f14195c == null ? false : this.f14195c.getBoolean(configKey.name()));
    }

    @TargetApi(21)
    /* JADX INFO: renamed from: b */
    private Bundle m14526b(Context context) {
        return ((RestrictionsManager) context.getSystemService("restrictions")).getApplicationRestrictions();
    }

    @TargetApi(21)
    /* JADX INFO: renamed from: c */
    private boolean m14528c(Context context) {
        return ((RestrictionsManager) context.getSystemService("restrictions")).hasRestrictionsProvider();
    }
}
