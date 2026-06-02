package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzx implements Parcelable.Creator<SignInConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration createFromParcel(Parcel parcel) {
        GoogleSignInOptions googleSignInOptions = null;
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                case 4:
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
                case 5:
                    googleSignInOptions = (GoogleSignInOptions) zzbfn.m7702a(parcel, i, GoogleSignInOptions.CREATOR);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new SignInConfiguration(strM7722p, googleSignInOptions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
