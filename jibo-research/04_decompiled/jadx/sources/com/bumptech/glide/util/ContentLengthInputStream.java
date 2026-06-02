package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class ContentLengthInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a */
    private final long f5000a;

    /* JADX INFO: renamed from: b */
    private int f5001b;

    /* JADX INFO: renamed from: a */
    public static InputStream m5575a(InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    ContentLengthInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.f5000a = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f5000a - ((long) this.f5001b), this.in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        return m5574a(super.read());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return m5574a(super.read(bArr, i, i2));
    }

    /* JADX INFO: renamed from: a */
    private int m5574a(int i) throws IOException {
        if (i >= 0) {
            this.f5001b += i;
        } else if (this.f5000a - ((long) this.f5001b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f5000a + ", but read: " + this.f5001b);
        }
        return i;
    }
}
