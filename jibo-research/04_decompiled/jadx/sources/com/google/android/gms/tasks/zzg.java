package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzg<TResult> implements zzk<TResult> {

    /* JADX INFO: renamed from: a */
    private final Executor f8413a;

    /* JADX INFO: renamed from: b */
    private final Object f8414b = new Object();

    /* JADX INFO: renamed from: c */
    private OnFailureListener f8415c;

    public zzg(Executor executor, OnFailureListener onFailureListener) {
        this.f8413a = executor;
        this.f8415c = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.zzk
    /* JADX INFO: renamed from: a */
    public final void mo8949a(Task<TResult> task) {
        if (task.mo8930b()) {
            return;
        }
        synchronized (this.f8414b) {
            if (this.f8415c != null) {
                this.f8413a.execute(new zzh(this, task));
            }
        }
    }
}
