package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzo extends zzbfm {

    /* JADX INFO: renamed from: e */
    private String f8220e;

    /* JADX INFO: renamed from: f */
    private int f8221f;

    /* JADX INFO: renamed from: a */
    private static zzo f8216a = m8811a("test_type", 1);

    /* JADX INFO: renamed from: b */
    private static zzo f8217b = m8811a("labeled_place", 6);

    /* JADX INFO: renamed from: c */
    private static zzo f8218c = m8811a("here_content", 7);

    /* JADX INFO: renamed from: d */
    private static Set<zzo> f8219d = zze.m7500a(f8216a, f8217b, f8218c);
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    zzo(String str, int i) {
        zzbq.m7375a(str);
        this.f8220e = str;
        this.f8221f = i;
    }

    /* JADX INFO: renamed from: a */
    private static zzo m8811a(String str, int i) {
        return new zzo(str, i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzoVar = (zzo) obj;
        return this.f8220e.equals(zzoVar.f8220e) && this.f8221f == zzoVar.f8221f;
    }

    public final int hashCode() {
        return this.f8220e.hashCode();
    }

    public final String toString() {
        return this.f8220e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, this.f8220e, false);
        zzbfp.m7738a(parcel, 2, this.f8221f);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
