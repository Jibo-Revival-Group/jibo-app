package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.GzipSource;
import okio.Okio;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public final class BridgeInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a */
    private final CookieJar f15363a;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.f15363a = cookieJar;
    }

    @Override // okhttp3.Interceptor
    /* JADX INFO: renamed from: a */
    public Response mo12243a(Interceptor.Chain chain) throws IOException {
        boolean z = false;
        Request requestMo15692a = chain.mo15692a();
        Request.Builder builderM15770e = requestMo15692a.m15770e();
        RequestBody requestBodyM15769d = requestMo15692a.m15769d();
        if (requestBodyM15769d != null) {
            MediaType mediaTypeMo14283a = requestBodyM15769d.mo14283a();
            if (mediaTypeMo14283a != null) {
                builderM15770e.m15775a("Content-Type", mediaTypeMo14283a.toString());
            }
            long jMo14285b = requestBodyM15769d.mo14285b();
            if (jMo14285b != -1) {
                builderM15770e.m15775a("Content-Length", Long.toString(jMo14285b));
                builderM15770e.m15781b("Transfer-Encoding");
            } else {
                builderM15770e.m15775a("Transfer-Encoding", HTTP.CHUNK_CODING);
                builderM15770e.m15781b("Content-Length");
            }
        }
        if (requestMo15692a.m15764a("Host") == null) {
            builderM15770e.m15775a("Host", Util.m15837a(requestMo15692a.m15765a(), false));
        }
        if (requestMo15692a.m15764a("Connection") == null) {
            builderM15770e.m15775a("Connection", HTTP.CONN_KEEP_ALIVE);
        }
        if (requestMo15692a.m15764a(org.apache.http.HttpHeaders.ACCEPT_ENCODING) == null && requestMo15692a.m15764a(org.apache.http.HttpHeaders.RANGE) == null) {
            z = true;
            builderM15770e.m15775a(org.apache.http.HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
        List<Cookie> listMo15586a = this.f15363a.mo15586a(requestMo15692a.m15765a());
        if (!listMo15586a.isEmpty()) {
            builderM15770e.m15775a("Cookie", m15957a(listMo15586a));
        }
        if (requestMo15692a.m15764a("User-Agent") == null) {
            builderM15770e.m15775a("User-Agent", Version.m15858a());
        }
        Response responseMo15693a = chain.mo15693a(builderM15770e.m15784c());
        HttpHeaders.m15974a(this.f15363a, requestMo15692a.m15765a(), responseMo15693a.m15797g());
        Response.Builder builderM15813a = responseMo15693a.m15799i().m15813a(requestMo15692a);
        if (z && "gzip".equalsIgnoreCase(responseMo15693a.m15789a("Content-Encoding")) && HttpHeaders.m15981d(responseMo15693a)) {
            GzipSource gzipSource = new GzipSource(responseMo15693a.m15798h().mo15513c());
            Headers headersM15626a = responseMo15693a.m15797g().m15622b().m15627b("Content-Encoding").m15627b("Content-Length").m15626a();
            builderM15813a.m15811a(headersM15626a);
            builderM15813a.m15815a(new RealResponseBody(headersM15626a, Okio.m16360a(gzipSource)));
        }
        return builderM15813a.m15816a();
    }

    /* JADX INFO: renamed from: a */
    private String m15957a(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.m15583a()).append('=').append(cookie.m15585b());
        }
        return sb.toString();
    }
}
