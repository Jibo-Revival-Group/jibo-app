package com.crashlytics.android.core;

import android.os.Looper;
import io.fabric.sdk.android.Fabric;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class CrashlyticsBackgroundWorker {

    /* JADX INFO: renamed from: a */
    private final ExecutorService f5165a;

    public CrashlyticsBackgroundWorker(ExecutorService executorService) {
        this.f5165a = executorService;
    }

    /* JADX INFO: renamed from: a */
    <T> T m5779a(Callable<T> callable) {
        T t = null;
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                t = this.f5165a.submit(callable).get(4L, TimeUnit.SECONDS);
            } else {
                t = this.f5165a.submit(callable).get();
            }
        } catch (RejectedExecutionException e) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
        } catch (Exception e2) {
            Fabric.m15085h().mo15073e("CrashlyticsCore", "Failed to execute task.", e2);
        }
        return t;
    }

    /* JADX INFO: renamed from: a */
    Future<?> m5780a(final Runnable runnable) {
        try {
            return this.f5165a.submit(new Runnable() { // from class: com.crashlytics.android.core.CrashlyticsBackgroundWorker.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        Fabric.m15085h().mo15073e("CrashlyticsCore", "Failed to execute task.", e);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    <T> Future<T> m5781b(final Callable<T> callable) {
        try {
            return this.f5165a.submit(new Callable<T>() { // from class: com.crashlytics.android.core.CrashlyticsBackgroundWorker.2
                @Override // java.util.concurrent.Callable
                public T call() throws Exception {
                    try {
                        return (T) callable.call();
                    } catch (Exception e) {
                        Fabric.m15085h().mo15073e("CrashlyticsCore", "Failed to execute task.", e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
