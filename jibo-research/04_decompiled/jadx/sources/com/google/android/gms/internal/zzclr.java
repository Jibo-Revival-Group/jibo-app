package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzclr extends zzfjm<zzclr> {

    /* JADX INFO: renamed from: d */
    private static volatile zzclr[] f7615d;

    /* JADX INFO: renamed from: a */
    public Integer f7616a = null;

    /* JADX INFO: renamed from: b */
    public zzclv[] f7617b = zzclv.m8452a();

    /* JADX INFO: renamed from: c */
    public zzcls[] f7618c = zzcls.m8449a();

    public zzclr() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzclr[] m8445a() {
        if (f7615d == null) {
            synchronized (zzfjq.f7965b) {
                if (f7615d == null) {
                    f7615d = new zzclr[0];
                }
            }
        }
        return f7615d;
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
                    this.f7616a = Integer.valueOf(zzfjjVar.m8636h());
                    break;
                case 18:
                    int iM8719a = zzfjv.m8719a(zzfjjVar, 18);
                    int length = this.f7617b == null ? 0 : this.f7617b.length;
                    zzclv[] zzclvVarArr = new zzclv[iM8719a + length];
                    if (length != 0) {
                        System.arraycopy(this.f7617b, 0, zzclvVarArr, 0, length);
                    }
                    while (length < zzclvVarArr.length - 1) {
                        zzclvVarArr[length] = new zzclv();
                        zzfjjVar.m8623a(zzclvVarArr[length]);
                        zzfjjVar.m8621a();
                        length++;
                    }
                    zzclvVarArr[length] = new zzclv();
                    zzfjjVar.m8623a(zzclvVarArr[length]);
                    this.f7617b = zzclvVarArr;
                    break;
                case 26:
                    int iM8719a2 = zzfjv.m8719a(zzfjjVar, 26);
                    int length2 = this.f7618c == null ? 0 : this.f7618c.length;
                    zzcls[] zzclsVarArr = new zzcls[iM8719a2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.f7618c, 0, zzclsVarArr, 0, length2);
                    }
                    while (length2 < zzclsVarArr.length - 1) {
                        zzclsVarArr[length2] = new zzcls();
                        zzfjjVar.m8623a(zzclsVarArr[length2]);
                        zzfjjVar.m8621a();
                        length2++;
                    }
                    zzclsVarArr[length2] = new zzcls();
                    zzfjjVar.m8623a(zzclsVarArr[length2]);
                    this.f7618c = zzclsVarArr;
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
        if (this.f7616a != null) {
            zzfjkVar.m8667a(1, this.f7616a.intValue());
        }
        if (this.f7617b != null && this.f7617b.length > 0) {
            for (int i = 0; i < this.f7617b.length; i++) {
                zzclv zzclvVar = this.f7617b[i];
                if (zzclvVar != null) {
                    zzfjkVar.m8669a(2, zzclvVar);
                }
            }
        }
        if (this.f7618c != null && this.f7618c.length > 0) {
            for (int i2 = 0; i2 < this.f7618c.length; i2++) {
                zzcls zzclsVar = this.f7618c[i2];
                if (zzclsVar != null) {
                    zzfjkVar.m8669a(3, zzclsVar);
                }
            }
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7616a != null) {
            iMo8448b += zzfjk.m8651b(1, this.f7616a.intValue());
        }
        if (this.f7617b != null && this.f7617b.length > 0) {
            int iM8652b = iMo8448b;
            for (int i = 0; i < this.f7617b.length; i++) {
                zzclv zzclvVar = this.f7617b[i];
                if (zzclvVar != null) {
                    iM8652b += zzfjk.m8652b(2, zzclvVar);
                }
            }
            iMo8448b = iM8652b;
        }
        if (this.f7618c != null && this.f7618c.length > 0) {
            for (int i2 = 0; i2 < this.f7618c.length; i2++) {
                zzcls zzclsVar = this.f7618c[i2];
                if (zzclsVar != null) {
                    iMo8448b += zzfjk.m8652b(3, zzclsVar);
                }
            }
        }
        return iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclr)) {
            return false;
        }
        zzclr zzclrVar = (zzclr) obj;
        if (this.f7616a == null) {
            if (zzclrVar.f7616a != null) {
                return false;
            }
        } else if (!this.f7616a.equals(zzclrVar.f7616a)) {
            return false;
        }
        if (zzfjq.m8703a(this.f7617b, zzclrVar.f7617b) && zzfjq.m8703a(this.f7618c, zzclrVar.f7618c)) {
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzclrVar.f7951H == null || zzclrVar.f7951H.m8690b() : this.f7951H.equals(zzclrVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((((((this.f7616a == null ? 0 : this.f7616a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzfjq.m8698a(this.f7617b)) * 31) + zzfjq.m8698a(this.f7618c)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
