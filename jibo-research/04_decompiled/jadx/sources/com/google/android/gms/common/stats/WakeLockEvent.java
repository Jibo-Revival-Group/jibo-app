package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbfp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzd();

    /* JADX INFO: renamed from: a */
    private int f6668a;

    /* JADX INFO: renamed from: b */
    private final long f6669b;

    /* JADX INFO: renamed from: c */
    private int f6670c;

    /* JADX INFO: renamed from: d */
    private final String f6671d;

    /* JADX INFO: renamed from: e */
    private final String f6672e;

    /* JADX INFO: renamed from: f */
    private final String f6673f;

    /* JADX INFO: renamed from: g */
    private final int f6674g;

    /* JADX INFO: renamed from: h */
    private final List<String> f6675h;

    /* JADX INFO: renamed from: i */
    private final String f6676i;

    /* JADX INFO: renamed from: j */
    private final long f6677j;

    /* JADX INFO: renamed from: k */
    private int f6678k;

    /* JADX INFO: renamed from: l */
    private final String f6679l;

    /* JADX INFO: renamed from: m */
    private final float f6680m;

    /* JADX INFO: renamed from: n */
    private final long f6681n;

    /* JADX INFO: renamed from: o */
    private long f6682o = -1;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.f6668a = i;
        this.f6669b = j;
        this.f6670c = i2;
        this.f6671d = str;
        this.f6672e = str3;
        this.f6673f = str5;
        this.f6674g = i3;
        this.f6675h = list;
        this.f6676i = str2;
        this.f6677j = j2;
        this.f6678k = i4;
        this.f6679l = str4;
        this.f6680m = f;
        this.f6681n = j3;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    /* JADX INFO: renamed from: a */
    public final long mo7479a() {
        return this.f6669b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    /* JADX INFO: renamed from: b */
    public final int mo7480b() {
        return this.f6670c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    /* JADX INFO: renamed from: c */
    public final long mo7481c() {
        return this.f6682o;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    /* JADX INFO: renamed from: d */
    public final String mo7482d() {
        String str = this.f6671d;
        int i = this.f6674g;
        String strJoin = this.f6675h == null ? "" : TextUtils.join(",", this.f6675h);
        int i2 = this.f6678k;
        String str2 = this.f6672e == null ? "" : this.f6672e;
        String str3 = this.f6679l == null ? "" : this.f6679l;
        float f = this.f6680m;
        String str4 = this.f6673f == null ? "" : this.f6673f;
        return new StringBuilder(String.valueOf("\t").length() + 37 + String.valueOf(str).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(strJoin).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(str2).length() + String.valueOf("\t").length() + String.valueOf(str3).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(str4).length()).append("\t").append(str).append("\t").append(i).append("\t").append(strJoin).append("\t").append(i2).append("\t").append(str2).append("\t").append(str3).append("\t").append(f).append("\t").append(str4).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6668a);
        zzbfp.m7739a(parcel, 2, mo7479a());
        zzbfp.m7748a(parcel, 4, this.f6671d, false);
        zzbfp.m7738a(parcel, 5, this.f6674g);
        zzbfp.m7760b(parcel, 6, this.f6675h, false);
        zzbfp.m7739a(parcel, 8, this.f6677j);
        zzbfp.m7748a(parcel, 10, this.f6672e, false);
        zzbfp.m7738a(parcel, 11, mo7480b());
        zzbfp.m7748a(parcel, 12, this.f6676i, false);
        zzbfp.m7748a(parcel, 13, this.f6679l, false);
        zzbfp.m7738a(parcel, 14, this.f6678k);
        zzbfp.m7737a(parcel, 15, this.f6680m);
        zzbfp.m7739a(parcel, 16, this.f6681n);
        zzbfp.m7748a(parcel, 17, this.f6673f, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
