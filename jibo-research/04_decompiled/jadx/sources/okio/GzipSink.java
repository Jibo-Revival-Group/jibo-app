package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes2.dex */
public final class GzipSink implements Sink {

    /* JADX INFO: renamed from: a */
    private final BufferedSink f15657a;

    /* JADX INFO: renamed from: b */
    private final Deflater f15658b;

    /* JADX INFO: renamed from: c */
    private final DeflaterSink f15659c;

    /* JADX INFO: renamed from: d */
    private boolean f15660d;

    /* JADX INFO: renamed from: e */
    private final CRC32 f15661e = new CRC32();

    public GzipSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f15658b = new Deflater(-1, true);
        this.f15657a = Okio.m16359a(sink);
        this.f15659c = new DeflaterSink(this.f15657a, this.f15658b);
        m16350b();
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: a_ */
    public void mo15902a_(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j != 0) {
            m16351b(buffer, j);
            this.f15659c.mo15902a_(buffer, j);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.f15659c.flush();
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: a */
    public Timeout mo16013a() {
        return this.f15657a.mo16013a();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (!this.f15660d) {
            Throwable th = null;
            try {
                this.f15659c.m16339b();
                m16352c();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f15658b.end();
                th = th;
            } catch (Throwable th3) {
                th = th3;
                if (th != null) {
                    th = th;
                }
            }
            try {
                this.f15657a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.f15660d = true;
            if (th != null) {
                Util.m16388a(th);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m16350b() {
        Buffer bufferMo16271c = this.f15657a.mo16271c();
        bufferMo16271c.mo16294j(8075);
        bufferMo16271c.mo16298k(8);
        bufferMo16271c.mo16298k(0);
        bufferMo16271c.mo16291i(0);
        bufferMo16271c.mo16298k(0);
        bufferMo16271c.mo16298k(0);
    }

    /* JADX INFO: renamed from: c */
    private void m16352c() throws IOException {
        this.f15657a.mo16288h((int) this.f15661e.getValue());
        this.f15657a.mo16288h((int) this.f15658b.getBytesRead());
    }

    /* JADX INFO: renamed from: b */
    private void m16351b(Buffer buffer, long j) {
        Segment segment = buffer.f15642a;
        while (j > 0) {
            int iMin = (int) Math.min(j, segment.f15686c - segment.f15685b);
            this.f15661e.update(segment.f15684a, segment.f15685b, iMin);
            j -= (long) iMin;
            segment = segment.f15689f;
        }
    }
}
