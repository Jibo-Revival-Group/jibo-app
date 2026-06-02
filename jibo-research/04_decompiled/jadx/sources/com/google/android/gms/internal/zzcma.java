package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcma extends zzfjm<zzcma> {

    /* JADX INFO: renamed from: e */
    private static volatile zzcma[] f7657e;

    /* JADX INFO: renamed from: a */
    public Integer f7658a = null;

    /* JADX INFO: renamed from: b */
    public zzcmf f7659b = null;

    /* JADX INFO: renamed from: c */
    public zzcmf f7660c = null;

    /* JADX INFO: renamed from: d */
    public Boolean f7661d = null;

    public zzcma() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzcma[] m8456a() {
        if (f7657e == null) {
            synchronized (zzfjq.f7965b) {
                if (f7657e == null) {
                    f7657e = new zzcma[0];
                }
            }
        }
        return f7657e;
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
                    this.f7658a = Integer.valueOf(zzfjjVar.m8636h());
                    break;
                case 18:
                    if (this.f7659b == null) {
                        this.f7659b = new zzcmf();
                    }
                    zzfjjVar.m8623a(this.f7659b);
                    break;
                case 26:
                    if (this.f7660c == null) {
                        this.f7660c = new zzcmf();
                    }
                    zzfjjVar.m8623a(this.f7660c);
                    break;
                case 32:
                    this.f7661d = Boolean.valueOf(zzfjjVar.m8631d());
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
        if (this.f7658a != null) {
            zzfjkVar.m8667a(1, this.f7658a.intValue());
        }
        if (this.f7659b != null) {
            zzfjkVar.m8669a(2, this.f7659b);
        }
        if (this.f7660c != null) {
            zzfjkVar.m8669a(3, this.f7660c);
        }
        if (this.f7661d != null) {
            zzfjkVar.m8671a(4, this.f7661d.booleanValue());
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7658a != null) {
            iMo8448b += zzfjk.m8651b(1, this.f7658a.intValue());
        }
        if (this.f7659b != null) {
            iMo8448b += zzfjk.m8652b(2, this.f7659b);
        }
        if (this.f7660c != null) {
            iMo8448b += zzfjk.m8652b(3, this.f7660c);
        }
        if (this.f7661d == null) {
            return iMo8448b;
        }
        this.f7661d.booleanValue();
        return iMo8448b + zzfjk.m8650b(4) + 1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcma)) {
            return false;
        }
        zzcma zzcmaVar = (zzcma) obj;
        if (this.f7658a == null) {
            if (zzcmaVar.f7658a != null) {
                return false;
            }
        } else if (!this.f7658a.equals(zzcmaVar.f7658a)) {
            return false;
        }
        if (this.f7659b == null) {
            if (zzcmaVar.f7659b != null) {
                return false;
            }
        } else if (!this.f7659b.equals(zzcmaVar.f7659b)) {
            return false;
        }
        if (this.f7660c == null) {
            if (zzcmaVar.f7660c != null) {
                return false;
            }
        } else if (!this.f7660c.equals(zzcmaVar.f7660c)) {
            return false;
        }
        if (this.f7661d == null) {
            if (zzcmaVar.f7661d != null) {
                return false;
            }
        } else if (!this.f7661d.equals(zzcmaVar.f7661d)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzcmaVar.f7951H == null || zzcmaVar.f7951H.m8690b() : this.f7951H.equals(zzcmaVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = (this.f7658a == null ? 0 : this.f7658a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31);
        zzcmf zzcmfVar = this.f7659b;
        int i = iHashCode2 * 31;
        int iHashCode3 = zzcmfVar == null ? 0 : zzcmfVar.hashCode();
        zzcmf zzcmfVar2 = this.f7660c;
        int iHashCode4 = ((this.f7661d == null ? 0 : this.f7661d.hashCode()) + (((zzcmfVar2 == null ? 0 : zzcmfVar2.hashCode()) + ((iHashCode3 + i) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode4 + iHashCode;
    }
}
