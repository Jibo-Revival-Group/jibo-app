package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgr implements Parcelable.Creator<zzbgo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbgo createFromParcel(Parcel parcel) {
        zzbgh zzbghVar = null;
        int iM7712f = 0;
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p = null;
        String strM7722p2 = null;
        boolean zM7709c = false;
        int iM7712f2 = 0;
        boolean zM7709c2 = false;
        int iM7712f3 = 0;
        int iM7712f4 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f4 = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    iM7712f3 = zzbfn.m7712f(parcel, i);
                    break;
                case 3:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 4:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 5:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 6:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 7:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 8:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 9:
                    zzbghVar = (zzbgh) zzbfn.m7702a(parcel, i, zzbgh.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzbgo(iM7712f4, iM7712f3, zM7709c2, iM7712f2, zM7709c, strM7722p2, iM7712f, strM7722p, zzbghVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbgo[] newArray(int i) {
        return new zzbgo[i];
    }
}
