package android.support.v4.util;

import java.io.PrintWriter;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final class TimeUtils {

    /* JADX INFO: renamed from: a */
    private static final Object f2245a = new Object();

    /* JADX INFO: renamed from: b */
    private static char[] f2246b = new char[24];

    /* JADX INFO: renamed from: a */
    private static int m2468a(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    private static int m2470a(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        int i5;
        if (z || i > 0) {
            if ((!z || i3 < 3) && i <= 99) {
                i4 = i2;
                i5 = i;
            } else {
                int i6 = i / 100;
                cArr[i2] = (char) (i6 + 48);
                i4 = i2 + 1;
                i5 = i - (i6 * 100);
            }
            if ((z && i3 >= 2) || i5 > 9 || i2 != i4) {
                int i7 = i5 / 10;
                cArr[i4] = (char) (i7 + 48);
                i4++;
                i5 -= i7 * 10;
            }
            cArr[i4] = (char) (i5 + 48);
            int i8 = i4 + 1;
            cArr[i8] = c;
            return i8 + 1;
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    private static int m2469a(long j, int i) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (f2246b.length < i) {
            f2246b = new char[i];
        }
        char[] cArr = f2246b;
        if (j == 0) {
            int i7 = i - 1;
            while (0 < i7) {
                cArr[0] = TokenParser.f15715SP;
            }
            cArr[0] = '0';
            return 1;
        }
        if (j > 0) {
            c = '+';
        } else {
            j = -j;
            c = '-';
        }
        int i8 = (int) (j % 1000);
        int iFloor = (int) Math.floor(j / 1000);
        int i9 = 0;
        if (iFloor > 86400) {
            i9 = iFloor / 86400;
            iFloor -= 86400 * i9;
        }
        if (iFloor > 3600) {
            int i10 = iFloor / 3600;
            i2 = i10;
            i3 = iFloor - (i10 * 3600);
        } else {
            i2 = 0;
            i3 = iFloor;
        }
        if (i3 > 60) {
            int i11 = i3 / 60;
            i4 = i11;
            i5 = i3 - (i11 * 60);
        } else {
            i4 = 0;
            i5 = i3;
        }
        if (i == 0) {
            i6 = 0;
        } else {
            int iM2468a = m2468a(i9, 1, false, 0);
            int iM2468a2 = iM2468a + m2468a(i2, 1, iM2468a > 0, 2);
            int iM2468a3 = iM2468a2 + m2468a(i4, 1, iM2468a2 > 0, 2);
            int iM2468a4 = iM2468a3 + m2468a(i5, 1, iM2468a3 > 0, 2);
            i6 = 0;
            int iM2468a5 = m2468a(i8, 2, true, iM2468a4 > 0 ? 3 : 0) + 1 + iM2468a4;
            while (iM2468a5 < i) {
                cArr[i6] = TokenParser.f15715SP;
                iM2468a5++;
                i6++;
            }
        }
        cArr[i6] = c;
        int i12 = i6 + 1;
        boolean z = i != 0;
        int iM2470a = m2470a(cArr, i9, 'd', i12, false, 0);
        int iM2470a2 = m2470a(cArr, i2, 'h', iM2470a, iM2470a != i12, z ? 2 : 0);
        int iM2470a3 = m2470a(cArr, i4, 'm', iM2470a2, iM2470a2 != i12, z ? 2 : 0);
        int iM2470a4 = m2470a(cArr, i5, 's', iM2470a3, iM2470a3 != i12, z ? 2 : 0);
        int iM2470a5 = m2470a(cArr, i8, 'm', iM2470a4, true, (!z || iM2470a4 == i12) ? 0 : 3);
        cArr[iM2470a5] = 's';
        return iM2470a5 + 1;
    }

    /* JADX INFO: renamed from: a */
    public static void m2473a(long j, PrintWriter printWriter, int i) {
        synchronized (f2245a) {
            printWriter.print(new String(f2246b, 0, m2469a(j, i)));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2472a(long j, PrintWriter printWriter) {
        m2473a(j, printWriter, 0);
    }

    /* JADX INFO: renamed from: a */
    public static void m2471a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            m2473a(j - j2, printWriter, 0);
        }
    }
}
