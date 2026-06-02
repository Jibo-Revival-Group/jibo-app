package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResultTransform<R extends Result, S extends Result> {
    /* JADX INFO: renamed from: a */
    public abstract PendingResult<S> m6931a(R r);

    /* JADX INFO: renamed from: a */
    public Status m6932a(Status status) {
        return status;
    }
}
