package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PolylineOptions extends zzbfm {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new zzl();

    /* JADX INFO: renamed from: a */
    private final List<LatLng> f8349a;

    /* JADX INFO: renamed from: b */
    private float f8350b;

    /* JADX INFO: renamed from: c */
    private int f8351c;

    /* JADX INFO: renamed from: d */
    private float f8352d;

    /* JADX INFO: renamed from: e */
    private boolean f8353e;

    /* JADX INFO: renamed from: f */
    private boolean f8354f;

    /* JADX INFO: renamed from: g */
    private boolean f8355g;

    /* JADX INFO: renamed from: h */
    private Cap f8356h;

    /* JADX INFO: renamed from: i */
    private Cap f8357i;

    /* JADX INFO: renamed from: j */
    private int f8358j;

    /* JADX INFO: renamed from: k */
    private List<PatternItem> f8359k;

    public PolylineOptions() {
        this.f8350b = 10.0f;
        this.f8351c = -16777216;
        this.f8352d = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8353e = true;
        this.f8354f = false;
        this.f8355g = false;
        this.f8356h = new ButtCap();
        this.f8357i = new ButtCap();
        this.f8358j = 0;
        this.f8359k = null;
        this.f8349a = new ArrayList();
    }

    PolylineOptions(List list, float f, int i, float f2, boolean z, boolean z2, boolean z3, Cap cap, Cap cap2, int i2, List<PatternItem> list2) {
        this.f8350b = 10.0f;
        this.f8351c = -16777216;
        this.f8352d = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8353e = true;
        this.f8354f = false;
        this.f8355g = false;
        this.f8356h = new ButtCap();
        this.f8357i = new ButtCap();
        this.f8358j = 0;
        this.f8359k = null;
        this.f8349a = list;
        this.f8350b = f;
        this.f8351c = i;
        this.f8352d = f2;
        this.f8353e = z;
        this.f8354f = z2;
        this.f8355g = z3;
        if (cap != null) {
            this.f8356h = cap;
        }
        if (cap2 != null) {
            this.f8357i = cap2;
        }
        this.f8358j = i2;
        this.f8359k = list2;
    }

    /* JADX INFO: renamed from: a */
    public final List<LatLng> m8895a() {
        return this.f8349a;
    }

    /* JADX INFO: renamed from: b */
    public final float m8896b() {
        return this.f8350b;
    }

    /* JADX INFO: renamed from: c */
    public final int m8897c() {
        return this.f8351c;
    }

    /* JADX INFO: renamed from: d */
    public final Cap m8898d() {
        return this.f8356h;
    }

    /* JADX INFO: renamed from: e */
    public final Cap m8899e() {
        return this.f8357i;
    }

    /* JADX INFO: renamed from: f */
    public final int m8900f() {
        return this.f8358j;
    }

    /* JADX INFO: renamed from: g */
    public final List<PatternItem> m8901g() {
        return this.f8359k;
    }

    /* JADX INFO: renamed from: h */
    public final float m8902h() {
        return this.f8352d;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m8903i() {
        return this.f8353e;
    }

    /* JADX INFO: renamed from: j */
    public final boolean m8904j() {
        return this.f8354f;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m8905k() {
        return this.f8355g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7762c(parcel, 2, m8895a(), false);
        zzbfp.m7737a(parcel, 3, m8896b());
        zzbfp.m7738a(parcel, 4, m8897c());
        zzbfp.m7737a(parcel, 5, m8902h());
        zzbfp.m7751a(parcel, 6, m8903i());
        zzbfp.m7751a(parcel, 7, m8904j());
        zzbfp.m7751a(parcel, 8, m8905k());
        zzbfp.m7743a(parcel, 9, (Parcelable) m8898d(), i, false);
        zzbfp.m7743a(parcel, 10, (Parcelable) m8899e(), i, false);
        zzbfp.m7738a(parcel, 11, m8900f());
        zzbfp.m7762c(parcel, 12, m8901g(), false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
