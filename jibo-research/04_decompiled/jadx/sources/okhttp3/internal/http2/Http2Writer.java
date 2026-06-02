package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes2.dex */
final class Http2Writer implements Closeable {

    /* JADX INFO: renamed from: b */
    private static final Logger f15557b = Logger.getLogger(Http2.class.getName());

    /* JADX INFO: renamed from: c */
    private final BufferedSink f15559c;

    /* JADX INFO: renamed from: d */
    private final boolean f15560d;

    /* JADX INFO: renamed from: g */
    private boolean f15563g;

    /* JADX INFO: renamed from: e */
    private final Buffer f15561e = new Buffer();

    /* JADX INFO: renamed from: a */
    final Hpack.Writer f15558a = new Hpack.Writer(this.f15561e);

    /* JADX INFO: renamed from: f */
    private int f15562f = 16384;

    Http2Writer(BufferedSink bufferedSink, boolean z) {
        this.f15559c = bufferedSink;
        this.f15560d = z;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m16130a() throws IOException {
        if (this.f15563g) {
            throw new IOException("closed");
        }
        if (this.f15560d) {
            if (f15557b.isLoggable(Level.FINE)) {
                f15557b.fine(Util.m15836a(">> CONNECTION %s", Http2.f15438a.mo16334f()));
            }
            this.f15559c.mo16273c(Http2.f15438a.mo16337i());
            this.f15559c.flush();
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m16137a(Settings settings) throws IOException {
        if (this.f15563g) {
            throw new IOException("closed");
        }
        this.f15562f = settings.m16167d(this.f15562f);
        if (settings.m16164c() != -1) {
            this.f15558a.m16038a(settings.m16164c());
        }
        m16132a(0, 0, (byte) 4, (byte) 1);
        this.f15559c.flush();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m16133a(int i, int i2, List<Header> list) throws IOException {
        if (this.f15563g) {
            throw new IOException("closed");
        }
        this.f15558a.m16040a(list);
        long jM16263b = this.f15561e.m16263b();
        int iMin = (int) Math.min(this.f15562f - 4, jM16263b);
        m16132a(i, iMin + 4, (byte) 5, jM16263b == ((long) iMin) ? (byte) 4 : (byte) 0);
        this.f15559c.mo16291i(Integer.MAX_VALUE & i2);
        this.f15559c.mo15902a_(this.f15561e, iMin);
        if (jM16263b > iMin) {
            m16129b(i, jM16263b - ((long) iMin));
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m16142b() throws IOException {
        if (this.f15563g) {
            throw new IOException("closed");
        }
        this.f15559c.flush();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m16139a(boolean z, int i, int i2, List<Header> list) throws IOException {
        if (this.f15563g) {
            throw new IOException("closed");
        }
        m16140a(z, i, list);
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m16135a(int i, ErrorCode errorCode) throws IOException {
        if (this.f15563g) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw new IllegalArgumentException();
        }
        m16132a(i, 4, (byte) 3, (byte) 0);
        this.f15559c.mo16291i(errorCode.httpCode);
        this.f15559c.flush();
    }

    /* JADX INFO: renamed from: c */
    public int m16144c() {
        return this.f15562f;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m16141a(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (this.f15563g) {
            throw new IOException("closed");
        }
        m16131a(i, z ? (byte) 1 : (byte) 0, buffer, i2);
    }

    /* JADX INFO: renamed from: a */
    void m16131a(int i, byte b, Buffer buffer, int i2) throws IOException {
        m16132a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f15559c.mo15902a_(buffer, i2);
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m16143b(Settings settings) throws IOException {
        int i;
        int i2 = 0;
        synchronized (this) {
            if (this.f15563g) {
                throw new IOException("closed");
            }
            m16132a(0, settings.m16162b() * 6, (byte) 4, (byte) 0);
            while (i2 < 10) {
                if (settings.m16161a(i2)) {
                    if (i2 == 4) {
                        i = 3;
                    } else {
                        i = i2 == 7 ? 4 : i2;
                    }
                    this.f15559c.mo16294j(i);
                    this.f15559c.mo16291i(settings.m16163b(i2));
                }
                i2++;
            }
            this.f15559c.flush();
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m16138a(boolean z, int i, int i2) throws IOException {
        synchronized (this) {
            if (this.f15563g) {
                throw new IOException("closed");
            }
            m16132a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.f15559c.mo16291i(i);
            this.f15559c.mo16291i(i2);
            this.f15559c.flush();
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m16136a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f15563g) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw Http2.m16042a("errorCode.httpCode == -1", new Object[0]);
        }
        m16132a(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.f15559c.mo16291i(i);
        this.f15559c.mo16291i(errorCode.httpCode);
        if (bArr.length > 0) {
            this.f15559c.mo16273c(bArr);
        }
        this.f15559c.flush();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m16134a(int i, long j) throws IOException {
        if (this.f15563g) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw Http2.m16042a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        m16132a(i, 4, (byte) 8, (byte) 0);
        this.f15559c.mo16291i((int) j);
        this.f15559c.flush();
    }

    /* JADX INFO: renamed from: a */
    public void m16132a(int i, int i2, byte b, byte b2) throws IOException {
        if (f15557b.isLoggable(Level.FINE)) {
            f15557b.fine(Http2.m16044a(false, i, i2, b, b2));
        }
        if (i2 > this.f15562f) {
            throw Http2.m16042a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f15562f), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw Http2.m16042a("reserved bit set: %s", Integer.valueOf(i));
        }
        m16128a(this.f15559c, i2);
        this.f15559c.mo16298k(b & 255);
        this.f15559c.mo16298k(b2 & 255);
        this.f15559c.mo16291i(Integer.MAX_VALUE & i);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f15563g = true;
        this.f15559c.close();
    }

    /* JADX INFO: renamed from: a */
    private static void m16128a(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.mo16298k((i >>> 16) & 255);
        bufferedSink.mo16298k((i >>> 8) & 255);
        bufferedSink.mo16298k(i & 255);
    }

    /* JADX INFO: renamed from: b */
    private void m16129b(int i, long j) throws IOException {
        while (j > 0) {
            int iMin = (int) Math.min(this.f15562f, j);
            j -= (long) iMin;
            m16132a(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f15559c.mo15902a_(this.f15561e, iMin);
        }
    }

    /* JADX INFO: renamed from: a */
    void m16140a(boolean z, int i, List<Header> list) throws IOException {
        if (this.f15563g) {
            throw new IOException("closed");
        }
        this.f15558a.m16040a(list);
        long jM16263b = this.f15561e.m16263b();
        int iMin = (int) Math.min(this.f15562f, jM16263b);
        byte b = jM16263b == ((long) iMin) ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        m16132a(i, iMin, (byte) 1, b);
        this.f15559c.mo15902a_(this.f15561e, iMin);
        if (jM16263b > iMin) {
            m16129b(i, jM16263b - ((long) iMin));
        }
    }
}
