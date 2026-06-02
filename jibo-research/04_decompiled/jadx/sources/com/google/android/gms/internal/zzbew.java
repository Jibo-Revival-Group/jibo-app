package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzbew extends zzbfm {
    public static final Parcelable.Creator<zzbew> CREATOR = new zzbex();

    /* JADX INFO: renamed from: a */
    public final int f6915a;

    /* JADX INFO: renamed from: b */
    public final String f6916b;

    /* JADX INFO: renamed from: c */
    private String f6917c;

    /* JADX INFO: renamed from: d */
    private int f6918d;

    /* JADX INFO: renamed from: e */
    private String f6919e;

    /* JADX INFO: renamed from: f */
    private String f6920f;

    /* JADX INFO: renamed from: g */
    private boolean f6921g;

    /* JADX INFO: renamed from: h */
    private boolean f6922h;

    /* JADX INFO: renamed from: i */
    private int f6923i;

    public zzbew(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        this.f6917c = (String) zzbq.m7373a(str);
        this.f6918d = i;
        this.f6915a = i2;
        this.f6916b = str2;
        this.f6919e = str3;
        this.f6920f = str4;
        this.f6921g = !z;
        this.f6922h = z;
        this.f6923i = i3;
    }

    public zzbew(String str, int i, int i2, String str2, String str3, boolean z, String str4, boolean z2, int i3) {
        this.f6917c = str;
        this.f6918d = i;
        this.f6915a = i2;
        this.f6919e = str2;
        this.f6920f = str3;
        this.f6921g = z;
        this.f6916b = str4;
        this.f6922h = z2;
        this.f6923i = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbew)) {
            return false;
        }
        zzbew zzbewVar = (zzbew) obj;
        return zzbg.m7371a(this.f6917c, zzbewVar.f6917c) && this.f6918d == zzbewVar.f6918d && this.f6915a == zzbewVar.f6915a && zzbg.m7371a(this.f6916b, zzbewVar.f6916b) && zzbg.m7371a(this.f6919e, zzbewVar.f6919e) && zzbg.m7371a(this.f6920f, zzbewVar.f6920f) && this.f6921g == zzbewVar.f6921g && this.f6922h == zzbewVar.f6922h && this.f6923i == zzbewVar.f6923i;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6917c, Integer.valueOf(this.f6918d), Integer.valueOf(this.f6915a), this.f6916b, this.f6919e, this.f6920f, Boolean.valueOf(this.f6921g), Boolean.valueOf(this.f6922h), Integer.valueOf(this.f6923i)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayLoggerContext[");
        sb.append("package=").append(this.f6917c).append(',');
        sb.append("packageVersionCode=").append(this.f6918d).append(',');
        sb.append("logSource=").append(this.f6915a).append(',');
        sb.append("logSourceName=").append(this.f6916b).append(',');
        sb.append("uploadAccount=").append(this.f6919e).append(',');
        sb.append("loggingId=").append(this.f6920f).append(',');
        sb.append("logAndroidId=").append(this.f6921g).append(',');
        sb.append("isAnonymous=").append(this.f6922h).append(',');
        sb.append("qosTier=").append(this.f6923i);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 2, this.f6917c, false);
        zzbfp.m7738a(parcel, 3, this.f6918d);
        zzbfp.m7738a(parcel, 4, this.f6915a);
        zzbfp.m7748a(parcel, 5, this.f6919e, false);
        zzbfp.m7748a(parcel, 6, this.f6920f, false);
        zzbfp.m7751a(parcel, 7, this.f6921g);
        zzbfp.m7748a(parcel, 8, this.f6916b, false);
        zzbfp.m7751a(parcel, 9, this.f6922h);
        zzbfp.m7738a(parcel, 10, this.f6923i);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
