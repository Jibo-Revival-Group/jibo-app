package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxh implements Parcelable.Creator<zzcxg> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcxg createFromParcel(Parcel parcel) {
        int iM7712f = 0;
        int iM7700a = zzbfn.m7700a(parcel);
        Intent intent = null;
        int iM7712f2 = 0;
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
                    intent = (Intent) zzbfn.m7702a(parcel, i, Intent.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcxg(iM7712f2, iM7712f, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcxg[] newArray(int i) {
        return new zzcxg[i];
    }
}
