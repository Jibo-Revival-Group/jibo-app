package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbt;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxq extends zzbfm {
    public static final Parcelable.Creator<zzcxq> CREATOR = new zzcxr();

    /* JADX INFO: renamed from: a */
    private int f7793a;

    /* JADX INFO: renamed from: b */
    private final ConnectionResult f7794b;

    /* JADX INFO: renamed from: c */
    private final zzbt f7795c;

    public zzcxq(int i) {
        this(new ConnectionResult(8, null), null);
    }

    zzcxq(int i, ConnectionResult connectionResult, zzbt zzbtVar) {
        this.f7793a = i;
        this.f7794b = connectionResult;
        this.f7795c = zzbtVar;
    }

    private zzcxq(ConnectionResult connectionResult, zzbt zzbtVar) {
        this(1, connectionResult, null);
    }

    /* JADX INFO: renamed from: a */
    public final ConnectionResult m8511a() {
        return this.f7794b;
    }

    /* JADX INFO: renamed from: b */
    public final zzbt m8512b() {
        return this.f7795c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f7793a);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f7794b, i, false);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f7795c, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
