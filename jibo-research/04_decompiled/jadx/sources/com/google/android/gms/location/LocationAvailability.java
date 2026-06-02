package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class LocationAvailability extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new zzv();

    /* JADX INFO: renamed from: a */
    @Deprecated
    private int f8050a;

    /* JADX INFO: renamed from: b */
    @Deprecated
    private int f8051b;

    /* JADX INFO: renamed from: c */
    private long f8052c;

    /* JADX INFO: renamed from: d */
    private int f8053d;

    /* JADX INFO: renamed from: e */
    private zzae[] f8054e;

    LocationAvailability(int i, int i2, int i3, long j, zzae[] zzaeVarArr) {
        this.f8053d = i;
        this.f8050a = i2;
        this.f8051b = i3;
        this.f8052c = j;
        this.f8054e = zzaeVarArr;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m8739a() {
        return this.f8053d < 1000;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.f8050a == locationAvailability.f8050a && this.f8051b == locationAvailability.f8051b && this.f8052c == locationAvailability.f8052c && this.f8053d == locationAvailability.f8053d && Arrays.equals(this.f8054e, locationAvailability.f8054e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8053d), Integer.valueOf(this.f8050a), Integer.valueOf(this.f8051b), Long.valueOf(this.f8052c), this.f8054e});
    }

    public final String toString() {
        return new StringBuilder(48).append("LocationAvailability[isLocationAvailable: ").append(m8739a()).append("]").toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f8050a);
        zzbfp.m7738a(parcel, 2, this.f8051b);
        zzbfp.m7739a(parcel, 3, this.f8052c);
        zzbfp.m7738a(parcel, 4, this.f8053d);
        zzbfp.m7754a(parcel, 5, (Parcelable[]) this.f8054e, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
