package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzaxc;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzbgo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzm extends zzaxc {
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();

    /* JADX INFO: renamed from: a */
    private static final HashMap<String, zzbgo<?, ?>> f5882a;

    /* JADX INFO: renamed from: b */
    private Set<Integer> f5883b;

    /* JADX INFO: renamed from: c */
    private int f5884c;

    /* JADX INFO: renamed from: d */
    private ArrayList<zzs> f5885d;

    /* JADX INFO: renamed from: e */
    private int f5886e;

    /* JADX INFO: renamed from: f */
    private zzp f5887f;

    static {
        HashMap<String, zzbgo<?, ?>> map = new HashMap<>();
        f5882a = map;
        map.put("authenticatorData", zzbgo.m7789b("authenticatorData", 2, zzs.class));
        f5882a.put("progress", zzbgo.m7786a("progress", 4, zzp.class));
    }

    public zzm() {
        this.f5883b = new HashSet(1);
        this.f5884c = 1;
    }

    zzm(Set<Integer> set, int i, ArrayList<zzs> arrayList, int i2, zzp zzpVar) {
        this.f5883b = set;
        this.f5884c = i;
        this.f5885d = arrayList;
        this.f5886e = i2;
        this.f5887f = zzpVar;
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Map mo6679a() {
        return f5882a;
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: a */
    protected final boolean mo6680a(zzbgo zzbgoVar) {
        return this.f5883b.contains(Integer.valueOf(zzbgoVar.m7793a()));
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: b */
    protected final Object mo6681b(zzbgo zzbgoVar) {
        switch (zzbgoVar.m7793a()) {
            case 1:
                return Integer.valueOf(this.f5884c);
            case 2:
                return this.f5885d;
            case 3:
            default:
                throw new IllegalStateException(new StringBuilder(37).append("Unknown SafeParcelable id=").append(zzbgoVar.m7793a()).toString());
            case 4:
                return this.f5887f;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        Set<Integer> set = this.f5883b;
        if (set.contains(1)) {
            zzbfp.m7738a(parcel, 1, this.f5884c);
        }
        if (set.contains(2)) {
            zzbfp.m7762c(parcel, 2, this.f5885d, true);
        }
        if (set.contains(3)) {
            zzbfp.m7738a(parcel, 3, this.f5886e);
        }
        if (set.contains(4)) {
            zzbfp.m7743a(parcel, 4, (Parcelable) this.f5887f, i, true);
        }
        zzbfp.m7734a(parcel, iM7733a);
    }
}
