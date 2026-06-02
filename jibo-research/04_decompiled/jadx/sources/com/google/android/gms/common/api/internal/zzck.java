package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzck<L> {

    /* JADX INFO: renamed from: a */
    private final L f6349a;

    /* JADX INFO: renamed from: b */
    private final String f6350b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzck)) {
            return false;
        }
        zzck zzckVar = (zzck) obj;
        return this.f6349a == zzckVar.f6349a && this.f6350b.equals(zzckVar.f6350b);
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f6349a) * 31) + this.f6350b.hashCode();
    }
}
