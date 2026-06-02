package okio;

import com.facebook.internal.NativeProtocol;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class Buffer implements Cloneable, BufferedSink, BufferedSource {

    /* JADX INFO: renamed from: c */
    private static final byte[] f15641c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* JADX INFO: renamed from: a */
    Segment f15642a;

    /* JADX INFO: renamed from: b */
    long f15643b;

    /* JADX INFO: renamed from: b */
    public long m16263b() {
        return this.f15643b;
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    /* JADX INFO: renamed from: c */
    public Buffer mo16271c() {
        return this;
    }

    /* JADX INFO: renamed from: d */
    public OutputStream m16275d() {
        return new OutputStream() { // from class: okio.Buffer.1
            @Override // java.io.OutputStream
            public void write(int i) {
                Buffer.this.mo16298k((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                Buffer.this.mo16274c(bArr, i, i2);
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }
        };
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Buffer mo16313x() {
        return this;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: f */
    public boolean mo16283f() {
        return this.f15643b == 0;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: a */
    public void mo16259a(long j) throws EOFException {
        if (this.f15643b < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: b */
    public boolean mo16269b(long j) {
        return this.f15643b >= j;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: g */
    public InputStream mo16284g() {
        return new InputStream() { // from class: okio.Buffer.2
            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.f15643b > 0) {
                    return Buffer.this.mo16290i() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.m16247a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.f15643b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public Buffer m16257a(Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.m16387a(this.f15643b, j, j2);
        if (j2 != 0) {
            buffer.f15643b += j2;
            Segment segment = this.f15642a;
            while (j >= segment.f15686c - segment.f15685b) {
                j -= (long) (segment.f15686c - segment.f15685b);
                segment = segment.f15689f;
            }
            while (j2 > 0) {
                Segment segment2 = new Segment(segment);
                segment2.f15685b = (int) (((long) segment2.f15685b) + j);
                segment2.f15686c = Math.min(segment2.f15685b + ((int) j2), segment2.f15686c);
                if (buffer.f15642a == null) {
                    segment2.f15690g = segment2;
                    segment2.f15689f = segment2;
                    buffer.f15642a = segment2;
                } else {
                    buffer.f15642a.f15690g.m16378a(segment2);
                }
                j2 -= (long) (segment2.f15686c - segment2.f15685b);
                segment = segment.f15689f;
                j = 0;
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: h */
    public long m16287h() {
        long j = this.f15643b;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.f15642a.f15690g;
        if (segment.f15686c < 8192 && segment.f15688e) {
            return j - ((long) (segment.f15686c - segment.f15685b));
        }
        return j;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: i */
    public byte mo16290i() {
        if (this.f15643b == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.f15642a;
        int i = segment.f15685b;
        int i2 = segment.f15686c;
        int i3 = i + 1;
        byte b = segment.f15684a[i];
        this.f15643b--;
        if (i3 == i2) {
            this.f15642a = segment.m16376a();
            SegmentPool.m16382a(segment);
        } else {
            segment.f15685b = i3;
        }
        return b;
    }

    /* JADX INFO: renamed from: c */
    public byte m16270c(long j) {
        Util.m16387a(this.f15643b, j, 1L);
        Segment segment = this.f15642a;
        while (true) {
            int i = segment.f15686c - segment.f15685b;
            if (j < i) {
                return segment.f15684a[segment.f15685b + ((int) j)];
            }
            j -= (long) i;
            segment = segment.f15689f;
        }
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: j */
    public short mo16295j() {
        if (this.f15643b < 2) {
            throw new IllegalStateException("size < 2: " + this.f15643b);
        }
        Segment segment = this.f15642a;
        int i = segment.f15685b;
        int i2 = segment.f15686c;
        if (i2 - i < 2) {
            return (short) (((mo16290i() & 255) << 8) | (mo16290i() & 255));
        }
        byte[] bArr = segment.f15684a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f15643b -= 2;
        if (i4 == i2) {
            this.f15642a = segment.m16376a();
            SegmentPool.m16382a(segment);
        } else {
            segment.f15685b = i4;
        }
        return (short) i5;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: k */
    public int mo16296k() {
        if (this.f15643b < 4) {
            throw new IllegalStateException("size < 4: " + this.f15643b);
        }
        Segment segment = this.f15642a;
        int i = segment.f15685b;
        int i2 = segment.f15686c;
        if (i2 - i < 4) {
            return ((mo16290i() & 255) << 24) | ((mo16290i() & 255) << 16) | ((mo16290i() & 255) << 8) | (mo16290i() & 255);
        }
        byte[] bArr = segment.f15684a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.f15643b -= 4;
        if (i8 == i2) {
            this.f15642a = segment.m16376a();
            SegmentPool.m16382a(segment);
            return i9;
        }
        segment.f15685b = i8;
        return i9;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: l */
    public short mo16300l() {
        return Util.m16386a(mo16295j());
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: m */
    public int mo16301m() {
        return Util.m16385a(mo16296k());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd A[EDGE_INSN: B:47:0x00cd->B:39:0x00cd BREAK  A[LOOP:0: B:7:0x001e->B:49:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long mo16303n() {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.mo16303n():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1 A[EDGE_INSN: B:43:0x00b1->B:37:0x00b1 BREAK  A[LOOP:0: B:7:0x0016->B:45:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long mo16304o() {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.mo16304o():long");
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: p */
    public ByteString mo16305p() {
        return new ByteString(mo16309t());
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: d */
    public ByteString mo16277d(long j) throws EOFException {
        return new ByteString(mo16289h(j));
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: a */
    public long mo16250a(Sink sink) throws IOException {
        long j = this.f15643b;
        if (j > 0) {
            sink.mo15902a_(this, j);
        }
        return j;
    }

    /* JADX INFO: renamed from: q */
    public String m16306q() {
        try {
            return m16252a(this.f15643b, Util.f15699a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: renamed from: e */
    public String m16278e(long j) throws EOFException {
        return m16252a(j, Util.f15699a);
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: a */
    public String mo16253a(Charset charset) {
        try {
            return m16252a(this.f15643b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public String m16252a(long j, Charset charset) throws EOFException {
        Util.m16387a(this.f15643b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        Segment segment = this.f15642a;
        if (((long) segment.f15685b) + j > segment.f15686c) {
            return new String(mo16289h(j), charset);
        }
        String str = new String(segment.f15684a, segment.f15685b, (int) j, charset);
        segment.f15685b = (int) (((long) segment.f15685b) + j);
        this.f15643b -= j;
        if (segment.f15685b == segment.f15686c) {
            this.f15642a = segment.m16376a();
            SegmentPool.m16382a(segment);
            return str;
        }
        return str;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: r */
    public String mo16307r() throws EOFException {
        return m16281f(Long.MAX_VALUE);
    }

    /* JADX INFO: renamed from: f */
    public String m16281f(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jM16249a = m16249a((byte) 10, 0L, j2);
        if (jM16249a != -1) {
            return m16285g(jM16249a);
        }
        if (j2 < m16263b() && m16270c(j2 - 1) == 13 && m16270c(j2) == 10) {
            return m16285g(j2);
        }
        Buffer buffer = new Buffer();
        m16257a(buffer, 0L, Math.min(32L, m16263b()));
        throw new EOFException("\\n not found: limit=" + Math.min(m16263b(), j) + " content=" + buffer.mo16305p().mo16334f() + (char) 8230);
    }

    /* JADX INFO: renamed from: g */
    String m16285g(long j) throws EOFException {
        if (j > 0 && m16270c(j - 1) == 13) {
            String strM16278e = m16278e(j - 1);
            mo16292i(2L);
            return strM16278e;
        }
        String strM16278e2 = m16278e(j);
        mo16292i(1L);
        return strM16278e2;
    }

    /* JADX INFO: renamed from: s */
    public int m16308s() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.f15643b == 0) {
            throw new EOFException();
        }
        byte bM16270c = m16270c(0L);
        if ((bM16270c & 128) == 0) {
            i3 = 0;
            i = bM16270c & 127;
            i2 = 1;
        } else if ((bM16270c & 224) == 192) {
            i = bM16270c & 31;
            i2 = 2;
            i3 = 128;
        } else if ((bM16270c & 240) == 224) {
            i = bM16270c & 15;
            i2 = 3;
            i3 = 2048;
        } else if ((bM16270c & 248) == 240) {
            i = bM16270c & 7;
            i2 = 4;
            i3 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            mo16292i(1L);
            return 65533;
        }
        if (this.f15643b < i2) {
            throw new EOFException("size < " + i2 + ": " + this.f15643b + " (to read code point prefixed 0x" + Integer.toHexString(bM16270c) + ")");
        }
        int i4 = i;
        int i5 = 1;
        while (i5 < i2) {
            byte bM16270c2 = m16270c(i5);
            if ((bM16270c2 & 192) == 128) {
                i5++;
                i4 = (bM16270c2 & 63) | (i4 << 6);
            } else {
                mo16292i(i5);
                return 65533;
            }
        }
        mo16292i(i2);
        if (i4 > 1114111) {
            return 65533;
        }
        if ((i4 < 55296 || i4 > 57343) && i4 >= i3) {
            return i4;
        }
        return 65533;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: t */
    public byte[] mo16309t() {
        try {
            return mo16289h(this.f15643b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: h */
    public byte[] mo16289h(long j) throws EOFException {
        Util.m16387a(this.f15643b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        mo16260a(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: a */
    public void mo16260a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iM16247a = m16247a(bArr, i, bArr.length - i);
            if (iM16247a == -1) {
                throw new EOFException();
            }
            i += iM16247a;
        }
    }

    /* JADX INFO: renamed from: a */
    public int m16247a(byte[] bArr, int i, int i2) {
        Util.m16387a(bArr.length, i, i2);
        Segment segment = this.f15642a;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i2, segment.f15686c - segment.f15685b);
        System.arraycopy(segment.f15684a, segment.f15685b, bArr, i, iMin);
        segment.f15685b += iMin;
        this.f15643b -= (long) iMin;
        if (segment.f15685b == segment.f15686c) {
            this.f15642a = segment.m16376a();
            SegmentPool.m16382a(segment);
            return iMin;
        }
        return iMin;
    }

    /* JADX INFO: renamed from: u */
    public void m16310u() {
        try {
            mo16292i(this.f15643b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: i */
    public void mo16292i(long j) throws EOFException {
        while (j > 0) {
            if (this.f15642a == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, this.f15642a.f15686c - this.f15642a.f15685b);
            this.f15643b -= (long) iMin;
            j -= (long) iMin;
            Segment segment = this.f15642a;
            segment.f15685b = iMin + segment.f15685b;
            if (this.f15642a.f15685b == this.f15642a.f15686c) {
                Segment segment2 = this.f15642a;
                this.f15642a = segment2.m16376a();
                SegmentPool.m16382a(segment2);
            }
        }
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Buffer mo16268b(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.mo16325a(this);
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Buffer mo16267b(String str) {
        return m16256a(str, 0, str.length());
    }

    /* JADX INFO: renamed from: a */
    public Buffer m16256a(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                Segment segmentM16282f = m16282f(1);
                byte[] bArr = segmentM16282f.f15684a;
                int i4 = segmentM16282f.f15686c - i;
                int iMin = Math.min(i2, 8192 - i4);
                i3 = i + 1;
                bArr[i4 + i] = (byte) cCharAt;
                while (i3 < iMin) {
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i3 + i4] = (byte) cCharAt2;
                    i3++;
                }
                int i5 = (i3 + i4) - segmentM16282f.f15686c;
                segmentM16282f.f15686c += i5;
                this.f15643b += (long) i5;
            } else if (cCharAt < 2048) {
                mo16298k((cCharAt >> 6) | 192);
                mo16298k((cCharAt & '?') | 128);
                i3 = i + 1;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                mo16298k((cCharAt >> '\f') | 224);
                mo16298k(((cCharAt >> 6) & 63) | 128);
                mo16298k((cCharAt & '?') | 128);
                i3 = i + 1;
            } else {
                char cCharAt3 = i + 1 < i2 ? str.charAt(i + 1) : (char) 0;
                if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                    mo16298k(63);
                    i++;
                } else {
                    int i6 = ((cCharAt3 & 9215) | ((cCharAt & 10239) << 10)) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                    mo16298k((i6 >> 18) | 240);
                    mo16298k(((i6 >> 12) & 63) | 128);
                    mo16298k(((i6 >> 6) & 63) | 128);
                    mo16298k((i6 & 63) | 128);
                    i3 = i + 2;
                }
            }
            i = i3;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public Buffer m16254a(int i) {
        if (i < 128) {
            mo16298k(i);
        } else if (i < 2048) {
            mo16298k((i >> 6) | 192);
            mo16298k((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                mo16298k(63);
            } else {
                mo16298k((i >> 12) | 224);
                mo16298k(((i >> 6) & 63) | 128);
                mo16298k((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            mo16298k((i >> 18) | 240);
            mo16298k(((i >> 12) & 63) | 128);
            mo16298k(((i >> 6) & 63) | 128);
            mo16298k((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Buffer mo16273c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return mo16274c(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Buffer mo16274c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        Util.m16387a(bArr.length, i, i2);
        int i3 = i + i2;
        while (i < i3) {
            Segment segmentM16282f = m16282f(1);
            int iMin = Math.min(i3 - i, 8192 - segmentM16282f.f15686c);
            System.arraycopy(bArr, i, segmentM16282f.f15684a, segmentM16282f.f15686c, iMin);
            i += iMin;
            segmentM16282f.f15686c = iMin + segmentM16282f.f15686c;
        }
        this.f15643b += (long) i2;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public long m16251a(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jMo15863a = source.mo15863a(this, 8192L);
            if (jMo15863a != -1) {
                j += jMo15863a;
            } else {
                return j;
            }
        }
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Buffer mo16298k(int i) {
        Segment segmentM16282f = m16282f(1);
        byte[] bArr = segmentM16282f.f15684a;
        int i2 = segmentM16282f.f15686c;
        segmentM16282f.f15686c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f15643b++;
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Buffer mo16294j(int i) {
        Segment segmentM16282f = m16282f(2);
        byte[] bArr = segmentM16282f.f15684a;
        int i2 = segmentM16282f.f15686c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        segmentM16282f.f15686c = i3 + 1;
        this.f15643b += 2;
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Buffer mo16291i(int i) {
        Segment segmentM16282f = m16282f(4);
        byte[] bArr = segmentM16282f.f15684a;
        int i2 = segmentM16282f.f15686c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        segmentM16282f.f15686c = i5 + 1;
        this.f15643b += 4;
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Buffer mo16288h(int i) {
        return mo16291i(Util.m16385a(i));
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Buffer mo16302m(long j) {
        boolean z;
        long j2;
        int i;
        if (j == 0) {
            return mo16298k(48);
        }
        if (j >= 0) {
            z = false;
            j2 = j;
        } else {
            j2 = -j;
            if (j2 < 0) {
                return mo16267b("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 < 100) {
            i = j2 < 10 ? 1 : 2;
        } else {
            i = j2 < 1000 ? 3 : 4;
        }
        if (z) {
            i++;
        }
        Segment segmentM16282f = m16282f(i);
        byte[] bArr = segmentM16282f.f15684a;
        int i2 = segmentM16282f.f15686c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = f15641c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        segmentM16282f.f15686c += i;
        this.f15643b = ((long) i) + this.f15643b;
        return this;
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Buffer mo16299l(long j) {
        if (j == 0) {
            return mo16298k(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment segmentM16282f = m16282f(iNumberOfTrailingZeros);
        byte[] bArr = segmentM16282f.f15684a;
        int i = segmentM16282f.f15686c;
        for (int i2 = (segmentM16282f.f15686c + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f15641c[(int) (15 & j)];
            j >>>= 4;
        }
        segmentM16282f.f15686c += iNumberOfTrailingZeros;
        this.f15643b = ((long) iNumberOfTrailingZeros) + this.f15643b;
        return this;
    }

    /* JADX INFO: renamed from: f */
    Segment m16282f(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        if (this.f15642a == null) {
            this.f15642a = SegmentPool.m16381a();
            Segment segment = this.f15642a;
            Segment segment2 = this.f15642a;
            Segment segment3 = this.f15642a;
            segment2.f15690g = segment3;
            segment.f15689f = segment3;
            return segment3;
        }
        Segment segment4 = this.f15642a.f15690g;
        if (segment4.f15686c + i > 8192 || !segment4.f15688e) {
            return segment4.m16378a(SegmentPool.m16381a());
        }
        return segment4;
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: a_ */
    public void mo15902a_(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.m16387a(buffer.f15643b, 0L, j);
        while (j > 0) {
            if (j < buffer.f15642a.f15686c - buffer.f15642a.f15685b) {
                Segment segment = this.f15642a != null ? this.f15642a.f15690g : null;
                if (segment != null && segment.f15688e) {
                    if ((((long) segment.f15686c) + j) - ((long) (segment.f15687d ? 0 : segment.f15685b)) <= 8192) {
                        buffer.f15642a.m16379a(segment, (int) j);
                        buffer.f15643b -= j;
                        this.f15643b += j;
                        return;
                    }
                }
                buffer.f15642a = buffer.f15642a.m16377a((int) j);
            }
            Segment segment2 = buffer.f15642a;
            long j2 = segment2.f15686c - segment2.f15685b;
            buffer.f15642a = segment2.m16376a();
            if (this.f15642a == null) {
                this.f15642a = segment2;
                Segment segment3 = this.f15642a;
                Segment segment4 = this.f15642a;
                Segment segment5 = this.f15642a;
                segment4.f15690g = segment5;
                segment3.f15689f = segment5;
            } else {
                this.f15642a.f15690g.m16378a(segment2).m16380b();
            }
            buffer.f15643b -= j2;
            this.f15643b += j2;
            j -= j2;
        }
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: a */
    public long mo15863a(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f15643b == 0) {
            return -1L;
        }
        if (j > this.f15643b) {
            j = this.f15643b;
        }
        buffer.mo15902a_(this, j);
        return j;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: a */
    public long mo16248a(byte b) {
        return m16249a(b, 0L, Long.MAX_VALUE);
    }

    /* JADX INFO: renamed from: a */
    public long m16249a(byte b, long j, long j2) {
        Segment segment;
        long j3;
        Segment segment2;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f15643b), Long.valueOf(j), Long.valueOf(j2)));
        }
        if (j2 > this.f15643b) {
            j2 = this.f15643b;
        }
        if (j == j2 || (segment = this.f15642a) == null) {
            return -1L;
        }
        if (this.f15643b - j < j) {
            j3 = this.f15643b;
            segment2 = segment;
            while (j3 > j) {
                segment2 = segment2.f15690g;
                j3 -= (long) (segment2.f15686c - segment2.f15685b);
            }
        } else {
            j3 = 0;
            segment2 = segment;
            while (true) {
                long j4 = ((long) (segment2.f15686c - segment2.f15685b)) + j3;
                if (j4 >= j) {
                    break;
                }
                segment2 = segment2.f15689f;
                j3 = j4;
            }
        }
        long j5 = j3;
        while (j5 < j2) {
            byte[] bArr = segment2.f15684a;
            int iMin = (int) Math.min(segment2.f15686c, (((long) segment2.f15685b) + j2) - j5);
            for (int i = (int) ((((long) segment2.f15685b) + j) - j5); i < iMin; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - segment2.f15685b)) + j5;
                }
            }
            long j6 = ((long) (segment2.f15686c - segment2.f15685b)) + j5;
            segment2 = segment2.f15689f;
            j5 = j6;
            j = j6;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: a */
    public boolean mo16261a(long j, ByteString byteString) {
        return m16262a(j, byteString, 0, byteString.mo16336h());
    }

    /* JADX INFO: renamed from: a */
    public boolean m16262a(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f15643b - j < i2 || byteString.mo16336h() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (m16270c(((long) i3) + j) != byteString.mo16322a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: a */
    public Timeout mo16013a() {
        return Timeout.f15695c;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (this.f15643b != buffer.f15643b) {
            return false;
        }
        if (this.f15643b == 0) {
            return true;
        }
        Segment segment = this.f15642a;
        Segment segment2 = buffer.f15642a;
        int i = segment.f15685b;
        int i2 = segment2.f15685b;
        while (j < this.f15643b) {
            long jMin = Math.min(segment.f15686c - i, segment2.f15686c - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                byte b = segment.f15684a[i];
                int i5 = i2 + 1;
                if (b != segment2.f15684a[i2]) {
                    return false;
                }
                i3++;
                i2 = i5;
                i = i4;
            }
            if (i == segment.f15686c) {
                segment = segment.f15689f;
                i = segment.f15685b;
            }
            if (i2 == segment2.f15686c) {
                segment2 = segment2.f15689f;
                i2 = segment2.f15685b;
            }
            j += jMin;
        }
        return true;
    }

    public int hashCode() {
        Segment segment = this.f15642a;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.f15685b;
            int i3 = segment.f15686c;
            while (i2 < i3) {
                int i4 = segment.f15684a[i2] + (i * 31);
                i2++;
                i = i4;
            }
            segment = segment.f15689f;
        } while (segment != this.f15642a);
        return i;
    }

    public String toString() {
        return m16312w().toString();
    }

    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.f15643b == 0) {
            return buffer;
        }
        buffer.f15642a = new Segment(this.f15642a);
        Segment segment = buffer.f15642a;
        Segment segment2 = buffer.f15642a;
        Segment segment3 = buffer.f15642a;
        segment2.f15690g = segment3;
        segment.f15689f = segment3;
        for (Segment segment4 = this.f15642a.f15689f; segment4 != this.f15642a; segment4 = segment4.f15689f) {
            buffer.f15642a.f15690g.m16378a(new Segment(segment4));
        }
        buffer.f15643b = this.f15643b;
        return buffer;
    }

    /* JADX INFO: renamed from: w */
    public ByteString m16312w() {
        if (this.f15643b > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f15643b);
        }
        return m16286g((int) this.f15643b);
    }

    /* JADX INFO: renamed from: g */
    public ByteString m16286g(int i) {
        return i == 0 ? ByteString.f15647b : new SegmentedByteString(this, i);
    }
}
