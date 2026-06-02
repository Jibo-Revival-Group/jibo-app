package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzbef extends zzbfm {
    public static final Parcelable.Creator<zzbef> CREATOR = new zzbeg();

    /* JADX INFO: renamed from: a */
    private boolean f6890a;

    /* JADX INFO: renamed from: b */
    private long f6891b;

    /* JADX INFO: renamed from: c */
    private long f6892c;

    public zzbef(boolean z, long j, long j2) {
        this.f6890a = z;
        this.f6891b = j;
        this.f6892c = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbef)) {
            return false;
        }
        zzbef zzbefVar = (zzbef) obj;
        return this.f6890a == zzbefVar.f6890a && this.f6891b == zzbefVar.f6891b && this.f6892c == zzbefVar.f6892c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f6890a), Long.valueOf(this.f6891b), Long.valueOf(this.f6892c)});
    }

    public final String toString() {
        return "CollectForDebugParcelable[skipPersistentStorage: " + this.f6890a + ",collectForDebugStartTimeMillis: " + this.f6891b + ",collectForDebugExpiryTimeMillis: " + this.f6892c + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7751a(parcel, 1, this.f6890a);
        zzbfp.m7739a(parcel, 2, this.f6892c);
        zzbfp.m7739a(parcel, 3, this.f6891b);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
