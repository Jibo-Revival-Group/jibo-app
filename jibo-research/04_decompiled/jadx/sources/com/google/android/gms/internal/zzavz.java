package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;

/* JADX INFO: loaded from: classes.dex */
public final class zzavz extends zzbfm {
    public static final Parcelable.Creator<zzavz> CREATOR = new zzawa();

    /* JADX INFO: renamed from: a */
    private final Credential f6853a;

    public zzavz(Credential credential) {
        this.f6853a = credential;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 1, (Parcelable) this.f6853a, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
