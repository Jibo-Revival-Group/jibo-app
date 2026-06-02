package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.mixpanel.android.util.MPLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"CommitPrefEdits"})
class PersistentIdentity {

    /* JADX INFO: renamed from: l */
    private static Integer f11995l;

    /* JADX INFO: renamed from: m */
    private static Boolean f11996m;

    /* JADX INFO: renamed from: n */
    private static boolean f11997n = true;

    /* JADX INFO: renamed from: o */
    private static final Object f11998o = new Object();

    /* JADX INFO: renamed from: a */
    private final Future<SharedPreferences> f11999a;

    /* JADX INFO: renamed from: b */
    private final Future<SharedPreferences> f12000b;

    /* JADX INFO: renamed from: c */
    private final Future<SharedPreferences> f12001c;

    /* JADX INFO: renamed from: d */
    private final Future<SharedPreferences> f12002d;

    /* JADX INFO: renamed from: i */
    private String f12007i;

    /* JADX INFO: renamed from: j */
    private String f12008j;

    /* JADX INFO: renamed from: k */
    private JSONArray f12009k;

    /* JADX INFO: renamed from: f */
    private JSONObject f12004f = null;

    /* JADX INFO: renamed from: g */
    private Map<String, String> f12005g = null;

    /* JADX INFO: renamed from: h */
    private boolean f12006h = false;

