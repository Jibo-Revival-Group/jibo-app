package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzber extends zzev implements zzbeq {
    public zzber() {
        attachInterface(this, "com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m8528a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo7673a((Status) zzew.m8574a(parcel, Status.CREATOR));
                break;
            case 2:
                mo7678b((Status) zzew.m8574a(parcel, Status.CREATOR));
                break;
            case 3:
                mo7674a((Status) zzew.m8574a(parcel, Status.CREATOR), parcel.readLong());
                break;
            case 4:
                mo7681c((Status) zzew.m8574a(parcel, Status.CREATOR));
                break;
            case 5:
                mo7679b((Status) zzew.m8574a(parcel, Status.CREATOR), parcel.readLong());
                break;
            case 6:
                mo7676a((Status) zzew.m8574a(parcel, Status.CREATOR), (zzbeh[]) parcel.createTypedArray(zzbeh.CREATOR));
                break;
            case 7:
                mo7677a((DataHolder) zzew.m8574a(parcel, DataHolder.CREATOR));
                break;
            case 8:
                mo7675a((Status) zzew.m8574a(parcel, Status.CREATOR), (zzbef) zzew.m8574a(parcel, zzbef.CREATOR));
                break;
            case 9:
                mo7680b((Status) zzew.m8574a(parcel, Status.CREATOR), (zzbef) zzew.m8574a(parcel, zzbef.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
