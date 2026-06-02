package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzo implements Parcelable.Creator<zzn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzn createFromParcel(Parcel parcel) {
        IBinder iBinderM7723q = null;
        int iM7700a = zzbfn.m7700a(parcel);
        boolean zM7709c = false;
        String strM7722p = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 2:
                    iBinderM7723q = zzbfn.m7723q(parcel, i);
                    break;
                case 3:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzn(strM7722p, iBinderM7723q, zM7709c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzn[] newArray(int i) {
        return new zzn[i];
    }
}
