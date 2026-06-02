package okio;

import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes2.dex */
public final class DeflaterSink implements Sink {

    /* JADX INFO: renamed from: a */
    private final BufferedSink f15651a;

    /* JADX INFO: renamed from: b */
    private final Deflater f15652b;

    /* JADX INFO: renamed from: c */
    private boolean f15653c;

    DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f15651a = bufferedSink;
        this.f15652b = deflater;
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: a_ */
    public void mo15902a_(Buffer buffer, long j) throws IOException {
        Util.m16387a(buffer.f15643b, 0L, j);
        while (j > 0) {
            Segment segment = buffer.f15642a;
            int iMin = (int) Math.min(j, segment.f15686c - segment.f15685b);
            this.f15652b.setInput(segment.f15684a, segment.f15685b, iMin);
            m16338a(false);
            buffer.f15643b -= (long) iMin;
            segment.f15685b += iMin;
            if (segment.f15685b == segment.f15686c) {
                buffer.f15642a = segment.m16376a();
                SegmentPool.m16382a(segment);
            }
            j -= (long) iMin;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m16338a(boolean z) throws IOException {
        Segment segmentM16282f;
        int iDeflate;
        Buffer bufferMo16271c = this.f15651a.mo16271c();
        while (true) {
            segmentM16282f = bufferMo16271c.m16282f(1);
            if (z) {
                iDeflate = this.f15652b.deflate(segmentM16282f.f15684a, segmentM16282f.f15686c, 8192 - segmentM16282f.f15686c, 2);
            } else {
                iDeflate = this.f15652b.deflate(segmentM16282f.f15684a, segmentM16282f.f15686c, 8192 - segmentM16282f.f15686c);
            }
            if (iDeflate > 0) {
                segmentM16282f.f15686c += iDeflate;
                bufferMo16271c.f15643b += (long) iDeflate;
                this.f15651a.mo16313x();
            } else if (this.f15652b.needsInput()) {
                break;
            }
        }
        if (segmentM16282f.f15685b == segmentM16282f.f15686c) {
            bufferMo16271c.f15642a = segmentM16282f.m16376a();
            SegmentPool.m16382a(segmentM16282f);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        m16338a(true);
        this.f15651a.flush();
    }

    /* JADX INFO: renamed from: b */
    void m16339b() throws IOException {
        this.f15652b.finish();
        m16338a(false);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (!this.f15653c) {
            Throwable th = null;
            try {
                m16339b();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f15652b.end();
                th = th;
            } catch (Throwable th3) {
                th = th3;
                if (th != null) {
                    th = th;
                }
            }
            try {
                this.f15651a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.f15653c = true;
            if (th != null) {
                Util.m16388a(th);
            }
        }
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: a */
    public Timeout mo16013a() {
        return this.f15651a.mo16013a();
    }

    public String toString() {
        return "DeflaterSink(" + this.f15651a + ")";
    }
}
