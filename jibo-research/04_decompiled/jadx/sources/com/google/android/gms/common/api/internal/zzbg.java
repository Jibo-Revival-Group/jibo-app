package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class zzbg extends zzby {

    /* JADX INFO: renamed from: a */
    private WeakReference<zzba> f6265a;

    zzbg(zzba zzbaVar) {
        this.f6265a = new WeakReference<>(zzbaVar);
    }

    @Override // com.google.android.gms.common.api.internal.zzby
    /* JADX INFO: renamed from: a */
    public final void mo7077a() {
        zzba zzbaVar = this.f6265a.get();
        if (zzbaVar == null) {
            return;
        }
        zzbaVar.m7067p();
    }
}
