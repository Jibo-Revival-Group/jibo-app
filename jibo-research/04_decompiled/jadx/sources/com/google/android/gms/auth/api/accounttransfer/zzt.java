package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.internal.zzbfo;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzt implements Parcelable.Creator<zzs> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzs createFromParcel(Parcel parcel) {
        String strM7722p = null;
        int iM7700a = zzbfn.m7700a(parcel);
        HashSet hashSet = new HashSet();
        int iM7712f = 0;
        String strM7722p2 = null;
        zzu zzuVar = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    hashSet.add(1);
                    break;
                case 2:
                    zzu zzuVar2 = (zzu) zzbfn.m7702a(parcel, i, zzu.CREATOR);
                    hashSet.add(2);
                    zzuVar = zzuVar2;
                    break;
                case 3:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    hashSet.add(3);
                    break;
                case 4:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    hashSet.add(4);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        if (parcel.dataPosition() != iM7700a) {
            throw new zzbfo(new StringBuilder(37).append("Overread allowed size end=").append(iM7700a).toString(), parcel);
        }
        return new zzs(hashSet, iM7712f, zzuVar, strM7722p2, strM7722p);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzs[] newArray(int i) {
        return new zzs[i];
    }
}
