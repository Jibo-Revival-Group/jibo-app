package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zzc implements Parcelable.Creator<CredentialPickerConfig> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialPickerConfig createFromParcel(Parcel parcel) {
        int iM7712f = 0;
        int iM7700a = zzbfn.m7700a(parcel);
        boolean zM7709c = false;
        boolean zM7709c2 = false;
        boolean zM7709c3 = false;
        int iM7712f2 = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    zM7709c3 = zzbfn.m7709c(parcel, i);
                    break;
                case 2:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 3:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 4:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 1000:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new CredentialPickerConfig(iM7712f2, zM7709c3, zM7709c2, zM7709c, iM7712f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialPickerConfig[] newArray(int i) {
        return new CredentialPickerConfig[i];
    }
}
