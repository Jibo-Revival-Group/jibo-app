package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class Task<TResult> {
    /* JADX INFO: renamed from: a */
    public Task<TResult> mo8926a(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    /* JADX INFO: renamed from: a */
    public abstract Task<TResult> mo8927a(Executor executor, OnFailureListener onFailureListener);

    /* JADX INFO: renamed from: a */
    public abstract Task<TResult> mo8928a(Executor executor, OnSuccessListener<? super TResult> onSuccessListener);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo8929a();

    /* JADX INFO: renamed from: b */
    public abstract boolean mo8930b();

    /* JADX INFO: renamed from: c */
    public abstract TResult mo8931c();

    /* JADX INFO: renamed from: d */
    public abstract Exception mo8932d();
}
