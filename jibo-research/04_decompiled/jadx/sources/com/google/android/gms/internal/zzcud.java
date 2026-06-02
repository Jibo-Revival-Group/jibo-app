package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzcud implements Parcelable.Creator<zzctx> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzctx createFromParcel(Parcel parcel) {
        byte[][] bArrM7726t = null;
        int iM7700a = zzbfn.m7700a(parcel);
        int[] iArrM7728v = null;
        byte[][] bArrM7726t2 = null;
        byte[][] bArrM7726t3 = null;
        byte[][] bArrM7726t4 = null;
        byte[][] bArrM7726t5 = null;
        byte[] bArrM7725s = null;
        String strM7722p = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 2:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    bArrM7725s = zzbfn.m7725s(parcel, i);
                    break;
                case 4:
                    bArrM7726t5 = zzbfn.m7726t(parcel, i);
                    break;
                case 5:
                    bArrM7726t4 = zzbfn.m7726t(parcel, i);
                    break;
                case 6:
                    bArrM7726t3 = zzbfn.m7726t(parcel, i);
                    break;
                case 7:
                    bArrM7726t2 = zzbfn.m7726t(parcel, i);
                    break;
                case 8:
                    iArrM7728v = zzbfn.m7728v(parcel, i);
                    break;
                case 9:
                    bArrM7726t = zzbfn.m7726t(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzctx(strM7722p, bArrM7725s, bArrM7726t5, bArrM7726t4, bArrM7726t3, bArrM7726t2, iArrM7728v, bArrM7726t);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzctx[] newArray(int i) {
        return new zzctx[i];
    }
}
