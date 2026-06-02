package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmb extends zzfjm<zzcmb> {

    /* JADX INFO: renamed from: f */
    private static volatile zzcmb[] f7662f;

    /* JADX INFO: renamed from: a */
    public zzcmc[] f7663a = zzcmc.m8458a();

    /* JADX INFO: renamed from: b */
    public String f7664b = null;

    /* JADX INFO: renamed from: c */
    public Long f7665c = null;

    /* JADX INFO: renamed from: d */
    public Long f7666d = null;

    /* JADX INFO: renamed from: e */
    public Integer f7667e = null;

    public zzcmb() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzcmb[] m8457a() {
        if (f7662f == null) {
            synchronized (zzfjq.f7965b) {
                if (f7662f == null) {
                    f7662f = new zzcmb[0];
                }
            }
        }
        return f7662f;
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
                    int iM8719a = zzfjv.m8719a(zzfjjVar, 10);
                    int length = this.f7663a == null ? 0 : this.f7663a.length;
                    zzcmc[] zzcmcVarArr = new zzcmc[iM8719a + length];
                    if (length != 0) {
                        System.arraycopy(this.f7663a, 0, zzcmcVarArr, 0, length);
                    }
                    while (length < zzcmcVarArr.length - 1) {
                        zzcmcVarArr[length] = new zzcmc();
                        zzfjjVar.m8623a(zzcmcVarArr[length]);
                        zzfjjVar.m8621a();
                        length++;
                    }
                    zzcmcVarArr[length] = new zzcmc();
                    zzfjjVar.m8623a(zzcmcVarArr[length]);
                    this.f7663a = zzcmcVarArr;
                    break;
                case 18:
                    this.f7664b = zzfjjVar.m8632e();
                    break;
                case 24:
                    this.f7665c = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 32:
                    this.f7666d = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 40:
                    this.f7667e = Integer.valueOf(zzfjjVar.m8636h());
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
        if (this.f7663a != null && this.f7663a.length > 0) {
            for (int i = 0; i < this.f7663a.length; i++) {
                zzcmc zzcmcVar = this.f7663a[i];
                if (zzcmcVar != null) {
                    zzfjkVar.m8669a(1, zzcmcVar);
                }
            }
        }
        if (this.f7664b != null) {
            zzfjkVar.m8670a(2, this.f7664b);
        }
        if (this.f7665c != null) {
            zzfjkVar.m8674b(3, this.f7665c.longValue());
        }
        if (this.f7666d != null) {
            zzfjkVar.m8674b(4, this.f7666d.longValue());
        }
        if (this.f7667e != null) {
            zzfjkVar.m8667a(5, this.f7667e.intValue());
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7663a != null && this.f7663a.length > 0) {
            for (int i = 0; i < this.f7663a.length; i++) {
                zzcmc zzcmcVar = this.f7663a[i];
                if (zzcmcVar != null) {
                    iMo8448b += zzfjk.m8652b(1, zzcmcVar);
                }
            }
        }
        if (this.f7664b != null) {
            iMo8448b += zzfjk.m8653b(2, this.f7664b);
        }
        if (this.f7665c != null) {
            iMo8448b += zzfjk.m8660d(3, this.f7665c.longValue());
        }
        if (this.f7666d != null) {
            iMo8448b += zzfjk.m8660d(4, this.f7666d.longValue());
        }
        return this.f7667e != null ? iMo8448b + zzfjk.m8651b(5, this.f7667e.intValue()) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmb)) {
            return false;
        }
        zzcmb zzcmbVar = (zzcmb) obj;
        if (!zzfjq.m8703a(this.f7663a, zzcmbVar.f7663a)) {
            return false;
        }
        if (this.f7664b == null) {
            if (zzcmbVar.f7664b != null) {
                return false;
            }
        } else if (!this.f7664b.equals(zzcmbVar.f7664b)) {
            return false;
        }
        if (this.f7665c == null) {
            if (zzcmbVar.f7665c != null) {
                return false;
            }
        } else if (!this.f7665c.equals(zzcmbVar.f7665c)) {
            return false;
        }
        if (this.f7666d == null) {
            if (zzcmbVar.f7666d != null) {
                return false;
            }
        } else if (!this.f7666d.equals(zzcmbVar.f7666d)) {
            return false;
        }
        if (this.f7667e == null) {
            if (zzcmbVar.f7667e != null) {
                return false;
            }
        } else if (!this.f7667e.equals(zzcmbVar.f7667e)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzcmbVar.f7951H == null || zzcmbVar.f7951H.m8690b() : this.f7951H.equals(zzcmbVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7667e == null ? 0 : this.f7667e.hashCode()) + (((this.f7666d == null ? 0 : this.f7666d.hashCode()) + (((this.f7665c == null ? 0 : this.f7665c.hashCode()) + (((this.f7664b == null ? 0 : this.f7664b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzfjq.m8698a(this.f7663a)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
