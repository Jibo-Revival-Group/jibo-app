package okhttp3;

import com.google.api.client.http.HttpMethods;
import java.util.List;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: loaded from: classes2.dex */
public final class Request {

    /* JADX INFO: renamed from: a */
    final HttpUrl f15182a;

    /* JADX INFO: renamed from: b */
    final String f15183b;

    /* JADX INFO: renamed from: c */
    final Headers f15184c;

    /* JADX INFO: renamed from: d */
    final RequestBody f15185d;

    /* JADX INFO: renamed from: e */
    final Object f15186e;

    /* JADX INFO: renamed from: f */
    private volatile CacheControl f15187f;

    Request(Builder builder) {
        this.f15182a = builder.f15188a;
        this.f15183b = builder.f15189b;
        this.f15184c = builder.f15190c.m15626a();
        this.f15185d = builder.f15191d;
        this.f15186e = builder.f15192e != null ? builder.f15192e : this;
    }

    /* JADX INFO: renamed from: a */
    public HttpUrl m15765a() {
        return this.f15182a;
    }

    /* JADX INFO: renamed from: b */
    public String m15766b() {
        return this.f15183b;
    }

    /* JADX INFO: renamed from: c */
    public Headers m15768c() {
        return this.f15184c;
    }

    /* JADX INFO: renamed from: a */
    public String m15764a(String str) {
        return this.f15184c.m15619a(str);
    }

    /* JADX INFO: renamed from: b */
    public List<String> m15767b(String str) {
        return this.f15184c.m15621b(str);
    }

    /* JADX INFO: renamed from: d */
    public RequestBody m15769d() {
        return this.f15185d;
    }

    /* JADX INFO: renamed from: e */
    public Builder m15770e() {
        return new Builder(this);
    }

    /* JADX INFO: renamed from: f */
    public CacheControl m15771f() {
        CacheControl cacheControl = this.f15187f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControlM15520a = CacheControl.m15520a(this.f15184c);
        this.f15187f = cacheControlM15520a;
        return cacheControlM15520a;
    }

    /* JADX INFO: renamed from: g */
    public boolean m15772g() {
        return this.f15182a.m15651d();
    }

    public String toString() {
        return "Request{method=" + this.f15183b + ", url=" + this.f15182a + ", tag=" + (this.f15186e != this ? this.f15186e : null) + '}';
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        HttpUrl f15188a;

        /* JADX INFO: renamed from: b */
        String f15189b;

        /* JADX INFO: renamed from: c */
        Headers.Builder f15190c;

        /* JADX INFO: renamed from: d */
        RequestBody f15191d;

        /* JADX INFO: renamed from: e */
        Object f15192e;

        public Builder() {
            this.f15189b = HttpMethods.GET;
            this.f15190c = new Headers.Builder();
        }

        Builder(Request request) {
            this.f15188a = request.f15182a;
            this.f15189b = request.f15183b;
            this.f15191d = request.f15185d;
            this.f15192e = request.f15186e;
            this.f15190c = request.f15184c.m15622b();
        }

        /* JADX INFO: renamed from: a */
        public Builder m15778a(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new NullPointerException("url == null");
            }
            this.f15188a = httpUrl;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15774a(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            HttpUrl httpUrlM15645e = HttpUrl.m15645e(str);
            if (httpUrlM15645e == null) {
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            return m15778a(httpUrlM15645e);
        }

        /* JADX INFO: renamed from: a */
        public Builder m15775a(String str, String str2) {
            this.f15190c.m15630c(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m15782b(String str, String str2) {
            this.f15190c.m15625a(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m15781b(String str) {
            this.f15190c.m15627b(str);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15777a(Headers headers) {
            this.f15190c = headers.m15622b();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15773a() {
            return m15776a(HttpMethods.GET, (RequestBody) null);
        }

        /* JADX INFO: renamed from: a */
        public Builder m15779a(RequestBody requestBody) {
            return m15776a(HttpMethods.POST, requestBody);
        }

        /* JADX INFO: renamed from: b */
        public Builder m15783b(RequestBody requestBody) {
            return m15776a(HttpMethods.DELETE, requestBody);
        }

        /* JADX INFO: renamed from: b */
        public Builder m15780b() {
            return m15783b(Util.f15240d);
        }

        /* JADX INFO: renamed from: a */
        public Builder m15776a(String str, RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (requestBody != null && !HttpMethod.m15985c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (requestBody == null && HttpMethod.m15984b(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.f15189b = str;
            this.f15191d = requestBody;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public Request m15784c() {
            if (this.f15188a == null) {
                throw new IllegalStateException("url == null");
            }
            return new Request(this);
        }
    }
}
