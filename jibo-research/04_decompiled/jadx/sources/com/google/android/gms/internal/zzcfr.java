package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfr implements Parcelable.Creator<zzcfq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcfq createFromParcel(Parcel parcel) {
        IBinder iBinderM7723q = null;
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 1;
        IBinder iBinderM7723q2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinderM7723q3 = null;
        zzcfo zzcfoVar = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    zzcfoVar = (zzcfo) zzbfn.m7702a(parcel, i, zzcfo.CREATOR);
                    break;
                case 3:
                    iBinderM7723q3 = zzbfn.m7723q(parcel, i);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zzbfn.m7702a(parcel, i, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinderM7723q2 = zzbfn.m7723q(parcel, i);
                    break;
                case 6:
                    iBinderM7723q = zzbfn.m7723q(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcfq(iM7712f, zzcfoVar, iBinderM7723q3, pendingIntent, iBinderM7723q2, iBinderM7723q);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcfq[] newArray(int i) {
        return new zzcfq[i];
    }
}
