package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzchb implements Parcelable.Creator<zzcha> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcha createFromParcel(Parcel parcel) {
        String strM7722p = null;
        int iM7700a = zzbfn.m7700a(parcel);
        long jM7714h = 0;
        zzcgx zzcgxVar = null;
        String strM7722p2 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    zzcgxVar = (zzcgx) zzbfn.m7702a(parcel, i, zzcgx.CREATOR);
                    break;
                case 4:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 5:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcha(strM7722p2, zzcgxVar, strM7722p, jM7714h);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcha[] newArray(int i) {
        return new zzcha[i];
    }
}
