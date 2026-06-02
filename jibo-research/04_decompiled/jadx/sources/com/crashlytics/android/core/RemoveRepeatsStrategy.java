package com.crashlytics.android.core;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy {

    /* JADX INFO: renamed from: a */
    private final int f5320a;

    public RemoveRepeatsStrategy() {
        this(1);
    }

    public RemoveRepeatsStrategy(int i) {
        this.f5320a = i;
    }

    @Override // com.crashlytics.android.core.StackTraceTrimmingStrategy
    /* JADX INFO: renamed from: a */
    public StackTraceElement[] mo5935a(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] stackTraceElementArrM5960a = m5960a(stackTraceElementArr, this.f5320a);
        return stackTraceElementArrM5960a.length < stackTraceElementArr.length ? stackTraceElementArrM5960a : stackTraceElementArr;
    }

    /* JADX INFO: renamed from: a */
    private static StackTraceElement[] m5960a(StackTraceElement[] stackTraceElementArr, int i) {
        int i2;
        HashMap map = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i3];
            Integer num = (Integer) map.get(stackTraceElement);
            if (num == null || !m5959a(stackTraceElementArr, num.intValue(), i3)) {
                stackTraceElementArr2[i5] = stackTraceElementArr[i3];
                i5++;
                i2 = i3;
                i4 = 1;
            } else {
                int iIntValue = i3 - num.intValue();
                if (i4 < i) {
                    System.arraycopy(stackTraceElementArr, i3, stackTraceElementArr2, i5, iIntValue);
                    i5 += iIntValue;
                    i4++;
                }
                i2 = (iIntValue - 1) + i3;
            }
            map.put(stackTraceElement, Integer.valueOf(i3));
            i3 = i2 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i5];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, stackTraceElementArr3.length);
        return stackTraceElementArr3;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m5959a(StackTraceElement[] stackTraceElementArr, int i, int i2) {
        int i3 = i2 - i;
        if (i2 + i3 > stackTraceElementArr.length) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!stackTraceElementArr[i + i4].equals(stackTraceElementArr[i2 + i4])) {
                return false;
            }
        }
        return true;
    }
}
