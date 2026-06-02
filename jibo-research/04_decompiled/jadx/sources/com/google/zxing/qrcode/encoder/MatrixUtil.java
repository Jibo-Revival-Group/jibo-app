package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

/* JADX INFO: loaded from: classes.dex */
final class MatrixUtil {

    /* JADX INFO: renamed from: a */
    private static final int[][] f9121a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: b */
    private static final int[][] f9122b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: c */
    private static final int[][] f9123c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* JADX INFO: renamed from: d */
    private static final int[][] f9124d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* JADX INFO: renamed from: a */
    static void m9756a(ByteMatrix byteMatrix) {
        byteMatrix.m9715a((byte) -1);
    }

    /* JADX INFO: renamed from: a */
    static void m9751a(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i, ByteMatrix byteMatrix) throws WriterException {
        m9756a(byteMatrix);
        m9755a(version, byteMatrix);
        m9753a(errorCorrectionLevel, i, byteMatrix);
        m9758b(version, byteMatrix);
        m9750a(bitArray, i, byteMatrix);
    }

    /* JADX INFO: renamed from: a */
    static void m9755a(Version version, ByteMatrix byteMatrix) throws WriterException {
        m9765d(byteMatrix);
        m9763c(byteMatrix);
        m9762c(version, byteMatrix);
        m9759b(byteMatrix);
    }

