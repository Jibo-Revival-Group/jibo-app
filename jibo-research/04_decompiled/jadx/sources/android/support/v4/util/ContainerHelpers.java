package android.support.v4.util;

/* JADX INFO: loaded from: classes.dex */
class ContainerHelpers {

    /* JADX INFO: renamed from: a */
    static final int[] f2195a = new int[0];

    /* JADX INFO: renamed from: b */
    static final long[] f2196b = new long[0];

    /* JADX INFO: renamed from: c */
    static final Object[] f2197c = new Object[0];

    /* JADX INFO: renamed from: a */
    public static int m2396a(int i) {
        return m2401c(i * 4) / 4;
    }

    /* JADX INFO: renamed from: b */
    public static int m2400b(int i) {
        return m2401c(i * 8) / 8;
    }

    /* JADX INFO: renamed from: c */
    public static int m2401c(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2399a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: a */
    static int m2397a(int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = i - 1;
        while (i3 <= i4) {
            int i5 = (i3 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i3 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return i3 ^ (-1);
    }

    /* JADX INFO: renamed from: a */
    static int m2398a(long[] jArr, int i, long j) {
        int i2 = 0;
        int i3 = i - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i2 = i4 + 1;
            } else {
                if (j2 <= j) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return i2 ^ (-1);
    }
}
