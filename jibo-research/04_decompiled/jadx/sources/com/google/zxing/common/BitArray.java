package com.google.zxing.common;

import java.util.Arrays;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final class BitArray implements Cloneable {

    /* JADX INFO: renamed from: a */
    private int[] f9075a;

    /* JADX INFO: renamed from: b */
    private int f9076b;

    public BitArray() {
        this.f9076b = 0;
        this.f9075a = new int[1];
    }

    BitArray(int[] iArr, int i) {
        this.f9075a = iArr;
        this.f9076b = i;
    }

    /* JADX INFO: renamed from: a */
    public int m9665a() {
        return this.f9076b;
    }

    /* JADX INFO: renamed from: b */
    public int m9671b() {
        return (this.f9076b + 7) / 8;
    }

    /* JADX INFO: renamed from: b */
    private void m9663b(int i) {
        if (i > this.f9075a.length * 32) {
            int[] iArrM9664c = m9664c(i);
            System.arraycopy(this.f9075a, 0, iArrM9664c, 0, this.f9075a.length);
            this.f9075a = iArrM9664c;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m9670a(int i) {
        return (this.f9075a[i / 32] & (1 << (i & 31))) != 0;
    }

    /* JADX INFO: renamed from: a */
    public void m9669a(boolean z) {
        m9663b(this.f9076b + 1);
        if (z) {
            int[] iArr = this.f9075a;
            int i = this.f9076b / 32;
            iArr[i] = iArr[i] | (1 << (this.f9076b & 31));
        }
        this.f9076b++;
    }

    /* JADX INFO: renamed from: a */
    public void m9666a(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        m9663b(this.f9076b + i2);
        while (i2 > 0) {
            m9669a(((i >> (i2 + (-1))) & 1) == 1);
            i2--;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9668a(BitArray bitArray) {
        int i = bitArray.f9076b;
        m9663b(this.f9076b + i);
        for (int i2 = 0; i2 < i; i2++) {
            m9669a(bitArray.m9670a(i2));
        }
    }

    /* JADX INFO: renamed from: b */
    public void m9672b(BitArray bitArray) {
        if (this.f9075a.length != bitArray.f9075a.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.f9075a.length; i++) {
            int[] iArr = this.f9075a;
            iArr[i] = iArr[i] ^ bitArray.f9075a[i];
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9667a(int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        int i5 = i;
        while (i4 < i3) {
            int i6 = i5;
            int i7 = 0;
            for (int i8 = 0; i8 < 8; i8++) {
                if (m9670a(i6)) {
                    i7 |= 1 << (7 - i8);
                }
                i6++;
            }
            bArr[i2 + i4] = (byte) i7;
            i4++;
            i5 = i6;
        }
    }

    /* JADX INFO: renamed from: c */
    private static int[] m9664c(int i) {
        return new int[(i + 31) / 32];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        return this.f9076b == bitArray.f9076b && Arrays.equals(this.f9075a, bitArray.f9075a);
    }

    public int hashCode() {
        return (this.f9076b * 31) + Arrays.hashCode(this.f9075a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f9076b);
        for (int i = 0; i < this.f9076b; i++) {
            if ((i & 7) == 0) {
                sb.append(TokenParser.f15715SP);
            }
            sb.append(m9670a(i) ? 'X' : '.');
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public BitArray clone() {
        return new BitArray((int[]) this.f9075a.clone(), this.f9076b);
    }
}
