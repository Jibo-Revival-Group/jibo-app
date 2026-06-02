package com.fasterxml.jackson.core.util;

import com.google.api.client.googleapis.media.MediaHttpUploader;
import java.io.OutputStream;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class ByteArrayBuilder extends OutputStream {

    /* JADX INFO: renamed from: a */
    public static final byte[] f5657a = new byte[0];

    /* JADX INFO: renamed from: b */
    private final BufferRecycler f5658b;

    /* JADX INFO: renamed from: c */
    private final LinkedList<byte[]> f5659c;

    /* JADX INFO: renamed from: d */
    private int f5660d;

    /* JADX INFO: renamed from: e */
    private byte[] f5661e;

    /* JADX INFO: renamed from: f */
    private int f5662f;

    public ByteArrayBuilder() {
        this(null);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler) {
        this(bufferRecycler, 500);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler, int i) {
        this.f5659c = new LinkedList<>();
        this.f5658b = bufferRecycler;
        this.f5661e = bufferRecycler == null ? new byte[i] : bufferRecycler.m6450a(2);
    }

    /* JADX INFO: renamed from: a */
    public void m6459a() {
        this.f5660d = 0;
        this.f5662f = 0;
        if (!this.f5659c.isEmpty()) {
            this.f5659c.clear();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6460a(int i) {
        if (this.f5662f >= this.f5661e.length) {
            m6458e();
        }
        byte[] bArr = this.f5661e;
        int i2 = this.f5662f;
        this.f5662f = i2 + 1;
        bArr[i2] = (byte) i;
    }

    /* JADX INFO: renamed from: b */
    public byte[] m6461b() {
        int i = this.f5660d + this.f5662f;
        if (i == 0) {
            return f5657a;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : this.f5659c) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i2, length);
            i2 += length;
        }
        System.arraycopy(this.f5661e, 0, bArr, i2, this.f5662f);
        int i3 = this.f5662f + i2;
        if (i3 != i) {
            throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + i3 + " bytes");
        }
        if (!this.f5659c.isEmpty()) {
            m6459a();
        }
        return bArr;
    }

    /* JADX INFO: renamed from: c */
    public byte[] m6463c() {
        m6459a();
        return this.f5661e;
    }

    /* JADX INFO: renamed from: d */
    public byte[] m6464d() {
        m6458e();
        return this.f5661e;
    }

    /* JADX INFO: renamed from: b */
    public byte[] m6462b(int i) {
        this.f5662f = i;
        return m6461b();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        while (true) {
            int iMin = Math.min(this.f5661e.length - this.f5662f, i2);
            if (iMin > 0) {
                System.arraycopy(bArr, i, this.f5661e, this.f5662f, iMin);
                i += iMin;
                this.f5662f += iMin;
                i2 -= iMin;
            }
            if (i2 > 0) {
                m6458e();
            } else {
                return;
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        m6460a(i);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    /* JADX INFO: renamed from: e */
    private void m6458e() {
        int i = MediaHttpUploader.MINIMUM_CHUNK_SIZE;
        this.f5660d += this.f5661e.length;
        int iMax = Math.max(this.f5660d >> 1, 1000);
        if (iMax <= 262144) {
            i = iMax;
        }
        this.f5659c.add(this.f5661e);
        this.f5661e = new byte[i];
        this.f5662f = 0;
    }
}
