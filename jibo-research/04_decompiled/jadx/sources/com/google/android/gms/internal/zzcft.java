package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class zzcft implements Parcelable.Creator<zzcfs> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcfs createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p = null;
        int iM7712f = 0;
        short sM7711e = 0;
        double dM7719m = 0.0d;
        double dM7719m2 = 0.0d;
        float fM7717k = CropImageView.DEFAULT_ASPECT_RATIO;
        long jM7714h = 0;
        int iM7712f2 = 0;
        int iM7712f3 = -1;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 2:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 3:
                    sM7711e = zzbfn.m7711e(parcel, i);
                    break;
                case 4:
                    dM7719m = zzbfn.m7719m(parcel, i);
                    break;
                case 5:
                    dM7719m2 = zzbfn.m7719m(parcel, i);
                    break;
                case 6:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                case 7:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 8:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 9:
                    iM7712f3 = zzbfn.m7712f(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcfs(strM7722p, iM7712f, sM7711e, dM7719m, dM7719m2, fM7717k, jM7714h, iM7712f2, iM7712f3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcfs[] newArray(int i) {
        return new zzcfs[i];
    }
}
