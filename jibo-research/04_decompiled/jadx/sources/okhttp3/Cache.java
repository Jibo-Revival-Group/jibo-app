package okhttp3;

import com.google.api.client.http.HttpMethods;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.p026io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes2.dex */
public final class Cache implements Closeable, Flushable {

    /* JADX INFO: renamed from: a */
    final InternalCache f14840a;

    /* JADX INFO: renamed from: b */
    final DiskLruCache f14841b;

    /* JADX INFO: renamed from: c */
    int f14842c;

    /* JADX INFO: renamed from: d */
    int f14843d;

    /* JADX INFO: renamed from: e */
    private int f14844e;

    /* JADX INFO: renamed from: f */
    private int f14845f;

    /* JADX INFO: renamed from: g */
    private int f14846g;

    public Cache(File file, long j) {
        this(file, j, FileSystem.f15578a);
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.f14840a = new InternalCache() { // from class: okhttp3.Cache.1
            @Override // okhttp3.internal.cache.InternalCache
            /* JADX INFO: renamed from: a */
            public Response mo15503a(Request request) throws IOException {
                return Cache.this.m15497a(request);
            }

            @Override // okhttp3.internal.cache.InternalCache
            /* JADX INFO: renamed from: a */
            public CacheRequest mo15504a(Response response) throws IOException {
                return Cache.this.m15498a(response);
            }

            @Override // okhttp3.internal.cache.InternalCache
            /* JADX INFO: renamed from: b */
            public void mo15508b(Request request) throws IOException {
                Cache.this.m15502b(request);
            }

            @Override // okhttp3.internal.cache.InternalCache
            /* JADX INFO: renamed from: a */
            public void mo15506a(Response response, Response response2) {
                Cache.this.m15500a(response, response2);
            }

            @Override // okhttp3.internal.cache.InternalCache
            /* JADX INFO: renamed from: a */
            public void mo15505a() {
                Cache.this.m15499a();
            }

            @Override // okhttp3.internal.cache.InternalCache
            /* JADX INFO: renamed from: a */
            public void mo15507a(CacheStrategy cacheStrategy) {
                Cache.this.m15501a(cacheStrategy);
            }
        };
        this.f14841b = DiskLruCache.m15872a(fileSystem, file, 201105, 2, j);
    }

    /* JADX INFO: renamed from: a */
    public static String m15495a(HttpUrl httpUrl) {
        return ByteString.m16317a(httpUrl.toString()).mo16331c().mo16334f();
    }

