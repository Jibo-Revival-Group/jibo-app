package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class InflaterSource implements Source {

    /* JADX INFO: renamed from: a */
    private final BufferedSource f15667a;

    /* JADX INFO: renamed from: b */
    private final Inflater f15668b;

    /* JADX INFO: renamed from: c */
    private int f15669c;

    /* JADX INFO: renamed from: d */
    private boolean f15670d;

    InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f15667a = bufferedSource;
        this.f15668b = inflater;
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: a */
    public long mo15863a(Buffer buffer, long j) throws IOException {
        boolean zM16358b;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f15670d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zM16358b = m16358b();
            try {
                Segment segmentM16282f = buffer.m16282f(1);
                int iInflate = this.f15668b.inflate(segmentM16282f.f15684a, segmentM16282f.f15686c, 8192 - segmentM16282f.f15686c);
                if (iInflate > 0) {
                    segmentM16282f.f15686c += iInflate;
                    buffer.f15643b += (long) iInflate;
                    return iInflate;
                }
                if (this.f15668b.finished() || this.f15668b.needsDictionary()) {
                    m16357c();
                    if (segmentM16282f.f15685b == segmentM16282f.f15686c) {
                        buffer.f15642a = segmentM16282f.m16376a();
                        SegmentPool.m16382a(segmentM16282f);
                    }
                    return -1L;
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zM16358b);
        throw new EOFException("source exhausted prematurely");
    }

    /* JADX INFO: renamed from: b */
    public boolean m16358b() throws IOException {
        if (!this.f15668b.needsInput()) {
            return false;
        }
        m16357c();
        if (this.f15668b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f15667a.mo16283f()) {
            return true;
        }
        Segment segment = this.f15667a.mo16271c().f15642a;
        this.f15669c = segment.f15686c - segment.f15685b;
        this.f15668b.setInput(segment.f15684a, segment.f15685b, this.f15669c);
        return false;
    }

    /* JADX INFO: renamed from: c */
    private void m16357c() throws IOException {
        if (this.f15669c != 0) {
            int remaining = this.f15669c - this.f15668b.getRemaining();
            this.f15669c -= remaining;
            this.f15667a.mo16292i(remaining);
        }
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: a */
    public Timeout mo15864a() {
        return this.f15667a.mo15864a();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f15670d) {
            this.f15668b.end();
            this.f15670d = true;
            this.f15667a.close();
        }
    }
}
