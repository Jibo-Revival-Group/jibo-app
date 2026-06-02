package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzcib {

    /* JADX INFO: renamed from: a */
    private String f7288a;

    /* JADX INFO: renamed from: b */
    private final String f7289b;

    /* JADX INFO: renamed from: c */
    private final String f7290c;

    /* JADX INFO: renamed from: d */
    private final long f7291d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ zzchx f7292e;

    private zzcib(zzchx zzchxVar, String str, long j) {
        this.f7292e = zzchxVar;
        zzbq.m7375a(str);
        zzbq.m7382b(j > 0);
        this.f7288a = String.valueOf(str).concat(":start");
        this.f7289b = String.valueOf(str).concat(":count");
        this.f7290c = String.valueOf(str).concat(":value");
        this.f7291d = j;
    }

    /* JADX INFO: renamed from: b */
    private final void m8138b() {
        this.f7292e.mo7855c();
        long jMo7496a = this.f7292e.mo7863k().mo7496a();
        SharedPreferences.Editor editorEdit = this.f7292e.m8120D().edit();
        editorEdit.remove(this.f7289b);
        editorEdit.remove(this.f7290c);
        editorEdit.putLong(this.f7288a, jMo7496a);
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: c */
    private final long m8139c() {
        return this.f7292e.m8120D().getLong(this.f7288a, 0L);
    }

    /* JADX INFO: renamed from: a */
    public final Pair<String, Long> m8140a() {
        long jAbs;
        this.f7292e.mo7855c();
        this.f7292e.mo7855c();
        long jM8139c = m8139c();
        if (jM8139c == 0) {
            m8138b();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jM8139c - this.f7292e.mo7863k().mo7496a());
        }
        if (jAbs < this.f7291d) {
            return null;
        }
        if (jAbs > (this.f7291d << 1)) {
            m8138b();
            return null;
        }
        String string = this.f7292e.m8120D().getString(this.f7290c, null);
        long j = this.f7292e.m8120D().getLong(this.f7289b, 0L);
        m8138b();
        return (string == null || j <= 0) ? zzchx.f7256a : new Pair<>(string, Long.valueOf(j));
    }

    /* JADX INFO: renamed from: a */
    public final void m8141a(String str, long j) {
        this.f7292e.mo7855c();
        if (m8139c() == 0) {
            m8138b();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.f7292e.m8120D().getLong(this.f7289b, 0L);
        if (j2 <= 0) {
            SharedPreferences.Editor editorEdit = this.f7292e.m8120D().edit();
            editorEdit.putString(this.f7290c, str);
            editorEdit.putLong(this.f7289b, 1L);
            editorEdit.apply();
            return;
        }
        boolean z = (this.f7292e.mo7868p().m8444z().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / (j2 + 1);
        SharedPreferences.Editor editorEdit2 = this.f7292e.m8120D().edit();
        if (z) {
            editorEdit2.putString(this.f7290c, str);
        }
        editorEdit2.putLong(this.f7289b, j2 + 1);
        editorEdit2.apply();
    }
}
