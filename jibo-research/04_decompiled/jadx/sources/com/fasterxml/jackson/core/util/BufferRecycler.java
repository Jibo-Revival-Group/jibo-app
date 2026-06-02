package com.fasterxml.jackson.core.util;

/* JADX INFO: loaded from: classes.dex */
public class BufferRecycler {

    /* JADX INFO: renamed from: c */
    private static final int[] f5653c = {8000, 8000, 2000, 2000};

    /* JADX INFO: renamed from: d */
    private static final int[] f5654d = {4000, 4000, 200, 200};

    /* JADX INFO: renamed from: a */
    protected final byte[][] f5655a;

    /* JADX INFO: renamed from: b */
    protected final char[][] f5656b;

    public BufferRecycler() {
        this(4, 4);
    }

    protected BufferRecycler(int i, int i2) {
        this.f5655a = new byte[i][];
        this.f5656b = new char[i2][];
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m6450a(int i) {
        return m6451a(i, 0);
    }

    /* JADX INFO: renamed from: a */
    public byte[] m6451a(int i, int i2) {
        int iM6454c = m6454c(i);
        if (i2 < iM6454c) {
            i2 = iM6454c;
        }
        byte[] bArr = this.f5655a[i];
        if (bArr == null || bArr.length < i2) {
            return m6456e(i2);
        }
        this.f5655a[i] = null;
        return bArr;
    }

    /* JADX INFO: renamed from: a */
    public final void m6448a(int i, byte[] bArr) {
        this.f5655a[i] = bArr;
    }

    /* JADX INFO: renamed from: b */
    public final char[] m6452b(int i) {
        return m6453b(i, 0);
    }

    /* JADX INFO: renamed from: b */
    public char[] m6453b(int i, int i2) {
        int iM6455d = m6455d(i);
        if (i2 < iM6455d) {
            i2 = iM6455d;
        }
        char[] cArr = this.f5656b[i];
        if (cArr == null || cArr.length < i2) {
            return m6457f(i2);
        }
        this.f5656b[i] = null;
        return cArr;
    }

    /* JADX INFO: renamed from: a */
    public void m6449a(int i, char[] cArr) {
        this.f5656b[i] = cArr;
    }

    /* JADX INFO: renamed from: c */
    protected int m6454c(int i) {
        return f5653c[i];
    }

    /* JADX INFO: renamed from: d */
    protected int m6455d(int i) {
        return f5654d[i];
    }

    /* JADX INFO: renamed from: e */
    protected byte[] m6456e(int i) {
        return new byte[i];
    }

    /* JADX INFO: renamed from: f */
    protected char[] m6457f(int i) {
        return new char[i];
    }
}
