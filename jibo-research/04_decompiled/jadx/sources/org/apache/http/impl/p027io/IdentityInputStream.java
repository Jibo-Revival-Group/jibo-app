package org.apache.http.impl.p027io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.p028io.BufferInfo;
import org.apache.http.p028io.SessionInputBuffer;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes2.dex */
@NotThreadSafe
public class IdentityInputStream extends InputStream {
    private boolean closed = false;

    /* JADX INFO: renamed from: in */
    private final SessionInputBuffer f15711in;

    public IdentityInputStream(SessionInputBuffer sessionInputBuffer) {
        this.f15711in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.f15711in instanceof BufferInfo) {
            return ((BufferInfo) this.f15711in).length();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed) {
            return -1;
        }
        return this.f15711in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            return -1;
        }
        return this.f15711in.read(bArr, i, i2);
    }
}
