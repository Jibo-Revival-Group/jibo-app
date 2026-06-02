package com.mixpanel.android.viewcrawler;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.JsonWriter;
import android.util.Pair;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.mixpanel.android.mpmetrics.MPConfig;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.OnMixpanelTweaksUpdatedListener;
import com.mixpanel.android.mpmetrics.ResourceReader;
import com.mixpanel.android.mpmetrics.SuperPropertyUpdate;
import com.mixpanel.android.mpmetrics.Tweaks;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.JSONUtils;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.EditProtocol;
import com.mixpanel.android.viewcrawler.EditorConnection;
import com.mixpanel.android.viewcrawler.FlipGesture;
import com.mixpanel.android.viewcrawler.ViewVisitor;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(16)
public class ViewCrawler implements TrackingDebug, UpdatesFromMixpanel, ViewVisitor.OnLayoutErrorListener {

    /* JADX INFO: renamed from: a */
    private final MPConfig f12159a;

    /* JADX INFO: renamed from: b */
    private final Context f12160b;

    /* JADX INFO: renamed from: c */
    private final MixpanelAPI f12161c;

    /* JADX INFO: renamed from: d */
    private final DynamicEventTracker f12162d;

    /* JADX INFO: renamed from: f */
    private final Tweaks f12164f;

    /* JADX INFO: renamed from: g */
    private final Map<String, String> f12165g;

    /* JADX INFO: renamed from: h */
    private final ViewCrawlerHandler f12166h;

    /* JADX INFO: renamed from: e */
    private final EditState f12163e = new EditState();

    /* JADX INFO: renamed from: i */
    private final float f12167i = Resources.getSystem().getDisplayMetrics().scaledDensity;

    /* JADX INFO: renamed from: j */
    private final Set<OnMixpanelTweaksUpdatedListener> f12168j = Collections.newSetFromMap(new ConcurrentHashMap());

    public ViewCrawler(Context context, String str, MixpanelAPI mixpanelAPI, Tweaks tweaks) {
        this.f12159a = MPConfig.m11762a(context);
        this.f12160b = context;
        this.f12164f = tweaks;
        this.f12165g = mixpanelAPI.m11844e();
        HandlerThread handlerThread = new HandlerThread(ViewCrawler.class.getCanonicalName());
        handlerThread.setPriority(10);
        handlerThread.start();
        this.f12166h = new ViewCrawlerHandler(context, str, handlerThread.getLooper(), this);
        this.f12162d = new DynamicEventTracker(mixpanelAPI, this.f12166h);
        this.f12161c = mixpanelAPI;
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new LifecycleCallbacks());
        this.f12164f.m11954a(new Tweaks.OnTweakDeclaredListener() { // from class: com.mixpanel.android.viewcrawler.ViewCrawler.1
            @Override // com.mixpanel.android.mpmetrics.Tweaks.OnTweakDeclaredListener
            /* JADX INFO: renamed from: a */
            public void mo11959a() {
                ViewCrawler.this.f12166h.sendMessage(ViewCrawler.this.f12166h.obtainMessage(4));
            }
        });
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    /* JADX INFO: renamed from: a */
    public void mo11854a() {
        this.f12166h.m12136a();
        mo11856b();
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    /* JADX INFO: renamed from: b */
    public void mo11856b() {
        this.f12166h.sendMessage(this.f12166h.obtainMessage(0));
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    /* JADX INFO: renamed from: a */
    public void mo11855a(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message messageObtainMessage = this.f12166h.obtainMessage(13);
            messageObtainMessage.obj = jSONArray;
            this.f12166h.sendMessage(messageObtainMessage);
        }
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    /* JADX INFO: renamed from: b */
    public void mo11857b(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message messageObtainMessage = this.f12166h.obtainMessage(5);
            messageObtainMessage.obj = jSONArray;
            this.f12166h.sendMessage(messageObtainMessage);
        }
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    /* JADX INFO: renamed from: c */
    public void mo11858c(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message messageObtainMessage = this.f12166h.obtainMessage(9);
            messageObtainMessage.obj = jSONArray;
            this.f12166h.sendMessage(messageObtainMessage);
        }
    }

    @Override // com.mixpanel.android.viewcrawler.TrackingDebug
    /* JADX INFO: renamed from: a */
    public void mo12098a(String str) {
        Message messageObtainMessage = this.f12166h.obtainMessage();
        messageObtainMessage.what = 7;
        messageObtainMessage.obj = str;
        this.f12166h.sendMessage(messageObtainMessage);
    }

    @Override // com.mixpanel.android.viewcrawler.ViewVisitor.OnLayoutErrorListener
    /* JADX INFO: renamed from: a */
    public void mo12110a(ViewVisitor.LayoutErrorMessage layoutErrorMessage) {
        Message messageObtainMessage = this.f12166h.obtainMessage();
        messageObtainMessage.what = 12;
        messageObtainMessage.obj = layoutErrorMessage;
        this.f12166h.sendMessage(messageObtainMessage);
    }

    private class EmulatorConnector implements Runnable {

        /* JADX INFO: renamed from: b */
        private volatile boolean f12172b = true;

        public EmulatorConnector() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f12172b) {
                ViewCrawler.this.f12166h.sendMessage(ViewCrawler.this.f12166h.obtainMessage(1));
            }
            ViewCrawler.this.f12166h.postDelayed(this, 30000L);
        }

