package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public final class ByteMatrix {

    /* JADX INFO: renamed from: a */
    private final byte[][] f9116a;

    /* JADX INFO: renamed from: b */
    private final int f9117b;

    /* JADX INFO: renamed from: c */
    private final int f9118c;

    public ByteMatrix(int i, int i2) {
        this.f9116a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i2, i);
        this.f9117b = i;
        this.f9118c = i2;
    }

    /* JADX INFO: renamed from: a */
    public int m9714a() {
        return this.f9118c;
    }

    /* JADX INFO: renamed from: b */
    public int m9718b() {
        return this.f9117b;
    }

    /* JADX INFO: renamed from: a */
    public byte m9713a(int i, int i2) {
        return this.f9116a[i2][i];
    }

    /* JADX INFO: renamed from: c */
    public byte[][] m9719c() {
        return this.f9116a;
    }

    /* JADX INFO: renamed from: a */
    public void m9716a(int i, int i2, int i3) {
        this.f9116a[i2][i] = (byte) i3;
    }

    /* JADX INFO: renamed from: a */
    public void m9717a(int i, int i2, boolean z) {
        this.f9116a[i2][i] = (byte) (z ? 1 : 0);
    }

    /* JADX INFO: renamed from: a */
    public void m9715a(byte b) {
        for (int i = 0; i < this.f9118c; i++) {
            for (int i2 = 0; i2 < this.f9117b; i2++) {
                this.f9116a[i][i2] = b;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f9117b * 2 * this.f9118c) + 2);
        for (int i = 0; i < this.f9118c; i++) {
            for (int i2 = 0; i2 < this.f9117b; i2++) {
                switch (this.f9116a[i][i2]) {
                    case 0:
                        sb.append(" 0");
                        break;
                    case 1:
                        sb.append(" 1");
                        break;
                    default:
                        sb.append("  ");
                        break;
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
