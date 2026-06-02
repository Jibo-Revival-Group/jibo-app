package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class zza extends zzao {
    /* JADX INFO: renamed from: a */
    public static Account m7308a(zzan zzanVar) {
        Account accountMo7309a = null;
        if (zzanVar != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                accountMo7309a = zzanVar.mo7309a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return accountMo7309a;
    }

    @Override // com.google.android.gms.common.internal.zzan
    /* JADX INFO: renamed from: a */
    public final Account mo7309a() {
        throw new NoSuchMethodError();
    }

    public final boolean equals(Object obj) {
        throw new NoSuchMethodError();
    }
}
