package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public interface zzbeq extends IInterface {
    /* JADX INFO: renamed from: a */
    void mo7673a(Status status) throws RemoteException;

    /* JADX INFO: renamed from: a */
    void mo7674a(Status status, long j) throws RemoteException;

    /* JADX INFO: renamed from: a */
    void mo7675a(Status status, zzbef zzbefVar) throws RemoteException;

    /* JADX INFO: renamed from: a */
    void mo7676a(Status status, zzbeh[] zzbehVarArr) throws RemoteException;

    /* JADX INFO: renamed from: a */
    void mo7677a(DataHolder dataHolder) throws RemoteException;

    /* JADX INFO: renamed from: b */
    void mo7678b(Status status) throws RemoteException;

    /* JADX INFO: renamed from: b */
    void mo7679b(Status status, long j) throws RemoteException;

    /* JADX INFO: renamed from: b */
    void mo7680b(Status status, zzbef zzbefVar) throws RemoteException;

    /* JADX INFO: renamed from: c */
    void mo7681c(Status status) throws RemoteException;
}
