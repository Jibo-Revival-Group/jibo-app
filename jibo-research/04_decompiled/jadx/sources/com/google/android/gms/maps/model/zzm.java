package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class zzm implements Parcelable.Creator<StreetViewPanoramaCamera> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaCamera createFromParcel(Parcel parcel) {
        float fM7717k = CropImageView.DEFAULT_ASPECT_RATIO;
        int iM7700a = zzbfn.m7700a(parcel);
        float fM7717k2 = 0.0f;
        float fM7717k3 = 0.0f;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    fM7717k3 = zzbfn.m7717k(parcel, i);
                    break;
                case 3:
                    fM7717k2 = zzbfn.m7717k(parcel, i);
                    break;
                case 4:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new StreetViewPanoramaCamera(fM7717k3, fM7717k2, fM7717k);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaCamera[] newArray(int i) {
        return new StreetViewPanoramaCamera[i];
    }
}
