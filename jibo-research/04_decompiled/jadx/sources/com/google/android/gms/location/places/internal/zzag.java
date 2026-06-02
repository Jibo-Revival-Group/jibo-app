package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzag implements Parcelable.Creator<zzaf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf createFromParcel(Parcel parcel) {
        Uri uri = null;
        int iM7700a = zzbfn.m7700a(parcel);
        float fM7717k = CropImageView.DEFAULT_ASPECT_RATIO;
        int iM7712f = 0;
        String strM7722p = null;
        ArrayList<Integer> arrayListM7695A = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    arrayListM7695A = zzbfn.m7695A(parcel, i);
                    break;
                case 2:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    uri = (Uri) zzbfn.m7702a(parcel, i, Uri.CREATOR);
                    break;
                case 4:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                case 5:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzaf(arrayListM7695A, strM7722p, uri, fM7717k, iM7712f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf[] newArray(int i) {
        return new zzaf[i];
    }
}
