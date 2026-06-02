package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class LocationRequest extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzw();

    /* JADX INFO: renamed from: a */
    private int f8055a;

    /* JADX INFO: renamed from: b */
    private long f8056b;

    /* JADX INFO: renamed from: c */
    private long f8057c;

    /* JADX INFO: renamed from: d */
    private boolean f8058d;

    /* JADX INFO: renamed from: e */
    private long f8059e;

    /* JADX INFO: renamed from: f */
    private int f8060f;

    /* JADX INFO: renamed from: g */
    private float f8061g;

    /* JADX INFO: renamed from: h */
    private long f8062h;

    public LocationRequest() {
        this.f8055a = 102;
        this.f8056b = 3600000L;
        this.f8057c = 600000L;
        this.f8058d = false;
        this.f8059e = Long.MAX_VALUE;
        this.f8060f = Integer.MAX_VALUE;
        this.f8061g = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8062h = 0L;
    }

    LocationRequest(int i, long j, long j2, boolean z, long j3, int i2, float f, long j4) {
        this.f8055a = i;
        this.f8056b = j;
        this.f8057c = j2;
        this.f8058d = z;
        this.f8059e = j3;
        this.f8060f = i2;
        this.f8061g = f;
        this.f8062h = j4;
    }

    /* JADX INFO: renamed from: a */
    public final long m8743a() {
        long j = this.f8062h;
        return j < this.f8056b ? this.f8056b : j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.f8055a == locationRequest.f8055a && this.f8056b == locationRequest.f8056b && this.f8057c == locationRequest.f8057c && this.f8058d == locationRequest.f8058d && this.f8059e == locationRequest.f8059e && this.f8060f == locationRequest.f8060f && this.f8061g == locationRequest.f8061g && m8743a() == locationRequest.m8743a();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8055a), Long.valueOf(this.f8056b), Float.valueOf(this.f8061g), Long.valueOf(this.f8062h)});
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAppend = sb.append("Request[");
        switch (this.f8055a) {
            case 100:
                str = "PRIORITY_HIGH_ACCURACY";
                break;
            case 101:
            case 103:
            default:
                str = "???";
                break;
            case 102:
                str = "PRIORITY_BALANCED_POWER_ACCURACY";
                break;
            case 104:
                str = "PRIORITY_LOW_POWER";
                break;
            case 105:
                str = "PRIORITY_NO_POWER";
                break;
        }
        sbAppend.append(str);
        if (this.f8055a != 105) {
            sb.append(" requested=");
            sb.append(this.f8056b).append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.f8057c).append("ms");
        if (this.f8062h > this.f8056b) {
            sb.append(" maxWait=");
            sb.append(this.f8062h).append("ms");
        }
        if (this.f8061g > CropImageView.DEFAULT_ASPECT_RATIO) {
            sb.append(" smallestDisplacement=");
            sb.append(this.f8061g).append("m");
        }
        if (this.f8059e != Long.MAX_VALUE) {
            long jElapsedRealtime = this.f8059e - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(jElapsedRealtime).append("ms");
        }
        if (this.f8060f != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.f8060f);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f8055a);
        zzbfp.m7739a(parcel, 2, this.f8056b);
        zzbfp.m7739a(parcel, 3, this.f8057c);
        zzbfp.m7751a(parcel, 4, this.f8058d);
        zzbfp.m7739a(parcel, 5, this.f8059e);
        zzbfp.m7738a(parcel, 6, this.f8060f);
        zzbfp.m7737a(parcel, 7, this.f8061g);
        zzbfp.m7739a(parcel, 8, this.f8062h);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
