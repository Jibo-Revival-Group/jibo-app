package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfjm;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfjn<M extends zzfjm<M>, T> {

    /* JADX INFO: renamed from: a */
    protected final Class<T> f7952a;

    /* JADX INFO: renamed from: b */
    public final int f7953b;

    /* JADX INFO: renamed from: c */
    protected final boolean f7954c;

    /* JADX INFO: renamed from: d */
    private int f7955d;

    /* JADX INFO: renamed from: a */
    protected final int m8682a(Object obj) {
        int i = this.f7953b >>> 3;
        switch (this.f7955d) {
            case 10:
                return (zzfjk.m8650b(i) << 1) + ((zzfjs) obj).m8713f();
            case 11:
                return zzfjk.m8652b(i, (zzfjs) obj);
            default:
                throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.f7955d).toString());
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m8683a(Object obj, zzfjk zzfjkVar) {
        try {
            zzfjkVar.m8675c(this.f7953b);
            switch (this.f7955d) {
                case 10:
                    int i = this.f7953b >>> 3;
                    ((zzfjs) obj).mo8447a(zzfjkVar);
                    zzfjkVar.m8676c(i, 4);
                    return;
                case 11:
                    zzfjkVar.m8673a((zzfjs) obj);
                    return;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.f7955d).toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfjn)) {
            return false;
        }
        zzfjn zzfjnVar = (zzfjn) obj;
        return this.f7955d == zzfjnVar.f7955d && this.f7952a == zzfjnVar.f7952a && this.f7953b == zzfjnVar.f7953b && this.f7954c == zzfjnVar.f7954c;
    }

    public final int hashCode() {
        return (this.f7954c ? 1 : 0) + ((((((this.f7955d + 1147) * 31) + this.f7952a.hashCode()) * 31) + this.f7953b) * 31);
    }
}
