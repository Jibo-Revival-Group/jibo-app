package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
final class zzcgh {

    /* JADX INFO: renamed from: A */
    private long f7060A;

    /* JADX INFO: renamed from: a */
    private final zzcim f7061a;

    /* JADX INFO: renamed from: b */
    private final String f7062b;

    /* JADX INFO: renamed from: c */
    private String f7063c;

    /* JADX INFO: renamed from: d */
    private String f7064d;

    /* JADX INFO: renamed from: e */
    private String f7065e;

    /* JADX INFO: renamed from: f */
    private String f7066f;

    /* JADX INFO: renamed from: g */
    private long f7067g;

    /* JADX INFO: renamed from: h */
    private long f7068h;

    /* JADX INFO: renamed from: i */
    private long f7069i;

    /* JADX INFO: renamed from: j */
    private String f7070j;

    /* JADX INFO: renamed from: k */
    private long f7071k;

    /* JADX INFO: renamed from: l */
    private String f7072l;

    /* JADX INFO: renamed from: m */
    private long f7073m;

    /* JADX INFO: renamed from: n */
    private long f7074n;

    /* JADX INFO: renamed from: o */
    private boolean f7075o;

    /* JADX INFO: renamed from: p */
    private long f7076p;

    /* JADX INFO: renamed from: q */
    private boolean f7077q;

    /* JADX INFO: renamed from: r */
    private long f7078r;

    /* JADX INFO: renamed from: s */
    private long f7079s;

    /* JADX INFO: renamed from: t */
    private long f7080t;

    /* JADX INFO: renamed from: u */
    private long f7081u;

    /* JADX INFO: renamed from: v */
    private long f7082v;

    /* JADX INFO: renamed from: w */
    private long f7083w;

    /* JADX INFO: renamed from: x */
    private String f7084x;

    /* JADX INFO: renamed from: y */
    private boolean f7085y;

    /* JADX INFO: renamed from: z */
    private long f7086z;

    zzcgh(zzcim zzcimVar, String str) {
        zzbq.m7373a(zzcimVar);
        zzbq.m7375a(str);
        this.f7061a = zzcimVar;
        this.f7062b = str;
        this.f7061a.m8235h().mo7855c();
    }

    /* JADX INFO: renamed from: A */
    public final long m7875A() {
        this.f7061a.m8235h().mo7855c();
        return this.f7076p;
    }

    /* JADX INFO: renamed from: B */
    public final boolean m7876B() {
        this.f7061a.m8235h().mo7855c();
        return this.f7077q;
    }

    /* JADX INFO: renamed from: a */
    public final void m7877a() {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = false;
    }

