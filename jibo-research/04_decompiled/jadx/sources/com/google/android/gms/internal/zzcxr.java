package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbt;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxr implements Parcelable.Creator<zzcxq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcxq createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        ConnectionResult connectionResult = null;
        int iM7712f = 0;
        zzbt zzbtVar = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    connectionResult = (ConnectionResult) zzbfn.m7702a(parcel, i, ConnectionResult.CREATOR);
                    break;
                case 3:
                    zzbtVar = (zzbt) zzbfn.m7702a(parcel, i, zzbt.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcxq(iM7712f, connectionResult, zzbtVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcxq[] newArray(int i) {
        return new zzcxq[i];
    }
}
