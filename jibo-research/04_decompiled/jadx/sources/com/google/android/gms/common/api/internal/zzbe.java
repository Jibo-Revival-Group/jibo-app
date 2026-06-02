package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zzbe implements ResultCallback<Status> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzda f6260a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ boolean f6261b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ GoogleApiClient f6262c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ zzba f6263d;

    zzbe(zzba zzbaVar, zzda zzdaVar, boolean z, GoogleApiClient googleApiClient) {
        this.f6263d = zzbaVar;
        this.f6260a = zzdaVar;
        this.f6261b = z;
        this.f6262c = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void mo6928a(Result result) {
        Status status = (Status) result;
        com.google.android.gms.auth.api.signin.internal.zzz.m6793a(this.f6263d.f6240k).m6802c();
        if (status.m6935c() && this.f6263d.mo6906j()) {
            this.f6263d.mo6904h();
        }
        this.f6260a.m6942a(status);
        if (this.f6261b) {
            this.f6262c.mo6903g();
        }
    }
}
