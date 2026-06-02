package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<AccountChangeEventsRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEventsRequest createFromParcel(Parcel parcel) {
        Account account = null;
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        int iM7712f2 = 0;
        String strM7722p = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 3:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 4:
                    account = (Account) zzbfn.m7702a(parcel, i, Account.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new AccountChangeEventsRequest(iM7712f2, iM7712f, strM7722p, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEventsRequest[] newArray(int i) {
        return new AccountChangeEventsRequest[i];
    }
}
