package com.salesforce.androidsdk.rest;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.auth.HttpAccess;
import com.salesforce.androidsdk.auth.OAuth2;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class RestClient {

    /* JADX INFO: renamed from: a */
    private static Map<String, OAuthRefreshInterceptor> f14223a = new HashMap();

    /* JADX INFO: renamed from: b */
    private static Map<String, OkHttpClient.Builder> f14224b = new HashMap();

    /* JADX INFO: renamed from: c */
    private static Map<String, OkHttpClient> f14225c = new HashMap();

    /* JADX INFO: renamed from: d */
    private ClientInfo f14226d;

    /* JADX INFO: renamed from: e */
    private HttpAccess f14227e;

    /* JADX INFO: renamed from: f */
    private AuthTokenProvider f14228f;

    /* JADX INFO: renamed from: g */
    private OAuthRefreshInterceptor f14229g;

    /* JADX INFO: renamed from: h */
    private OkHttpClient.Builder f14230h;

    /* JADX INFO: renamed from: i */
    private OkHttpClient f14231i;

    public interface AuthTokenProvider {
        /* JADX INFO: renamed from: a */
        String mo14572a();

        /* JADX INFO: renamed from: b */
        long mo14573b();

        /* JADX INFO: renamed from: c */
        String mo14574c();
    }

    public RestClient(ClientInfo clientInfo, String str, HttpAccess httpAccess, AuthTokenProvider authTokenProvider) {
        this.f14226d = clientInfo;
        this.f14227e = httpAccess;
        this.f14228f = authTokenProvider;
        m14593a(str);
        m14595f();
        m14598a((OkHttpClient) null);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized void m14592a(UserAccount userAccount) {
        synchronized (RestClient.class) {
            String strM14591a = m14591a(userAccount != null ? userAccount.m14246f() : null, userAccount != null ? userAccount.m14247g() : null);
            f14223a.remove(strM14591a);
            f14224b.remove(strM14591a);
            OkHttpClient okHttpClientRemove = f14225c.remove(strM14591a);
            if (okHttpClientRemove != null) {
                okHttpClientRemove.m15725s().m15597b();
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private String m14594e() {
        return m14591a(this.f14226d.f14239h, this.f14226d.f14238g);
    }

    /* JADX INFO: renamed from: a */
    private static String m14591a(String str, String str2) {
        return (str == null || str2 == null) ? "unauthenticated" : str + "-" + str2;
    }

    /* JADX INFO: renamed from: a */
    private synchronized void m14593a(String str) {
        String strM14594e = m14594e();
        OAuthRefreshInterceptor oAuthRefreshInterceptor = f14223a.get(strM14594e);
        if (oAuthRefreshInterceptor == null) {
            oAuthRefreshInterceptor = new OAuthRefreshInterceptor(this.f14226d, str, this.f14228f);
            f14223a.put(strM14594e, oAuthRefreshInterceptor);
        }
        this.f14229g = oAuthRefreshInterceptor;
    }

    /* JADX INFO: renamed from: f */
    private synchronized void m14595f() {
        OkHttpClient.Builder builderM15751a = f14224b.get(m14594e());
        if (builderM15751a == null) {
            builderM15751a = this.f14227e.m14476a().m15751a(m14599b());
            f14224b.put(m14594e(), builderM15751a);
        }
        this.f14230h = builderM15751a;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m14598a(OkHttpClient okHttpClient) {
        String strM14594e = m14594e();
        if (okHttpClient != null) {
            f14225c.put(strM14594e, okHttpClient);
        }
        OkHttpClient okHttpClientM15752a = f14225c.get(strM14594e);
        if (okHttpClientM15752a == null) {
            okHttpClientM15752a = m14601c().m15752a();
            f14225c.put(strM14594e, okHttpClientM15752a);
        }
        this.f14231i = okHttpClientM15752a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RestClient: {\n").append(this.f14229g.f14251c.toString()).append("   timeSinceLastRefresh: ").append(this.f14229g.m14612b()).append("\n").append("}\n");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public synchronized String m14596a() {
        return this.f14229g.m14611a();
    }

    /* JADX INFO: renamed from: b */
    public OAuthRefreshInterceptor m14599b() {
        return this.f14229g;
    }

    /* JADX INFO: renamed from: c */
    public OkHttpClient.Builder m14601c() {
        return this.f14230h;
    }

    /* JADX INFO: renamed from: d */
    public OkHttpClient m14602d() {
        return this.f14231i;
    }

    /* JADX INFO: renamed from: a */
    public Request m14597a(RestRequest restRequest) {
        Request.Builder builderM15776a = new Request.Builder().m15778a(HttpUrl.m15638a(this.f14229g.f14251c.mo14604a(restRequest.m14616b()))).m15776a(restRequest.m14615a().toString(), restRequest.m14617c());
        Map<String, String> mapM14619e = restRequest.m14619e();
        if (mapM14619e != null) {
            for (Map.Entry<String, String> entry : mapM14619e.entrySet()) {
                builderM15776a.m15782b(entry.getKey(), entry.getValue());
            }
        }
        return builderM15776a.m15784c();
    }

    /* JADX INFO: renamed from: b */
    public RestResponse m14600b(RestRequest restRequest) throws IOException {
        return new RestResponse(FirebasePerfOkHttpClient.execute(this.f14231i.mo15540a(m14597a(restRequest))));
    }

    public static class ClientInfo {

        /* JADX INFO: renamed from: a */
        public final String f14232a;

        /* JADX INFO: renamed from: b */
        public final URI f14233b;

        /* JADX INFO: renamed from: c */
        public final URI f14234c;

        /* JADX INFO: renamed from: d */
        public final URI f14235d;

        /* JADX INFO: renamed from: e */
        public final String f14236e;

        /* JADX INFO: renamed from: f */
        public final String f14237f;

        /* JADX INFO: renamed from: g */
        public final String f14238g;

        /* JADX INFO: renamed from: h */
        public final String f14239h;

        /* JADX INFO: renamed from: i */
        public final String f14240i;

        /* JADX INFO: renamed from: j */
        public final String f14241j;

        /* JADX INFO: renamed from: k */
        public final String f14242k;

        /* JADX INFO: renamed from: l */
        public final String f14243l;

        /* JADX INFO: renamed from: m */
        public final String f14244m;

        /* JADX INFO: renamed from: n */
        public final String f14245n;

        /* JADX INFO: renamed from: o */
        public final String f14246o;

        /* JADX INFO: renamed from: p */
        public final String f14247p;

        /* JADX INFO: renamed from: q */
        public final Map<String, String> f14248q;

        public ClientInfo(String str, URI uri, URI uri2, URI uri3, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Map<String, String> map) {
            this.f14232a = str;
            this.f14233b = uri;
            this.f14234c = uri2;
            this.f14235d = uri3;
            this.f14236e = str2;
            this.f14237f = str3;
            this.f14238g = str4;
            this.f14239h = str5;
            this.f14240i = str6;
            this.f14241j = str7;
            this.f14242k = str8;
            this.f14243l = str9;
            this.f14244m = str10;
            this.f14245n = str11;
            this.f14246o = str12;
            this.f14247p = str13;
            this.f14248q = map;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("  ClientInfo: {\n").append("     loginUrl: ").append(this.f14234c.toString()).append("\n").append("     identityUrl: ").append(this.f14235d.toString()).append("\n").append("     instanceUrl: ").append(this.f14233b.toString()).append("\n").append("     accountName: ").append(this.f14236e).append("\n").append("     username: ").append(this.f14237f).append("\n").append("     userId: ").append(this.f14238g).append("\n").append("     orgId: ").append(this.f14239h).append("\n").append("     communityId: ").append(this.f14240i).append("\n").append("     communityUrl: ").append(this.f14241j).append("\n").append("     firstName: ").append(this.f14242k).append("\n").append("     lastName: ").append(this.f14243l).append("\n").append("     displayName: ").append(this.f14244m).append("\n").append("     email: ").append(this.f14245n).append("\n").append("     photoUrl: ").append(this.f14246o).append("\n").append("     thumbnailUrl: ").append(this.f14247p).append("\n").append("     additionalOauthValues: ").append(this.f14248q).append("\n").append("  }\n");
            return sb.toString();
        }

        /* JADX INFO: renamed from: a */
        public URI m14603a() {
            if (this.f14241j != null && !"".equals(this.f14241j.trim())) {
                try {
                    return new URI(this.f14241j);
                } catch (URISyntaxException e) {
                    SalesforceSDKLogger.m15016a("RestClient", "Exception thrown while parsing URL: " + this.f14241j, e);
                    return null;
                }
            }
            return this.f14233b;
        }

        /* JADX INFO: renamed from: a */
        public URI mo14604a(String str) {
            if (!str.matches("[hH][tT][tT][pP][sS]?://.*")) {
                StringBuilder sb = new StringBuilder();
                if (this.f14241j != null && !"".equals(this.f14241j.trim())) {
                    sb.append(this.f14241j);
                } else {
                    sb.append(this.f14233b.toString());
                }
                if (!sb.toString().endsWith("/")) {
                    sb.append("/");
                }
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                sb.append(str);
                str = sb.toString();
            }
            try {
                return new URI(str);
            } catch (URISyntaxException e) {
                SalesforceSDKLogger.m15016a("RestClient", "Exception thrown while parsing URL: " + str, e);
                return null;
            }
        }
    }

    public static class UnauthenticatedClientInfo extends ClientInfo {
        public UnauthenticatedClientInfo() {
            super(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        }

        @Override // com.salesforce.androidsdk.rest.RestClient.ClientInfo
        public String toString() {
            return getClass().getSimpleName();
        }

        @Override // com.salesforce.androidsdk.rest.RestClient.ClientInfo
        /* JADX INFO: renamed from: a */
        public URI mo14604a(String str) {
            try {
                return new URI(str);
            } catch (URISyntaxException e) {
                SalesforceSDKLogger.m15016a("RestClient", "Exception thrown while parsing URL: " + str, e);
                return null;
            }
        }
    }

    public static class OAuthRefreshInterceptor implements Interceptor {

        /* JADX INFO: renamed from: a */
        private final AuthTokenProvider f14249a;

        /* JADX INFO: renamed from: b */
        private String f14250b;

        /* JADX INFO: renamed from: c */
        private ClientInfo f14251c;

        public OAuthRefreshInterceptor(ClientInfo clientInfo, String str, AuthTokenProvider authTokenProvider) {
            this.f14251c = clientInfo;
            this.f14250b = str;
            this.f14249a = authTokenProvider;
        }

        @Override // okhttp3.Interceptor
        /* JADX INFO: renamed from: a */
        public Response mo12243a(Interceptor.Chain chain) throws IOException {
            Request requestM14606a = m14606a(chain.mo15692a());
            Response responseMo15693a = chain.mo15693a(requestM14606a);
            int iM15793c = responseMo15693a.m15793c();
            if (iM15793c == 401 || iM15793c == 403) {
                m14610c();
                if (m14611a() != null) {
                    Request requestM14606a2 = m14606a(requestM14606a);
                    HttpUrl httpUrlM15638a = HttpUrl.m15638a(this.f14251c.m14603a());
                    if (httpUrlM15638a != null && httpUrlM15638a.m15654g() != null && !httpUrlM15638a.m15654g().equals(requestM14606a2.m15765a().m15654g())) {
                        requestM14606a2 = m14607a(requestM14606a2, httpUrlM15638a.m15654g());
                    }
                    return chain.mo15693a(requestM14606a2);
                }
                return responseMo15693a;
            }
            return responseMo15693a;
        }

        /* JADX INFO: renamed from: a */
        private Request m14607a(Request request, String str) {
            HttpUrl.Builder builderM15663p = request.m15765a().m15663p();
            builderM15663p.m15688d(str);
            Request.Builder builderM15770e = request.m15770e();
            builderM15770e.m15778a(builderM15663p.m15687c());
            return builderM15770e.m15784c();
        }

        /* JADX INFO: renamed from: a */
        private Request m14606a(Request request) {
            Request.Builder builderM15770e = request.m15770e();
            m14609a(builderM15770e);
            return builderM15770e.m15784c();
        }

        /* JADX INFO: renamed from: a */
        public synchronized String m14611a() {
            return this.f14250b;
        }

        /* JADX INFO: renamed from: a */
        private void m14609a(Request.Builder builder) {
            if (this.f14250b != null) {
                OAuth2.m14487a(builder, this.f14250b);
            }
        }

        /* JADX INFO: renamed from: a */
        private synchronized void m14608a(String str) {
            this.f14250b = str;
        }

        /* JADX INFO: renamed from: b */
        public long m14612b() {
            long jMo14573b = this.f14249a != null ? this.f14249a.mo14573b() : -1L;
            if (jMo14573b < 0) {
                return -1L;
            }
            return System.currentTimeMillis() - jMo14573b;
        }

        /* JADX INFO: renamed from: c */
        private void m14610c() throws IOException {
            if (this.f14249a != null) {
                String strMo14572a = this.f14249a.mo14572a();
                if (strMo14572a == null || this.f14249a.mo14574c() == null) {
                    throw new RefreshTokenRevokedException("Could not refresh token");
                }
                m14608a(strMo14572a);
                String strMo14574c = this.f14249a.mo14574c();
                if (!this.f14251c.f14233b.toString().equalsIgnoreCase(strMo14574c)) {
                    try {
                        this.f14251c = new ClientInfo(this.f14251c.f14232a, new URI(strMo14574c), this.f14251c.f14234c, this.f14251c.f14235d, this.f14251c.f14236e, this.f14251c.f14237f, this.f14251c.f14238g, this.f14251c.f14239h, this.f14251c.f14240i, this.f14251c.f14241j, this.f14251c.f14242k, this.f14251c.f14243l, this.f14251c.f14244m, this.f14251c.f14245n, this.f14251c.f14246o, this.f14251c.f14247p, this.f14251c.f14248q);
                    } catch (URISyntaxException e) {
                        SalesforceSDKLogger.m15018b("RestClient", "Invalid server URL", e);
                    }
                }
            }
        }
    }

    public static class RefreshTokenRevokedException extends IOException {
        RefreshTokenRevokedException(String str) {
            super(str);
        }
    }
}
