package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzcic {

    /* JADX INFO: renamed from: a */
    private final String f7293a;

    /* JADX INFO: renamed from: b */
    private final String f7294b;

    /* JADX INFO: renamed from: c */
    private boolean f7295c;

    /* JADX INFO: renamed from: d */
    private String f7296d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ zzchx f7297e;

    public zzcic(zzchx zzchxVar, String str, String str2) {
        this.f7297e = zzchxVar;
        zzbq.m7375a(str);
        this.f7293a = str;
        this.f7294b = null;
    }

    /* JADX INFO: renamed from: a */
    public final String m8142a() {
        if (!this.f7295c) {
            this.f7295c = true;
            this.f7296d = this.f7297e.m8120D().getString(this.f7293a, null);
        }
        return this.f7296d;
    }

    /* JADX INFO: renamed from: a */
    public final void m8143a(String str) {
        if (zzclq.m8396a(str, this.f7296d)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f7297e.m8120D().edit();
        editorEdit.putString(this.f7293a, str);
        editorEdit.apply();
        this.f7296d = str;
    }
}
