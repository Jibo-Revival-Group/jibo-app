package com.google.zxing.qrcode.encoder;

/* JADX INFO: loaded from: classes.dex */
final class MaskUtil {
    /* JADX INFO: renamed from: a */
    static int m9739a(ByteMatrix byteMatrix) {
        return m9740a(byteMatrix, true) + m9740a(byteMatrix, false);
    }

    /* JADX INFO: renamed from: b */
    static int m9744b(ByteMatrix byteMatrix) {
        byte[][] bArrM9719c = byteMatrix.m9719c();
        int iM9718b = byteMatrix.m9718b();
        int iM9714a = byteMatrix.m9714a();
        int i = 0;
        for (int i2 = 0; i2 < iM9714a - 1; i2++) {
            for (int i3 = 0; i3 < iM9718b - 1; i3++) {
                byte b = bArrM9719c[i2][i3];
                if (b == bArrM9719c[i2][i3 + 1] && b == bArrM9719c[i2 + 1][i3] && b == bArrM9719c[i2 + 1][i3 + 1]) {
                    i++;
                }
            }
        }
        return i * 3;
    }

    /* JADX INFO: renamed from: c */
    static int m9745c(ByteMatrix byteMatrix) {
        byte[][] bArrM9719c = byteMatrix.m9719c();
        int iM9718b = byteMatrix.m9718b();
        int iM9714a = byteMatrix.m9714a();
        int i = 0;
        for (int i2 = 0; i2 < iM9714a; i2++) {
            for (int i3 = 0; i3 < iM9718b; i3++) {
                byte[] bArr = bArrM9719c[i2];
                if (i3 + 6 < iM9718b && bArr[i3] == 1 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 1 && bArr[i3 + 3] == 1 && bArr[i3 + 4] == 1 && bArr[i3 + 5] == 0 && bArr[i3 + 6] == 1 && (m9742a(bArr, i3 - 4, i3) || m9742a(bArr, i3 + 7, i3 + 11))) {
                    i++;
                }
                if (i2 + 6 < iM9714a && bArrM9719c[i2][i3] == 1 && bArrM9719c[i2 + 1][i3] == 0 && bArrM9719c[i2 + 2][i3] == 1 && bArrM9719c[i2 + 3][i3] == 1 && bArrM9719c[i2 + 4][i3] == 1 && bArrM9719c[i2 + 5][i3] == 0 && bArrM9719c[i2 + 6][i3] == 1 && (m9743a(bArrM9719c, i3, i2 - 4, i2) || m9743a(bArrM9719c, i3, i2 + 7, i2 + 11))) {
                    i++;
                }
            }
        }
        return i * 40;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m9742a(byte[] bArr, int i, int i2) {
        while (i < i2) {
            if (i < 0 || i >= bArr.length || bArr[i] != 1) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m9743a(byte[][] bArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (i2 < 0 || i2 >= bArr.length || bArr[i2][i] != 1) {
                i2++;
            } else {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: d */
    static int m9746d(ByteMatrix byteMatrix) {
        byte[][] bArrM9719c = byteMatrix.m9719c();
        int iM9718b = byteMatrix.m9718b();
        int iM9714a = byteMatrix.m9714a();
        int i = 0;
        for (int i2 = 0; i2 < iM9714a; i2++) {
            byte[] bArr = bArrM9719c[i2];
            for (int i3 = 0; i3 < iM9718b; i3++) {
                if (bArr[i3] == 1) {
                    i++;
                }
            }
        }
        int iM9714a2 = byteMatrix.m9714a() * byteMatrix.m9718b();
        return ((Math.abs((i * 2) - iM9714a2) * 10) / iM9714a2) * 10;
    }

    /* JADX INFO: renamed from: a */
    static boolean m9741a(int i, int i2, int i3) {
        int i4;
        switch (i) {
            case 0:
                i4 = (i3 + i2) & 1;
                break;
            case 1:
                i4 = i3 & 1;
                break;
            case 2:
                i4 = i2 % 3;
                break;
            case 3:
                i4 = (i3 + i2) % 3;
                break;
            case 4:
                i4 = ((i3 / 2) + (i2 / 3)) & 1;
                break;
            case 5:
                int i5 = i3 * i2;
                i4 = (i5 % 3) + (i5 & 1);
                break;
            case 6:
                int i6 = i3 * i2;
                i4 = ((i6 % 3) + (i6 & 1)) & 1;
                break;
            case 7:
                i4 = (((i3 * i2) % 3) + ((i3 + i2) & 1)) & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i);
        }
        return i4 == 0;
    }

    /* JADX INFO: renamed from: a */
    private static int m9740a(ByteMatrix byteMatrix, boolean z) {
        int i;
        byte b;
        int iM9714a = z ? byteMatrix.m9714a() : byteMatrix.m9718b();
        int iM9718b = z ? byteMatrix.m9718b() : byteMatrix.m9714a();
        byte[][] bArrM9719c = byteMatrix.m9719c();
        int i2 = 0;
        for (int i3 = 0; i3 < iM9714a; i3++) {
            byte b2 = -1;
            int i4 = 0;
            int i5 = 0;
            while (i4 < iM9718b) {
                byte b3 = z ? bArrM9719c[i3][i4] : bArrM9719c[i4][i3];
                if (b3 == b2) {
                    b = b2;
                    i = i5 + 1;
                } else {
                    if (i5 >= 5) {
                        i2 += (i5 - 5) + 3;
                    }
                    i = 1;
                    b = b3;
                }
                i4++;
                i5 = i;
                b2 = b;
                i2 = i2;
            }
            if (i5 >= 5) {
                i2 += (i5 - 5) + 3;
            }
        }
        return i2;
    }
}
