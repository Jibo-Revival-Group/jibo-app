package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgf extends zzeu implements zzbge {
    zzbgf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    @Override // com.google.android.gms.internal.zzbge
    /* JADX INFO: renamed from: a */
    public final void mo7767a(zzbgc zzbgcVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8575a(parcelM8526c, zzbgcVar);
        m8527c(1, parcelM8526c);
    }
}
