package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.internal.zzbfo;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzn implements Parcelable.Creator<zzm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm createFromParcel(Parcel parcel) {
        zzp zzpVar = null;
        int iM7712f = 0;
        int iM7700a = zzbfn.m7700a(parcel);
        HashSet hashSet = new HashSet();
        ArrayList arrayListM7708c = null;
        int iM7712f2 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    hashSet.add(1);
                    break;
                case 2:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, zzs.CREATOR);
                    hashSet.add(2);
                    break;
                case 3:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    hashSet.add(3);
                    break;
                case 4:
                    zzp zzpVar2 = (zzp) zzbfn.m7702a(parcel, i, zzp.CREATOR);
                    hashSet.add(4);
                    zzpVar = zzpVar2;
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        if (parcel.dataPosition() != iM7700a) {
            throw new zzbfo(new StringBuilder(37).append("Overread allowed size end=").append(iM7700a).toString(), parcel);
        }
        return new zzm(hashSet, iM7712f2, arrayListM7708c, iM7712f, zzpVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm[] newArray(int i) {
        return new zzm[i];
    }
}
