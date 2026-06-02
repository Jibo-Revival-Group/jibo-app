package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface Sink extends Closeable, Flushable {
    /* JADX INFO: renamed from: a */
    Timeout mo16013a();

    /* JADX INFO: renamed from: a_ */
    void mo15902a_(Buffer buffer, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;
}
