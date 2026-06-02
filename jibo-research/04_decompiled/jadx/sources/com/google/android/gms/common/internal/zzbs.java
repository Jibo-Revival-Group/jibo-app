package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzbs implements Parcelable.Creator<zzbr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbr createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        Account account = null;
        int iM7712f2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    account = (Account) zzbfn.m7702a(parcel, i, Account.CREATOR);
                    break;
                case 3:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 4:
                    googleSignInAccount = (GoogleSignInAccount) zzbfn.m7702a(parcel, i, GoogleSignInAccount.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzbr(iM7712f2, account, iM7712f, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbr[] newArray(int i) {
        return new zzbr[i];
    }
}
