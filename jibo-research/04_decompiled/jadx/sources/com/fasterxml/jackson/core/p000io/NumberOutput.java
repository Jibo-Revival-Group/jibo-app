package com.fasterxml.jackson.core.p000io;

import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: loaded from: classes.dex */
public final class NumberOutput {

    /* JADX INFO: renamed from: d */
    static final byte[] f5499d;

    /* JADX INFO: renamed from: e */
    static final String[] f5500e;

    /* JADX INFO: renamed from: f */
    static final String[] f5501f;

    /* JADX INFO: renamed from: g */
    private static int f5502g = 1000000;

    /* JADX INFO: renamed from: h */
    private static int f5503h = 1000000000;

    /* JADX INFO: renamed from: i */
    private static long f5504i = 10000000000L;

    /* JADX INFO: renamed from: j */
    private static long f5505j = 1000;

    /* JADX INFO: renamed from: k */
    private static long f5506k = -2147483648L;

    /* JADX INFO: renamed from: l */
    private static long f5507l = 2147483647L;

    /* JADX INFO: renamed from: a */
    static final String f5496a = String.valueOf(Long.MIN_VALUE);

    /* JADX INFO: renamed from: b */
    static final char[] f5497b = new char[4000];

    /* JADX INFO: renamed from: c */
    static final char[] f5498c = new char[4000];

