package okhttp3.internal.cache;

import com.facebook.appevents.AppEventsConstants;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public final class CacheInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a */
    final InternalCache f15256a;

    public CacheInterceptor(InternalCache internalCache) {
        this.f15256a = internalCache;
    }

    @Override // okhttp3.Interceptor
    /* JADX INFO: renamed from: a */
    public Response mo12243a(Interceptor.Chain chain) throws IOException {
        Response responseMo15503a = this.f15256a != null ? this.f15256a.mo15503a(chain.mo15692a()) : null;
        CacheStrategy cacheStrategyM15871a = new CacheStrategy.Factory(System.currentTimeMillis(), chain.mo15692a(), responseMo15503a).m15871a();
        Request request = cacheStrategyM15871a.f15262a;
        Response response = cacheStrategyM15871a.f15263b;
        if (this.f15256a != null) {
            this.f15256a.mo15507a(cacheStrategyM15871a);
        }
        if (responseMo15503a != null && response == null) {
            Util.m15843a(responseMo15503a.m15798h());
        }
        if (request == null && response == null) {
            return new Response.Builder().m15813a(chain.mo15692a()).m15812a(Protocol.HTTP_1_1).m15806a(HttpStatus.SC_GATEWAY_TIMEOUT).m15808a("Unsatisfiable Request (only-if-cached)").m15815a(Util.f15239c).m15807a(-1L).m15817b(System.currentTimeMillis()).m15816a();
        }
        if (request == null) {
            return response.m15799i().m15819b(m15860a(response)).m15816a();
        }
        try {
            Response responseMo15693a = chain.mo15693a(request);
            if (responseMo15693a == null && responseMo15503a != null) {
                Util.m15843a(responseMo15503a.m15798h());
            }
            if (response != null) {
                if (responseMo15693a.m15793c() == 304) {
                    Response responseM15816a = response.m15799i().m15811a(m15859a(response.m15797g(), responseMo15693a.m15797g())).m15807a(responseMo15693a.m15802l()).m15817b(responseMo15693a.m15803m()).m15819b(m15860a(response)).m15814a(m15860a(responseMo15693a)).m15816a();
                    responseMo15693a.m15798h().close();
                    this.f15256a.mo15505a();
                    this.f15256a.mo15506a(response, responseM15816a);
                    return responseM15816a;
                }
                Util.m15843a(response.m15798h());
            }
            Response responseM15816a2 = responseMo15693a.m15799i().m15819b(m15860a(response)).m15814a(m15860a(responseMo15693a)).m15816a();
            if (this.f15256a != null) {
                if (HttpHeaders.m15981d(responseM15816a2) && CacheStrategy.m15865a(responseM15816a2, request)) {
                    return m15861a(this.f15256a.mo15504a(responseM15816a2), responseM15816a2);
                }
                if (HttpMethod.m15983a(request.m15766b())) {
                    try {
                        this.f15256a.mo15508b(request);
                        return responseM15816a2;
                    } catch (IOException e) {
                        return responseM15816a2;
                    }
                }
                return responseM15816a2;
            }
            return responseM15816a2;
        } catch (Throwable th) {
            if (0 == 0 && responseMo15503a != null) {
                Util.m15843a(responseMo15503a.m15798h());
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private static Response m15860a(Response response) {
        if (response == null || response.m15798h() == null) {
            return response;
        }
        return response.m15799i().m15815a((ResponseBody) null).m15816a();
    }

    /* JADX INFO: renamed from: a */
    private Response m15861a(final CacheRequest cacheRequest, Response response) throws IOException {
        Sink sinkMo15510b;
        if (cacheRequest != null && (sinkMo15510b = cacheRequest.mo15510b()) != null) {
            final BufferedSource bufferedSourceMo15513c = response.m15798h().mo15513c();
            final BufferedSink bufferedSinkM16359a = Okio.m16359a(sinkMo15510b);
            return response.m15799i().m15815a(new RealResponseBody(response.m15797g(), Okio.m16360a(new Source() { // from class: okhttp3.internal.cache.CacheInterceptor.1

                /* JADX INFO: renamed from: a */
                boolean f15257a;

                @Override // okio.Source
                /* JADX INFO: renamed from: a */
                public long mo15863a(Buffer buffer, long j) throws IOException {
                    try {
                        long jA = bufferedSourceMo15513c.mo15863a(buffer, j);
                        if (jA == -1) {
                            if (!this.f15257a) {
                                this.f15257a = true;
                                bufferedSinkM16359a.close();
                            }
                            return -1L;
                        }
                        buffer.m16257a(bufferedSinkM16359a.mo16271c(), buffer.m16263b() - jA, jA);
                        bufferedSinkM16359a.mo16313x();
                        return jA;
                    } catch (IOException e) {
                        if (!this.f15257a) {
                            this.f15257a = true;
                            cacheRequest.mo15509a();
                        }
                        throw e;
                    }
                }

                @Override // okio.Source
                /* JADX INFO: renamed from: a */
                public Timeout mo15864a() {
                    return bufferedSourceMo15513c.mo15864a();
                }

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    if (!this.f15257a && !Util.m15847a(this, 100, TimeUnit.MILLISECONDS)) {
                        this.f15257a = true;
                        cacheRequest.mo15509a();
                    }
                    bufferedSourceMo15513c.close();
                }
            }))).m15816a();
        }
        return response;
    }

    /* JADX INFO: renamed from: a */
    private static Headers m15859a(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int iM15617a = headers.m15617a();
        for (int i = 0; i < iM15617a; i++) {
            String strM15618a = headers.m15618a(i);
            String strM15620b = headers.m15620b(i);
            if ((!org.apache.http.HttpHeaders.WARNING.equalsIgnoreCase(strM15618a) || !strM15620b.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_YES)) && (!m15862a(strM15618a) || headers2.m15619a(strM15618a) == null)) {
                Internal.f15235a.mo15738a(builder, strM15618a, strM15620b);
            }
        }
        int iM15617a2 = headers2.m15617a();
        for (int i2 = 0; i2 < iM15617a2; i2++) {
            String strM15618a2 = headers2.m15618a(i2);
            if (!"Content-Length".equalsIgnoreCase(strM15618a2) && m15862a(strM15618a2)) {
                Internal.f15235a.mo15738a(builder, strM15618a2, headers2.m15620b(i2));
            }
        }
        return builder.m15626a();
    }

    /* JADX INFO: renamed from: a */
    static boolean m15862a(String str) {
        return ("Connection".equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || org.apache.http.HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) || org.apache.http.HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || org.apache.http.HttpHeaders.f15705TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || org.apache.http.HttpHeaders.UPGRADE.equalsIgnoreCase(str)) ? false : true;
    }
}
