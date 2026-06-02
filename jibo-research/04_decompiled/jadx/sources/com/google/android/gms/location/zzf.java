package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class zzf implements Parcelable.Creator<zze> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zze createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        boolean zM7709c = true;
        long jM7714h = 50;
        float fM7717k = CropImageView.DEFAULT_ASPECT_RATIO;
        long jM7714h2 = Long.MAX_VALUE;
        int iM7712f = Integer.MAX_VALUE;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 2:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 3:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                case 4:
                    jM7714h2 = zzbfn.m7714h(parcel, i);
                    break;
                case 5:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zze(zM7709c, jM7714h, fM7717k, jM7714h2, iM7712f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zze[] newArray(int i) {
        return new zze[i];
    }
}
