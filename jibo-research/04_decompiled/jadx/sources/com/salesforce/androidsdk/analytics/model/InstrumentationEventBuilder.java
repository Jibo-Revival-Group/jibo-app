package com.salesforce.androidsdk.analytics.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.salesforce.androidsdk.analytics.manager.AnalyticsManager;
import com.salesforce.androidsdk.analytics.model.InstrumentationEvent;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InstrumentationEventBuilder {

    /* JADX INFO: renamed from: a */
    private AnalyticsManager f14057a;

    /* JADX INFO: renamed from: b */
    private Context f14058b;

    /* JADX INFO: renamed from: c */
    private long f14059c;

    /* JADX INFO: renamed from: d */
    private long f14060d;

    /* JADX INFO: renamed from: e */
    private String f14061e;

    /* JADX INFO: renamed from: f */
    private JSONObject f14062f;

    /* JADX INFO: renamed from: g */
    private String f14063g;

    /* JADX INFO: renamed from: h */
    private String f14064h;

    /* JADX INFO: renamed from: i */
    private JSONObject f14065i;

    /* JADX INFO: renamed from: j */
    private InstrumentationEvent.SchemaType f14066j;

    /* JADX INFO: renamed from: k */
    private InstrumentationEvent.EventType f14067k;

    /* JADX INFO: renamed from: l */
    private InstrumentationEvent.ErrorType f14068l;

    /* JADX INFO: renamed from: m */
    private String f14069m;

    /* JADX INFO: renamed from: n */
    private long f14070n;

    /* JADX INFO: renamed from: o */
    private JSONObject f14071o;

    /* JADX INFO: renamed from: p */
    private JSONObject f14072p;

    /* JADX INFO: renamed from: q */
    private JSONObject f14073q;

    /* JADX INFO: renamed from: a */
    public static final InstrumentationEventBuilder m14355a(AnalyticsManager analyticsManager, Context context) {
        return new InstrumentationEventBuilder(analyticsManager, context);
    }

    private InstrumentationEventBuilder(AnalyticsManager analyticsManager, Context context) {
        this.f14057a = analyticsManager;
        this.f14058b = context;
    }

    /* JADX INFO: renamed from: a */
    public InstrumentationEventBuilder m14358a(long j) {
        this.f14059c = j;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public InstrumentationEventBuilder m14363b(long j) {
        this.f14060d = j;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public InstrumentationEventBuilder m14361a(String str) {
        this.f14061e = str;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public InstrumentationEventBuilder m14362a(JSONObject jSONObject) {
        this.f14062f = jSONObject;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public InstrumentationEventBuilder m14360a(InstrumentationEvent.SchemaType schemaType) {
        this.f14066j = schemaType;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public InstrumentationEventBuilder m14359a(InstrumentationEvent.EventType eventType) {
        this.f14067k = eventType;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public InstrumentationEventBuilder m14364b(JSONObject jSONObject) {
        this.f14071o = jSONObject;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public InstrumentationEvent m14357a() throws EventBuilderException {
        String string = UUID.randomUUID().toString();
        String str = null;
        if (this.f14066j == null) {
            str = "Mandatory field 'schema type' not set!";
        }
        if (TextUtils.isEmpty(this.f14061e)) {
            str = "Mandatory field 'name' not set!";
        }
        DeviceAppAttributes deviceAppAttributesM14332c = this.f14057a.m14332c();
        if (deviceAppAttributesM14332c == null) {
            str = "Mandatory field 'device app attributes' not set!";
        }
        if ((this.f14066j == InstrumentationEvent.SchemaType.LightningInteraction || this.f14066j == InstrumentationEvent.SchemaType.LightningPerformance) && this.f14067k == null) {
            str = "Mandatory field 'event type' not set!";
        }
        if (this.f14066j != InstrumentationEvent.SchemaType.LightningPerformance && this.f14071o == null) {
            str = "Mandatory field 'page' not set!";
        }
        if (str != null) {
            throw new EventBuilderException(str);
        }
        int iM14331b = this.f14057a.m14331b() + 1;
        this.f14057a.m14329a(iM14331b);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f14059c = this.f14059c == 0 ? jCurrentTimeMillis : this.f14059c;
        if (this.f14070n != 0) {
            jCurrentTimeMillis = this.f14070n;
        }
        this.f14070n = jCurrentTimeMillis;
        return new InstrumentationEvent(string, this.f14059c, this.f14060d, this.f14061e, this.f14062f, this.f14063g, iM14331b, this.f14064h, this.f14065i, this.f14066j, this.f14067k, this.f14068l, deviceAppAttributesM14332c, m14356b(), this.f14069m, this.f14070n, this.f14071o, this.f14072p, this.f14073q);
    }

    /* JADX INFO: renamed from: b */
    private String m14356b() {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f14058b.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            String typeName = activeNetworkInfo.getTypeName();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            if (!TextUtils.isEmpty(typeName)) {
                sb.append(typeName);
                sb.append(";");
            }
            if (!TextUtils.isEmpty(subtypeName)) {
                sb.append(subtypeName);
            }
        }
        return sb.toString();
    }

    public static class EventBuilderException extends Exception {
        public EventBuilderException(String str) {
            super(str);
        }
    }
}
