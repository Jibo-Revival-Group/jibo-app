package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcim;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class FirebaseAnalytics {
    private final zzcim zziwf;

    public static class Event {
    }

    public static class Param {
    }

    public static class UserProperty {
    }

    public FirebaseAnalytics(zzcim zzcimVar) {
        zzbq.m7373a(zzcimVar);
        this.zziwf = zzcimVar;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        return zzcim.m8191a(context).m8241n();
    }

    public final Task<String> getAppInstanceId() {
        return this.zziwf.m8239l().m8301y();
    }

    public final void logEvent(String str, Bundle bundle) {
        this.zziwf.m8240m().logEvent(str, bundle);
    }

    public final void resetAnalyticsData() {
        this.zziwf.m8239l().m8279A();
    }

    public final void setAnalyticsCollectionEnabled(boolean z) {
        this.zziwf.m8240m().setMeasurementEnabled(z);
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        this.zziwf.m8249v().m8310a(activity, str, str2);
    }

    public final void setMinimumSessionDuration(long j) {
        this.zziwf.m8240m().setMinimumSessionDuration(j);
    }

    public final void setSessionTimeoutDuration(long j) {
        this.zziwf.m8240m().setSessionTimeoutDuration(j);
    }

    public final void setUserId(String str) {
        this.zziwf.m8240m().setUserPropertyInternal("app", "_id", str);
    }

    public final void setUserProperty(String str, String str2) {
        this.zziwf.m8240m().setUserProperty(str, str2);
    }
}
