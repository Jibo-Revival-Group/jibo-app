package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzau extends zzev implements zzat {
    public zzau() {
        attachInterface(this, "com.google.android.gms.common.internal.ICertData");
    }

    /* JADX INFO: renamed from: a */
    public static zzat m7360a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return iInterfaceQueryLocalInterface instanceof zzat ? (zzat) iInterfaceQueryLocalInterface : new zzav(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m8528a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperA = mo7358a();
                parcel2.writeNoException();
                zzew.m8575a(parcel2, iObjectWrapperA);
                break;
            case 2:
                int iB = mo7359b();
                parcel2.writeNoException();
                parcel2.writeInt(iB);
                break;
        }
        return true;
    }
}
