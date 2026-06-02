package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgl implements Parcelable.Creator<zzbgj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbgj createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        ArrayList arrayListM7708c = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, zzbgk.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzbgj(iM7712f, arrayListM7708c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbgj[] newArray(int i) {
        return new zzbgj[i];
    }
}
