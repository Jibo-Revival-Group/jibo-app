package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class PendingResult<R extends Result> {

    public interface zza {
        /* JADX INFO: renamed from: a */
        void mo6923a(Status status);
    }

    /* JADX INFO: renamed from: a */
    public abstract R mo6917a(long j, TimeUnit timeUnit);

    /* JADX INFO: renamed from: a */
    public abstract void mo6918a();

    /* JADX INFO: renamed from: a */
    public void mo6919a(zza zzaVar) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo6920a(ResultCallback<? super R> resultCallback);

    /* JADX INFO: renamed from: b */
    public abstract boolean mo6921b();

    /* JADX INFO: renamed from: c */
    public Integer mo6922c() {
        throw new UnsupportedOperationException();
    }
}
