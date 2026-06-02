package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class zzt implements Parcelable.Creator<TileOverlayOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TileOverlayOptions createFromParcel(Parcel parcel) {
        float fM7717k = CropImageView.DEFAULT_ASPECT_RATIO;
        int iM7700a = zzbfn.m7700a(parcel);
        IBinder iBinderM7723q = null;
        boolean zM7709c = false;
        boolean zM7709c2 = true;
        float fM7717k2 = 0.0f;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    iBinderM7723q = zzbfn.m7723q(parcel, i);
                    break;
                case 3:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 4:
                    fM7717k2 = zzbfn.m7717k(parcel, i);
                    break;
                case 5:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 6:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new TileOverlayOptions(iBinderM7723q, zM7709c, fM7717k2, zM7709c2, fM7717k);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TileOverlayOptions[] newArray(int i) {
        return new TileOverlayOptions[i];
    }
}
