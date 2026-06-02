package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zzaf implements PendingResult.zza {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ BasePendingResult f6182a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzae f6183b;

    zzaf(zzae zzaeVar, BasePendingResult basePendingResult) {
        this.f6183b = zzaeVar;
        this.f6182a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.zza
    /* JADX INFO: renamed from: a */
    public final void mo6923a(Status status) {
        this.f6183b.f6180a.remove(this.f6182a);
    }
}
