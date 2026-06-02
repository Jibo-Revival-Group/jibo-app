package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public final class Http1Codec implements HttpCodec {

    /* JADX INFO: renamed from: a */
    final OkHttpClient f15386a;

    /* JADX INFO: renamed from: b */
    final StreamAllocation f15387b;

    /* JADX INFO: renamed from: c */
    final BufferedSource f15388c;

    /* JADX INFO: renamed from: d */
    final BufferedSink f15389d;

    /* JADX INFO: renamed from: e */
    int f15390e = 0;

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f15386a = okHttpClient;
        this.f15387b = streamAllocation;
        this.f15388c = bufferedSource;
        this.f15389d = bufferedSink;
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: a */
    public Sink mo15960a(Request request, long j) {
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(request.m15764a("Transfer-Encoding"))) {
            return m16010e();
        }
        if (j != -1) {
            return m16004a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: c */
    public void mo15964c() {
        RealConnection realConnectionM15952b = this.f15387b.m15952b();
        if (realConnectionM15952b != null) {
            realConnectionM15952b.m15919c();
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: a */
    public void mo15962a(Request request) throws IOException {
        m16006a(request.m15768c(), RequestLine.m15992a(request, this.f15387b.m15952b().mo15554a().m15828b().type()));
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: a */
    public ResponseBody mo15959a(Response response) throws IOException {
        return new RealResponseBody(response.m15797g(), Okio.m16360a(m16003b(response)));
    }

    /* JADX INFO: renamed from: b */
    private Source m16003b(Response response) throws IOException {
        if (!HttpHeaders.m15981d(response)) {
            return m16008b(0L);
        }
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(response.m15789a("Transfer-Encoding"))) {
            return m16005a(response.m15791a().m15765a());
        }
        long jM15972a = HttpHeaders.m15972a(response);
        if (jM15972a != -1) {
            return m16008b(jM15972a);
        }
        return m16011f();
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: a */
    public void mo15961a() throws IOException {
        this.f15389d.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: b */
    public void mo15963b() throws IOException {
        this.f15389d.flush();
    }

    /* JADX INFO: renamed from: a */
    public void m16006a(Headers headers, String str) throws IOException {
        if (this.f15390e != 0) {
            throw new IllegalStateException("state: " + this.f15390e);
        }
        this.f15389d.mo16267b(str).mo16267b("\r\n");
        int iM15617a = headers.m15617a();
        for (int i = 0; i < iM15617a; i++) {
            this.f15389d.mo16267b(headers.m15618a(i)).mo16267b(": ").mo16267b(headers.m15620b(i)).mo16267b("\r\n");
        }
        this.f15389d.mo16267b("\r\n");
        this.f15390e = 1;
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: a */
    public Response.Builder mo15958a(boolean z) throws IOException {
        if (this.f15390e != 1 && this.f15390e != 3) {
            throw new IllegalStateException("state: " + this.f15390e);
        }
        try {
            StatusLine statusLineM16002a = StatusLine.m16002a(this.f15388c.mo16307r());
            Response.Builder builderM15811a = new Response.Builder().m15812a(statusLineM16002a.f15383a).m15806a(statusLineM16002a.f15384b).m15808a(statusLineM16002a.f15385c).m15811a(m16009d());
            if (z && statusLineM16002a.f15384b == 100) {
                return null;
            }
            this.f15390e = 4;
            return builderM15811a;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f15387b);
            iOException.initCause(e);
            throw iOException;
        }
    }

    /* JADX INFO: renamed from: d */
    public Headers m16009d() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String strMo16307r = this.f15388c.mo16307r();
            if (strMo16307r.length() != 0) {
                Internal.f15235a.mo15737a(builder, strMo16307r);
            } else {
                return builder.m15626a();
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public Sink m16010e() {
        if (this.f15390e != 1) {
            throw new IllegalStateException("state: " + this.f15390e);
        }
        this.f15390e = 2;
        return new ChunkedSink();
    }

    /* JADX INFO: renamed from: a */
    public Sink m16004a(long j) {
        if (this.f15390e != 1) {
            throw new IllegalStateException("state: " + this.f15390e);
        }
        this.f15390e = 2;
        return new FixedLengthSink(j);
    }

    /* JADX INFO: renamed from: b */
    public Source m16008b(long j) throws IOException {
        if (this.f15390e != 4) {
            throw new IllegalStateException("state: " + this.f15390e);
        }
        this.f15390e = 5;
        return new FixedLengthSource(j);
    }

    /* JADX INFO: renamed from: a */
    public Source m16005a(HttpUrl httpUrl) throws IOException {
        if (this.f15390e != 4) {
            throw new IllegalStateException("state: " + this.f15390e);
        }
        this.f15390e = 5;
        return new ChunkedSource(httpUrl);
    }

    /* JADX INFO: renamed from: f */
    public Source m16011f() throws IOException {
        if (this.f15390e != 4) {
            throw new IllegalStateException("state: " + this.f15390e);
        }
        if (this.f15387b == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f15390e = 5;
        this.f15387b.m15954d();
        return new UnknownLengthSource();
    }

    /* JADX INFO: renamed from: a */
    void m16007a(ForwardingTimeout forwardingTimeout) {
        Timeout timeoutM16341a = forwardingTimeout.m16341a();
        forwardingTimeout.m16340a(Timeout.f15695c);
        timeoutM16341a.mo16345f();
        timeoutM16341a.mo16349z_();
    }

    private final class FixedLengthSink implements Sink {

        /* JADX INFO: renamed from: b */
        private final ForwardingTimeout f15402b;

        /* JADX INFO: renamed from: c */
        private boolean f15403c;

        /* JADX INFO: renamed from: d */
        private long f15404d;

        FixedLengthSink(long j) {
            this.f15402b = new ForwardingTimeout(Http1Codec.this.f15389d.mo16013a());
            this.f15404d = j;
        }

        @Override // okio.Sink
        /* JADX INFO: renamed from: a */
        public Timeout mo16013a() {
            return this.f15402b;
        }

        @Override // okio.Sink
        /* JADX INFO: renamed from: a_ */
        public void mo15902a_(Buffer buffer, long j) throws IOException {
            if (this.f15403c) {
                throw new IllegalStateException("closed");
            }
            Util.m15842a(buffer.m16263b(), 0L, j);
            if (j > this.f15404d) {
                throw new ProtocolException("expected " + this.f15404d + " bytes but received " + j);
            }
            Http1Codec.this.f15389d.mo15902a_(buffer, j);
            this.f15404d -= j;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (!this.f15403c) {
                Http1Codec.this.f15389d.flush();
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f15403c) {
                this.f15403c = true;
                if (this.f15404d > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                Http1Codec.this.m16007a(this.f15402b);
                Http1Codec.this.f15390e = 3;
            }
        }
    }

    private final class ChunkedSink implements Sink {

        /* JADX INFO: renamed from: b */
        private final ForwardingTimeout f15395b;

        /* JADX INFO: renamed from: c */
        private boolean f15396c;

        ChunkedSink() {
            this.f15395b = new ForwardingTimeout(Http1Codec.this.f15389d.mo16013a());
        }

        @Override // okio.Sink
        /* JADX INFO: renamed from: a */
        public Timeout mo16013a() {
            return this.f15395b;
        }

        @Override // okio.Sink
        /* JADX INFO: renamed from: a_ */
        public void mo15902a_(Buffer buffer, long j) throws IOException {
            if (this.f15396c) {
                throw new IllegalStateException("closed");
            }
            if (j != 0) {
                Http1Codec.this.f15389d.mo16299l(j);
                Http1Codec.this.f15389d.mo16267b("\r\n");
                Http1Codec.this.f15389d.mo15902a_(buffer, j);
                Http1Codec.this.f15389d.mo16267b("\r\n");
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (!this.f15396c) {
                Http1Codec.this.f15389d.flush();
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (!this.f15396c) {
                this.f15396c = true;
                Http1Codec.this.f15389d.mo16267b("0\r\n\r\n");
                Http1Codec.this.m16007a(this.f15395b);
                Http1Codec.this.f15390e = 3;
            }
        }
    }

    private abstract class AbstractSource implements Source {

        /* JADX INFO: renamed from: a */
        protected final ForwardingTimeout f15391a;

        /* JADX INFO: renamed from: b */
        protected boolean f15392b;

        private AbstractSource() {
            this.f15391a = new ForwardingTimeout(Http1Codec.this.f15388c.mo15864a());
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: a */
        public Timeout mo15864a() {
            return this.f15391a;
        }

        /* JADX INFO: renamed from: a */
        protected final void m16012a(boolean z) throws IOException {
            if (Http1Codec.this.f15390e != 6) {
                if (Http1Codec.this.f15390e != 5) {
                    throw new IllegalStateException("state: " + Http1Codec.this.f15390e);
                }
                Http1Codec.this.m16007a(this.f15391a);
                Http1Codec.this.f15390e = 6;
                if (Http1Codec.this.f15387b != null) {
                    Http1Codec.this.f15387b.m15950a(!z, Http1Codec.this);
                }
            }
        }
    }

    private class FixedLengthSource extends AbstractSource {

        /* JADX INFO: renamed from: e */
        private long f15406e;

        FixedLengthSource(long j) throws IOException {
            super();
            this.f15406e = j;
            if (this.f15406e == 0) {
                m16012a(true);
            }
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: a */
        public long mo15863a(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f15392b) {
                throw new IllegalStateException("closed");
            }
            if (this.f15406e == 0) {
                return -1L;
            }
            long jA = Http1Codec.this.f15388c.mo15863a(buffer, Math.min(this.f15406e, j));
            if (jA == -1) {
                m16012a(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.f15406e -= jA;
            if (this.f15406e == 0) {
                m16012a(true);
            }
            return jA;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f15392b) {
                if (this.f15406e != 0 && !Util.m15847a(this, 100, TimeUnit.MILLISECONDS)) {
                    m16012a(false);
                }
                this.f15392b = true;
            }
        }
    }

    private class ChunkedSource extends AbstractSource {

        /* JADX INFO: renamed from: e */
        private final HttpUrl f15398e;

        /* JADX INFO: renamed from: f */
        private long f15399f;

        /* JADX INFO: renamed from: g */
        private boolean f15400g;

        ChunkedSource(HttpUrl httpUrl) {
            super();
            this.f15399f = -1L;
            this.f15400g = true;
            this.f15398e = httpUrl;
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: a */
        public long mo15863a(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f15392b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f15400g) {
                return -1L;
            }
            if (this.f15399f == 0 || this.f15399f == -1) {
                m16014b();
                if (!this.f15400g) {
                    return -1L;
                }
            }
            long jA = Http1Codec.this.f15388c.mo15863a(buffer, Math.min(j, this.f15399f));
            if (jA == -1) {
                m16012a(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.f15399f -= jA;
            return jA;
        }

        /* JADX INFO: renamed from: b */
        private void m16014b() throws IOException {
            if (this.f15399f != -1) {
                Http1Codec.this.f15388c.mo16307r();
            }
            try {
                this.f15399f = Http1Codec.this.f15388c.mo16304o();
                String strTrim = Http1Codec.this.f15388c.mo16307r().trim();
                if (this.f15399f < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f15399f + strTrim + "\"");
                }
                if (this.f15399f == 0) {
                    this.f15400g = false;
                    HttpHeaders.m15974a(Http1Codec.this.f15386a.m15712f(), this.f15398e, Http1Codec.this.m16009d());
                    m16012a(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f15392b) {
                if (this.f15400g && !Util.m15847a(this, 100, TimeUnit.MILLISECONDS)) {
                    m16012a(false);
                }
                this.f15392b = true;
            }
        }
    }

    private class UnknownLengthSource extends AbstractSource {

        /* JADX INFO: renamed from: e */
        private boolean f15408e;

        UnknownLengthSource() {
            super();
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: a */
        public long mo15863a(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f15392b) {
                throw new IllegalStateException("closed");
            }
            if (this.f15408e) {
                return -1L;
            }
            long jA = Http1Codec.this.f15388c.mo15863a(buffer, j);
            if (jA != -1) {
                return jA;
            }
            this.f15408e = true;
            m16012a(true);
            return -1L;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f15392b) {
                if (!this.f15408e) {
                    m16012a(false);
                }
                this.f15392b = true;
            }
        }
    }
}
