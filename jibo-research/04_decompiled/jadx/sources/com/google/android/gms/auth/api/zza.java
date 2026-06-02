package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzavy;

/* JADX INFO: loaded from: classes.dex */
final class zza extends Api.zza<zzavy, Auth.AuthCredentialsOptions> {
    zza() {
    }

    @Override // com.google.android.gms.common.api.Api.zza
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Api.zze mo6804a(Context context, Looper looper, zzr zzrVar, Auth.AuthCredentialsOptions authCredentialsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzavy(context, looper, zzrVar, authCredentialsOptions, connectionCallbacks, onConnectionFailedListener);
    }
}
