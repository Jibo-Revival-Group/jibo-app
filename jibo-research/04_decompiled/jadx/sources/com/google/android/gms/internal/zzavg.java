package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzavg implements Parcelable.Creator<zzavf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzavf createFromParcel(Parcel parcel) {
        int iM7712f = 0;
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p = null;
        int iM7712f2 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzavf(iM7712f2, strM7722p, iM7712f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzavf[] newArray(int i) {
        return new zzavf[i];
    }
}
