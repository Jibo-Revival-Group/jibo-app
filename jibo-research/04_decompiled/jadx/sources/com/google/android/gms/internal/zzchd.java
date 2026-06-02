package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzchd<V> {

    /* JADX INFO: renamed from: a */
    private final V f7201a;

    /* JADX INFO: renamed from: b */
    private final zzbey<V> f7202b;

    /* JADX INFO: renamed from: c */
    private final String f7203c;

    private zzchd(String str, zzbey<V> zzbeyVar, V v) {
        zzbq.m7373a(zzbeyVar);
        this.f7202b = zzbeyVar;
        this.f7201a = v;
        this.f7203c = str;
    }

    /* JADX INFO: renamed from: a */
    static zzchd<Integer> m8035a(String str, int i, int i2) {
        return new zzchd<>(str, zzbey.m7691a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: a */
    static zzchd<Long> m8036a(String str, long j, long j2) {
        return new zzchd<>(str, zzbey.m7692a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    /* JADX INFO: renamed from: a */
    static zzchd<String> m8037a(String str, String str2, String str3) {
        return new zzchd<>(str, zzbey.m7693a(str, str3), str2);
    }

    /* JADX INFO: renamed from: a */
    static zzchd<Boolean> m8038a(String str, boolean z, boolean z2) {
        return new zzchd<>(str, zzbey.m7694a(str, z2), Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: a */
    public final V m8039a(V v) {
        return v != null ? v : this.f7201a;
    }

    /* JADX INFO: renamed from: a */
    public final String m8040a() {
        return this.f7203c;
    }

    /* JADX INFO: renamed from: b */
    public final V m8041b() {
        return this.f7201a;
    }
}
