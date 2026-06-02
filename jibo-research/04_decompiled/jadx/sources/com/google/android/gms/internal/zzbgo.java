package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbi;
import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgo<I, O> extends zzbfm {
    public static final zzbgr CREATOR = new zzbgr();

    /* JADX INFO: renamed from: a */
    protected final int f6949a;

    /* JADX INFO: renamed from: b */
    protected final boolean f6950b;

    /* JADX INFO: renamed from: c */
    protected final int f6951c;

    /* JADX INFO: renamed from: d */
    protected final boolean f6952d;

    /* JADX INFO: renamed from: e */
    protected final String f6953e;

    /* JADX INFO: renamed from: f */
    protected final int f6954f;

    /* JADX INFO: renamed from: g */
    protected final Class<? extends zzbgn> f6955g;

    /* JADX INFO: renamed from: h */
    private final int f6956h;

    /* JADX INFO: renamed from: i */
    private String f6957i;

    /* JADX INFO: renamed from: j */
    private zzbgt f6958j;

    /* JADX INFO: renamed from: k */
    private zzbgp<I, O> f6959k;

    zzbgo(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, zzbgh zzbghVar) {
        this.f6956h = i;
        this.f6949a = i2;
        this.f6950b = z;
        this.f6951c = i3;
        this.f6952d = z2;
        this.f6953e = str;
        this.f6954f = i4;
        if (str2 == null) {
            this.f6955g = null;
            this.f6957i = null;
        } else {
            this.f6955g = zzbgy.class;
            this.f6957i = str2;
        }
        if (zzbghVar == null) {
            this.f6959k = null;
        } else {
            this.f6959k = (zzbgp<I, O>) zzbghVar.m7776a();
        }
    }

    private zzbgo(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends zzbgn> cls, zzbgp<I, O> zzbgpVar) {
        this.f6956h = 1;
        this.f6949a = i;
        this.f6950b = z;
        this.f6951c = i2;
        this.f6952d = z2;
        this.f6953e = str;
        this.f6954f = i3;
        this.f6955g = cls;
        if (cls == null) {
            this.f6957i = null;
        } else {
            this.f6957i = cls.getCanonicalName();
        }
        this.f6959k = zzbgpVar;
    }

    /* JADX INFO: renamed from: a */
    public static zzbgo<Integer, Integer> m7785a(String str, int i) {
        return new zzbgo<>(0, false, 0, false, str, i, null, null);
    }

    /* JADX INFO: renamed from: a */
    public static <T extends zzbgn> zzbgo<T, T> m7786a(String str, int i, Class<T> cls) {
        return new zzbgo<>(11, false, 11, false, str, i, cls, null);
    }

    /* JADX INFO: renamed from: b */
    public static zzbgo<String, String> m7788b(String str, int i) {
        return new zzbgo<>(7, false, 7, false, str, i, null, null);
    }

    /* JADX INFO: renamed from: b */
    public static <T extends zzbgn> zzbgo<ArrayList<T>, ArrayList<T>> m7789b(String str, int i, Class<T> cls) {
        return new zzbgo<>(11, true, 11, true, str, i, cls, null);
    }

    /* JADX INFO: renamed from: c */
    public static zzbgo<ArrayList<String>, ArrayList<String>> m7790c(String str, int i) {
        return new zzbgo<>(7, true, 7, true, str, i, null, null);
    }

    /* JADX INFO: renamed from: d */
    public static zzbgo<byte[], byte[]> m7791d(String str, int i) {
        return new zzbgo<>(8, false, 8, false, str, 4, null, null);
    }

    /* JADX INFO: renamed from: d */
    private String m7792d() {
        if (this.f6957i == null) {
            return null;
        }
        return this.f6957i;
    }

    /* JADX INFO: renamed from: a */
    public final int m7793a() {
        return this.f6954f;
    }

    /* JADX INFO: renamed from: a */
    public final I m7794a(O o) {
        return this.f6959k.mo7779a(o);
    }

    /* JADX INFO: renamed from: a */
    public final void m7795a(zzbgt zzbgtVar) {
        this.f6958j = zzbgtVar;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m7796b() {
        return this.f6959k != null;
    }

    /* JADX INFO: renamed from: c */
    public final Map<String, zzbgo<?, ?>> m7797c() {
        zzbq.m7373a(this.f6957i);
        zzbq.m7373a(this.f6958j);
        return this.f6958j.m7800a(this.f6957i);
    }

    public final String toString() {
        zzbi zzbiVarM7372a = zzbg.m7370a(this).m7372a("versionCode", Integer.valueOf(this.f6956h)).m7372a("typeIn", Integer.valueOf(this.f6949a)).m7372a("typeInArray", Boolean.valueOf(this.f6950b)).m7372a("typeOut", Integer.valueOf(this.f6951c)).m7372a("typeOutArray", Boolean.valueOf(this.f6952d)).m7372a("outputFieldName", this.f6953e).m7372a("safeParcelFieldId", Integer.valueOf(this.f6954f)).m7372a("concreteTypeName", m7792d());
        Class<? extends zzbgn> cls = this.f6955g;
        if (cls != null) {
            zzbiVarM7372a.m7372a("concreteType.class", cls.getCanonicalName());
        }
        if (this.f6959k != null) {
            zzbiVarM7372a.m7372a("converterName", this.f6959k.getClass().getCanonicalName());
        }
        return zzbiVarM7372a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6956h);
        zzbfp.m7738a(parcel, 2, this.f6949a);
        zzbfp.m7751a(parcel, 3, this.f6950b);
        zzbfp.m7738a(parcel, 4, this.f6951c);
        zzbfp.m7751a(parcel, 5, this.f6952d);
        zzbfp.m7748a(parcel, 6, this.f6953e, false);
        zzbfp.m7738a(parcel, 7, this.f6954f);
        zzbfp.m7748a(parcel, 8, m7792d(), false);
        zzbfp.m7743a(parcel, 9, (Parcelable) (this.f6959k == null ? null : zzbgh.m7775a(this.f6959k)), i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
