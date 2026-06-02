package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzcfs;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GeofencingRequest extends zzbfm {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zzl();

    /* JADX INFO: renamed from: a */
    private final List<zzcfs> f8047a;

    /* JADX INFO: renamed from: b */
    private final int f8048b;

    /* JADX INFO: renamed from: c */
    private final String f8049c;

    GeofencingRequest(List<zzcfs> list, int i, String str) {
        this.f8047a = list;
        this.f8048b = i;
        this.f8049c = str;
    }

    /* JADX INFO: renamed from: a */
    public int m8738a() {
        return this.f8048b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeofencingRequest[");
        sb.append("geofences=");
        sb.append(this.f8047a);
        sb.append(new StringBuilder(30).append(", initialTrigger=").append(this.f8048b).append(", ").toString());
        String strValueOf = String.valueOf(this.f8049c);
        sb.append(strValueOf.length() != 0 ? "tag=".concat(strValueOf) : new String("tag="));
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7762c(parcel, 1, this.f8047a, false);
        zzbfp.m7738a(parcel, 2, m8738a());
        zzbfp.m7748a(parcel, 3, this.f8049c, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
