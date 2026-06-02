package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class ExceptionCatchingInputStream extends InputStream {

    /* JADX INFO: renamed from: a */
    private static final Queue<ExceptionCatchingInputStream> f5002a = Util.m5591a(0);

    /* JADX INFO: renamed from: b */
    private InputStream f5003b;

    /* JADX INFO: renamed from: c */
    private IOException f5004c;

    /* JADX INFO: renamed from: a */
    public static ExceptionCatchingInputStream m5576a(InputStream inputStream) {
        ExceptionCatchingInputStream exceptionCatchingInputStreamPoll;
        synchronized (f5002a) {
            exceptionCatchingInputStreamPoll = f5002a.poll();
        }
        if (exceptionCatchingInputStreamPoll == null) {
            exceptionCatchingInputStreamPoll = new ExceptionCatchingInputStream();
        }
        exceptionCatchingInputStreamPoll.m5579b(inputStream);
        return exceptionCatchingInputStreamPoll;
    }

    ExceptionCatchingInputStream() {
    }

    /* JADX INFO: renamed from: b */
    void m5579b(InputStream inputStream) {
        this.f5003b = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f5003b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5003b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f5003b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f5003b.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f5003b.read(bArr);
        } catch (IOException e) {
            this.f5004c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.f5003b.read(bArr, i, i2);
        } catch (IOException e) {
            this.f5004c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f5003b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.f5003b.skip(j);
        } catch (IOException e) {
            this.f5004c = e;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f5003b.read();
        } catch (IOException e) {
            this.f5004c = e;
            return -1;
        }
    }

    /* JADX INFO: renamed from: a */
    public IOException m5577a() {
        return this.f5004c;
    }

    /* JADX INFO: renamed from: b */
    public void m5578b() {
        this.f5004c = null;
        this.f5003b = null;
        synchronized (f5002a) {
            f5002a.offer(this);
        }
    }
}
