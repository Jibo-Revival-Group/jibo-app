package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;

/* JADX INFO: loaded from: classes.dex */
public final class zze implements Parcelable.Creator<CredentialRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialRequest createFromParcel(Parcel parcel) {
        boolean zM7709c = false;
        String strM7722p = null;
        int iM7700a = zzbfn.m7700a(parcel);
        String strM7722p2 = null;
        boolean zM7709c2 = false;
        CredentialPickerConfig credentialPickerConfig = null;
        CredentialPickerConfig credentialPickerConfig2 = null;
        String[] strArrM7732z = null;
        boolean zM7709c3 = false;
        int iM7712f = 0;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    zM7709c3 = zzbfn.m7709c(parcel, i);
                    break;
                case 2:
                    strArrM7732z = zzbfn.m7732z(parcel, i);
                    break;
                case 3:
                    credentialPickerConfig2 = (CredentialPickerConfig) zzbfn.m7702a(parcel, i, CredentialPickerConfig.CREATOR);
                    break;
                case 4:
                    credentialPickerConfig = (CredentialPickerConfig) zzbfn.m7702a(parcel, i, CredentialPickerConfig.CREATOR);
                    break;
                case 5:
                    zM7709c2 = zzbfn.m7709c(parcel, i);
                    break;
                case 6:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 7:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 8:
                    zM7709c = zzbfn.m7709c(parcel, i);
                    break;
                case 1000:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new CredentialRequest(iM7712f, zM7709c3, strArrM7732z, credentialPickerConfig2, credentialPickerConfig, zM7709c2, strM7722p2, strM7722p, zM7709c);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialRequest[] newArray(int i) {
        return new CredentialRequest[i];
    }
}
