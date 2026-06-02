package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;

/* JADX INFO: loaded from: classes.dex */
final class zzbfy extends zzbfs {

    /* JADX INFO: renamed from: a */
    private final zzn<Status> f6935a;

    public zzbfy(zzn<Status> zznVar) {
        this.f6935a = zznVar;
    }

    @Override // com.google.android.gms.internal.zzbfs, com.google.android.gms.internal.zzbgc
    /* JADX INFO: renamed from: a */
    public final void mo7765a(int i) throws RemoteException {
        this.f6935a.mo6779a(new Status(i));
    }
}
