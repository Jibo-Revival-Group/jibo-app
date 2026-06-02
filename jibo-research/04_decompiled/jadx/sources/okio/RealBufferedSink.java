package okio;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class RealBufferedSink implements BufferedSink {

    /* JADX INFO: renamed from: a */
    public final Buffer f15677a = new Buffer();

    /* JADX INFO: renamed from: b */
    public final Sink f15678b;

    /* JADX INFO: renamed from: c */
    boolean f15679c;

    RealBufferedSink(Sink sink) {
        if (sink == null) {
            throw new NullPointerException("sink == null");
        }
        this.f15678b = sink;
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    /* JADX INFO: renamed from: c */
    public Buffer mo16271c() {
        return this.f15677a;
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: a_ */
    public void mo15902a_(Buffer buffer, long j) throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        this.f15677a.mo15902a_(buffer, j);
        mo16313x();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: b */
    public BufferedSink mo16268b(ByteString byteString) throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        this.f15677a.mo16268b(byteString);
        return mo16313x();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: b */
    public BufferedSink mo16267b(String str) throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        this.f15677a.mo16267b(str);
        return mo16313x();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: c */
    public BufferedSink mo16273c(byte[] bArr) throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        this.f15677a.mo16273c(bArr);
        return mo16313x();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: c */
    public BufferedSink mo16274c(byte[] bArr, int i, int i2) throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        this.f15677a.mo16274c(bArr, i, i2);
        return mo16313x();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: k */
    public BufferedSink mo16298k(int i) throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        this.f15677a.mo16298k(i);
        return mo16313x();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: j */
    public BufferedSink mo16294j(int i) throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        this.f15677a.mo16294j(i);
        return mo16313x();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: i */
    public BufferedSink mo16291i(int i) throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        this.f15677a.mo16291i(i);
        return mo16313x();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: h */
    public BufferedSink mo16288h(int i) throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        this.f15677a.mo16288h(i);
        return mo16313x();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: m */
    public BufferedSink mo16302m(long j) throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        this.f15677a.mo16302m(j);
        return mo16313x();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: l */
    public BufferedSink mo16299l(long j) throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        this.f15677a.mo16299l(j);
        return mo16313x();
    }

    @Override // okio.BufferedSink
    /* JADX INFO: renamed from: x */
    public BufferedSink mo16313x() throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        long jM16287h = this.f15677a.m16287h();
        if (jM16287h > 0) {
            this.f15678b.mo15902a_(this.f15677a, jM16287h);
        }
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.f15679c) {
            throw new IllegalStateException("closed");
        }
        if (this.f15677a.f15643b > 0) {
            this.f15678b.mo15902a_(this.f15677a, this.f15677a.f15643b);
        }
        this.f15678b.flush();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (!this.f15679c) {
            Throwable th = null;
            try {
                if (this.f15677a.f15643b > 0) {
                    this.f15678b.mo15902a_(this.f15677a, this.f15677a.f15643b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f15678b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f15679c = true;
            if (th != null) {
                Util.m16388a(th);
            }
        }
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: a */
    public Timeout mo16013a() {
        return this.f15678b.mo16013a();
    }

    public String toString() {
        return "buffer(" + this.f15678b + ")";
    }
}
