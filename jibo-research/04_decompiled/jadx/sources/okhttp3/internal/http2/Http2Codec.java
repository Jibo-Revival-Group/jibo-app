package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes2.dex */
public final class Http2Codec implements HttpCodec {

    /* JADX INFO: renamed from: b */
    private static final ByteString f15442b = ByteString.m16317a("connection");

    /* JADX INFO: renamed from: c */
    private static final ByteString f15443c = ByteString.m16317a("host");

    /* JADX INFO: renamed from: d */
    private static final ByteString f15444d = ByteString.m16317a("keep-alive");

    /* JADX INFO: renamed from: e */
    private static final ByteString f15445e = ByteString.m16317a("proxy-connection");

    /* JADX INFO: renamed from: f */
    private static final ByteString f15446f = ByteString.m16317a("transfer-encoding");

    /* JADX INFO: renamed from: g */
    private static final ByteString f15447g = ByteString.m16317a("te");

    /* JADX INFO: renamed from: h */
    private static final ByteString f15448h = ByteString.m16317a("encoding");

    /* JADX INFO: renamed from: i */
    private static final ByteString f15449i = ByteString.m16317a("upgrade");

    /* JADX INFO: renamed from: j */
    private static final List<ByteString> f15450j = Util.m15840a(f15442b, f15443c, f15444d, f15445e, f15447g, f15446f, f15448h, f15449i, Header.f15411c, Header.f15412d, Header.f15413e, Header.f15414f);

    /* JADX INFO: renamed from: k */
    private static final List<ByteString> f15451k = Util.m15840a(f15442b, f15443c, f15444d, f15445e, f15447g, f15446f, f15448h, f15449i);

    /* JADX INFO: renamed from: a */
    final StreamAllocation f15452a;

    /* JADX INFO: renamed from: l */
    private final OkHttpClient f15453l;

    /* JADX INFO: renamed from: m */
    private final Http2Connection f15454m;

    /* JADX INFO: renamed from: n */
    private Http2Stream f15455n;

    public Http2Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.f15453l = okHttpClient;
        this.f15452a = streamAllocation;
        this.f15454m = http2Connection;
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: a */
    public Sink mo15960a(Request request, long j) {
        return this.f15455n.m16116h();
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: a */
    public void mo15962a(Request request) throws IOException {
        if (this.f15455n == null) {
            this.f15455n = this.f15454m.m16051a(m16047b(request), request.m15769d() != null);
            this.f15455n.m16113e().mo16343a(this.f15453l.m15708b(), TimeUnit.MILLISECONDS);
            this.f15455n.m16114f().mo16343a(this.f15453l.m15709c(), TimeUnit.MILLISECONDS);
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: a */
    public void mo15961a() throws IOException {
        this.f15454m.m16064b();
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: b */
    public void mo15963b() throws IOException {
        this.f15455n.m16116h().close();
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: a */
    public Response.Builder mo15958a(boolean z) throws IOException {
        Response.Builder builderM16046a = m16046a(this.f15455n.m16112d());
        if (z && Internal.f15235a.mo15732a(builderM16046a) == 100) {
            return null;
        }
        return builderM16046a;
    }

    /* JADX INFO: renamed from: b */
    public static List<Header> m16047b(Request request) {
        Headers headersM15768c = request.m15768c();
        ArrayList arrayList = new ArrayList(headersM15768c.m15617a() + 4);
        arrayList.add(new Header(Header.f15411c, request.m15766b()));
        arrayList.add(new Header(Header.f15412d, RequestLine.m15991a(request.m15765a())));
        String strM15764a = request.m15764a("Host");
        if (strM15764a != null) {
            arrayList.add(new Header(Header.f15414f, strM15764a));
        }
        arrayList.add(new Header(Header.f15413e, request.m15765a().m15648c()));
        int iM15617a = headersM15768c.m15617a();
        for (int i = 0; i < iM15617a; i++) {
            ByteString byteStringM16317a = ByteString.m16317a(headersM15768c.m15618a(i).toLowerCase(Locale.US));
            if (!f15450j.contains(byteStringM16317a)) {
                arrayList.add(new Header(byteStringM16317a, headersM15768c.m15620b(i)));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public static Response.Builder m16046a(List<Header> list) throws IOException {
        StatusLine statusLineM16002a;
        Headers.Builder builder;
        Headers.Builder builder2 = new Headers.Builder();
        int size = list.size();
        int i = 0;
        StatusLine statusLine = null;
        while (i < size) {
            Header header = list.get(i);
            if (header == null) {
                if (statusLine == null || statusLine.f15384b != 100) {
                    builder = builder2;
                    statusLineM16002a = statusLine;
                } else {
                    builder = new Headers.Builder();
                    statusLineM16002a = null;
                }
            } else {
                ByteString byteString = header.f15415g;
                String strMo16323a = header.f15416h.mo16323a();
                if (byteString.equals(Header.f15410b)) {
                    Headers.Builder builder3 = builder2;
                    statusLineM16002a = StatusLine.m16002a("HTTP/1.1 " + strMo16323a);
                    builder = builder3;
                } else {
                    if (!f15451k.contains(byteString)) {
                        Internal.f15235a.mo15738a(builder2, byteString.mo16323a(), strMo16323a);
                    }
                    builder = builder2;
                    statusLineM16002a = statusLine;
                }
            }
            i++;
            statusLine = statusLineM16002a;
            builder2 = builder;
        }
        if (statusLine == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new Response.Builder().m15812a(Protocol.HTTP_2).m15806a(statusLine.f15384b).m15808a(statusLine.f15385c).m15811a(builder2.m15626a());
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: a */
    public ResponseBody mo15959a(Response response) throws IOException {
        return new RealResponseBody(response.m15797g(), Okio.m16360a(new StreamFinishingSource(this.f15455n.m16115g())));
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* JADX INFO: renamed from: c */
    public void mo15964c() {
        if (this.f15455n != null) {
            this.f15455n.m16108b(ErrorCode.CANCEL);
        }
    }

    class StreamFinishingSource extends ForwardingSource {
        StreamFinishingSource(Source source) {
            super(source);
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Codec.this.f15452a.m15950a(false, (HttpCodec) Http2Codec.this);
            super.close();
        }
    }
}
