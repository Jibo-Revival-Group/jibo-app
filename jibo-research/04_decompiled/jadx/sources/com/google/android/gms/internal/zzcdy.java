package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.zze;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzcdy implements Parcelable.Creator<zzcdx> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcdx createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        zze zzeVar = zzcdx.f6995b;
        List<zzcdv> listM7708c = zzcdx.f6994a;
        String strM7722p = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    zzeVar = (zze) zzbfn.m7702a(parcel, i, zze.CREATOR);
                    break;
                case 2:
                    listM7708c = zzbfn.m7708c(parcel, i, zzcdv.CREATOR);
                    break;
                case 3:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzcdx(zzeVar, listM7708c, strM7722p);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcdx[] newArray(int i) {
        return new zzcdx[i];
    }
}
