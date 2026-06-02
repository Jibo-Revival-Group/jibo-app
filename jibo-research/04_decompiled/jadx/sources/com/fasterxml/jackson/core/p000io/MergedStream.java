package com.fasterxml.jackson.core.p000io;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class MergedStream extends InputStream {

    /* JADX INFO: renamed from: a */
    private final IOContext f5489a;

    /* JADX INFO: renamed from: b */
    private final InputStream f5490b;

    /* JADX INFO: renamed from: c */
    private byte[] f5491c;

    /* JADX INFO: renamed from: d */
    private int f5492d;

    /* JADX INFO: renamed from: e */
    private final int f5493e;

    public MergedStream(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.f5489a = iOContext;
        this.f5490b = inputStream;
        this.f5491c = bArr;
        this.f5492d = i;
        this.f5493e = i2;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f5491c != null ? this.f5493e - this.f5492d : this.f5490b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        m6179a();
        this.f5490b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        if (this.f5491c == null) {
            this.f5490b.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f5491c == null && this.f5490b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f5491c == null) {
            return this.f5490b.read();
        }
        byte[] bArr = this.f5491c;
        int i = this.f5492d;
        this.f5492d = i + 1;
        int i2 = bArr[i] & 255;
        if (this.f5492d >= this.f5493e) {
            m6179a();
            return i2;
        }
        return i2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f5491c == null) {
            return this.f5490b.read(bArr, i, i2);
        }
        int i3 = this.f5493e - this.f5492d;
        if (i2 > i3) {
            i2 = i3;
        }
        System.arraycopy(this.f5491c, this.f5492d, bArr, i, i2);
        this.f5492d += i2;
        if (this.f5492d >= this.f5493e) {
            m6179a();
            return i2;
        }
        return i2;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (this.f5491c == null) {
            this.f5490b.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip;
        if (this.f5491c != null) {
            int i = this.f5493e - this.f5492d;
            if (i > j) {
                this.f5492d += (int) j;
                return j;
            }
            m6179a();
            jSkip = ((long) i) + 0;
            j -= (long) i;
        } else {
            jSkip = 0;
        }
        if (j > 0) {
            jSkip += this.f5490b.skip(j);
        }
        return jSkip;
    }

    /* JADX INFO: renamed from: a */
    private void m6179a() {
        byte[] bArr = this.f5491c;
        if (bArr != null) {
            this.f5491c = null;
            if (this.f5489a != null) {
                this.f5489a.m6158a(bArr);
            }
        }
    }
}
