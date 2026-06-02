package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class zzd implements Parcelable.Creator<GroundOverlayOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GroundOverlayOptions createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        IBinder iBinderM7723q = null;
        LatLng latLng = null;
        float fM7717k = CropImageView.DEFAULT_ASPECT_RATIO;
        float fM7717k2 = CropImageView.DEFAULT_ASPECT_RATIO;
        LatLngBounds latLngBounds = null;
        float fM7717k3 = CropImageView.DEFAULT_ASPECT_RATIO;
        float fM7717k4 = CropImageView.DEFAULT_ASPECT_RATIO;
        boolean zM7709c = false;
        float fM7717k5 = CropImageView.DEFAULT_ASPECT_RATIO;
        float fM7717k6 = CropImageView.DEFAULT_ASPECT_RATIO;
        float fM7717k7 = CropImageView.DEFAULT_ASPECT_RATIO;
        boolean zM7709c2 = false;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    iBinderM7723q = zzbfn.m7723q(parcel, i);
                    break;
                case 3:
                    latLng = (LatLng) zzbfn.m7702a(parcel, i, LatLng.CREATOR);
                    break;
                case 4:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                case 5:
                    fM7717k2 = zzbfn.m7717k(parcel, i);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zzbfn.m7702a(parcel, i, LatLngBounds.CREATOR);
                    break;
                case 7:
                    fM7717k3 = zzbfn.m7717k(parcel, i);
                    break;
                case 8:
                    fM7717k4 = zzbfn.m7717k(parcel, i);
                    break;
                case 9:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 10:
                    fM7717k5 = zzbfn.m7717k(parcel, i);
                    break;
                case 11:
                    fM7717k6 = zzbfn.m7717k(parcel, i);
                    break;
                case 12:
                    fM7717k7 = zzbfn.m7717k(parcel, i);
                    break;
                case 13:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new GroundOverlayOptions(iBinderM7723q, latLng, fM7717k, fM7717k2, latLngBounds, fM7717k3, fM7717k4, zM7709c, fM7717k5, fM7717k6, fM7717k7, zM7709c2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GroundOverlayOptions[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
