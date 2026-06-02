package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class GzipSource implements Source {

    /* JADX INFO: renamed from: b */
    private final BufferedSource f15663b;

    /* JADX INFO: renamed from: c */
    private final Inflater f15664c;

    /* JADX INFO: renamed from: d */
    private final InflaterSource f15665d;

    /* JADX INFO: renamed from: a */
    private int f15662a = 0;

    /* JADX INFO: renamed from: e */
    private final CRC32 f15666e = new CRC32();

    public GzipSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f15664c = new Inflater(true);
        this.f15663b = Okio.m16360a(source);
        this.f15665d = new InflaterSource(this.f15663b, this.f15664c);
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: a */
    public long mo15863a(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f15662a == 0) {
            m16355b();
            this.f15662a = 1;
        }
        if (this.f15662a == 1) {
            long j2 = buffer.f15643b;
            long jMo15863a = this.f15665d.mo15863a(buffer, j);
            if (jMo15863a != -1) {
                m16354a(buffer, j2, jMo15863a);
                return jMo15863a;
            }
            this.f15662a = 2;
        }
        if (this.f15662a == 2) {
            m16356c();
            this.f15662a = 3;
            if (!this.f15663b.mo16283f()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    /* JADX INFO: renamed from: b */
    private void m16355b() throws IOException {
        this.f15663b.mo16259a(10L);
        byte bM16270c = this.f15663b.mo16271c().m16270c(3L);
        boolean z = ((bM16270c >> 1) & 1) == 1;
        if (z) {
            m16354a(this.f15663b.mo16271c(), 0L, 10L);
        }
        m16353a("ID1ID2", 8075, this.f15663b.mo16295j());
        this.f15663b.mo16292i(8L);
        if (((bM16270c >> 2) & 1) == 1) {
            this.f15663b.mo16259a(2L);
            if (z) {
                m16354a(this.f15663b.mo16271c(), 0L, 2L);
            }
            short sMo16300l = this.f15663b.mo16271c().mo16300l();
            this.f15663b.mo16259a(sMo16300l);
            if (z) {
                m16354a(this.f15663b.mo16271c(), 0L, sMo16300l);
            }
            this.f15663b.mo16292i(sMo16300l);
        }
        if (((bM16270c >> 3) & 1) == 1) {
            long jMo16248a = this.f15663b.mo16248a((byte) 0);
            if (jMo16248a == -1) {
                throw new EOFException();
            }
            if (z) {
                m16354a(this.f15663b.mo16271c(), 0L, 1 + jMo16248a);
            }
            this.f15663b.mo16292i(1 + jMo16248a);
        }
        if (((bM16270c >> 4) & 1) == 1) {
            long jMo16248a2 = this.f15663b.mo16248a((byte) 0);
            if (jMo16248a2 == -1) {
                throw new EOFException();
            }
            if (z) {
                m16354a(this.f15663b.mo16271c(), 0L, 1 + jMo16248a2);
            }
            this.f15663b.mo16292i(1 + jMo16248a2);
        }
        if (z) {
            m16353a("FHCRC", this.f15663b.mo16300l(), (short) this.f15666e.getValue());
            this.f15666e.reset();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m16356c() throws IOException {
        m16353a("CRC", this.f15663b.mo16301m(), (int) this.f15666e.getValue());
        m16353a("ISIZE", this.f15663b.mo16301m(), (int) this.f15664c.getBytesWritten());
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: a */
    public Timeout mo15864a() {
        return this.f15663b.mo15864a();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f15665d.close();
    }

    /* JADX INFO: renamed from: a */
    private void m16354a(Buffer buffer, long j, long j2) {
        Segment segment = buffer.f15642a;
        while (j >= segment.f15686c - segment.f15685b) {
            j -= (long) (segment.f15686c - segment.f15685b);
            segment = segment.f15689f;
        }
        while (j2 > 0) {
            int i = (int) (((long) segment.f15685b) + j);
            int iMin = (int) Math.min(segment.f15686c - i, j2);
            this.f15666e.update(segment.f15684a, i, iMin);
            j2 -= (long) iMin;
            segment = segment.f15689f;
            j = 0;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m16353a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
