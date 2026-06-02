package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzah {

    /* JADX INFO: renamed from: a */
    private final String f6540a;

    /* JADX INFO: renamed from: b */
    private final String f6541b;

    /* JADX INFO: renamed from: c */
    private final ComponentName f6542c;

    /* JADX INFO: renamed from: d */
    private final int f6543d;

    public zzah(ComponentName componentName, int i) {
        this.f6540a = null;
        this.f6541b = null;
        this.f6542c = (ComponentName) zzbq.m7373a(componentName);
        this.f6543d = 129;
    }

    public zzah(String str, String str2, int i) {
        this.f6540a = zzbq.m7375a(str);
        this.f6541b = zzbq.m7375a(str2);
        this.f6542c = null;
        this.f6543d = i;
    }

    /* JADX INFO: renamed from: a */
    public final String m7332a() {
        return this.f6541b;
    }

    /* JADX INFO: renamed from: b */
    public final ComponentName m7333b() {
        return this.f6542c;
    }

    /* JADX INFO: renamed from: c */
    public final int m7334c() {
        return this.f6543d;
    }

    /* JADX INFO: renamed from: d */
    public final Intent m7335d() {
        return this.f6540a != null ? new Intent(this.f6540a).setPackage(this.f6541b) : new Intent().setComponent(this.f6542c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah zzahVar = (zzah) obj;
        return zzbg.m7371a(this.f6540a, zzahVar.f6540a) && zzbg.m7371a(this.f6541b, zzahVar.f6541b) && zzbg.m7371a(this.f6542c, zzahVar.f6542c) && this.f6543d == zzahVar.f6543d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6540a, this.f6541b, this.f6542c, Integer.valueOf(this.f6543d)});
    }

    public final String toString() {
        return this.f6540a == null ? this.f6542c.flattenToString() : this.f6540a;
    }
}
