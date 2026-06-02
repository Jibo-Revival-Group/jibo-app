package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzaut;

/* JADX INFO: loaded from: classes.dex */
final class zzb extends Api.zza<zzaut, Object> {
    zzb() {
    }

    @Override // com.google.android.gms.common.api.Api.zza
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Api.zze mo6804a(Context context, Looper looper, zzr zzrVar, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzaut(context, looper, zzrVar, connectionCallbacks, onConnectionFailedListener);
    }
}
