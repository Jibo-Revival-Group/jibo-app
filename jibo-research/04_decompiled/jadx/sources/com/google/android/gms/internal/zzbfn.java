package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfn {
    /* JADX INFO: renamed from: A */
    public static ArrayList<Integer> m7695A(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i2 = parcel.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(iDataPosition + iM7701a);
        return arrayList;
    }

    /* JADX INFO: renamed from: B */
    public static ArrayList<String> m7696B(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iM7701a + iDataPosition);
        return arrayListCreateStringArrayList;
    }

    /* JADX INFO: renamed from: C */
    public static Parcel m7697C(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(parcel, iDataPosition, iM7701a);
        parcel.setDataPosition(iM7701a + iDataPosition);
        return parcelObtain;
    }

    /* JADX INFO: renamed from: D */
    public static Parcel[] m7698D(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        int i2 = parcel.readInt();
        Parcel[] parcelArr = new Parcel[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = parcel.readInt();
            if (i4 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i4);
                parcelArr[i3] = parcelObtain;
                parcel.setDataPosition(i4 + iDataPosition2);
            } else {
                parcelArr[i3] = null;
            }
        }
        parcel.setDataPosition(iDataPosition + iM7701a);
        return parcelArr;
    }

    /* JADX INFO: renamed from: E */
    public static void m7699E(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new zzbfo(new StringBuilder(37).append("Overread allowed size end=").append(i).toString(), parcel);
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m7700a(Parcel parcel) {
        int i = parcel.readInt();
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if ((65535 & i) != 20293) {
            String strValueOf = String.valueOf(Integer.toHexString(i));
            throw new zzbfo(strValueOf.length() != 0 ? "Expected object header. Got 0x".concat(strValueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = iDataPosition + iM7701a;
        if (i2 < iDataPosition || i2 > parcel.dataSize()) {
            throw new zzbfo(new StringBuilder(54).append("Size read is invalid start=").append(iDataPosition).append(" end=").append(i2).toString(), parcel);
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    public static int m7701a(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Parcelable> T m7702a(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iM7701a + iDataPosition);
        return tCreateFromParcel;
    }

    /* JADX INFO: renamed from: a */
    private static void m7703a(Parcel parcel, int i, int i2) {
        int iM7701a = m7701a(parcel, i);
        if (iM7701a != i2) {
            String hexString = Integer.toHexString(iM7701a);
            throw new zzbfo(new StringBuilder(String.valueOf(hexString).length() + 46).append("Expected size ").append(i2).append(" got ").append(iM7701a).append(" (0x").append(hexString).append(")").toString(), parcel);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m7704a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String hexString = Integer.toHexString(i2);
            throw new zzbfo(new StringBuilder(String.valueOf(hexString).length() + 46).append("Expected size ").append(i3).append(" got ").append(i2).append(" (0x").append(hexString).append(")").toString(), parcel);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7705a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(iM7701a + iDataPosition);
    }

    /* JADX INFO: renamed from: b */
    public static void m7706b(Parcel parcel, int i) {
        parcel.setDataPosition(m7701a(parcel, i) + parcel.dataPosition());
    }

    /* JADX INFO: renamed from: b */
    public static <T> T[] m7707b(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iM7701a + iDataPosition);
        return tArr;
    }

    /* JADX INFO: renamed from: c */
    public static <T> ArrayList<T> m7708c(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iM7701a + iDataPosition);
        return arrayListCreateTypedArrayList;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m7709c(Parcel parcel, int i) {
        m7703a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    /* JADX INFO: renamed from: d */
    public static byte m7710d(Parcel parcel, int i) {
        m7703a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    /* JADX INFO: renamed from: e */
    public static short m7711e(Parcel parcel, int i) {
        m7703a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    /* JADX INFO: renamed from: f */
    public static int m7712f(Parcel parcel, int i) {
        m7703a(parcel, i, 4);
        return parcel.readInt();
    }

    /* JADX INFO: renamed from: g */
    public static Integer m7713g(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        if (iM7701a == 0) {
            return null;
        }
        m7704a(parcel, i, iM7701a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    /* JADX INFO: renamed from: h */
    public static long m7714h(Parcel parcel, int i) {
        m7703a(parcel, i, 8);
        return parcel.readLong();
    }

    /* JADX INFO: renamed from: i */
    public static Long m7715i(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        if (iM7701a == 0) {
            return null;
        }
        m7704a(parcel, i, iM7701a, 8);
        return Long.valueOf(parcel.readLong());
    }

    /* JADX INFO: renamed from: j */
    public static BigInteger m7716j(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iM7701a + iDataPosition);
        return new BigInteger(bArrCreateByteArray);
    }

    /* JADX INFO: renamed from: k */
    public static float m7717k(Parcel parcel, int i) {
        m7703a(parcel, i, 4);
        return parcel.readFloat();
    }

    /* JADX INFO: renamed from: l */
    public static Float m7718l(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        if (iM7701a == 0) {
            return null;
        }
        m7704a(parcel, i, iM7701a, 4);
        return Float.valueOf(parcel.readFloat());
    }

    /* JADX INFO: renamed from: m */
    public static double m7719m(Parcel parcel, int i) {
        m7703a(parcel, i, 8);
        return parcel.readDouble();
    }

    /* JADX INFO: renamed from: n */
    public static Double m7720n(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        if (iM7701a == 0) {
            return null;
        }
        m7704a(parcel, i, iM7701a, 8);
        return Double.valueOf(parcel.readDouble());
    }

    /* JADX INFO: renamed from: o */
    public static BigDecimal m7721o(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i2 = parcel.readInt();
        parcel.setDataPosition(iM7701a + iDataPosition);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i2);
    }

    /* JADX INFO: renamed from: p */
    public static String m7722p(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iM7701a + iDataPosition);
        return string;
    }

    /* JADX INFO: renamed from: q */
    public static IBinder m7723q(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iM7701a + iDataPosition);
        return strongBinder;
    }

    /* JADX INFO: renamed from: r */
    public static Bundle m7724r(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iM7701a + iDataPosition);
        return bundle;
    }

    /* JADX INFO: renamed from: s */
    public static byte[] m7725s(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iM7701a + iDataPosition);
        return bArrCreateByteArray;
    }

    /* JADX INFO: renamed from: t */
    public static byte[][] m7726t(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        int i2 = parcel.readInt();
        byte[][] bArr = new byte[i2][];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = parcel.createByteArray();
        }
        parcel.setDataPosition(iDataPosition + iM7701a);
        return bArr;
    }

    /* JADX INFO: renamed from: u */
    public static boolean[] m7727u(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(iM7701a + iDataPosition);
        return zArrCreateBooleanArray;
    }

    /* JADX INFO: renamed from: v */
    public static int[] m7728v(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iM7701a + iDataPosition);
        return iArrCreateIntArray;
    }

    /* JADX INFO: renamed from: w */
    public static long[] m7729w(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iM7701a + iDataPosition);
        return jArrCreateLongArray;
    }

    /* JADX INFO: renamed from: x */
    public static float[] m7730x(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        float[] fArrCreateFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(iM7701a + iDataPosition);
        return fArrCreateFloatArray;
    }

    /* JADX INFO: renamed from: y */
    public static BigDecimal[] m7731y(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        int i2 = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            bigDecimalArr[i3] = new BigDecimal(new BigInteger(bArrCreateByteArray), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + iM7701a);
        return bigDecimalArr;
    }

    /* JADX INFO: renamed from: z */
    public static String[] m7732z(Parcel parcel, int i) {
        int iM7701a = m7701a(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7701a == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iM7701a + iDataPosition);
        return strArrCreateStringArray;
    }
}
