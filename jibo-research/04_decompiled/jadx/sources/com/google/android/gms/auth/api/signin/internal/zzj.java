package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zzj extends zzl<Status> {
    zzj(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ Result mo6777a(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.zzm
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ void mo6778a(Api.zzb zzbVar) throws RemoteException {
        zzd zzdVar = (zzd) zzbVar;
        ((zzu) zzdVar.m7439v()).mo6790a(new zzk(this), zzdVar.m6773e());
    }
}
