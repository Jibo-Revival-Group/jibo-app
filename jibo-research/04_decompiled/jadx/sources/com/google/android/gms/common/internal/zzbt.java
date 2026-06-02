package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class zzbt extends zzbfm {
    public static final Parcelable.Creator<zzbt> CREATOR = new zzbu();

    /* JADX INFO: renamed from: a */
    private int f6578a;

    /* JADX INFO: renamed from: b */
    private IBinder f6579b;

    /* JADX INFO: renamed from: c */
    private ConnectionResult f6580c;

    /* JADX INFO: renamed from: d */
    private boolean f6581d;

    /* JADX INFO: renamed from: e */
    private boolean f6582e;

    zzbt(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f6578a = i;
        this.f6579b = iBinder;
        this.f6580c = connectionResult;
        this.f6581d = z;
        this.f6582e = z2;
    }

    /* JADX INFO: renamed from: a */
    public final zzan m7386a() {
        IBinder iBinder = this.f6579b;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        return iInterfaceQueryLocalInterface instanceof zzan ? (zzan) iInterfaceQueryLocalInterface : new zzap(iBinder);
    }

    /* JADX INFO: renamed from: b */
    public final ConnectionResult m7387b() {
        return this.f6580c;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m7388c() {
        return this.f6581d;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m7389d() {
        return this.f6582e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbt)) {
            return false;
        }
        zzbt zzbtVar = (zzbt) obj;
        return this.f6580c.equals(zzbtVar.f6580c) && m7386a().equals(zzbtVar.m7386a());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6578a);
        zzbfp.m7741a(parcel, 2, this.f6579b, false);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f6580c, i, false);
        zzbfp.m7751a(parcel, 4, this.f6581d);
        zzbfp.m7751a(parcel, 5, this.f6582e);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
