package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzbha implements Executor {

    /* JADX INFO: renamed from: a */
    private final Handler f6977a;

    public zzbha(Looper looper) {
        this.f6977a = new Handler(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f6977a.post(runnable);
    }
}
