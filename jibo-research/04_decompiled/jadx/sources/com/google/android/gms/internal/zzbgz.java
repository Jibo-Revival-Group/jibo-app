package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgz implements Parcelable.Creator<zzbgy> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbgy createFromParcel(Parcel parcel) {
        zzbgt zzbgtVar = null;
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        Parcel parcelM7697C = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    parcelM7697C = zzbfn.m7697C(parcel, i);
                    break;
                case 3:
                    zzbgtVar = (zzbgt) zzbfn.m7702a(parcel, i, zzbgt.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzbgy(iM7712f, parcelM7697C, zzbgtVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbgy[] newArray(int i) {
        return new zzbgy[i];
    }
}
