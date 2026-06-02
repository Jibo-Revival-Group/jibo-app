package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.internal.zzbfo;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzv implements Parcelable.Creator<zzu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzu createFromParcel(Parcel parcel) {
        int iM7712f = 0;
        DeviceMetaData deviceMetaData = null;
        int iM7700a = zzbfn.m7700a(parcel);
        HashSet hashSet = new HashSet();
        PendingIntent pendingIntent = null;
        byte[] bArrM7725s = null;
        String strM7722p = null;
        int iM7712f2 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    hashSet.add(1);
                    break;
                case 2:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    hashSet.add(2);
                    break;
                case 3:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    hashSet.add(3);
                    break;
                case 4:
                    bArrM7725s = zzbfn.m7725s(parcel, i);
                    hashSet.add(4);
                    break;
                case 5:
                    PendingIntent pendingIntent2 = (PendingIntent) zzbfn.m7702a(parcel, i, PendingIntent.CREATOR);
                    hashSet.add(5);
                    pendingIntent = pendingIntent2;
                    break;
                case 6:
                    DeviceMetaData deviceMetaData2 = (DeviceMetaData) zzbfn.m7702a(parcel, i, DeviceMetaData.CREATOR);
                    hashSet.add(6);
                    deviceMetaData = deviceMetaData2;
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        if (parcel.dataPosition() != iM7700a) {
            throw new zzbfo(new StringBuilder(37).append("Overread allowed size end=").append(iM7700a).toString(), parcel);
        }
        return new zzu(hashSet, iM7712f2, strM7722p, iM7712f, bArrM7725s, pendingIntent, deviceMetaData);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzu[] newArray(int i) {
        return new zzu[i];
    }
}
