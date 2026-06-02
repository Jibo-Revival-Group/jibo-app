package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzaxc;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzbgo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zzs extends zzaxc {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();

    /* JADX INFO: renamed from: a */
    private static final HashMap<String, zzbgo<?, ?>> f5895a;

    /* JADX INFO: renamed from: b */
    private Set<Integer> f5896b;

    /* JADX INFO: renamed from: c */
    private int f5897c;

    /* JADX INFO: renamed from: d */
    private zzu f5898d;

    /* JADX INFO: renamed from: e */
    private String f5899e;

    /* JADX INFO: renamed from: f */
    private String f5900f;

    static {
        HashMap<String, zzbgo<?, ?>> map = new HashMap<>();
        f5895a = map;
        map.put("authenticatorInfo", zzbgo.m7786a("authenticatorInfo", 2, zzu.class));
        f5895a.put("signature", zzbgo.m7788b("signature", 3));
        f5895a.put("package", zzbgo.m7788b("package", 4));
    }

    public zzs() {
        this.f5896b = new HashSet(3);
        this.f5897c = 1;
    }

    zzs(Set<Integer> set, int i, zzu zzuVar, String str, String str2) {
        this.f5896b = set;
        this.f5897c = i;
        this.f5898d = zzuVar;
        this.f5899e = str;
        this.f5900f = str2;
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Map mo6679a() {
        return f5895a;
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: a */
    protected final boolean mo6680a(zzbgo zzbgoVar) {
        return this.f5896b.contains(Integer.valueOf(zzbgoVar.m7793a()));
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: b */
    protected final Object mo6681b(zzbgo zzbgoVar) {
        switch (zzbgoVar.m7793a()) {
            case 1:
                return Integer.valueOf(this.f5897c);
            case 2:
                return this.f5898d;
            case 3:
                return this.f5899e;
            case 4:
                return this.f5900f;
            default:
                throw new IllegalStateException(new StringBuilder(37).append("Unknown SafeParcelable id=").append(zzbgoVar.m7793a()).toString());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        Set<Integer> set = this.f5896b;
        if (set.contains(1)) {
            zzbfp.m7738a(parcel, 1, this.f5897c);
        }
        if (set.contains(2)) {
            zzbfp.m7743a(parcel, 2, (Parcelable) this.f5898d, i, true);
        }
        if (set.contains(3)) {
            zzbfp.m7748a(parcel, 3, this.f5899e, true);
        }
        if (set.contains(4)) {
            zzbfp.m7748a(parcel, 4, this.f5900f, true);
        }
        zzbfp.m7734a(parcel, iM7733a);
    }
}
