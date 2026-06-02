package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zze implements Parcelable.Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions createFromParcel(Parcel parcel) {
        boolean zM7709c = false;
        ArrayList arrayListM7708c = null;
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p = null;
        String strM7722p2 = null;
        boolean zM7709c2 = false;
        boolean zM7709c3 = false;
        Account account = null;
        ArrayList arrayListM7708c2 = null;
        int iM7712f = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    arrayListM7708c2 = zzbfn.m7708c(parcel, i, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) zzbfn.m7702a(parcel, i, Account.CREATOR);
                    break;
                case 4:
                    zM7709c3 = zzbfn.m7709c(parcel, i);
                    break;
                case 5:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 6:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 7:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 8:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 9:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, zzn.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new GoogleSignInOptions(iM7712f, (ArrayList<Scope>) arrayListM7708c2, account, zM7709c3, zM7709c2, zM7709c, strM7722p2, strM7722p, (ArrayList<zzn>) arrayListM7708c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
