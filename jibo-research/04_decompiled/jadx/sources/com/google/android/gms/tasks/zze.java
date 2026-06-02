package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zze<TResult> implements zzk<TResult> {

    /* JADX INFO: renamed from: a */
    private final Executor f8408a;

    /* JADX INFO: renamed from: b */
    private final Object f8409b = new Object();

    /* JADX INFO: renamed from: c */
    private OnCompleteListener<TResult> f8410c;

    public zze(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f8408a = executor;
        this.f8410c = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.zzk
    /* JADX INFO: renamed from: a */
    public final void mo8949a(Task<TResult> task) {
        synchronized (this.f8409b) {
            if (this.f8410c == null) {
                return;
            }
            this.f8408a.execute(new zzf(this, task));
        }
    }
}
