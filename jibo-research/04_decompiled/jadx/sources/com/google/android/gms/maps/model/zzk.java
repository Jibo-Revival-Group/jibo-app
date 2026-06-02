package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzk implements Parcelable.Creator<PolygonOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolygonOptions createFromParcel(Parcel parcel) {
        ArrayList arrayListM7708c = null;
        float fM7717k = CropImageView.DEFAULT_ASPECT_RATIO;
        int iM7712f = 0;
        int iM7700a = zzbfn.m7700a(parcel);
        ArrayList arrayList = new ArrayList();
        boolean zM7709c = false;
        boolean zM7709c2 = false;
        boolean zM7709c3 = false;
        int iM7712f2 = 0;
        int iM7712f3 = 0;
        float fM7717k2 = 0.0f;
        ArrayList arrayListM7708c2 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    arrayListM7708c2 = zzbfn.m7708c(parcel, i, LatLng.CREATOR);
                    break;
                case 3:
                    zzbfn.m7705a(parcel, i, arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    fM7717k2 = zzbfn.m7717k(parcel, i);
                    break;
                case 5:
                    iM7712f3 = zzbfn.m7712f(parcel, i);
                    break;
                case 6:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 7:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                case 8:
                    zM7709c3 = zzbfn.m7709c(parcel, i);
                    break;
                case 9:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 10:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 11:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 12:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, PatternItem.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new PolygonOptions(arrayListM7708c2, arrayList, fM7717k2, iM7712f3, iM7712f2, fM7717k, zM7709c3, zM7709c2, zM7709c, iM7712f, arrayListM7708c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolygonOptions[] newArray(int i) {
        return new PolygonOptions[i];
    }
}
