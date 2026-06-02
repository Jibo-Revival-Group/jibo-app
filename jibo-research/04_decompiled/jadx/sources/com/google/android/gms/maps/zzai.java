package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* JADX INFO: loaded from: classes.dex */
public final class zzai implements Parcelable.Creator<StreetViewPanoramaOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        Integer numM7713g = null;
        byte bM7710d = 0;
        int iM7700a = zzbfn.m7700a(parcel);
        byte bM7710d2 = 0;
        byte bM7710d3 = 0;
        byte bM7710d4 = 0;
        byte bM7710d5 = 0;
        LatLng latLng = null;
        String strM7722p = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) zzbfn.m7702a(parcel, i, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 4:
                    latLng = (LatLng) zzbfn.m7702a(parcel, i, LatLng.CREATOR);
                    break;
                case 5:
                    numM7713g = zzbfn.m7713g(parcel, i);
                    break;
                case 6:
                    bM7710d5 = zzbfn.m7710d(parcel, i);
                    break;
                case 7:
                    bM7710d4 = zzbfn.m7710d(parcel, i);
                    break;
                case 8:
                    bM7710d3 = zzbfn.m7710d(parcel, i);
                    break;
                case 9:
                    bM7710d2 = zzbfn.m7710d(parcel, i);
                    break;
                case 10:
                    bM7710d = zzbfn.m7710d(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new StreetViewPanoramaOptions(streetViewPanoramaCamera, strM7722p, latLng, numM7713g, bM7710d5, bM7710d4, bM7710d3, bM7710d2, bM7710d);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOptions[] newArray(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
