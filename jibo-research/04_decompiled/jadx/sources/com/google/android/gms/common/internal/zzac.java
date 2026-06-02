package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
final class zzac implements zzf {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ GoogleApiClient.ConnectionCallbacks f6527a;

    zzac(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f6527a = connectionCallbacks;
    }

    @Override // com.google.android.gms.common.internal.zzf
    /* JADX INFO: renamed from: a */
    public final void mo7315a(int i) {
        this.f6527a.mo6914a(i);
    }

    @Override // com.google.android.gms.common.internal.zzf
    /* JADX INFO: renamed from: a */
    public final void mo7316a(Bundle bundle) {
        this.f6527a.mo6915a(bundle);
    }
}
