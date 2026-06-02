package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;

/* JADX INFO: loaded from: classes.dex */
public final class zzav extends zzeu implements zzat {
    zzav(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzat
    /* JADX INFO: renamed from: a */
    public final IObjectWrapper mo7358a() throws RemoteException {
        Parcel parcelM8524a = m8524a(1, m8526c());
        IObjectWrapper iObjectWrapperM7552a = IObjectWrapper.zza.m7552a(parcelM8524a.readStrongBinder());
        parcelM8524a.recycle();
        return iObjectWrapperM7552a;
    }

    @Override // com.google.android.gms.common.internal.zzat
    /* JADX INFO: renamed from: b */
    public final int mo7359b() throws RemoteException {
        Parcel parcelM8524a = m8524a(2, m8526c());
        int i = parcelM8524a.readInt();
        parcelM8524a.recycle();
        return i;
    }
}
