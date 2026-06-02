package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzdn<A extends Api.zzb, L> {
    /* JADX INFO: renamed from: a */
    protected abstract void m7207a(A a, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;
}
