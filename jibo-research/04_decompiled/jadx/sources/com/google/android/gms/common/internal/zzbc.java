package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

/* JADX INFO: loaded from: classes.dex */
public final class zzbc extends zzeu implements zzba {
    zzbc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzba
    /* JADX INFO: renamed from: a */
    public final boolean mo7364a(com.google.android.gms.common.zzn zznVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zznVar);
        zzew.m8575a(parcelM8526c, iObjectWrapper);
        Parcel parcelM8524a = m8524a(5, parcelM8526c);
        boolean zM8578a = zzew.m8578a(parcelM8524a);
        parcelM8524a.recycle();
        return zM8578a;
    }
}
