package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.util.ArrayMap;
import com.facebook.AccessToken;
import com.google.android.gms.common.api.internal.zzbz;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcim;
import com.google.android.gms.internal.zzcln;
import com.google.android.gms.internal.zzclq;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
@Deprecated
public class AppMeasurement {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    private final zzcim zziwf;

    public static class ConditionalUserProperty {

        @Keep
        public boolean mActive;

        @Keep
        public String mAppId;

        @Keep
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @Keep
        public String mName;

        @Keep
        public String mOrigin;

        @Keep
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @Keep
        public String mTriggerEventName;

        @Keep
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @Keep
        public long mTriggeredTimestamp;

        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            zzbq.m7373a(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            if (conditionalUserProperty.mValue != null) {
                this.mValue = zzclq.m8404b(conditionalUserProperty.mValue);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mValue = conditionalUserProperty.mValue;
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
        }
    }

    public static final class Event extends FirebaseAnalytics.Event {

        /* JADX INFO: renamed from: a */
        public static final String[] f8390a = {"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter"};

        /* JADX INFO: renamed from: b */
        public static final String[] f8391b = {"_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_vs", "_ep"};

        /* JADX INFO: renamed from: a */
        public static String m8916a(String str) {
            return zzclq.m8388a(str, f8390a, f8391b);
        }
    }

    public interface EventInterceptor {
        /* JADX INFO: renamed from: a */
        void m8917a(String str, String str2, Bundle bundle, long j);
    }

    public interface OnEventListener {
        /* JADX INFO: renamed from: a */
        void m8918a(String str, String str2, Bundle bundle, long j);
    }

    public static final class Param extends FirebaseAnalytics.Param {

        /* JADX INFO: renamed from: a */
        public static final String[] f8392a = {"firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "firebase_event_id", "firebase_extra_params_ct", "firebase_group_name", "firebase_list_length", "firebase_index", "firebase_event_name"};

        /* JADX INFO: renamed from: b */
        public static final String[] f8393b = {"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en"};

        /* JADX INFO: renamed from: a */
        public static String m8919a(String str) {
            return zzclq.m8388a(str, f8392a, f8393b);
        }
    }

    public static final class UserProperty extends FirebaseAnalytics.UserProperty {

        /* JADX INFO: renamed from: a */
        public static final String[] f8394a = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", AccessToken.USER_ID_KEY, "first_open_after_install"};

        /* JADX INFO: renamed from: b */
        public static final String[] f8395b = {"_ln", "_fot", "_fvt", "_ldl", "_id", "_fi"};

        /* JADX INFO: renamed from: a */
        public static String m8920a(String str) {
            return zzclq.m8388a(str, f8394a, f8395b);
        }
    }

    public interface zza {
        /* JADX INFO: renamed from: a */
        boolean m8921a(zzb zzbVar, zzb zzbVar2);
    }

    public static class zzb {

        /* JADX INFO: renamed from: b */
        public String f8396b;

        /* JADX INFO: renamed from: c */
        public String f8397c;

        /* JADX INFO: renamed from: d */
        public long f8398d;

        public zzb() {
        }

        public zzb(zzb zzbVar) {
            this.f8396b = zzbVar.f8396b;
            this.f8397c = zzbVar.f8397c;
            this.f8398d = zzbVar.f8398d;
        }
    }

    public AppMeasurement(zzcim zzcimVar) {
        zzbq.m7373a(zzcimVar);
        this.zziwf = zzcimVar;
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return zzcim.m8191a(context).m8240m();
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.zziwf.m8204A().m7852a(str);
    }

    @Keep
    protected void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zziwf.m8239l().m8299b(str, str2, bundle);
    }

    @Keep
    protected void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        this.zziwf.m8239l().m8293a(str, str2, str3, bundle);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.zziwf.m8204A().m7854b(str);
    }

    @Keep
    public long generateEventId() {
        return this.zziwf.m8242o().m8443y();
    }

    @Keep
    public String getAppInstanceId() {
        return this.zziwf.m8239l().m8302z();
    }

