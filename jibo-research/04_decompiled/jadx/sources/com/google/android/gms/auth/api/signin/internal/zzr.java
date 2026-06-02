package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzr extends zzev implements zzq {
    public zzr() {
        attachInterface(this, "com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m8528a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo6788a();
                break;
            case 2:
                mo6789b();
                break;
        }
        return true;
    }
}
