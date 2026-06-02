package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcly extends zzfjm<zzcly> {

    /* JADX INFO: renamed from: a */
    public Long f7648a = null;

    /* JADX INFO: renamed from: b */
    public String f7649b = null;

    /* JADX INFO: renamed from: f */
    private Integer f7653f = null;

    /* JADX INFO: renamed from: c */
    public zzclz[] f7650c = zzclz.m8455a();

    /* JADX INFO: renamed from: d */
    public zzclx[] f7651d = zzclx.m8454a();

    /* JADX INFO: renamed from: e */
    public zzclr[] f7652e = zzclr.m8445a();

    public zzcly() {
        this.f7951H = null;
        this.f7967I = -1;
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
                    this.f7648a = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 18:
                    this.f7649b = zzfjjVar.m8632e();
                    break;
                case 24:
                    this.f7653f = Integer.valueOf(zzfjjVar.m8636h());
                    break;
                case 34:
                    int iM8719a = zzfjv.m8719a(zzfjjVar, 34);
                    int length = this.f7650c == null ? 0 : this.f7650c.length;
                    zzclz[] zzclzVarArr = new zzclz[iM8719a + length];
                    if (length != 0) {
                        System.arraycopy(this.f7650c, 0, zzclzVarArr, 0, length);
                    }
                    while (length < zzclzVarArr.length - 1) {
                        zzclzVarArr[length] = new zzclz();
                        zzfjjVar.m8623a(zzclzVarArr[length]);
                        zzfjjVar.m8621a();
                        length++;
                    }
                    zzclzVarArr[length] = new zzclz();
                    zzfjjVar.m8623a(zzclzVarArr[length]);
                    this.f7650c = zzclzVarArr;
                    break;
                case 42:
                    int iM8719a2 = zzfjv.m8719a(zzfjjVar, 42);
                    int length2 = this.f7651d == null ? 0 : this.f7651d.length;
                    zzclx[] zzclxVarArr = new zzclx[iM8719a2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.f7651d, 0, zzclxVarArr, 0, length2);
                    }
                    while (length2 < zzclxVarArr.length - 1) {
                        zzclxVarArr[length2] = new zzclx();
                        zzfjjVar.m8623a(zzclxVarArr[length2]);
                        zzfjjVar.m8621a();
                        length2++;
                    }
                    zzclxVarArr[length2] = new zzclx();
                    zzfjjVar.m8623a(zzclxVarArr[length2]);
                    this.f7651d = zzclxVarArr;
                    break;
                case 50:
                    int iM8719a3 = zzfjv.m8719a(zzfjjVar, 50);
                    int length3 = this.f7652e == null ? 0 : this.f7652e.length;
                    zzclr[] zzclrVarArr = new zzclr[iM8719a3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.f7652e, 0, zzclrVarArr, 0, length3);
                    }
                    while (length3 < zzclrVarArr.length - 1) {
                        zzclrVarArr[length3] = new zzclr();
                        zzfjjVar.m8623a(zzclrVarArr[length3]);
                        zzfjjVar.m8621a();
                        length3++;
                    }
                    zzclrVarArr[length3] = new zzclr();
                    zzfjjVar.m8623a(zzclrVarArr[length3]);
                    this.f7652e = zzclrVarArr;
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
        if (this.f7648a != null) {
            zzfjkVar.m8674b(1, this.f7648a.longValue());
        }
        if (this.f7649b != null) {
            zzfjkVar.m8670a(2, this.f7649b);
        }
        if (this.f7653f != null) {
            zzfjkVar.m8667a(3, this.f7653f.intValue());
        }
        if (this.f7650c != null && this.f7650c.length > 0) {
            for (int i = 0; i < this.f7650c.length; i++) {
                zzclz zzclzVar = this.f7650c[i];
                if (zzclzVar != null) {
                    zzfjkVar.m8669a(4, zzclzVar);
                }
            }
        }
        if (this.f7651d != null && this.f7651d.length > 0) {
            for (int i2 = 0; i2 < this.f7651d.length; i2++) {
                zzclx zzclxVar = this.f7651d[i2];
                if (zzclxVar != null) {
                    zzfjkVar.m8669a(5, zzclxVar);
                }
            }
        }
        if (this.f7652e != null && this.f7652e.length > 0) {
            for (int i3 = 0; i3 < this.f7652e.length; i3++) {
                zzclr zzclrVar = this.f7652e[i3];
                if (zzclrVar != null) {
                    zzfjkVar.m8669a(6, zzclrVar);
                }
            }
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7648a != null) {
            iMo8448b += zzfjk.m8660d(1, this.f7648a.longValue());
        }
        if (this.f7649b != null) {
            iMo8448b += zzfjk.m8653b(2, this.f7649b);
        }
        if (this.f7653f != null) {
            iMo8448b += zzfjk.m8651b(3, this.f7653f.intValue());
        }
        if (this.f7650c != null && this.f7650c.length > 0) {
            int iM8652b = iMo8448b;
            for (int i = 0; i < this.f7650c.length; i++) {
                zzclz zzclzVar = this.f7650c[i];
                if (zzclzVar != null) {
                    iM8652b += zzfjk.m8652b(4, zzclzVar);
                }
            }
            iMo8448b = iM8652b;
        }
        if (this.f7651d != null && this.f7651d.length > 0) {
            int iM8652b2 = iMo8448b;
            for (int i2 = 0; i2 < this.f7651d.length; i2++) {
                zzclx zzclxVar = this.f7651d[i2];
                if (zzclxVar != null) {
                    iM8652b2 += zzfjk.m8652b(5, zzclxVar);
                }
            }
            iMo8448b = iM8652b2;
        }
        if (this.f7652e != null && this.f7652e.length > 0) {
            for (int i3 = 0; i3 < this.f7652e.length; i3++) {
                zzclr zzclrVar = this.f7652e[i3];
                if (zzclrVar != null) {
                    iMo8448b += zzfjk.m8652b(6, zzclrVar);
                }
            }
        }
        return iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcly)) {
            return false;
        }
        zzcly zzclyVar = (zzcly) obj;
        if (this.f7648a == null) {
            if (zzclyVar.f7648a != null) {
                return false;
            }
        } else if (!this.f7648a.equals(zzclyVar.f7648a)) {
            return false;
        }
        if (this.f7649b == null) {
            if (zzclyVar.f7649b != null) {
                return false;
            }
        } else if (!this.f7649b.equals(zzclyVar.f7649b)) {
            return false;
        }
        if (this.f7653f == null) {
            if (zzclyVar.f7653f != null) {
                return false;
            }
        } else if (!this.f7653f.equals(zzclyVar.f7653f)) {
            return false;
        }
        if (zzfjq.m8703a(this.f7650c, zzclyVar.f7650c) && zzfjq.m8703a(this.f7651d, zzclyVar.f7651d) && zzfjq.m8703a(this.f7652e, zzclyVar.f7652e)) {
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzclyVar.f7951H == null || zzclyVar.f7951H.m8690b() : this.f7951H.equals(zzclyVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((((((((this.f7653f == null ? 0 : this.f7653f.hashCode()) + (((this.f7649b == null ? 0 : this.f7649b.hashCode()) + (((this.f7648a == null ? 0 : this.f7648a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + zzfjq.m8698a(this.f7650c)) * 31) + zzfjq.m8698a(this.f7651d)) * 31) + zzfjq.m8698a(this.f7652e)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
