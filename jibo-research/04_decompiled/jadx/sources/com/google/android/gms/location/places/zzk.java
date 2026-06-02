package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzk implements Parcelable.Creator<PlacePhotoResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlacePhotoResult createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        BitmapTeleporter bitmapTeleporter = null;
        Status status = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    status = (Status) zzbfn.m7702a(parcel, i, Status.CREATOR);
                    break;
                case 2:
                    bitmapTeleporter = (BitmapTeleporter) zzbfn.m7702a(parcel, i, BitmapTeleporter.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new PlacePhotoResult(status, bitmapTeleporter);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlacePhotoResult[] newArray(int i) {
        return new PlacePhotoResult[i];
    }
}