    /* JADX INFO: renamed from: a */
    static void m9753a(ErrorCorrectionLevel errorCorrectionLevel, int i, ByteMatrix byteMatrix) throws WriterException {
        BitArray bitArray = new BitArray();
        m9752a(errorCorrectionLevel, i, bitArray);
        for (int i2 = 0; i2 < bitArray.m9665a(); i2++) {
            boolean zM9670a = bitArray.m9670a((bitArray.m9665a() - 1) - i2);
            byteMatrix.m9717a(f9124d[i2][0], f9124d[i2][1], zM9670a);
            if (i2 < 8) {
                byteMatrix.m9717a((byteMatrix.m9718b() - i2) - 1, 8, zM9670a);
            } else {
                byteMatrix.m9717a(8, (byteMatrix.m9714a() - 7) + (i2 - 8), zM9670a);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    static void m9758b(Version version, ByteMatrix byteMatrix) throws WriterException {
        if (version.m9701a() >= 7) {
            BitArray bitArray = new BitArray();
            m9754a(version, bitArray);
            int i = 17;
            int i2 = 0;
            while (i2 < 6) {
                int i3 = i;
                for (int i4 = 0; i4 < 3; i4++) {
                    boolean zM9670a = bitArray.m9670a(i3);
                    i3--;
                    byteMatrix.m9717a(i2, (byteMatrix.m9714a() - 11) + i4, zM9670a);
                    byteMatrix.m9717a((byteMatrix.m9714a() - 11) + i4, i2, zM9670a);
                }
                i2++;
                i = i3;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static void m9750a(BitArray bitArray, int i, ByteMatrix byteMatrix) throws WriterException {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean zM9670a;
        int iM9718b = byteMatrix.m9718b() - 1;
        int iM9714a = byteMatrix.m9714a() - 1;
        int i6 = -1;
        int i7 = 0;
        while (iM9718b > 0) {
            if (iM9718b == 6) {
                i2 = iM9714a;
                i3 = iM9718b - 1;
                i4 = i7;
            } else {
                i2 = iM9714a;
                i3 = iM9718b;
                i4 = i7;
            }
            while (i2 >= 0 && i2 < byteMatrix.m9714a()) {
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i3 - i8;
                    if (m9760b(byteMatrix.m9713a(i9, i2))) {
                        if (i4 < bitArray.m9665a()) {
                            i5 = i4 + 1;
                            zM9670a = bitArray.m9670a(i4);
                        } else {
                            i5 = i4;
                            zM9670a = false;
                        }
                        if (i != -1 && MaskUtil.m9741a(i, i9, i2)) {
                            zM9670a = !zM9670a;
                        }
                        byteMatrix.m9717a(i9, i2, zM9670a);
                        i4 = i5;
                    }
                }
                i2 += i6;
            }
            i6 = -i6;
            iM9718b = i3 - 2;
            i7 = i4;
            iM9714a = i2 + i6;
        }
        if (i7 != bitArray.m9665a()) {
            throw new WriterException("Not all bits consumed: " + i7 + '/' + bitArray.m9665a());
        }
    }

    /* JADX INFO: renamed from: a */
    static int m9747a(int i) {
        int i2 = 0;
        while (i != 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    static int m9748a(int i, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iM9747a = m9747a(i2);
        int iM9747a2 = i << (iM9747a - 1);
        while (m9747a(iM9747a2) >= iM9747a) {
            iM9747a2 ^= i2 << (m9747a(iM9747a2) - iM9747a);
        }
        return iM9747a2;
    }

    /* JADX INFO: renamed from: a */
    static void m9752a(ErrorCorrectionLevel errorCorrectionLevel, int i, BitArray bitArray) throws WriterException {
        if (!QRCode.m9766b(i)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i;
        bitArray.m9666a(bits, 5);
        bitArray.m9666a(m9748a(bits, 1335), 10);
        BitArray bitArray2 = new BitArray();
        bitArray2.m9666a(21522, 15);
        bitArray.m9672b(bitArray2);
        if (bitArray.m9665a() != 15) {
            throw new WriterException("should not happen but we got: " + bitArray.m9665a());
        }
    }

    /* JADX INFO: renamed from: a */
    static void m9754a(Version version, BitArray bitArray) throws WriterException {
        bitArray.m9666a(version.m9701a(), 6);
        bitArray.m9666a(m9748a(version.m9701a(), 7973), 12);
        if (bitArray.m9665a() != 18) {
            throw new WriterException("should not happen but we got: " + bitArray.m9665a());
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m9760b(int i) {
        return i == -1;
    }

    /* JADX INFO: renamed from: b */
    private static void m9759b(ByteMatrix byteMatrix) {
        for (int i = 8; i < byteMatrix.m9718b() - 8; i++) {
            int i2 = (i + 1) % 2;
            if (m9760b(byteMatrix.m9713a(i, 6))) {
                byteMatrix.m9716a(i, 6, i2);
            }
            if (m9760b(byteMatrix.m9713a(6, i))) {
                byteMatrix.m9716a(6, i, i2);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m9763c(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.m9713a(8, byteMatrix.m9714a() - 8) == 0) {
            throw new WriterException();
        }
        byteMatrix.m9716a(8, byteMatrix.m9714a() - 8, 1);
    }

    /* JADX INFO: renamed from: a */
    private static void m9749a(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        for (int i3 = 0; i3 < 8; i3++) {
            if (!m9760b(byteMatrix.m9713a(i + i3, i2))) {
                throw new WriterException();
            }
            byteMatrix.m9716a(i + i3, i2, 0);
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m9757b(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        for (int i3 = 0; i3 < 7; i3++) {
            if (!m9760b(byteMatrix.m9713a(i, i2 + i3))) {
                throw new WriterException();
            }
            byteMatrix.m9716a(i, i2 + i3, 0);
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m9761c(int i, int i2, ByteMatrix byteMatrix) {
        for (int i3 = 0; i3 < 5; i3++) {
            for (int i4 = 0; i4 < 5; i4++) {
                byteMatrix.m9716a(i + i4, i2 + i3, f9122b[i3][i4]);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private static void m9764d(int i, int i2, ByteMatrix byteMatrix) {
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                byteMatrix.m9716a(i + i4, i2 + i3, f9121a[i3][i4]);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private static void m9765d(ByteMatrix byteMatrix) throws WriterException {
        int length = f9121a[0].length;
        m9764d(0, 0, byteMatrix);
        m9764d(byteMatrix.m9718b() - length, 0, byteMatrix);
        m9764d(0, byteMatrix.m9718b() - length, byteMatrix);
        m9749a(0, 7, byteMatrix);
        m9749a(byteMatrix.m9718b() - 8, 7, byteMatrix);
        m9749a(0, byteMatrix.m9718b() - 8, byteMatrix);
        m9757b(7, 0, byteMatrix);
        m9757b((byteMatrix.m9714a() - 7) - 1, 0, byteMatrix);
        m9757b(7, byteMatrix.m9714a() - 7, byteMatrix);
    }

    /* JADX INFO: renamed from: c */
    private static void m9762c(Version version, ByteMatrix byteMatrix) {
        if (version.m9701a() >= 2) {
            int iM9701a = version.m9701a() - 1;
            int[] iArr = f9123c[iM9701a];
            int length = f9123c[iM9701a].length;
            for (int i = 0; i < length; i++) {
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = iArr[i];
                    int i4 = iArr[i2];
                    if (i4 != -1 && i3 != -1 && m9760b(byteMatrix.m9713a(i4, i3))) {
                        m9761c(i4 - 2, i3 - 2, byteMatrix);
                    }
                }
            }
        }
    }
}
