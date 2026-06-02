package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzavm implements Parcelable.Creator<zzavl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzavl createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        String strM7722p = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) zzbfn.m7702a(parcel, i, PendingIntent.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzavl(iM7712f, strM7722p, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzavl[] newArray(int i) {
        return new zzavl[i];
    }
}
