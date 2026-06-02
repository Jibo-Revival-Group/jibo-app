package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
final class zzcdu implements zzcfu<zzcez> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcdt f6991a;

    zzcdu(zzcdt zzcdtVar) {
        this.f6991a = zzcdtVar;
    }

    @Override // com.google.android.gms.internal.zzcfu
    /* JADX INFO: renamed from: a */
    public final void mo7820a() {
        this.f6991a.m7438u();
    }

    @Override // com.google.android.gms.internal.zzcfu
    /* JADX INFO: renamed from: b */
    public final /* synthetic */ IInterface mo7821b() throws DeadObjectException {
        return (zzcez) this.f6991a.m7439v();
    }
}
