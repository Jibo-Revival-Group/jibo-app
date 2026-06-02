package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzk implements Parcelable.Creator<TokenData> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TokenData createFromParcel(Parcel parcel) {
        ArrayList<String> arrayListM7696B = null;
        boolean zM7709c = false;
        int iM7700a = zzbfn.m7700a(parcel);
        boolean zM7709c2 = false;
        Long lM7715i = null;
        String strM7722p = null;
        int iM7712f = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    lM7715i = zzbfn.m7715i(parcel, i);
                    break;
                case 4:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 5:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 6:
                    arrayListM7696B = zzbfn.m7696B(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new TokenData(iM7712f, strM7722p, lM7715i, zM7709c2, zM7709c, arrayListM7696B);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TokenData[] newArray(int i) {
        return new TokenData[i];
    }
}
