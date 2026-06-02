package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public final class zzt implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: a */
    public final Api<?> f6431a;

    /* JADX INFO: renamed from: b */
    private final boolean f6432b;

    /* JADX INFO: renamed from: c */
    private zzu f6433c;

    public zzt(Api<?> api, boolean z) {
        this.f6431a = api;
        this.f6432b = z;
    }

    /* JADX INFO: renamed from: a */
    private final void m7233a() {
        com.google.android.gms.common.internal.zzbq.m7374a(this.f6433c, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public final void mo6914a(int i) {
        m7233a();
        this.f6433c.mo6914a(i);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public final void mo6915a(Bundle bundle) {
        m7233a();
        this.f6433c.mo6915a(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    /* JADX INFO: renamed from: a */
    public final void mo6916a(ConnectionResult connectionResult) {
        m7233a();
        this.f6433c.mo7081a(connectionResult, this.f6431a, this.f6432b);
    }

    /* JADX INFO: renamed from: a */
    public final void m7234a(zzu zzuVar) {
        this.f6433c = zzuVar;
    }
}
