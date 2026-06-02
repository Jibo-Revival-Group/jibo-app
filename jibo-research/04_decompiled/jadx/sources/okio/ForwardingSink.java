package okio;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingSink implements Sink {

    /* JADX INFO: renamed from: a */
    private final Sink f15654a;

    public ForwardingSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f15654a = sink;
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: a_ */
    public void mo15902a_(Buffer buffer, long j) throws IOException {
        this.f15654a.mo15902a_(buffer, j);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.f15654a.flush();
    }

    @Override // okio.Sink
    /* JADX INFO: renamed from: a */
    public Timeout mo16013a() {
        return this.f15654a.mo16013a();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f15654a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f15654a.toString() + ")";
    }
}
