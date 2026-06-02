package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfp {
    /* JADX INFO: renamed from: a */
    public static int m7733a(Parcel parcel) {
        return m7758b(parcel, 20293);
    }

    /* JADX INFO: renamed from: a */
    public static void m7734a(Parcel parcel, int i) {
        m7761c(parcel, i);
    }

    /* JADX INFO: renamed from: a */
    public static void m7735a(Parcel parcel, int i, byte b) {
        m7759b(parcel, i, 4);
        parcel.writeInt(b);
    }

    /* JADX INFO: renamed from: a */
    public static void m7736a(Parcel parcel, int i, double d) {
        m7759b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    /* JADX INFO: renamed from: a */
    public static void m7737a(Parcel parcel, int i, float f) {
        m7759b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    /* JADX INFO: renamed from: a */
    public static void m7738a(Parcel parcel, int i, int i2) {
        m7759b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    /* JADX INFO: renamed from: a */
    public static void m7739a(Parcel parcel, int i, long j) {
        m7759b(parcel, i, 8);
        parcel.writeLong(j);
    }

    /* JADX INFO: renamed from: a */
    public static void m7740a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            return;
        }
        int iM7758b = m7758b(parcel, i);
        parcel.writeBundle(bundle);
        m7761c(parcel, iM7758b);
    }

    /* JADX INFO: renamed from: a */
    public static void m7741a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            return;
        }
        int iM7758b = m7758b(parcel, i);
        parcel.writeStrongBinder(iBinder);
        m7761c(parcel, iM7758b);
    }

    /* JADX INFO: renamed from: a */
    public static void m7742a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 == null) {
            return;
        }
        int iM7758b = m7758b(parcel, 2);
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        m7761c(parcel, iM7758b);
    }

    /* JADX INFO: renamed from: a */
    public static void m7743a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                m7759b(parcel, i, 0);
            }
        } else {
            int iM7758b = m7758b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m7761c(parcel, iM7758b);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7744a(Parcel parcel, int i, Double d, boolean z) {
        if (d == null) {
            return;
        }
        m7759b(parcel, i, 8);
        parcel.writeDouble(d.doubleValue());
    }

    /* JADX INFO: renamed from: a */
    public static void m7745a(Parcel parcel, int i, Float f, boolean z) {
        if (f == null) {
            return;
        }
        m7759b(parcel, i, 4);
        parcel.writeFloat(f.floatValue());
    }

    /* JADX INFO: renamed from: a */
    public static void m7746a(Parcel parcel, int i, Integer num, boolean z) {
        if (num == null) {
            return;
        }
        m7759b(parcel, i, 4);
        parcel.writeInt(num.intValue());
    }

    /* JADX INFO: renamed from: a */
    public static void m7747a(Parcel parcel, int i, Long l, boolean z) {
        if (l == null) {
            return;
        }
        m7759b(parcel, i, 8);
        parcel.writeLong(l.longValue());
    }

    /* JADX INFO: renamed from: a */
    public static void m7748a(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                m7759b(parcel, i, 0);
            }
        } else {
            int iM7758b = m7758b(parcel, i);
            parcel.writeString(str);
            m7761c(parcel, iM7758b);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7749a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list == null) {
            return;
        }
        int iM7758b = m7758b(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(list.get(i2).intValue());
        }
        m7761c(parcel, iM7758b);
    }

    /* JADX INFO: renamed from: a */
    public static void m7750a(Parcel parcel, int i, short s) {
        m7759b(parcel, 3, 4);
        parcel.writeInt(s);
    }

    /* JADX INFO: renamed from: a */
    public static void m7751a(Parcel parcel, int i, boolean z) {
        m7759b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    /* JADX INFO: renamed from: a */
    public static void m7752a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                m7759b(parcel, i, 0);
            }
        } else {
            int iM7758b = m7758b(parcel, i);
            parcel.writeByteArray(bArr);
            m7761c(parcel, iM7758b);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7753a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr == null) {
            return;
        }
        int iM7758b = m7758b(parcel, i);
        parcel.writeIntArray(iArr);
        m7761c(parcel, iM7758b);
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Parcelable> void m7754a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr == null) {
            return;
        }
        int iM7758b = m7758b(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                m7757a(parcel, t, i2);
            }
        }
        m7761c(parcel, iM7758b);
    }

    /* JADX INFO: renamed from: a */
    public static void m7755a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr == null) {
            return;
        }
        int iM7758b = m7758b(parcel, i);
        parcel.writeStringArray(strArr);
        m7761c(parcel, iM7758b);
    }

    /* JADX INFO: renamed from: a */
    public static void m7756a(Parcel parcel, int i, byte[][] bArr, boolean z) {
        if (bArr == null) {
            return;
        }
        int iM7758b = m7758b(parcel, i);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        m7761c(parcel, iM7758b);
    }

    /* JADX INFO: renamed from: a */
    private static <T extends Parcelable> void m7757a(Parcel parcel, T t, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    /* JADX INFO: renamed from: b */
    private static int m7758b(Parcel parcel, int i) {
        parcel.writeInt((-65536) | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* JADX INFO: renamed from: b */
    private static void m7759b(Parcel parcel, int i, int i2) {
        if (i2 < 65535) {
            parcel.writeInt((i2 << 16) | i);
        } else {
            parcel.writeInt((-65536) | i);
            parcel.writeInt(i2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m7760b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list == null) {
            return;
        }
        int iM7758b = m7758b(parcel, i);
        parcel.writeStringList(list);
        m7761c(parcel, iM7758b);
    }

    /* JADX INFO: renamed from: c */
    private static void m7761c(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    /* JADX INFO: renamed from: c */
    public static <T extends Parcelable> void m7762c(Parcel parcel, int i, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                m7759b(parcel, i, 0);
                return;
            }
            return;
        }
        int iM7758b = m7758b(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                m7757a(parcel, t, 0);
            }
        }
        m7761c(parcel, iM7758b);
    }

    /* JADX INFO: renamed from: d */
    public static void m7763d(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            return;
        }
        int iM7758b = m7758b(parcel, i);
        parcel.writeList(list);
        m7761c(parcel, iM7758b);
    }
}
