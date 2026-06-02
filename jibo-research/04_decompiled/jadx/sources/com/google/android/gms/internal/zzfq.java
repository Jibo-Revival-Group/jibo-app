package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfq extends zzeu implements zzfo {
    zzfq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // com.google.android.gms.internal.zzfo
    /* JADX INFO: renamed from: a */
    public final String mo8731a() throws RemoteException {
        Parcel parcelM8524a = m8524a(1, m8526c());
        String string = parcelM8524a.readString();
        parcelM8524a.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.zzfo
    /* JADX INFO: renamed from: a */
    public final boolean mo8732a(boolean z) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8577a(parcelM8526c, true);
        Parcel parcelM8524a = m8524a(2, parcelM8526c);
        boolean zM8578a = zzew.m8578a(parcelM8524a);
        parcelM8524a.recycle();
        return zM8578a;
    }

    @Override // com.google.android.gms.internal.zzfo
    /* JADX INFO: renamed from: b */
    public final boolean mo8733b() throws RemoteException {
        Parcel parcelM8524a = m8524a(6, m8526c());
        boolean zM8578a = zzew.m8578a(parcelM8524a);
        parcelM8524a.recycle();
        return zM8578a;
    }
}
