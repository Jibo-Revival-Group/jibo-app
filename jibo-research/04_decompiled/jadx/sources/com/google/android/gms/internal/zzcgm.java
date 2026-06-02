package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgm implements Parcelable.Creator<zzcgl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcgl createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        String strM7722p = null;
        String strM7722p2 = null;
        zzcln zzclnVar = null;
        long jM7714h = 0;
        boolean zM7709c = false;
        String strM7722p3 = null;
        zzcha zzchaVar = null;
        long jM7714h2 = 0;
        zzcha zzchaVar2 = null;
        long jM7714h3 = 0;
        zzcha zzchaVar3 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 4:
                    zzclnVar = (zzcln) zzbfn.m7702a(parcel, i, zzcln.CREATOR);
                    break;
                case 5:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 6:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 7:
                    strM7722p3 = zzbfn.m7722p(parcel, i);
                    break;
                case 8:
                    zzchaVar = (zzcha) zzbfn.m7702a(parcel, i, zzcha.CREATOR);
                    break;
                case 9:
                    jM7714h2 = zzbfn.m7714h(parcel, i);
                    break;
                case 10:
                    zzchaVar2 = (zzcha) zzbfn.m7702a(parcel, i, zzcha.CREATOR);
                    break;
                case 11:
                    jM7714h3 = zzbfn.m7714h(parcel, i);
                    break;
                case 12:
                    zzchaVar3 = (zzcha) zzbfn.m7702a(parcel, i, zzcha.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcgl(iM7712f, strM7722p, strM7722p2, zzclnVar, jM7714h, zM7709c, strM7722p3, zzchaVar, jM7714h2, zzchaVar2, jM7714h3, zzchaVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcgl[] newArray(int i) {
        return new zzcgl[i];
    }
}
