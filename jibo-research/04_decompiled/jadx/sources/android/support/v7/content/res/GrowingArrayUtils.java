package android.support.v7.content.res;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
final class GrowingArrayUtils {

    /* JADX INFO: renamed from: a */
    static final /* synthetic */ boolean f3114a;

    static {
        f3114a = !GrowingArrayUtils.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static <T> T[] m3432a(T[] tArr, int i, T t) {
        T[] tArr2;
        if (!f3114a && i > tArr.length) {
            throw new AssertionError();
        }
        if (i + 1 > tArr.length) {
            tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), m3430a(i)));
            System.arraycopy(tArr, 0, tArr2, 0, i);
        } else {
            tArr2 = tArr;
        }
        tArr2[i] = t;
        return tArr2;
    }

    /* JADX INFO: renamed from: a */
    public static int[] m3431a(int[] iArr, int i, int i2) {
        if (!f3114a && i > iArr.length) {
            throw new AssertionError();
        }
        if (i + 1 > iArr.length) {
            int[] iArr2 = new int[m3430a(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr = iArr2;
        }
        iArr[i] = i2;
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    public static int m3430a(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    private GrowingArrayUtils() {
    }
}
