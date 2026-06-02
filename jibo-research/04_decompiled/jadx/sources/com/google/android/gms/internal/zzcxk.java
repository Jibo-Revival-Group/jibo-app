package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzcxk extends zzev implements zzcxj {
    public zzcxk() {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m8528a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 3:
                zzew.m8574a(parcel, ConnectionResult.CREATOR);
                zzew.m8574a(parcel, zzcxg.CREATOR);
                break;
            case 4:
                zzew.m8574a(parcel, Status.CREATOR);
                break;
            case 5:
            default:
                return false;
            case 6:
                zzew.m8574a(parcel, Status.CREATOR);
                break;
            case 7:
                zzew.m8574a(parcel, Status.CREATOR);
                zzew.m8574a(parcel, GoogleSignInAccount.CREATOR);
                break;
            case 8:
                mo7056a((zzcxq) zzew.m8574a(parcel, zzcxq.CREATOR));
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
