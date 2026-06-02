package com.crashlytics.android.core;

/* JADX INFO: loaded from: classes.dex */
class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {

    /* JADX INFO: renamed from: a */
    private final int f5275a;

    /* JADX INFO: renamed from: b */
    private final StackTraceTrimmingStrategy[] f5276b;

    /* JADX INFO: renamed from: c */
    private final MiddleOutStrategy f5277c;

    public MiddleOutFallbackStrategy(int i, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.f5275a = i;
        this.f5276b = stackTraceTrimmingStrategyArr;
        this.f5277c = new MiddleOutStrategy(i);
    }

    @Override // com.crashlytics.android.core.StackTraceTrimmingStrategy
    /* JADX INFO: renamed from: a */
    public StackTraceElement[] mo5935a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length > this.f5275a) {
            StackTraceTrimmingStrategy[] stackTraceTrimmingStrategyArr = this.f5276b;
            int length = stackTraceTrimmingStrategyArr.length;
            int i = 0;
            StackTraceElement[] stackTraceElementArrMo5935a = stackTraceElementArr;
            while (i < length) {
                StackTraceTrimmingStrategy stackTraceTrimmingStrategy = stackTraceTrimmingStrategyArr[i];
                if (stackTraceElementArrMo5935a.length <= this.f5275a) {
                    break;
                }
                i++;
                stackTraceElementArrMo5935a = stackTraceTrimmingStrategy.mo5935a(stackTraceElementArr);
            }
            if (stackTraceElementArrMo5935a.length > this.f5275a) {
                stackTraceElementArrMo5935a = this.f5277c.mo5935a(stackTraceElementArrMo5935a);
            }
            return stackTraceElementArrMo5935a;
        }
        return stackTraceElementArr;
    }
}
