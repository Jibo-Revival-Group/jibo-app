package com.salesforce.androidsdk.analytics.transform;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.salesforce.androidsdk.analytics.model.DeviceAppAttributes;
import com.salesforce.androidsdk.analytics.model.InstrumentationEvent;
import com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AILTNTransform implements Transform {
    @Override // com.salesforce.androidsdk.analytics.transform.Transform
    /* JADX INFO: renamed from: a */
    public JSONObject mo14392a(InstrumentationEvent instrumentationEvent) {
        if (instrumentationEvent == null) {
            return null;
        }
        JSONObject jSONObjectM14390c = m14390c(instrumentationEvent);
        if (jSONObjectM14390c != null) {
            try {
                jSONObjectM14390c.put("deviceAttributes", m14389b(instrumentationEvent));
            } catch (JSONException e) {
                SalesforceAnalyticsLogger.m14396a((Context) null, "AILTNTransform", "Exception occurred while transforming JSON", e);
                return null;
            }
        }
        return jSONObjectM14390c;
    }

    /* JADX INFO: renamed from: b */
    private JSONObject m14389b(InstrumentationEvent instrumentationEvent) {
        JSONObject jSONObjectM14334a;
        JSONException e;
        JSONObject jSONObject = new JSONObject();
        try {
            DeviceAppAttributes deviceAppAttributesM14347m = instrumentationEvent.m14347m();
            jSONObjectM14334a = deviceAppAttributesM14347m != null ? deviceAppAttributesM14347m.m14334a() : jSONObject;
            try {
                jSONObjectM14334a.put("connectionType", instrumentationEvent.m14348n());
            } catch (JSONException e2) {
                e = e2;
                SalesforceAnalyticsLogger.m14396a((Context) null, "AILTNTransform", "Exception occurred while transforming JSON", e);
            }
        } catch (JSONException e3) {
            jSONObjectM14334a = jSONObject;
            e = e3;
        }
        return jSONObjectM14334a;
    }

    /* JADX INFO: renamed from: c */
    private JSONObject m14390c(InstrumentationEvent instrumentationEvent) {
        JSONObject jSONObjectM14391d;
        String strName;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "0.2");
            InstrumentationEvent.SchemaType schemaTypeM14344j = instrumentationEvent.m14344j();
            jSONObject.put("schemaType", schemaTypeM14344j.name());
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, instrumentationEvent.m14335a());
            jSONObject.put("eventSource", instrumentationEvent.m14338d());
            long jM14336b = instrumentationEvent.m14336b();
            jSONObject.put("ts", jM14336b);
            jSONObject.put("pageStartTime", instrumentationEvent.m14350p());
            long jM14337c = instrumentationEvent.m14337c() - jM14336b;
            if (jM14337c > 0) {
                if (schemaTypeM14344j == InstrumentationEvent.SchemaType.LightningInteraction || schemaTypeM14344j == InstrumentationEvent.SchemaType.LightningPerformance) {
                    jSONObject.put("duration", jM14337c);
                } else if (schemaTypeM14344j == InstrumentationEvent.SchemaType.LightningPageView) {
                    jSONObject.put("ept", jM14337c);
                }
            }
            String strM14340f = instrumentationEvent.m14340f();
            if (!TextUtils.isEmpty(strM14340f)) {
                jSONObject.put("clientSessionId", strM14340f);
            }
            if (schemaTypeM14344j != InstrumentationEvent.SchemaType.LightningPerformance) {
                jSONObject.put("sequence", instrumentationEvent.m14341g());
            }
            JSONObject jSONObjectM14339e = instrumentationEvent.m14339e();
            if (jSONObjectM14339e != null) {
                jSONObject.put("attributes", jSONObjectM14339e);
            }
            if (schemaTypeM14344j != InstrumentationEvent.SchemaType.LightningPerformance) {
                jSONObject.put("page", instrumentationEvent.m14351q());
            }
            JSONObject jSONObjectM14352r = instrumentationEvent.m14352r();
            if (jSONObjectM14352r != null && schemaTypeM14344j == InstrumentationEvent.SchemaType.LightningPageView) {
                jSONObject.put("previousPage", jSONObjectM14352r);
            }
            JSONObject jSONObjectM14353s = instrumentationEvent.m14353s();
            if (jSONObjectM14353s != null && (schemaTypeM14344j == InstrumentationEvent.SchemaType.LightningPageView || schemaTypeM14344j == InstrumentationEvent.SchemaType.LightningPerformance)) {
                jSONObject.put("marks", jSONObjectM14353s);
            }
            if ((schemaTypeM14344j == InstrumentationEvent.SchemaType.LightningInteraction || schemaTypeM14344j == InstrumentationEvent.SchemaType.LightningPageView) && (jSONObjectM14391d = m14391d(instrumentationEvent)) != null) {
                jSONObject.put("locator", jSONObjectM14391d);
            }
            InstrumentationEvent.EventType eventTypeM14345k = instrumentationEvent.m14345k();
            if (schemaTypeM14344j == InstrumentationEvent.SchemaType.LightningPerformance) {
                strName = "defs";
            } else {
                strName = (schemaTypeM14344j != InstrumentationEvent.SchemaType.LightningInteraction || eventTypeM14345k == null) ? null : eventTypeM14345k.name();
            }
            if (!TextUtils.isEmpty(strName)) {
                jSONObject.put("eventType", strName);
            }
            InstrumentationEvent.ErrorType errorTypeM14346l = instrumentationEvent.m14346l();
            if (errorTypeM14346l != null && schemaTypeM14344j == InstrumentationEvent.SchemaType.LightningError) {
                jSONObject.put("errorType", errorTypeM14346l.name());
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e) {
            SalesforceAnalyticsLogger.m14396a((Context) null, "AILTNTransform", "Exception occurred while transforming JSON", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    private JSONObject m14391d(InstrumentationEvent instrumentationEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strM14342h = instrumentationEvent.m14342h();
            String strM14349o = instrumentationEvent.m14349o();
            if (TextUtils.isEmpty(strM14342h) || TextUtils.isEmpty(strM14349o)) {
                return null;
            }
            jSONObject.put("target", strM14342h);
            jSONObject.put("scope", strM14349o);
            JSONObject jSONObjectM14343i = instrumentationEvent.m14343i();
            if (jSONObjectM14343i != null) {
                jSONObject.put("context", jSONObjectM14343i);
            }
        } catch (JSONException e) {
            SalesforceAnalyticsLogger.m14396a((Context) null, "AILTNTransform", "Exception occurred while transforming JSON", e);
            jSONObject = null;
        }
        return jSONObject;
    }
}
