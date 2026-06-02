package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzcfk;

/* JADX INFO: loaded from: classes.dex */
final class zzy extends Api.zza<zzcfk, Object> {
    zzy() {
    }

    @Override // com.google.android.gms.common.api.Api.zza
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Api.zze mo6804a(Context context, Looper looper, com.google.android.gms.common.internal.zzr zzrVar, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzcfk(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices", zzrVar);
    }
}
