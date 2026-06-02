package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements Parcelable.Creator<AccountChangeEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEvent createFromParcel(Parcel parcel) {
        String strM7722p = null;
        int iM7712f = 0;
        int iM7700a = zzbfn.m7700a(parcel);
        long jM7714h = 0;
        int iM7712f2 = 0;
        String strM7722p2 = null;
        int iM7712f3 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f3 = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 3:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 4:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 5:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 6:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new AccountChangeEvent(iM7712f3, jM7714h, strM7722p2, iM7712f2, iM7712f, strM7722p);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AccountChangeEvent[] newArray(int i) {
        return new AccountChangeEvent[i];
    }
}
