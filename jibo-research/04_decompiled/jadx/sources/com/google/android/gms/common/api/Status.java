package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends zzbfm implements Result, ReflectedParcelable {

    /* JADX INFO: renamed from: h */
    private int f6136h;

    /* JADX INFO: renamed from: i */
    private final int f6137i;

    /* JADX INFO: renamed from: j */
    private final String f6138j;

    /* JADX INFO: renamed from: k */
    private final PendingIntent f6139k;

    /* JADX INFO: renamed from: a */
    public static final Status f6129a = new Status(0);

    /* JADX INFO: renamed from: b */
    public static final Status f6130b = new Status(14);

    /* JADX INFO: renamed from: c */
    public static final Status f6131c = new Status(8);

    /* JADX INFO: renamed from: d */
    public static final Status f6132d = new Status(15);

    /* JADX INFO: renamed from: e */
    public static final Status f6133e = new Status(16);

    /* JADX INFO: renamed from: f */
    public static final Status f6134f = new Status(17);

    /* JADX INFO: renamed from: g */
    private static Status f6135g = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new zzg();

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f6136h = i;
        this.f6137i = i2;
        this.f6138j = str;
        this.f6139k = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    @Override // com.google.android.gms.common.api.Result
    /* JADX INFO: renamed from: a */
    public final Status mo6927a() {
        return this;
    }

    /* JADX INFO: renamed from: b */
    public final String m6934b() {
        return this.f6138j;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m6935c() {
        return this.f6137i <= 0;
    }

    /* JADX INFO: renamed from: d */
    public final int m6936d() {
        return this.f6137i;
    }

    /* JADX INFO: renamed from: e */
    public final String m6937e() {
        return this.f6138j != null ? this.f6138j : CommonStatusCodes.m6870a(this.f6137i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f6136h == status.f6136h && this.f6137i == status.f6137i && zzbg.m7371a(this.f6138j, status.f6138j) && zzbg.m7371a(this.f6139k, status.f6139k);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6136h), Integer.valueOf(this.f6137i), this.f6138j, this.f6139k});
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("statusCode", m6937e()).m7372a("resolution", this.f6139k).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, m6936d());
        zzbfp.m7748a(parcel, 2, m6934b(), false);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f6139k, i, false);
        zzbfp.m7738a(parcel, 1000, this.f6136h);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
