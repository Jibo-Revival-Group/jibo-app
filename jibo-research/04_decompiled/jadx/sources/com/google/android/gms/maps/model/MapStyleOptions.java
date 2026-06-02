package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class MapStyleOptions extends zzbfm {

    /* JADX INFO: renamed from: b */
    private String f8317b;

    /* JADX INFO: renamed from: a */
    private static final String f8316a = MapStyleOptions.class.getSimpleName();
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new zzg();

    public MapStyleOptions(String str) {
        this.f8317b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 2, this.f8317b, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
