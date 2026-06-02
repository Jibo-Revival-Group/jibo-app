package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.mpmetrics.DecideMessages;
import com.mixpanel.android.mpmetrics.SharedPreferencesLoader;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.TrackingDebug;
import com.mixpanel.android.viewcrawler.UpdatesFromMixpanel;
import com.mixpanel.android.viewcrawler.ViewCrawler;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MixpanelAPI {

    /* JADX INFO: renamed from: n */
    private static final Map<String, Map<Context, MixpanelAPI>> f11955n = new HashMap();

    /* JADX INFO: renamed from: o */
    private static final SharedPreferencesLoader f11956o = new SharedPreferencesLoader();

    /* JADX INFO: renamed from: p */
    private static final Tweaks f11957p = new Tweaks();

    /* JADX INFO: renamed from: q */
    private static Future<SharedPreferences> f11958q;

    /* JADX INFO: renamed from: a */
    private final Context f11959a;

    /* JADX INFO: renamed from: b */
    private final AnalyticsMessages f11960b;

    /* JADX INFO: renamed from: c */
    private final MPConfig f11961c;

    /* JADX INFO: renamed from: d */
    private final String f11962d;

    /* JADX INFO: renamed from: e */
    private final PeopleImpl f11963e;

    /* JADX INFO: renamed from: f */
    private final UpdatesFromMixpanel f11964f;

    /* JADX INFO: renamed from: g */
    private final PersistentIdentity f11965g;

    /* JADX INFO: renamed from: h */
    private final UpdatesListener f11966h;

    /* JADX INFO: renamed from: i */
    private final TrackingDebug f11967i;

    /* JADX INFO: renamed from: j */
    private final DecideMessages f11968j;

    /* JADX INFO: renamed from: k */
    private final Map<String, String> f11969k;

    /* JADX INFO: renamed from: l */
    private final Map<String, Long> f11970l;

    /* JADX INFO: renamed from: m */
    private MixpanelActivityLifecycleCallbacks f11971m;

    interface InstanceProcessor {
        /* JADX INFO: renamed from: a */
        void mo11692a(MixpanelAPI mixpanelAPI);
    }

    public interface People {
        /* JADX INFO: renamed from: a */
        void mo11859a();

        /* JADX INFO: renamed from: a */
        void mo11860a(double d, JSONObject jSONObject);

        /* JADX INFO: renamed from: a */
        void mo11861a(Activity activity);

        /* JADX INFO: renamed from: a */
        void mo11862a(String str);

        /* JADX INFO: renamed from: a */
        void mo11863a(String str, double d);

        /* JADX INFO: renamed from: a */
        void mo11864a(String str, InAppNotification inAppNotification, JSONObject jSONObject);

        /* JADX INFO: renamed from: a */
        void mo11865a(String str, Object obj);

        /* JADX INFO: renamed from: a */
        void mo11866a(String str, JSONObject jSONObject);

        /* JADX INFO: renamed from: a */
        void mo11867a(JSONObject jSONObject);

        /* JADX INFO: renamed from: b */
        void mo11868b();

        /* JADX INFO: renamed from: b */
        void mo11869b(String str);

        /* JADX INFO: renamed from: b */
        void mo11870b(String str, Object obj);

        /* JADX INFO: renamed from: c */
        People mo11871c(String str);
    }

    private interface UpdatesListener extends DecideMessages.OnNewResultsListener {
    }

    MixpanelAPI(Context context, Future<SharedPreferences> future, String str) {
        this(context, future, str, MPConfig.m11762a(context));
    }

    MixpanelAPI(Context context, Future<SharedPreferences> future, String str, MPConfig mPConfig) {
        this.f11959a = context;
        this.f11962d = str;
        this.f11963e = new PeopleImpl();
        this.f11961c = mPConfig;
        HashMap map = new HashMap();
        map.put("$android_lib_version", "5.2.1");
        map.put("$android_os", "Android");
        map.put("$android_os_version", Build.VERSION.RELEASE == null ? "UNKNOWN" : Build.VERSION.RELEASE);
        map.put("$android_manufacturer", Build.MANUFACTURER == null ? "UNKNOWN" : Build.MANUFACTURER);
        map.put("$android_brand", Build.BRAND == null ? "UNKNOWN" : Build.BRAND);
        map.put("$android_model", Build.MODEL == null ? "UNKNOWN" : Build.MODEL);
        try {
            PackageInfo packageInfo = this.f11959a.getPackageManager().getPackageInfo(this.f11959a.getPackageName(), 0);
            map.put("$android_app_version", packageInfo.versionName);
            map.put("$android_app_version_code", Integer.toString(packageInfo.versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            MPLog.m12031e("MixpanelAPI.API", "Exception getting app version name", e);
        }
        this.f11969k = Collections.unmodifiableMap(map);
        this.f11964f = m11839b(context, str);
        this.f11967i = m11850k();
        this.f11965g = m11831a(context, future, str);
        this.f11970l = this.f11965g.m11919g();
        this.f11966h = m11849j();
        this.f11968j = m11830a(str, this.f11966h, this.f11964f);
        String strM11910c = this.f11965g.m11910c();
        this.f11968j.m11709a(strM11910c == null ? this.f11965g.m11907b() : strM11910c);
        this.f11960b = m11848i();
        if (this.f11965g.m11906a(MPDbAdapter.m11791a(this.f11959a).m11803b().exists())) {
            m11837a("$ae_first_open", (JSONObject) null, true);
            this.f11965g.m11921h();
        }
        if (!this.f11961c.m11780p()) {
            this.f11960b.m11668a(this.f11968j);
        }
        m11845f();
        if (m11851l()) {
            m11836a("$app_open", (JSONObject) null);
        }
        if (!this.f11965g.m11916e(this.f11962d)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mp_lib", "Android");
                jSONObject.put("lib", "Android");
                jSONObject.put("distinct_id", str);
                this.f11960b.m11665a(new AnalyticsMessages.EventDescription("Integration", jSONObject, "85053bf24bba75239b16a601d9387e17", false));
                this.f11960b.m11666a(new AnalyticsMessages.FlushDescription("85053bf24bba75239b16a601d9387e17", false));
                this.f11965g.m11918f(this.f11962d);
            } catch (JSONException e2) {
            }
        }
        if (this.f11965g.m11920g((String) map.get("$android_app_version_code"))) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("$ae_updated_version", map.get("$android_app_version"));
                m11837a("$ae_updated", jSONObject2, true);
            } catch (JSONException e3) {
            }
        }
        this.f11964f.mo11854a();
        ExceptionHandler.m11716a();
    }

    /* JADX INFO: renamed from: a */
    public static MixpanelAPI m11814a(Context context, String str) {
        Map<Context, MixpanelAPI> map;
        MixpanelAPI mixpanelAPI = null;
        if (str != null && context != null) {
            synchronized (f11955n) {
                Context applicationContext = context.getApplicationContext();
                if (f11958q == null) {
                    f11958q = f11956o.m11930a(context, "com.mixpanel.android.mpmetrics.ReferralInfo", null);
                }
                Map<Context, MixpanelAPI> map2 = f11955n.get(str);
                if (map2 == null) {
                    HashMap map3 = new HashMap();
                    f11955n.put(str, map3);
                    map = map3;
                } else {
                    map = map2;
                }
                mixpanelAPI = map.get(applicationContext);
                if (mixpanelAPI == null && ConfigurationChecker.m11693a(applicationContext)) {
                    mixpanelAPI = new MixpanelAPI(applicationContext, f11958q, str);
                    m11817a(context, mixpanelAPI);
                    map.put(applicationContext, mixpanelAPI);
                }
                m11816a(context);
            }
        }
        return mixpanelAPI;
    }

    /* JADX INFO: renamed from: a */
    public void m11835a(String str, String str2) {
        if (str2 == null) {
            str2 = m11840b();
        }
        if (str.equals(str2)) {
            MPLog.m12028d("MixpanelAPI.API", "Attempted to alias identical distinct_ids " + str + ". Alias message will not be sent.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("alias", str);
            jSONObject.put("original", str2);
            m11836a("$create_alias", jSONObject);
        } catch (JSONException e) {
            MPLog.m12031e("MixpanelAPI.API", "Failed to alias", e);
        }
        m11832a();
    }

    /* JADX INFO: renamed from: a */
    public void m11834a(String str) {
        synchronized (this.f11965g) {
            this.f11965g.m11904a(str);
            String strM11910c = this.f11965g.m11910c();
            if (strM11910c == null) {
                strM11910c = this.f11965g.m11907b();
            }
            this.f11968j.m11709a(strM11910c);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11836a(String str, JSONObject jSONObject) {
        m11837a(str, jSONObject, false);
    }

    /* JADX INFO: renamed from: b */
    public void m11841b(String str) {
        m11836a(str, (JSONObject) null);
    }

    /* JADX INFO: renamed from: a */
    public void m11832a() {
        this.f11960b.m11666a(new AnalyticsMessages.FlushDescription(this.f11962d));
    }

    /* JADX INFO: renamed from: b */
    public String m11840b() {
        return this.f11965g.m11907b();
    }

    /* JADX INFO: renamed from: a */
    public void m11838a(JSONObject jSONObject) {
        this.f11965g.m11912c(jSONObject);
    }

    /* JADX INFO: renamed from: a */
    public void m11833a(SuperPropertyUpdate superPropertyUpdate) {
        this.f11965g.m11902a(superPropertyUpdate);
    }

    /* JADX INFO: renamed from: c */
    public People m11842c() {
        return this.f11963e;
    }

    /* JADX INFO: renamed from: d */
    public void m11843d() {
        this.f11965g.m11915e();
        m11834a(m11840b());
        m11832a();
    }

    /* JADX INFO: renamed from: e */
    public Map<String, String> m11844e() {
        return this.f11969k;
    }

    @TargetApi(14)
    /* JADX INFO: renamed from: f */
    void m11845f() {
        if (Build.VERSION.SDK_INT >= 14) {
            if (this.f11959a.getApplicationContext() instanceof Application) {
                Application application = (Application) this.f11959a.getApplicationContext();
                this.f11971m = new MixpanelActivityLifecycleCallbacks(this, this.f11961c);
                application.registerActivityLifecycleCallbacks(this.f11971m);
                return;
            }
            MPLog.m12026c("MixpanelAPI.API", "Context is not an Application, Mixpanel will not automatically show in-app notifications or A/B test experiments. We won't be able to automatically flush on an app background.");
        }
    }

    /* JADX INFO: renamed from: g */
    public boolean m11846g() {
        if (Build.VERSION.SDK_INT >= 14) {
            if (this.f11971m != null) {
                return this.f11971m.m11886a();
            }
        } else {
            MPLog.m12030e("MixpanelAPI.API", "Your build version is below 14. This method will always return false.");
        }
        return false;
    }

    /* JADX INFO: renamed from: h */
    void m11847h() {
        m11832a();
        this.f11964f.mo11856b();
    }

    /* JADX INFO: renamed from: a */
    static void m11818a(InstanceProcessor instanceProcessor) {
        synchronized (f11955n) {
            Iterator<Map<Context, MixpanelAPI>> it = f11955n.values().iterator();
            while (it.hasNext()) {
                Iterator<MixpanelAPI> it2 = it.next().values().iterator();
                while (it2.hasNext()) {
                    instanceProcessor.mo11692a(it2.next());
                }
            }
        }
    }

    /* JADX INFO: renamed from: i */
    AnalyticsMessages m11848i() {
        return AnalyticsMessages.m11659a(this.f11959a);
    }

    /* JADX INFO: renamed from: a */
    PersistentIdentity m11831a(Context context, Future<SharedPreferences> future, String str) {
        return new PersistentIdentity(future, f11956o.m11930a(context, "com.mixpanel.android.mpmetrics.MixpanelAPI_" + str, new SharedPreferencesLoader.OnPrefsLoadedListener() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.1
            @Override // com.mixpanel.android.mpmetrics.SharedPreferencesLoader.OnPrefsLoadedListener
            /* JADX INFO: renamed from: a */
            public void mo11853a(SharedPreferences sharedPreferences) {
                JSONArray jSONArrayM11889a = PersistentIdentity.m11889a(sharedPreferences);
                if (jSONArrayM11889a != null) {
                    MixpanelAPI.this.m11821a(jSONArrayM11889a);
                }
            }
        }), f11956o.m11930a(context, "com.mixpanel.android.mpmetrics.MixpanelAPI.TimeEvents_" + str, null), f11956o.m11930a(context, "com.mixpanel.android.mpmetrics.Mixpanel", null));
    }

    /* JADX INFO: renamed from: a */
    DecideMessages m11830a(String str, DecideMessages.OnNewResultsListener onNewResultsListener, UpdatesFromMixpanel updatesFromMixpanel) {
        return new DecideMessages(this.f11959a, str, onNewResultsListener, updatesFromMixpanel, this.f11965g.m11922i());
    }

    /* JADX INFO: renamed from: j */
    UpdatesListener m11849j() {
        if (Build.VERSION.SDK_INT >= 16) {
            return new SupportedUpdatesListener();
        }
        MPLog.m12026c("MixpanelAPI.API", "Notifications are not supported on this Android OS Version");
        return new UnsupportedUpdatesListener();
    }

    /* JADX INFO: renamed from: b */
    UpdatesFromMixpanel m11839b(Context context, String str) {
        if (Build.VERSION.SDK_INT < 16) {
            MPLog.m12026c("MixpanelAPI.API", "SDK version is lower than 16. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
            return new NoOpUpdatesFromMixpanel(f11957p);
        }
        if (this.f11961c.m11772h() || Arrays.asList(this.f11961c.m11773i()).contains(str)) {
            MPLog.m12026c("MixpanelAPI.API", "DisableViewCrawler is set to true. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
            return new NoOpUpdatesFromMixpanel(f11957p);
        }
        return new ViewCrawler(this.f11959a, this.f11962d, this, f11957p);
    }

    /* JADX INFO: renamed from: k */
    TrackingDebug m11850k() {
        if (this.f11964f instanceof ViewCrawler) {
            return (TrackingDebug) this.f11964f;
        }
        return null;
    }

    /* JADX INFO: renamed from: l */
    boolean m11851l() {
        return !this.f11961c.m11771g();
    }

    private class PeopleImpl implements People {
        private PeopleImpl() {
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: a */
        public void mo11862a(String str) {
            synchronized (MixpanelAPI.this.f11965g) {
                MixpanelAPI.this.f11965g.m11908b(str);
                MixpanelAPI.this.f11968j.m11709a(str);
            }
            MixpanelAPI.this.m11829n();
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: a */
        public void mo11867a(JSONObject jSONObject) {
            try {
                JSONObject jSONObject2 = new JSONObject(MixpanelAPI.this.f11969k);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
                MixpanelAPI.this.m11823b(m11873c("$set", jSONObject2));
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.API", "Exception setting people properties", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: a */
        public void mo11865a(String str, Object obj) {
            try {
                mo11867a(new JSONObject().put(str, obj));
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.API", "set", e);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m11876a(Map<String, ? extends Number> map) {
            try {
                MixpanelAPI.this.m11823b(m11873c("$add", new JSONObject(map)));
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.API", "Exception incrementing properties", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: a */
        public void mo11866a(String str, JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(str, jSONObject);
                MixpanelAPI.this.m11823b(m11873c("$merge", jSONObject2));
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.API", "Exception merging a property", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: a */
        public void mo11863a(String str, double d) {
            HashMap map = new HashMap();
            map.put(str, Double.valueOf(d));
            m11876a(map);
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: b */
        public void mo11870b(String str, Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, obj);
                MixpanelAPI.this.m11823b(m11873c("$append", jSONObject));
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.API", "Exception appending a property", e);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m11875a(String str, JSONArray jSONArray) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, jSONArray);
                MixpanelAPI.this.m11823b(m11873c("$union", jSONObject));
            } catch (JSONException e) {
                MPLog.m12030e("MixpanelAPI.API", "Exception unioning a property");
            }
        }

        /* JADX INFO: renamed from: c */
        public InAppNotification m11877c() {
            return MixpanelAPI.this.f11968j.m11706a(MixpanelAPI.this.f11961c.m11774j());
        }

        /* JADX INFO: renamed from: a */
        public void m11874a(InAppNotification inAppNotification) {
            if (inAppNotification != null) {
                MixpanelAPI.this.f11965g.m11903a(Integer.valueOf(inAppNotification.m11749b()));
                mo11864a("$campaign_delivery", inAppNotification, null);
                People peopleMo11871c = MixpanelAPI.this.m11842c().mo11871c(mo11878d());
                if (peopleMo11871c != null) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                    JSONObject jSONObjectM11747a = inAppNotification.m11747a();
                    try {
                        jSONObjectM11747a.put("$time", simpleDateFormat.format(new Date()));
                    } catch (JSONException e) {
                        MPLog.m12031e("MixpanelAPI.API", "Exception trying to track an in-app notification seen", e);
                    }
                    peopleMo11871c.mo11870b("$campaigns", Integer.valueOf(inAppNotification.m11749b()));
                    peopleMo11871c.mo11870b("$notifications", jSONObjectM11747a);
                    return;
                }
                MPLog.m12030e("MixpanelAPI.API", "No identity found. Make sure to call getPeople().identify() before showing in-app notifications.");
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: a */
        public void mo11861a(Activity activity) {
            if (Build.VERSION.SDK_INT >= 16) {
                m11872a((InAppNotification) null, activity);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: a */
        public void mo11864a(String str, InAppNotification inAppNotification, JSONObject jSONObject) {
            JSONObject jSONObjectM11747a = inAppNotification.m11747a();
            if (jSONObject != null) {
                try {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObjectM11747a.put(next, jSONObject.get(next));
                    }
                } catch (JSONException e) {
                    MPLog.m12031e("MixpanelAPI.API", "Exception merging provided properties with notification properties", e);
                }
            }
            MixpanelAPI.this.m11836a(str, jSONObjectM11747a);
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: b */
        public void mo11868b() {
            MixpanelAPI.this.f11964f.mo11858c(MixpanelAPI.this.f11968j.m11712c());
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: a */
        public void mo11860a(double d, JSONObject jSONObject) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("$amount", d);
                jSONObject2.put("$time", simpleDateFormat.format(date));
                if (jSONObject != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.put(next, jSONObject.get(next));
                    }
                }
                mo11870b("$transactions", jSONObject2);
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.API", "Exception creating new charge", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: b */
        public void mo11869b(String str) {
            synchronized (MixpanelAPI.this.f11965g) {
                if (MixpanelAPI.this.f11965g.m11910c() != null) {
                    MixpanelAPI.this.f11965g.m11911c(str);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    m11875a("$android_devices", jSONArray);
                }
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: a */
        public void mo11859a() {
            MixpanelAPI.this.f11965g.m11917f();
            mo11865a("$android_devices", (Object) new JSONArray());
        }

        /* JADX INFO: renamed from: d */
        public String mo11878d() {
            return MixpanelAPI.this.f11965g.m11910c();
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        /* JADX INFO: renamed from: c */
        public People mo11871c(final String str) {
            if (str == null) {
                return null;
            }
            return new PeopleImpl() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl
                /* JADX INFO: renamed from: d */
                public String mo11878d() {
                    return str;
                }

                @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl, com.mixpanel.android.mpmetrics.MixpanelAPI.People
                /* JADX INFO: renamed from: a */
                public void mo11862a(String str2) {
                    throw new RuntimeException("This MixpanelPeople object has a fixed, constant distinctId");
                }
            };
        }

        /* JADX INFO: renamed from: c */
        private JSONObject m11873c(String str, Object obj) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            String strMo11878d = mo11878d();
            jSONObject.put(str, obj);
            jSONObject.put("$token", MixpanelAPI.this.f11962d);
            jSONObject.put("$time", System.currentTimeMillis());
            if (strMo11878d != null) {
                jSONObject.put("$distinct_id", strMo11878d);
            }
            return jSONObject;
        }

        /* JADX INFO: renamed from: a */
        private void m11872a(final InAppNotification inAppNotification, final Activity activity) {
            if (Build.VERSION.SDK_INT < 16) {
                MPLog.m12021a("MixpanelAPI.API", "Will not show notifications, os version is too low.");
            } else {
                activity.runOnUiThread(new Runnable() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl.3
                    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0 A[Catch: all -> 0x0117, TRY_LEAVE, TryCatch #1 {all -> 0x0117, blocks: (B:3:0x0007, B:5:0x000d, B:8:0x0018, B:10:0x001c, B:12:0x0025, B:14:0x0030, B:16:0x0038, B:18:0x0044, B:20:0x004f, B:22:0x006e, B:24:0x0079, B:25:0x0081, B:26:0x0084, B:27:0x00a2, B:29:0x00b0, B:31:0x00ba, B:33:0x00c0, B:35:0x00cc, B:36:0x00ff, B:39:0x0104, B:44:0x011c), top: B:49:0x0007, inners: #0 }] */
                    @Override // java.lang.Runnable
                    @android.annotation.TargetApi(16)
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void run() {
                        /*
                            Method dump skipped, instruction units count: 338
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl.RunnableC14843.run():void");
                    }
                });
            }
        }
    }

    private class UnsupportedUpdatesListener implements UpdatesListener {
        private UnsupportedUpdatesListener() {
        }

        @Override // com.mixpanel.android.mpmetrics.DecideMessages.OnNewResultsListener
        /* JADX INFO: renamed from: a */
        public void mo11715a() {
        }
    }

    private class SupportedUpdatesListener implements UpdatesListener, Runnable {

        /* JADX INFO: renamed from: b */
        private final Set<OnMixpanelUpdatesReceivedListener> f11984b;

        /* JADX INFO: renamed from: c */
        private final Executor f11985c;

        private SupportedUpdatesListener() {
            this.f11984b = Collections.newSetFromMap(new ConcurrentHashMap());
            this.f11985c = Executors.newSingleThreadExecutor();
        }

        @Override // com.mixpanel.android.mpmetrics.DecideMessages.OnNewResultsListener
        /* JADX INFO: renamed from: a */
        public void mo11715a() {
            this.f11985c.execute(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<OnMixpanelUpdatesReceivedListener> it = this.f11984b.iterator();
            while (it.hasNext()) {
                it.next().m11888a();
            }
        }
    }

    class NoOpUpdatesFromMixpanel implements UpdatesFromMixpanel {

        /* JADX INFO: renamed from: b */
        private final Tweaks f11976b;

        public NoOpUpdatesFromMixpanel(Tweaks tweaks) {
            this.f11976b = tweaks;
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        /* JADX INFO: renamed from: a */
        public void mo11854a() {
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        /* JADX INFO: renamed from: a */
        public void mo11855a(JSONArray jSONArray) {
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        /* JADX INFO: renamed from: b */
        public void mo11856b() {
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        /* JADX INFO: renamed from: b */
        public void mo11857b(JSONArray jSONArray) {
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        /* JADX INFO: renamed from: c */
        public void mo11858c(JSONArray jSONArray) {
        }
    }

    /* JADX INFO: renamed from: m */
    protected void m11852m() {
        this.f11960b.m11666a(new AnalyticsMessages.FlushDescription(this.f11962d, false));
    }

    /* JADX INFO: renamed from: a */
    protected void m11837a(String str, JSONObject jSONObject, boolean z) {
        Long l;
        if (!z || this.f11968j.m11714e()) {
            synchronized (this.f11970l) {
                l = this.f11970l.get(str);
                this.f11970l.remove(str);
                this.f11965g.m11914d(str);
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : this.f11965g.m11901a().entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                this.f11965g.m11905a(jSONObject2);
                double dCurrentTimeMillis = System.currentTimeMillis() / 1000.0d;
                jSONObject2.put(SkillsJsonParser.TYPE_TIME, (long) dCurrentTimeMillis);
                jSONObject2.put("distinct_id", m11840b());
                if (l != null) {
                    jSONObject2.put("$duration", dCurrentTimeMillis - (l.longValue() / 1000.0d));
                }
                if (jSONObject != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.put(next, jSONObject.get(next));
                    }
                }
                this.f11960b.m11665a(new AnalyticsMessages.EventDescription(str, jSONObject2, this.f11962d, z));
                if (this.f11967i != null) {
                    this.f11967i.mo12098a(str);
                }
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.API", "Exception tracking event " + str, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m11823b(JSONObject jSONObject) {
        if (jSONObject.has("$distinct_id")) {
            this.f11960b.m11667a(new AnalyticsMessages.PeopleDescription(jSONObject, this.f11962d));
        } else {
            this.f11965g.m11909b(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n */
    public void m11829n() {
        JSONArray jSONArrayM11913d = this.f11965g.m11913d();
        if (jSONArrayM11913d != null) {
            m11821a(jSONArrayM11913d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11821a(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.f11960b.m11667a(new AnalyticsMessages.PeopleDescription(jSONArray.getJSONObject(i), this.f11962d));
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.API", "Malformed people record stored pending identity, will not send it.", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m11817a(Context context, MixpanelAPI mixpanelAPI) {
        try {
            Class<?> cls = Class.forName("android.support.v4.content.LocalBroadcastManager");
            cls.getMethod("registerReceiver", BroadcastReceiver.class, IntentFilter.class).invoke(cls.getMethod("getInstance", Context.class).invoke(null, context), new BroadcastReceiver() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    JSONObject jSONObject = new JSONObject();
                    Bundle bundleExtra = intent.getBundleExtra("event_args");
                    if (bundleExtra != null) {
                        for (String str : bundleExtra.keySet()) {
                            try {
                                jSONObject.put(str, bundleExtra.get(str));
                            } catch (JSONException e) {
                                MPLog.m12031e("MixpanelAPI.AL", "failed to add key \"" + str + "\" to properties for tracking bolts event", e);
                            }
                        }
                    }
                    MixpanelAPI.this.m11836a("$" + intent.getStringExtra("event_name"), jSONObject);
                }
            }, new IntentFilter("com.parse.bolts.measurement_event"));
        } catch (ClassNotFoundException e) {
            MPLog.m12023b("MixpanelAPI.AL", "To enable App Links tracking android.support.v4 must be installed: " + e.getMessage());
        } catch (IllegalAccessException e2) {
            MPLog.m12023b("MixpanelAPI.AL", "App Links tracking will not be enabled due to this exception: " + e2.getMessage());
        } catch (NoSuchMethodException e3) {
            MPLog.m12023b("MixpanelAPI.AL", "To enable App Links tracking android.support.v4 must be installed: " + e3.getMessage());
        } catch (InvocationTargetException e4) {
            MPLog.m12024b("MixpanelAPI.AL", "Failed to invoke LocalBroadcastManager.registerReceiver() -- App Links tracking will not be enabled due to this exception", e4);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m11816a(Context context) {
        if (context instanceof Activity) {
            try {
                Class.forName("bolts.AppLinks").getMethod("getTargetUrlFromInboundIntent", Context.class, Intent.class).invoke(null, context, ((Activity) context).getIntent());
                return;
            } catch (ClassNotFoundException e) {
                MPLog.m12023b("MixpanelAPI.AL", "Please install the Bolts library >= 1.1.2 to track App Links: " + e.getMessage());
                return;
            } catch (IllegalAccessException e2) {
                MPLog.m12023b("MixpanelAPI.AL", "Unable to detect inbound App Links: " + e2.getMessage());
                return;
            } catch (NoSuchMethodException e3) {
                MPLog.m12023b("MixpanelAPI.AL", "Please install the Bolts library >= 1.1.2 to track App Links: " + e3.getMessage());
                return;
            } catch (InvocationTargetException e4) {
                MPLog.m12024b("MixpanelAPI.AL", "Failed to invoke bolts.AppLinks.getTargetUrlFromInboundIntent() -- Unable to detect inbound App Links", e4);
                return;
            }
        }
        MPLog.m12023b("MixpanelAPI.AL", "Context is not an instance of Activity. To detect inbound App Links, pass an instance of an Activity to getInstance.");
    }
}
