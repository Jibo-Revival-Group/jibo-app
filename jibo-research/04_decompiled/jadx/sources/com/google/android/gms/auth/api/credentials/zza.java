package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements Parcelable.Creator<Credential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential createFromParcel(Parcel parcel) {
        String strM7722p = null;
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p2 = null;
        String strM7722p3 = null;
        String strM7722p4 = null;
        String strM7722p5 = null;
        String strM7722p6 = null;
        ArrayList arrayListM7708c = null;
        Uri uri = null;
        String strM7722p7 = null;
        String strM7722p8 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    strM7722p8 = zzbfn.m7722p(parcel, i);
                    break;
                case 2:
                    strM7722p7 = zzbfn.m7722p(parcel, i);
                    break;
                case 3:
                    uri = (Uri) zzbfn.m7702a(parcel, i, Uri.CREATOR);
                    break;
                case 4:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, IdToken.CREATOR);
                    break;
                case 5:
                    strM7722p6 = zzbfn.m7722p(parcel, i);
                    break;
                case 6:
                    strM7722p5 = zzbfn.m7722p(parcel, i);
                    break;
                case 7:
                    strM7722p4 = zzbfn.m7722p(parcel, i);
                    break;
                case 8:
                    strM7722p3 = zzbfn.m7722p(parcel, i);
                    break;
                case 9:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 10:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new Credential(strM7722p8, strM7722p7, uri, arrayListM7708c, strM7722p6, strM7722p5, strM7722p4, strM7722p3, strM7722p2, strM7722p);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential[] newArray(int i) {
        return new Credential[i];
    }
}
