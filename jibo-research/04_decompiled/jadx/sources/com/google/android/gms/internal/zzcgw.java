package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
final class zzcgw {

    /* JADX INFO: renamed from: a */
    final String f7144a;

    /* JADX INFO: renamed from: b */
    final String f7145b;

    /* JADX INFO: renamed from: c */
    final long f7146c;

    /* JADX INFO: renamed from: d */
    final long f7147d;

    /* JADX INFO: renamed from: e */
    final long f7148e;

    /* JADX INFO: renamed from: f */
    final long f7149f;

    /* JADX INFO: renamed from: g */
    final Long f7150g;

    /* JADX INFO: renamed from: h */
    final Long f7151h;

    /* JADX INFO: renamed from: i */
    final Boolean f7152i;

    zzcgw(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Boolean bool) {
        zzbq.m7375a(str);
        zzbq.m7375a(str2);
        zzbq.m7382b(j >= 0);
        zzbq.m7382b(j2 >= 0);
        zzbq.m7382b(j4 >= 0);
        this.f7144a = str;
        this.f7145b = str2;
        this.f7146c = j;
        this.f7147d = j2;
        this.f7148e = j3;
        this.f7149f = j4;
        this.f7150g = l;
        this.f7151h = l2;
        this.f7152i = bool;
    }

    /* JADX INFO: renamed from: a */
    final zzcgw m8024a() {
        return new zzcgw(this.f7144a, this.f7145b, this.f7146c + 1, this.f7147d + 1, this.f7148e, this.f7149f, this.f7150g, this.f7151h, this.f7152i);
    }

    /* JADX INFO: renamed from: a */
    final zzcgw m8025a(long j) {
        return new zzcgw(this.f7144a, this.f7145b, this.f7146c, this.f7147d, j, this.f7149f, this.f7150g, this.f7151h, this.f7152i);
    }

    /* JADX INFO: renamed from: a */
    final zzcgw m8026a(Long l, Long l2, Boolean bool) {
        return new zzcgw(this.f7144a, this.f7145b, this.f7146c, this.f7147d, this.f7148e, this.f7149f, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    /* JADX INFO: renamed from: b */
    final zzcgw m8027b(long j) {
        return new zzcgw(this.f7144a, this.f7145b, this.f7146c, this.f7147d, this.f7148e, j, this.f7150g, this.f7151h, this.f7152i);
    }
}
