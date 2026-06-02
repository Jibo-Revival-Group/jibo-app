package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.util.Arrays;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class zzfjq {

    /* JADX INFO: renamed from: a */
    protected static final Charset f7964a = Charset.forName(HTTP.UTF_8);

    /* JADX INFO: renamed from: c */
    private static Charset f7966c = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: b */
    public static final Object f7965b = new Object();

    /* JADX INFO: renamed from: a */
    public static int m8696a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(iArr);
    }

    /* JADX INFO: renamed from: a */
    public static int m8697a(long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(jArr);
    }

    /* JADX INFO: renamed from: a */
    public static int m8698a(Object[] objArr) {
        int iHashCode = 0;
        int length = objArr == null ? 0 : objArr.length;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            if (obj != null) {
                iHashCode = (iHashCode * 31) + obj.hashCode();
            }
        }
        return iHashCode;
    }

    /* JADX INFO: renamed from: a */
    public static int m8699a(byte[][] bArr) {
        int iHashCode = 0;
        int length = bArr == null ? 0 : bArr.length;
        for (int i = 0; i < length; i++) {
            byte[] bArr2 = bArr[i];
            if (bArr2 != null) {
                iHashCode = (iHashCode * 31) + Arrays.hashCode(bArr2);
            }
        }
        return iHashCode;
    }

    /* JADX INFO: renamed from: a */
    public static void m8700a(zzfjm zzfjmVar, zzfjm zzfjmVar2) {
        if (zzfjmVar.f7951H != null) {
            zzfjmVar2.f7951H = (zzfjo) zzfjmVar.f7951H.clone();
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8701a(int[] iArr, int[] iArr2) {
        return (iArr == null || iArr.length == 0) ? iArr2 == null || iArr2.length == 0 : Arrays.equals(iArr, iArr2);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8702a(long[] jArr, long[] jArr2) {
        return (jArr == null || jArr.length == 0) ? jArr2 == null || jArr2.length == 0 : Arrays.equals(jArr, jArr2);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8703a(Object[] objArr, Object[] objArr2) {
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length || objArr[i2] != null) {
                int i3 = i;
                while (i3 < length2 && objArr2[i3] == null) {
                    i3++;
                }
                boolean z = i2 >= length;
                boolean z2 = i3 >= length2;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !objArr[i2].equals(objArr2[i3])) {
                    return false;
                }
                i = i3 + 1;
                i2++;
            } else {
                i2++;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8704a(byte[][] bArr, byte[][] bArr2) {
        int length = bArr == null ? 0 : bArr.length;
        int length2 = bArr2 == null ? 0 : bArr2.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length || bArr[i2] != null) {
                int i3 = i;
                while (i3 < length2 && bArr2[i3] == null) {
                    i3++;
                }
                boolean z = i2 >= length;
                boolean z2 = i3 >= length2;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !Arrays.equals(bArr[i2], bArr2[i3])) {
                    return false;
                }
                i = i3 + 1;
                i2++;
            } else {
                i2++;
            }
        }
    }
}
