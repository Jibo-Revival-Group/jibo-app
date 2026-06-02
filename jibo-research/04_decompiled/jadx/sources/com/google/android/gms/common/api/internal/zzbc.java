package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzbc implements GoogleApiClient.ConnectionCallbacks {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AtomicReference f6256a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzda f6257b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzba f6258c;

    zzbc(zzba zzbaVar, AtomicReference atomicReference, zzda zzdaVar) {
        this.f6258c = zzbaVar;
        this.f6256a = atomicReference;
        this.f6257b = zzdaVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public final void mo6914a(int i) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public final void mo6915a(Bundle bundle) {
        this.f6258c.m7059a((GoogleApiClient) this.f6256a.get(), this.f6257b, true);
    }
}
