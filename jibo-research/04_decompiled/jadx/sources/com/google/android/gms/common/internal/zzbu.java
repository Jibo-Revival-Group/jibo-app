package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzbu implements Parcelable.Creator<zzbt> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbt createFromParcel(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean zM7709c = false;
        int iM7700a = zzbfn.m7700a(parcel);
        boolean zM7709c2 = false;
        IBinder iBinderM7723q = null;
        int iM7712f = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    iBinderM7723q = zzbfn.m7723q(parcel, i);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) zzbfn.m7702a(parcel, i, ConnectionResult.CREATOR);
                    break;
                case 4:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 5:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzbt(iM7712f, iBinderM7723q, connectionResult, zM7709c2, zM7709c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbt[] newArray(int i) {
        return new zzbt[i];
    }
}
