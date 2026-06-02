package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzcea implements Parcelable.Creator<zzcdz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcdz createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        IBinder iBinderM7723q = null;
        zzcdx zzcdxVar = null;
        int iM7712f = 1;
        IBinder iBinderM7723q2 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    zzcdxVar = (zzcdx) zzbfn.m7702a(parcel, i, zzcdx.CREATOR);
                    break;
                case 3:
                    iBinderM7723q = zzbfn.m7723q(parcel, i);
                    break;
                case 4:
                    iBinderM7723q2 = zzbfn.m7723q(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcdz(iM7712f, zzcdxVar, iBinderM7723q, iBinderM7723q2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcdz[] newArray(int i) {
        return new zzcdz[i];
    }
}
