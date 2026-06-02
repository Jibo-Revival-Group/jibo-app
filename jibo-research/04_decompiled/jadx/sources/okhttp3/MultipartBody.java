package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class MultipartBody extends RequestBody {

    /* JADX INFO: renamed from: a */
    public static final MediaType f15100a = MediaType.m15695a("multipart/mixed");

    /* JADX INFO: renamed from: b */
    public static final MediaType f15101b = MediaType.m15695a("multipart/alternative");

    /* JADX INFO: renamed from: c */
    public static final MediaType f15102c = MediaType.m15695a("multipart/digest");

    /* JADX INFO: renamed from: d */
    public static final MediaType f15103d = MediaType.m15695a("multipart/parallel");

    /* JADX INFO: renamed from: e */
    public static final MediaType f15104e = MediaType.m15695a("multipart/form-data");

    /* JADX INFO: renamed from: f */
    private static final byte[] f15105f = {58, 32};

    /* JADX INFO: renamed from: g */
    private static final byte[] f15106g = {13, 10};

    /* JADX INFO: renamed from: h */
    private static final byte[] f15107h = {45, 45};

    /* JADX INFO: renamed from: i */
    private final ByteString f15108i;

    /* JADX INFO: renamed from: j */
    private final MediaType f15109j;

    /* JADX INFO: renamed from: k */
    private final MediaType f15110k;

    /* JADX INFO: renamed from: l */
    private final List<Part> f15111l;

    /* JADX INFO: renamed from: m */
    private long f15112m = -1;

    MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        this.f15108i = byteString;
        this.f15109j = mediaType;
        this.f15110k = MediaType.m15695a(mediaType + "; boundary=" + byteString.mo16323a());
        this.f15111l = Util.m15839a(list);
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: a */
    public MediaType mo14283a() {
        return this.f15110k;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: b */
    public long mo14285b() throws IOException {
        long j = this.f15112m;
        if (j != -1) {
            return j;
        }
        long jM15699a = m15699a((BufferedSink) null, true);
        this.f15112m = jM15699a;
        return jM15699a;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: a */
    public void mo14284a(BufferedSink bufferedSink) throws IOException {
        m15699a(bufferedSink, false);
    }

    /* JADX INFO: renamed from: a */
    private long m15699a(BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        long j = 0;
        if (!z) {
            buffer = null;
        } else {
            Buffer buffer2 = new Buffer();
            buffer = buffer2;
            bufferedSink = buffer2;
        }
        int size = this.f15111l.size();
        for (int i = 0; i < size; i++) {
            Part part = this.f15111l.get(i);
            Headers headers = part.f15116a;
            RequestBody requestBody = part.f15117b;
            bufferedSink.mo16273c(f15107h);
            bufferedSink.mo16268b(this.f15108i);
            bufferedSink.mo16273c(f15106g);
            if (headers != null) {
                int iM15617a = headers.m15617a();
                for (int i2 = 0; i2 < iM15617a; i2++) {
                    bufferedSink.mo16267b(headers.m15618a(i2)).mo16273c(f15105f).mo16267b(headers.m15620b(i2)).mo16273c(f15106g);
                }
            }
            MediaType mediaTypeMo14283a = requestBody.mo14283a();
            if (mediaTypeMo14283a != null) {
                bufferedSink.mo16267b("Content-Type: ").mo16267b(mediaTypeMo14283a.toString()).mo16273c(f15106g);
            }
            long jMo14285b = requestBody.mo14285b();
            if (jMo14285b != -1) {
                bufferedSink.mo16267b("Content-Length: ").mo16302m(jMo14285b).mo16273c(f15106g);
            } else if (z) {
                buffer.m16310u();
                return -1L;
            }
            bufferedSink.mo16273c(f15106g);
            if (z) {
                j += jMo14285b;
            } else {
                requestBody.mo14284a(bufferedSink);
            }
            bufferedSink.mo16273c(f15106g);
        }
        bufferedSink.mo16273c(f15107h);
        bufferedSink.mo16268b(this.f15108i);
        bufferedSink.mo16273c(f15107h);
        bufferedSink.mo16273c(f15106g);
        if (z) {
            long jM16263b = j + buffer.m16263b();
            buffer.m16310u();
            return jM16263b;
        }
        return j;
    }

    public static final class Part {

        /* JADX INFO: renamed from: a */
        final Headers f15116a;

        /* JADX INFO: renamed from: b */
        final RequestBody f15117b;

        /* JADX INFO: renamed from: a */
        public static Part m15704a(Headers headers, RequestBody requestBody) {
            if (requestBody == null) {
                throw new NullPointerException("body == null");
            }
            if (headers != null && headers.m15619a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (headers != null && headers.m15619a("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new Part(headers, requestBody);
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.f15116a = headers;
            this.f15117b = requestBody;
        }
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        private final ByteString f15113a;

        /* JADX INFO: renamed from: b */
        private MediaType f15114b;

        /* JADX INFO: renamed from: c */
        private final List<Part> f15115c;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.f15114b = MultipartBody.f15100a;
            this.f15115c = new ArrayList();
            this.f15113a = ByteString.m16317a(str);
        }

        /* JADX INFO: renamed from: a */
        public Builder m15701a(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            }
            if (!mediaType.m15696a().equals("multipart")) {
                throw new IllegalArgumentException("multipart != " + mediaType);
            }
            this.f15114b = mediaType;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15700a(Headers headers, RequestBody requestBody) {
            return m15702a(Part.m15704a(headers, requestBody));
        }

        /* JADX INFO: renamed from: a */
        public Builder m15702a(Part part) {
            if (part == null) {
                throw new NullPointerException("part == null");
            }
            this.f15115c.add(part);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public MultipartBody m15703a() {
            if (this.f15115c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.f15113a, this.f15114b, this.f15115c);
        }
    }
}
