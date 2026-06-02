package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgi implements Parcelable.Creator<zzbgh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbgh createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        zzbgj zzbgjVar = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    zzbgjVar = (zzbgj) zzbfn.m7702a(parcel, i, zzbgj.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzbgh(iM7712f, zzbgjVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbgh[] newArray(int i) {
        return new zzbgh[i];
    }
}
