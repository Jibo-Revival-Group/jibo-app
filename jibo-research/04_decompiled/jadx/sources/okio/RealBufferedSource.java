package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
final class RealBufferedSource implements BufferedSource {

    /* JADX INFO: renamed from: a */
    public final Buffer f15680a = new Buffer();

    /* JADX INFO: renamed from: b */
    public final Source f15681b;

    /* JADX INFO: renamed from: c */
    boolean f15682c;

    RealBufferedSource(Source source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        this.f15681b = source;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: c */
    public Buffer mo16271c() {
        return this.f15680a;
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: a */
    public long mo15863a(Buffer buffer, long j) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f15682c) {
            throw new IllegalStateException("closed");
        }
        if (this.f15680a.f15643b == 0 && this.f15681b.mo15863a(this.f15680a, 8192L) == -1) {
            return -1L;
        }
        return this.f15680a.mo15863a(buffer, Math.min(j, this.f15680a.f15643b));
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: f */
    public boolean mo16283f() throws IOException {
        if (this.f15682c) {
            throw new IllegalStateException("closed");
        }
        return this.f15680a.mo16283f() && this.f15681b.mo15863a(this.f15680a, 8192L) == -1;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: a */
    public void mo16259a(long j) throws IOException {
        if (!mo16269b(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: b */
    public boolean mo16269b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f15682c) {
            throw new IllegalStateException("closed");
        }
        while (this.f15680a.f15643b < j) {
            if (this.f15681b.mo15863a(this.f15680a, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: i */
    public byte mo16290i() throws IOException {
        mo16259a(1L);
        return this.f15680a.mo16290i();
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: p */
    public ByteString mo16305p() throws IOException {
        this.f15680a.m16251a(this.f15681b);
        return this.f15680a.mo16305p();
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: d */
    public ByteString mo16277d(long j) throws IOException {
        mo16259a(j);
        return this.f15680a.mo16277d(j);
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: t */
    public byte[] mo16309t() throws IOException {
        this.f15680a.m16251a(this.f15681b);
        return this.f15680a.mo16309t();
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: h */
    public byte[] mo16289h(long j) throws IOException {
        mo16259a(j);
        return this.f15680a.mo16289h(j);
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: a */
    public void mo16260a(byte[] bArr) throws IOException {
        try {
            mo16259a(bArr.length);
            this.f15680a.mo16260a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f15680a.f15643b > 0) {
                int iM16247a = this.f15680a.m16247a(bArr, i, (int) this.f15680a.f15643b);
                if (iM16247a == -1) {
                    throw new AssertionError();
                }
                i += iM16247a;
            }
            throw e;
        }
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: a */
    public long mo16250a(Sink sink) throws IOException {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.f15681b.mo15863a(this.f15680a, 8192L) != -1) {
            long jM16287h = this.f15680a.m16287h();
            if (jM16287h > 0) {
                j += jM16287h;
                sink.mo15902a_(this.f15680a, jM16287h);
            }
        }
        if (this.f15680a.m16263b() > 0) {
            long jM16263b = j + this.f15680a.m16263b();
            sink.mo15902a_(this.f15680a, this.f15680a.m16263b());
            return jM16263b;
        }
        return j;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: a */
    public String mo16253a(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f15680a.m16251a(this.f15681b);
        return this.f15680a.mo16253a(charset);
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: r */
    public String mo16307r() throws IOException {
        return m16375c(Long.MAX_VALUE);
    }

    /* JADX INFO: renamed from: c */
    public String m16375c(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jM16373a = m16373a((byte) 10, 0L, j2);
        if (jM16373a != -1) {
            return this.f15680a.m16285g(jM16373a);
        }
        if (j2 < Long.MAX_VALUE && mo16269b(j2) && this.f15680a.m16270c(j2 - 1) == 13 && mo16269b(1 + j2) && this.f15680a.m16270c(j2) == 10) {
            return this.f15680a.m16285g(j2);
        }
        Buffer buffer = new Buffer();
        this.f15680a.m16257a(buffer, 0L, Math.min(32L, this.f15680a.m16263b()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f15680a.m16263b(), j) + " content=" + buffer.mo16305p().mo16334f() + (char) 8230);
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: j */
    public short mo16295j() throws IOException {
        mo16259a(2L);
        return this.f15680a.mo16295j();
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: l */
    public short mo16300l() throws IOException {
        mo16259a(2L);
        return this.f15680a.mo16300l();
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: k */
    public int mo16296k() throws IOException {
        mo16259a(4L);
        return this.f15680a.mo16296k();
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: m */
    public int mo16301m() throws IOException {
        mo16259a(4L);
        return this.f15680a.mo16301m();
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: n */
    public long mo16303n() throws IOException {
        mo16259a(1L);
        for (int i = 0; mo16269b(i + 1); i++) {
            byte bM16270c = this.f15680a.m16270c(i);
            if ((bM16270c < 48 || bM16270c > 57) && (i != 0 || bM16270c != 45)) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(bM16270c)));
                }
                return this.f15680a.mo16303n();
            }
        }
        return this.f15680a.mo16303n();
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: o */
    public long mo16304o() throws IOException {
        mo16259a(1L);
        for (int i = 0; mo16269b(i + 1); i++) {
            byte bM16270c = this.f15680a.m16270c(i);
            if ((bM16270c < 48 || bM16270c > 57) && ((bM16270c < 97 || bM16270c > 102) && (bM16270c < 65 || bM16270c > 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bM16270c)));
                }
                return this.f15680a.mo16304o();
            }
        }
        return this.f15680a.mo16304o();
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: i */
    public void mo16292i(long j) throws IOException {
        if (this.f15682c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f15680a.f15643b == 0 && this.f15681b.mo15863a(this.f15680a, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.f15680a.m16263b());
            this.f15680a.mo16292i(jMin);
            j -= jMin;
        }
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: a */
    public long mo16248a(byte b) throws IOException {
        return m16373a(b, 0L, Long.MAX_VALUE);
    }

    /* JADX INFO: renamed from: a */
    public long m16373a(byte b, long j, long j2) throws IOException {
        if (this.f15682c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        long jMax = j;
        while (jMax < j2) {
            long jM16249a = this.f15680a.m16249a(b, jMax, j2);
            if (jM16249a == -1) {
                long j3 = this.f15680a.f15643b;
                if (j3 >= j2 || this.f15681b.mo15863a(this.f15680a, 8192L) == -1) {
                    return -1L;
                }
                jMax = Math.max(jMax, j3);
            } else {
                return jM16249a;
            }
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: a */
    public boolean mo16261a(long j, ByteString byteString) throws IOException {
        return m16374a(j, byteString, 0, byteString.mo16336h());
    }

    /* JADX INFO: renamed from: a */
    public boolean m16374a(long j, ByteString byteString, int i, int i2) throws IOException {
        if (this.f15682c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || byteString.mo16336h() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = ((long) i3) + j;
            if (!mo16269b(1 + j2) || this.f15680a.m16270c(j2) != byteString.mo16322a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    /* JADX INFO: renamed from: g */
    public InputStream mo16284g() {
        return new InputStream() { // from class: okio.RealBufferedSource.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (RealBufferedSource.this.f15682c) {
                    throw new IOException("closed");
                }
                if (RealBufferedSource.this.f15680a.f15643b == 0 && RealBufferedSource.this.f15681b.mo15863a(RealBufferedSource.this.f15680a, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.f15680a.mo16290i() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (RealBufferedSource.this.f15682c) {
                    throw new IOException("closed");
                }
                Util.m16387a(bArr.length, i, i2);
                if (RealBufferedSource.this.f15680a.f15643b == 0 && RealBufferedSource.this.f15681b.mo15863a(RealBufferedSource.this.f15680a, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.f15680a.m16247a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (RealBufferedSource.this.f15682c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(RealBufferedSource.this.f15680a.f15643b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }
        };
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f15682c) {
            this.f15682c = true;
            this.f15681b.close();
            this.f15680a.m16310u();
        }
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: a */
    public Timeout mo15864a() {
        return this.f15681b.mo15864a();
    }

    public String toString() {
        return "buffer(" + this.f15681b + ")";
    }
}
