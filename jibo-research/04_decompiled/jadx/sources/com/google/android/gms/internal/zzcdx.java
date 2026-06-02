package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.location.zze;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzcdx extends zzbfm {

    /* JADX INFO: renamed from: c */
    private zze f6996c;

    /* JADX INFO: renamed from: d */
    private List<zzcdv> f6997d;

    /* JADX INFO: renamed from: e */
    private String f6998e;

    /* JADX INFO: renamed from: a */
    static final List<zzcdv> f6994a = Collections.emptyList();

    /* JADX INFO: renamed from: b */
    static final zze f6995b = new zze();
    public static final Parcelable.Creator<zzcdx> CREATOR = new zzcdy();

    zzcdx(zze zzeVar, List<zzcdv> list, String str) {
        this.f6996c = zzeVar;
        this.f6997d = list;
        this.f6998e = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzcdx)) {
            return false;
        }
        zzcdx zzcdxVar = (zzcdx) obj;
        return zzbg.m7371a(this.f6996c, zzcdxVar.f6996c) && zzbg.m7371a(this.f6997d, zzcdxVar.f6997d) && zzbg.m7371a(this.f6998e, zzcdxVar.f6998e);
    }

    public final int hashCode() {
        return this.f6996c.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 1, (Parcelable) this.f6996c, i, false);
        zzbfp.m7762c(parcel, 2, this.f6997d, false);
        zzbfp.m7748a(parcel, 3, this.f6998e, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
