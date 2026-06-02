package com.crashlytics.android.core;

/* JADX INFO: loaded from: classes.dex */
class TrimmedThrowableData {

    /* JADX INFO: renamed from: a */
    public final String f5337a;

    /* JADX INFO: renamed from: b */
    public final String f5338b;

    /* JADX INFO: renamed from: c */
    public final StackTraceElement[] f5339c;

    /* JADX INFO: renamed from: d */
    public final TrimmedThrowableData f5340d;

    public TrimmedThrowableData(Throwable th, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.f5337a = th.getLocalizedMessage();
        this.f5338b = th.getClass().getName();
        this.f5339c = stackTraceTrimmingStrategy.mo5935a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f5340d = cause != null ? new TrimmedThrowableData(cause, stackTraceTrimmingStrategy) : null;
    }
}
