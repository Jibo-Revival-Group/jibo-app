package com.crashlytics.android.core;

/* JADX INFO: loaded from: classes.dex */
class MiddleOutStrategy implements StackTraceTrimmingStrategy {

    /* JADX INFO: renamed from: a */
    private final int f5278a;

    public MiddleOutStrategy(int i) {
        this.f5278a = i;
    }

    @Override // com.crashlytics.android.core.StackTraceTrimmingStrategy
    /* JADX INFO: renamed from: a */
    public StackTraceElement[] mo5935a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length > this.f5278a) {
            int i = this.f5278a / 2;
            int i2 = this.f5278a - i;
            StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[this.f5278a];
            System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i2);
            System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i, stackTraceElementArr2, i2, i);
            return stackTraceElementArr2;
        }
        return stackTraceElementArr;
    }
}
