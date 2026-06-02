package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzh implements Parcelable.Creator<PlaceFilter> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceFilter createFromParcel(Parcel parcel) {
        ArrayList arrayListM7708c = null;
        int iM7700a = zzbfn.m7700a(parcel);
        boolean zM7709c = false;
        ArrayList<Integer> arrayListM7695A = null;
        ArrayList<String> arrayListM7696B = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    arrayListM7695A = zzbfn.m7695A(parcel, i);
                    break;
                case 2:
                case 5:
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
                case 3:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 4:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, zzo.CREATOR);
                    break;
                case 6:
                    arrayListM7696B = zzbfn.m7696B(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new PlaceFilter((List<Integer>) arrayListM7695A, zM7709c, (List<String>) arrayListM7696B, (List<zzo>) arrayListM7708c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceFilter[] newArray(int i) {
        return new PlaceFilter[i];
    }
}
