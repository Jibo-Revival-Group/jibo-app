package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzi<TResult> implements zzk<TResult> {

    /* JADX INFO: renamed from: a */
    private final Executor f8418a;

    /* JADX INFO: renamed from: b */
    private final Object f8419b = new Object();

    /* JADX INFO: renamed from: c */
    private OnSuccessListener<? super TResult> f8420c;

    public zzi(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f8418a = executor;
        this.f8420c = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.zzk
    /* JADX INFO: renamed from: a */
    public final void mo8949a(Task<TResult> task) {
        if (task.mo8930b()) {
            synchronized (this.f8419b) {
                if (this.f8420c != null) {
                    this.f8418a.execute(new zzj(this, task));
                }
            }
        }
    }
}
