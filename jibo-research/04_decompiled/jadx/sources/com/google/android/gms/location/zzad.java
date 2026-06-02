package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzad implements Parcelable.Creator<LocationSettingsStates> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsStates createFromParcel(Parcel parcel) {
        boolean zM7709c = false;
        int iM7700a = zzbfn.m7700a(parcel);
        boolean zM7709c2 = false;
        boolean zM7709c3 = false;
        boolean zM7709c4 = false;
        boolean zM7709c5 = false;
        boolean zM7709c6 = false;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    zM7709c6 = zzbfn.m7709c(parcel, i);
                    break;
                case 2:
                    zM7709c5 = zzbfn.m7709c(parcel, i);
                    break;
                case 3:
                    zM7709c4 = zzbfn.m7709c(parcel, i);
                    break;
                case 4:
                    zM7709c3 = zzbfn.m7709c(parcel, i);
                    break;
                case 5:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 6:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new LocationSettingsStates(zM7709c6, zM7709c5, zM7709c4, zM7709c3, zM7709c2, zM7709c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsStates[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}
