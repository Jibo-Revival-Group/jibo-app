package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzc implements Parcelable.Creator<CircleOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CircleOptions createFromParcel(Parcel parcel) {
        ArrayList arrayListM7708c = null;
        float fM7717k = CropImageView.DEFAULT_ASPECT_RATIO;
        boolean zM7709c = false;
        int iM7700a = zzbfn.m7700a(parcel);
        double dM7719m = 0.0d;
        boolean zM7709c2 = false;
        int iM7712f = 0;
        int iM7712f2 = 0;
        float fM7717k2 = 0.0f;
        LatLng latLng = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    latLng = (LatLng) zzbfn.m7702a(parcel, i, LatLng.CREATOR);
                    break;
                case 3:
                    dM7719m = zzbfn.m7719m(parcel, i);
                    break;
                case 4:
                    fM7717k2 = zzbfn.m7717k(parcel, i);
                    break;
                case 5:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 6:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 7:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                case 8:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 9:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 10:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, PatternItem.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new CircleOptions(latLng, dM7719m, fM7717k2, iM7712f2, iM7712f, fM7717k, zM7709c2, zM7709c, arrayListM7708c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CircleOptions[] newArray(int i) {
        return new CircleOptions[i];
    }
}
