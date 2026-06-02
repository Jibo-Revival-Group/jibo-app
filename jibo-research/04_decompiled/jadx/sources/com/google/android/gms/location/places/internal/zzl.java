package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.zzm;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzl extends zzm.zzc<zzn> {

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String[] f8205b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzl(zzh zzhVar, Api api, GoogleApiClient googleApiClient, String[] strArr) {
        super(api, googleApiClient);
        this.f8205b = strArr;
    }

    @Override // com.google.android.gms.common.api.internal.zzm
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ void mo6778a(Api.zzb zzbVar) throws RemoteException {
        ((zzn) zzbVar).m8801a(new com.google.android.gms.location.places.zzm(this), Arrays.asList(this.f8205b));
    }
}
