package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmg extends zzfjm<zzcmg> {

    /* JADX INFO: renamed from: f */
    private static volatile zzcmg[] f7713f;

    /* JADX INFO: renamed from: a */
    public Long f7714a = null;

    /* JADX INFO: renamed from: b */
    public String f7715b = null;

    /* JADX INFO: renamed from: c */
    public String f7716c = null;

    /* JADX INFO: renamed from: d */
    public Long f7717d = null;

    /* JADX INFO: renamed from: g */
    private Float f7719g = null;

    /* JADX INFO: renamed from: e */
    public Double f7718e = null;

    public zzcmg() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzcmg[] m8460a() {
        if (f7713f == null) {
            synchronized (zzfjq.f7965b) {
                if (f7713f == null) {
                    f7713f = new zzcmg[0];
                }
            }
        }
        return f7713f;
    }

    @Override // com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ zzfjs mo8446a(zzfjj zzfjjVar) throws IOException {
        while (true) {
            int iM8621a = zzfjjVar.m8621a();
            switch (iM8621a) {
                case 0:
                    break;
                case 8:
                    this.f7714a = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 18:
                    this.f7715b = zzfjjVar.m8632e();
                    break;
                case 26:
                    this.f7716c = zzfjjVar.m8632e();
                    break;
                case 32:
                    this.f7717d = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 45:
                    this.f7719g = Float.valueOf(Float.intBitsToFloat(zzfjjVar.m8638j()));
                    break;
                case 49:
                    this.f7718e = Double.valueOf(Double.longBitsToDouble(zzfjjVar.m8639k()));
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
        if (this.f7714a != null) {
            zzfjkVar.m8674b(1, this.f7714a.longValue());
        }
        if (this.f7715b != null) {
            zzfjkVar.m8670a(2, this.f7715b);
        }
        if (this.f7716c != null) {
            zzfjkVar.m8670a(3, this.f7716c);
        }
        if (this.f7717d != null) {
            zzfjkVar.m8674b(4, this.f7717d.longValue());
        }
        if (this.f7719g != null) {
            zzfjkVar.m8666a(5, this.f7719g.floatValue());
        }
        if (this.f7718e != null) {
            zzfjkVar.m8665a(6, this.f7718e.doubleValue());
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7714a != null) {
            iMo8448b += zzfjk.m8660d(1, this.f7714a.longValue());
        }
        if (this.f7715b != null) {
            iMo8448b += zzfjk.m8653b(2, this.f7715b);
        }
        if (this.f7716c != null) {
            iMo8448b += zzfjk.m8653b(3, this.f7716c);
        }
        if (this.f7717d != null) {
            iMo8448b += zzfjk.m8660d(4, this.f7717d.longValue());
        }
        if (this.f7719g != null) {
            this.f7719g.floatValue();
            iMo8448b += zzfjk.m8650b(5) + 4;
        }
        if (this.f7718e == null) {
            return iMo8448b;
        }
        this.f7718e.doubleValue();
        return iMo8448b + zzfjk.m8650b(6) + 8;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmg)) {
            return false;
        }
        zzcmg zzcmgVar = (zzcmg) obj;
        if (this.f7714a == null) {
            if (zzcmgVar.f7714a != null) {
                return false;
            }
        } else if (!this.f7714a.equals(zzcmgVar.f7714a)) {
            return false;
        }
        if (this.f7715b == null) {
            if (zzcmgVar.f7715b != null) {
                return false;
            }
        } else if (!this.f7715b.equals(zzcmgVar.f7715b)) {
            return false;
        }
        if (this.f7716c == null) {
            if (zzcmgVar.f7716c != null) {
                return false;
            }
        } else if (!this.f7716c.equals(zzcmgVar.f7716c)) {
            return false;
        }
        if (this.f7717d == null) {
            if (zzcmgVar.f7717d != null) {
                return false;
            }
        } else if (!this.f7717d.equals(zzcmgVar.f7717d)) {
            return false;
        }
        if (this.f7719g == null) {
            if (zzcmgVar.f7719g != null) {
                return false;
            }
        } else if (!this.f7719g.equals(zzcmgVar.f7719g)) {
            return false;
        }
        if (this.f7718e == null) {
            if (zzcmgVar.f7718e != null) {
                return false;
            }
        } else if (!this.f7718e.equals(zzcmgVar.f7718e)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzcmgVar.f7951H == null || zzcmgVar.f7951H.m8690b() : this.f7951H.equals(zzcmgVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7718e == null ? 0 : this.f7718e.hashCode()) + (((this.f7719g == null ? 0 : this.f7719g.hashCode()) + (((this.f7717d == null ? 0 : this.f7717d.hashCode()) + (((this.f7716c == null ? 0 : this.f7716c.hashCode()) + (((this.f7715b == null ? 0 : this.f7715b.hashCode()) + (((this.f7714a == null ? 0 : this.f7714a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
