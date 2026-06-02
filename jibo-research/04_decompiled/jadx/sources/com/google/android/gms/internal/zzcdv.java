package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;

/* JADX INFO: loaded from: classes.dex */
public final class zzcdv extends zzbfm {
    public static final Parcelable.Creator<zzcdv> CREATOR = new zzcdw();

    /* JADX INFO: renamed from: a */
    private int f6992a;

    /* JADX INFO: renamed from: b */
    private String f6993b;

    public zzcdv(int i, String str) {
        this.f6992a = i;
        this.f6993b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof zzcdv)) {
            return false;
        }
        zzcdv zzcdvVar = (zzcdv) obj;
        return zzcdvVar.f6992a == this.f6992a && zzbg.m7371a(zzcdvVar.f6993b, this.f6993b);
    }

    public final int hashCode() {
        return this.f6992a;
    }

    public final String toString() {
        return String.format("%d:%s", Integer.valueOf(this.f6992a), this.f6993b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6992a);
        zzbfp.m7748a(parcel, 2, this.f6993b, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
