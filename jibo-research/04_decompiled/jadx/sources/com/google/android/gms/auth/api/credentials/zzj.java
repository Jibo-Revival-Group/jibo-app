package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzj implements Parcelable.Creator<PasswordSpecification> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PasswordSpecification createFromParcel(Parcel parcel) {
        int iM7712f = 0;
        ArrayList<Integer> arrayListM7695A = null;
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f2 = 0;
        ArrayList<String> arrayListM7696B = null;
        String strM7722p = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 2:
                    arrayListM7696B = zzbfn.m7696B(parcel, i);
                    break;
                case 3:
                    arrayListM7695A = zzbfn.m7695A(parcel, i);
                    break;
                case 4:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 5:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new PasswordSpecification(strM7722p, arrayListM7696B, arrayListM7695A, iM7712f2, iM7712f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PasswordSpecification[] newArray(int i) {
        return new PasswordSpecification[i];
    }
}
