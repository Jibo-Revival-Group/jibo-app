package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzcxi;
import com.google.android.gms.internal.zzcxq;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class zzav extends zzcxi {

    /* JADX INFO: renamed from: a */
    private final WeakReference<zzao> f6223a;

    zzav(zzao zzaoVar) {
        this.f6223a = new WeakReference<>(zzaoVar);
    }

    @Override // com.google.android.gms.internal.zzcxi, com.google.android.gms.internal.zzcxj
    /* JADX INFO: renamed from: a */
    public final void mo7056a(zzcxq zzcxqVar) {
        zzao zzaoVar = this.f6223a.get();
        if (zzaoVar == null) {
            return;
        }
        zzaoVar.f6191a.m7082a(new zzaw(this, zzaoVar, zzaoVar, zzcxqVar));
    }
}
