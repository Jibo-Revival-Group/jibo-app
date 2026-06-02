package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgz implements Parcelable.Creator<zzcgx> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcgx createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        Bundle bundleM7724r = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    bundleM7724r = zzbfn.m7724r(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcgx(bundleM7724r);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcgx[] newArray(int i) {
        return new zzcgx[i];
    }
}
