package com.google.android.gms.auth.api.signin.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzp {

    /* JADX INFO: renamed from: a */
    private static int f6045a = 31;

    /* JADX INFO: renamed from: b */
    private int f6046b = 1;

    /* JADX INFO: renamed from: a */
    public final int m6785a() {
        return this.f6046b;
    }

    /* JADX INFO: renamed from: a */
    public final zzp m6786a(Object obj) {
        this.f6046b = (obj == null ? 0 : obj.hashCode()) + (this.f6046b * f6045a);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final zzp m6787a(boolean z) {
        this.f6046b = (z ? 1 : 0) + (this.f6046b * f6045a);
        return this;
    }
}
