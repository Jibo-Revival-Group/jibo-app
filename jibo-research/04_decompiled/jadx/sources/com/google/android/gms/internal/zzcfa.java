package com.google.android.gms.internal;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationAvailability;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfa extends zzeu implements zzcez {
    zzcfa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.zzcez
    /* JADX INFO: renamed from: a */
    public final Location mo7824a(String str) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeString(str);
        Parcel parcelM8524a = m8524a(21, parcelM8526c);
        Location location = (Location) zzew.m8574a(parcelM8524a, Location.CREATOR);
        parcelM8524a.recycle();
        return location;
    }

    @Override // com.google.android.gms.internal.zzcez
    /* JADX INFO: renamed from: a */
    public final void mo7825a(zzcdz zzcdzVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzcdzVar);
        m8525b(75, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzcez
    /* JADX INFO: renamed from: a */
    public final void mo7826a(zzcfq zzcfqVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzcfqVar);
        m8525b(59, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzcez
    /* JADX INFO: renamed from: a */
    public final void mo7827a(boolean z) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8577a(parcelM8526c, z);
        m8525b(12, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzcez
    /* JADX INFO: renamed from: b */
    public final LocationAvailability mo7828b(String str) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeString(str);
        Parcel parcelM8524a = m8524a(34, parcelM8526c);
        LocationAvailability locationAvailability = (LocationAvailability) zzew.m8574a(parcelM8524a, LocationAvailability.CREATOR);
        parcelM8524a.recycle();
        return locationAvailability;
    }
}
