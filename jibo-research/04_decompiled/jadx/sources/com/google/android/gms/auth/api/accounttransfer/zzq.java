package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzq implements Parcelable.Creator<zzp> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzp createFromParcel(Parcel parcel) {
        ArrayList<String> arrayListM7696B = null;
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        ArrayList<String> arrayListM7696B2 = null;
        ArrayList<String> arrayListM7696B3 = null;
        ArrayList<String> arrayListM7696B4 = null;
        ArrayList<String> arrayListM7696B5 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    arrayListM7696B5 = zzbfn.m7696B(parcel, i);
                    break;
                case 3:
                    arrayListM7696B4 = zzbfn.m7696B(parcel, i);
                    break;
                case 4:
                    arrayListM7696B3 = zzbfn.m7696B(parcel, i);
                    break;
                case 5:
                    arrayListM7696B2 = zzbfn.m7696B(parcel, i);
                    break;
                case 6:
                    arrayListM7696B = zzbfn.m7696B(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzp(iM7712f, arrayListM7696B5, arrayListM7696B4, arrayListM7696B3, arrayListM7696B2, arrayListM7696B);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzp[] newArray(int i) {
        return new zzp[i];
    }
}
