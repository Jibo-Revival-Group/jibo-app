package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbeg implements Parcelable.Creator<zzbef> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbef createFromParcel(Parcel parcel) {
        long jM7714h = 0;
        int iM7700a = zzbfn.m7700a(parcel);
        boolean zM7709c = false;
        long jM7714h2 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 2:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 3:
                    jM7714h2 = zzbfn.m7714h(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzbef(zM7709c, jM7714h2, jM7714h);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbef[] newArray(int i) {
        return new zzbef[i];
    }
}