        /* JADX INFO: renamed from: a */
        public void m12111a() {
            this.f12172b = false;
            ViewCrawler.this.f12166h.post(this);
        }

        /* JADX INFO: renamed from: b */
        public void m12112b() {
            this.f12172b = true;
            ViewCrawler.this.f12166h.removeCallbacks(this);
        }
    }

    private class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks, FlipGesture.OnFlipGestureListener {

        /* JADX INFO: renamed from: b */
        private final FlipGesture f12174b = new FlipGesture(this);

        /* JADX INFO: renamed from: c */
        private final EmulatorConnector f12175c;

        public LifecycleCallbacks() {
            this.f12175c = ViewCrawler.this.new EmulatorConnector();
        }

        @Override // com.mixpanel.android.viewcrawler.FlipGesture.OnFlipGestureListener
        /* JADX INFO: renamed from: a */
        public void mo12082a() {
            ViewCrawler.this.f12161c.m11841b("$ab_gesture3");
            ViewCrawler.this.f12166h.sendMessage(ViewCrawler.this.f12166h.obtainMessage(1));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            m12113a(activity);
            ViewCrawler.this.f12163e.mo12064b(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            ViewCrawler.this.f12163e.mo12062a(activity);
            m12114b(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        /* JADX INFO: renamed from: a */
        private void m12113a(Activity activity) {
            if (!m12115b() || ViewCrawler.this.f12159a.m11770f()) {
                if (!ViewCrawler.this.f12159a.m11769e()) {
                    SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
                    sensorManager.registerListener(this.f12174b, sensorManager.getDefaultSensor(1), 3);
                    return;
                }
                return;
            }
            this.f12175c.m12111a();
        }

        /* JADX INFO: renamed from: b */
        private void m12114b(Activity activity) {
            if (!m12115b() || ViewCrawler.this.f12159a.m11770f()) {
                if (!ViewCrawler.this.f12159a.m11769e()) {
                    ((SensorManager) activity.getSystemService("sensor")).unregisterListener(this.f12174b);
                    return;
                }
                return;
            }
            this.f12175c.m12112b();
        }

        /* JADX INFO: renamed from: b */
        private boolean m12115b() {
            if (Build.HARDWARE.toLowerCase().equals("goldfish") || Build.HARDWARE.toLowerCase().equals("ranchu")) {
                return (Build.BRAND.toLowerCase().startsWith("generic") || Build.BRAND.toLowerCase().equals("android") || Build.BRAND.toLowerCase().equals("google")) && Build.DEVICE.toLowerCase().startsWith("generic") && Build.PRODUCT.toLowerCase().contains(ServerProtocol.DIALOG_PARAM_SDK_VERSION) && Build.MODEL.toLowerCase(Locale.US).contains(ServerProtocol.DIALOG_PARAM_SDK_VERSION);
            }
            return false;
        }
    }

    private class ViewCrawlerHandler extends Handler {

        /* JADX INFO: renamed from: b */
        private EditorConnection f12184b;

        /* JADX INFO: renamed from: c */
        private ViewSnapshot f12185c;

        /* JADX INFO: renamed from: d */
        private final String f12186d;

        /* JADX INFO: renamed from: e */
        private final Lock f12187e;

        /* JADX INFO: renamed from: f */
        private final EditProtocol f12188f;

        /* JADX INFO: renamed from: g */
        private final ImageStore f12189g;

        /* JADX INFO: renamed from: h */
        private final Map<String, Pair<String, JSONObject>> f12190h;

        /* JADX INFO: renamed from: i */
        private final List<JSONObject> f12191i;

        /* JADX INFO: renamed from: j */
        private final List<String> f12192j;

        /* JADX INFO: renamed from: k */
        private final Map<String, Pair<String, JSONObject>> f12193k;

        /* JADX INFO: renamed from: l */
        private final Set<VariantChange> f12194l;

        /* JADX INFO: renamed from: m */
        private final Set<VariantTweak> f12195m;

        /* JADX INFO: renamed from: n */
        private final Set<Pair<Integer, Integer>> f12196n;

        /* JADX INFO: renamed from: o */
        private final Set<Pair<String, JSONObject>> f12197o;

        /* JADX INFO: renamed from: p */
        private final Set<Pair<String, JSONObject>> f12198p;

        /* JADX INFO: renamed from: q */
        private final Set<Pair<Integer, Integer>> f12199q;

        public ViewCrawlerHandler(Context context, String str, Looper looper, ViewVisitor.OnLayoutErrorListener onLayoutErrorListener) {
            super(looper);
            this.f12186d = str;
            this.f12185c = null;
            String strM11788x = ViewCrawler.this.f12159a.m11788x();
            ResourceReader.Ids ids = new ResourceReader.Ids(strM11788x == null ? context.getPackageName() : strM11788x, context);
            this.f12189g = new ImageStore(context, "ViewCrawler");
            this.f12188f = new EditProtocol(context, ids, this.f12189g, onLayoutErrorListener);
            this.f12198p = new HashSet();
            this.f12190h = new HashMap();
            this.f12191i = new ArrayList();
            this.f12192j = new ArrayList();
            this.f12193k = new HashMap();
            this.f12194l = new HashSet();
            this.f12195m = new HashSet();
            this.f12196n = new HashSet();
            this.f12197o = new HashSet();
            this.f12199q = new HashSet();
            this.f12187e = new ReentrantLock();
            this.f12187e.lock();
        }

        /* JADX INFO: renamed from: a */
        public void m12136a() {
            this.f12187e.unlock();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f12187e.lock();
            try {
                switch (message.what) {
                    case 0:
                        m12122b();
                        break;
                    case 1:
                        m12126c();
                        break;
                    case 2:
                        m12121a((JSONObject) message.obj);
                        break;
                    case 3:
                        m12125b((JSONObject) message.obj);
                        break;
                    case 4:
                        m12130d();
                        break;
                    case 5:
                        m12128c((JSONArray) message.obj);
                        break;
                    case 6:
                        m12133e((JSONObject) message.obj);
                        break;
                    case 7:
                        m12127c((String) message.obj);
                        break;
                    case 8:
                        m12132e();
                        break;
                    case 9:
                        m12124b((JSONArray) message.obj);
                        break;
                    case 10:
                        m12129c((JSONObject) message.obj);
                        break;
                    case 11:
                        m12131d((JSONObject) message.obj);
                        break;
                    case 12:
                        m12116a((ViewVisitor.LayoutErrorMessage) message.obj);
                        break;
                    case 13:
                        m12120a((JSONArray) message.obj);
                        break;
                }
            } finally {
                this.f12187e.unlock();
            }
        }

        /* JADX INFO: renamed from: b */
        private void m12122b() {
            SharedPreferences sharedPreferencesM12135g = m12135g();
            String string = sharedPreferencesM12135g.getString("mixpanel.viewcrawler.changes", null);
            String string2 = sharedPreferencesM12135g.getString("mixpanel.viewcrawler.bindings", null);
            this.f12194l.clear();
            this.f12195m.clear();
            this.f12199q.clear();
            m12118a(string, false);
            this.f12197o.clear();
            m12117a(string2);
            m12134f();
        }

        /* JADX INFO: renamed from: a */
        private void m12120a(JSONArray jSONArray) {
            SharedPreferences.Editor editorEdit = m12135g().edit();
            editorEdit.putString("mixpanel.viewcrawler.changes", jSONArray.toString());
            editorEdit.apply();
        }

        /* JADX INFO: renamed from: a */
        private void m12118a(String str, boolean z) {
            if (str != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(jSONObject.getInt("experiment_id")), Integer.valueOf(jSONObject.getInt(ShareConstants.WEB_DIALOG_PARAM_ID)));
                        JSONArray jSONArray2 = jSONObject.getJSONArray("actions");
                        int length2 = jSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                            this.f12194l.add(new VariantChange(jSONObject2.getString("name"), JSONUtils.m12019a(jSONObject2, "target_activity"), jSONObject2, pair));
                        }
                        JSONArray jSONArray3 = jSONObject.getJSONArray("tweaks");
                        int length3 = jSONArray3.length();
                        for (int i3 = 0; i3 < length3; i3++) {
                            JSONObject jSONObject3 = jSONArray3.getJSONObject(i3);
                            this.f12195m.add(new VariantTweak(jSONObject3.getString("name"), jSONObject3, pair));
                        }
                        if (!z) {
                            this.f12199q.add(pair);
                        }
                        if (length3 == 0 && length2 == 0) {
                            this.f12196n.add(pair);
                        }
                    }
                } catch (JSONException e) {
                    MPLog.m12027c("MixpanelAPI.ViewCrawler", "JSON error when loading ab tests / tweaks, clearing persistent memory", e);
                    SharedPreferences.Editor editorEdit = m12135g().edit();
                    editorEdit.remove("mixpanel.viewcrawler.changes");
                    editorEdit.apply();
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m12117a(String str) {
            if (str != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    this.f12197o.clear();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        this.f12197o.add(new Pair<>(JSONUtils.m12019a(jSONObject, "target_activity"), jSONObject));
                    }
                } catch (JSONException e) {
                    MPLog.m12027c("MixpanelAPI.ViewCrawler", "JSON error when loading event bindings, clearing persistent memory", e);
                    SharedPreferences.Editor editorEdit = m12135g().edit();
                    editorEdit.remove("mixpanel.viewcrawler.bindings");
                    editorEdit.apply();
                }
            }
        }

        /* JADX INFO: renamed from: c */
        private void m12126c() {
            MPLog.m12021a("MixpanelAPI.ViewCrawler", "connecting to editor");
            if (this.f12184b == null || !this.f12184b.m12071a()) {
                SSLSocketFactory sSLSocketFactoryM11789y = ViewCrawler.this.f12159a.m11789y();
                if (sSLSocketFactoryM11789y != null) {
                    String str = MPConfig.m11762a(ViewCrawler.this.f12160b).m11779o() + this.f12186d;
                    try {
                        this.f12184b = new EditorConnection(new URI(str), new Editor(), sSLSocketFactoryM11789y.createSocket());
                        return;
                    } catch (EditorConnection.EditorConnectionException e) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Error connecting to URI " + str, e);
                        return;
                    } catch (IOException e2) {
                        MPLog.m12027c("MixpanelAPI.ViewCrawler", "Can't create SSL Socket to connect to editor service", e2);
                        return;
                    } catch (URISyntaxException e3) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Error parsing URI " + str + " for editor websocket", e3);
                        return;
                    }
                }
                MPLog.m12021a("MixpanelAPI.ViewCrawler", "SSL is not available on this device, no connection will be attempted to the events editor.");
                return;
            }
            MPLog.m12021a("MixpanelAPI.ViewCrawler", "There is already a valid connection to an events editor.");
        }

        /* JADX INFO: renamed from: b */
        private void m12123b(String str) {
            if (this.f12184b != null && this.f12184b.m12071a() && this.f12184b.m12072b()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str);
                } catch (JSONException e) {
                    MPLog.m12031e("MixpanelAPI.ViewCrawler", "Apparently impossible JSONException", e);
                }
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f12184b.m12073c());
                try {
                    try {
                        outputStreamWriter.write("{\"type\": \"error\", ");
                        outputStreamWriter.write("\"payload\": ");
                        outputStreamWriter.write(jSONObject.toString());
                        outputStreamWriter.write("}");
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e2) {
                            MPLog.m12031e("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", e2);
                        }
                    } catch (IOException e3) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't write error message to editor", e3);
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e4) {
                            MPLog.m12031e("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", e4);
                        }
                    }
                } catch (Throwable th) {
                    try {
                        outputStreamWriter.close();
                    } catch (IOException e5) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", e5);
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: d */
        private void m12130d() {
            if (this.f12184b != null && this.f12184b.m12071a() && this.f12184b.m12072b()) {
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(this.f12184b.m12073c()));
                try {
                    try {
                        jsonWriter.beginObject();
                        jsonWriter.name(ShareConstants.MEDIA_TYPE).value("device_info_response");
                        jsonWriter.name("payload").beginObject();
                        jsonWriter.name("device_type").value("Android");
                        jsonWriter.name("device_name").value(Build.BRAND + "/" + Build.MODEL);
                        jsonWriter.name("scaled_density").value(ViewCrawler.this.f12167i);
                        for (Map.Entry entry : ViewCrawler.this.f12165g.entrySet()) {
                            jsonWriter.name((String) entry.getKey()).value((String) entry.getValue());
                        }
                        Map<String, Tweaks.TweakValue> mapM11953a = ViewCrawler.this.f12164f.m11953a();
                        jsonWriter.name("tweaks").beginArray();
                        for (Map.Entry<String, Tweaks.TweakValue> entry2 : mapM11953a.entrySet()) {
                            Tweaks.TweakValue value = entry2.getValue();
                            String key = entry2.getKey();
                            jsonWriter.beginObject();
                            jsonWriter.name("name").value(key);
                            jsonWriter.name("minimum").value(value.m11967d());
                            jsonWriter.name("maximum").value(value.m11968e());
                            switch (value.f12037a) {
                                case 1:
                                    jsonWriter.name(ShareConstants.MEDIA_TYPE).value("boolean");
                                    jsonWriter.name("value").value(value.m11966c().booleanValue());
                                    jsonWriter.name("default").value(((Boolean) value.m11969f()).booleanValue());
                                    break;
                                case 2:
                                    jsonWriter.name(ShareConstants.MEDIA_TYPE).value("number");
                                    jsonWriter.name("encoding").value("d");
                                    jsonWriter.name("value").value(value.m11965b().doubleValue());
                                    jsonWriter.name("default").value(((Number) value.m11969f()).doubleValue());
                                    break;
                                case 3:
                                    jsonWriter.name(ShareConstants.MEDIA_TYPE).value("number");
                                    jsonWriter.name("encoding").value("l");
                                    jsonWriter.name("value").value(value.m11965b().longValue());
                                    jsonWriter.name("default").value(((Number) value.m11969f()).longValue());
                                    break;
                                case 4:
                                    jsonWriter.name(ShareConstants.MEDIA_TYPE).value("string");
                                    jsonWriter.name("value").value(value.m11964a());
                                    jsonWriter.name("default").value((String) value.m11969f());
                                    break;
                                default:
                                    MPLog.m12032f("MixpanelAPI.ViewCrawler", "Unrecognized Tweak Type " + value.f12037a + " encountered.");
                                    break;
                            }
                            jsonWriter.endObject();
                        }
                        jsonWriter.endArray();
                        jsonWriter.endObject();
                        jsonWriter.endObject();
                        try {
                            jsonWriter.close();
                        } catch (IOException e) {
                            MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't close websocket writer", e);
                        }
                    } catch (IOException e2) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't write device_info to server", e2);
                        try {
                            jsonWriter.close();
                        } catch (IOException e3) {
                            MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't close websocket writer", e3);
                        }
                    }
                } catch (Throwable th) {
                    try {
                        jsonWriter.close();
                    } catch (IOException e4) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't close websocket writer", e4);
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m12121a(JSONObject jSONObject) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("payload");
                if (jSONObject2.has("config")) {
                    this.f12185c = this.f12188f.m12056b(jSONObject2);
                    MPLog.m12021a("MixpanelAPI.ViewCrawler", "Initializing snapshot with configuration");
                }
                if (this.f12185c == null) {
                    m12123b("No snapshot configuration (or a malformed snapshot configuration) was sent.");
                    MPLog.m12028d("MixpanelAPI.ViewCrawler", "Mixpanel editor is misconfigured, sent a snapshot request without a valid configuration.");
                    return;
                }
                BufferedOutputStream bufferedOutputStreamM12073c = this.f12184b.m12073c();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStreamM12073c);
                try {
                    try {
                        outputStreamWriter.write("{");
                        outputStreamWriter.write("\"type\": \"snapshot_response\",");
                        outputStreamWriter.write("\"payload\": {");
                        outputStreamWriter.write("\"activities\":");
                        outputStreamWriter.flush();
                        this.f12185c.m12140a(ViewCrawler.this.f12163e, bufferedOutputStreamM12073c);
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        outputStreamWriter.write(",\"snapshot_time_millis\": ");
                        outputStreamWriter.write(Long.toString(jCurrentTimeMillis2));
                        outputStreamWriter.write("}");
                        outputStreamWriter.write("}");
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e) {
                            MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't close writer.", e);
                        }
                    } catch (IOException e2) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't write snapshot request to server", e2);
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e3) {
                            MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't close writer.", e3);
                        }
                    }
                } catch (Throwable th) {
                    try {
                        outputStreamWriter.close();
                    } catch (IOException e4) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't close writer.", e4);
                    }
                    throw th;
                }
            } catch (EditProtocol.BadInstructionsException e5) {
                MPLog.m12031e("MixpanelAPI.ViewCrawler", "Editor sent malformed message with snapshot request", e5);
                m12123b(e5.getMessage());
            } catch (JSONException e6) {
                MPLog.m12031e("MixpanelAPI.ViewCrawler", "Payload with snapshot config required with snapshot request", e6);
                m12123b("Payload with snapshot config required with snapshot request");
            }
        }

        /* JADX INFO: renamed from: c */
        private void m12127c(String str) {
            if (this.f12184b != null && this.f12184b.m12071a() && this.f12184b.m12072b()) {
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(this.f12184b.m12073c()));
                try {
                    try {
                        jsonWriter.beginObject();
                        jsonWriter.name(ShareConstants.MEDIA_TYPE).value("track_message");
                        jsonWriter.name("payload");
                        jsonWriter.beginObject();
                        jsonWriter.name("event_name").value(str);
                        jsonWriter.endObject();
                        jsonWriter.endObject();
                        jsonWriter.flush();
                        try {
                            jsonWriter.close();
                        } catch (IOException e) {
                            MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't close writer.", e);
                        }
                    } catch (IOException e2) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't write track_message to server", e2);
                        try {
                            jsonWriter.close();
                        } catch (IOException e3) {
                            MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't close writer.", e3);
                        }
                    }
                } catch (Throwable th) {
                    try {
                        jsonWriter.close();
                    } catch (IOException e4) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't close writer.", e4);
                    }
                    throw th;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        private void m12116a(ViewVisitor.LayoutErrorMessage layoutErrorMessage) {
            if (this.f12184b != null && this.f12184b.m12071a() && this.f12184b.m12072b()) {
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(this.f12184b.m12073c()));
                try {
                    try {
                        jsonWriter.beginObject();
                        jsonWriter.name(ShareConstants.MEDIA_TYPE).value("layout_error");
                        jsonWriter.name("exception_type").value(layoutErrorMessage.m12160a());
                        jsonWriter.name("cid").value(layoutErrorMessage.m12161b());
                        jsonWriter.endObject();
                    } finally {
                        try {
                            jsonWriter.close();
                        } catch (IOException e) {
                            MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't close writer.", e);
                        }
                    }
                } catch (IOException e2) {
                    MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't write track_message to server", e2);
                    try {
                        jsonWriter.close();
                        jsonWriter = jsonWriter;
                    } catch (IOException e3) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Can't close writer.", e3);
                        jsonWriter = "Can't close writer.";
                    }
                }
            }
        }

        /* JADX INFO: renamed from: b */
        private void m12125b(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("actions");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String strM12019a = JSONUtils.m12019a(jSONObject2, "target_activity");
                    this.f12190h.put(jSONObject2.getString("name"), new Pair<>(strM12019a, jSONObject2));
                }
                m12134f();
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.ViewCrawler", "Bad change request received", e);
            }
        }

        /* JADX INFO: renamed from: c */
        private void m12129c(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("actions");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f12190h.remove(jSONArray.getString(i));
                }
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.ViewCrawler", "Bad clear request received", e);
            }
            m12134f();
        }

        /* JADX INFO: renamed from: d */
        private void m12131d(JSONObject jSONObject) {
            try {
                this.f12191i.clear();
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("tweaks");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.f12191i.add(jSONArray.getJSONObject(i));
                }
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.ViewCrawler", "Bad tweaks received", e);
            }
            m12134f();
        }

        /* JADX INFO: renamed from: b */
        private void m12124b(JSONArray jSONArray) {
            m12120a(jSONArray);
            m12118a(jSONArray.toString(), true);
            m12134f();
        }

        /* JADX INFO: renamed from: c */
        private void m12128c(JSONArray jSONArray) {
            SharedPreferences.Editor editorEdit = m12135g().edit();
            editorEdit.putString("mixpanel.viewcrawler.bindings", jSONArray.toString());
            editorEdit.apply();
            m12117a(jSONArray.toString());
            m12134f();
        }

        /* JADX INFO: renamed from: e */
        private void m12133e(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONObject("payload").getJSONArray("events");
                int length = jSONArray.length();
                this.f12193k.clear();
                if (!this.f12197o.isEmpty() && this.f12198p.isEmpty()) {
                    this.f12198p.addAll(this.f12197o);
                    for (Pair<String, JSONObject> pair : this.f12197o) {
                        try {
                            this.f12193k.put(((JSONObject) pair.second).get("path").toString(), pair);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    this.f12197o.clear();
                }
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        this.f12193k.put(jSONObject2.get("path").toString(), new Pair<>(JSONUtils.m12019a(jSONObject2, "target_activity"), jSONObject2));
                    } catch (JSONException e2) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Bad event binding received from editor in " + jSONArray.toString(), e2);
                    }
                }
                m12134f();
            } catch (JSONException e3) {
                MPLog.m12031e("MixpanelAPI.ViewCrawler", "Bad event bindings received", e3);
            }
        }

        /* JADX INFO: renamed from: e */
        private void m12132e() {
            this.f12190h.clear();
            this.f12193k.clear();
            this.f12191i.clear();
            this.f12197o.addAll(this.f12198p);
            this.f12198p.clear();
            this.f12185c = null;
            MPLog.m12021a("MixpanelAPI.ViewCrawler", "Editor closed- freeing snapshot");
            m12134f();
            Iterator<String> it = this.f12192j.iterator();
            while (it.hasNext()) {
                this.f12189g.m12017c(it.next());
            }
        }

        /* JADX INFO: renamed from: f */
        private void m12134f() {
            List arrayList;
            Tweaks.TweakValue tweakValueM11960a;
            ArrayList arrayList2 = new ArrayList();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (VariantChange variantChange : this.f12194l) {
                try {
                    arrayList2.add(new Pair(variantChange.f12177b, this.f12188f.m12053a(variantChange.f12178c).f12112a));
                    if (!this.f12199q.contains(variantChange.f12179d)) {
                        hashSet.add(variantChange.f12179d);
                    }
                } catch (EditProtocol.InapplicableInstructionsException e) {
                    MPLog.m12026c("MixpanelAPI.ViewCrawler", e.getMessage());
                } catch (EditProtocol.BadInstructionsException e2) {
                    MPLog.m12031e("MixpanelAPI.ViewCrawler", "Bad persistent change request cannot be applied.", e2);
                } catch (EditProtocol.CantGetEditAssetsException e3) {
                    MPLog.m12022a("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", e3);
                }
            }
            for (VariantTweak variantTweak : this.f12195m) {
                try {
                    Pair<String, Object> pairM12057c = this.f12188f.m12057c(variantTweak.f12181b);
                    if (this.f12199q.contains(variantTweak.f12182c)) {
                        if (ViewCrawler.this.f12164f.m11958b((String) pairM12057c.first, pairM12057c.second)) {
                            hashSet2.add(pairM12057c.first);
                        }
                    } else {
                        hashSet.add(variantTweak.f12182c);
                        hashSet2.add(pairM12057c.first);
                    }
                    if (!ViewCrawler.this.f12164f.m11953a().containsKey(pairM12057c.first) && (tweakValueM11960a = Tweaks.TweakValue.m11960a(variantTweak.f12181b)) != null) {
                        ViewCrawler.this.f12164f.m11956a((String) pairM12057c.first, tweakValueM11960a.m11969f(), tweakValueM11960a.m11967d(), tweakValueM11960a.m11968e(), tweakValueM11960a.f12037a);
                    }
                    ViewCrawler.this.f12164f.m11955a((String) pairM12057c.first, pairM12057c.second);
                } catch (EditProtocol.BadInstructionsException e4) {
                    MPLog.m12031e("MixpanelAPI.ViewCrawler", "Bad editor tweak cannot be applied.", e4);
                }
            }
            if (this.f12195m.size() == 0) {
                for (Map.Entry<String, Tweaks.TweakValue> entry : ViewCrawler.this.f12164f.m11957b().entrySet()) {
                    Tweaks.TweakValue value = entry.getValue();
                    String key = entry.getKey();
                    if (ViewCrawler.this.f12164f.m11958b(key, value.m11970g())) {
                        ViewCrawler.this.f12164f.m11955a(key, value.m11970g());
                        hashSet2.add(key);
                    }
                }
            }
            for (Pair<String, JSONObject> pair : this.f12190h.values()) {
                try {
                    EditProtocol.Edit editM12053a = this.f12188f.m12053a((JSONObject) pair.second);
                    arrayList2.add(new Pair(pair.first, editM12053a.f12112a));
                    this.f12192j.addAll(editM12053a.f12113b);
                } catch (EditProtocol.BadInstructionsException e5) {
                    MPLog.m12031e("MixpanelAPI.ViewCrawler", "Bad editor change request cannot be applied.", e5);
                } catch (EditProtocol.CantGetEditAssetsException e6) {
                    MPLog.m12022a("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", e6);
                } catch (EditProtocol.InapplicableInstructionsException e7) {
                    MPLog.m12026c("MixpanelAPI.ViewCrawler", e7.getMessage());
                }
            }
            int size = this.f12191i.size();
            for (int i = 0; i < size; i++) {
                try {
                    Pair<String, Object> pairM12057c2 = this.f12188f.m12057c(this.f12191i.get(i));
                    if (ViewCrawler.this.f12164f.m11958b((String) pairM12057c2.first, pairM12057c2.second)) {
                        hashSet2.add(pairM12057c2.first);
                    }
                    ViewCrawler.this.f12164f.m11955a((String) pairM12057c2.first, pairM12057c2.second);
                } catch (EditProtocol.BadInstructionsException e8) {
                    MPLog.m12031e("MixpanelAPI.ViewCrawler", "Strange tweaks received", e8);
                }
            }
            if (this.f12193k.size() == 0 && this.f12198p.size() == 0) {
                for (Pair<String, JSONObject> pair2 : this.f12197o) {
                    try {
                        arrayList2.add(new Pair(pair2.first, this.f12188f.m12054a((JSONObject) pair2.second, ViewCrawler.this.f12162d)));
                    } catch (EditProtocol.InapplicableInstructionsException e9) {
                        MPLog.m12026c("MixpanelAPI.ViewCrawler", e9.getMessage());
                    } catch (EditProtocol.BadInstructionsException e10) {
                        MPLog.m12031e("MixpanelAPI.ViewCrawler", "Bad persistent event binding cannot be applied.", e10);
                    }
                }
            }
            for (Pair<String, JSONObject> pair3 : this.f12193k.values()) {
                try {
                    arrayList2.add(new Pair(pair3.first, this.f12188f.m12054a((JSONObject) pair3.second, ViewCrawler.this.f12162d)));
                } catch (EditProtocol.InapplicableInstructionsException e11) {
                    MPLog.m12026c("MixpanelAPI.ViewCrawler", e11.getMessage());
                } catch (EditProtocol.BadInstructionsException e12) {
                    MPLog.m12031e("MixpanelAPI.ViewCrawler", "Bad editor event binding cannot be applied.", e12);
                }
            }
            HashMap map = new HashMap();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Pair pair4 = (Pair) arrayList2.get(i2);
                if (map.containsKey(pair4.first)) {
                    arrayList = (List) map.get(pair4.first);
                } else {
                    arrayList = new ArrayList();
                    map.put(pair4.first, arrayList);
                }
                arrayList.add(pair4.second);
            }
            ViewCrawler.this.f12163e.m12063a((Map<String, List<ViewVisitor>>) map);
            this.f12199q.addAll(hashSet);
            hashSet.addAll(this.f12196n);
            m12119a(hashSet);
            this.f12196n.clear();
            if (hashSet2.size() > 0) {
                Iterator it = ViewCrawler.this.f12168j.iterator();
                while (it.hasNext()) {
                    ((OnMixpanelTweaksUpdatedListener) it.next()).m11887a(hashSet2);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m12119a(Set<Pair<Integer, Integer>> set) {
            if (set != null && set.size() > 0) {
                final JSONObject jSONObject = new JSONObject();
                try {
                    for (Pair<Integer, Integer> pair : set) {
                        int iIntValue = ((Integer) pair.first).intValue();
                        int iIntValue2 = ((Integer) pair.second).intValue();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("$experiment_id", iIntValue);
                        jSONObject2.put("$variant_id", iIntValue2);
                        jSONObject.put(Integer.toString(iIntValue), iIntValue2);
                        ViewCrawler.this.f12161c.m11842c().mo11866a("$experiments", jSONObject);
                        ViewCrawler.this.f12161c.m11833a(new SuperPropertyUpdate() { // from class: com.mixpanel.android.viewcrawler.ViewCrawler.ViewCrawlerHandler.1
                            @Override // com.mixpanel.android.mpmetrics.SuperPropertyUpdate
                            /* JADX INFO: renamed from: a */
                            public JSONObject mo11932a(JSONObject jSONObject3) {
                                try {
                                    jSONObject3.put("$experiments", jSONObject);
                                } catch (JSONException e) {
                                    MPLog.m12033f("MixpanelAPI.ViewCrawler", "Can't write $experiments super property", e);
                                }
                                return jSONObject3;
                            }
                        });
                        ViewCrawler.this.f12161c.m11836a("$experiment_started", jSONObject2);
                    }
                } catch (JSONException e) {
                    MPLog.m12033f("MixpanelAPI.ViewCrawler", "Could not build JSON for reporting experiment start", e);
                }
            }
        }

        /* JADX INFO: renamed from: g */
        private SharedPreferences m12135g() {
            return ViewCrawler.this.f12160b.getSharedPreferences("mixpanel.viewcrawler.changes" + this.f12186d, 0);
        }
    }

    private class Editor implements EditorConnection.Editor {
        private Editor() {
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        /* JADX INFO: renamed from: a */
        public void mo12075a(JSONObject jSONObject) {
            Message messageObtainMessage = ViewCrawler.this.f12166h.obtainMessage(2);
            messageObtainMessage.obj = jSONObject;
            ViewCrawler.this.f12166h.sendMessage(messageObtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        /* JADX INFO: renamed from: b */
        public void mo12077b(JSONObject jSONObject) {
            Message messageObtainMessage = ViewCrawler.this.f12166h.obtainMessage(3);
            messageObtainMessage.obj = jSONObject;
            ViewCrawler.this.f12166h.sendMessage(messageObtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        /* JADX INFO: renamed from: c */
        public void mo12078c(JSONObject jSONObject) {
            Message messageObtainMessage = ViewCrawler.this.f12166h.obtainMessage(10);
            messageObtainMessage.obj = jSONObject;
            ViewCrawler.this.f12166h.sendMessage(messageObtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        /* JADX INFO: renamed from: e */
        public void mo12080e(JSONObject jSONObject) {
            Message messageObtainMessage = ViewCrawler.this.f12166h.obtainMessage(11);
            messageObtainMessage.obj = jSONObject;
            ViewCrawler.this.f12166h.sendMessage(messageObtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        /* JADX INFO: renamed from: d */
        public void mo12079d(JSONObject jSONObject) {
            Message messageObtainMessage = ViewCrawler.this.f12166h.obtainMessage(6);
            messageObtainMessage.obj = jSONObject;
            ViewCrawler.this.f12166h.sendMessage(messageObtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        /* JADX INFO: renamed from: a */
        public void mo12074a() {
            ViewCrawler.this.f12166h.sendMessage(ViewCrawler.this.f12166h.obtainMessage(4));
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        /* JADX INFO: renamed from: b */
        public void mo12076b() {
            ViewCrawler.this.f12166h.sendMessage(ViewCrawler.this.f12166h.obtainMessage(8));
        }
    }

    private static class VariantChange {

        /* JADX INFO: renamed from: a */
        public final String f12176a;

        /* JADX INFO: renamed from: b */
        public final String f12177b;

        /* JADX INFO: renamed from: c */
        public final JSONObject f12178c;

        /* JADX INFO: renamed from: d */
        public final Pair<Integer, Integer> f12179d;

        public VariantChange(String str, String str2, JSONObject jSONObject, Pair<Integer, Integer> pair) {
            this.f12176a = str;
            this.f12177b = str2;
            this.f12178c = jSONObject;
            this.f12179d = pair;
        }

        public int hashCode() {
            return this.f12176a.hashCode();
        }

        public boolean equals(Object obj) {
            return (obj instanceof VariantChange) && obj.hashCode() == hashCode();
        }
    }

    private static class VariantTweak {

        /* JADX INFO: renamed from: a */
        public final String f12180a;

        /* JADX INFO: renamed from: b */
        public final JSONObject f12181b;

        /* JADX INFO: renamed from: c */
        public final Pair<Integer, Integer> f12182c;

        public VariantTweak(String str, JSONObject jSONObject, Pair<Integer, Integer> pair) {
            this.f12180a = str;
            this.f12181b = jSONObject;
            this.f12182c = pair;
        }

        public int hashCode() {
            return this.f12180a.hashCode();
        }

        public boolean equals(Object obj) {
            return (obj instanceof VariantTweak) && obj.hashCode() == hashCode();
        }
    }
}