    /* JADX INFO: renamed from: e */
    private final SharedPreferences.OnSharedPreferenceChangeListener f12003e = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.mixpanel.android.mpmetrics.PersistentIdentity.1
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            synchronized (PersistentIdentity.f11998o) {
                PersistentIdentity.this.m11897m();
                boolean unused = PersistentIdentity.f11997n = false;
            }
        }
    };

    /* JADX INFO: renamed from: a */
    public static JSONArray m11889a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("people_distinct_id", null);
        String string2 = sharedPreferences.getString("waiting_array", null);
        if (string2 == null || string == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string2);
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    jSONObject.put("$distinct_id", string);
                    jSONArray2.put(jSONObject);
                } catch (JSONException e) {
                    MPLog.m12031e("MixpanelAPI.PIdentity", "Unparsable object found in waiting people records", e);
                }
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove("waiting_array");
            m11891a(editorEdit);
            return jSONArray2;
        } catch (JSONException e2) {
            MPLog.m12030e("MixpanelAPI.PIdentity", "Waiting people records were unreadable.");
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11890a(Context context, String str, Map<String, String> map) {
        synchronized (f11998o) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                editorEdit.putString(entry.getKey(), entry.getValue());
            }
            m11891a(editorEdit);
            f11997n = true;
        }
    }

    public PersistentIdentity(Future<SharedPreferences> future, Future<SharedPreferences> future2, Future<SharedPreferences> future3, Future<SharedPreferences> future4) {
        this.f12000b = future;
        this.f11999a = future2;
        this.f12001c = future3;
        this.f12002d = future4;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11905a(JSONObject jSONObject) {
        JSONObject jSONObjectM11895k = m11895k();
        Iterator<String> itKeys = jSONObjectM11895k.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObject.put(next, jSONObjectM11895k.get(next));
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.PIdentity", "Object read from one JSON Object cannot be written to another", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11902a(SuperPropertyUpdate superPropertyUpdate) {
        JSONObject jSONObjectM11895k = m11895k();
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<String> itKeys = jSONObjectM11895k.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObjectM11895k.get(next));
            }
            JSONObject jSONObjectMo11932a = superPropertyUpdate.mo11932a(jSONObject);
            if (jSONObjectMo11932a == null) {
                MPLog.m12028d("MixpanelAPI.PIdentity", "An update to Mixpanel's super properties returned null, and will have no effect.");
            } else {
                this.f12004f = jSONObjectMo11932a;
                m11898n();
            }
        } catch (JSONException e) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Can't copy from one JSONObject to another", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public Map<String, String> m11901a() {
        synchronized (f11998o) {
            if (f11997n || this.f12005g == null) {
                m11897m();
                f11997n = false;
            }
        }
        return this.f12005g;
    }

    /* JADX INFO: renamed from: b */
    public synchronized String m11907b() {
        if (!this.f12006h) {
            m11899o();
        }
        return this.f12007i;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11904a(String str) {
        if (!this.f12006h) {
            m11899o();
        }
        this.f12007i = str;
        m11900p();
    }

    /* JADX INFO: renamed from: c */
    public synchronized String m11910c() {
        if (!this.f12006h) {
            m11899o();
        }
        return this.f12008j;
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m11908b(String str) {
        if (!this.f12006h) {
            m11899o();
        }
        this.f12008j = str;
        m11900p();
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m11909b(JSONObject jSONObject) {
        if (!this.f12006h) {
            m11899o();
        }
        if (this.f12009k == null) {
            this.f12009k = new JSONArray();
        }
        this.f12009k.put(jSONObject);
        m11900p();
    }

    /* JADX INFO: renamed from: d */
    public synchronized JSONArray m11913d() {
        JSONArray jSONArrayM11889a;
        ExecutionException e;
        InterruptedException e2;
        try {
            jSONArrayM11889a = m11889a(this.f11999a.get());
        } catch (InterruptedException e3) {
            jSONArrayM11889a = null;
            e2 = e3;
        } catch (ExecutionException e4) {
            jSONArrayM11889a = null;
            e = e4;
        }
        try {
            m11899o();
        } catch (InterruptedException e5) {
            e2 = e5;
            MPLog.m12031e("MixpanelAPI.PIdentity", "Couldn't read waiting people records from shared preferences.", e2);
        } catch (ExecutionException e6) {
            e = e6;
            MPLog.m12031e("MixpanelAPI.PIdentity", "Couldn't read waiting people records from shared preferences.", e.getCause());
        }
        return jSONArrayM11889a;
    }

    /* JADX INFO: renamed from: e */
    public synchronized void m11915e() {
        try {
            try {
                SharedPreferences.Editor editorEdit = this.f11999a.get().edit();
                editorEdit.clear();
                m11891a(editorEdit);
                m11896l();
                m11899o();
            } catch (ExecutionException e) {
                throw new RuntimeException(e.getCause());
            }
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2.getCause());
        }
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m11912c(JSONObject jSONObject) {
        JSONObject jSONObjectM11895k = m11895k();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObjectM11895k.put(next, jSONObject.get(next));
            } catch (JSONException e) {
                MPLog.m12031e("MixpanelAPI.PIdentity", "Exception registering super property.", e);
            }
        }
        m11898n();
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m11911c(String str) {
        try {
            SharedPreferences.Editor editorEdit = this.f11999a.get().edit();
            editorEdit.putString("push_id", str);
            m11891a(editorEdit);
        } catch (InterruptedException e) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", e);
        } catch (ExecutionException e2) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", e2.getCause());
        }
    }

    /* JADX INFO: renamed from: f */
    public synchronized void m11917f() {
        try {
            SharedPreferences.Editor editorEdit = this.f11999a.get().edit();
            editorEdit.remove("push_id");
            m11891a(editorEdit);
        } catch (InterruptedException e) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", e);
        } catch (ExecutionException e2) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", e2.getCause());
        }
    }

    /* JADX INFO: renamed from: g */
    public Map<String, Long> m11919g() {
        HashMap map = new HashMap();
        try {
            for (Map.Entry<String, ?> entry : this.f12001c.get().getAll().entrySet()) {
                map.put(entry.getKey(), Long.valueOf(entry.getValue().toString()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        }
        return map;
    }

    /* JADX INFO: renamed from: d */
    public void m11914d(String str) {
        try {
            SharedPreferences.Editor editorEdit = this.f12001c.get().edit();
            editorEdit.remove(str);
            m11891a(editorEdit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: e */
    public synchronized boolean m11916e(String str) {
        boolean z;
        try {
            z = this.f12002d.get().getBoolean(str, false);
        } catch (InterruptedException e) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Couldn't read internal Mixpanel from shared preferences.", e);
            z = false;
        } catch (ExecutionException e2) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Couldn't read internal Mixpanel shared preferences.", e2.getCause());
            z = false;
        }
        return z;
    }

    /* JADX INFO: renamed from: f */
    public synchronized void m11918f(String str) {
        try {
            SharedPreferences.Editor editorEdit = this.f12002d.get().edit();
            editorEdit.putBoolean(str, true);
            m11891a(editorEdit);
        } catch (InterruptedException e) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel from shared preferences.", e);
        } catch (ExecutionException e2) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e2.getCause());
        }
    }

    /* JADX INFO: renamed from: g */
    public synchronized boolean m11920g(String str) {
        boolean z;
        if (str == null) {
            z = false;
        } else {
            Integer numValueOf = Integer.valueOf(str);
            try {
                try {
                    if (f11995l == null) {
                        f11995l = Integer.valueOf(this.f12002d.get().getInt("latest_version_code", -1));
                        if (f11995l.intValue() == -1) {
                            f11995l = numValueOf;
                            SharedPreferences.Editor editorEdit = this.f12002d.get().edit();
                            editorEdit.putInt("latest_version_code", numValueOf.intValue());
                            m11891a(editorEdit);
                        }
                    }
                } catch (ExecutionException e) {
                    MPLog.m12031e("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e.getCause());
                }
            } catch (InterruptedException e2) {
                MPLog.m12031e("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel from shared preferences.", e2);
            }
            if (f11995l.intValue() < numValueOf.intValue()) {
                SharedPreferences.Editor editorEdit2 = this.f12002d.get().edit();
                editorEdit2.putInt("latest_version_code", numValueOf.intValue());
                m11891a(editorEdit2);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public synchronized boolean m11906a(boolean z) {
        if (f11996m == null) {
            try {
                if (this.f12002d.get().getBoolean("has_launched", false)) {
                    f11996m = false;
                } else {
                    f11996m = Boolean.valueOf(!z);
                }
            } catch (InterruptedException e) {
                f11996m = false;
            } catch (ExecutionException e2) {
                f11996m = false;
            }
        }
        return f11996m.booleanValue();
    }

    /* JADX INFO: renamed from: h */
    public synchronized void m11921h() {
        try {
            try {
                SharedPreferences.Editor editorEdit = this.f12002d.get().edit();
                editorEdit.putBoolean("has_launched", true);
                m11891a(editorEdit);
            } catch (ExecutionException e) {
                MPLog.m12031e("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e.getCause());
            }
        } catch (InterruptedException e2) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e2);
        }
    }

    /* JADX INFO: renamed from: i */
    public synchronized HashSet<Integer> m11922i() {
        HashSet<Integer> hashSet;
        hashSet = new HashSet<>();
        try {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(this.f11999a.get().getString("seen_campaign_ids", ""), ",");
                while (stringTokenizer.hasMoreTokens()) {
                    hashSet.add(Integer.valueOf(stringTokenizer.nextToken()));
                }
            } catch (InterruptedException e) {
                MPLog.m12031e("MixpanelAPI.PIdentity", "Couldn't read Mixpanel shared preferences.", e);
            }
        } catch (ExecutionException e2) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Couldn't read Mixpanel shared preferences.", e2.getCause());
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11903a(Integer num) {
        try {
            SharedPreferences sharedPreferences = this.f11999a.get();
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("seen_campaign_ids", sharedPreferences.getString("seen_campaign_ids", "") + num + ",");
            m11891a(editorEdit);
        } catch (InterruptedException e) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Can't write campaign id to shared preferences", e);
        } catch (ExecutionException e2) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Can't write campaign d to shared preferences", e2.getCause());
        }
    }

    /* JADX INFO: renamed from: k */
    private JSONObject m11895k() {
        if (this.f12004f == null) {
            m11896l();
        }
        return this.f12004f;
    }

    /* JADX INFO: renamed from: l */
    private void m11896l() {
        try {
            try {
                String string = this.f11999a.get().getString("super_properties", "{}");
                MPLog.m12021a("MixpanelAPI.PIdentity", "Loading Super Properties " + string);
                this.f12004f = new JSONObject(string);
                if (this.f12004f == null) {
                    this.f12004f = new JSONObject();
                }
            } catch (InterruptedException e) {
                MPLog.m12031e("MixpanelAPI.PIdentity", "Cannot load superProperties from SharedPreferences.", e);
                if (this.f12004f == null) {
                    this.f12004f = new JSONObject();
                }
            } catch (ExecutionException e2) {
                MPLog.m12031e("MixpanelAPI.PIdentity", "Cannot load superProperties from SharedPreferences.", e2.getCause());
                if (this.f12004f == null) {
                    this.f12004f = new JSONObject();
                }
            } catch (JSONException e3) {
                MPLog.m12030e("MixpanelAPI.PIdentity", "Cannot parse stored superProperties");
                m11898n();
                if (this.f12004f == null) {
                    this.f12004f = new JSONObject();
                }
            }
        } catch (Throwable th) {
            if (this.f12004f == null) {
                this.f12004f = new JSONObject();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m */
    public void m11897m() {
        this.f12005g = new HashMap();
        try {
            SharedPreferences sharedPreferences = this.f12000b.get();
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.f12003e);
            sharedPreferences.registerOnSharedPreferenceChangeListener(this.f12003e);
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                this.f12005g.put(entry.getKey(), entry.getValue().toString());
            }
        } catch (InterruptedException e) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e);
        } catch (ExecutionException e2) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e2.getCause());
        }
    }

    /* JADX INFO: renamed from: n */
    private void m11898n() {
        if (this.f12004f == null) {
            MPLog.m12030e("MixpanelAPI.PIdentity", "storeSuperProperties should not be called with uninitialized superPropertiesCache.");
            return;
        }
        String string = this.f12004f.toString();
        MPLog.m12021a("MixpanelAPI.PIdentity", "Storing Super Properties " + string);
        try {
            SharedPreferences.Editor editorEdit = this.f11999a.get().edit();
            editorEdit.putString("super_properties", string);
            m11891a(editorEdit);
        } catch (InterruptedException e) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", e);
        } catch (ExecutionException e2) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", e2.getCause());
        }
    }

    /* JADX INFO: renamed from: o */
    private void m11899o() {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = this.f11999a.get();
        } catch (InterruptedException e) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Cannot read distinct ids from sharedPreferences.", e);
            sharedPreferences = null;
        } catch (ExecutionException e2) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Cannot read distinct ids from sharedPreferences.", e2.getCause());
            sharedPreferences = null;
        }
        if (sharedPreferences != null) {
            this.f12007i = sharedPreferences.getString("events_distinct_id", null);
            this.f12008j = sharedPreferences.getString("people_distinct_id", null);
            this.f12009k = null;
            String string = sharedPreferences.getString("waiting_array", null);
            if (string != null) {
                try {
                    this.f12009k = new JSONArray(string);
                } catch (JSONException e3) {
                    MPLog.m12030e("MixpanelAPI.PIdentity", "Could not interpret waiting people JSON record " + string);
                }
            }
            if (this.f12007i == null) {
                this.f12007i = UUID.randomUUID().toString();
                m11900p();
            }
            this.f12006h = true;
        }
    }

    /* JADX INFO: renamed from: p */
    private void m11900p() {
        try {
            SharedPreferences.Editor editorEdit = this.f11999a.get().edit();
            editorEdit.putString("events_distinct_id", this.f12007i);
            editorEdit.putString("people_distinct_id", this.f12008j);
            if (this.f12009k == null) {
                editorEdit.remove("waiting_array");
            } else {
                editorEdit.putString("waiting_array", this.f12009k.toString());
            }
            m11891a(editorEdit);
        } catch (InterruptedException e) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", e);
        } catch (ExecutionException e2) {
            MPLog.m12031e("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", e2.getCause());
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m11891a(SharedPreferences.Editor editor) {
        editor.apply();
    }
}
