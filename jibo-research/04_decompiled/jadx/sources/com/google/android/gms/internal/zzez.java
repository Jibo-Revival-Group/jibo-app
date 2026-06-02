package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class zzez extends zzeu implements zzex {
    zzez(IBinder iBinder) {
        super(iBinder, "com.google.android.auth.IAuthManagerService");
    }

    @Override // com.google.android.gms.internal.zzex
    /* JADX INFO: renamed from: a */
    public final Bundle mo8614a(Account account, String str, Bundle bundle) throws RemoteException {
        Parcel parcelM8526c = m8526c();
        zzew.m8576a(parcelM8526c, account);
        parcelM8526c.writeString(str);
        zzew.m8576a(parcelM8526c, bundle);
        Parcel parcelM8524a = m8524a(5, parcelM8526c);
        Bundle bundle2 = (Bundle) zzew.m8574a(parcelM8524a, Bundle.CREATOR);
        parcelM8524a.recycle();
        return bundle2;
    }
}
