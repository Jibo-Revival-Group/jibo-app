package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<AddPlaceRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AddPlaceRequest createFromParcel(Parcel parcel) {
        Uri uri = null;
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p = null;
        ArrayList<Integer> arrayListM7695A = null;
        String strM7722p2 = null;
        LatLng latLng = null;
        String strM7722p3 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strM7722p3 = zzbfn.m7722p(parcel, i);
                    break;
                case 2:
                    latLng = (LatLng) zzbfn.m7702a(parcel, i, LatLng.CREATOR);
                    break;
                case 3:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 4:
                    arrayListM7695A = zzbfn.m7695A(parcel, i);
                    break;
                case 5:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 6:
                    uri = (Uri) zzbfn.m7702a(parcel, i, Uri.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new AddPlaceRequest(strM7722p3, latLng, strM7722p2, arrayListM7695A, strM7722p, uri);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AddPlaceRequest[] newArray(int i) {
        return new AddPlaceRequest[i];
    }
}