    static {
        int i = 0;
        int i2 = 0;
        while (i < 10) {
            char c = (char) (i + 48);
            char c2 = i == 0 ? (char) 0 : c;
            int i3 = 0;
            while (i3 < 10) {
                char c3 = (char) (i3 + 48);
                char c4 = (i == 0 && i3 == 0) ? (char) 0 : c3;
                int i4 = i2;
                for (int i5 = 0; i5 < 10; i5++) {
                    char c5 = (char) (i5 + 48);
                    f5497b[i4] = c2;
                    f5497b[i4 + 1] = c4;
                    f5497b[i4 + 2] = c5;
                    f5498c[i4] = c;
                    f5498c[i4 + 1] = c3;
                    f5498c[i4 + 2] = c5;
                    i4 += 4;
                }
                i3++;
                i2 = i4;
            }
            i++;
        }
        f5499d = new byte[4000];
        for (int i6 = 0; i6 < 4000; i6++) {
            f5499d[i6] = (byte) f5498c[i6];
        }
        f5500e = new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, AppEventsConstants.EVENT_PARAM_VALUE_YES, "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        f5501f = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    /* JADX INFO: renamed from: a */
    public static int m6189a(int i, char[] cArr, int i2) {
        int iM6194b;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return m6192a(i, cArr, i2);
            }
            cArr[i2] = '-';
            i = -i;
            i2++;
        }
        if (i < f5502g) {
            if (i < 1000) {
                if (i < 10) {
                    int i3 = i2 + 1;
                    cArr[i2] = (char) (i + 48);
                    return i3;
                }
                return m6194b(i, cArr, i2);
            }
            int i4 = i / 1000;
            return m6196c(i - (i4 * 1000), cArr, m6194b(i4, cArr, i2));
        }
        boolean z = i >= f5503h;
        if (z) {
            i -= f5503h;
            if (i >= f5503h) {
                i -= f5503h;
                cArr[i2] = '2';
                i2++;
            } else {
                cArr[i2] = '1';
                i2++;
            }
        }
        int i5 = i / 1000;
        int i6 = i - (i5 * 1000);
        int i7 = i5 / 1000;
        int i8 = i5 - (i7 * 1000);
        if (z) {
            iM6194b = m6196c(i7, cArr, i2);
        } else {
            iM6194b = m6194b(i7, cArr, i2);
        }
        return m6196c(i6, cArr, m6196c(i8, cArr, iM6194b));
    }

    /* JADX INFO: renamed from: a */
    public static int m6188a(int i, byte[] bArr, int i2) {
        int iM6193b;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return m6191a(i, bArr, i2);
            }
            bArr[i2] = 45;
            i = -i;
            i2++;
        }
        if (i < f5502g) {
            if (i < 1000) {
                if (i < 10) {
                    int i3 = i2 + 1;
                    bArr[i2] = (byte) (i + 48);
                    return i3;
                }
                return m6193b(i, bArr, i2);
            }
            int i4 = i / 1000;
            return m6195c(i - (i4 * 1000), bArr, m6193b(i4, bArr, i2));
        }
        boolean z = i >= f5503h;
        if (z) {
            i -= f5503h;
            if (i >= f5503h) {
                i -= f5503h;
                bArr[i2] = 50;
                i2++;
            } else {
                bArr[i2] = 49;
                i2++;
            }
        }
        int i5 = i / 1000;
        int i6 = i - (i5 * 1000);
        int i7 = i5 / 1000;
        int i8 = i5 - (i7 * 1000);
        if (z) {
            iM6193b = m6195c(i7, bArr, i2);
        } else {
            iM6193b = m6193b(i7, bArr, i2);
        }
        return m6195c(i6, bArr, m6195c(i8, bArr, iM6193b));
    }

    /* JADX INFO: renamed from: a */
    public static int m6192a(long j, char[] cArr, int i) {
        if (j < 0) {
            if (j > f5506k) {
                return m6189a((int) j, cArr, i);
            }
            if (j == Long.MIN_VALUE) {
                int length = f5496a.length();
                f5496a.getChars(0, length, cArr, i);
                return i + length;
            }
            cArr[i] = '-';
            j = -j;
            i++;
        } else if (j <= f5507l) {
            return m6189a((int) j, cArr, i);
        }
        int iM6190a = i + m6190a(j);
        int i2 = iM6190a;
        while (j > f5507l) {
            i2 -= 3;
            long j2 = j / f5505j;
            m6196c((int) (j - (f5505j * j2)), cArr, i2);
            j = j2;
        }
        int i3 = i2;
        int i4 = (int) j;
        while (i4 >= 1000) {
            int i5 = i3 - 3;
            int i6 = i4 / 1000;
            m6196c(i4 - (i6 * 1000), cArr, i5);
            i4 = i6;
            i3 = i5;
        }
        m6194b(i4, cArr, i);
        return iM6190a;
    }

    /* JADX INFO: renamed from: a */
    public static int m6191a(long j, byte[] bArr, int i) {
        if (j < 0) {
            if (j > f5506k) {
                return m6188a((int) j, bArr, i);
            }
            if (j == Long.MIN_VALUE) {
                int length = f5496a.length();
                int i2 = 0;
                int i3 = i;
                while (i2 < length) {
                    bArr[i3] = (byte) f5496a.charAt(i2);
                    i2++;
                    i3++;
                }
                return i3;
            }
            bArr[i] = 45;
            j = -j;
            i++;
        } else if (j <= f5507l) {
            return m6188a((int) j, bArr, i);
        }
        int iM6190a = i + m6190a(j);
        int i4 = iM6190a;
        while (j > f5507l) {
            i4 -= 3;
            long j2 = j / f5505j;
            m6195c((int) (j - (f5505j * j2)), bArr, i4);
            j = j2;
        }
        int i5 = i4;
        int i6 = (int) j;
        while (i6 >= 1000) {
            int i7 = i5 - 3;
            int i8 = i6 / 1000;
            m6195c(i6 - (i8 * 1000), bArr, i7);
            i6 = i8;
            i5 = i7;
        }
        m6193b(i6, bArr, i);
        return iM6190a;
    }

    /* JADX INFO: renamed from: b */
    private static int m6194b(int i, char[] cArr, int i2) {
        int i3 = i << 2;
        int i4 = i3 + 1;
        char c = f5497b[i3];
        if (c != 0) {
            cArr[i2] = c;
            i2++;
        }
        int i5 = i4 + 1;
        char c2 = f5497b[i4];
        if (c2 != 0) {
            cArr[i2] = c2;
            i2++;
        }
        int i6 = i2 + 1;
        cArr[i2] = f5497b[i5];
        return i6;
    }

    /* JADX INFO: renamed from: b */
    private static int m6193b(int i, byte[] bArr, int i2) {
        int i3 = i << 2;
        int i4 = i3 + 1;
        char c = f5497b[i3];
        if (c != 0) {
            bArr[i2] = (byte) c;
            i2++;
        }
        int i5 = i4 + 1;
        char c2 = f5497b[i4];
        if (c2 != 0) {
            bArr[i2] = (byte) c2;
            i2++;
        }
        int i6 = i2 + 1;
        bArr[i2] = (byte) f5497b[i5];
        return i6;
    }

    /* JADX INFO: renamed from: c */
    private static int m6196c(int i, char[] cArr, int i2) {
        int i3 = i << 2;
        int i4 = i2 + 1;
        int i5 = i3 + 1;
        cArr[i2] = f5498c[i3];
        int i6 = i4 + 1;
        cArr[i4] = f5498c[i5];
        int i7 = i6 + 1;
        cArr[i6] = f5498c[i5 + 1];
        return i7;
    }

    /* JADX INFO: renamed from: c */
    private static int m6195c(int i, byte[] bArr, int i2) {
        int i3 = i << 2;
        int i4 = i2 + 1;
        int i5 = i3 + 1;
        bArr[i2] = f5499d[i3];
        int i6 = i4 + 1;
        bArr[i4] = f5499d[i5];
        int i7 = i6 + 1;
        bArr[i6] = f5499d[i5 + 1];
        return i7;
    }

    /* JADX INFO: renamed from: a */
    private static int m6190a(long j) {
        int i = 10;
        for (long j2 = f5504i; j >= j2 && i != 19; j2 = (j2 << 1) + (j2 << 3)) {
            i++;
        }
        return i;
    }
}
