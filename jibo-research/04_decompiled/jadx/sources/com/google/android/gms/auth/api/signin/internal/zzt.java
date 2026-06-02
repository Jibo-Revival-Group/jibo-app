package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzt extends zzev implements zzs {
    public zzt() {
        attachInterface(this, "com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m8528a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 101:
                mo6763a((GoogleSignInAccount) zzew.m8574a(parcel, GoogleSignInAccount.CREATOR), (Status) zzew.m8574a(parcel, Status.CREATOR));
                break;
            case 102:
                mo6764a((Status) zzew.m8574a(parcel, Status.CREATOR));
                break;
            case 103:
                mo6765b((Status) zzew.m8574a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
