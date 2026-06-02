package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzx extends zzev implements zzw {
    public zzx() {
        attachInterface(this, "com.google.android.gms.location.places.internal.IPlacesCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m8528a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo8805a((DataHolder) zzew.m8574a(parcel, DataHolder.CREATOR));
                break;
            case 2:
                mo8806b((DataHolder) zzew.m8574a(parcel, DataHolder.CREATOR));
                break;
            case 3:
                mo8807c((DataHolder) zzew.m8574a(parcel, DataHolder.CREATOR));
                break;
            case 4:
                mo8804a((Status) zzew.m8574a(parcel, Status.CREATOR));
                break;
            case 5:
                mo8808d((DataHolder) zzew.m8574a(parcel, DataHolder.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
