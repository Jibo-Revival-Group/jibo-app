package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class zzceo extends zzbfm implements Result {

    /* JADX INFO: renamed from: b */
    private final Status f7004b;

    /* JADX INFO: renamed from: a */
    private static zzceo f7003a = new zzceo(Status.f6129a);
    public static final Parcelable.Creator<zzceo> CREATOR = new zzcep();

    public zzceo(Status status) {
        this.f7004b = status;
    }

    @Override // com.google.android.gms.common.api.Result
    /* JADX INFO: renamed from: a */
    public final Status mo6927a() {
        return this.f7004b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 1, (Parcelable) mo6927a(), i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
