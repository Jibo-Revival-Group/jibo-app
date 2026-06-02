package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzcq<A extends Api.zzb, L> {

    /* JADX INFO: renamed from: a */
    private final zzci<L> f6355a;

    /* JADX INFO: renamed from: a */
    public final void m7175a() {
        this.f6355a.m7169a();
    }

    /* JADX INFO: renamed from: a */
    protected abstract void m7176a(A a, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;
}
