package okhttp3.internal.http2;

import com.google.api.client.http.HttpMethods;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes2.dex */
final class Hpack {

    /* JADX INFO: renamed from: a */
    static final Header[] f15418a = {new Header(Header.f15414f, ""), new Header(Header.f15411c, HttpMethods.GET), new Header(Header.f15411c, HttpMethods.POST), new Header(Header.f15412d, "/"), new Header(Header.f15412d, "/index.html"), new Header(Header.f15413e, HttpHost.DEFAULT_SCHEME_NAME), new Header(Header.f15413e, "https"), new Header(Header.f15410b, "200"), new Header(Header.f15410b, "204"), new Header(Header.f15410b, "206"), new Header(Header.f15410b, "304"), new Header(Header.f15410b, "400"), new Header(Header.f15410b, "404"), new Header(Header.f15410b, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(SkillsJsonParser.TYPE_LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};

    /* JADX INFO: renamed from: b */
    static final Map<ByteString, Integer> f15419b = m16015a();

    static final class Reader {

        /* JADX INFO: renamed from: a */
        Header[] f15420a;

        /* JADX INFO: renamed from: b */
        int f15421b;

        /* JADX INFO: renamed from: c */
        int f15422c;

        /* JADX INFO: renamed from: d */
        int f15423d;

        /* JADX INFO: renamed from: e */
        private final List<Header> f15424e;

        /* JADX INFO: renamed from: f */
        private final BufferedSource f15425f;

        /* JADX INFO: renamed from: g */
        private final int f15426g;

        /* JADX INFO: renamed from: h */
        private int f15427h;

        Reader(int i, Source source) {
            this(i, i, source);
        }

        Reader(int i, int i2, Source source) {
            this.f15424e = new ArrayList();
            this.f15420a = new Header[8];
            this.f15421b = this.f15420a.length - 1;
            this.f15422c = 0;
            this.f15423d = 0;
            this.f15426g = i;
            this.f15427h = i2;
            this.f15425f = Okio.m16360a(source);
        }

        /* JADX INFO: renamed from: d */
        private void m16021d() {
            if (this.f15427h < this.f15423d) {
                if (this.f15427h == 0) {
                    m16023e();
                } else {
                    m16017a(this.f15423d - this.f15427h);
                }
            }
        }

        /* JADX INFO: renamed from: e */
        private void m16023e() {
            Arrays.fill(this.f15420a, (Object) null);
            this.f15421b = this.f15420a.length - 1;
            this.f15422c = 0;
            this.f15423d = 0;
        }

        /* JADX INFO: renamed from: a */
        private int m16017a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f15420a.length;
                while (true) {
                    length--;
                    if (length < this.f15421b || i <= 0) {
                        break;
                    }
                    i -= this.f15420a[length].f15417i;
                    this.f15423d -= this.f15420a[length].f15417i;
                    this.f15422c--;
                    i2++;
                }
                System.arraycopy(this.f15420a, this.f15421b + 1, this.f15420a, this.f15421b + 1 + i2, this.f15422c);
                this.f15421b += i2;
            }
            return i2;
        }

        /* JADX INFO: renamed from: a */
        void m16031a() throws IOException {
            while (!this.f15425f.mo16283f()) {
                int iMo16290i = this.f15425f.mo16290i() & 255;
                if (iMo16290i == 128) {
                    throw new IOException("index == 0");
                }
                if ((iMo16290i & 128) == 128) {
                    m16019b(m16030a(iMo16290i, 127) - 1);
                } else if (iMo16290i == 64) {
                    m16027g();
                } else if ((iMo16290i & 64) == 64) {
                    m16024e(m16030a(iMo16290i, 63) - 1);
                } else if ((iMo16290i & 32) == 32) {
                    this.f15427h = m16030a(iMo16290i, 31);
                    if (this.f15427h < 0 || this.f15427h > this.f15426g) {
                        throw new IOException("Invalid dynamic table size update " + this.f15427h);
                    }
                    m16021d();
                } else if (iMo16290i == 16 || iMo16290i == 0) {
                    m16026f();
                } else {
                    m16022d(m16030a(iMo16290i, 15) - 1);
                }
            }
        }

        /* JADX INFO: renamed from: b */
        public List<Header> m16032b() {
            ArrayList arrayList = new ArrayList(this.f15424e);
            this.f15424e.clear();
            return arrayList;
        }

        /* JADX INFO: renamed from: b */
        private void m16019b(int i) throws IOException {
            if (m16028g(i)) {
                this.f15424e.add(Hpack.f15418a[i]);
                return;
            }
            int iM16020c = m16020c(i - Hpack.f15418a.length);
            if (iM16020c < 0 || iM16020c > this.f15420a.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.f15424e.add(this.f15420a[iM16020c]);
        }

        /* JADX INFO: renamed from: c */
        private int m16020c(int i) {
            return this.f15421b + 1 + i;
        }

        /* JADX INFO: renamed from: d */
        private void m16022d(int i) throws IOException {
            this.f15424e.add(new Header(m16025f(i), m16033c()));
        }

        /* JADX INFO: renamed from: f */
        private void m16026f() throws IOException {
            this.f15424e.add(new Header(Hpack.m16016a(m16033c()), m16033c()));
        }

        /* JADX INFO: renamed from: e */
        private void m16024e(int i) throws IOException {
            m16018a(-1, new Header(m16025f(i), m16033c()));
        }

        /* JADX INFO: renamed from: g */
        private void m16027g() throws IOException {
            m16018a(-1, new Header(Hpack.m16016a(m16033c()), m16033c()));
        }

        /* JADX INFO: renamed from: f */
        private ByteString m16025f(int i) {
            return m16028g(i) ? Hpack.f15418a[i].f15415g : this.f15420a[m16020c(i - Hpack.f15418a.length)].f15415g;
        }

        /* JADX INFO: renamed from: g */
        private boolean m16028g(int i) {
            return i >= 0 && i <= Hpack.f15418a.length + (-1);
        }

        /* JADX INFO: renamed from: a */
        private void m16018a(int i, Header header) {
            this.f15424e.add(header);
            int i2 = header.f15417i;
            if (i != -1) {
                i2 -= this.f15420a[m16020c(i)].f15417i;
            }
            if (i2 > this.f15427h) {
                m16023e();
                return;
            }
            int iM16017a = m16017a((this.f15423d + i2) - this.f15427h);
            if (i == -1) {
                if (this.f15422c + 1 > this.f15420a.length) {
                    Header[] headerArr = new Header[this.f15420a.length * 2];
                    System.arraycopy(this.f15420a, 0, headerArr, this.f15420a.length, this.f15420a.length);
                    this.f15421b = this.f15420a.length - 1;
                    this.f15420a = headerArr;
                }
                int i3 = this.f15421b;
                this.f15421b = i3 - 1;
                this.f15420a[i3] = header;
                this.f15422c++;
            } else {
                this.f15420a[iM16017a + m16020c(i) + i] = header;
            }
            this.f15423d = i2 + this.f15423d;
        }

        /* JADX INFO: renamed from: h */
        private int m16029h() throws IOException {
            return this.f15425f.mo16290i() & 255;
        }

        /* JADX INFO: renamed from: a */
        int m16030a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 >= i2) {
                int i4 = 0;
                while (true) {
                    int iM16029h = m16029h();
                    if ((iM16029h & 128) != 0) {
                        i2 += (iM16029h & 127) << i4;
                        i4 += 7;
                    } else {
                        return (iM16029h << i4) + i2;
                    }
                }
            } else {
                return i3;
            }
        }

