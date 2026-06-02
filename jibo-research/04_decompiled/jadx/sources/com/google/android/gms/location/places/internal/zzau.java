package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzau implements Parcelable.Creator<zzat> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzat createFromParcel(Parcel parcel) {
        int iM7712f = 0;
        String strM7722p = null;
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f2 = 0;
        String strM7722p2 = null;
        String strM7722p3 = null;
        String strM7722p4 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strM7722p4 = zzbfn.m7722p(parcel, i);
                    break;
                case 2:
                    strM7722p3 = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 4:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 5:
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
                case 6:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 7:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzat(strM7722p4, strM7722p3, strM7722p2, strM7722p, iM7712f2, iM7712f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzat[] newArray(int i) {
        return new zzat[i];
    }
}
