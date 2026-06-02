package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
abstract class zzb<T> extends zza {

    /* JADX INFO: renamed from: a */
    protected final TaskCompletionSource<T> f6229a;

    public zzb(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.f6229a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zza
    /* JADX INFO: renamed from: a */
    public void mo6961a(Status status) {
        this.f6229a.m8936b(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zza
    /* JADX INFO: renamed from: a */
    public void mo6962a(zzae zzaeVar, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zza
    /* JADX INFO: renamed from: a */
    public final void mo6963a(zzbo<?> zzboVar) throws DeadObjectException {
        try {
            mo7057b(zzboVar);
        } catch (DeadObjectException e) {
            mo6961a(zza.m6960b(e));
            throw e;
        } catch (RemoteException e2) {
            mo6961a(zza.m6960b(e2));
        }
    }

    /* JADX INFO: renamed from: b */
    protected abstract void mo7057b(zzbo<?> zzboVar) throws RemoteException;
}
