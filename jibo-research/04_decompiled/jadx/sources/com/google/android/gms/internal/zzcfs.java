package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfs extends zzbfm {
    public static final Parcelable.Creator<zzcfs> CREATOR = new zzcft();

    /* JADX INFO: renamed from: a */
    private final String f7033a;

    /* JADX INFO: renamed from: b */
    private final long f7034b;

    /* JADX INFO: renamed from: c */
    private final short f7035c;

    /* JADX INFO: renamed from: d */
    private final double f7036d;

    /* JADX INFO: renamed from: e */
    private final double f7037e;

    /* JADX INFO: renamed from: f */
    private final float f7038f;

    /* JADX INFO: renamed from: g */
    private final int f7039g;

    /* JADX INFO: renamed from: h */
    private final int f7040h;

    /* JADX INFO: renamed from: i */
    private final int f7041i;

    public zzcfs(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        if (str == null || str.length() > 100) {
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "requestId is null or too long: ".concat(strValueOf) : new String("requestId is null or too long: "));
        }
        if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new IllegalArgumentException(new StringBuilder(31).append("invalid radius: ").append(f).toString());
        }
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException(new StringBuilder(42).append("invalid latitude: ").append(d).toString());
        }
        if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException(new StringBuilder(43).append("invalid longitude: ").append(d2).toString());
        }
        int i4 = i & 7;
        if (i4 == 0) {
            throw new IllegalArgumentException(new StringBuilder(46).append("No supported transition specified: ").append(i).toString());
        }
        this.f7035c = s;
        this.f7033a = str;
        this.f7036d = d;
        this.f7037e = d2;
        this.f7038f = f;
        this.f7034b = j;
        this.f7039g = i4;
        this.f7040h = i2;
        this.f7041i = i3;
    }

    /* JADX INFO: renamed from: a */
    public final String m7841a() {
        return this.f7033a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzcfs)) {
            zzcfs zzcfsVar = (zzcfs) obj;
            return this.f7038f == zzcfsVar.f7038f && this.f7036d == zzcfsVar.f7036d && this.f7037e == zzcfsVar.f7037e && this.f7035c == zzcfsVar.f7035c;
        }
        return false;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f7036d);
        int i = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f7037e);
        return (((((((i * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f7038f)) * 31) + this.f7035c) * 31) + this.f7039g;
    }

    public final String toString() {
        String str;
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        switch (this.f7035c) {
            case 1:
                str = "CIRCLE";
                break;
            default:
                str = null;
                break;
        }
        objArr[0] = str;
        objArr[1] = this.f7033a.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.f7039g);
        objArr[3] = Double.valueOf(this.f7036d);
        objArr[4] = Double.valueOf(this.f7037e);
        objArr[5] = Float.valueOf(this.f7038f);
        objArr[6] = Integer.valueOf(this.f7040h / 1000);
        objArr[7] = Integer.valueOf(this.f7041i);
        objArr[8] = Long.valueOf(this.f7034b);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, m7841a(), false);
        zzbfp.m7739a(parcel, 2, this.f7034b);
        zzbfp.m7750a(parcel, 3, this.f7035c);
        zzbfp.m7736a(parcel, 4, this.f7036d);
        zzbfp.m7736a(parcel, 5, this.f7037e);
        zzbfp.m7737a(parcel, 6, this.f7038f);
        zzbfp.m7738a(parcel, 7, this.f7039g);
        zzbfp.m7738a(parcel, 8, this.f7040h);
        zzbfp.m7738a(parcel, 9, this.f7041i);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
