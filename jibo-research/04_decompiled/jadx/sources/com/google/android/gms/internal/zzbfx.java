package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
final class zzbfx extends zzbga {
    zzbfx(zzbfw zzbfwVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.zzm
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ void mo6778a(Api.zzb zzbVar) throws RemoteException {
        ((zzbge) ((zzbgb) zzbVar).m7439v()).mo7767a(new zzbfy(this));
    }
}
