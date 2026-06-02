package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmc extends zzfjm<zzcmc> {

    /* JADX INFO: renamed from: e */
    private static volatile zzcmc[] f7668e;

    /* JADX INFO: renamed from: a */
    public String f7669a = null;

    /* JADX INFO: renamed from: b */
    public String f7670b = null;

    /* JADX INFO: renamed from: c */
    public Long f7671c = null;

    /* JADX INFO: renamed from: f */
    private Float f7673f = null;

    /* JADX INFO: renamed from: d */
    public Double f7672d = null;

    public zzcmc() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzcmc[] m8458a() {
        if (f7668e == null) {
            synchronized (zzfjq.f7965b) {
                if (f7668e == null) {
                    f7668e = new zzcmc[0];
                }
            }
        }
        return f7668e;
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
                    this.f7669a = zzfjjVar.m8632e();
                    break;
                case 18:
                    this.f7670b = zzfjjVar.m8632e();
                    break;
                case 24:
                    this.f7671c = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 37:
                    this.f7673f = Float.valueOf(Float.intBitsToFloat(zzfjjVar.m8638j()));
                    break;
                case 41:
                    this.f7672d = Double.valueOf(Double.longBitsToDouble(zzfjjVar.m8639k()));
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
        if (this.f7669a != null) {
            zzfjkVar.m8670a(1, this.f7669a);
        }
        if (this.f7670b != null) {
            zzfjkVar.m8670a(2, this.f7670b);
        }
        if (this.f7671c != null) {
            zzfjkVar.m8674b(3, this.f7671c.longValue());
        }
        if (this.f7673f != null) {
            zzfjkVar.m8666a(4, this.f7673f.floatValue());
        }
        if (this.f7672d != null) {
            zzfjkVar.m8665a(5, this.f7672d.doubleValue());
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7669a != null) {
            iMo8448b += zzfjk.m8653b(1, this.f7669a);
        }
        if (this.f7670b != null) {
            iMo8448b += zzfjk.m8653b(2, this.f7670b);
        }
        if (this.f7671c != null) {
            iMo8448b += zzfjk.m8660d(3, this.f7671c.longValue());
        }
        if (this.f7673f != null) {
            this.f7673f.floatValue();
            iMo8448b += zzfjk.m8650b(4) + 4;
        }
        if (this.f7672d == null) {
            return iMo8448b;
        }
        this.f7672d.doubleValue();
        return iMo8448b + zzfjk.m8650b(5) + 8;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmc)) {
            return false;
        }
        zzcmc zzcmcVar = (zzcmc) obj;
        if (this.f7669a == null) {
            if (zzcmcVar.f7669a != null) {
                return false;
            }
        } else if (!this.f7669a.equals(zzcmcVar.f7669a)) {
            return false;
        }
        if (this.f7670b == null) {
            if (zzcmcVar.f7670b != null) {
                return false;
            }
        } else if (!this.f7670b.equals(zzcmcVar.f7670b)) {
            return false;
        }
        if (this.f7671c == null) {
            if (zzcmcVar.f7671c != null) {
                return false;
            }
        } else if (!this.f7671c.equals(zzcmcVar.f7671c)) {
            return false;
        }
        if (this.f7673f == null) {
            if (zzcmcVar.f7673f != null) {
                return false;
            }
        } else if (!this.f7673f.equals(zzcmcVar.f7673f)) {
            return false;
        }
        if (this.f7672d == null) {
            if (zzcmcVar.f7672d != null) {
                return false;
            }
        } else if (!this.f7672d.equals(zzcmcVar.f7672d)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzcmcVar.f7951H == null || zzcmcVar.f7951H.m8690b() : this.f7951H.equals(zzcmcVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7672d == null ? 0 : this.f7672d.hashCode()) + (((this.f7673f == null ? 0 : this.f7673f.hashCode()) + (((this.f7671c == null ? 0 : this.f7671c.hashCode()) + (((this.f7670b == null ? 0 : this.f7670b.hashCode()) + (((this.f7669a == null ? 0 : this.f7669a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
