package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzr;

/* JADX INFO: loaded from: classes.dex */
final class zzcxb extends Api.zza<zzcxn, zzcxe> {
    zzcxb() {
    }

    @Override // com.google.android.gms.common.api.Api.zza
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Api.zze mo6804a(Context context, Looper looper, zzr zzrVar, zzcxe zzcxeVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzcxe zzcxeVar2 = zzcxeVar;
        return new zzcxn(context, looper, true, zzrVar, zzcxeVar2 == null ? zzcxe.f7775a : zzcxeVar2, connectionCallbacks, onConnectionFailedListener);
    }
}
