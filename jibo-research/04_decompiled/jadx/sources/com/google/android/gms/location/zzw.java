package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class zzw implements Parcelable.Creator<LocationRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 102;
        long jM7714h = 3600000;
        long jM7714h2 = 600000;
        boolean zM7709c = false;
        long jM7714h3 = Long.MAX_VALUE;
        int iM7712f2 = Integer.MAX_VALUE;
        float fM7717k = CropImageView.DEFAULT_ASPECT_RATIO;
        long jM7714h4 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 3:
                    jM7714h2 = zzbfn.m7714h(parcel, i);
                    break;
                case 4:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 5:
                    jM7714h3 = zzbfn.m7714h(parcel, i);
                    break;
                case 6:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 7:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                case 8:
                    jM7714h4 = zzbfn.m7714h(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new LocationRequest(iM7712f, jM7714h, jM7714h2, zM7709c, jM7714h3, iM7712f2, fM7717k, jM7714h4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest[] newArray(int i) {
        return new LocationRequest[i];
    }
}
