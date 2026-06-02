package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements Parcelable.Creator<ProxyRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyRequest createFromParcel(Parcel parcel) {
        int iM7712f = 0;
        Bundle bundleM7724r = null;
        int iM7700a = zzbfn.m7700a(parcel);
        long jM7714h = 0;
        byte[] bArrM7725s = null;
        String strM7722p = null;
        int iM7712f2 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 2:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 3:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 4:
                    bArrM7725s = zzbfn.m7725s(parcel, i);
                    break;
                case 5:
                    bundleM7724r = zzbfn.m7724r(parcel, i);
                    break;
                case 1000:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new ProxyRequest(iM7712f2, strM7722p, iM7712f, jM7714h, bArrM7725s, bundleM7724r);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyRequest[] newArray(int i) {
        return new ProxyRequest[i];
    }
}
