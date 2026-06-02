package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
final class zzckb implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcjn f7491a;

    private zzckb(zzcjn zzcjnVar) {
        this.f7491a = zzcjnVar;
    }

    /* synthetic */ zzckb(zzcjn zzcjnVar, zzcjo zzcjoVar) {
        this(zzcjnVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Bundle bundle2;
        Uri data;
        try {
            this.f7491a.mo7872t().m8101E().m8108a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null && (data = intent.getData()) != null && data.isHierarchical()) {
                if (bundle == null) {
                    Bundle bundleM8416a = this.f7491a.mo7868p().m8416a(data);
                    this.f7491a.mo7868p();
                    String str = zzclq.m8391a(intent) ? "gs" : "auto";
                    if (bundleM8416a != null) {
                        this.f7491a.m8289a(str, "_cmp", bundleM8416a);
                    }
                }
                String queryParameter = data.getQueryParameter("referrer");
                if (TextUtils.isEmpty(queryParameter)) {
                    return;
                }
                if (!(queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content")))) {
                    this.f7491a.mo7872t().m8100D().m8108a("Activity created with data 'referrer' param without gclid and at least one utm field");
                    return;
                } else {
                    this.f7491a.mo7872t().m8100D().m8109a("Activity created with referrer", queryParameter);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        this.f7491a.m8292a("auto", "_ldl", (Object) queryParameter);
                    }
                }
            }
        } catch (Throwable th) {
            this.f7491a.mo7872t().m8106y().m8109a("Throwable caught in onActivityCreated", th);
        }
        zzckc zzckcVarMo7862j = this.f7491a.mo7862j();
        if (bundle == null || (bundle2 = bundle.getBundle("com.google.firebase.analytics.screen_service")) == null) {
            return;
        }
        zzckf zzckfVarM8308a = zzckcVarMo7862j.m8308a(activity);
        zzckfVarM8308a.f8398d = bundle2.getLong(ShareConstants.WEB_DIALOG_PARAM_ID);
        zzckfVarM8308a.f8396b = bundle2.getString("name");
        zzckfVarM8308a.f8397c = bundle2.getString("referrer_name");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f7491a.mo7862j().m8316d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.f7491a.mo7862j().m8315c(activity);
        zzclf zzclfVarMo7870r = this.f7491a.mo7870r();
        zzclfVarMo7870r.mo7871s().m8173a(new zzclj(zzclfVarMo7870r, zzclfVarMo7870r.mo7863k().mo7497b()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.f7491a.mo7862j().m8313b(activity);
        zzclf zzclfVarMo7870r = this.f7491a.mo7870r();
        zzclfVarMo7870r.mo7871s().m8173a(new zzcli(zzclfVarMo7870r, zzclfVarMo7870r.mo7863k().mo7497b()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f7491a.mo7862j().m8309a(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
