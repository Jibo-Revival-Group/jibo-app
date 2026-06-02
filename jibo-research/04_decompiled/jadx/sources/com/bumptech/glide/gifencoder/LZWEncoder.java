package com.bumptech.glide.gifencoder;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
class LZWEncoder {

    /* JADX INFO: renamed from: a */
    int f4849a;

    /* JADX INFO: renamed from: c */
    int f4851c;

    /* JADX INFO: renamed from: j */
    int f4858j;

    /* JADX INFO: renamed from: k */
    int f4859k;

    /* JADX INFO: renamed from: l */
    int f4860l;

    /* JADX INFO: renamed from: p */
    int f4864p;

    /* JADX INFO: renamed from: r */
    private int f4866r;

    /* JADX INFO: renamed from: s */
    private int f4867s;

    /* JADX INFO: renamed from: t */
    private byte[] f4868t;

    /* JADX INFO: renamed from: u */
    private int f4869u;

    /* JADX INFO: renamed from: v */
    private int f4870v;

    /* JADX INFO: renamed from: w */
    private int f4871w;

    /* JADX INFO: renamed from: b */
    int f4850b = 12;

    /* JADX INFO: renamed from: d */
    int f4852d = 4096;

    /* JADX INFO: renamed from: e */
    int[] f4853e = new int[5003];

    /* JADX INFO: renamed from: f */
    int[] f4854f = new int[5003];

    /* JADX INFO: renamed from: g */
    int f4855g = 5003;

    /* JADX INFO: renamed from: h */
    int f4856h = 0;

    /* JADX INFO: renamed from: i */
    boolean f4857i = false;

    /* JADX INFO: renamed from: m */
    int f4861m = 0;

    /* JADX INFO: renamed from: n */
    int f4862n = 0;

    /* JADX INFO: renamed from: o */
    int[] f4863o = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};

    /* JADX INFO: renamed from: q */
    byte[] f4865q = new byte[256];

    LZWEncoder(int i, int i2, byte[] bArr, int i3) {
        this.f4866r = i;
        this.f4867s = i2;
        this.f4868t = bArr;
        this.f4869u = Math.max(2, i3);
    }

    /* JADX INFO: renamed from: a */
    void m5397a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.f4865q;
        int i = this.f4864p;
        this.f4864p = i + 1;
        bArr[i] = b;
        if (this.f4864p >= 254) {
            m5404c(outputStream);
        }
    }

    /* JADX INFO: renamed from: a */
    void m5400a(OutputStream outputStream) throws IOException {
        m5398a(this.f4855g);
        this.f4856h = this.f4859k + 2;
        this.f4857i = true;
        m5402b(this.f4859k, outputStream);
    }

    /* JADX INFO: renamed from: a */
    void m5398a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f4853e[i2] = -1;
        }
    }

    /* JADX INFO: renamed from: a */
    void m5399a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.f4858j = i;
        this.f4857i = false;
        this.f4849a = this.f4858j;
        this.f4851c = m5401b(this.f4849a);
        this.f4859k = 1 << (i - 1);
        this.f4860l = this.f4859k + 1;
        this.f4856h = this.f4859k + 2;
        this.f4864p = 0;
        int iM5396a = m5396a();
        for (int i3 = this.f4855g; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.f4855g;
        m5398a(i5);
        m5402b(this.f4859k, outputStream);
        while (true) {
            int iM5396a2 = m5396a();
            if (iM5396a2 != -1) {
                int i6 = (iM5396a2 << this.f4850b) + iM5396a;
                int i7 = (iM5396a2 << i4) ^ iM5396a;
                if (this.f4853e[i7] == i6) {
                    iM5396a = this.f4854f[i7];
                } else {
                    if (this.f4853e[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.f4853e[i7] == i6) {
                                iM5396a = this.f4854f[i7];
                                break;
                            }
                        } while (this.f4853e[i7] >= 0);
                    }
                    m5402b(iM5396a, outputStream);
                    if (this.f4856h < this.f4852d) {
                        int[] iArr = this.f4854f;
                        int i9 = this.f4856h;
                        this.f4856h = i9 + 1;
                        iArr[i7] = i9;
                        this.f4853e[i7] = i6;
                        iM5396a = iM5396a2;
                    } else {
                        m5400a(outputStream);
                        iM5396a = iM5396a2;
                    }
                }
            } else {
                m5402b(iM5396a, outputStream);
                m5402b(this.f4860l, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m5403b(OutputStream outputStream) throws IOException {
        outputStream.write(this.f4869u);
        this.f4870v = this.f4866r * this.f4867s;
        this.f4871w = 0;
        m5399a(this.f4869u + 1, outputStream);
        outputStream.write(0);
    }

    /* JADX INFO: renamed from: c */
    void m5404c(OutputStream outputStream) throws IOException {
        if (this.f4864p > 0) {
            outputStream.write(this.f4864p);
            outputStream.write(this.f4865q, 0, this.f4864p);
            this.f4864p = 0;
        }
    }

    /* JADX INFO: renamed from: b */
    final int m5401b(int i) {
        return (1 << i) - 1;
    }

    /* JADX INFO: renamed from: a */
    private int m5396a() {
        if (this.f4870v == 0) {
            return -1;
        }
        this.f4870v--;
        byte[] bArr = this.f4868t;
        int i = this.f4871w;
        this.f4871w = i + 1;
        return bArr[i] & 255;
    }

    /* JADX INFO: renamed from: b */
    void m5402b(int i, OutputStream outputStream) throws IOException {
        this.f4861m &= this.f4863o[this.f4862n];
        if (this.f4862n > 0) {
            this.f4861m |= i << this.f4862n;
        } else {
            this.f4861m = i;
        }
        this.f4862n += this.f4849a;
        while (this.f4862n >= 8) {
            m5397a((byte) (this.f4861m & 255), outputStream);
            this.f4861m >>= 8;
            this.f4862n -= 8;
        }
        if (this.f4856h > this.f4851c || this.f4857i) {
            if (this.f4857i) {
                int i2 = this.f4858j;
                this.f4849a = i2;
                this.f4851c = m5401b(i2);
                this.f4857i = false;
            } else {
                this.f4849a++;
                if (this.f4849a == this.f4850b) {
                    this.f4851c = this.f4852d;
                } else {
                    this.f4851c = m5401b(this.f4849a);
                }
            }
        }
        if (i == this.f4860l) {
            while (this.f4862n > 0) {
                m5397a((byte) (this.f4861m & 255), outputStream);
                this.f4861m >>= 8;
                this.f4862n -= 8;
            }
            m5404c(outputStream);
        }
    }
}
