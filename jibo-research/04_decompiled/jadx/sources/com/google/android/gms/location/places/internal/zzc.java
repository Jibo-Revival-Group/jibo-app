package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzc implements Parcelable.Creator<zza> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza createFromParcel(Parcel parcel) {
        ArrayList arrayListM7708c = null;
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        String strM7722p = null;
        ArrayList arrayListM7708c2 = null;
        String strM7722p2 = null;
        ArrayList arrayListM7708c3 = null;
        String strM7722p3 = null;
        ArrayList<Integer> arrayListM7695A = null;
        String strM7722p4 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strM7722p3 = zzbfn.m7722p(parcel, i);
                    break;
                case 2:
                    strM7722p4 = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    arrayListM7695A = zzbfn.m7695A(parcel, i);
                    break;
                case 4:
                    arrayListM7708c3 = zzbfn.m7708c(parcel, i, zzb.CREATOR);
                    break;
                case 5:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 6:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 7:
                    arrayListM7708c2 = zzbfn.m7708c(parcel, i, zzb.CREATOR);
                    break;
                case 8:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 9:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, zzb.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zza(strM7722p4, arrayListM7695A, iM7712f, strM7722p3, arrayListM7708c3, strM7722p2, arrayListM7708c2, strM7722p, arrayListM7708c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
