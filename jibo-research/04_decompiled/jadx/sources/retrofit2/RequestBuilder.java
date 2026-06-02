package retrofit2;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes2.dex */
final class RequestBuilder {

    /* JADX INFO: renamed from: a */
    private static final char[] f16294a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b */
    private final String f16295b;

    /* JADX INFO: renamed from: c */
    private final HttpUrl f16296c;

    /* JADX INFO: renamed from: d */
    private String f16297d;

    /* JADX INFO: renamed from: e */
    private HttpUrl.Builder f16298e;

    /* JADX INFO: renamed from: f */
    private final Request.Builder f16299f = new Request.Builder();

    /* JADX INFO: renamed from: g */
    private MediaType f16300g;

    /* JADX INFO: renamed from: h */
    private final boolean f16301h;

    /* JADX INFO: renamed from: i */
    private MultipartBody.Builder f16302i;

    /* JADX INFO: renamed from: j */
    private FormBody.Builder f16303j;

    /* JADX INFO: renamed from: k */
    private RequestBody f16304k;

    RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.f16295b = str;
        this.f16296c = httpUrl;
        this.f16297d = str2;
        this.f16300g = mediaType;
        this.f16301h = z;
        if (headers != null) {
            this.f16299f.m15777a(headers);
        }
        if (z2) {
            this.f16303j = new FormBody.Builder();
        } else if (z3) {
            this.f16302i = new MultipartBody.Builder();
            this.f16302i.m15701a(MultipartBody.f15104e);
        }
    }

    /* JADX INFO: renamed from: a */
    void m17111a(Object obj) {
        this.f16297d = obj.toString();
    }

    /* JADX INFO: renamed from: a */
    void m17112a(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            MediaType mediaTypeM15695a = MediaType.m15695a(str2);
            if (mediaTypeM15695a == null) {
                throw new IllegalArgumentException("Malformed content type: " + str2);
            }
            this.f16300g = mediaTypeM15695a;
            return;
        }
        this.f16299f.m15782b(str, str2);
    }

    /* JADX INFO: renamed from: a */
    void m17113a(String str, String str2, boolean z) {
        if (this.f16297d == null) {
            throw new AssertionError();
        }
        this.f16297d = this.f16297d.replace("{" + str + "}", m17108a(str2, z));
    }

    /* JADX INFO: renamed from: a */
    private static String m17108a(String str, boolean z) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt < 127 && " \"<>^`{}|\\?#".indexOf(iCodePointAt) == -1 && (z || (iCodePointAt != 47 && iCodePointAt != 37))) {
                iCharCount += Character.charCount(iCodePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.m16256a(str, 0, iCharCount);
                m17109a(buffer, str, iCharCount, length, z);
                return buffer.m16306q();
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    private static void m17109a(Buffer buffer, String str, int i, int i2, boolean z) {
        Buffer buffer2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.m16254a(iCodePointAt);
                    while (!buffer2.mo16283f()) {
                        int iMo16290i = buffer2.mo16290i() & 255;
                        buffer.mo16298k(37);
                        buffer.mo16298k((int) f16294a[(iMo16290i >> 4) & 15]);
                        buffer.mo16298k((int) f16294a[iMo16290i & 15]);
                    }
                } else {
                    buffer.m16254a(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    /* JADX INFO: renamed from: b */
    void m17117b(String str, String str2, boolean z) {
        if (this.f16297d != null) {
            this.f16298e = this.f16296c.m15650d(this.f16297d);
            if (this.f16298e == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f16296c + ", Relative: " + this.f16297d);
            }
            this.f16297d = null;
        }
        if (z) {
            this.f16298e.m15685b(str, str2);
        } else {
            this.f16298e.m15682a(str, str2);
        }
    }

    /* JADX INFO: renamed from: c */
    void m17118c(String str, String str2, boolean z) {
        if (z) {
            this.f16303j.m15608b(str, str2);
        } else {
            this.f16303j.m15606a(str, str2);
        }
    }

    /* JADX INFO: renamed from: a */
    void m17114a(Headers headers, RequestBody requestBody) {
        this.f16302i.m15700a(headers, requestBody);
    }

    /* JADX INFO: renamed from: a */
    void m17115a(MultipartBody.Part part) {
        this.f16302i.m15702a(part);
    }

    /* JADX INFO: renamed from: a */
    void m17116a(RequestBody requestBody) {
        this.f16304k = requestBody;
    }

    /* JADX INFO: renamed from: a */
    Request m17110a() {
        HttpUrl httpUrlM15649c;
        HttpUrl.Builder builder = this.f16298e;
        if (builder != null) {
            httpUrlM15649c = builder.m15687c();
        } else {
            httpUrlM15649c = this.f16296c.m15649c(this.f16297d);
            if (httpUrlM15649c == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f16296c + ", Relative: " + this.f16297d);
            }
        }
        RequestBody contentTypeOverridingRequestBody = this.f16304k;
        if (contentTypeOverridingRequestBody == null) {
            if (this.f16303j != null) {
                contentTypeOverridingRequestBody = this.f16303j.m15607a();
            } else if (this.f16302i != null) {
                contentTypeOverridingRequestBody = this.f16302i.m15703a();
            } else if (this.f16301h) {
                contentTypeOverridingRequestBody = RequestBody.m15787a((MediaType) null, new byte[0]);
            }
        }
        MediaType mediaType = this.f16300g;
        if (mediaType != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, mediaType);
            } else {
                this.f16299f.m15782b("Content-Type", mediaType.toString());
            }
        }
        return this.f16299f.m15778a(httpUrlM15649c).m15776a(this.f16295b, contentTypeOverridingRequestBody).m15784c();
    }

    private static class ContentTypeOverridingRequestBody extends RequestBody {

        /* JADX INFO: renamed from: a */
        private final RequestBody f16305a;

        /* JADX INFO: renamed from: b */
        private final MediaType f16306b;

        ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.f16305a = requestBody;
            this.f16306b = mediaType;
        }

        @Override // okhttp3.RequestBody
        /* JADX INFO: renamed from: a */
        public MediaType mo14283a() {
            return this.f16306b;
        }

        @Override // okhttp3.RequestBody
        /* JADX INFO: renamed from: b */
        public long mo14285b() throws IOException {
            return this.f16305a.mo14285b();
        }

        @Override // okhttp3.RequestBody
        /* JADX INFO: renamed from: a */
        public void mo14284a(BufferedSink bufferedSink) throws IOException {
            this.f16305a.mo14284a(bufferedSink);
        }
    }
}
