package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a */
    private final CrashListener f5247a;

    /* JADX INFO: renamed from: b */
    private final Thread.UncaughtExceptionHandler f5248b;

    /* JADX INFO: renamed from: c */
    private final AtomicBoolean f5249c = new AtomicBoolean(false);

    interface CrashListener {
        /* JADX INFO: renamed from: a */
        void mo5855a(Thread thread, Throwable th);
    }

    public CrashlyticsUncaughtExceptionHandler(CrashListener crashListener, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f5247a = crashListener;
        this.f5248b = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.f5249c.set(true);
        try {
            this.f5247a.mo5855a(thread, th);
        } catch (Exception e) {
            Fabric.m15085h().mo15073e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
        } finally {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f5248b.uncaughtException(thread, th);
            this.f5249c.set(false);
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m5896a() {
        return this.f5249c.get();
    }
}
