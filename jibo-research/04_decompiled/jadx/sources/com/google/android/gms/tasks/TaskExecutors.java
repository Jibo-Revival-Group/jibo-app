package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class TaskExecutors {

    /* JADX INFO: renamed from: a */
    public static final Executor f8404a = new zza();

    /* JADX INFO: renamed from: b */
    static final Executor f8405b = new zzm();

    static final class zza implements Executor {

        /* JADX INFO: renamed from: a */
        private final Handler f8406a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f8406a.post(runnable);
        }
    }
}
