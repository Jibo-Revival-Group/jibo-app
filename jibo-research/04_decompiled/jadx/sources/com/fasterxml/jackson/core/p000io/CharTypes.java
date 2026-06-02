package com.fasterxml.jackson.core.p000io;

import java.util.Arrays;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final class CharTypes {

    /* JADX INFO: renamed from: a */
    static final int[] f5464a;

    /* JADX INFO: renamed from: b */
    static final int[] f5465b;

    /* JADX INFO: renamed from: c */
    static final int[] f5466c;

    /* JADX INFO: renamed from: d */
    static final int[] f5467d;

    /* JADX INFO: renamed from: e */
    static final int[] f5468e;

    /* JADX INFO: renamed from: f */
    static final int[] f5469f;

    /* JADX INFO: renamed from: g */
    static final int[] f5470g;

    /* JADX INFO: renamed from: h */
    static final int[] f5471h;

    /* JADX INFO: renamed from: i */
    private static final char[] f5472i = "0123456789ABCDEF".toCharArray();

    /* JADX INFO: renamed from: j */
    private static final byte[] f5473j;

    static {
        int i;
        int length = f5472i.length;
        f5473j = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            f5473j[i2] = (byte) f5472i[i2];
        }
        int[] iArr = new int[256];
        for (int i3 = 0; i3 < 32; i3++) {
            iArr[i3] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f5464a = iArr;
        int[] iArr2 = new int[f5464a.length];
        System.arraycopy(f5464a, 0, iArr2, 0, iArr2.length);
        for (int i4 = 128; i4 < 256; i4++) {
            if ((i4 & 224) == 192) {
                i = 2;
            } else if ((i4 & 240) == 224) {
                i = 3;
            } else {
                i = (i4 & 248) == 240 ? 4 : -1;
            }
            iArr2[i4] = i;
        }
        f5465b = iArr2;
        int[] iArr3 = new int[256];
        Arrays.fill(iArr3, -1);
        for (int i5 = 33; i5 < 256; i5++) {
            if (Character.isJavaIdentifierPart((char) i5)) {
                iArr3[i5] = 0;
            }
        }
        iArr3[64] = 0;
        iArr3[35] = 0;
        iArr3[42] = 0;
        iArr3[45] = 0;
        iArr3[43] = 0;
        f5466c = iArr3;
        int[] iArr4 = new int[256];
        System.arraycopy(f5466c, 0, iArr4, 0, iArr4.length);
        Arrays.fill(iArr4, 128, 128, 0);
        f5467d = iArr4;
        int[] iArr5 = new int[256];
        System.arraycopy(f5465b, 128, iArr5, 128, 128);
        Arrays.fill(iArr5, 0, 32, -1);
        iArr5[9] = 0;
        iArr5[10] = 10;
        iArr5[13] = 13;
        iArr5[42] = 42;
        f5468e = iArr5;
        int[] iArr6 = new int[256];
        System.arraycopy(f5465b, 128, iArr6, 128, 128);
        Arrays.fill(iArr6, 0, 32, -1);
        iArr6[32] = 1;
        iArr6[9] = 1;
        iArr6[10] = 10;
        iArr6[13] = 13;
        iArr6[47] = 47;
        iArr6[35] = 35;
        f5469f = iArr6;
        int[] iArr7 = new int[128];
        for (int i6 = 0; i6 < 32; i6++) {
            iArr7[i6] = -1;
        }
        iArr7[34] = 34;
        iArr7[92] = 92;
        iArr7[8] = 98;
        iArr7[9] = 116;
        iArr7[12] = 102;
        iArr7[10] = 110;
        iArr7[13] = 114;
        f5470g = iArr7;
        f5471h = new int[128];
        Arrays.fill(f5471h, -1);
        for (int i7 = 0; i7 < 10; i7++) {
            f5471h[i7 + 48] = i7;
        }
        for (int i8 = 0; i8 < 6; i8++) {
            f5471h[i8 + 97] = i8 + 10;
            f5471h[i8 + 65] = i8 + 10;
        }
    }

    /* JADX INFO: renamed from: a */
    public static int[] m6144a() {
        return f5464a;
    }

    /* JADX INFO: renamed from: b */
    public static int[] m6145b() {
        return f5465b;
    }

    /* JADX INFO: renamed from: c */
    public static int[] m6146c() {
        return f5466c;
    }

    /* JADX INFO: renamed from: d */
    public static int[] m6147d() {
        return f5467d;
    }

    /* JADX INFO: renamed from: e */
    public static int[] m6148e() {
        return f5468e;
    }

    /* JADX INFO: renamed from: f */
    public static int[] m6149f() {
        return f5470g;
    }

    /* JADX INFO: renamed from: a */
    public static int m6142a(int i) {
        if (i > 127) {
            return -1;
        }
        return f5471h[i];
    }

    /* JADX INFO: renamed from: a */
    public static void m6143a(StringBuilder sb, String str) {
        int[] iArr = f5470g;
        int length = iArr.length;
        int length2 = str.length();
        for (int i = 0; i < length2; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= length || iArr[cCharAt] == 0) {
                sb.append(cCharAt);
            } else {
                sb.append(TokenParser.ESCAPE);
                int i2 = iArr[cCharAt];
                if (i2 < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    sb.append(f5472i[cCharAt >> 4]);
                    sb.append(f5472i[cCharAt & 15]);
                } else {
                    sb.append((char) i2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public static char[] m6150g() {
        return (char[]) f5472i.clone();
    }

    /* JADX INFO: renamed from: h */
    public static byte[] m6151h() {
        return (byte[]) f5473j.clone();
    }
}
