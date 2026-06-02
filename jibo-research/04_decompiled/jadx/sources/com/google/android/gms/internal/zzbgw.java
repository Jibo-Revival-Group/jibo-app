package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgw implements Parcelable.Creator<zzbgt> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbgt createFromParcel(Parcel parcel) {
        String strM7722p = null;
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
                    arrayListM7708c = zzbfn.m7708c(parcel, i, zzbgu.CREATOR);
                    break;
                case 3:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzbgt(iM7712f, arrayListM7708c, strM7722p);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbgt[] newArray(int i) {
        return new zzbgt[i];
    }
}
