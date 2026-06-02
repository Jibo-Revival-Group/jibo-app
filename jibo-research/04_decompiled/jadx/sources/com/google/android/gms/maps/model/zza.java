package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements Parcelable.Creator<CameraPosition> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CameraPosition createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        float fM7717k = 0.0f;
        float fM7717k2 = 0.0f;
        LatLng latLng = null;
        float fM7717k3 = 0.0f;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    latLng = (LatLng) zzbfn.m7702a(parcel, i, LatLng.CREATOR);
                    break;
                case 3:
                    fM7717k2 = zzbfn.m7717k(parcel, i);
                    break;
                case 4:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                case 5:
                    fM7717k3 = zzbfn.m7717k(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new CameraPosition(latLng, fM7717k2, fM7717k, fM7717k3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CameraPosition[] newArray(int i) {
        return new CameraPosition[i];
    }
}
