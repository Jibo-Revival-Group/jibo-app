package com.google.android.gms.gcm;

/* JADX INFO: loaded from: classes.dex */
public final class zzi {

    /* JADX INFO: renamed from: a */
    public static final zzi f6780a = new zzi(0, 30, 3600);

    /* JADX INFO: renamed from: b */
    private static zzi f6781b = new zzi(1, 30, 3600);

    /* JADX INFO: renamed from: c */
    private final int f6782c;

    /* JADX INFO: renamed from: d */
    private final int f6783d = 30;

    /* JADX INFO: renamed from: e */
    private final int f6784e = 3600;

    private zzi(int i, int i2, int i3) {
        this.f6782c = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzi)) {
            return false;
        }
        zzi zziVar = (zzi) obj;
        return zziVar.f6782c == this.f6782c && zziVar.f6783d == this.f6783d && zziVar.f6784e == this.f6784e;
    }

    public final int hashCode() {
        return (((((this.f6782c + 1) ^ 1000003) * 1000003) ^ this.f6783d) * 1000003) ^ this.f6784e;
    }

    public final String toString() {
        int i = this.f6782c;
        int i2 = this.f6783d;
        return new StringBuilder(74).append("policy=").append(i).append(" initial_backoff=").append(i2).append(" maximum_backoff=").append(this.f6784e).toString();
    }
}
