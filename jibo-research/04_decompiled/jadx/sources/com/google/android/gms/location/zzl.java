package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.internal.zzcfs;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzl implements Parcelable.Creator<GeofencingRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GeofencingRequest createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        ArrayList arrayListM7708c = null;
        int iM7712f = 0;
        String strM7722p = "";
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, zzcfs.CREATOR);
                    break;
                case 2:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 3:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new GeofencingRequest(arrayListM7708c, iM7712f, strM7722p);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GeofencingRequest[] newArray(int i) {
        return new GeofencingRequest[i];
    }
}
