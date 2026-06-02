package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzu implements Parcelable.Creator<VisibleRegion> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int iM7700a = zzbfn.m7700a(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    latLng4 = (LatLng) zzbfn.m7702a(parcel, i, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) zzbfn.m7702a(parcel, i, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) zzbfn.m7702a(parcel, i, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) zzbfn.m7702a(parcel, i, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zzbfn.m7702a(parcel, i, LatLngBounds.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new VisibleRegion(latLng4, latLng3, latLng2, latLng, latLngBounds);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