    /* JADX INFO: renamed from: a */
    Response m15497a(Request request) {
        try {
            DiskLruCache.Snapshot snapshotM15880a = this.f14841b.m15880a(m15495a(request.m15765a()));
            if (snapshotM15880a == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshotM15880a.m15901a(0));
                Response responseM15517a = entry.m15517a(snapshotM15880a);
                if (entry.m15519a(request, responseM15517a)) {
                    return responseM15517a;
                }
                Util.m15843a(responseM15517a.m15798h());
                return null;
            } catch (IOException e) {
                Util.m15843a(snapshotM15880a);
                return null;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    CacheRequest m15498a(Response response) {
        DiskLruCache.Editor editor;
        String strM15766b = response.m15791a().m15766b();
        if (HttpMethod.m15983a(response.m15791a().m15766b())) {
            try {
                m15502b(response.m15791a());
                return null;
            } catch (IOException e) {
                return null;
            }
        }
        if (!strM15766b.equals(HttpMethods.GET) || HttpHeaders.m15978b(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            DiskLruCache.Editor editorM15884b = this.f14841b.m15884b(m15495a(response.m15791a().m15765a()));
            if (editorM15884b == null) {
                return null;
            }
            try {
                entry.m15518a(editorM15884b);
                return new CacheRequestImpl(editorM15884b);
            } catch (IOException e2) {
                editor = editorM15884b;
                m15496a(editor);
                return null;
            }
        } catch (IOException e3) {
            editor = null;
        }
    }

    /* JADX INFO: renamed from: b */
    void m15502b(Request request) throws IOException {
        this.f14841b.m15887c(m15495a(request.m15765a()));
    }

    /* JADX INFO: renamed from: a */
    void m15500a(Response response, Response response2) {
        Entry entry = new Entry(response2);
        DiskLruCache.Editor editorM15900a = null;
        try {
            editorM15900a = ((CacheResponseBody) response.m15798h()).f14856a.m15900a();
            if (editorM15900a != null) {
                entry.m15518a(editorM15900a);
                editorM15900a.m15894b();
            }
        } catch (IOException e) {
            m15496a(editorM15900a);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m15496a(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.m15895c();
            } catch (IOException e) {
            }
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f14841b.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f14841b.close();
    }

    /* JADX INFO: renamed from: a */
    synchronized void m15501a(CacheStrategy cacheStrategy) {
        this.f14846g++;
        if (cacheStrategy.f15262a != null) {
            this.f14844e++;
        } else if (cacheStrategy.f15263b != null) {
            this.f14845f++;
        }
    }

    /* JADX INFO: renamed from: a */
    synchronized void m15499a() {
        this.f14845f++;
    }

    private final class CacheRequestImpl implements CacheRequest {

        /* JADX INFO: renamed from: a */
        boolean f14848a;

        /* JADX INFO: renamed from: c */
        private final DiskLruCache.Editor f14850c;

        /* JADX INFO: renamed from: d */
        private Sink f14851d;

        /* JADX INFO: renamed from: e */
        private Sink f14852e;

        CacheRequestImpl(final DiskLruCache.Editor editor) {
            this.f14850c = editor;
            this.f14851d = editor.m15892a(1);
            this.f14852e = new ForwardingSink(this.f14851d) { // from class: okhttp3.Cache.CacheRequestImpl.1
                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    synchronized (Cache.this) {
                        if (!CacheRequestImpl.this.f14848a) {
                            CacheRequestImpl.this.f14848a = true;
                            Cache.this.f14842c++;
                            super.close();
                            editor.m15894b();
                        }
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        /* JADX INFO: renamed from: a */
        public void mo15509a() {
            synchronized (Cache.this) {
                if (!this.f14848a) {
                    this.f14848a = true;
                    Cache.this.f14843d++;
                    Util.m15843a(this.f14851d);
                    try {
                        this.f14850c.m15895c();
                    } catch (IOException e) {
                    }
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        /* JADX INFO: renamed from: b */
        public Sink mo15510b() {
            return this.f14852e;
        }
    }

    private static final class Entry {

        /* JADX INFO: renamed from: a */
        private static final String f14862a = Platform.m16203b().m16205c() + "-Sent-Millis";

        /* JADX INFO: renamed from: b */
        private static final String f14863b = Platform.m16203b().m16205c() + "-Received-Millis";

        /* JADX INFO: renamed from: c */
        private final String f14864c;

        /* JADX INFO: renamed from: d */
        private final Headers f14865d;

        /* JADX INFO: renamed from: e */
        private final String f14866e;

        /* JADX INFO: renamed from: f */
        private final Protocol f14867f;

        /* JADX INFO: renamed from: g */
        private final int f14868g;

        /* JADX INFO: renamed from: h */
        private final String f14869h;

        /* JADX INFO: renamed from: i */
        private final Headers f14870i;

        /* JADX INFO: renamed from: j */
        private final Handshake f14871j;

        /* JADX INFO: renamed from: k */
        private final long f14872k;

        /* JADX INFO: renamed from: l */
        private final long f14873l;

        Entry(Source source) throws IOException {
            TlsVersion tlsVersionForJavaName;
            try {
                BufferedSource bufferedSourceM16360a = Okio.m16360a(source);
                this.f14864c = bufferedSourceM16360a.mo16307r();
                this.f14866e = bufferedSourceM16360a.mo16307r();
                Headers.Builder builder = new Headers.Builder();
                int iM15494a = Cache.m15494a(bufferedSourceM16360a);
                for (int i = 0; i < iM15494a; i++) {
                    builder.m15624a(bufferedSourceM16360a.mo16307r());
                }
                this.f14865d = builder.m15626a();
                StatusLine statusLineM16002a = StatusLine.m16002a(bufferedSourceM16360a.mo16307r());
                this.f14867f = statusLineM16002a.f15383a;
                this.f14868g = statusLineM16002a.f15384b;
                this.f14869h = statusLineM16002a.f15385c;
                Headers.Builder builder2 = new Headers.Builder();
                int iM15494a2 = Cache.m15494a(bufferedSourceM16360a);
                for (int i2 = 0; i2 < iM15494a2; i2++) {
                    builder2.m15624a(bufferedSourceM16360a.mo16307r());
                }
                String strM15629c = builder2.m15629c(f14862a);
                String strM15629c2 = builder2.m15629c(f14863b);
                builder2.m15627b(f14862a);
                builder2.m15627b(f14863b);
                this.f14872k = strM15629c != null ? Long.parseLong(strM15629c) : 0L;
                this.f14873l = strM15629c2 != null ? Long.parseLong(strM15629c2) : 0L;
                this.f14870i = builder2.m15626a();
                if (m15516a()) {
                    String strMo16307r = bufferedSourceM16360a.mo16307r();
                    if (strMo16307r.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strMo16307r + "\"");
                    }
                    CipherSuite cipherSuiteM15550a = CipherSuite.m15550a(bufferedSourceM16360a.mo16307r());
                    List<Certificate> listM15514a = m15514a(bufferedSourceM16360a);
                    List<Certificate> listM15514a2 = m15514a(bufferedSourceM16360a);
                    if (!bufferedSourceM16360a.mo16283f()) {
                        tlsVersionForJavaName = TlsVersion.forJavaName(bufferedSourceM16360a.mo16307r());
                    } else {
                        tlsVersionForJavaName = TlsVersion.SSL_3_0;
                    }
                    this.f14871j = Handshake.m15610a(tlsVersionForJavaName, cipherSuiteM15550a, listM15514a, listM15514a2);
                } else {
                    this.f14871j = null;
                }
            } finally {
                source.close();
            }
        }

        Entry(Response response) {
            this.f14864c = response.m15791a().m15765a().toString();
            this.f14865d = HttpHeaders.m15980c(response);
            this.f14866e = response.m15791a().m15766b();
            this.f14867f = response.m15792b();
            this.f14868g = response.m15793c();
            this.f14869h = response.m15795e();
            this.f14870i = response.m15797g();
            this.f14871j = response.m15796f();
            this.f14872k = response.m15802l();
            this.f14873l = response.m15803m();
        }

        /* JADX INFO: renamed from: a */
        public void m15518a(DiskLruCache.Editor editor) throws IOException {
            BufferedSink bufferedSinkM16359a = Okio.m16359a(editor.m15892a(0));
            bufferedSinkM16359a.mo16267b(this.f14864c).mo16298k(10);
            bufferedSinkM16359a.mo16267b(this.f14866e).mo16298k(10);
            bufferedSinkM16359a.mo16302m(this.f14865d.m15617a()).mo16298k(10);
            int iM15617a = this.f14865d.m15617a();
            for (int i = 0; i < iM15617a; i++) {
                bufferedSinkM16359a.mo16267b(this.f14865d.m15618a(i)).mo16267b(": ").mo16267b(this.f14865d.m15620b(i)).mo16298k(10);
            }
            bufferedSinkM16359a.mo16267b(new StatusLine(this.f14867f, this.f14868g, this.f14869h).toString()).mo16298k(10);
            bufferedSinkM16359a.mo16302m(this.f14870i.m15617a() + 2).mo16298k(10);
            int iM15617a2 = this.f14870i.m15617a();
            for (int i2 = 0; i2 < iM15617a2; i2++) {
                bufferedSinkM16359a.mo16267b(this.f14870i.m15618a(i2)).mo16267b(": ").mo16267b(this.f14870i.m15620b(i2)).mo16298k(10);
            }
            bufferedSinkM16359a.mo16267b(f14862a).mo16267b(": ").mo16302m(this.f14872k).mo16298k(10);
            bufferedSinkM16359a.mo16267b(f14863b).mo16267b(": ").mo16302m(this.f14873l).mo16298k(10);
            if (m15516a()) {
                bufferedSinkM16359a.mo16298k(10);
                bufferedSinkM16359a.mo16267b(this.f14871j.m15612b().m15552a()).mo16298k(10);
                m15515a(bufferedSinkM16359a, this.f14871j.m15613c());
                m15515a(bufferedSinkM16359a, this.f14871j.m15614d());
                bufferedSinkM16359a.mo16267b(this.f14871j.m15611a().javaName()).mo16298k(10);
            }
            bufferedSinkM16359a.close();
        }

        /* JADX INFO: renamed from: a */
        private boolean m15516a() {
            return this.f14864c.startsWith("https://");
        }

        /* JADX INFO: renamed from: a */
        private List<Certificate> m15514a(BufferedSource bufferedSource) throws IOException {
            int iM15494a = Cache.m15494a(bufferedSource);
            if (iM15494a == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iM15494a);
                for (int i = 0; i < iM15494a; i++) {
                    String strMo16307r = bufferedSource.mo16307r();
                    Buffer buffer = new Buffer();
                    buffer.mo16268b(ByteString.m16319b(strMo16307r));
                    arrayList.add(certificateFactory.generateCertificate(buffer.mo16284g()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* JADX INFO: renamed from: a */
        private void m15515a(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.mo16302m(list.size()).mo16298k(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.mo16267b(ByteString.m16318a(list.get(i).getEncoded()).mo16330b()).mo16298k(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean m15519a(Request request, Response response) {
            return this.f14864c.equals(request.m15765a().toString()) && this.f14866e.equals(request.m15766b()) && HttpHeaders.m15975a(response, this.f14865d, request);
        }

        /* JADX INFO: renamed from: a */
        public Response m15517a(DiskLruCache.Snapshot snapshot) {
            String strM15619a = this.f14870i.m15619a("Content-Type");
            String strM15619a2 = this.f14870i.m15619a("Content-Length");
            return new Response.Builder().m15813a(new Request.Builder().m15774a(this.f14864c).m15776a(this.f14866e, (RequestBody) null).m15777a(this.f14865d).m15784c()).m15812a(this.f14867f).m15806a(this.f14868g).m15808a(this.f14869h).m15811a(this.f14870i).m15815a(new CacheResponseBody(snapshot, strM15619a, strM15619a2)).m15810a(this.f14871j).m15807a(this.f14872k).m15817b(this.f14873l).m15816a();
        }
    }

    /* JADX INFO: renamed from: a */
    static int m15494a(BufferedSource bufferedSource) throws IOException {
        try {
            long jMo16303n = bufferedSource.mo16303n();
            String strMo16307r = bufferedSource.mo16307r();
            if (jMo16303n < 0 || jMo16303n > 2147483647L || !strMo16307r.isEmpty()) {
                throw new IOException("expected an int but was \"" + jMo16303n + strMo16307r + "\"");
            }
            return (int) jMo16303n;
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    private static class CacheResponseBody extends ResponseBody {

        /* JADX INFO: renamed from: a */
        final DiskLruCache.Snapshot f14856a;

        /* JADX INFO: renamed from: b */
        private final BufferedSource f14857b;

        /* JADX INFO: renamed from: c */
        private final String f14858c;

        /* JADX INFO: renamed from: d */
        private final String f14859d;

        CacheResponseBody(final DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.f14856a = snapshot;
            this.f14858c = str;
            this.f14859d = str2;
            this.f14857b = Okio.m16360a(new ForwardingSource(snapshot.m15901a(1)) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: a */
        public MediaType mo15511a() {
            if (this.f14858c != null) {
                return MediaType.m15695a(this.f14858c);
            }
            return null;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: b */
        public long mo15512b() {
            try {
                if (this.f14859d != null) {
                    return Long.parseLong(this.f14859d);
                }
                return -1L;
            } catch (NumberFormatException e) {
                return -1L;
            }
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: c */
        public BufferedSource mo15513c() {
            return this.f14857b;
        }
    }
}