    @Keep
    protected List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return this.zziwf.m8239l().m8280a(str, str2);
    }

    @Keep
    protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        return this.zziwf.m8239l().m8281a(str, str2, str3);
    }

    @Keep
    public String getCurrentScreenClass() {
        zzb zzbVarM8318z = this.zziwf.m8249v().m8318z();
        if (zzbVarM8318z != null) {
            return zzbVarM8318z.f8397c;
        }
        return null;
    }

    @Keep
    public String getCurrentScreenName() {
        zzb zzbVarM8318z = this.zziwf.m8249v().m8318z();
        if (zzbVarM8318z != null) {
            return zzbVarM8318z.f8396b;
        }
        return null;
    }

    @Keep
    public String getGmpAppId() {
        try {
            return zzbz.m7157a();
        } catch (IllegalStateException e) {
            this.zziwf.m8233f().m8106y().m8109a("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    @Keep
    protected int getMaxUserProperties(String str) {
        this.zziwf.m8239l();
        zzbq.m7375a(str);
        return 25;
    }

    @Keep
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zziwf.m8239l().m8283a(str, str2, z);
    }

    public Map<String, Object> getUserProperties(boolean z) {
        List<zzcln> listM8295b = this.zziwf.m8239l().m8295b(z);
        ArrayMap arrayMap = new ArrayMap(listM8295b.size());
        for (zzcln zzclnVar : listM8295b) {
            arrayMap.put(zzclnVar.f7598a, zzclnVar.m8383a());
        }
        return arrayMap;
    }

    @Keep
    protected Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        return this.zziwf.m8239l().m8282a(str, str2, str3, z);
    }

    public final void logEvent(String str, Bundle bundle) {
        int iM8430b;
        if (bundle == null) {
            bundle = new Bundle();
        }
        if ("_iap".equals(str) || (iM8430b = this.zziwf.m8242o().m8430b(str)) == 0) {
            this.zziwf.m8239l().m8291a("app", str, bundle, true);
        } else {
            this.zziwf.m8242o();
            this.zziwf.m8242o().m8422a(iM8430b, "_ev", zzclq.m8387a(str, 40, true), str != null ? str.length() : 0);
        }
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zziwf.m8239l().m8289a(str, str2, bundle);
    }

    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zziwf.m8239l().m8290a(str, str2, bundle == null ? new Bundle() : bundle, j);
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zziwf.m8239l().m8287a(onEventListener);
    }

    @Keep
    public void registerOnScreenChangeCallback(zza zzaVar) {
        this.zziwf.m8249v().m8311a(zzaVar);
    }

    @Keep
    protected void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        this.zziwf.m8239l().m8285a(conditionalUserProperty);
    }

    @Keep
    protected void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        this.zziwf.m8239l().m8297b(conditionalUserProperty);
    }

    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zziwf.m8239l().m8286a(eventInterceptor);
    }

    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        this.zziwf.m8239l().m8294a(z);
    }

    public final void setMinimumSessionDuration(long j) {
        this.zziwf.m8239l().m8284a(j);
    }

    public final void setSessionTimeoutDuration(long j) {
        this.zziwf.m8239l().m8296b(j);
    }

    public final void setUserProperty(String str, String str2) {
        int iM8436d = this.zziwf.m8242o().m8436d(str);
        if (iM8436d == 0) {
            setUserPropertyInternal("app", str, str2);
        } else {
            this.zziwf.m8242o();
            this.zziwf.m8242o().m8422a(iM8436d, "_ev", zzclq.m8387a(str, 24, true), str != null ? str.length() : 0);
        }
    }

    public void setUserPropertyInternal(String str, String str2, Object obj) {
        this.zziwf.m8239l().m8292a(str, str2, obj);
    }

    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zziwf.m8239l().m8298b(onEventListener);
    }

    @Keep
    public void unregisterOnScreenChangeCallback(zza zzaVar) {
        this.zziwf.m8249v().m8314b(zzaVar);
    }
}
