package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes2.dex */
public final class CacheStrategy {

    /* JADX INFO: renamed from: a */
    public final Request f15262a;

    /* JADX INFO: renamed from: b */
    public final Response f15263b;

    CacheStrategy(Request request, Response response) {
        this.f15262a = request;
        this.f15263b = response;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m15865a(Response response, Request request) {
        switch (response.m15793c()) {
            case 200:
            case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
            case 204:
            case 300:
            case 301:
            case 308:
            case 404:
            case 405:
            case HttpStatus.SC_GONE /* 410 */:
            case HttpStatus.SC_REQUEST_URI_TOO_LONG /* 414 */:
            case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                break;
            case 302:
            case 307:
                if (response.m15789a(HttpHeaders.EXPIRES) == null && response.m15801k().m15524c() == -1 && !response.m15801k().m15526e() && !response.m15801k().m15525d()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return (response.m15801k().m15523b() || request.m15771f().m15523b()) ? false : true;
    }

    public static class Factory {

        /* JADX INFO: renamed from: a */
        final long f15264a;

        /* JADX INFO: renamed from: b */
        final Request f15265b;

        /* JADX INFO: renamed from: c */
        final Response f15266c;

        /* JADX INFO: renamed from: d */
        private Date f15267d;

        /* JADX INFO: renamed from: e */
        private String f15268e;

        /* JADX INFO: renamed from: f */
        private Date f15269f;

        /* JADX INFO: renamed from: g */
        private String f15270g;

        /* JADX INFO: renamed from: h */
        private Date f15271h;

        /* JADX INFO: renamed from: i */
        private long f15272i;

        /* JADX INFO: renamed from: j */
        private long f15273j;

        /* JADX INFO: renamed from: k */
        private String f15274k;

        /* JADX INFO: renamed from: l */
        private int f15275l;

        public Factory(long j, Request request, Response response) {
            this.f15275l = -1;
            this.f15264a = j;
            this.f15265b = request;
            this.f15266c = response;
            if (response != null) {
                this.f15272i = response.m15802l();
                this.f15273j = response.m15803m();
                Headers headersM15797g = response.m15797g();
                int iM15617a = headersM15797g.m15617a();
                for (int i = 0; i < iM15617a; i++) {
                    String strM15618a = headersM15797g.m15618a(i);
                    String strM15620b = headersM15797g.m15620b(i);
                    if ("Date".equalsIgnoreCase(strM15618a)) {
                        this.f15267d = HttpDate.m15966a(strM15620b);
                        this.f15268e = strM15620b;
                    } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(strM15618a)) {
                        this.f15271h = HttpDate.m15966a(strM15620b);
                    } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(strM15618a)) {
                        this.f15269f = HttpDate.m15966a(strM15620b);
                        this.f15270g = strM15620b;
                    } else if (HttpHeaders.ETAG.equalsIgnoreCase(strM15618a)) {
                        this.f15274k = strM15620b;
                    } else if (HttpHeaders.AGE.equalsIgnoreCase(strM15618a)) {
                        this.f15275l = okhttp3.internal.http.HttpHeaders.m15976b(strM15620b, -1);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public CacheStrategy m15871a() {
            CacheStrategy cacheStrategyM15867b = m15867b();
            if (cacheStrategyM15867b.f15262a != null && this.f15265b.m15771f().m15530i()) {
                return new CacheStrategy(null, null);
            }
            return cacheStrategyM15867b;
        }

        /* JADX INFO: renamed from: b */
        private CacheStrategy m15867b() {
            String str;
            String str2;
            long millis = 0;
            if (this.f15266c == null) {
                return new CacheStrategy(this.f15265b, null);
            }
            if (this.f15265b.m15772g() && this.f15266c.m15796f() == null) {
                return new CacheStrategy(this.f15265b, null);
            }
            if (!CacheStrategy.m15865a(this.f15266c, this.f15265b)) {
                return new CacheStrategy(this.f15265b, null);
            }
            CacheControl cacheControlM15771f = this.f15265b.m15771f();
            if (cacheControlM15771f.m15522a() || m15866a(this.f15265b)) {
                return new CacheStrategy(this.f15265b, null);
            }
            long jM15869d = m15869d();
            long jM15868c = m15868c();
            if (cacheControlM15771f.m15524c() != -1) {
                jM15868c = Math.min(jM15868c, TimeUnit.SECONDS.toMillis(cacheControlM15771f.m15524c()));
            }
            long millis2 = cacheControlM15771f.m15529h() != -1 ? TimeUnit.SECONDS.toMillis(cacheControlM15771f.m15529h()) : 0L;
            CacheControl cacheControlM15801k = this.f15266c.m15801k();
            if (!cacheControlM15801k.m15527f() && cacheControlM15771f.m15528g() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cacheControlM15771f.m15528g());
            }
            if (!cacheControlM15801k.m15522a() && jM15869d + millis2 < millis + jM15868c) {
                Response.Builder builderM15799i = this.f15266c.m15799i();
                if (millis2 + jM15869d >= jM15868c) {
                    builderM15799i.m15818b(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                }
                if (jM15869d > 86400000 && m15870e()) {
                    builderM15799i.m15818b(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new CacheStrategy(null, builderM15799i.m15816a());
            }
            if (this.f15274k != null) {
                str = HttpHeaders.IF_NONE_MATCH;
                str2 = this.f15274k;
            } else if (this.f15269f != null) {
                str = HttpHeaders.IF_MODIFIED_SINCE;
                str2 = this.f15270g;
            } else if (this.f15267d != null) {
                str = HttpHeaders.IF_MODIFIED_SINCE;
                str2 = this.f15268e;
            } else {
                return new CacheStrategy(this.f15265b, null);
            }
            Headers.Builder builderM15622b = this.f15265b.m15768c().m15622b();
            Internal.f15235a.mo15738a(builderM15622b, str, str2);
            return new CacheStrategy(this.f15265b.m15770e().m15777a(builderM15622b.m15626a()).m15784c(), this.f15266c);
        }

        /* JADX INFO: renamed from: c */
        private long m15868c() {
            long time;
            long time2;
            if (this.f15266c.m15801k().m15524c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.m15524c());
            }
            if (this.f15271h != null) {
                if (this.f15267d != null) {
                    time2 = this.f15267d.getTime();
                } else {
                    time2 = this.f15273j;
                }
                long time3 = this.f15271h.getTime() - time2;
                if (time3 <= 0) {
                    time3 = 0;
                }
                return time3;
            }
            if (this.f15269f == null || this.f15266c.m15791a().m15765a().m15660m() != null) {
                return 0L;
            }
            if (this.f15267d != null) {
                time = this.f15267d.getTime();
            } else {
                time = this.f15272i;
            }
            long time4 = time - this.f15269f.getTime();
            if (time4 > 0) {
                return time4 / 10;
            }
            return 0L;
        }

        /* JADX INFO: renamed from: d */
        private long m15869d() {
            long jMax = this.f15267d != null ? Math.max(0L, this.f15273j - this.f15267d.getTime()) : 0L;
            if (this.f15275l != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.f15275l));
            }
            return jMax + (this.f15273j - this.f15272i) + (this.f15264a - this.f15273j);
        }

        /* JADX INFO: renamed from: e */
        private boolean m15870e() {
            return this.f15266c.m15801k().m15524c() == -1 && this.f15271h == null;
        }

        /* JADX INFO: renamed from: a */
        private static boolean m15866a(Request request) {
            return (request.m15764a(HttpHeaders.IF_MODIFIED_SINCE) == null && request.m15764a(HttpHeaders.IF_NONE_MATCH) == null) ? false : true;
        }
    }
}
