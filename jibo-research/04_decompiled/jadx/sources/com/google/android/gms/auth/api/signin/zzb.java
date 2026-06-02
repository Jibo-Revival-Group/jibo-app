package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzb implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        String strM7722p = null;
        String strM7722p2 = null;
        String strM7722p3 = null;
        String strM7722p4 = null;
        Uri uri = null;
        String strM7722p5 = null;
        long jM7714h = 0;
        String strM7722p6 = null;
        ArrayList arrayListM7708c = null;
        String strM7722p7 = null;
        String strM7722p8 = null;
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
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 4:
                    strM7722p3 = zzbfn.m7722p(parcel, i);
                    break;
                case 5:
                    strM7722p4 = zzbfn.m7722p(parcel, i);
                    break;
                case 6:
                    uri = (Uri) zzbfn.m7702a(parcel, i, Uri.CREATOR);
                    break;
                case 7:
                    strM7722p5 = zzbfn.m7722p(parcel, i);
                    break;
                case 8:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 9:
                    strM7722p6 = zzbfn.m7722p(parcel, i);
                    break;
                case 10:
                    arrayListM7708c = zzbfn.m7708c(parcel, i, Scope.CREATOR);
                    break;
                case 11:
                    strM7722p7 = zzbfn.m7722p(parcel, i);
                    break;
                case 12:
                    strM7722p8 = zzbfn.m7722p(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new GoogleSignInAccount(iM7712f, strM7722p, strM7722p2, strM7722p3, strM7722p4, uri, strM7722p5, jM7714h, strM7722p6, arrayListM7708c, strM7722p7, strM7722p8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
