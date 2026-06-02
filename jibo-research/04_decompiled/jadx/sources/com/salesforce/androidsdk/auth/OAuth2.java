package com.salesforce.androidsdk.auth;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.RestResponse;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class OAuth2 {
    /* JADX INFO: renamed from: a */
    public static URI m14483a(URI uri, String str, String str2, String[] strArr, String str3, String str4) {
        return m14485a(uri, str, str2, strArr, str3, str4, null);
    }

    /* JADX INFO: renamed from: a */
    public static URI m14485a(URI uri, String str, String str2, String[] strArr, String str3, String str4, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(uri.toString());
        sb.append("/services/oauth2/authorize").append(m14481a());
        StringBuilder sbAppend = sb.append("?display=");
        if (str4 == null) {
            str4 = "touch";
        }
        sbAppend.append(str4);
        sb.append("&").append(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE).append("=").append(str3 == null ? "token" : "activated_client_code");
        sb.append("&").append("client_id").append("=").append(Uri.encode(str));
        if (strArr != null && strArr.length > 0) {
            sb.append("&").append("scope").append("=").append(Uri.encode(m14482a(strArr)));
        }
        sb.append("&").append(ServerProtocol.DIALOG_PARAM_REDIRECT_URI).append("=").append(str2);
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("&").append(entry.getKey()).append("=").append(Uri.encode(entry.getValue() == null ? "" : entry.getValue()));
            }
        }
        return URI.create(sb.toString());
    }

    /* JADX INFO: renamed from: a */
    private static String m14481a() {
        String strM14453r = SalesforceSDKManager.m14403a().m14453r();
        if (strM14453r == null || strM14453r.trim().isEmpty()) {
            return "";
        }
        if (!strM14453r.startsWith("/")) {
            strM14453r = "/" + strM14453r;
        }
        if (strM14453r.endsWith("/")) {
            return strM14453r.substring(0, strM14453r.length() - 1);
        }
        return strM14453r;
    }

    /* JADX INFO: renamed from: a */
    public static URI m14484a(URI uri, String str, String str2, String[] strArr, String str3, String str4, String str5, String str6, Map<String, String> map) {
        if (str5 == null || str6 == null) {
            return m14485a(uri, str, str2, strArr, str3, str4, map);
        }
        StringBuilder sb = new StringBuilder(str6);
        sb.append("/secur/frontdoor.jsp?");
        sb.append("sid").append("=").append(str5);
        sb.append("&").append("retURL").append("=").append(Uri.encode(m14483a(uri, str, str2, strArr, str3, str4).toString()));
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("&").append(entry.getKey()).append("=").append(Uri.encode(entry.getValue() == null ? "" : entry.getValue()));
            }
        }
        return URI.create(sb.toString());
    }

    /* JADX INFO: renamed from: a */
    private static String m14482a(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        TreeSet treeSet = new TreeSet(Arrays.asList(strArr));
        treeSet.add("refresh_token");
        return TextUtils.join(" ", treeSet.toArray(new String[0]));
    }

    /* JADX INFO: renamed from: a */
    public static TokenEndpointResponse m14479a(HttpAccess httpAccess, URI uri, String str, String str2, String str3, Map<String, String> map) throws OAuthFailedException, IOException {
        FormBody.Builder builderM14486a = m14486a("refresh_token", str, str3, map);
        builderM14486a.m15606a("refresh_token", str2);
        builderM14486a.m15606a("format", "json");
        return m14480a(httpAccess, uri, builderM14486a);
    }

    /* JADX INFO: renamed from: a */
    public static void m14488a(HttpAccess httpAccess, URI uri, String str) {
        try {
            FirebasePerfOkHttpClient.execute(httpAccess.m14477b().mo15540a(new Request.Builder().m15774a(uri.toString() + "/services/oauth2/revoke?token=" + Uri.encode(str)).m15773a().m15784c()));
        } catch (IOException e) {
            SalesforceSDKLogger.m15018b("OAuth2", "Exception thrown while revoking refresh token", e);
        }
    }

    /* JADX INFO: renamed from: b */
    public static TokenEndpointResponse m14489b(HttpAccess httpAccess, URI uri, String str) throws URISyntaxException, IOException, OAuthFailedException {
        return m14480a(httpAccess, uri, new FormBody.Builder().m15606a("grant_type", "urn:ietf:params:oauth:grant-type:jwt-bearer").m15606a("assertion", str));
    }

    /* JADX INFO: renamed from: a */
    public static final IdServiceResponse m14478a(HttpAccess httpAccess, String str, String str2) throws URISyntaxException, IOException {
        Request.Builder builderM15773a = new Request.Builder().m15774a(str).m15773a();
        m14487a(builderM15773a, str2);
        return new IdServiceResponse(FirebasePerfOkHttpClient.execute(httpAccess.m14477b().mo15540a(builderM15773a.m15784c())));
    }

    /* JADX INFO: renamed from: a */
    public static final Request.Builder m14487a(Request.Builder builder, String str) {
        return builder.m15775a(HttpHeaders.AUTHORIZATION, "Bearer " + str);
    }

    /* JADX INFO: renamed from: a */
    private static TokenEndpointResponse m14480a(HttpAccess httpAccess, URI uri, FormBody.Builder builder) throws IOException, OAuthFailedException {
        Response responseExecute = FirebasePerfOkHttpClient.execute(httpAccess.m14477b().mo15540a(new Request.Builder().m15774a(uri.toString() + "/services/oauth2/token").m15779a(builder.m15607a()).m15784c()));
        if (responseExecute.m15794d()) {
            return new TokenEndpointResponse(responseExecute);
        }
        throw new OAuthFailedException(new TokenErrorResponse(responseExecute), responseExecute.m15793c());
    }

    /* JADX INFO: renamed from: a */
    private static FormBody.Builder m14486a(String str, String str2, String str3, Map<String, String> map) {
        FormBody.Builder builderM15606a = new FormBody.Builder().m15606a("grant_type", str).m15606a("client_id", str2);
        if (str3 != null) {
            builderM15606a.m15606a("client_secret", str3);
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builderM15606a.m15606a(entry.getKey(), entry.getValue());
            }
        }
        return builderM15606a;
    }

    public static class OAuthFailedException extends Exception {

        /* JADX INFO: renamed from: a */
        final TokenErrorResponse f14158a;

        /* JADX INFO: renamed from: b */
        final int f14159b;

        OAuthFailedException(TokenErrorResponse tokenErrorResponse, int i) {
            super(tokenErrorResponse.toString());
            this.f14158a = tokenErrorResponse;
            this.f14159b = i;
        }

        /* JADX INFO: renamed from: a */
        public boolean m14490a() {
            return this.f14159b == 401 || this.f14159b == 403 || this.f14159b == 400;
        }

        /* JADX INFO: renamed from: b */
        public TokenErrorResponse m14491b() {
            return this.f14158a;
        }

        /* JADX INFO: renamed from: c */
        public int m14492c() {
            return this.f14159b;
        }
    }

    public static class IdServiceResponse {

        /* JADX INFO: renamed from: a */
        public String f14147a;

        /* JADX INFO: renamed from: b */
        public String f14148b;

        /* JADX INFO: renamed from: c */
        public String f14149c;

        /* JADX INFO: renamed from: d */
        public String f14150d;

        /* JADX INFO: renamed from: e */
        public String f14151e;

        /* JADX INFO: renamed from: f */
        public String f14152f;

        /* JADX INFO: renamed from: g */
        public String f14153g;

        /* JADX INFO: renamed from: h */
        public int f14154h;

        /* JADX INFO: renamed from: i */
        public int f14155i;

        /* JADX INFO: renamed from: j */
        public JSONObject f14156j;

        /* JADX INFO: renamed from: k */
        public JSONObject f14157k;

        public IdServiceResponse(Response response) {
            this.f14154h = -1;
            this.f14155i = -1;
            try {
                JSONObject jSONObjectM14626f = new RestResponse(response).m14626f();
                this.f14147a = jSONObjectM14626f.getString("username");
                this.f14148b = jSONObjectM14626f.getString("email");
                this.f14149c = jSONObjectM14626f.getString("first_name");
                this.f14150d = jSONObjectM14626f.getString("last_name");
                this.f14151e = jSONObjectM14626f.getString("display_name");
                JSONObject jSONObject = jSONObjectM14626f.getJSONObject("photos");
                if (jSONObject != null) {
                    this.f14152f = jSONObject.getString("picture");
                    this.f14153g = jSONObject.getString("thumbnail");
                }
                this.f14156j = jSONObjectM14626f.optJSONObject("custom_attributes");
                this.f14157k = jSONObjectM14626f.optJSONObject("custom_permissions");
                if (jSONObjectM14626f.has("mobile_policy")) {
                    this.f14154h = jSONObjectM14626f.getJSONObject("mobile_policy").getInt("pin_length");
                    this.f14155i = jSONObjectM14626f.getJSONObject("mobile_policy").getInt("screen_lock");
                }
            } catch (Exception e) {
                SalesforceSDKLogger.m15018b("OAuth2", "Could not parse identity response", e);
            }
        }
    }

    public static class TokenErrorResponse {

        /* JADX INFO: renamed from: a */
        public String f14171a;

        /* JADX INFO: renamed from: b */
        public String f14172b;

        public TokenErrorResponse(Response response) {
            try {
                JSONObject jSONObjectM14626f = new RestResponse(response).m14626f();
                this.f14171a = jSONObjectM14626f.getString("error");
                this.f14172b = jSONObjectM14626f.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
            } catch (Exception e) {
                SalesforceSDKLogger.m15018b("OAuth2", "Could not parse token error response", e);
            }
        }

        public String toString() {
            return this.f14171a + ":" + this.f14172b;
        }
    }

    public static class TokenEndpointResponse {

        /* JADX INFO: renamed from: a */
        public String f14160a;

        /* JADX INFO: renamed from: b */
        public String f14161b;

        /* JADX INFO: renamed from: c */
        public String f14162c;

        /* JADX INFO: renamed from: d */
        public String f14163d;

        /* JADX INFO: renamed from: e */
        public String f14164e;

        /* JADX INFO: renamed from: f */
        public String f14165f;

        /* JADX INFO: renamed from: g */
        public String f14166g;

        /* JADX INFO: renamed from: h */
        public String f14167h;

        /* JADX INFO: renamed from: i */
        public String f14168i;

        /* JADX INFO: renamed from: j */
        public String f14169j;

        /* JADX INFO: renamed from: k */
        public Map<String, String> f14170k;

        public TokenEndpointResponse(Map<String, String> map) {
            List<String> listM14457v;
            try {
                this.f14160a = map.get("access_token");
                this.f14161b = map.get("refresh_token");
                this.f14162c = map.get("instance_url");
                this.f14163d = map.get(ShareConstants.WEB_DIALOG_PARAM_ID);
                this.f14167h = map.get("code");
                m14493a();
                this.f14168i = map.get("sfdc_community_id");
                this.f14169j = map.get("sfdc_community_url");
                SalesforceSDKManager salesforceSDKManagerM14403a = SalesforceSDKManager.m14403a();
                if (salesforceSDKManagerM14403a != null && (listM14457v = salesforceSDKManagerM14403a.m14457v()) != null && !listM14457v.isEmpty()) {
                    this.f14170k = new HashMap();
                    for (String str : listM14457v) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f14170k.put(str, map.get(str));
                        }
                    }
                }
            } catch (Exception e) {
                SalesforceSDKLogger.m15018b("OAuth2", "Could not parse token endpoint response", e);
            }
        }

        public TokenEndpointResponse(Response response) {
            List<String> listM14457v;
            String strOptString;
            try {
                JSONObject jSONObjectM14626f = new RestResponse(response).m14626f();
                this.f14160a = jSONObjectM14626f.getString("access_token");
                this.f14162c = jSONObjectM14626f.getString("instance_url");
                this.f14163d = jSONObjectM14626f.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
                m14493a();
                if (jSONObjectM14626f.has("refresh_token")) {
                    this.f14161b = jSONObjectM14626f.getString("refresh_token");
                }
                if (jSONObjectM14626f.has("sfdc_community_id")) {
                    this.f14168i = jSONObjectM14626f.getString("sfdc_community_id");
                }
                if (jSONObjectM14626f.has("sfdc_community_url")) {
                    this.f14169j = jSONObjectM14626f.getString("sfdc_community_url");
                }
                SalesforceSDKManager salesforceSDKManagerM14403a = SalesforceSDKManager.m14403a();
                if (salesforceSDKManagerM14403a != null && (listM14457v = salesforceSDKManagerM14403a.m14457v()) != null && !listM14457v.isEmpty()) {
                    this.f14170k = new HashMap();
                    for (String str : listM14457v) {
                        if (!TextUtils.isEmpty(str) && (strOptString = jSONObjectM14626f.optString(str, null)) != null) {
                            this.f14170k.put(str, strOptString);
                        }
                    }
                }
            } catch (Exception e) {
                SalesforceSDKLogger.m15018b("OAuth2", "Could not parse token endpoint response", e);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m14493a() throws URISyntaxException {
            this.f14164e = this.f14163d.replace(new URI(this.f14163d).getHost(), new URI(this.f14162c).getHost());
            String[] strArrSplit = this.f14163d.split("/");
            this.f14166g = strArrSplit[strArrSplit.length - 1];
            this.f14165f = strArrSplit[strArrSplit.length - 2];
        }
    }
}
