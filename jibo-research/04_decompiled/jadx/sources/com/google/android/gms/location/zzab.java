package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzab implements Parcelable.Creator<LocationSettingsRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsRequest createFromParcel(Parcel parcel) {
        zzz zzzVar = null;
        boolean zM7709c = false;
        int iM7700a = zzbfn.m7700a(parcel);
        boolean zM7709c2 = false;
        ArrayList arrayListM7708c = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, LocationRequest.CREATOR);
                    break;
                case 2:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 3:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 4:
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
                case 5:
                    zzzVar = (zzz) zzbfn.m7702a(parcel, i, zzz.CREATOR);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new LocationSettingsRequest(arrayListM7708c, zM7709c2, zM7709c, zzzVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsRequest[] newArray(int i) {
        return new LocationSettingsRequest[i];
    }
}
