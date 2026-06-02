package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class zzeu implements IInterface {

    /* JADX INFO: renamed from: a */
    private final IBinder f7813a;

    /* JADX INFO: renamed from: b */
    private final String f7814b;

    protected zzeu(IBinder iBinder, String str) {
        this.f7813a = iBinder;
        this.f7814b = str;
    }

    /* JADX INFO: renamed from: a */
    protected final Parcel m8524a(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f7813a.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f7813a;
    }

    /* JADX INFO: renamed from: b */
    protected final void m8525b(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f7813a.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    /* JADX INFO: renamed from: c */
    protected final Parcel m8526c() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f7814b);
        return parcelObtain;
    }

    /* JADX INFO: renamed from: c */
    protected final void m8527c(int i, Parcel parcel) throws RemoteException {
        try {
            this.f7813a.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
