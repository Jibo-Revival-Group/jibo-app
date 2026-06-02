package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzak extends zzbfm {
    public static final Parcelable.Creator<zzak> CREATOR = new zzal();

    /* JADX INFO: renamed from: a */
    private String f8177a;

    /* JADX INFO: renamed from: b */
    private String f8178b;

    /* JADX INFO: renamed from: c */
    private String f8179c;

    /* JADX INFO: renamed from: d */
    private String f8180d;

    /* JADX INFO: renamed from: e */
    private List<String> f8181e;

    public zzak(String str, String str2, String str3, String str4, List<String> list) {
        this.f8177a = str;
        this.f8178b = str2;
        this.f8179c = str3;
        this.f8180d = str4;
        this.f8181e = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzak)) {
            return false;
        }
        zzak zzakVar = (zzak) obj;
        return zzbg.m7371a(this.f8177a, zzakVar.f8177a) && zzbg.m7371a(this.f8178b, zzakVar.f8178b) && zzbg.m7371a(this.f8179c, zzakVar.f8179c) && zzbg.m7371a(this.f8180d, zzakVar.f8180d) && zzbg.m7371a(this.f8181e, zzakVar.f8181e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8177a, this.f8178b, this.f8179c, this.f8180d});
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("name", this.f8177a).m7372a("address", this.f8178b).m7372a("internationalPhoneNumber", this.f8179c).m7372a("regularOpenHours", this.f8180d).m7372a("attributions", this.f8181e).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, this.f8177a, false);
        zzbfp.m7748a(parcel, 2, this.f8178b, false);
        zzbfp.m7748a(parcel, 3, this.f8179c, false);
        zzbfp.m7748a(parcel, 4, this.f8180d, false);
        zzbfp.m7760b(parcel, 5, this.f8181e, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
