package com.google.android.gms.internal;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class zzcup {

    /* JADX INFO: renamed from: a */
    private final String f7760a;

    /* JADX INFO: renamed from: b */
    private final Uri f7761b;

    /* JADX INFO: renamed from: c */
    private final String f7762c;

    /* JADX INFO: renamed from: d */
    private final String f7763d;

    /* JADX INFO: renamed from: e */
    private final boolean f7764e;

    /* JADX INFO: renamed from: f */
    private final boolean f7765f;

    public zzcup(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    private zzcup(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
        this.f7760a = str;
        this.f7761b = uri;
        this.f7762c = str2;
        this.f7763d = str3;
        this.f7764e = z;
        this.f7765f = z2;
    }

    /* JADX INFO: renamed from: a */
    public final zzcui<String> m8492a(String str, String str2) {
        return zzcui.m8475b(this, str, null);
    }

    /* JADX INFO: renamed from: a */
    public final zzcup m8493a(String str) {
        if (this.f7764e) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        return new zzcup(this.f7760a, this.f7761b, str, this.f7763d, this.f7764e, this.f7765f);
    }

    /* JADX INFO: renamed from: b */
    public final zzcup m8494b(String str) {
        return new zzcup(this.f7760a, this.f7761b, this.f7762c, str, this.f7764e, this.f7765f);
    }
}
