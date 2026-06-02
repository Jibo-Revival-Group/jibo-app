package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbi;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PlaceFilter extends zza {
    public static final Parcelable.Creator<PlaceFilter> CREATOR = new zzh();

    /* JADX INFO: renamed from: a */
    private static final PlaceFilter f8099a = new PlaceFilter();

    /* JADX INFO: renamed from: b */
    private List<Integer> f8100b;

    /* JADX INFO: renamed from: c */
    private boolean f8101c;

    /* JADX INFO: renamed from: d */
    private List<zzo> f8102d;

    /* JADX INFO: renamed from: e */
    private List<String> f8103e;

    /* JADX INFO: renamed from: f */
    private final Set<Integer> f8104f;

    /* JADX INFO: renamed from: g */
    private final Set<zzo> f8105g;

    /* JADX INFO: renamed from: h */
    private final Set<String> f8106h;

    public PlaceFilter() {
        this(false, null);
    }

    private PlaceFilter(Collection<Integer> collection, boolean z, Collection<String> collection2, Collection<zzo> collection3) {
        this((List<Integer>) m8809a((Collection) null), z, (List<String>) m8809a(collection2), (List<zzo>) m8809a((Collection) null));
    }

    PlaceFilter(List<Integer> list, boolean z, List<String> list2, List<zzo> list3) {
        this.f8100b = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f8101c = z;
        this.f8102d = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.f8103e = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f8104f = m8810a((List) this.f8100b);
        this.f8105g = m8810a((List) this.f8102d);
        this.f8106h = m8810a((List) this.f8103e);
    }

    public PlaceFilter(boolean z, Collection<String> collection) {
        this((Collection<Integer>) null, z, collection, (Collection<zzo>) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        return this.f8104f.equals(placeFilter.f8104f) && this.f8101c == placeFilter.f8101c && this.f8105g.equals(placeFilter.f8105g) && this.f8106h.equals(placeFilter.f8106h);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8104f, Boolean.valueOf(this.f8101c), this.f8105g, this.f8106h});
    }

    public final String toString() {
        zzbi zzbiVarM7370a = zzbg.m7370a(this);
        if (!this.f8104f.isEmpty()) {
            zzbiVarM7370a.m7372a("types", this.f8104f);
        }
        zzbiVarM7370a.m7372a("requireOpenNow", Boolean.valueOf(this.f8101c));
        if (!this.f8106h.isEmpty()) {
            zzbiVarM7370a.m7372a("placeIds", this.f8106h);
        }
        if (!this.f8105g.isEmpty()) {
            zzbiVarM7370a.m7372a("requestedUserDataTypes", this.f8105g);
        }
        return zzbiVarM7370a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7749a(parcel, 1, this.f8100b, false);
        zzbfp.m7751a(parcel, 3, this.f8101c);
        zzbfp.m7762c(parcel, 4, this.f8102d, false);
        zzbfp.m7760b(parcel, 6, this.f8103e, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
