package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzae extends zzbfm {
    public static final Parcelable.Creator<zzae> CREATOR = new zzaf();

    /* JADX INFO: renamed from: a */
    private int f8222a;

    /* JADX INFO: renamed from: b */
    private int f8223b;

    /* JADX INFO: renamed from: c */
    private long f8224c;

    /* JADX INFO: renamed from: d */
    private long f8225d;

    zzae(int i, int i2, long j, long j2) {
        this.f8222a = i;
        this.f8223b = i2;
        this.f8224c = j;
        this.f8225d = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzae zzaeVar = (zzae) obj;
        return this.f8222a == zzaeVar.f8222a && this.f8223b == zzaeVar.f8223b && this.f8224c == zzaeVar.f8224c && this.f8225d == zzaeVar.f8225d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8223b), Integer.valueOf(this.f8222a), Long.valueOf(this.f8225d), Long.valueOf(this.f8224c)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NetworkLocationStatus:");
        sb.append(" Wifi status: ").append(this.f8222a).append(" Cell status: ").append(this.f8223b).append(" elapsed time NS: ").append(this.f8225d).append(" system time ms: ").append(this.f8224c);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f8222a);
        zzbfp.m7738a(parcel, 2, this.f8223b);
        zzbfp.m7739a(parcel, 3, this.f8224c);
        zzbfp.m7739a(parcel, 4, this.f8225d);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
