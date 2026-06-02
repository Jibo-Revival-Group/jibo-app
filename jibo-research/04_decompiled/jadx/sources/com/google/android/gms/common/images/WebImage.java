package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class WebImage extends zzbfm {
    public static final Parcelable.Creator<WebImage> CREATOR = new zze();

    /* JADX INFO: renamed from: a */
    private int f6511a;

    /* JADX INFO: renamed from: b */
    private final Uri f6512b;

    /* JADX INFO: renamed from: c */
    private final int f6513c;

    /* JADX INFO: renamed from: d */
    private final int f6514d;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.f6511a = i;
        this.f6512b = uri;
        this.f6513c = i2;
        this.f6514d = i3;
    }

    /* JADX INFO: renamed from: a */
    public final Uri m7302a() {
        return this.f6512b;
    }

    /* JADX INFO: renamed from: b */
    public final int m7303b() {
        return this.f6513c;
    }

    /* JADX INFO: renamed from: c */
    public final int m7304c() {
        return this.f6514d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzbg.m7371a(this.f6512b, webImage.f6512b) && this.f6513c == webImage.f6513c && this.f6514d == webImage.f6514d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6512b, Integer.valueOf(this.f6513c), Integer.valueOf(this.f6514d)});
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.f6513c), Integer.valueOf(this.f6514d), this.f6512b.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6511a);
        zzbfp.m7743a(parcel, 2, (Parcelable) m7302a(), i, false);
        zzbfp.m7738a(parcel, 3, m7303b());
        zzbfp.m7738a(parcel, 4, m7304c());
        zzbfp.m7734a(parcel, iM7733a);
    }
}
