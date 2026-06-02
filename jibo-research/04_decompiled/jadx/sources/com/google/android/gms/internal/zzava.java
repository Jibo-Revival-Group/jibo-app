package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzava implements Parcelable.Creator<zzauz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzauz createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        String strM7722p = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzauz(iM7712f, strM7722p);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzauz[] newArray(int i) {
        return new zzauz[i];
    }
}
