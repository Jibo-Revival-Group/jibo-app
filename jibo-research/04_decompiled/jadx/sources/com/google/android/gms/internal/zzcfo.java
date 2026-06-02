package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfo extends zzbfm {

    /* JADX INFO: renamed from: b */
    private LocationRequest f7019b;

    /* JADX INFO: renamed from: c */
    private List<zzcdv> f7020c;

    /* JADX INFO: renamed from: d */
    private String f7021d;

    /* JADX INFO: renamed from: e */
    private boolean f7022e;

    /* JADX INFO: renamed from: f */
    private boolean f7023f;

    /* JADX INFO: renamed from: g */
    private boolean f7024g;

    /* JADX INFO: renamed from: h */
    private String f7025h;

    /* JADX INFO: renamed from: i */
    private boolean f7026i = true;

    /* JADX INFO: renamed from: a */
    static final List<zzcdv> f7018a = Collections.emptyList();
    public static final Parcelable.Creator<zzcfo> CREATOR = new zzcfp();

    zzcfo(LocationRequest locationRequest, List<zzcdv> list, String str, boolean z, boolean z2, boolean z3, String str2) {
        this.f7019b = locationRequest;
        this.f7020c = list;
        this.f7021d = str;
        this.f7022e = z;
        this.f7023f = z2;
        this.f7024g = z3;
        this.f7025h = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzcfo)) {
            return false;
        }
        zzcfo zzcfoVar = (zzcfo) obj;
        return zzbg.m7371a(this.f7019b, zzcfoVar.f7019b) && zzbg.m7371a(this.f7020c, zzcfoVar.f7020c) && zzbg.m7371a(this.f7021d, zzcfoVar.f7021d) && this.f7022e == zzcfoVar.f7022e && this.f7023f == zzcfoVar.f7023f && this.f7024g == zzcfoVar.f7024g && zzbg.m7371a(this.f7025h, zzcfoVar.f7025h);
    }

    public final int hashCode() {
        return this.f7019b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7019b.toString());
        if (this.f7021d != null) {
            sb.append(" tag=").append(this.f7021d);
        }
        if (this.f7025h != null) {
            sb.append(" moduleId=").append(this.f7025h);
        }
        sb.append(" hideAppOps=").append(this.f7022e);
        sb.append(" clients=").append(this.f7020c);
        sb.append(" forceCoarseLocation=").append(this.f7023f);
        if (this.f7024g) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 1, (Parcelable) this.f7019b, i, false);
        zzbfp.m7762c(parcel, 5, this.f7020c, false);
        zzbfp.m7748a(parcel, 6, this.f7021d, false);
        zzbfp.m7751a(parcel, 7, this.f7022e);
        zzbfp.m7751a(parcel, 8, this.f7023f);
        zzbfp.m7751a(parcel, 9, this.f7024g);
        zzbfp.m7748a(parcel, 10, this.f7025h, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
