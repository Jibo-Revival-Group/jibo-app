package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

/* JADX INFO: loaded from: classes2.dex */
public class FieldUtils {
    /* JADX INFO: renamed from: a */
    public static int m16751a(int i, int i2) {
        int i3 = i + i2;
        if ((i ^ i3) < 0 && (i ^ i2) >= 0) {
            throw new ArithmeticException("The calculation caused an overflow: " + i + " + " + i2);
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    public static long m16754a(long j, long j2) {
        long j3 = j + j2;
        if ((j ^ j3) < 0 && (j ^ j2) >= 0) {
            throw new ArithmeticException("The calculation caused an overflow: " + j + " + " + j2);
        }
        return j3;
    }

    /* JADX INFO: renamed from: a */
    public static long m16753a(long j, int i) {
        switch (i) {
            case -1:
                if (j == Long.MIN_VALUE) {
                    throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + i);
                }
                return -j;
            case 0:
                return 0L;
            case 1:
                return j;
            default:
                long j2 = ((long) i) * j;
                if (j2 / ((long) i) != j) {
                    throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + i);
                }
                return j2;
        }
    }

    /* JADX INFO: renamed from: b */
    public static long m16758b(long j, long j2) {
        if (j2 == 1) {
            return j;
        }
        if (j == 1) {
            return j2;
        }
        if (j == 0 || j2 == 0) {
            return 0L;
        }
        long j3 = j * j2;
        if (j3 / j2 != j || ((j == Long.MIN_VALUE && j2 == -1) || (j2 == Long.MIN_VALUE && j == -1))) {
            throw new ArithmeticException("Multiplication overflows a long: " + j + " * " + j2);
        }
        return j3;
    }

    /* JADX INFO: renamed from: a */
    public static int m16752a(long j) {
        if (-2147483648L <= j && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("Value cannot fit in an int: " + j);
    }

    /* JADX INFO: renamed from: a */
    public static void m16755a(DateTimeField dateTimeField, int i, int i2, int i3) {
        if (i < i2 || i > i3) {
            throw new IllegalFieldValueException(dateTimeField.mo16442a(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m16756a(DateTimeFieldType dateTimeFieldType, int i, int i2, int i3) {
        if (i < i2 || i > i3) {
            throw new IllegalFieldValueException(dateTimeFieldType, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m16757a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }
}
