package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzh<O extends Api.ApiOptions> {

    /* JADX INFO: renamed from: a */
    private final boolean f6400a;

    /* JADX INFO: renamed from: b */
    private final int f6401b;

    /* JADX INFO: renamed from: c */
    private final Api<O> f6402c;

    /* JADX INFO: renamed from: d */
    private final O f6403d;

    private zzh(Api<O> api) {
        this.f6400a = true;
        this.f6402c = api;
        this.f6403d = null;
        this.f6401b = System.identityHashCode(this);
    }

    private zzh(Api<O> api, O o) {
        this.f6400a = false;
        this.f6402c = api;
        this.f6403d = o;
        this.f6401b = Arrays.hashCode(new Object[]{this.f6402c, this.f6403d});
    }

    /* JADX INFO: renamed from: a */
    public static <O extends Api.ApiOptions> zzh<O> m7208a(Api<O> api) {
        return new zzh<>(api);
    }

    /* JADX INFO: renamed from: a */
    public static <O extends Api.ApiOptions> zzh<O> m7209a(Api<O> api, O o) {
        return new zzh<>(api, o);
    }

    /* JADX INFO: renamed from: a */
    public final String m7210a() {
        return this.f6402c.m6853d();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzhVar = (zzh) obj;
        return !this.f6400a && !zzhVar.f6400a && com.google.android.gms.common.internal.zzbg.m7371a(this.f6402c, zzhVar.f6402c) && com.google.android.gms.common.internal.zzbg.m7371a(this.f6403d, zzhVar.f6403d);
    }

    public final int hashCode() {
        return this.f6401b;
    }
}
