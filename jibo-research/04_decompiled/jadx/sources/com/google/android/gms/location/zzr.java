package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

/* JADX INFO: loaded from: classes.dex */
public final class zzr extends zzeu implements zzp {
    zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    @Override // com.google.android.gms.location.zzp
    /* JADX INFO: renamed from: a */
    public final void mo7834a(LocationAvailability locationAvailability) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, locationAvailability);
        m8527c(2, parcelM8526c);
    }

    @Override // com.google.android.gms.location.zzp
    /* JADX INFO: renamed from: a */
    public final void mo7835a(LocationResult locationResult) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, locationResult);
        m8527c(1, parcelM8526c);
    }
}
