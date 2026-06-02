package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbi;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class PlaceReport extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zzl();

    /* JADX INFO: renamed from: a */
    private int f8118a;

    /* JADX INFO: renamed from: b */
    private final String f8119b;

    /* JADX INFO: renamed from: c */
    private final String f8120c;

    /* JADX INFO: renamed from: d */
    private final String f8121d;

    PlaceReport(int i, String str, String str2, String str3) {
        this.f8118a = i;
        this.f8119b = str;
        this.f8120c = str2;
        this.f8121d = str3;
    }

    /* JADX INFO: renamed from: a */
    public String m8770a() {
        return this.f8119b;
    }

    /* JADX INFO: renamed from: b */
    public String m8771b() {
        return this.f8120c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzbg.m7371a(this.f8119b, placeReport.f8119b) && zzbg.m7371a(this.f8120c, placeReport.f8120c) && zzbg.m7371a(this.f8121d, placeReport.f8121d);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8119b, this.f8120c, this.f8121d});
    }

    public String toString() {
        zzbi zzbiVarM7370a = zzbg.m7370a(this);
        zzbiVarM7370a.m7372a("placeId", this.f8119b);
        zzbiVarM7370a.m7372a("tag", this.f8120c);
        if (!"unknown".equals(this.f8121d)) {
            zzbiVarM7370a.m7372a(ShareConstants.FEED_SOURCE_PARAM, this.f8121d);
        }
        return zzbiVarM7370a.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f8118a);
        zzbfp.m7748a(parcel, 2, m8770a(), false);
        zzbfp.m7748a(parcel, 3, m8771b(), false);
        zzbfp.m7748a(parcel, 4, this.f8121d, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
