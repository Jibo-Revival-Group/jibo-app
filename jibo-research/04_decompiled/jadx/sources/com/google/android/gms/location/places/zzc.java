package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzc implements Parcelable.Creator<AutocompleteFilter> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AutocompleteFilter createFromParcel(Parcel parcel) {
        String strM7722p = null;
        int iM7700a = zzbfn.m7700a(parcel);
        boolean zM7709c = false;
        int iM7712f = 0;
        ArrayList<Integer> arrayListM7695A = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 2:
                    arrayListM7695A = zzbfn.m7695A(parcel, i);
                    break;
                case 3:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 1000:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new AutocompleteFilter(iM7712f, zM7709c, arrayListM7695A, strM7722p);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AutocompleteFilter[] newArray(int i) {
        return new AutocompleteFilter[i];
    }
}
