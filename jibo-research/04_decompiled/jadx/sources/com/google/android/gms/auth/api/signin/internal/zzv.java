package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

/* JADX INFO: loaded from: classes.dex */
public final class zzv extends zzeu implements zzu {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzu
    /* JADX INFO: renamed from: a */
    public final void mo6790a(zzs zzsVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8575a(parcelM8526c, zzsVar);
        zzew.m8576a(parcelM8526c, googleSignInOptions);
        m8525b(103, parcelM8526c);
    }
}
