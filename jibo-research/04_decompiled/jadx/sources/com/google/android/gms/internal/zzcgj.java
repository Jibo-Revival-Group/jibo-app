package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgj implements Parcelable.Creator<zzcgi> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcgi createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p = null;
        String strM7722p2 = null;
        String strM7722p3 = null;
        String strM7722p4 = null;
        long jM7714h = 0;
        long jM7714h2 = 0;
        String strM7722p5 = null;
        boolean zM7709c = true;
        boolean zM7709c2 = false;
        long jM7714h3 = -2147483648L;
        String strM7722p6 = null;
        long jM7714h4 = 0;
        long jM7714h5 = 0;
        int iM7712f = 0;
        boolean zM7709c3 = true;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 4:
                    strM7722p3 = zzbfn.m7722p(parcel, i);
                    break;
                case 5:
                    strM7722p4 = zzbfn.m7722p(parcel, i);
                    break;
                case 6:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 7:
                    jM7714h2 = zzbfn.m7714h(parcel, i);
                    break;
                case 8:
                    strM7722p5 = zzbfn.m7722p(parcel, i);
                    break;
                case 9:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 10:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 11:
                    jM7714h3 = zzbfn.m7714h(parcel, i);
                    break;
                case 12:
                    strM7722p6 = zzbfn.m7722p(parcel, i);
                    break;
                case 13:
                    jM7714h4 = zzbfn.m7714h(parcel, i);
                    break;
                case 14:
                    jM7714h5 = zzbfn.m7714h(parcel, i);
                    break;
                case 15:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 16:
                    zM7709c3 = zzbfn.m7709c(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcgi(strM7722p, strM7722p2, strM7722p3, strM7722p4, jM7714h, jM7714h2, strM7722p5, zM7709c, zM7709c2, jM7714h3, strM7722p6, jM7714h4, jM7714h5, iM7712f, zM7709c3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcgi[] newArray(int i) {
        return new zzcgi[i];
    }
}
