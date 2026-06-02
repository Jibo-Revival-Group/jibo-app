package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;

/* JADX INFO: loaded from: classes.dex */
public final class zzawa implements Parcelable.Creator<zzavz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzavz createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    credential = (Credential) zzbfn.m7702a(parcel, i, Credential.CREATOR);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new zzavz(credential);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzavz[] newArray(int i) {
        return new zzavz[i];
    }
}
