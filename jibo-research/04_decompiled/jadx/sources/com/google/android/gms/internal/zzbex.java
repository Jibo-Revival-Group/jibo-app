package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbex implements Parcelable.Creator<zzbew> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbew createFromParcel(Parcel parcel) {
        String strM7722p = null;
        int iM7712f = 0;
        int iM7700a = zzbfn.m7700a(parcel);
        boolean zM7709c = true;
        boolean zM7709c2 = false;
        String strM7722p2 = null;
        String strM7722p3 = null;
        int iM7712f2 = 0;
        int iM7712f3 = 0;
        String strM7722p4 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    strM7722p4 = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    iM7712f3 = zzbfn.m7712f(parcel, i);
                    break;
                case 4:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 5:
                    strM7722p3 = zzbfn.m7722p(parcel, i);
                    break;
                case 6:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 7:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 8:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 9:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 10:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzbew(strM7722p4, iM7712f3, iM7712f2, strM7722p3, strM7722p2, zM7709c, strM7722p, zM7709c2, iM7712f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbew[] newArray(int i) {
        return new zzbew[i];
    }
}
