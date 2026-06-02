package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

/* JADX INFO: loaded from: classes.dex */
public final class zzap extends zzeu implements zzan {
    zzap(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.zzan
    /* JADX INFO: renamed from: a */
    public final Account mo7309a() throws RemoteException {
        Parcel parcelM8524a = m8524a(2, m8526c());
        Account account = (Account) zzew.m8574a(parcelM8524a, Account.CREATOR);
        parcelM8524a.recycle();
        return account;
    }
}
