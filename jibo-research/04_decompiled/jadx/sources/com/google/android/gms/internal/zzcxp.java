package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbr;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxp implements Parcelable.Creator<zzcxo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcxo createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        zzbr zzbrVar = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    zzbrVar = (zzbr) zzbfn.m7702a(parcel, i, zzbr.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcxo(iM7712f, zzbrVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcxo[] newArray(int i) {
        return new zzcxo[i];
    }
}
