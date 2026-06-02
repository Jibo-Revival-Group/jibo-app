package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcls extends zzfjm<zzcls> {

    /* JADX INFO: renamed from: e */
    private static volatile zzcls[] f7619e;

    /* JADX INFO: renamed from: a */
    public Integer f7620a = null;

    /* JADX INFO: renamed from: b */
    public String f7621b = null;

    /* JADX INFO: renamed from: c */
    public zzclt[] f7622c = zzclt.m8450a();

    /* JADX INFO: renamed from: f */
    private Boolean f7624f = null;

    /* JADX INFO: renamed from: d */
    public zzclu f7623d = null;

    public zzcls() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzcls[] m8449a() {
        if (f7619e == null) {
            synchronized (zzfjq.f7965b) {
                if (f7619e == null) {
                    f7619e = new zzcls[0];
                }
            }
        }
        return f7619e;
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
                    this.f7620a = Integer.valueOf(zzfjjVar.m8636h());
                    break;
                case 18:
                    this.f7621b = zzfjjVar.m8632e();
                    break;
                case 26:
                    int iM8719a = zzfjv.m8719a(zzfjjVar, 26);
                    int length = this.f7622c == null ? 0 : this.f7622c.length;
                    zzclt[] zzcltVarArr = new zzclt[iM8719a + length];
                    if (length != 0) {
                        System.arraycopy(this.f7622c, 0, zzcltVarArr, 0, length);
                    }
                    while (length < zzcltVarArr.length - 1) {
                        zzcltVarArr[length] = new zzclt();
                        zzfjjVar.m8623a(zzcltVarArr[length]);
                        zzfjjVar.m8621a();
                        length++;
                    }
                    zzcltVarArr[length] = new zzclt();
                    zzfjjVar.m8623a(zzcltVarArr[length]);
                    this.f7622c = zzcltVarArr;
                    break;
                case 32:
                    this.f7624f = Boolean.valueOf(zzfjjVar.m8631d());
                    break;
                case 42:
                    if (this.f7623d == null) {
                        this.f7623d = new zzclu();
                    }
                    zzfjjVar.m8623a(this.f7623d);
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
        if (this.f7620a != null) {
            zzfjkVar.m8667a(1, this.f7620a.intValue());
        }
        if (this.f7621b != null) {
            zzfjkVar.m8670a(2, this.f7621b);
        }
        if (this.f7622c != null && this.f7622c.length > 0) {
            for (int i = 0; i < this.f7622c.length; i++) {
                zzclt zzcltVar = this.f7622c[i];
                if (zzcltVar != null) {
                    zzfjkVar.m8669a(3, zzcltVar);
                }
            }
        }
        if (this.f7624f != null) {
            zzfjkVar.m8671a(4, this.f7624f.booleanValue());
        }
        if (this.f7623d != null) {
            zzfjkVar.m8669a(5, this.f7623d);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7620a != null) {
            iMo8448b += zzfjk.m8651b(1, this.f7620a.intValue());
        }
        if (this.f7621b != null) {
            iMo8448b += zzfjk.m8653b(2, this.f7621b);
        }
        if (this.f7622c != null && this.f7622c.length > 0) {
            int iM8652b = iMo8448b;
            for (int i = 0; i < this.f7622c.length; i++) {
                zzclt zzcltVar = this.f7622c[i];
                if (zzcltVar != null) {
                    iM8652b += zzfjk.m8652b(3, zzcltVar);
                }
            }
            iMo8448b = iM8652b;
        }
        if (this.f7624f != null) {
            this.f7624f.booleanValue();
            iMo8448b += zzfjk.m8650b(4) + 1;
        }
        return this.f7623d != null ? iMo8448b + zzfjk.m8652b(5, this.f7623d) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcls)) {
            return false;
        }
        zzcls zzclsVar = (zzcls) obj;
        if (this.f7620a == null) {
            if (zzclsVar.f7620a != null) {
                return false;
            }
        } else if (!this.f7620a.equals(zzclsVar.f7620a)) {
            return false;
        }
        if (this.f7621b == null) {
            if (zzclsVar.f7621b != null) {
                return false;
            }
        } else if (!this.f7621b.equals(zzclsVar.f7621b)) {
            return false;
        }
        if (!zzfjq.m8703a(this.f7622c, zzclsVar.f7622c)) {
            return false;
        }
        if (this.f7624f == null) {
            if (zzclsVar.f7624f != null) {
                return false;
            }
        } else if (!this.f7624f.equals(zzclsVar.f7624f)) {
            return false;
        }
        if (this.f7623d == null) {
            if (zzclsVar.f7623d != null) {
                return false;
            }
        } else if (!this.f7623d.equals(zzclsVar.f7623d)) {
            return false;
        }
        return (this.f7951H == null || this.f7951H.m8690b()) ? zzclsVar.f7951H == null || zzclsVar.f7951H.m8690b() : this.f7951H.equals(zzclsVar.f7951H);
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = (this.f7624f == null ? 0 : this.f7624f.hashCode()) + (((((this.f7621b == null ? 0 : this.f7621b.hashCode()) + (((this.f7620a == null ? 0 : this.f7620a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + zzfjq.m8698a(this.f7622c)) * 31);
        zzclu zzcluVar = this.f7623d;
        int iHashCode3 = ((zzcluVar == null ? 0 : zzcluVar.hashCode()) + (iHashCode2 * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode3 + iHashCode;
    }
}
