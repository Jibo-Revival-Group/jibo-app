package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzbw implements Parcelable.Creator<zzbv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbv createFromParcel(Parcel parcel) {
        int iM7712f = 0;
        int iM7700a = zzbfn.m7700a(parcel);
        Scope[] scopeArr = null;
        int iM7712f2 = 0;
        int iM7712f3 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f3 = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 3:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 4:
                    scopeArr = (Scope[]) zzbfn.m7707b(parcel, i, Scope.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzbv(iM7712f3, iM7712f2, iM7712f, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbv[] newArray(int i) {
        return new zzbv[i];
    }
}
