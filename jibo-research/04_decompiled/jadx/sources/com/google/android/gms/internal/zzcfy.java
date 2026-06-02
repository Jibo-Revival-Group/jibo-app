package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfy implements Parcelable.Creator<zzcfx> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcfx createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcfx(strM7722p);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcfx[] newArray(int i) {
        return new zzcfx[i];
    }
}
