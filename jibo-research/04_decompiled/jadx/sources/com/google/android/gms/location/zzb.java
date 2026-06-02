package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<ActivityRecognitionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long jM7714h = 0;
        Bundle bundleM7724r = null;
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        long jM7714h2 = 0;
        ArrayList arrayListM7708c = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, DetectedActivity.CREATOR);
                    break;
                case 2:
                    jM7714h2 = zzbfn.m7714h(parcel, i);
                    break;
                case 3:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 4:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 5:
                    bundleM7724r = zzbfn.m7724r(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new ActivityRecognitionResult(arrayListM7708c, jM7714h2, jM7714h, iM7712f, bundleM7724r);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityRecognitionResult[] newArray(int i) {
        return new ActivityRecognitionResult[i];
    }
}
