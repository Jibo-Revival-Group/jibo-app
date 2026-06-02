package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class MarkEnforcingInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a */
    private int f5006a;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
        this.f5006a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        super.mark(i);
        this.f5006a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (m5582a(1L) == -1) {
            return -1;
        }
        int i = super.read();
        m5583b(1L);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iM5582a = (int) m5582a(i2);
        if (iM5582a == -1) {
            return -1;
        }
        int i3 = super.read(bArr, i, iM5582a);
        m5583b(i3);
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.f5006a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jM5582a = m5582a(j);
        if (jM5582a == -1) {
            return -1L;
        }
        long jSkip = super.skip(jM5582a);
        m5583b(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.f5006a == Integer.MIN_VALUE ? super.available() : Math.min(this.f5006a, super.available());
    }

    /* JADX INFO: renamed from: a */
    private long m5582a(long j) {
        if (this.f5006a == 0) {
            return -1L;
        }
        if (this.f5006a != Integer.MIN_VALUE && j > this.f5006a) {
            return this.f5006a;
        }
        return j;
    }

    /* JADX INFO: renamed from: b */
    private void m5583b(long j) {
        if (this.f5006a != Integer.MIN_VALUE && j != -1) {
            this.f5006a = (int) (((long) this.f5006a) - j);
        }
    }
}
