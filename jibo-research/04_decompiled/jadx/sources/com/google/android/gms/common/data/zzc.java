package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class zzc {

    /* JADX INFO: renamed from: a */
    protected final DataHolder f6485a;

    /* JADX INFO: renamed from: b */
    protected int f6486b;

    /* JADX INFO: renamed from: c */
    private int f6487c;

    public zzc(DataHolder dataHolder, int i) {
        this.f6485a = (DataHolder) zzbq.m7373a(dataHolder);
        m7282a(i);
    }

    /* JADX INFO: renamed from: a */
    protected final void m7282a(int i) {
        zzbq.m7378a(i >= 0 && i < this.f6485a.f6467a);
        this.f6486b = i;
        this.f6487c = this.f6485a.m7269a(this.f6486b);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m7283a(String str) {
        return this.f6485a.m7272a(str);
    }

    /* JADX INFO: renamed from: b */
    protected final int m7284b(String str) {
        return this.f6485a.m7270a(str, this.f6486b, this.f6487c);
    }

    /* JADX INFO: renamed from: c */
    protected final String m7285c(String str) {
        return this.f6485a.m7274b(str, this.f6486b, this.f6487c);
    }

    /* JADX INFO: renamed from: d */
    protected final float m7286d(String str) {
        return this.f6485a.m7275c(str, this.f6486b, this.f6487c);
    }

    /* JADX INFO: renamed from: e */
    protected final byte[] m7287e(String str) {
        return this.f6485a.m7278d(str, this.f6486b, this.f6487c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzcVar = (zzc) obj;
        return zzbg.m7371a(Integer.valueOf(zzcVar.f6486b), Integer.valueOf(this.f6486b)) && zzbg.m7371a(Integer.valueOf(zzcVar.f6487c), Integer.valueOf(this.f6487c)) && zzcVar.f6485a == this.f6485a;
    }

    /* JADX INFO: renamed from: f */
    protected final boolean m7288f(String str) {
        return this.f6485a.m7279e(str, this.f6486b, this.f6487c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6486b), Integer.valueOf(this.f6487c), this.f6485a});
    }
}
