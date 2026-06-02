package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class zzk extends zzax {

    /* JADX INFO: renamed from: a */
    private zzd f6624a;

    /* JADX INFO: renamed from: b */
    private final int f6625b;

    public zzk(zzd zzdVar, int i) {
        this.f6624a = zzdVar;
        this.f6625b = i;
    }

    @Override // com.google.android.gms.common.internal.zzaw
    /* JADX INFO: renamed from: a */
    public final void mo7361a(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.zzaw
    /* JADX INFO: renamed from: a */
    public final void mo7362a(int i, IBinder iBinder, Bundle bundle) {
        zzbq.m7374a(this.f6624a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f6624a.m7420a(i, iBinder, bundle, this.f6625b);
        this.f6624a = null;
    }
}
