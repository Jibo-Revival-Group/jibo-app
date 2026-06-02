package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzaa implements Parcelable.Creator<zzz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p = "";
        String strM7722p2 = "";
        String strM7722p3 = "";
        int iM7712f = 0;
        boolean zM7709c = true;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 2:
                    strM7722p3 = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 4:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 5:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzz(strM7722p, strM7722p2, strM7722p3, iM7712f, zM7709c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz[] newArray(int i) {
        return new zzz[i];
    }
}
