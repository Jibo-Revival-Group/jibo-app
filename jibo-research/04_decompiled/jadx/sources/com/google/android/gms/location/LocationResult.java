package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LocationResult extends zzbfm implements ReflectedParcelable {

    /* JADX INFO: renamed from: b */
    private final List<Location> f8064b;

    /* JADX INFO: renamed from: a */
    static final List<Location> f8063a = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new zzx();

    LocationResult(List<Location> list) {
        this.f8064b = list;
    }

    /* JADX INFO: renamed from: a */
    public final List<Location> m8744a() {
        return this.f8064b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f8064b.size() != this.f8064b.size()) {
            return false;
        }
        Iterator<Location> it = locationResult.f8064b.iterator();
        Iterator<Location> it2 = this.f8064b.iterator();
        while (it.hasNext()) {
            if (it2.next().getTime() != it.next().getTime()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 17;
        Iterator<Location> it = this.f8064b.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            long time = it.next().getTime();
            i = ((int) (time ^ (time >>> 32))) + (i2 * 31);
        }
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f8064b);
        return new StringBuilder(String.valueOf(strValueOf).length() + 27).append("LocationResult[locations: ").append(strValueOf).append("]").toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7762c(parcel, 1, m8744a(), false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
