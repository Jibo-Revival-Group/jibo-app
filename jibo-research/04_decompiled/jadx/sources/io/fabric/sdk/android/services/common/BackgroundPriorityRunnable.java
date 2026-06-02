package io.fabric.sdk.android.services.common;

import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BackgroundPriorityRunnable implements Runnable {
    /* JADX INFO: renamed from: a */
    protected abstract void mo5968a();

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        mo5968a();
    }
}
