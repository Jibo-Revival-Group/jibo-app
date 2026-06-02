package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzchg extends zzeu implements zzche {
    zzchg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final List<zzcln> mo8042a(zzcgi zzcgiVar, boolean z) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzcgiVar);
        zzew.m8577a(parcelM8526c, z);
        Parcel parcelM8524a = m8524a(7, parcelM8526c);
        ArrayList arrayListCreateTypedArrayList = parcelM8524a.createTypedArrayList(zzcln.CREATOR);
        parcelM8524a.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final List<zzcgl> mo8043a(String str, String str2, zzcgi zzcgiVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeString(str);
        parcelM8526c.writeString(str2);
        zzew.m8576a(parcelM8526c, zzcgiVar);
        Parcel parcelM8524a = m8524a(16, parcelM8526c);
        ArrayList arrayListCreateTypedArrayList = parcelM8524a.createTypedArrayList(zzcgl.CREATOR);
        parcelM8524a.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final List<zzcgl> mo8044a(String str, String str2, String str3) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeString(str);
        parcelM8526c.writeString(str2);
        parcelM8526c.writeString(str3);
        Parcel parcelM8524a = m8524a(17, parcelM8526c);
        ArrayList arrayListCreateTypedArrayList = parcelM8524a.createTypedArrayList(zzcgl.CREATOR);
        parcelM8524a.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final List<zzcln> mo8045a(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeString(str);
        parcelM8526c.writeString(str2);
        parcelM8526c.writeString(str3);
        zzew.m8577a(parcelM8526c, z);
        Parcel parcelM8524a = m8524a(15, parcelM8526c);
        ArrayList arrayListCreateTypedArrayList = parcelM8524a.createTypedArrayList(zzcln.CREATOR);
        parcelM8524a.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final List<zzcln> mo8046a(String str, String str2, boolean z, zzcgi zzcgiVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeString(str);
        parcelM8526c.writeString(str2);
        zzew.m8577a(parcelM8526c, z);
        zzew.m8576a(parcelM8526c, zzcgiVar);
        Parcel parcelM8524a = m8524a(14, parcelM8526c);
        ArrayList arrayListCreateTypedArrayList = parcelM8524a.createTypedArrayList(zzcln.CREATOR);
        parcelM8524a.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8047a(long j, String str, String str2, String str3) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        parcelM8526c.writeLong(j);
        parcelM8526c.writeString(str);
        parcelM8526c.writeString(str2);
        parcelM8526c.writeString(str3);
        m8525b(10, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8048a(zzcgi zzcgiVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzcgiVar);
        m8525b(4, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8049a(zzcgl zzcglVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzcglVar);
        m8525b(13, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8050a(zzcgl zzcglVar, zzcgi zzcgiVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzcglVar);
        zzew.m8576a(parcelM8526c, zzcgiVar);
        m8525b(12, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8051a(zzcha zzchaVar, zzcgi zzcgiVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzchaVar);
        zzew.m8576a(parcelM8526c, zzcgiVar);
        m8525b(1, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8052a(zzcha zzchaVar, String str, String str2) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzchaVar);
        parcelM8526c.writeString(str);
        parcelM8526c.writeString(str2);
        m8525b(5, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8053a(zzcln zzclnVar, zzcgi zzcgiVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzclnVar);
        zzew.m8576a(parcelM8526c, zzcgiVar);
        m8525b(2, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final byte[] mo8054a(zzcha zzchaVar, String str) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzchaVar);
        parcelM8526c.writeString(str);
        Parcel parcelM8524a = m8524a(9, parcelM8526c);
        byte[] bArrCreateByteArray = parcelM8524a.createByteArray();
        parcelM8524a.recycle();
        return bArrCreateByteArray;
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: b */
    public final void mo8055b(zzcgi zzcgiVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzcgiVar);
        m8525b(6, parcelM8526c);
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: c */
    public final String mo8056c(zzcgi zzcgiVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzcgiVar);
        Parcel parcelM8524a = m8524a(11, parcelM8526c);
        String string = parcelM8524a.readString();
        parcelM8524a.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: d */
    public final void mo8057d(zzcgi zzcgiVar) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, zzcgiVar);
        m8525b(18, parcelM8526c);
    }
}
