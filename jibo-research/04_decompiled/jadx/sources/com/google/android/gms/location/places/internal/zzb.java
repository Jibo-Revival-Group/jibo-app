package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzb extends zzbfm {
    public static final Parcelable.Creator<zzb> CREATOR = new zzaw();

    /* JADX INFO: renamed from: a */
    final int f8203a;

    /* JADX INFO: renamed from: b */
    final int f8204b;

    public zzb(int i, int i2) {
        this.f8203a = i;
        this.f8204b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzb)) {
            return false;
        }
        zzb zzbVar = (zzb) obj;
        return zzbg.m7371a(Integer.valueOf(this.f8203a), Integer.valueOf(zzbVar.f8203a)) && zzbg.m7371a(Integer.valueOf(this.f8204b), Integer.valueOf(zzbVar.f8204b));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8203a), Integer.valueOf(this.f8204b)});
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("offset", Integer.valueOf(this.f8203a)).m7372a("length", Integer.valueOf(this.f8204b)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f8203a);
        zzbfp.m7738a(parcel, 2, this.f8204b);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
