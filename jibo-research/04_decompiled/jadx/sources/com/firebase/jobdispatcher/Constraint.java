package com.firebase.jobdispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class Constraint {

    /* JADX INFO: renamed from: a */
    static final int[] f5691a = {2, 1, 4, 8};

    /* JADX INFO: renamed from: a */
    static int m6495a(int[] iArr) {
        int i = 0;
        if (iArr != null) {
            int length = iArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = iArr[i2] | i;
                i2++;
                i = i3;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    static int[] m6496a(int i) {
        int i2;
        int i3 = 0;
        int[] iArr = f5691a;
        int length = iArr.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            i4 += (i & i6) == i6 ? 1 : 0;
        }
        int[] iArr2 = new int[i4];
        int[] iArr3 = f5691a;
        int length2 = iArr3.length;
        int i7 = 0;
        while (i7 < length2) {
            int i8 = iArr3[i7];
            if ((i & i8) == i8) {
                i2 = i3 + 1;
                iArr2[i3] = i8;
            } else {
                i2 = i3;
            }
            i7++;
            i3 = i2;
        }
        return iArr2;
    }
}
