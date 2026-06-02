package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public final class zzaa implements Parcelable.Creator<GoogleMapOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleMapOptions createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        byte bM7710d = -1;
        byte bM7710d2 = -1;
        int iM7712f = 0;
        CameraPosition cameraPosition = null;
        byte bM7710d3 = -1;
        byte bM7710d4 = -1;
        byte bM7710d5 = -1;
        byte bM7710d6 = -1;
        byte bM7710d7 = -1;
        byte bM7710d8 = -1;
        byte bM7710d9 = -1;
        byte bM7710d10 = -1;
        byte bM7710d11 = -1;
        Float fM7718l = null;
        Float fM7718l2 = null;
        LatLngBounds latLngBounds = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    bM7710d = zzbfn.m7710d(parcel, i);
                    break;
                case 3:
                    bM7710d2 = zzbfn.m7710d(parcel, i);
                    break;
                case 4:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) zzbfn.m7702a(parcel, i, CameraPosition.CREATOR);
                    break;
                case 6:
                    bM7710d3 = zzbfn.m7710d(parcel, i);
                    break;
                case 7:
                    bM7710d4 = zzbfn.m7710d(parcel, i);
                    break;
                case 8:
                    bM7710d5 = zzbfn.m7710d(parcel, i);
                    break;
                case 9:
                    bM7710d6 = zzbfn.m7710d(parcel, i);
                    break;
                case 10:
                    bM7710d7 = zzbfn.m7710d(parcel, i);
                    break;
                case 11:
                    bM7710d8 = zzbfn.m7710d(parcel, i);
                    break;
                case 12:
                    bM7710d9 = zzbfn.m7710d(parcel, i);
                    break;
                case 13:
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
                case 14:
                    bM7710d10 = zzbfn.m7710d(parcel, i);
                    break;
                case 15:
                    bM7710d11 = zzbfn.m7710d(parcel, i);
                    break;
                case 16:
                    fM7718l = zzbfn.m7718l(parcel, i);
                    break;
                case 17:
                    fM7718l2 = zzbfn.m7718l(parcel, i);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) zzbfn.m7702a(parcel, i, LatLngBounds.CREATOR);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new GoogleMapOptions(bM7710d, bM7710d2, iM7712f, cameraPosition, bM7710d3, bM7710d4, bM7710d5, bM7710d6, bM7710d7, bM7710d8, bM7710d9, bM7710d10, bM7710d11, fM7718l, fM7718l2, latLngBounds);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleMapOptions[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
