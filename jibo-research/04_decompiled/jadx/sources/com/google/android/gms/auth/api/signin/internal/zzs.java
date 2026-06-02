package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public interface zzs extends IInterface {
    /* JADX INFO: renamed from: a */
    void mo6763a(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException;

    /* JADX INFO: renamed from: a */
    void mo6764a(Status status) throws RemoteException;

    /* JADX INFO: renamed from: b */
    void mo6765b(Status status) throws RemoteException;
}
