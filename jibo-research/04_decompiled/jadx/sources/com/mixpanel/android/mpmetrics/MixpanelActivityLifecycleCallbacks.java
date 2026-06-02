package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.mixpanel.android.viewcrawler.GestureTracker;
import java.text.NumberFormat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
class MixpanelActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: e */
    private static Double f11987e;

    /* JADX INFO: renamed from: b */
    private Runnable f11989b;

    /* JADX INFO: renamed from: f */
    private final MixpanelAPI f11992f;

    /* JADX INFO: renamed from: g */
    private final MPConfig f11993g;

    /* JADX INFO: renamed from: a */
    private Handler f11988a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c */
    private boolean f11990c = true;

    /* JADX INFO: renamed from: d */
    private boolean f11991d = true;

    public MixpanelActivityLifecycleCallbacks(MixpanelAPI mixpanelAPI, MPConfig mPConfig) {
        this.f11992f = mixpanelAPI;
        this.f11993g = mPConfig;
        if (f11987e == null) {
            f11987e = Double.valueOf(System.currentTimeMillis());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        m11879a(activity.getIntent());
        if (Build.VERSION.SDK_INT >= 16 && this.f11993g.m11778n()) {
            this.f11992f.m11842c().mo11861a(activity);
        }
        new GestureTracker(this.f11992f, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f11991d = true;
        if (this.f11989b != null) {
            this.f11988a.removeCallbacks(this.f11989b);
        }
        Handler handler = this.f11988a;
        Runnable runnable = new Runnable() { // from class: com.mixpanel.android.mpmetrics.MixpanelActivityLifecycleCallbacks.1
            @Override // java.lang.Runnable
            public void run() {
                if (MixpanelActivityLifecycleCallbacks.this.f11990c && MixpanelActivityLifecycleCallbacks.this.f11991d) {
                    MixpanelActivityLifecycleCallbacks.this.f11990c = false;
                    try {
                        double dCurrentTimeMillis = System.currentTimeMillis() - MixpanelActivityLifecycleCallbacks.f11987e.doubleValue();
                        if (dCurrentTimeMillis >= MixpanelActivityLifecycleCallbacks.this.f11993g.m11783s() && dCurrentTimeMillis < MixpanelActivityLifecycleCallbacks.this.f11993g.m11784t()) {
                            NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.ENGLISH);
                            numberInstance.setMaximumFractionDigits(1);
                            String str = numberInstance.format((System.currentTimeMillis() - MixpanelActivityLifecycleCallbacks.f11987e.doubleValue()) / 1000.0d);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("$ae_session_length", str);
                            MixpanelActivityLifecycleCallbacks.this.f11992f.m11837a("$ae_session", jSONObject, true);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    MixpanelActivityLifecycleCallbacks.this.f11992f.m11847h();
                }
            }
        };
        this.f11989b = runnable;
        handler.postDelayed(runnable, 500L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16 && this.f11993g.m11778n()) {
            this.f11992f.m11842c().mo11868b();
        }
        this.f11991d = false;
        boolean z = this.f11990c ? false : true;
        this.f11990c = true;
        if (this.f11989b != null) {
            this.f11988a.removeCallbacks(this.f11989b);
        }
        if (z) {
            f11987e = Double.valueOf(System.currentTimeMillis());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* JADX INFO: renamed from: a */
    protected boolean m11886a() {
        return this.f11990c;
    }

    /* JADX INFO: renamed from: a */
    private void m11879a(Intent intent) {
        JSONObject jSONObject;
        if (intent != null) {
            try {
                if (intent.hasExtra("mp_campaign_id") && intent.hasExtra("mp_message_id")) {
                    String stringExtra = intent.getStringExtra("mp_campaign_id");
                    String stringExtra2 = intent.getStringExtra("mp_message_id");
                    String stringExtra3 = intent.getStringExtra("mp");
                    try {
                        if (stringExtra3 != null) {
                            jSONObject = new JSONObject(stringExtra3);
                        } else {
                            jSONObject = new JSONObject();
                        }
                        jSONObject.put("campaign_id", Integer.valueOf(stringExtra).intValue());
                        jSONObject.put("message_id", Integer.valueOf(stringExtra2).intValue());
                        jSONObject.put("message_type", "push");
                        this.f11992f.m11836a("$app_open", jSONObject);
                    } catch (JSONException e) {
                    }
                    intent.removeExtra("mp_campaign_id");
                    intent.removeExtra("mp_message_id");
                    intent.removeExtra("mp");
                }
            } catch (BadParcelableException e2) {
            }
        }
    }
}
