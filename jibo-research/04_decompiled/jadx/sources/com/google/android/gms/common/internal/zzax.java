package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzax extends zzev implements zzaw {
    public zzax() {
        attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m8528a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo7362a(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzew.m8574a(parcel, Bundle.CREATOR));
                break;
            case 2:
                mo7361a(parcel.readInt(), (Bundle) zzew.m8574a(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
