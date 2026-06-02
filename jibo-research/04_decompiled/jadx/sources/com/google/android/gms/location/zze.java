package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zze extends zzbfm {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();

    /* JADX INFO: renamed from: a */
    private boolean f8229a;

    /* JADX INFO: renamed from: b */
    private long f8230b;

    /* JADX INFO: renamed from: c */
    private float f8231c;

    /* JADX INFO: renamed from: d */
    private long f8232d;

    /* JADX INFO: renamed from: e */
    private int f8233e;

    public zze() {
        this(true, 50L, CropImageView.DEFAULT_ASPECT_RATIO, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    zze(boolean z, long j, float f, long j2, int i) {
        this.f8229a = z;
        this.f8230b = j;
        this.f8231c = f;
        this.f8232d = j2;
        this.f8233e = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zzeVar = (zze) obj;
        return this.f8229a == zzeVar.f8229a && this.f8230b == zzeVar.f8230b && Float.compare(this.f8231c, zzeVar.f8231c) == 0 && this.f8232d == zzeVar.f8232d && this.f8233e == zzeVar.f8233e;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f8229a), Long.valueOf(this.f8230b), Float.valueOf(this.f8231c), Long.valueOf(this.f8232d), Integer.valueOf(this.f8233e)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceOrientationRequest[mShouldUseMag=").append(this.f8229a);
        sb.append(" mMinimumSamplingPeriodMs=").append(this.f8230b);
        sb.append(" mSmallestAngleChangeRadians=").append(this.f8231c);
        if (this.f8232d != Long.MAX_VALUE) {
            long jElapsedRealtime = this.f8232d - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(jElapsedRealtime).append("ms");
        }
        if (this.f8233e != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.f8233e);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7751a(parcel, 1, this.f8229a);
        zzbfp.m7739a(parcel, 2, this.f8230b);
        zzbfp.m7737a(parcel, 3, this.f8231c);
        zzbfp.m7739a(parcel, 4, this.f8232d);
        zzbfp.m7738a(parcel, 5, this.f8233e);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
