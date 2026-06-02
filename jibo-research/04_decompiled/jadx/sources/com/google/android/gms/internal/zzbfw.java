package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfw implements zzbfv {
    @Override // com.google.android.gms.internal.zzbfv
    /* JADX INFO: renamed from: a */
    public final PendingResult<Status> mo7766a(GoogleApiClient googleApiClient) {
        return googleApiClient.mo6896b(new zzbfx(this, googleApiClient));
    }
}
