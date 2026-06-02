package okio;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface Source extends Closeable {
    /* JADX INFO: renamed from: a */
    long mo15863a(Buffer buffer, long j) throws IOException;

    /* JADX INFO: renamed from: a */
    Timeout mo15864a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
