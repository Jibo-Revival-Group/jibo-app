package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzewy extends zzfjm<zzewy> {

    /* JADX INFO: renamed from: g */
    private static volatile zzewy[] f7925g;

    /* JADX INFO: renamed from: a */
    public String f7926a = null;

    /* JADX INFO: renamed from: h */
    private Boolean f7932h = null;

    /* JADX INFO: renamed from: b */
    public Long f7927b = null;

    /* JADX INFO: renamed from: c */
    public Long f7928c = null;

    /* JADX INFO: renamed from: d */
    public zzewz[] f7929d = zzewz.m8613a();

    /* JADX INFO: renamed from: e */
    public zzewy[] f7930e = m8612a();

    /* JADX INFO: renamed from: f */
    public zzexa[] f7931f = zzexa.m8615a();

    public zzewy() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    private static zzewy[] m8612a() {
        if (f7925g == null) {
            synchronized (zzfjq.f7965b) {
                if (f7925g == null) {
                    f7925g = new zzewy[0];
                }
            }
        }
        return f7925g;
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
                    this.f7926a = zzfjjVar.m8632e();
                    break;
                case 16:
                    this.f7932h = Boolean.valueOf(zzfjjVar.m8631d());
                    break;
                case 32:
                    this.f7927b = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 40:
                    this.f7928c = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 50:
                    int iM8719a = zzfjv.m8719a(zzfjjVar, 50);
                    int length = this.f7929d == null ? 0 : this.f7929d.length;
                    zzewz[] zzewzVarArr = new zzewz[iM8719a + length];
                    if (length != 0) {
                        System.arraycopy(this.f7929d, 0, zzewzVarArr, 0, length);
                    }
                    while (length < zzewzVarArr.length - 1) {
                        zzewzVarArr[length] = new zzewz();
                        zzfjjVar.m8623a(zzewzVarArr[length]);
                        zzfjjVar.m8621a();
                        length++;
                    }
                    zzewzVarArr[length] = new zzewz();
                    zzfjjVar.m8623a(zzewzVarArr[length]);
                    this.f7929d = zzewzVarArr;
                    break;
                case 58:
                    int iM8719a2 = zzfjv.m8719a(zzfjjVar, 58);
                    int length2 = this.f7930e == null ? 0 : this.f7930e.length;
                    zzewy[] zzewyVarArr = new zzewy[iM8719a2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.f7930e, 0, zzewyVarArr, 0, length2);
                    }
                    while (length2 < zzewyVarArr.length - 1) {
                        zzewyVarArr[length2] = new zzewy();
                        zzfjjVar.m8623a(zzewyVarArr[length2]);
                        zzfjjVar.m8621a();
                        length2++;
                    }
                    zzewyVarArr[length2] = new zzewy();
                    zzfjjVar.m8623a(zzewyVarArr[length2]);
                    this.f7930e = zzewyVarArr;
                    break;
                case 66:
                    int iM8719a3 = zzfjv.m8719a(zzfjjVar, 66);
                    int length3 = this.f7931f == null ? 0 : this.f7931f.length;
                    zzexa[] zzexaVarArr = new zzexa[iM8719a3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.f7931f, 0, zzexaVarArr, 0, length3);
                    }
                    while (length3 < zzexaVarArr.length - 1) {
                        zzexaVarArr[length3] = new zzexa();
                        zzfjjVar.m8623a(zzexaVarArr[length3]);
                        zzfjjVar.m8621a();
                        length3++;
                    }
                    zzexaVarArr[length3] = new zzexa();
                    zzfjjVar.m8623a(zzexaVarArr[length3]);
                    this.f7931f = zzexaVarArr;
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
        if (this.f7926a != null) {
            zzfjkVar.m8670a(1, this.f7926a);
        }
        if (this.f7932h != null) {
            zzfjkVar.m8671a(2, this.f7932h.booleanValue());
        }
        if (this.f7927b != null) {
            zzfjkVar.m8674b(4, this.f7927b.longValue());
        }
        if (this.f7928c != null) {
            zzfjkVar.m8674b(5, this.f7928c.longValue());
        }
        if (this.f7929d != null && this.f7929d.length > 0) {
            for (int i = 0; i < this.f7929d.length; i++) {
                zzewz zzewzVar = this.f7929d[i];
                if (zzewzVar != null) {
                    zzfjkVar.m8669a(6, zzewzVar);
                }
            }
        }
        if (this.f7930e != null && this.f7930e.length > 0) {
            for (int i2 = 0; i2 < this.f7930e.length; i2++) {
                zzewy zzewyVar = this.f7930e[i2];
                if (zzewyVar != null) {
                    zzfjkVar.m8669a(7, zzewyVar);
                }
            }
        }
        if (this.f7931f != null && this.f7931f.length > 0) {
            for (int i3 = 0; i3 < this.f7931f.length; i3++) {
                zzexa zzexaVar = this.f7931f[i3];
                if (zzexaVar != null) {
                    zzfjkVar.m8669a(8, zzexaVar);
                }
            }
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7926a != null) {
            iMo8448b += zzfjk.m8653b(1, this.f7926a);
        }
        if (this.f7932h != null) {
            this.f7932h.booleanValue();
            iMo8448b += zzfjk.m8650b(2) + 1;
        }
        if (this.f7927b != null) {
            iMo8448b += zzfjk.m8660d(4, this.f7927b.longValue());
        }
        if (this.f7928c != null) {
            iMo8448b += zzfjk.m8660d(5, this.f7928c.longValue());
        }
        if (this.f7929d != null && this.f7929d.length > 0) {
            int iM8652b = iMo8448b;
            for (int i = 0; i < this.f7929d.length; i++) {
                zzewz zzewzVar = this.f7929d[i];
                if (zzewzVar != null) {
                    iM8652b += zzfjk.m8652b(6, zzewzVar);
                }
            }
            iMo8448b = iM8652b;
        }
        if (this.f7930e != null && this.f7930e.length > 0) {
            int iM8652b2 = iMo8448b;
            for (int i2 = 0; i2 < this.f7930e.length; i2++) {
                zzewy zzewyVar = this.f7930e[i2];
                if (zzewyVar != null) {
                    iM8652b2 += zzfjk.m8652b(7, zzewyVar);
                }
            }
            iMo8448b = iM8652b2;
        }
        if (this.f7931f != null && this.f7931f.length > 0) {
            for (int i3 = 0; i3 < this.f7931f.length; i3++) {
                zzexa zzexaVar = this.f7931f[i3];
                if (zzexaVar != null) {
                    iMo8448b += zzfjk.m8652b(8, zzexaVar);
                }
            }
        }
        return iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzewy)) {
            return false;
        }
        zzewy zzewyVar = (zzewy) obj;
        if (this.f7926a == null) {
            if (zzewyVar.f7926a != null) {
                return false;
            }
        } else if (!this.f7926a.equals(zzewyVar.f7926a)) {
            return false;
        }
        if (this.f7932h == null) {
            if (zzewyVar.f7932h != null) {
                return false;
            }
        } else if (!this.f7932h.equals(zzewyVar.f7932h)) {
            return false;
        }
        if (this.f7927b == null) {
            if (zzewyVar.f7927b != null) {
                return false;
            }
        } else if (!this.f7927b.equals(zzewyVar.f7927b)) {
            return false;
        }
        if (this.f7928c == null) {
            if (zzewyVar.f7928c != null) {
                return false;
            }
        } else if (!this.f7928c.equals(zzewyVar.f7928c)) {
            return false;
        }
        if (zzfjq.m8703a(this.f7929d, zzewyVar.f7929d) && zzfjq.m8703a(this.f7930e, zzewyVar.f7930e) && zzfjq.m8703a(this.f7931f, zzewyVar.f7931f)) {
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzewyVar.f7951H == null || zzewyVar.f7951H.m8690b() : this.f7951H.equals(zzewyVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((((((((this.f7928c == null ? 0 : this.f7928c.hashCode()) + (((this.f7927b == null ? 0 : this.f7927b.hashCode()) + (((this.f7932h == null ? 0 : this.f7932h.hashCode()) + (((this.f7926a == null ? 0 : this.f7926a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31) + zzfjq.m8698a(this.f7929d)) * 31) + zzfjq.m8698a(this.f7930e)) * 31) + zzfjq.m8698a(this.f7931f)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
