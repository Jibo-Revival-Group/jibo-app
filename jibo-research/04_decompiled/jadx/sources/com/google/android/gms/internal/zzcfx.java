package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzcfx extends zzbfm {
    public static final Parcelable.Creator<zzcfx> CREATOR = new zzcfy();

    /* JADX INFO: renamed from: a */
    private static zzcfx f7042a = new zzcfx("Home");

    /* JADX INFO: renamed from: b */
    private static zzcfx f7043b = new zzcfx("Work");

    /* JADX INFO: renamed from: c */
    private final String f7044c;

    zzcfx(String str) {
        this.f7044c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcfx) {
            return zzbg.m7371a(this.f7044c, ((zzcfx) obj).f7044c);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7044c});
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("alias", this.f7044c).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, this.f7044c, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
