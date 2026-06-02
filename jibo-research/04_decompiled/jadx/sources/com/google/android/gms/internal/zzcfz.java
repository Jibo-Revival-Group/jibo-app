package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzcfz extends zzbfm {
    public static final Parcelable.Creator<zzcfz> CREATOR = new zzcgb();

    /* JADX INFO: renamed from: a */
    private final String f7045a;

    /* JADX INFO: renamed from: b */
    private final String f7046b;

    /* JADX INFO: renamed from: c */
    private final List<zzcfx> f7047c;

    zzcfz(String str, String str2, List<zzcfx> list) {
        this.f7045a = str;
        this.f7046b = str2;
        this.f7047c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcfz)) {
            return false;
        }
        zzcfz zzcfzVar = (zzcfz) obj;
        return this.f7045a.equals(zzcfzVar.f7045a) && this.f7046b.equals(zzcfzVar.f7046b) && this.f7047c.equals(zzcfzVar.f7047c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7045a, this.f7046b, this.f7047c});
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("accountName", this.f7045a).m7372a("placeId", this.f7046b).m7372a("placeAliases", this.f7047c).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, this.f7045a, false);
        zzbfp.m7748a(parcel, 2, this.f7046b, false);
        zzbfp.m7762c(parcel, 6, this.f7047c, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
