package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzclx extends zzfjm<zzclx> {

    /* JADX INFO: renamed from: e */
    private static volatile zzclx[] f7643e;

    /* JADX INFO: renamed from: a */
    public String f7644a = null;

    /* JADX INFO: renamed from: b */
    public Boolean f7645b = null;

    /* JADX INFO: renamed from: c */
    public Boolean f7646c = null;

    /* JADX INFO: renamed from: d */
    public Integer f7647d = null;

    public zzclx() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzclx[] m8454a() {
        if (f7643e == null) {
            synchronized (zzfjq.f7965b) {
                if (f7643e == null) {
                    f7643e = new zzclx[0];
                }
            }
        }
        return f7643e;
    }

    @Override // com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ zzfjs mo8446a(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int iM8621a = zzfjjVar.m8621a();
            switch (iM8621a) {
                case 0:
                    break;
                case 10:
                    this.f7644a = zzfjjVar.m8632e();
                    break;
                case 16:
                    this.f7645b = Boolean.valueOf(zzfjjVar.m8631d());
                    break;
                case 24:
                    this.f7646c = Boolean.valueOf(zzfjjVar.m8631d());
                    break;
                case 32:
                    this.f7647d = Integer.valueOf(zzfjjVar.m8636h());
                    break;
                default:
                    if (!super.m8679a(zzfjjVar, iM8621a)) {
                    }
                    break;
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public final void mo8447a(zzfjk zzfjkVar) throws IOException {
        if (this.f7644a != null) {
            zzfjkVar.m8670a(1, this.f7644a);
        }
        if (this.f7645b != null) {
            zzfjkVar.m8671a(2, this.f7645b.booleanValue());
        }
        if (this.f7646c != null) {
            zzfjkVar.m8671a(3, this.f7646c.booleanValue());
        }
        if (this.f7647d != null) {
            zzfjkVar.m8667a(4, this.f7647d.intValue());
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7644a != null) {
            iMo8448b += zzfjk.m8653b(1, this.f7644a);
        }
        if (this.f7645b != null) {
            this.f7645b.booleanValue();
            iMo8448b += zzfjk.m8650b(2) + 1;
        }
        if (this.f7646c != null) {
            this.f7646c.booleanValue();
            iMo8448b += zzfjk.m8650b(3) + 1;
        }
        return this.f7647d != null ? iMo8448b + zzfjk.m8651b(4, this.f7647d.intValue()) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclx)) {
            return false;
        }
        zzclx zzclxVar = (zzclx) obj;
        if (this.f7644a == null) {
            if (zzclxVar.f7644a != null) {
                return false;
            }
        } else if (!this.f7644a.equals(zzclxVar.f7644a)) {
            return false;
        }
        if (this.f7645b == null) {
            if (zzclxVar.f7645b != null) {
                return false;
            }
        } else if (!this.f7645b.equals(zzclxVar.f7645b)) {
            return false;
        }
        if (this.f7646c == null) {
            if (zzclxVar.f7646c != null) {
                return false;
            }
        } else if (!this.f7646c.equals(zzclxVar.f7646c)) {
            return false;
        }
        if (this.f7647d == null) {
            if (zzclxVar.f7647d != null) {
                return false;
            }
        } else if (!this.f7647d.equals(zzclxVar.f7647d)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzclxVar.f7951H == null || zzclxVar.f7951H.m8690b() : this.f7951H.equals(zzclxVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7647d == null ? 0 : this.f7647d.hashCode()) + (((this.f7646c == null ? 0 : this.f7646c.hashCode()) + (((this.f7645b == null ? 0 : this.f7645b.hashCode()) + (((this.f7644a == null ? 0 : this.f7644a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
