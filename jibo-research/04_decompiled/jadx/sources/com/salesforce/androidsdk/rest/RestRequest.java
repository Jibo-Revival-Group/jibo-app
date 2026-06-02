package com.salesforce.androidsdk.rest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TimeZone;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RestRequest {

    /* JADX INFO: renamed from: a */
    public static final MediaType f14252a = MediaType.m15695a("application/json; charset=utf-8");

    /* JADX INFO: renamed from: b */
    public static final String f14253b = StandardCharsets.UTF_8.name();

    /* JADX INFO: renamed from: c */
    public static final DateFormat f14254c = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");

    /* JADX INFO: renamed from: d */
    private final RestMethod f14255d;

    /* JADX INFO: renamed from: e */
    private final String f14256e;

    /* JADX INFO: renamed from: f */
    private final RequestBody f14257f;

    /* JADX INFO: renamed from: g */
    private final Map<String, String> f14258g;

    /* JADX INFO: renamed from: h */
    private final JSONObject f14259h;

    public enum RestMethod {
        GET,
        POST,
        PUT,
        DELETE,
        HEAD,
        PATCH
    }

    static {
        f14254c.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    private enum RestAction {
        VERSIONS("/services/data/"),
        RESOURCES("/services/data/%s/"),
        DESCRIBE_GLOBAL("/services/data/%s/sobjects/"),
        METADATA("/services/data/%s/sobjects/%s/"),
        DESCRIBE("/services/data/%s/sobjects/%s/describe/"),
        CREATE("/services/data/%s/sobjects/%s"),
        RETRIEVE("/services/data/%s/sobjects/%s/%s"),
        UPSERT("/services/data/%s/sobjects/%s/%s/%s"),
        UPDATE("/services/data/%s/sobjects/%s/%s"),
        DELETE("/services/data/%s/sobjects/%s/%s"),
        QUERY("/services/data/%s/query"),
        SEARCH("/services/data/%s/search"),
        SEARCH_SCOPE_AND_ORDER("/services/data/%s/search/scopeOrder"),
        SEARCH_RESULT_LAYOUT("/services/data/%s/search/layout"),
        COMPOSITE("/services/data/%s/composite"),
        BATCH("/services/data/%s/composite/batch"),
        SOBJECT_TREE("/services/data/%s/composite/tree/%s");

        private final String pathTemplate;

        RestAction(String str) {
            this.pathTemplate = str;
        }

        public String getPath(Object... objArr) {
            return String.format(this.pathTemplate, objArr);
        }
    }

    public RestRequest(RestMethod restMethod, String str) {
        this(restMethod, str, (RequestBody) null, (Map<String, String>) null);
    }

    public RestRequest(RestMethod restMethod, String str, JSONObject jSONObject) {
        this(restMethod, str, jSONObject, (Map<String, String>) null);
    }

    public RestRequest(RestMethod restMethod, String str, RequestBody requestBody, Map<String, String> map) {
        this.f14255d = restMethod;
        this.f14256e = str;
        this.f14257f = requestBody;
        this.f14258g = map;
        this.f14259h = null;
    }

    public RestRequest(RestMethod restMethod, String str, JSONObject jSONObject, Map<String, String> map) {
        this.f14255d = restMethod;
        this.f14256e = str;
        this.f14257f = jSONObject == null ? null : RequestBody.m15785a(f14252a, jSONObject.toString());
        this.f14258g = map;
        this.f14259h = jSONObject;
    }

    /* JADX INFO: renamed from: a */
    public RestMethod m14615a() {
        return this.f14255d;
    }

    /* JADX INFO: renamed from: b */
    public String m14616b() {
        return this.f14256e;
    }

    /* JADX INFO: renamed from: c */
    public RequestBody m14617c() {
        return this.f14257f;
    }

    /* JADX INFO: renamed from: d */
    public JSONObject m14618d() {
        return this.f14259h;
    }

    /* JADX INFO: renamed from: e */
    public Map<String, String> m14619e() {
        return this.f14258g;
    }

    /* JADX INFO: renamed from: a */
    public static RestRequest m14614a(String str, String str2, Map<String, Object> map) throws IOException {
        return new RestRequest(RestMethod.POST, RestAction.CREATE.getPath(str, str2), map == null ? null : new JSONObject(map));
    }

    /* JADX INFO: renamed from: a */
    public static RestRequest m14613a(String str, String str2, String str3) {
        return new RestRequest(RestMethod.DELETE, RestAction.DELETE.getPath(str, str2, str3));
    }

    public String toString() {
        try {
            return m14620f().toString(2);
        } catch (JSONException e) {
            return super.toString();
        }
    }

    /* JADX INFO: renamed from: f */
    protected JSONObject m14620f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("method", m14615a().toString());
        jSONObject.put("url", m14616b());
        jSONObject.put("body", m14618d());
        if (m14619e() != null) {
            jSONObject.put("httpHeaders", new JSONObject(m14619e()));
        }
        return jSONObject;
    }
}
