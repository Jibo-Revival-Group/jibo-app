package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

/* JADX INFO: loaded from: classes.dex */
public final class zzbe extends zzeu implements zzbd {
    zzbe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    @Override // com.google.android.gms.common.internal.zzbd
    /* JADX INFO: renamed from: a */
    public final IObjectWrapper mo7366a(IObjectWrapper iObjectWrapper, zzbv zzbvVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8575a(parcelM8526c, iObjectWrapper);
        zzew.m8576a(parcelM8526c, zzbvVar);
        Parcel parcelM8524a = m8524a(2, parcelM8526c);
        IObjectWrapper iObjectWrapperM7552a = IObjectWrapper.zza.m7552a(parcelM8524a.readStrongBinder());
        parcelM8524a.recycle();
        return iObjectWrapperM7552a;
    }
}
