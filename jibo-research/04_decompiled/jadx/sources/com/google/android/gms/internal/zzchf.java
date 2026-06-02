package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzchf extends zzev implements zzche {
    public zzchf() {
        attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (m8528a(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                mo8051a((zzcha) zzew.m8574a(parcel, zzcha.CREATOR), (zzcgi) zzew.m8574a(parcel, zzcgi.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                mo8053a((zzcln) zzew.m8574a(parcel, zzcln.CREATOR), (zzcgi) zzew.m8574a(parcel, zzcgi.CREATOR));
                parcel2.writeNoException();
                break;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                mo8048a((zzcgi) zzew.m8574a(parcel, zzcgi.CREATOR));
                parcel2.writeNoException();
                break;
            case 5:
                mo8052a((zzcha) zzew.m8574a(parcel, zzcha.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                mo8055b((zzcgi) zzew.m8574a(parcel, zzcgi.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                List<zzcln> listA = mo8042a((zzcgi) zzew.m8574a(parcel, zzcgi.CREATOR), zzew.m8578a(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(listA);
                break;
            case 9:
                byte[] bArrA = mo8054a((zzcha) zzew.m8574a(parcel, zzcha.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrA);
                break;
            case 10:
                mo8047a(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                String strC = mo8056c((zzcgi) zzew.m8574a(parcel, zzcgi.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(strC);
                break;
            case 12:
                mo8050a((zzcgl) zzew.m8574a(parcel, zzcgl.CREATOR), (zzcgi) zzew.m8574a(parcel, zzcgi.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                mo8049a((zzcgl) zzew.m8574a(parcel, zzcgl.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                List<zzcln> listA2 = mo8046a(parcel.readString(), parcel.readString(), zzew.m8578a(parcel), (zzcgi) zzew.m8574a(parcel, zzcgi.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listA2);
                break;
            case 15:
                List<zzcln> listA3 = mo8045a(parcel.readString(), parcel.readString(), parcel.readString(), zzew.m8578a(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(listA3);
                break;
            case 16:
                List<zzcgl> listA4 = mo8043a(parcel.readString(), parcel.readString(), (zzcgi) zzew.m8574a(parcel, zzcgi.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(listA4);
                break;
            case 17:
                List<zzcgl> listA5 = mo8044a(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(listA5);
                break;
            case 18:
                mo8057d((zzcgi) zzew.m8574a(parcel, zzcgi.CREATOR));
                parcel2.writeNoException();
                break;
        }
        return true;
    }
}
