package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgb implements Parcelable.Creator<zzcfz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcfz createFromParcel(Parcel parcel) {
        ArrayList arrayListM7708c = null;
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p = null;
        String strM7722p2 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 2:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                case 4:
                case 5:
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
                case 6:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, zzcfx.CREATOR);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcfz(strM7722p2, strM7722p, arrayListM7708c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcfz[] newArray(int i) {
        return new zzcfz[i];
    }
}
