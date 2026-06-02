package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class zzh implements Parcelable.Creator<MarkerOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MarkerOptions createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        LatLng latLng = null;
        String strM7722p = null;
        String strM7722p2 = null;
        IBinder iBinderM7723q = null;
        float fM7717k = CropImageView.DEFAULT_ASPECT_RATIO;
        float fM7717k2 = CropImageView.DEFAULT_ASPECT_RATIO;
        boolean zM7709c = false;
        boolean zM7709c2 = false;
        boolean zM7709c3 = false;
        float fM7717k3 = CropImageView.DEFAULT_ASPECT_RATIO;
        float fM7717k4 = 0.5f;
        float fM7717k5 = CropImageView.DEFAULT_ASPECT_RATIO;
        float fM7717k6 = 1.0f;
        float fM7717k7 = CropImageView.DEFAULT_ASPECT_RATIO;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    latLng = (LatLng) zzbfn.m7702a(parcel, i, LatLng.CREATOR);
                    break;
                case 3:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 4:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 5:
                    iBinderM7723q = zzbfn.m7723q(parcel, i);
                    break;
                case 6:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                case 7:
                    fM7717k2 = zzbfn.m7717k(parcel, i);
                    break;
                case 8:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 9:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 10:
                    zM7709c3 = zzbfn.m7709c(parcel, i);
                    break;
                case 11:
                    fM7717k3 = zzbfn.m7717k(parcel, i);
                    break;
                case 12:
                    fM7717k4 = zzbfn.m7717k(parcel, i);
                    break;
                case 13:
                    fM7717k5 = zzbfn.m7717k(parcel, i);
                    break;
                case 14:
                    fM7717k6 = zzbfn.m7717k(parcel, i);
                    break;
                case 15:
                    fM7717k7 = zzbfn.m7717k(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new MarkerOptions(latLng, strM7722p, strM7722p2, iBinderM7723q, fM7717k, fM7717k2, zM7709c, zM7709c2, zM7709c3, fM7717k3, fM7717k4, fM7717k5, fM7717k6, fM7717k7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MarkerOptions[] newArray(int i) {
        return new MarkerOptions[i];
    }
}
