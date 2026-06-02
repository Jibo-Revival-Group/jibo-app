package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class AddPlaceRequest extends zzbfm {
    public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new zzb();

    /* JADX INFO: renamed from: a */
    private final String f8083a;

    /* JADX INFO: renamed from: b */
    private final LatLng f8084b;

    /* JADX INFO: renamed from: c */
    private final String f8085c;

    /* JADX INFO: renamed from: d */
    private final List<Integer> f8086d;

    /* JADX INFO: renamed from: e */
    private final String f8087e;

    /* JADX INFO: renamed from: f */
    private final Uri f8088f;

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, String str3, Uri uri) {
        this.f8083a = zzbq.m7375a(str);
        this.f8084b = (LatLng) zzbq.m7373a(latLng);
        this.f8085c = zzbq.m7375a(str2);
        this.f8086d = new ArrayList((Collection) zzbq.m7373a(list));
        zzbq.m7383b(!this.f8086d.isEmpty(), "At least one place type should be provided.");
        zzbq.m7383b((TextUtils.isEmpty(str3) && uri == null) ? false : true, "One of phone number or URI should be provided.");
        this.f8087e = str3;
        this.f8088f = uri;
    }

    /* JADX INFO: renamed from: a */
    public String m8753a() {
        return this.f8083a;
    }

    /* JADX INFO: renamed from: b */
    public LatLng m8754b() {
        return this.f8084b;
    }

    /* JADX INFO: renamed from: c */
    public String m8755c() {
        return this.f8085c;
    }

    /* JADX INFO: renamed from: d */
    public List<Integer> m8756d() {
        return this.f8086d;
    }

    /* JADX INFO: renamed from: e */
    public String m8757e() {
        return this.f8087e;
    }

    /* JADX INFO: renamed from: f */
    public Uri m8758f() {
        return this.f8088f;
    }

    public String toString() {
        return zzbg.m7370a(this).m7372a("name", this.f8083a).m7372a("latLng", this.f8084b).m7372a("address", this.f8085c).m7372a("placeTypes", this.f8086d).m7372a("phoneNumer", this.f8087e).m7372a("websiteUri", this.f8088f).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, m8753a(), false);
        zzbfp.m7743a(parcel, 2, (Parcelable) m8754b(), i, false);
        zzbfp.m7748a(parcel, 3, m8755c(), false);
        zzbfp.m7749a(parcel, 4, m8756d(), false);
        zzbfp.m7748a(parcel, 5, m8757e(), false);
        zzbfp.m7743a(parcel, 6, (Parcelable) m8758f(), i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
