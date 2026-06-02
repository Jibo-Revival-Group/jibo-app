package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzw implements Parcelable.Creator<DeviceMetaData> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DeviceMetaData createFromParcel(Parcel parcel) {
        boolean zM7709c = false;
        int iM7700a = zzbfn.m7700a(parcel);
        long jM7714h = 0;
        boolean zM7709c2 = false;
        int iM7712f = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 3:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 4:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new DeviceMetaData(iM7712f, zM7709c2, jM7714h, zM7709c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DeviceMetaData[] newArray(int i) {
        return new DeviceMetaData[i];
    }
}