    /* JADX INFO: renamed from: a */
    public final void m7878a(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7068h != j) | this.f7085y;
        this.f7068h = j;
    }

    /* JADX INFO: renamed from: a */
    public final void m7879a(String str) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (!zzclq.m8396a(this.f7063c, str)) | this.f7085y;
        this.f7063c = str;
    }

    /* JADX INFO: renamed from: a */
    public final void m7880a(boolean z) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7075o != z) | this.f7085y;
        this.f7075o = z;
    }

    /* JADX INFO: renamed from: b */
    public final String m7881b() {
        this.f7061a.m8235h().mo7855c();
        return this.f7062b;
    }

    /* JADX INFO: renamed from: b */
    public final void m7882b(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7069i != j) | this.f7085y;
        this.f7069i = j;
    }

    /* JADX INFO: renamed from: b */
    public final void m7883b(String str) {
        this.f7061a.m8235h().mo7855c();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f7085y = (!zzclq.m8396a(this.f7064d, str)) | this.f7085y;
        this.f7064d = str;
    }

    /* JADX INFO: renamed from: b */
    public final void m7884b(boolean z) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = this.f7077q != z;
        this.f7077q = z;
    }

    /* JADX INFO: renamed from: c */
    public final String m7885c() {
        this.f7061a.m8235h().mo7855c();
        return this.f7063c;
    }

    /* JADX INFO: renamed from: c */
    public final void m7886c(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7071k != j) | this.f7085y;
        this.f7071k = j;
    }

    /* JADX INFO: renamed from: c */
    public final void m7887c(String str) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (!zzclq.m8396a(this.f7065e, str)) | this.f7085y;
        this.f7065e = str;
    }

    /* JADX INFO: renamed from: d */
    public final String m7888d() {
        this.f7061a.m8235h().mo7855c();
        return this.f7064d;
    }

    /* JADX INFO: renamed from: d */
    public final void m7889d(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7073m != j) | this.f7085y;
        this.f7073m = j;
    }

    /* JADX INFO: renamed from: d */
    public final void m7890d(String str) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (!zzclq.m8396a(this.f7066f, str)) | this.f7085y;
        this.f7066f = str;
    }

    /* JADX INFO: renamed from: e */
    public final String m7891e() {
        this.f7061a.m8235h().mo7855c();
        return this.f7065e;
    }

    /* JADX INFO: renamed from: e */
    public final void m7892e(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7074n != j) | this.f7085y;
        this.f7074n = j;
    }

    /* JADX INFO: renamed from: e */
    public final void m7893e(String str) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (!zzclq.m8396a(this.f7070j, str)) | this.f7085y;
        this.f7070j = str;
    }

    /* JADX INFO: renamed from: f */
    public final String m7894f() {
        this.f7061a.m8235h().mo7855c();
        return this.f7066f;
    }

    /* JADX INFO: renamed from: f */
    public final void m7895f(long j) {
        zzbq.m7382b(j >= 0);
        this.f7061a.m8235h().mo7855c();
        this.f7085y |= this.f7067g != j;
        this.f7067g = j;
    }

    /* JADX INFO: renamed from: f */
    public final void m7896f(String str) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (!zzclq.m8396a(this.f7072l, str)) | this.f7085y;
        this.f7072l = str;
    }

    /* JADX INFO: renamed from: g */
    public final long m7897g() {
        this.f7061a.m8235h().mo7855c();
        return this.f7068h;
    }

    /* JADX INFO: renamed from: g */
    public final void m7898g(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7086z != j) | this.f7085y;
        this.f7086z = j;
    }

    /* JADX INFO: renamed from: g */
    public final void m7899g(String str) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (!zzclq.m8396a(this.f7084x, str)) | this.f7085y;
        this.f7084x = str;
    }

    /* JADX INFO: renamed from: h */
    public final long m7900h() {
        this.f7061a.m8235h().mo7855c();
        return this.f7069i;
    }

    /* JADX INFO: renamed from: h */
    public final void m7901h(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7060A != j) | this.f7085y;
        this.f7060A = j;
    }

    /* JADX INFO: renamed from: i */
    public final String m7902i() {
        this.f7061a.m8235h().mo7855c();
        return this.f7070j;
    }

    /* JADX INFO: renamed from: i */
    public final void m7903i(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7078r != j) | this.f7085y;
        this.f7078r = j;
    }

    /* JADX INFO: renamed from: j */
    public final long m7904j() {
        this.f7061a.m8235h().mo7855c();
        return this.f7071k;
    }

    /* JADX INFO: renamed from: j */
    public final void m7905j(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7079s != j) | this.f7085y;
        this.f7079s = j;
    }

    /* JADX INFO: renamed from: k */
    public final String m7906k() {
        this.f7061a.m8235h().mo7855c();
        return this.f7072l;
    }

    /* JADX INFO: renamed from: k */
    public final void m7907k(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7080t != j) | this.f7085y;
        this.f7080t = j;
    }

    /* JADX INFO: renamed from: l */
    public final long m7908l() {
        this.f7061a.m8235h().mo7855c();
        return this.f7073m;
    }

    /* JADX INFO: renamed from: l */
    public final void m7909l(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7081u != j) | this.f7085y;
        this.f7081u = j;
    }

    /* JADX INFO: renamed from: m */
    public final long m7910m() {
        this.f7061a.m8235h().mo7855c();
        return this.f7074n;
    }

    /* JADX INFO: renamed from: m */
    public final void m7911m(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7083w != j) | this.f7085y;
        this.f7083w = j;
    }

    /* JADX INFO: renamed from: n */
    public final void m7912n(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7082v != j) | this.f7085y;
        this.f7082v = j;
    }

    /* JADX INFO: renamed from: n */
    public final boolean m7913n() {
        this.f7061a.m8235h().mo7855c();
        return this.f7075o;
    }

    /* JADX INFO: renamed from: o */
    public final long m7914o() {
        this.f7061a.m8235h().mo7855c();
        return this.f7067g;
    }

    /* JADX INFO: renamed from: o */
    public final void m7915o(long j) {
        this.f7061a.m8235h().mo7855c();
        this.f7085y = (this.f7076p != j) | this.f7085y;
        this.f7076p = j;
    }

    /* JADX INFO: renamed from: p */
    public final long m7916p() {
        this.f7061a.m8235h().mo7855c();
        return this.f7086z;
    }

    /* JADX INFO: renamed from: q */
    public final long m7917q() {
        this.f7061a.m8235h().mo7855c();
        return this.f7060A;
    }

    /* JADX INFO: renamed from: r */
    public final void m7918r() {
        this.f7061a.m8235h().mo7855c();
        long j = this.f7067g + 1;
        if (j > 2147483647L) {
            this.f7061a.m8233f().m8097A().m8109a("Bundle index overflow. appId", zzchm.m8093a(this.f7062b));
            j = 0;
        }
        this.f7085y = true;
        this.f7067g = j;
    }

    /* JADX INFO: renamed from: s */
    public final long m7919s() {
        this.f7061a.m8235h().mo7855c();
        return this.f7078r;
    }

    /* JADX INFO: renamed from: t */
    public final long m7920t() {
        this.f7061a.m8235h().mo7855c();
        return this.f7079s;
    }

    /* JADX INFO: renamed from: u */
    public final long m7921u() {
        this.f7061a.m8235h().mo7855c();
        return this.f7080t;
    }

    /* JADX INFO: renamed from: v */
    public final long m7922v() {
        this.f7061a.m8235h().mo7855c();
        return this.f7081u;
    }

    /* JADX INFO: renamed from: w */
    public final long m7923w() {
        this.f7061a.m8235h().mo7855c();
        return this.f7083w;
    }

    /* JADX INFO: renamed from: x */
    public final long m7924x() {
        this.f7061a.m8235h().mo7855c();
        return this.f7082v;
    }

    /* JADX INFO: renamed from: y */
    public final String m7925y() {
        this.f7061a.m8235h().mo7855c();
        return this.f7084x;
    }

    /* JADX INFO: renamed from: z */
    public final String m7926z() {
        this.f7061a.m8235h().mo7855c();
        String str = this.f7084x;
        m7899g((String) null);
        return str;
    }
}
