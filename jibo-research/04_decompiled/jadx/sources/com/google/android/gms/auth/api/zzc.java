package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzr;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzc extends Api.zza<com.google.android.gms.auth.api.signin.internal.zzd, GoogleSignInOptions> {
    zzc() {
    }

    @Override // com.google.android.gms.common.api.Api.zza
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Api.zze mo6804a(Context context, Looper looper, zzr zzrVar, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new com.google.android.gms.auth.api.signin.internal.zzd(context, looper, zzrVar, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.Api.zzd
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ List mo6805a(Object obj) {
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.m6751a();
    }
}
