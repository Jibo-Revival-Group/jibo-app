package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgx implements Parcelable.Creator<zzbgu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbgu createFromParcel(Parcel parcel) {
        ArrayList arrayListM7708c = null;
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        String strM7722p = null;
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
                    arrayListM7708c = zzbfn.m7708c(parcel, i, zzbgv.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzbgu(iM7712f, strM7722p, arrayListM7708c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbgu[] newArray(int i) {
        return new zzbgu[i];
    }
}
