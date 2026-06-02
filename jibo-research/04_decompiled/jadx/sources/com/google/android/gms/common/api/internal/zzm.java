package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzm<R extends Result, A extends Api.zzb> extends BasePendingResult<R> implements zzn<R> {

    /* JADX INFO: renamed from: b */
    private final Api.zzc<A> f6419b;

    /* JADX INFO: renamed from: c */
    private final Api<?> f6420c;

    protected zzm(Api<?> api, GoogleApiClient googleApiClient) {
        super((GoogleApiClient) com.google.android.gms.common.internal.zzbq.m7374a(googleApiClient, "GoogleApiClient must not be null"));
        com.google.android.gms.common.internal.zzbq.m7374a(api, "Api must not be null");
        this.f6419b = (Api.zzc<A>) api.m6852c();
        this.f6420c = api;
    }

    /* JADX INFO: renamed from: a */
    private final void m7223a(RemoteException remoteException) {
        m7225c(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo6778a(A a) throws RemoteException;

    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6779a(Object obj) {
        super.m6942a((Result) obj);
    }

    /* JADX INFO: renamed from: b */
    public final void m7224b(A a) throws DeadObjectException {
        if (a instanceof com.google.android.gms.common.internal.zzbz) {
            a = com.google.android.gms.common.internal.zzbz.m7395e();
        }
        try {
            mo6778a((Api.zzb) a);
        } catch (DeadObjectException e) {
            m7223a((RemoteException) e);
            throw e;
        } catch (RemoteException e2) {
            m7223a(e2);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m7225c(Status status) {
        com.google.android.gms.common.internal.zzbq.m7383b(!status.m6935c(), "Failed result must not be success");
        m6942a((Result) mo6777a(status));
    }

    /* JADX INFO: renamed from: g */
    public final Api.zzc<A> m7226g() {
        return this.f6419b;
    }

    /* JADX INFO: renamed from: h */
    public final Api<?> m7227h() {
        return this.f6420c;
    }
}
