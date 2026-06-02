package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzv implements Parcelable.Creator<LocationAvailability> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability createFromParcel(Parcel parcel) {
        int iM7712f = 1;
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f2 = 1000;
        long jM7714h = 0;
        zzae[] zzaeVarArr = null;
        int iM7712f3 = 1;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f3 = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 3:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 4:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 5:
                    zzaeVarArr = (zzae[]) zzbfn.m7707b(parcel, i, zzae.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new LocationAvailability(iM7712f2, iM7712f3, iM7712f, jM7714h, zzaeVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
