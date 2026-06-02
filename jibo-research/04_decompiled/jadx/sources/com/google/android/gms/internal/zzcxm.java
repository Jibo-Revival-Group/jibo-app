package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzan;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxm extends zzeu implements zzcxl {
    zzcxm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.internal.zzcxl
    /* JADX INFO: renamed from: a */
    public final void mo8507a(int i) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeInt(i);
        m8525b(7, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzcxl
    /* JADX INFO: renamed from: a */
    public final void mo8508a(zzan zzanVar, int i, boolean z) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8575a(parcelM8526c, zzanVar);
        parcelM8526c.writeInt(i);
        zzew.m8577a(parcelM8526c, z);
        m8525b(9, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzcxl
    /* JADX INFO: renamed from: a */
    public final void mo8509a(zzcxo zzcxoVar, zzcxj zzcxjVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzcxoVar);
        zzew.m8575a(parcelM8526c, zzcxjVar);
        m8525b(12, parcelM8526c);
    }
}
