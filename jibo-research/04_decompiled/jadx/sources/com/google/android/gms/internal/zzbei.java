package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbei implements Parcelable.Creator<zzbeh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbeh createFromParcel(Parcel parcel) {
        zzctx[] zzctxVarArr = null;
        int iM7700a = zzbfn.m7700a(parcel);
        boolean zM7709c = true;
        byte[][] bArrM7726t = null;
        int[] iArrM7728v = null;
        String[] strArrM7732z = null;
        int[] iArrM7728v2 = null;
        byte[] bArrM7725s = null;
        zzbew zzbewVar = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    zzbewVar = (zzbew) zzbfn.m7702a(parcel, i, zzbew.CREATOR);
                    break;
                case 3:
                    bArrM7725s = zzbfn.m7725s(parcel, i);
                    break;
                case 4:
                    iArrM7728v2 = zzbfn.m7728v(parcel, i);
                    break;
                case 5:
                    strArrM7732z = zzbfn.m7732z(parcel, i);
                    break;
                case 6:
                    iArrM7728v = zzbfn.m7728v(parcel, i);
                    break;
                case 7:
                    bArrM7726t = zzbfn.m7726t(parcel, i);
                    break;
                case 8:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 9:
                    zzctxVarArr = (zzctx[]) zzbfn.m7707b(parcel, i, zzctx.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzbeh(zzbewVar, bArrM7725s, iArrM7728v2, strArrM7732z, iArrM7728v, bArrM7726t, zM7709c, zzctxVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbeh[] newArray(int i) {
        return new zzbeh[i];
    }
}
