package okhttp3;

import java.io.Closeable;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes2.dex */
public final class Response implements Closeable {

    /* JADX INFO: renamed from: a */
    final Request f15199a;

    /* JADX INFO: renamed from: b */
    final Protocol f15200b;

    /* JADX INFO: renamed from: c */
    final int f15201c;

    /* JADX INFO: renamed from: d */
    final String f15202d;

    /* JADX INFO: renamed from: e */
    final Handshake f15203e;

    /* JADX INFO: renamed from: f */
    final Headers f15204f;

    /* JADX INFO: renamed from: g */
    final ResponseBody f15205g;

    /* JADX INFO: renamed from: h */
    final Response f15206h;

    /* JADX INFO: renamed from: i */
    final Response f15207i;

    /* JADX INFO: renamed from: j */
    final Response f15208j;

    /* JADX INFO: renamed from: k */
    final long f15209k;

    /* JADX INFO: renamed from: l */
    final long f15210l;

    /* JADX INFO: renamed from: m */
    private volatile CacheControl f15211m;

    Response(Builder builder) {
        this.f15199a = builder.f15212a;
        this.f15200b = builder.f15213b;
        this.f15201c = builder.f15214c;
        this.f15202d = builder.f15215d;
        this.f15203e = builder.f15216e;
        this.f15204f = builder.f15217f.m15626a();
        this.f15205g = builder.f15218g;
        this.f15206h = builder.f15219h;
        this.f15207i = builder.f15220i;
        this.f15208j = builder.f15221j;
        this.f15209k = builder.f15222k;
        this.f15210l = builder.f15223l;
    }

    /* JADX INFO: renamed from: a */
    public Request m15791a() {
        return this.f15199a;
    }

    /* JADX INFO: renamed from: b */
    public Protocol m15792b() {
        return this.f15200b;
    }

    /* JADX INFO: renamed from: c */
    public int m15793c() {
        return this.f15201c;
    }

    /* JADX INFO: renamed from: d */
    public boolean m15794d() {
        return this.f15201c >= 200 && this.f15201c < 300;
    }

    /* JADX INFO: renamed from: e */
    public String m15795e() {
        return this.f15202d;
    }

    /* JADX INFO: renamed from: f */
    public Handshake m15796f() {
        return this.f15203e;
    }

    /* JADX INFO: renamed from: a */
    public String m15789a(String str) {
        return m15790a(str, null);
    }

    /* JADX INFO: renamed from: a */
    public String m15790a(String str, String str2) {
        String strM15619a = this.f15204f.m15619a(str);
        return strM15619a != null ? strM15619a : str2;
    }

    /* JADX INFO: renamed from: g */
    public Headers m15797g() {
        return this.f15204f;
    }

    /* JADX INFO: renamed from: h */
    public ResponseBody m15798h() {
        return this.f15205g;
    }

    /* JADX INFO: renamed from: i */
    public Builder m15799i() {
        return new Builder(this);
    }

    /* JADX INFO: renamed from: j */
    public Response m15800j() {
        return this.f15206h;
    }

    /* JADX INFO: renamed from: k */
    public CacheControl m15801k() {
        CacheControl cacheControl = this.f15211m;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControlM15520a = CacheControl.m15520a(this.f15204f);
        this.f15211m = cacheControlM15520a;
        return cacheControlM15520a;
    }

    /* JADX INFO: renamed from: l */
    public long m15802l() {
        return this.f15209k;
    }

    /* JADX INFO: renamed from: m */
    public long m15803m() {
        return this.f15210l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15205g.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f15200b + ", code=" + this.f15201c + ", message=" + this.f15202d + ", url=" + this.f15199a.m15765a() + '}';
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        Request f15212a;

        /* JADX INFO: renamed from: b */
        Protocol f15213b;

        /* JADX INFO: renamed from: c */
        int f15214c;

        /* JADX INFO: renamed from: d */
        String f15215d;

        /* JADX INFO: renamed from: e */
        Handshake f15216e;

        /* JADX INFO: renamed from: f */
        Headers.Builder f15217f;

        /* JADX INFO: renamed from: g */
        ResponseBody f15218g;

        /* JADX INFO: renamed from: h */
        Response f15219h;

        /* JADX INFO: renamed from: i */
        Response f15220i;

        /* JADX INFO: renamed from: j */
        Response f15221j;

        /* JADX INFO: renamed from: k */
        long f15222k;

        /* JADX INFO: renamed from: l */
        long f15223l;

        public Builder() {
            this.f15214c = -1;
            this.f15217f = new Headers.Builder();
        }

        Builder(Response response) {
            this.f15214c = -1;
            this.f15212a = response.f15199a;
            this.f15213b = response.f15200b;
            this.f15214c = response.f15201c;
            this.f15215d = response.f15202d;
            this.f15216e = response.f15203e;
            this.f15217f = response.f15204f.m15622b();
            this.f15218g = response.f15205g;
            this.f15219h = response.f15206h;
            this.f15220i = response.f15207i;
            this.f15221j = response.f15208j;
            this.f15222k = response.f15209k;
            this.f15223l = response.f15210l;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15813a(Request request) {
            this.f15212a = request;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15812a(Protocol protocol) {
            this.f15213b = protocol;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15806a(int i) {
            this.f15214c = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15808a(String str) {
            this.f15215d = str;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15810a(Handshake handshake) {
            this.f15216e = handshake;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15809a(String str, String str2) {
            this.f15217f.m15630c(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m15818b(String str, String str2) {
            this.f15217f.m15625a(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15811a(Headers headers) {
            this.f15217f = headers.m15622b();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15815a(ResponseBody responseBody) {
            this.f15218g = responseBody;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15814a(Response response) {
            if (response != null) {
                m15804a("networkResponse", response);
            }
            this.f15219h = response;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m15819b(Response response) {
            if (response != null) {
                m15804a("cacheResponse", response);
            }
            this.f15220i = response;
            return this;
        }

        /* JADX INFO: renamed from: a */
        private void m15804a(String str, Response response) {
            if (response.f15205g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (response.f15206h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (response.f15207i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (response.f15208j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        /* JADX INFO: renamed from: c */
        public Builder m15820c(Response response) {
            if (response != null) {
                m15805d(response);
            }
            this.f15221j = response;
            return this;
        }

        /* JADX INFO: renamed from: d */
        private void m15805d(Response response) {
            if (response.f15205g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* JADX INFO: renamed from: a */
        public Builder m15807a(long j) {
            this.f15222k = j;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m15817b(long j) {
            this.f15223l = j;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Response m15816a() {
            if (this.f15212a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f15213b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f15214c < 0) {
                throw new IllegalStateException("code < 0: " + this.f15214c);
            }
            if (this.f15215d == null) {
                throw new IllegalStateException("message == null");
            }
            return new Response(this);
        }
    }
}
