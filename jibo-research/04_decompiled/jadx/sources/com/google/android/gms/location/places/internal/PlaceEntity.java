package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class PlaceEntity extends zzbfm implements ReflectedParcelable, Place {
    public static final Parcelable.Creator<PlaceEntity> CREATOR = new zzae();

    /* JADX INFO: renamed from: a */
    private final String f8134a;

    /* JADX INFO: renamed from: b */
    private final Bundle f8135b;

    /* JADX INFO: renamed from: c */
    @Deprecated
    private final zzak f8136c;

    /* JADX INFO: renamed from: d */
    private final LatLng f8137d;

    /* JADX INFO: renamed from: e */
    private final float f8138e;

    /* JADX INFO: renamed from: f */
    private final LatLngBounds f8139f;

    /* JADX INFO: renamed from: g */
    private final String f8140g;

    /* JADX INFO: renamed from: h */
    private final Uri f8141h;

    /* JADX INFO: renamed from: i */
    private final boolean f8142i;

    /* JADX INFO: renamed from: j */
    private final float f8143j;

    /* JADX INFO: renamed from: k */
    private final int f8144k;

    /* JADX INFO: renamed from: l */
    private final List<Integer> f8145l;

    /* JADX INFO: renamed from: m */
    private final List<Integer> f8146m;

    /* JADX INFO: renamed from: n */
    private final String f8147n;

    /* JADX INFO: renamed from: o */
    private final String f8148o;

    /* JADX INFO: renamed from: p */
    private final String f8149p;

    /* JADX INFO: renamed from: q */
    private final String f8150q;

    /* JADX INFO: renamed from: r */
    private final List<String> f8151r;

    /* JADX INFO: renamed from: s */
    private final zzam f8152s;

    /* JADX INFO: renamed from: t */
    private final zzaf f8153t;

    /* JADX INFO: renamed from: u */
    private final String f8154u;

    /* JADX INFO: renamed from: v */
    private final Map<Integer, String> f8155v;

    /* JADX INFO: renamed from: w */
    private final TimeZone f8156w;

    /* JADX INFO: renamed from: x */
    private Locale f8157x;

    PlaceEntity(String str, List<Integer> list, List<Integer> list2, Bundle bundle, String str2, String str3, String str4, String str5, List<String> list3, LatLng latLng, float f, LatLngBounds latLngBounds, String str6, Uri uri, boolean z, float f2, int i, zzak zzakVar, zzam zzamVar, zzaf zzafVar, String str7) {
        this.f8134a = str;
        this.f8146m = Collections.unmodifiableList(list);
        this.f8145l = list2;
        this.f8135b = bundle == null ? new Bundle() : bundle;
        this.f8147n = str2;
        this.f8148o = str3;
        this.f8149p = str4;
        this.f8150q = str5;
        this.f8151r = list3 == null ? Collections.emptyList() : list3;
        this.f8137d = latLng;
        this.f8138e = f;
        this.f8139f = latLngBounds;
        this.f8140g = str6 == null ? "UTC" : str6;
        this.f8141h = uri;
        this.f8142i = z;
        this.f8143j = f2;
        this.f8144k = i;
        this.f8155v = Collections.unmodifiableMap(new HashMap());
        this.f8156w = null;
        this.f8157x = null;
        this.f8136c = zzakVar;
        this.f8152s = zzamVar;
        this.f8153t = zzafVar;
        this.f8154u = str7;
    }

    @Override // com.google.android.gms.location.places.Place
    /* JADX INFO: renamed from: a */
    public final LatLng mo8765a() {
        return this.f8137d;
    }

    /* JADX INFO: renamed from: b */
    public final String m8775b() {
        return this.f8134a;
    }

    /* JADX INFO: renamed from: c */
    public final List<Integer> m8776c() {
        return this.f8146m;
    }

    /* JADX INFO: renamed from: d */
    public final LatLngBounds m8777d() {
        return this.f8139f;
    }

    /* JADX INFO: renamed from: e */
    public final Uri m8778e() {
        return this.f8141h;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceEntity)) {
            return false;
        }
        PlaceEntity placeEntity = (PlaceEntity) obj;
        return this.f8134a.equals(placeEntity.f8134a) && zzbg.m7371a(this.f8157x, placeEntity.f8157x);
    }

    /* JADX INFO: renamed from: f */
    public final float m8779f() {
        return this.f8143j;
    }

    /* JADX INFO: renamed from: g */
    public final int m8780g() {
        return this.f8144k;
    }

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ CharSequence m8781h() {
        return this.f8149p;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8134a, this.f8157x});
    }

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ CharSequence m8782i() {
        return this.f8147n;
    }

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CharSequence m8783j() {
        return this.f8148o;
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        return zzbg.m7370a(this).m7372a(ShareConstants.WEB_DIALOG_PARAM_ID, this.f8134a).m7372a("placeTypes", this.f8146m).m7372a("locale", this.f8157x).m7372a("name", this.f8147n).m7372a("address", this.f8148o).m7372a("phoneNumber", this.f8149p).m7372a("latlng", this.f8137d).m7372a("viewport", this.f8139f).m7372a("websiteUri", this.f8141h).m7372a("isPermanentlyClosed", Boolean.valueOf(this.f8142i)).m7372a("priceLevel", Integer.valueOf(this.f8144k)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, m8775b(), false);
        zzbfp.m7740a(parcel, 2, this.f8135b, false);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f8136c, i, false);
        zzbfp.m7743a(parcel, 4, (Parcelable) mo8765a(), i, false);
        zzbfp.m7737a(parcel, 5, this.f8138e);
        zzbfp.m7743a(parcel, 6, (Parcelable) m8777d(), i, false);
        zzbfp.m7748a(parcel, 7, this.f8140g, false);
        zzbfp.m7743a(parcel, 8, (Parcelable) m8778e(), i, false);
        zzbfp.m7751a(parcel, 9, this.f8142i);
        zzbfp.m7737a(parcel, 10, m8779f());
        zzbfp.m7738a(parcel, 11, m8780g());
        zzbfp.m7749a(parcel, 13, this.f8145l, false);
        zzbfp.m7748a(parcel, 14, (String) m8783j(), false);
        zzbfp.m7748a(parcel, 15, (String) m8781h(), false);
        zzbfp.m7748a(parcel, 16, this.f8150q, false);
        zzbfp.m7760b(parcel, 17, this.f8151r, false);
        zzbfp.m7748a(parcel, 19, (String) m8782i(), false);
        zzbfp.m7749a(parcel, 20, m8776c(), false);
        zzbfp.m7743a(parcel, 21, (Parcelable) this.f8152s, i, false);
        zzbfp.m7743a(parcel, 22, (Parcelable) this.f8153t, i, false);
        zzbfp.m7748a(parcel, 23, this.f8154u, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
