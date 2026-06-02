package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzcia {

    /* JADX INFO: renamed from: a */
    private final String f7283a;

    /* JADX INFO: renamed from: b */
    private final long f7284b;

    /* JADX INFO: renamed from: c */
    private boolean f7285c;

    /* JADX INFO: renamed from: d */
    private long f7286d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ zzchx f7287e;

    public zzcia(zzchx zzchxVar, String str, long j) {
        this.f7287e = zzchxVar;
        zzbq.m7375a(str);
        this.f7283a = str;
        this.f7284b = j;
    }

    /* JADX INFO: renamed from: a */
    public final long m8136a() {
        if (!this.f7285c) {
            this.f7285c = true;
            this.f7286d = this.f7287e.m8120D().getLong(this.f7283a, this.f7284b);
        }
        return this.f7286d;
    }

    /* JADX INFO: renamed from: a */
    public final void m8137a(long j) {
        SharedPreferences.Editor editorEdit = this.f7287e.m8120D().edit();
        editorEdit.putLong(this.f7283a, j);
        editorEdit.apply();
        this.f7286d = j;
    }
}
