package okio;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingSource implements Source {

    /* JADX INFO: renamed from: a */
    private final Source f15655a;

    public ForwardingSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f15655a = source;
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: a */
    public long mo15863a(Buffer buffer, long j) throws IOException {
        return this.f15655a.mo15863a(buffer, j);
    }

    @Override // okio.Source
    /* JADX INFO: renamed from: a */
    public Timeout mo15864a() {
        return this.f15655a.mo15864a();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f15655a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f15655a.toString() + ")";
    }
}
