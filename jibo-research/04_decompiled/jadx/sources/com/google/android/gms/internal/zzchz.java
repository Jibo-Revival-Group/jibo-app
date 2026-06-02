package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzchz {

    /* JADX INFO: renamed from: a */
    private final String f7278a;

    /* JADX INFO: renamed from: b */
    private final boolean f7279b;

    /* JADX INFO: renamed from: c */
    private boolean f7280c;

    /* JADX INFO: renamed from: d */
    private boolean f7281d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ zzchx f7282e;

    public zzchz(zzchx zzchxVar, String str, boolean z) {
        this.f7282e = zzchxVar;
        zzbq.m7375a(str);
        this.f7278a = str;
        this.f7279b = true;
    }

    /* JADX INFO: renamed from: a */
    public final void m8134a(boolean z) {
        SharedPreferences.Editor editorEdit = this.f7282e.m8120D().edit();
        editorEdit.putBoolean(this.f7278a, z);
        editorEdit.apply();
        this.f7281d = z;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m8135a() {
        if (!this.f7280c) {
            this.f7280c = true;
            this.f7281d = this.f7282e.m8120D().getBoolean(this.f7278a, this.f7279b);
        }
        return this.f7281d;
    }
}
