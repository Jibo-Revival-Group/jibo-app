package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* JADX INFO: loaded from: classes2.dex */
class FaultHidingSink extends ForwardingSink {

    /* JADX INFO: renamed from: a */
    private boolean f15319a;

    FaultHidingSink(Sink sink) {
        super(sink);
    }

    @Override // okio.ForwardingSink, okio.Sink
    /* JADX INFO: renamed from: a_ */
    public void mo15902a_(Buffer buffer, long j) throws IOException {
        if (this.f15319a) {
            buffer.mo16292i(j);
            return;
        }
        try {
            super.mo15902a_(buffer, j);
        } catch (IOException e) {
            this.f15319a = true;
            mo15891a(e);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (!this.f15319a) {
            try {
                super.flush();
            } catch (IOException e) {
                this.f15319a = true;
                mo15891a(e);
            }
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f15319a) {
            try {
                super.close();
            } catch (IOException e) {
                this.f15319a = true;
                mo15891a(e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo15891a(IOException iOException) {
    }
}
