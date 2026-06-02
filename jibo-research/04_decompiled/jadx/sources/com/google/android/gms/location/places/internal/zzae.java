package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzae implements Parcelable.Creator<PlaceEntity> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceEntity createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p = null;
        ArrayList<Integer> arrayListM7695A = null;
        ArrayList<Integer> arrayListM7695A2 = null;
        Bundle bundleM7724r = null;
        String strM7722p2 = null;
        String strM7722p3 = null;
        String strM7722p4 = null;
        String strM7722p5 = null;
        ArrayList<String> arrayListM7696B = null;
        LatLng latLng = null;
        float fM7717k = CropImageView.DEFAULT_ASPECT_RATIO;
        LatLngBounds latLngBounds = null;
        String strM7722p6 = null;
        Uri uri = null;
        boolean zM7709c = false;
        float fM7717k2 = CropImageView.DEFAULT_ASPECT_RATIO;
        int iM7712f = 0;
        zzak zzakVar = null;
        zzam zzamVar = null;
        zzaf zzafVar = null;
        String strM7722p7 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 2:
                    bundleM7724r = zzbfn.m7724r(parcel, i);
                    break;
                case 3:
                    zzakVar = (zzak) zzbfn.m7702a(parcel, i, zzak.CREATOR);
                    break;
                case 4:
                    latLng = (LatLng) zzbfn.m7702a(parcel, i, LatLng.CREATOR);
                    break;
                case 5:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zzbfn.m7702a(parcel, i, LatLngBounds.CREATOR);
                    break;
                case 7:
                    strM7722p6 = zzbfn.m7722p(parcel, i);
                    break;
                case 8:
                    uri = (Uri) zzbfn.m7702a(parcel, i, Uri.CREATOR);
                    break;
                case 9:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 10:
                    fM7717k2 = zzbfn.m7717k(parcel, i);
                    break;
                case 11:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 12:
                case 18:
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
                case 13:
                    arrayListM7695A2 = zzbfn.m7695A(parcel, i);
                    break;
                case 14:
                    strM7722p3 = zzbfn.m7722p(parcel, i);
                    break;
                case 15:
                    strM7722p4 = zzbfn.m7722p(parcel, i);
                    break;
                case 16:
                    strM7722p5 = zzbfn.m7722p(parcel, i);
                    break;
                case 17:
                    arrayListM7696B = zzbfn.m7696B(parcel, i);
                    break;
                case 19:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 20:
                    arrayListM7695A = zzbfn.m7695A(parcel, i);
                    break;
                case 21:
                    zzamVar = (zzam) zzbfn.m7702a(parcel, i, zzam.CREATOR);
                    break;
                case 22:
                    zzafVar = (zzaf) zzbfn.m7702a(parcel, i, zzaf.CREATOR);
                    break;
                case 23:
                    strM7722p7 = zzbfn.m7722p(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new PlaceEntity(strM7722p, arrayListM7695A, arrayListM7695A2, bundleM7724r, strM7722p2, strM7722p3, strM7722p4, strM7722p5, arrayListM7696B, latLng, fM7717k, latLngBounds, strM7722p6, uri, zM7709c, fM7717k2, iM7712f, zzakVar, zzamVar, zzafVar, strM7722p7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceEntity[] newArray(int i) {
        return new PlaceEntity[i];
    }
}
