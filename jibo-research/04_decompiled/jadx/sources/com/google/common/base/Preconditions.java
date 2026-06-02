package com.google.common.base;

/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    /* JADX INFO: renamed from: a */
    public static void m9017a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m9018a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m9019a(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(m9016a(str, Integer.valueOf(i)));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m9020a(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(m9016a(str, Long.valueOf(j)));
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m9022b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m9023b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* JADX INFO: renamed from: a */
    public static <T> T m9015a(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    /* JADX INFO: renamed from: a */
    public static int m9013a(int i, int i2) {
        return m9014a(i, i2, "index");
    }

    /* JADX INFO: renamed from: a */
    public static int m9014a(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(m9021b(i, i2, str));
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    private static String m9021b(int i, int i2, String str) {
        if (i < 0) {
            return m9016a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        }
        return m9016a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: a */
    static String m9016a(String str, Object... objArr) {
        int iIndexOf;
        int i = 0;
        String strValueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder(strValueOf.length() + (objArr.length * 16));
        int i2 = 0;
        while (i < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i2)) != -1) {
            sb.append((CharSequence) strValueOf, i2, iIndexOf);
            sb.append(objArr[i]);
            i2 = iIndexOf + 2;
            i++;
        }
        sb.append((CharSequence) strValueOf, i2, strValueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            int i3 = i + 1;
            sb.append(objArr[i]);
            while (true) {
                int i4 = i3;
                if (i4 >= objArr.length) {
                    break;
                }
                sb.append(", ");
                i3 = i4 + 1;
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
