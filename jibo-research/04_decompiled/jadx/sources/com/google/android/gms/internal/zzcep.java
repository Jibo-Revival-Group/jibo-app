package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class zzcep implements Parcelable.Creator<zzceo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzceo createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        Status status = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    status = (Status) zzbfn.m7702a(parcel, i, Status.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzceo(status);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzceo[] newArray(int i) {
        return new zzceo[i];
    }
}
