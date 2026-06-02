package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzclo implements Parcelable.Creator<zzcln> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcln createFromParcel(Parcel parcel) {
        Double dM7720n = null;
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        long jM7714h = 0;
        String strM7722p = null;
        String strM7722p2 = null;
        Float fM7718l = null;
        Long lM7715i = null;
        String strM7722p3 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    strM7722p3 = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 4:
                    lM7715i = zzbfn.m7715i(parcel, i);
                    break;
                case 5:
                    fM7718l = zzbfn.m7718l(parcel, i);
                    break;
                case 6:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 7:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 8:
                    dM7720n = zzbfn.m7720n(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcln(iM7712f, strM7722p3, jM7714h, lM7715i, fM7718l, strM7722p2, strM7722p, dM7720n);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcln[] newArray(int i) {
        return new zzcln[i];
    }
}