        /* JADX INFO: renamed from: c */
        ByteString m16033c() throws IOException {
            int iM16029h = m16029h();
            boolean z = (iM16029h & 128) == 128;
            int iM16030a = m16030a(iM16029h, 127);
            if (z) {
                return ByteString.m16318a(Huffman.m16145a().m16150a(this.f15425f.mo16289h(iM16030a)));
            }
            return this.f15425f.mo16277d(iM16030a);
        }
    }

    /* JADX INFO: renamed from: a */
    private static Map<ByteString, Integer> m16015a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f15418a.length);
        for (int i = 0; i < f15418a.length; i++) {
            if (!linkedHashMap.containsKey(f15418a[i].f15415g)) {
                linkedHashMap.put(f15418a[i].f15415g, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    static final class Writer {

        /* JADX INFO: renamed from: a */
        int f15428a;

        /* JADX INFO: renamed from: b */
        int f15429b;

        /* JADX INFO: renamed from: c */
        Header[] f15430c;

        /* JADX INFO: renamed from: d */
        int f15431d;

        /* JADX INFO: renamed from: e */
        int f15432e;

        /* JADX INFO: renamed from: f */
        int f15433f;

        /* JADX INFO: renamed from: g */
        private final Buffer f15434g;

        /* JADX INFO: renamed from: h */
        private final boolean f15435h;

        /* JADX INFO: renamed from: i */
        private int f15436i;

        /* JADX INFO: renamed from: j */
        private boolean f15437j;

        Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        Writer(int i, boolean z, Buffer buffer) {
            this.f15436i = Integer.MAX_VALUE;
            this.f15430c = new Header[8];
            this.f15431d = this.f15430c.length - 1;
            this.f15432e = 0;
            this.f15433f = 0;
            this.f15428a = i;
            this.f15429b = i;
            this.f15435h = z;
            this.f15434g = buffer;
        }

        /* JADX INFO: renamed from: a */
        private void m16034a() {
            Arrays.fill(this.f15430c, (Object) null);
            this.f15431d = this.f15430c.length - 1;
            this.f15432e = 0;
            this.f15433f = 0;
        }

        /* JADX INFO: renamed from: b */
        private int m16036b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f15430c.length;
                while (true) {
                    length--;
                    if (length < this.f15431d || i <= 0) {
                        break;
                    }
                    i -= this.f15430c[length].f15417i;
                    this.f15433f -= this.f15430c[length].f15417i;
                    this.f15432e--;
                    i2++;
                }
                System.arraycopy(this.f15430c, this.f15431d + 1, this.f15430c, this.f15431d + 1 + i2, this.f15432e);
                Arrays.fill(this.f15430c, this.f15431d + 1, this.f15431d + 1 + i2, (Object) null);
                this.f15431d += i2;
            }
            return i2;
        }

        /* JADX INFO: renamed from: a */
        private void m16035a(Header header) {
            int i = header.f15417i;
            if (i > this.f15429b) {
                m16034a();
                return;
            }
            m16036b((this.f15433f + i) - this.f15429b);
            if (this.f15432e + 1 > this.f15430c.length) {
                Header[] headerArr = new Header[this.f15430c.length * 2];
                System.arraycopy(this.f15430c, 0, headerArr, this.f15430c.length, this.f15430c.length);
                this.f15431d = this.f15430c.length - 1;
                this.f15430c = headerArr;
            }
            int i2 = this.f15431d;
            this.f15431d = i2 - 1;
            this.f15430c[i2] = header;
            this.f15432e++;
            this.f15433f = i + this.f15433f;
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x00e9  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void m16040a(java.util.List<okhttp3.internal.http2.Header> r14) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 240
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.m16040a(java.util.List):void");
        }

        /* JADX INFO: renamed from: a */
        void m16039a(int i, int i2, int i3) {
            if (i < i2) {
                this.f15434g.mo16298k(i3 | i);
                return;
            }
            this.f15434g.mo16298k(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f15434g.mo16298k((i4 & 127) | 128);
                i4 >>>= 7;
            }
            this.f15434g.mo16298k(i4);
        }

        /* JADX INFO: renamed from: a */
        void m16041a(ByteString byteString) throws IOException {
            if (this.f15435h && Huffman.m16145a().m16148a(byteString) < byteString.mo16336h()) {
                Buffer buffer = new Buffer();
                Huffman.m16145a().m16149a(byteString, buffer);
                ByteString byteStringMo16305p = buffer.mo16305p();
                m16039a(byteStringMo16305p.mo16336h(), 127, 128);
                this.f15434g.mo16268b(byteStringMo16305p);
                return;
            }
            m16039a(byteString.mo16336h(), 127, 0);
            this.f15434g.mo16268b(byteString);
        }

        /* JADX INFO: renamed from: a */
        void m16038a(int i) {
            this.f15428a = i;
            int iMin = Math.min(i, 16384);
            if (this.f15429b != iMin) {
                if (iMin < this.f15429b) {
                    this.f15436i = Math.min(this.f15436i, iMin);
                }
                this.f15437j = true;
                this.f15429b = iMin;
                m16037b();
            }
        }

        /* JADX INFO: renamed from: b */
        private void m16037b() {
            if (this.f15429b < this.f15433f) {
                if (this.f15429b == 0) {
                    m16034a();
                } else {
                    m16036b(this.f15433f - this.f15429b);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static ByteString m16016a(ByteString byteString) throws IOException {
        int iMo16336h = byteString.mo16336h();
        for (int i = 0; i < iMo16336h; i++) {
            byte bMo16322a = byteString.mo16322a(i);
            if (bMo16322a >= 65 && bMo16322a <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.mo16323a());
            }
        }
        return byteString;
    }
}
