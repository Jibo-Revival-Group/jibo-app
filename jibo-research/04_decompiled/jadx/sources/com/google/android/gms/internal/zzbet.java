package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class zzbet extends zzeu implements zzbes {
    zzbet(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    }

    @Override // com.google.android.gms.internal.zzbes
    /* JADX INFO: renamed from: a */
    public final void mo7688a(zzbeq zzbeqVar, zzbeh zzbehVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8575a(parcelM8526c, zzbeqVar);
        zzew.m8576a(parcelM8526c, zzbehVar);
        m8527c(1, parcelM8526c);
    }
}
