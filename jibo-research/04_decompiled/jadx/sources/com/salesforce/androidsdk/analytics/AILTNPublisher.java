package com.salesforce.androidsdk.analytics;

import com.facebook.share.internal.ShareConstants;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ApiVersionStrings;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AILTNPublisher implements AnalyticsPublisher {
    @Override // com.salesforce.androidsdk.analytics.AnalyticsPublisher
    /* JADX INFO: renamed from: a */
    public boolean mo14281a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return true;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", "ailtn");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("schemaType", jSONObjectOptJSONObject.optString("schemaType"));
                    jSONObjectOptJSONObject.remove("schemaType");
                    jSONObject2.put("payload", jSONObjectOptJSONObject.toString());
                    jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_DATA, jSONObject2);
                    jSONArray2.put(jSONObject);
                }
            } catch (JSONException e) {
                SalesforceSDKLogger.m15016a("AILTNPublisher", "Exception thrown while constructing event payload", e);
                return false;
            }
        }
        return m14282b(jSONArray2);
    }

    /* JADX INFO: renamed from: b */
    public boolean m14282b(JSONArray jSONArray) {
        RestResponse restResponseM14600b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("logLines", jSONArray);
            try {
                String str = String.format("/services/data/%s/connect/proxy/app-analytics-logging", ApiVersionStrings.m14555a(SalesforceSDKManager.m14403a().m14446k()));
                RestClient restClientM14567b = SalesforceSDKManager.m14403a().m14423E().m14567b();
                if (restClientM14567b.m14602d() == null) {
                    return false;
                }
                RequestBody requestBodyM14279a = m14279a(m14280b(RequestBody.m15785a(RestRequest.f14252a, jSONObject.toString())));
                HashMap map = new HashMap();
                map.put("Content-Encoding", "gzip");
                map.put("Content-Length", Long.toString(requestBodyM14279a.mo14285b()));
                restResponseM14600b = restClientM14567b.m14600b(new RestRequest(RestRequest.RestMethod.POST, str, requestBodyM14279a, map));
            } catch (ClientManager.AccountInfoNotFoundException e) {
                SalesforceSDKLogger.m15016a("AILTNPublisher", "Exception thrown while constructing rest client", e);
                restResponseM14600b = null;
            } catch (IOException e2) {
                SalesforceSDKLogger.m15016a("AILTNPublisher", "Exception thrown while making network request", e2);
                restResponseM14600b = null;
            }
            return restResponseM14600b != null && restResponseM14600b.m14622b();
        } catch (JSONException e3) {
            SalesforceSDKLogger.m15016a("AILTNPublisher", "Exception thrown while constructing event payload", e3);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private RequestBody m14279a(final RequestBody requestBody) throws IOException {
        final Buffer buffer = new Buffer();
        requestBody.mo14284a(buffer);
        return new RequestBody() { // from class: com.salesforce.androidsdk.analytics.AILTNPublisher.1
            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: a */
            public MediaType mo14283a() {
                return requestBody.mo14283a();
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: b */
            public long mo14285b() {
                return buffer.m16263b();
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: a */
            public void mo14284a(BufferedSink bufferedSink) throws IOException {
                bufferedSink.mo16268b(buffer.m16312w());
            }
        };
    }

    /* JADX INFO: renamed from: b */
    private RequestBody m14280b(final RequestBody requestBody) {
        return new RequestBody() { // from class: com.salesforce.androidsdk.analytics.AILTNPublisher.2
            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: a */
            public MediaType mo14283a() {
                return requestBody.mo14283a();
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: b */
            public long mo14285b() {
                return -1L;
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: a */
            public void mo14284a(BufferedSink bufferedSink) throws IOException {
                BufferedSink bufferedSinkM16359a = Okio.m16359a(new GzipSink(bufferedSink));
                requestBody.mo14284a(bufferedSinkM16359a);
                bufferedSinkM16359a.close();
            }
        };
    }
}
