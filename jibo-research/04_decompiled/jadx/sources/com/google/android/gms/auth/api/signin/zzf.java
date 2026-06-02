package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzf implements Parcelable.Creator<SignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p = "";
        GoogleSignInAccount googleSignInAccount = null;
        String strM7722p2 = "";
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 4:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 5:
                case 6:
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
                case 7:
                    googleSignInAccount = (GoogleSignInAccount) zzbfn.m7702a(parcel, i, GoogleSignInAccount.CREATOR);
                    break;
                case 8:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new SignInAccount(strM7722p, googleSignInAccount, strM7722p2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount[] newArray(int i) {
        return new SignInAccount[i];
    }
}
