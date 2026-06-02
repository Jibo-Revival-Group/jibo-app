package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<ProxyResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyResponse createFromParcel(Parcel parcel) {
        byte[] bArrM7725s = null;
        int iM7712f = 0;
        int iM7700a = zzbfn.m7700a(parcel);
        Bundle bundleM7724r = null;
        PendingIntent pendingIntent = null;
        int iM7712f2 = 0;
        int iM7712f3 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) zzbfn.m7702a(parcel, i, PendingIntent.CREATOR);
                    break;
                case 3:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 4:
                    bundleM7724r = zzbfn.m7724r(parcel, i);
                    break;
                case 5:
                    bArrM7725s = zzbfn.m7725s(parcel, i);
                    break;
                case 1000:
                    iM7712f3 = zzbfn.m7712f(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new ProxyResponse(iM7712f3, iM7712f2, pendingIntent, iM7712f, bundleM7724r, bArrM7725s);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyResponse[] newArray(int i) {
        return new ProxyResponse[i];
    }
}
