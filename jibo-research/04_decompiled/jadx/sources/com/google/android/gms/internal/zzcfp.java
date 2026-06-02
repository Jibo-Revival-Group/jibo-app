package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfp implements Parcelable.Creator<zzcfo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcfo createFromParcel(Parcel parcel) {
        String strM7722p = null;
        boolean zM7709c = false;
        int iM7700a = zzbfn.m7700a(parcel);
        List<zzcdv> listM7708c = zzcfo.f7018a;
        boolean zM7709c2 = false;
        boolean zM7709c3 = false;
        String strM7722p2 = null;
        LocationRequest locationRequest = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    locationRequest = (LocationRequest) zzbfn.m7702a(parcel, i, LocationRequest.CREATOR);
                    break;
                case 2:
                case 3:
                case 4:
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
                case 5:
                    listM7708c = zzbfn.m7708c(parcel, i, zzcdv.CREATOR);
                    break;
                case 6:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 7:
                    zM7709c3 = zzbfn.m7709c(parcel, i);
                    break;
                case 8:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 9:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 10:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcfo(locationRequest, listM7708c, strM7722p2, zM7709c3, zM7709c2, zM7709c, strM7722p);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcfo[] newArray(int i) {
        return new zzcfo[i];
    }
}
