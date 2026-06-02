package com.fasterxml.jackson.core.p000io;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class NumberInput {

    /* JADX INFO: renamed from: a */
    static final String f5494a = String.valueOf(Long.MIN_VALUE).substring(1);

    /* JADX INFO: renamed from: b */
    static final String f5495b = String.valueOf(Long.MAX_VALUE);

    /* JADX INFO: renamed from: a */
    public static int m6181a(char[] cArr, int i, int i2) {
        int i3 = cArr[i] - '0';
        if (i2 > 4) {
            int i4 = ((i3 * 10) + (cArr[r1] - '0')) * 10;
            int i5 = (i4 + (cArr[r1] - '0')) * 10;
            i = i + 1 + 1 + 1 + 1;
            i3 = ((i5 + (cArr[r1] - '0')) * 10) + (cArr[i] - '0');
            i2 -= 4;
            if (i2 > 4) {
                int i6 = ((i3 * 10) + (cArr[r1] - '0')) * 10;
                int i7 = (i6 + (cArr[r1] - '0')) * 10;
                int i8 = i + 1 + 1 + 1;
                return ((i7 + (cArr[i8] - '0')) * 10) + (cArr[i8 + 1] - '0');
            }
        }
        if (i2 > 1) {
            int i9 = i + 1;
            int i10 = (i3 * 10) + (cArr[i9] - '0');
            if (i2 > 2) {
                int i11 = i9 + 1;
                int i12 = (i10 * 10) + (cArr[i11] - '0');
                if (i2 > 3) {
                    return (i12 * 10) + (cArr[i11 + 1] - '0');
                }
                return i12;
            }
            return i10;
        }
        return i3;
    }

    /* JADX INFO: renamed from: b */
    public static long m6184b(char[] cArr, int i, int i2) {
        int i3 = i2 - 9;
        return ((long) m6181a(cArr, i3 + i, 9)) + (((long) m6181a(cArr, i, i3)) * 1000000000);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m6183a(char[] cArr, int i, int i2, boolean z) {
        String str = z ? f5494a : f5495b;
        int length = str.length();
        if (i2 < length) {
            return true;
        }
        if (i2 > length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            int iCharAt = cArr[i + i3] - str.charAt(i3);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static double m6180a(String str) throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    /* JADX INFO: renamed from: b */
    public static BigDecimal m6185b(String str) throws NumberFormatException {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException e) {
            throw m6186c(str);
        }
    }

    /* JADX INFO: renamed from: a */
    public static BigDecimal m6182a(char[] cArr) throws NumberFormatException {
        return m6187c(cArr, 0, cArr.length);
    }

    /* JADX INFO: renamed from: c */
    public static BigDecimal m6187c(char[] cArr, int i, int i2) throws NumberFormatException {
        try {
            return new BigDecimal(cArr, i, i2);
        } catch (NumberFormatException e) {
            throw m6186c(new String(cArr, i, i2));
        }
    }

    /* JADX INFO: renamed from: c */
    private static NumberFormatException m6186c(String str) {
        return new NumberFormatException("Value \"" + str + "\" can not be represented as BigDecimal");
    }
}
