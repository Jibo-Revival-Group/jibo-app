package okhttp3.logging;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import org.apache.http.message.TokenParser;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpLoggingInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a */
    private static final Charset f15625a = Charset.forName(HTTP.UTF_8);

    /* JADX INFO: renamed from: b */
    private final Logger f15626b;

    /* JADX INFO: renamed from: c */
    private volatile Level f15627c;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {

        /* JADX INFO: renamed from: a */
        public static final Logger f15628a = new Logger() { // from class: okhttp3.logging.HttpLoggingInterceptor.Logger.1
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            /* JADX INFO: renamed from: a */
            public void mo16233a(String str) {
                Platform.m16203b().mo16181a(4, str, (Throwable) null);
            }
        };

        /* JADX INFO: renamed from: a */
        void mo16233a(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.f15628a);
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.f15627c = Level.NONE;
        this.f15626b = logger;
    }

    /* JADX INFO: renamed from: a */
    public HttpLoggingInterceptor m16232a(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.f15627c = level;
        return this;
    }

    @Override // okhttp3.Interceptor
    /* JADX INFO: renamed from: a */
    public Response mo12243a(Interceptor.Chain chain) throws Exception {
        Level level = this.f15627c;
        Request requestMo15692a = chain.mo15692a();
        if (level == Level.NONE) {
            return chain.mo15693a(requestMo15692a);
        }
        boolean z = level == Level.BODY;
        boolean z2 = z || level == Level.HEADERS;
        RequestBody requestBodyM15769d = requestMo15692a.m15769d();
        boolean z3 = requestBodyM15769d != null;
        Connection connectionMo15694b = chain.mo15694b();
        String str = "--> " + requestMo15692a.m15766b() + TokenParser.f15715SP + requestMo15692a.m15765a() + TokenParser.f15715SP + (connectionMo15694b != null ? connectionMo15694b.mo15555b() : Protocol.HTTP_1_1);
        if (!z2 && z3) {
            str = str + " (" + requestBodyM15769d.mo14285b() + "-byte body)";
        }
        this.f15626b.mo16233a(str);
        if (z2) {
            if (z3) {
                if (requestBodyM15769d.mo14283a() != null) {
                    this.f15626b.mo16233a("Content-Type: " + requestBodyM15769d.mo14283a());
                }
                if (requestBodyM15769d.mo14285b() != -1) {
                    this.f15626b.mo16233a("Content-Length: " + requestBodyM15769d.mo14285b());
                }
            }
            Headers headersM15768c = requestMo15692a.m15768c();
            int iM15617a = headersM15768c.m15617a();
            for (int i = 0; i < iM15617a; i++) {
                String strM15618a = headersM15768c.m15618a(i);
                if (!"Content-Type".equalsIgnoreCase(strM15618a) && !"Content-Length".equalsIgnoreCase(strM15618a)) {
                    this.f15626b.mo16233a(strM15618a + ": " + headersM15768c.m15620b(i));
                }
            }
            if (!z || !z3) {
                this.f15626b.mo16233a("--> END " + requestMo15692a.m15766b());
            } else if (m16230a(requestMo15692a.m15768c())) {
                this.f15626b.mo16233a("--> END " + requestMo15692a.m15766b() + " (encoded body omitted)");
            } else {
                Buffer buffer = new Buffer();
                requestBodyM15769d.mo14284a(buffer);
                Charset charsetM15697a = f15625a;
                MediaType mediaTypeMo14283a = requestBodyM15769d.mo14283a();
                if (mediaTypeMo14283a != null) {
                    charsetM15697a = mediaTypeMo14283a.m15697a(f15625a);
                }
                this.f15626b.mo16233a("");
                if (m16231a(buffer)) {
                    this.f15626b.mo16233a(buffer.mo16253a(charsetM15697a));
                    this.f15626b.mo16233a("--> END " + requestMo15692a.m15766b() + " (" + requestBodyM15769d.mo14285b() + "-byte body)");
                } else {
                    this.f15626b.mo16233a("--> END " + requestMo15692a.m15766b() + " (binary " + requestBodyM15769d.mo14285b() + "-byte body omitted)");
                }
            }
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseMo15693a = chain.mo15693a(requestMo15692a);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyM15798h = responseMo15693a.m15798h();
            long jMo15512b = responseBodyM15798h.mo15512b();
            this.f15626b.mo16233a("<-- " + responseMo15693a.m15793c() + TokenParser.f15715SP + responseMo15693a.m15795e() + TokenParser.f15715SP + responseMo15693a.m15791a().m15765a() + " (" + millis + "ms" + (!z2 ? ", " + (jMo15512b != -1 ? jMo15512b + "-byte" : "unknown-length") + " body" : "") + ')');
            if (z2) {
                Headers headersM15797g = responseMo15693a.m15797g();
                int iM15617a2 = headersM15797g.m15617a();
                for (int i2 = 0; i2 < iM15617a2; i2++) {
                    this.f15626b.mo16233a(headersM15797g.m15618a(i2) + ": " + headersM15797g.m15620b(i2));
                }
                if (!z || !HttpHeaders.m15981d(responseMo15693a)) {
                    this.f15626b.mo16233a("<-- END HTTP");
                } else if (m16230a(responseMo15693a.m15797g())) {
                    this.f15626b.mo16233a("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource bufferedSourceMo15513c = responseBodyM15798h.mo15513c();
                    bufferedSourceMo15513c.mo16269b(Long.MAX_VALUE);
                    Buffer bufferMo16271c = bufferedSourceMo15513c.mo16271c();
                    Charset charsetM15697a2 = f15625a;
                    MediaType mediaTypeMo15511a = responseBodyM15798h.mo15511a();
                    if (mediaTypeMo15511a != null) {
                        charsetM15697a2 = mediaTypeMo15511a.m15697a(f15625a);
                    }
                    if (!m16231a(bufferMo16271c)) {
                        this.f15626b.mo16233a("");
                        this.f15626b.mo16233a("<-- END HTTP (binary " + bufferMo16271c.m16263b() + "-byte body omitted)");
                        return responseMo15693a;
                    }
                    if (jMo15512b != 0) {
                        this.f15626b.mo16233a("");
                        this.f15626b.mo16233a(bufferMo16271c.clone().mo16253a(charsetM15697a2));
                    }
                    this.f15626b.mo16233a("<-- END HTTP (" + bufferMo16271c.m16263b() + "-byte body)");
                }
            }
            return responseMo15693a;
        } catch (Exception e) {
            this.f15626b.mo16233a("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m16231a(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.m16257a(buffer2, 0L, buffer.m16263b() < 64 ? buffer.m16263b() : 64L);
            for (int i = 0; i < 16; i++) {
                if (buffer2.mo16283f()) {
                    break;
                }
                int iM16308s = buffer2.m16308s();
                if (Character.isISOControl(iM16308s) && !Character.isWhitespace(iM16308s)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m16230a(Headers headers) {
        String strM15619a = headers.m15619a("Content-Encoding");
        return (strM15619a == null || strM15619a.equalsIgnoreCase(HTTP.IDENTITY_CODING)) ? false : true;
    }
}
