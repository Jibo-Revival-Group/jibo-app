package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzah implements Parcelable.Creator<zzag> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzag createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        PendingIntent pendingIntent = null;
        ArrayList<String> arrayListM7696B = null;
        String strM7722p = "";
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    arrayListM7696B = zzbfn.m7696B(parcel, i);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) zzbfn.m7702a(parcel, i, PendingIntent.CREATOR);
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
        return new zzag(arrayListM7696B, pendingIntent, strM7722p);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzag[] newArray(int i) {
        return new zzag[i];
    }
}
