package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class zza {

    /* JADX INFO: renamed from: a */
    private int f6158a;

    public zza(int i) {
        this.f6158a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static Status m6960b(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (com.google.android.gms.common.util.zzq.m7510a() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo6961a(Status status);

    /* JADX INFO: renamed from: a */
    public abstract void mo6962a(zzae zzaeVar, boolean z);

    /* JADX INFO: renamed from: a */
    public abstract void mo6963a(zzbo<?> zzboVar) throws DeadObjectException;
}
