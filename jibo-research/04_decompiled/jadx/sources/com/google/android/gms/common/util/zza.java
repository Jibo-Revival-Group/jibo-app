package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zzbg;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zza {
    /* JADX INFO: renamed from: a */
    public static void m7486a(StringBuilder sb, double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(dArr[i]));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7487a(StringBuilder sb, float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(fArr[i]));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7488a(StringBuilder sb, long[] jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(jArr[i]));
        }
    }

    /* JADX INFO: renamed from: a */
    public static <T> void m7489a(StringBuilder sb, T[] tArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(tArr[i].toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7490a(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append("\"").append(strArr[i]).append("\"");
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7491a(StringBuilder sb, boolean[] zArr) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(zArr[i]));
        }
    }

    /* JADX INFO: renamed from: a */
    public static <T> T[] m7492a(T[] tArr, T... tArr2) {
        int i;
        int i2;
        int i3;
        if (tArr == null) {
            return null;
        }
        if (tArr2.length == 0) {
            return (T[]) Arrays.copyOf(tArr, tArr.length);
        }
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length));
        if (tArr2.length == 1) {
            int length = tArr.length;
            int i4 = 0;
            i = 0;
            while (i4 < length) {
                T t = tArr[i4];
                if (zzbg.m7371a(tArr2[0], t)) {
                    i3 = i;
                } else {
                    i3 = i + 1;
                    tArr3[i] = t;
                }
                i4++;
                i = i3;
            }
        } else {
            int length2 = tArr.length;
            int i5 = 0;
            i = 0;
            while (i5 < length2) {
                T t2 = tArr[i5];
                int length3 = tArr2.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length3) {
                        i6 = -1;
                        break;
                    }
                    if (zzbg.m7371a(tArr2[i6], t2)) {
                        break;
                    }
                    i6++;
                }
                if (i6 >= 0) {
                    i2 = i;
                } else {
                    i2 = i + 1;
                    tArr3[i] = t2;
                }
                i5++;
                i = i2;
            }
        }
        if (tArr3 == null) {
            return null;
        }
        return i != tArr3.length ? (T[]) Arrays.copyOf(tArr3, i) : tArr3;
    }
}
