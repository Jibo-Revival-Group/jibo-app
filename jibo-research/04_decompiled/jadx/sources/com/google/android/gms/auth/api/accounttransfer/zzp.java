package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import com.facebook.GraphResponse;
import com.google.android.gms.internal.zzaxc;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzbgo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzp extends zzaxc {
    public static final Parcelable.Creator<zzp> CREATOR = new zzq();

    /* JADX INFO: renamed from: a */
    private static final ArrayMap<String, zzbgo<?, ?>> f5888a;

    /* JADX INFO: renamed from: b */
    private int f5889b;

    /* JADX INFO: renamed from: c */
    private List<String> f5890c;

    /* JADX INFO: renamed from: d */
    private List<String> f5891d;

    /* JADX INFO: renamed from: e */
    private List<String> f5892e;

    /* JADX INFO: renamed from: f */
    private List<String> f5893f;

    /* JADX INFO: renamed from: g */
    private List<String> f5894g;

    static {
        ArrayMap<String, zzbgo<?, ?>> arrayMap = new ArrayMap<>();
        f5888a = arrayMap;
        arrayMap.put("registered", zzbgo.m7790c("registered", 2));
        f5888a.put("in_progress", zzbgo.m7790c("in_progress", 3));
        f5888a.put(GraphResponse.SUCCESS_KEY, zzbgo.m7790c(GraphResponse.SUCCESS_KEY, 4));
        f5888a.put("failed", zzbgo.m7790c("failed", 5));
        f5888a.put("escrowed", zzbgo.m7790c("escrowed", 6));
    }

    public zzp() {
        this.f5889b = 1;
    }

    zzp(int i, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
        this.f5889b = i;
        this.f5890c = list;
        this.f5891d = list2;
        this.f5892e = list3;
        this.f5893f = list4;
        this.f5894g = list5;
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: a */
    public final Map<String, zzbgo<?, ?>> mo6679a() {
        return f5888a;
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: a */
    protected final boolean mo6680a(zzbgo zzbgoVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.zzbgn
    /* JADX INFO: renamed from: b */
    protected final Object mo6681b(zzbgo zzbgoVar) {
        switch (zzbgoVar.m7793a()) {
            case 1:
                return Integer.valueOf(this.f5889b);
            case 2:
                return this.f5890c;
            case 3:
                return this.f5891d;
            case 4:
                return this.f5892e;
            case 5:
                return this.f5893f;
            case 6:
                return this.f5894g;
            default:
                throw new IllegalStateException(new StringBuilder(37).append("Unknown SafeParcelable id=").append(zzbgoVar.m7793a()).toString());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f5889b);
        zzbfp.m7760b(parcel, 2, this.f5890c, false);
        zzbfp.m7760b(parcel, 3, this.f5891d, false);
        zzbfp.m7760b(parcel, 4, this.f5892e, false);
        zzbfp.m7760b(parcel, 5, this.f5893f, false);
        zzbfp.m7760b(parcel, 6, this.f5894g, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
