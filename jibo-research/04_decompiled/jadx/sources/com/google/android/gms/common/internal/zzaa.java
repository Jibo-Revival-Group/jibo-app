package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzaa implements Parcelable.Creator<zzz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz createFromParcel(Parcel parcel) {
        int iM7712f = 0;
        com.google.android.gms.common.zzc[] zzcVarArr = null;
        int iM7700a = zzbfn.m7700a(parcel);
        Account account = null;
        Bundle bundleM7724r = null;
        Scope[] scopeArr = null;
        IBinder iBinderM7723q = null;
        String strM7722p = null;
        int iM7712f2 = 0;
        int iM7712f3 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f3 = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 3:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 4:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 5:
                    iBinderM7723q = zzbfn.m7723q(parcel, i);
                    break;
                case 6:
                    scopeArr = (Scope[]) zzbfn.m7707b(parcel, i, Scope.CREATOR);
                    break;
                case 7:
                    bundleM7724r = zzbfn.m7724r(parcel, i);
                    break;
                case 8:
                    account = (Account) zzbfn.m7702a(parcel, i, Account.CREATOR);
                    break;
                case 9:
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
                case 10:
                    zzcVarArr = (com.google.android.gms.common.zzc[]) zzbfn.m7707b(parcel, i, com.google.android.gms.common.zzc.CREATOR);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzz(iM7712f3, iM7712f2, iM7712f, strM7722p, iBinderM7723q, scopeArr, bundleM7724r, account, zzcVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz[] newArray(int i) {
        return new zzz[i];
    }
}
