package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzr;

/* JADX INFO: loaded from: classes.dex */
final class zzcuf extends Api.zza<zzcut, Object> {
    zzcuf() {
    }

    @Override // com.google.android.gms.common.api.Api.zza
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Api.zze mo6804a(Context context, Looper looper, zzr zzrVar, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzcut(context, looper, zzrVar, connectionCallbacks, onConnectionFailedListener);
    }
}
