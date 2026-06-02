package com.salesforce.androidsdk.analytics.model;

import android.content.Context;
import android.text.TextUtils;
import com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InstrumentationEvent {

    /* JADX INFO: renamed from: a */
    private String f14038a;

    /* JADX INFO: renamed from: b */
    private long f14039b;

    /* JADX INFO: renamed from: c */
    private long f14040c;

    /* JADX INFO: renamed from: d */
    private String f14041d;

    /* JADX INFO: renamed from: e */
    private JSONObject f14042e;

    /* JADX INFO: renamed from: f */
    private String f14043f;

    /* JADX INFO: renamed from: g */
    private int f14044g;

    /* JADX INFO: renamed from: h */
    private String f14045h;

    /* JADX INFO: renamed from: i */
    private JSONObject f14046i;

    /* JADX INFO: renamed from: j */
    private SchemaType f14047j;

    /* JADX INFO: renamed from: k */
    private EventType f14048k;

    /* JADX INFO: renamed from: l */
    private ErrorType f14049l;

    /* JADX INFO: renamed from: m */
    private DeviceAppAttributes f14050m;

    /* JADX INFO: renamed from: n */
    private String f14051n;

    /* JADX INFO: renamed from: o */
    private String f14052o;

    /* JADX INFO: renamed from: p */
    private long f14053p;

    /* JADX INFO: renamed from: q */
    private JSONObject f14054q;

    /* JADX INFO: renamed from: r */
    private JSONObject f14055r;

    /* JADX INFO: renamed from: s */
    private JSONObject f14056s;

    public enum ErrorType {
        info,
        warn,
        error
    }

    public enum EventType {
        user,
        system,
        error,
        crud
    }

    public enum SchemaType {
        LightningInteraction,
        LightningPageView,
        LightningPerformance,
        LightningError
    }

    InstrumentationEvent(String str, long j, long j2, String str2, JSONObject jSONObject, String str3, int i, String str4, JSONObject jSONObject2, SchemaType schemaType, EventType eventType, ErrorType errorType, DeviceAppAttributes deviceAppAttributes, String str5, String str6, long j3, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        this.f14038a = str;
        this.f14039b = j;
        this.f14040c = j2;
        this.f14041d = str2;
        this.f14042e = jSONObject;
        this.f14043f = str3;
        this.f14044g = i;
        this.f14045h = str4;
        this.f14046i = jSONObject2;
        this.f14047j = schemaType;
        this.f14048k = eventType;
        this.f14049l = errorType;
        this.f14050m = deviceAppAttributes;
        this.f14051n = str5;
        this.f14052o = str6;
        this.f14053p = j3;
        this.f14054q = jSONObject3;
        this.f14055r = jSONObject4;
        this.f14056s = jSONObject5;
    }

    public InstrumentationEvent(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f14038a = jSONObject.optString("eventId");
            this.f14039b = jSONObject.optLong("startTime");
            this.f14040c = jSONObject.optLong("endTime");
            this.f14041d = jSONObject.optString("name");
            this.f14042e = jSONObject.optJSONObject("attributes");
            this.f14043f = jSONObject.optString("sessionId");
            this.f14044g = jSONObject.optInt("sequenceId");
            this.f14045h = jSONObject.optString("senderId");
            this.f14046i = jSONObject.optJSONObject("senderContext");
            String strOptString = jSONObject.optString("schemaType");
            if (!TextUtils.isEmpty(strOptString)) {
                this.f14047j = SchemaType.valueOf(strOptString);
            }
            String strOptString2 = jSONObject.optString("eventType");
            if (!TextUtils.isEmpty(strOptString2)) {
                this.f14048k = EventType.valueOf(strOptString2);
            }
            String strOptString3 = jSONObject.optString("errorType");
            if (!TextUtils.isEmpty(strOptString3)) {
                this.f14049l = ErrorType.valueOf(strOptString3);
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("deviceAppAttributes");
            if (jSONObjectOptJSONObject != null) {
                this.f14050m = new DeviceAppAttributes(jSONObjectOptJSONObject);
            }
            this.f14051n = jSONObject.optString("connectionType");
            this.f14052o = jSONObject.optString("senderParentId");
            this.f14053p = jSONObject.optLong("sessionStartTime");
            this.f14054q = jSONObject.optJSONObject("page");
            this.f14055r = jSONObject.optJSONObject("previousPage");
            this.f14056s = jSONObject.optJSONObject("marks");
        }
    }

    /* JADX INFO: renamed from: a */
    public String m14335a() {
        return this.f14038a;
    }

    /* JADX INFO: renamed from: b */
    public long m14336b() {
        return this.f14039b;
    }

    /* JADX INFO: renamed from: c */
    public long m14337c() {
        return this.f14040c;
    }

    /* JADX INFO: renamed from: d */
    public String m14338d() {
        return this.f14041d;
    }

    /* JADX INFO: renamed from: e */
    public JSONObject m14339e() {
        return this.f14042e;
    }

    /* JADX INFO: renamed from: f */
    public String m14340f() {
        return this.f14043f;
    }

    /* JADX INFO: renamed from: g */
    public int m14341g() {
        return this.f14044g;
    }

    /* JADX INFO: renamed from: h */
    public String m14342h() {
        return this.f14045h;
    }

    /* JADX INFO: renamed from: i */
    public JSONObject m14343i() {
        return this.f14046i;
    }

    /* JADX INFO: renamed from: j */
    public SchemaType m14344j() {
        return this.f14047j;
    }

    /* JADX INFO: renamed from: k */
    public EventType m14345k() {
        return this.f14048k;
    }

    /* JADX INFO: renamed from: l */
    public ErrorType m14346l() {
        return this.f14049l;
    }

    /* JADX INFO: renamed from: m */
    public DeviceAppAttributes m14347m() {
        return this.f14050m;
    }

    /* JADX INFO: renamed from: n */
    public String m14348n() {
        return this.f14051n;
    }

    /* JADX INFO: renamed from: o */
    public String m14349o() {
        return this.f14052o;
    }

    /* JADX INFO: renamed from: p */
    public long m14350p() {
        return this.f14053p;
    }

    /* JADX INFO: renamed from: q */
    public JSONObject m14351q() {
        return this.f14054q;
    }

    /* JADX INFO: renamed from: r */
    public JSONObject m14352r() {
        return this.f14055r;
    }

    /* JADX INFO: renamed from: s */
    public JSONObject m14353s() {
        return this.f14056s;
    }

    /* JADX INFO: renamed from: t */
    public JSONObject m14354t() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("eventId", this.f14038a);
            jSONObject.put("startTime", this.f14039b);
            jSONObject.put("endTime", this.f14040c);
            jSONObject.put("name", this.f14041d);
            if (this.f14042e != null) {
                jSONObject.put("attributes", this.f14042e);
            }
            if (this.f14043f != null) {
                jSONObject.put("sessionId", this.f14043f);
            }
            jSONObject.put("sequenceId", this.f14044g);
            jSONObject.put("senderId", this.f14045h);
            if (this.f14046i != null) {
                jSONObject.put("senderContext", this.f14046i);
            }
            if (this.f14047j != null) {
                jSONObject.put("schemaType", this.f14047j.name());
            }
            if (this.f14048k != null) {
                jSONObject.put("eventType", this.f14048k.name());
            }
            if (this.f14049l != null) {
                jSONObject.put("errorType", this.f14049l.name());
            }
            jSONObject.put("deviceAppAttributes", this.f14050m.m14334a());
            jSONObject.put("connectionType", this.f14051n);
            jSONObject.put("senderParentId", this.f14052o);
            jSONObject.put("sessionStartTime", this.f14053p);
            if (this.f14054q != null) {
                jSONObject.put("page", this.f14054q);
            }
            if (this.f14055r != null) {
                jSONObject.put("previousPage", this.f14055r);
            }
            if (this.f14056s != null) {
                jSONObject.put("marks", this.f14056s);
            }
        } catch (JSONException e) {
            SalesforceAnalyticsLogger.m14396a((Context) null, "InstrumentationEvent", "Exception thrown while attempting to convert to JSON", e);
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof InstrumentationEvent)) {
            return false;
        }
        return !TextUtils.isEmpty(this.f14038a) && this.f14038a.equals(((InstrumentationEvent) obj).m14335a());
    }

    public int hashCode() {
        return this.f14038a.hashCode();
    }
}
