package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public class DeviceMetaData extends zzbfm {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zzw();

    /* JADX INFO: renamed from: a */
    private int f5878a;

    /* JADX INFO: renamed from: b */
    private boolean f5879b;

    /* JADX INFO: renamed from: c */
    private long f5880c;

    /* JADX INFO: renamed from: d */
    private final boolean f5881d;

    DeviceMetaData(int i, boolean z, long j, boolean z2) {
        this.f5878a = i;
        this.f5879b = z;
        this.f5880c = j;
        this.f5881d = z2;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6676a() {
        return this.f5879b;
    }

    /* JADX INFO: renamed from: b */
    public long m6677b() {
        return this.f5880c;
    }

    /* JADX INFO: renamed from: c */
    public boolean m6678c() {
        return this.f5881d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f5878a);
        zzbfp.m7751a(parcel, 2, m6676a());
        zzbfp.m7739a(parcel, 3, m6677b());
        zzbfp.m7751a(parcel, 4, m6678c());
        zzbfp.m7734a(parcel, iM7733a);
    }
}
