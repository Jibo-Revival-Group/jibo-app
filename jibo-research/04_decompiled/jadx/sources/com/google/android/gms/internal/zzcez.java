package com.google.android.gms.internal;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.LocationAvailability;

/* JADX INFO: loaded from: classes.dex */
public interface zzcez extends IInterface {
    /* JADX INFO: renamed from: a */
    Location mo7824a(String str) throws RemoteException;

    /* JADX INFO: renamed from: a */
    void mo7825a(zzcdz zzcdzVar) throws RemoteException;

    /* JADX INFO: renamed from: a */
    void mo7826a(zzcfq zzcfqVar) throws RemoteException;

    /* JADX INFO: renamed from: a */
    void mo7827a(boolean z) throws RemoteException;

    /* JADX INFO: renamed from: b */
    LocationAvailability mo7828b(String str) throws RemoteException;
}
