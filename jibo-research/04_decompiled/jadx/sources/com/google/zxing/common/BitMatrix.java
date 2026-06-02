package com.google.zxing.common;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class BitMatrix implements Cloneable {

    /* JADX INFO: renamed from: a */
    private final int f9077a;

    /* JADX INFO: renamed from: b */
    private final int f9078b;

    /* JADX INFO: renamed from: c */
    private final int f9079c;

    /* JADX INFO: renamed from: d */
    private final int[] f9080d;

    public BitMatrix(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f9077a = i;
        this.f9078b = i2;
        this.f9079c = (i + 31) / 32;
        this.f9080d = new int[this.f9079c * i2];
    }

    private BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.f9077a = i;
        this.f9078b = i2;
        this.f9079c = i3;
        this.f9080d = iArr;
    }

    /* JADX INFO: renamed from: a */
    public boolean m9678a(int i, int i2) {
        return ((this.f9080d[(this.f9079c * i2) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    /* JADX INFO: renamed from: a */
    public void m9677a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i + i3;
        int i6 = i2 + i4;
        if (i6 > this.f9078b || i5 > this.f9077a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = i2 * this.f9079c;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.f9080d;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    /* JADX INFO: renamed from: a */
    public int m9674a() {
        return this.f9077a;
    }

    /* JADX INFO: renamed from: b */
    public int m9679b() {
        return this.f9078b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        return this.f9077a == bitMatrix.f9077a && this.f9078b == bitMatrix.f9078b && this.f9079c == bitMatrix.f9079c && Arrays.equals(this.f9080d, bitMatrix.f9080d);
    }

    public int hashCode() {
        return (((((((this.f9077a * 31) + this.f9077a) * 31) + this.f9078b) * 31) + this.f9079c) * 31) + Arrays.hashCode(this.f9080d);
    }

    public String toString() {
        return m9675a("X ", "  ");
    }

    /* JADX INFO: renamed from: a */
    public String m9675a(String str, String str2) {
        return m9676a(str, str2, System.lineSeparator());
    }

    /* JADX INFO: renamed from: a */
    public String m9676a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f9078b * (this.f9077a + 1));
        for (int i = 0; i < this.f9078b; i++) {
            for (int i2 = 0; i2 < this.f9077a; i2++) {
                sb.append(m9678a(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public BitMatrix clone() {
        return new BitMatrix(this.f9077a, this.f9078b, this.f9079c, (int[]) this.f9080d.clone());
    }
}
