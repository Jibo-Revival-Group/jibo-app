package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class zzc implements GoogleSignInApi {
    @Override // com.google.android.gms.auth.api.signin.GoogleSignInApi
    /* JADX INFO: renamed from: a */
    public final PendingResult<Status> mo6738a(GoogleApiClient googleApiClient) {
        return zze.m6775a(googleApiClient, googleApiClient.mo6895b(), false);
    }
}
