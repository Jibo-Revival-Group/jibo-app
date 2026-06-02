package com.crashlytics.android.core;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
final class CodedOutputStream implements Flushable {

    /* JADX INFO: renamed from: a */
    private final byte[] f5153a;

    /* JADX INFO: renamed from: b */
    private final int f5154b;

    /* JADX INFO: renamed from: c */
    private int f5155c = 0;

    /* JADX INFO: renamed from: d */
    private final OutputStream f5156d;

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.f5156d = outputStream;
        this.f5153a = bArr;
        this.f5154b = bArr.length;
    }

    /* JADX INFO: renamed from: a */
    public static CodedOutputStream m5722a(OutputStream outputStream) {
        return m5723a(outputStream, 4096);
    }

    /* JADX INFO: renamed from: a */
    public static CodedOutputStream m5723a(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    /* JADX INFO: renamed from: a */
    public void m5747a(int i, float f) throws IOException {
        m5765g(i, 5);
        m5745a(f);
    }

    /* JADX INFO: renamed from: a */
    public void m5749a(int i, long j) throws IOException {
        m5765g(i, 0);
        m5752a(j);
    }

    /* JADX INFO: renamed from: a */
    public void m5751a(int i, boolean z) throws IOException {
        m5765g(i, 0);
        m5755a(z);
    }

    /* JADX INFO: renamed from: a */
    public void m5750a(int i, ByteString byteString) throws IOException {
        m5765g(i, 2);
        m5753a(byteString);
    }

    /* JADX INFO: renamed from: a */
    public void m5748a(int i, int i2) throws IOException {
        m5765g(i, 0);
        m5758b(i2);
    }

    /* JADX INFO: renamed from: b */
    public void m5759b(int i, int i2) throws IOException {
        m5765g(i, 0);
        m5760c(i2);
    }

    /* JADX INFO: renamed from: c */
    public void m5761c(int i, int i2) throws IOException {
        m5765g(i, 0);
        m5764d(i2);
    }

    /* JADX INFO: renamed from: a */
    public void m5745a(float f) throws IOException {
        m5768m(Float.floatToRawIntBits(f));
    }

    /* JADX INFO: renamed from: a */
    public void m5752a(long j) throws IOException {
        m5762c(j);
    }

    /* JADX INFO: renamed from: a */
    public void m5746a(int i) throws IOException {
        if (i >= 0) {
            m5767k(i);
        } else {
            m5762c(i);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5755a(boolean z) throws IOException {
        m5766i(z ? 1 : 0);
    }

    /* JADX INFO: renamed from: a */
    public void m5753a(ByteString byteString) throws IOException {
        m5767k(byteString.m5713a());
        m5763c(byteString);
    }

    /* JADX INFO: renamed from: b */
    public void m5758b(int i) throws IOException {
        m5767k(i);
    }

    /* JADX INFO: renamed from: c */
    public void m5760c(int i) throws IOException {
        m5746a(i);
    }

    /* JADX INFO: renamed from: d */
    public void m5764d(int i) throws IOException {
        m5767k(m5743n(i));
    }

    /* JADX INFO: renamed from: b */
    public static int m5726b(int i, float f) {
        return m5741j(i) + m5725b(f);
    }

    /* JADX INFO: renamed from: b */
    public static int m5727b(int i, long j) {
        return m5741j(i) + m5730b(j);
    }

    /* JADX INFO: renamed from: b */
    public static int m5729b(int i, boolean z) {
        return m5741j(i) + m5732b(z);
    }

    /* JADX INFO: renamed from: b */
    public static int m5728b(int i, ByteString byteString) {
        return m5741j(i) + m5731b(byteString);
    }

    /* JADX INFO: renamed from: d */
    public static int m5733d(int i, int i2) {
        return m5741j(i) + m5737f(i2);
    }

    /* JADX INFO: renamed from: e */
    public static int m5736e(int i, int i2) {
        return m5741j(i) + m5739g(i2);
    }

    /* JADX INFO: renamed from: f */
    public static int m5738f(int i, int i2) {
        return m5741j(i) + m5740h(i2);
    }

    /* JADX INFO: renamed from: b */
    public static int m5725b(float f) {
        return 4;
    }

    /* JADX INFO: renamed from: b */
    public static int m5730b(long j) {
        return m5734d(j);
    }

    /* JADX INFO: renamed from: e */
    public static int m5735e(int i) {
        if (i >= 0) {
            return m5742l(i);
        }
        return 10;
    }

    /* JADX INFO: renamed from: b */
    public static int m5732b(boolean z) {
        return 1;
    }

    /* JADX INFO: renamed from: b */
    public static int m5731b(ByteString byteString) {
        return m5742l(byteString.m5713a()) + byteString.m5713a();
    }

    /* JADX INFO: renamed from: f */
    public static int m5737f(int i) {
        return m5742l(i);
    }

    /* JADX INFO: renamed from: g */
    public static int m5739g(int i) {
        return m5735e(i);
    }

    /* JADX INFO: renamed from: h */
    public static int m5740h(int i) {
        return m5742l(m5743n(i));
    }

    /* JADX INFO: renamed from: a */
    private void m5724a() throws IOException {
        if (this.f5156d == null) {
            throw new OutOfSpaceException();
        }
        this.f5156d.write(this.f5153a, 0, this.f5155c);
        this.f5155c = 0;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f5156d != null) {
            m5724a();
        }
    }

    static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5744a(byte b) throws IOException {
        if (this.f5155c == this.f5154b) {
            m5724a();
        }
        byte[] bArr = this.f5153a;
        int i = this.f5155c;
        this.f5155c = i + 1;
        bArr[i] = b;
    }

    /* JADX INFO: renamed from: i */
    public void m5766i(int i) throws IOException {
        m5744a((byte) i);
    }

    /* JADX INFO: renamed from: c */
    public void m5763c(ByteString byteString) throws IOException {
        m5754a(byteString, 0, byteString.m5713a());
    }

    /* JADX INFO: renamed from: a */
    public void m5756a(byte[] bArr) throws IOException {
        m5757a(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a */
    public void m5757a(byte[] bArr, int i, int i2) throws IOException {
        if (this.f5154b - this.f5155c >= i2) {
            System.arraycopy(bArr, i, this.f5153a, this.f5155c, i2);
            this.f5155c += i2;
            return;
        }
        int i3 = this.f5154b - this.f5155c;
        System.arraycopy(bArr, i, this.f5153a, this.f5155c, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.f5155c = this.f5154b;
        m5724a();
        if (i5 <= this.f5154b) {
            System.arraycopy(bArr, i4, this.f5153a, 0, i5);
            this.f5155c = i5;
        } else {
            this.f5156d.write(bArr, i4, i5);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5754a(ByteString byteString, int i, int i2) throws IOException {
        if (this.f5154b - this.f5155c >= i2) {
            byteString.m5714a(this.f5153a, i, this.f5155c, i2);
            this.f5155c += i2;
            return;
        }
        int i3 = this.f5154b - this.f5155c;
        byteString.m5714a(this.f5153a, i, this.f5155c, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.f5155c = this.f5154b;
        m5724a();
        if (i5 <= this.f5154b) {
            byteString.m5714a(this.f5153a, i4, 0, i5);
            this.f5155c = i5;
            return;
        }
        InputStream inputStreamM5715b = byteString.m5715b();
        if (i4 != inputStreamM5715b.skip(i4)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i5 > 0) {
            int iMin = Math.min(i5, this.f5154b);
            int i6 = inputStreamM5715b.read(this.f5153a, 0, iMin);
            if (i6 != iMin) {
                throw new IllegalStateException("Read failed.");
            }
            this.f5156d.write(this.f5153a, 0, i6);
            i5 -= i6;
        }
    }

    /* JADX INFO: renamed from: g */
    public void m5765g(int i, int i2) throws IOException {
        m5767k(WireFormat.m6003a(i, i2));
    }

    /* JADX INFO: renamed from: j */
    public static int m5741j(int i) {
        return m5742l(WireFormat.m6003a(i, 0));
    }

    /* JADX INFO: renamed from: k */
    public void m5767k(int i) throws IOException {
        while ((i & (-128)) != 0) {
            m5766i((i & 127) | 128);
            i >>>= 7;
        }
        m5766i(i);
    }

    /* JADX INFO: renamed from: l */
    public static int m5742l(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    /* JADX INFO: renamed from: c */
    public void m5762c(long j) throws IOException {
        while (((-128) & j) != 0) {
            m5766i((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m5766i((int) j);
    }

    /* JADX INFO: renamed from: d */
    public static int m5734d(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    /* JADX INFO: renamed from: m */
    public void m5768m(int i) throws IOException {
        m5766i(i & 255);
        m5766i((i >> 8) & 255);
        m5766i((i >> 16) & 255);
        m5766i((i >> 24) & 255);
    }

    /* JADX INFO: renamed from: n */
    public static int m5743n(int i) {
        return (i << 1) ^ (i >> 31);
    }
}
