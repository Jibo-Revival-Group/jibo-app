package com.google.android.gms.internal;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzfju {

    /* JADX INFO: renamed from: a */
    final int f7968a;

    /* JADX INFO: renamed from: b */
    final byte[] f7969b;

    zzfju(int i, byte[] bArr) {
        this.f7968a = i;
        this.f7969b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfju)) {
            return false;
        }
        zzfju zzfjuVar = (zzfju) obj;
        return this.f7968a == zzfjuVar.f7968a && Arrays.equals(this.f7969b, zzfjuVar.f7969b);
    }

    public final int hashCode() {
        return ((this.f7968a + 527) * 31) + Arrays.hashCode(this.f7969b);
    }
}
