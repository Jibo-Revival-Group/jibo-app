package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsResult extends zzbfm implements Result {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzac();

    /* JADX INFO: renamed from: a */
    private final Status f8075a;

    /* JADX INFO: renamed from: b */
    private final LocationSettingsStates f8076b;

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.f8075a = status;
        this.f8076b = locationSettingsStates;
    }

    @Override // com.google.android.gms.common.api.Result
    /* JADX INFO: renamed from: a */
    public final Status mo6927a() {
        return this.f8075a;
    }

    /* JADX INFO: renamed from: b */
    public final LocationSettingsStates m8746b() {
        return this.f8076b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 1, (Parcelable) mo6927a(), i, false);
        zzbfp.m7743a(parcel, 2, (Parcelable) m8746b(), i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
