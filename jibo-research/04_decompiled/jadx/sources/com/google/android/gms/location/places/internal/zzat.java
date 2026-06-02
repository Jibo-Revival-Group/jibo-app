package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzat extends zzbfm {

    /* JADX INFO: renamed from: b */
    private String f8197b;

    /* JADX INFO: renamed from: c */
    private String f8198c;

    /* JADX INFO: renamed from: d */
    private String f8199d;

    /* JADX INFO: renamed from: e */
    private String f8200e;

    /* JADX INFO: renamed from: f */
    private int f8201f;

    /* JADX INFO: renamed from: g */
    private int f8202g;

    /* JADX INFO: renamed from: a */
    private static zzat f8196a = new zzat("com.google.android.gms", Locale.getDefault(), null);
    public static final Parcelable.Creator<zzat> CREATOR = new zzau();

    public zzat(String str, String str2, String str3, String str4, int i, int i2) {
        this.f8197b = str;
        this.f8198c = str2;
        this.f8199d = str3;
        this.f8200e = str4;
        this.f8201f = i;
        this.f8202g = i2;
    }

    private zzat(String str, Locale locale, String str2) {
        this(str, locale.toString(), null, null, GoogleApiAvailability.f6071a, 0);
    }

    public zzat(String str, Locale locale, String str2, String str3, int i) {
        this(str, locale.toString(), str2, str3, GoogleApiAvailability.f6071a, i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzat)) {
            return false;
        }
        zzat zzatVar = (zzat) obj;
        return this.f8201f == zzatVar.f8201f && this.f8202g == zzatVar.f8202g && this.f8198c.equals(zzatVar.f8198c) && this.f8197b.equals(zzatVar.f8197b) && zzbg.m7371a(this.f8199d, zzatVar.f8199d) && zzbg.m7371a(this.f8200e, zzatVar.f8200e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8197b, this.f8198c, this.f8199d, this.f8200e, Integer.valueOf(this.f8201f), Integer.valueOf(this.f8202g)});
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        return zzbg.m7370a(this).m7372a("clientPackageName", this.f8197b).m7372a("locale", this.f8198c).m7372a("accountName", this.f8199d).m7372a("gCoreClientName", this.f8200e).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, this.f8197b, false);
        zzbfp.m7748a(parcel, 2, this.f8198c, false);
        zzbfp.m7748a(parcel, 3, this.f8199d, false);
        zzbfp.m7748a(parcel, 4, this.f8200e, false);
        zzbfp.m7738a(parcel, 6, this.f8201f);
        zzbfp.m7738a(parcel, 7, this.f8202g);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
