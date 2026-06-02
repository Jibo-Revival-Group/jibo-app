package com.google.android.gms.internal;

import java.io.IOException;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public final class zzcme extends zzfjm<zzcme> {

    /* JADX INFO: renamed from: J */
    private static volatile zzcme[] f7675J;

    /* JADX INFO: renamed from: a */
    public Integer f7685a = null;

    /* JADX INFO: renamed from: b */
    public zzcmb[] f7686b = zzcmb.m8457a();

    /* JADX INFO: renamed from: c */
    public zzcmg[] f7687c = zzcmg.m8460a();

    /* JADX INFO: renamed from: d */
    public Long f7688d = null;

    /* JADX INFO: renamed from: e */
    public Long f7689e = null;

    /* JADX INFO: renamed from: f */
    public Long f7690f = null;

    /* JADX INFO: renamed from: g */
    public Long f7691g = null;

    /* JADX INFO: renamed from: h */
    public Long f7692h = null;

    /* JADX INFO: renamed from: i */
    public String f7693i = null;

    /* JADX INFO: renamed from: j */
    public String f7694j = null;

    /* JADX INFO: renamed from: k */
    public String f7695k = null;

    /* JADX INFO: renamed from: l */
    public String f7696l = null;

    /* JADX INFO: renamed from: m */
    public Integer f7697m = null;

    /* JADX INFO: renamed from: n */
    public String f7698n = null;

    /* JADX INFO: renamed from: o */
    public String f7699o = null;

    /* JADX INFO: renamed from: p */
    public String f7700p = null;

    /* JADX INFO: renamed from: q */
    public Long f7701q = null;

    /* JADX INFO: renamed from: r */
    public Long f7702r = null;

    /* JADX INFO: renamed from: s */
    public String f7703s = null;

    /* JADX INFO: renamed from: t */
    public Boolean f7704t = null;

    /* JADX INFO: renamed from: u */
    public String f7705u = null;

    /* JADX INFO: renamed from: v */
    public Long f7706v = null;

    /* JADX INFO: renamed from: w */
    public Integer f7707w = null;

    /* JADX INFO: renamed from: x */
    public String f7708x = null;

    /* JADX INFO: renamed from: y */
    public String f7709y = null;

    /* JADX INFO: renamed from: z */
    public Boolean f7710z = null;

    /* JADX INFO: renamed from: A */
    public zzcma[] f7676A = zzcma.m8456a();

    /* JADX INFO: renamed from: B */
    public String f7677B = null;

    /* JADX INFO: renamed from: C */
    public Integer f7678C = null;

    /* JADX INFO: renamed from: K */
    private Integer f7683K = null;

    /* JADX INFO: renamed from: L */
    private Integer f7684L = null;

    /* JADX INFO: renamed from: D */
    public String f7679D = null;

    /* JADX INFO: renamed from: E */
    public Long f7680E = null;

    /* JADX INFO: renamed from: F */
    public Long f7681F = null;

    /* JADX INFO: renamed from: G */
    public String f7682G = null;

    public zzcme() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: renamed from: a */
    public static zzcme[] m8459a() {
        if (f7675J == null) {
            synchronized (zzfjq.f7965b) {
                if (f7675J == null) {
                    f7675J = new zzcme[0];
                }
            }
        }
        return f7675J;
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
                    this.f7685a = Integer.valueOf(zzfjjVar.m8636h());
                    break;
                case 18:
                    int iM8719a = zzfjv.m8719a(zzfjjVar, 18);
                    int length = this.f7686b == null ? 0 : this.f7686b.length;
                    zzcmb[] zzcmbVarArr = new zzcmb[iM8719a + length];
                    if (length != 0) {
                        System.arraycopy(this.f7686b, 0, zzcmbVarArr, 0, length);
                    }
                    while (length < zzcmbVarArr.length - 1) {
                        zzcmbVarArr[length] = new zzcmb();
                        zzfjjVar.m8623a(zzcmbVarArr[length]);
                        zzfjjVar.m8621a();
                        length++;
                    }
                    zzcmbVarArr[length] = new zzcmb();
                    zzfjjVar.m8623a(zzcmbVarArr[length]);
                    this.f7686b = zzcmbVarArr;
                    break;
                case 26:
                    int iM8719a2 = zzfjv.m8719a(zzfjjVar, 26);
                    int length2 = this.f7687c == null ? 0 : this.f7687c.length;
                    zzcmg[] zzcmgVarArr = new zzcmg[iM8719a2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.f7687c, 0, zzcmgVarArr, 0, length2);
                    }
                    while (length2 < zzcmgVarArr.length - 1) {
                        zzcmgVarArr[length2] = new zzcmg();
                        zzfjjVar.m8623a(zzcmgVarArr[length2]);
                        zzfjjVar.m8621a();
                        length2++;
                    }
                    zzcmgVarArr[length2] = new zzcmg();
                    zzfjjVar.m8623a(zzcmgVarArr[length2]);
                    this.f7687c = zzcmgVarArr;
                    break;
                case 32:
                    this.f7688d = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 40:
                    this.f7689e = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 48:
                    this.f7690f = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 56:
                    this.f7692h = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 66:
                    this.f7693i = zzfjjVar.m8632e();
                    break;
                case 74:
                    this.f7694j = zzfjjVar.m8632e();
                    break;
                case 82:
                    this.f7695k = zzfjjVar.m8632e();
                    break;
                case 90:
                    this.f7696l = zzfjjVar.m8632e();
                    break;
                case 96:
                    this.f7697m = Integer.valueOf(zzfjjVar.m8636h());
                    break;
                case 106:
                    this.f7698n = zzfjjVar.m8632e();
                    break;
                case 114:
                    this.f7699o = zzfjjVar.m8632e();
                    break;
                case 130:
                    this.f7700p = zzfjjVar.m8632e();
                    break;
                case 136:
                    this.f7701q = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 144:
                    this.f7702r = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 154:
                    this.f7703s = zzfjjVar.m8632e();
                    break;
                case 160:
                    this.f7704t = Boolean.valueOf(zzfjjVar.m8631d());
                    break;
                case 170:
                    this.f7705u = zzfjjVar.m8632e();
                    break;
                case 176:
                    this.f7706v = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 184:
                    this.f7707w = Integer.valueOf(zzfjjVar.m8636h());
                    break;
                case 194:
                    this.f7708x = zzfjjVar.m8632e();
                    break;
                case HttpStatus.SC_ACCEPTED /* 202 */:
                    this.f7709y = zzfjjVar.m8632e();
                    break;
                case 208:
                    this.f7691g = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 224:
                    this.f7710z = Boolean.valueOf(zzfjjVar.m8631d());
                    break;
                case 234:
                    int iM8719a3 = zzfjv.m8719a(zzfjjVar, 234);
                    int length3 = this.f7676A == null ? 0 : this.f7676A.length;
                    zzcma[] zzcmaVarArr = new zzcma[iM8719a3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.f7676A, 0, zzcmaVarArr, 0, length3);
                    }
                    while (length3 < zzcmaVarArr.length - 1) {
                        zzcmaVarArr[length3] = new zzcma();
                        zzfjjVar.m8623a(zzcmaVarArr[length3]);
                        zzfjjVar.m8621a();
                        length3++;
                    }
                    zzcmaVarArr[length3] = new zzcma();
                    zzfjjVar.m8623a(zzcmaVarArr[length3]);
                    this.f7676A = zzcmaVarArr;
                    break;
                case 242:
                    this.f7677B = zzfjjVar.m8632e();
                    break;
                case 248:
                    this.f7678C = Integer.valueOf(zzfjjVar.m8636h());
                    break;
                case 256:
                    this.f7683K = Integer.valueOf(zzfjjVar.m8636h());
                    break;
                case 264:
                    this.f7684L = Integer.valueOf(zzfjjVar.m8636h());
                    break;
                case 274:
                    this.f7679D = zzfjjVar.m8632e();
                    break;
                case 280:
                    this.f7680E = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 288:
                    this.f7681F = Long.valueOf(zzfjjVar.m8637i());
                    break;
                case 298:
                    this.f7682G = zzfjjVar.m8632e();
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
        if (this.f7685a != null) {
            zzfjkVar.m8667a(1, this.f7685a.intValue());
        }
        if (this.f7686b != null && this.f7686b.length > 0) {
            for (int i = 0; i < this.f7686b.length; i++) {
                zzcmb zzcmbVar = this.f7686b[i];
                if (zzcmbVar != null) {
                    zzfjkVar.m8669a(2, zzcmbVar);
                }
            }
        }
        if (this.f7687c != null && this.f7687c.length > 0) {
            for (int i2 = 0; i2 < this.f7687c.length; i2++) {
                zzcmg zzcmgVar = this.f7687c[i2];
                if (zzcmgVar != null) {
                    zzfjkVar.m8669a(3, zzcmgVar);
                }
            }
        }
        if (this.f7688d != null) {
            zzfjkVar.m8674b(4, this.f7688d.longValue());
        }
        if (this.f7689e != null) {
            zzfjkVar.m8674b(5, this.f7689e.longValue());
        }
        if (this.f7690f != null) {
            zzfjkVar.m8674b(6, this.f7690f.longValue());
        }
        if (this.f7692h != null) {
            zzfjkVar.m8674b(7, this.f7692h.longValue());
        }
        if (this.f7693i != null) {
            zzfjkVar.m8670a(8, this.f7693i);
        }
        if (this.f7694j != null) {
            zzfjkVar.m8670a(9, this.f7694j);
        }
        if (this.f7695k != null) {
            zzfjkVar.m8670a(10, this.f7695k);
        }
        if (this.f7696l != null) {
            zzfjkVar.m8670a(11, this.f7696l);
        }
        if (this.f7697m != null) {
            zzfjkVar.m8667a(12, this.f7697m.intValue());
        }
        if (this.f7698n != null) {
            zzfjkVar.m8670a(13, this.f7698n);
        }
        if (this.f7699o != null) {
            zzfjkVar.m8670a(14, this.f7699o);
        }
        if (this.f7700p != null) {
            zzfjkVar.m8670a(16, this.f7700p);
        }
        if (this.f7701q != null) {
            zzfjkVar.m8674b(17, this.f7701q.longValue());
        }
        if (this.f7702r != null) {
            zzfjkVar.m8674b(18, this.f7702r.longValue());
        }
        if (this.f7703s != null) {
            zzfjkVar.m8670a(19, this.f7703s);
        }
        if (this.f7704t != null) {
            zzfjkVar.m8671a(20, this.f7704t.booleanValue());
        }
        if (this.f7705u != null) {
            zzfjkVar.m8670a(21, this.f7705u);
        }
        if (this.f7706v != null) {
            zzfjkVar.m8674b(22, this.f7706v.longValue());
        }
        if (this.f7707w != null) {
            zzfjkVar.m8667a(23, this.f7707w.intValue());
        }
        if (this.f7708x != null) {
            zzfjkVar.m8670a(24, this.f7708x);
        }
        if (this.f7709y != null) {
            zzfjkVar.m8670a(25, this.f7709y);
        }
        if (this.f7691g != null) {
            zzfjkVar.m8674b(26, this.f7691g.longValue());
        }
        if (this.f7710z != null) {
            zzfjkVar.m8671a(28, this.f7710z.booleanValue());
        }
        if (this.f7676A != null && this.f7676A.length > 0) {
            for (int i3 = 0; i3 < this.f7676A.length; i3++) {
                zzcma zzcmaVar = this.f7676A[i3];
                if (zzcmaVar != null) {
                    zzfjkVar.m8669a(29, zzcmaVar);
                }
            }
        }
        if (this.f7677B != null) {
            zzfjkVar.m8670a(30, this.f7677B);
        }
        if (this.f7678C != null) {
            zzfjkVar.m8667a(31, this.f7678C.intValue());
        }
        if (this.f7683K != null) {
            zzfjkVar.m8667a(32, this.f7683K.intValue());
        }
        if (this.f7684L != null) {
            zzfjkVar.m8667a(33, this.f7684L.intValue());
        }
        if (this.f7679D != null) {
            zzfjkVar.m8670a(34, this.f7679D);
        }
        if (this.f7680E != null) {
            zzfjkVar.m8674b(35, this.f7680E.longValue());
        }
        if (this.f7681F != null) {
            zzfjkVar.m8674b(36, this.f7681F.longValue());
        }
        if (this.f7682G != null) {
            zzfjkVar.m8670a(37, this.f7682G);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7685a != null) {
            iMo8448b += zzfjk.m8651b(1, this.f7685a.intValue());
        }
        if (this.f7686b != null && this.f7686b.length > 0) {
            int iM8652b = iMo8448b;
            for (int i = 0; i < this.f7686b.length; i++) {
                zzcmb zzcmbVar = this.f7686b[i];
                if (zzcmbVar != null) {
                    iM8652b += zzfjk.m8652b(2, zzcmbVar);
                }
            }
            iMo8448b = iM8652b;
        }
        if (this.f7687c != null && this.f7687c.length > 0) {
            int iM8652b2 = iMo8448b;
            for (int i2 = 0; i2 < this.f7687c.length; i2++) {
                zzcmg zzcmgVar = this.f7687c[i2];
                if (zzcmgVar != null) {
                    iM8652b2 += zzfjk.m8652b(3, zzcmgVar);
                }
            }
            iMo8448b = iM8652b2;
        }
        if (this.f7688d != null) {
            iMo8448b += zzfjk.m8660d(4, this.f7688d.longValue());
        }
        if (this.f7689e != null) {
            iMo8448b += zzfjk.m8660d(5, this.f7689e.longValue());
        }
        if (this.f7690f != null) {
            iMo8448b += zzfjk.m8660d(6, this.f7690f.longValue());
        }
        if (this.f7692h != null) {
            iMo8448b += zzfjk.m8660d(7, this.f7692h.longValue());
        }
        if (this.f7693i != null) {
            iMo8448b += zzfjk.m8653b(8, this.f7693i);
        }
        if (this.f7694j != null) {
            iMo8448b += zzfjk.m8653b(9, this.f7694j);
        }
        if (this.f7695k != null) {
            iMo8448b += zzfjk.m8653b(10, this.f7695k);
        }
        if (this.f7696l != null) {
            iMo8448b += zzfjk.m8653b(11, this.f7696l);
        }
        if (this.f7697m != null) {
            iMo8448b += zzfjk.m8651b(12, this.f7697m.intValue());
        }
        if (this.f7698n != null) {
            iMo8448b += zzfjk.m8653b(13, this.f7698n);
        }
        if (this.f7699o != null) {
            iMo8448b += zzfjk.m8653b(14, this.f7699o);
        }
        if (this.f7700p != null) {
            iMo8448b += zzfjk.m8653b(16, this.f7700p);
        }
        if (this.f7701q != null) {
            iMo8448b += zzfjk.m8660d(17, this.f7701q.longValue());
        }
        if (this.f7702r != null) {
            iMo8448b += zzfjk.m8660d(18, this.f7702r.longValue());
        }
        if (this.f7703s != null) {
            iMo8448b += zzfjk.m8653b(19, this.f7703s);
        }
        if (this.f7704t != null) {
            this.f7704t.booleanValue();
            iMo8448b += zzfjk.m8650b(20) + 1;
        }
        if (this.f7705u != null) {
            iMo8448b += zzfjk.m8653b(21, this.f7705u);
        }
        if (this.f7706v != null) {
            iMo8448b += zzfjk.m8660d(22, this.f7706v.longValue());
        }
        if (this.f7707w != null) {
            iMo8448b += zzfjk.m8651b(23, this.f7707w.intValue());
        }
        if (this.f7708x != null) {
            iMo8448b += zzfjk.m8653b(24, this.f7708x);
        }
        if (this.f7709y != null) {
            iMo8448b += zzfjk.m8653b(25, this.f7709y);
        }
        if (this.f7691g != null) {
            iMo8448b += zzfjk.m8660d(26, this.f7691g.longValue());
        }
        if (this.f7710z != null) {
            this.f7710z.booleanValue();
            iMo8448b += zzfjk.m8650b(28) + 1;
        }
        if (this.f7676A != null && this.f7676A.length > 0) {
            for (int i3 = 0; i3 < this.f7676A.length; i3++) {
                zzcma zzcmaVar = this.f7676A[i3];
                if (zzcmaVar != null) {
                    iMo8448b += zzfjk.m8652b(29, zzcmaVar);
                }
            }
        }
        if (this.f7677B != null) {
            iMo8448b += zzfjk.m8653b(30, this.f7677B);
        }
        if (this.f7678C != null) {
            iMo8448b += zzfjk.m8651b(31, this.f7678C.intValue());
        }
        if (this.f7683K != null) {
            iMo8448b += zzfjk.m8651b(32, this.f7683K.intValue());
        }
        if (this.f7684L != null) {
            iMo8448b += zzfjk.m8651b(33, this.f7684L.intValue());
        }
        if (this.f7679D != null) {
            iMo8448b += zzfjk.m8653b(34, this.f7679D);
        }
        if (this.f7680E != null) {
            iMo8448b += zzfjk.m8660d(35, this.f7680E.longValue());
        }
        if (this.f7681F != null) {
            iMo8448b += zzfjk.m8660d(36, this.f7681F.longValue());
        }
        return this.f7682G != null ? iMo8448b + zzfjk.m8653b(37, this.f7682G) : iMo8448b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcme)) {
            return false;
        }
        zzcme zzcmeVar = (zzcme) obj;
        if (this.f7685a == null) {
            if (zzcmeVar.f7685a != null) {
                return false;
            }
        } else if (!this.f7685a.equals(zzcmeVar.f7685a)) {
            return false;
        }
        if (zzfjq.m8703a(this.f7686b, zzcmeVar.f7686b) && zzfjq.m8703a(this.f7687c, zzcmeVar.f7687c)) {
            if (this.f7688d == null) {
                if (zzcmeVar.f7688d != null) {
                    return false;
                }
            } else if (!this.f7688d.equals(zzcmeVar.f7688d)) {
                return false;
            }
            if (this.f7689e == null) {
                if (zzcmeVar.f7689e != null) {
                    return false;
                }
            } else if (!this.f7689e.equals(zzcmeVar.f7689e)) {
                return false;
            }
            if (this.f7690f == null) {
                if (zzcmeVar.f7690f != null) {
                    return false;
                }
            } else if (!this.f7690f.equals(zzcmeVar.f7690f)) {
                return false;
            }
            if (this.f7691g == null) {
                if (zzcmeVar.f7691g != null) {
                    return false;
                }
            } else if (!this.f7691g.equals(zzcmeVar.f7691g)) {
                return false;
            }
            if (this.f7692h == null) {
                if (zzcmeVar.f7692h != null) {
                    return false;
                }
            } else if (!this.f7692h.equals(zzcmeVar.f7692h)) {
                return false;
            }
            if (this.f7693i == null) {
                if (zzcmeVar.f7693i != null) {
                    return false;
                }
            } else if (!this.f7693i.equals(zzcmeVar.f7693i)) {
                return false;
            }
            if (this.f7694j == null) {
                if (zzcmeVar.f7694j != null) {
                    return false;
                }
            } else if (!this.f7694j.equals(zzcmeVar.f7694j)) {
                return false;
            }
            if (this.f7695k == null) {
                if (zzcmeVar.f7695k != null) {
                    return false;
                }
            } else if (!this.f7695k.equals(zzcmeVar.f7695k)) {
                return false;
            }
            if (this.f7696l == null) {
                if (zzcmeVar.f7696l != null) {
                    return false;
                }
            } else if (!this.f7696l.equals(zzcmeVar.f7696l)) {
                return false;
            }
            if (this.f7697m == null) {
                if (zzcmeVar.f7697m != null) {
                    return false;
                }
            } else if (!this.f7697m.equals(zzcmeVar.f7697m)) {
                return false;
            }
            if (this.f7698n == null) {
                if (zzcmeVar.f7698n != null) {
                    return false;
                }
            } else if (!this.f7698n.equals(zzcmeVar.f7698n)) {
                return false;
            }
            if (this.f7699o == null) {
                if (zzcmeVar.f7699o != null) {
                    return false;
                }
            } else if (!this.f7699o.equals(zzcmeVar.f7699o)) {
                return false;
            }
            if (this.f7700p == null) {
                if (zzcmeVar.f7700p != null) {
                    return false;
                }
            } else if (!this.f7700p.equals(zzcmeVar.f7700p)) {
                return false;
            }
            if (this.f7701q == null) {
                if (zzcmeVar.f7701q != null) {
                    return false;
                }
            } else if (!this.f7701q.equals(zzcmeVar.f7701q)) {
                return false;
            }
            if (this.f7702r == null) {
                if (zzcmeVar.f7702r != null) {
                    return false;
                }
            } else if (!this.f7702r.equals(zzcmeVar.f7702r)) {
                return false;
            }
            if (this.f7703s == null) {
                if (zzcmeVar.f7703s != null) {
                    return false;
                }
            } else if (!this.f7703s.equals(zzcmeVar.f7703s)) {
                return false;
            }
            if (this.f7704t == null) {
                if (zzcmeVar.f7704t != null) {
                    return false;
                }
            } else if (!this.f7704t.equals(zzcmeVar.f7704t)) {
                return false;
            }
            if (this.f7705u == null) {
                if (zzcmeVar.f7705u != null) {
                    return false;
                }
            } else if (!this.f7705u.equals(zzcmeVar.f7705u)) {
                return false;
            }
            if (this.f7706v == null) {
                if (zzcmeVar.f7706v != null) {
                    return false;
                }
            } else if (!this.f7706v.equals(zzcmeVar.f7706v)) {
                return false;
            }
            if (this.f7707w == null) {
                if (zzcmeVar.f7707w != null) {
                    return false;
                }
            } else if (!this.f7707w.equals(zzcmeVar.f7707w)) {
                return false;
            }
            if (this.f7708x == null) {
                if (zzcmeVar.f7708x != null) {
                    return false;
                }
            } else if (!this.f7708x.equals(zzcmeVar.f7708x)) {
                return false;
            }
            if (this.f7709y == null) {
                if (zzcmeVar.f7709y != null) {
                    return false;
                }
            } else if (!this.f7709y.equals(zzcmeVar.f7709y)) {
                return false;
            }
            if (this.f7710z == null) {
                if (zzcmeVar.f7710z != null) {
                    return false;
                }
            } else if (!this.f7710z.equals(zzcmeVar.f7710z)) {
                return false;
            }
            if (!zzfjq.m8703a(this.f7676A, zzcmeVar.f7676A)) {
                return false;
            }
            if (this.f7677B == null) {
                if (zzcmeVar.f7677B != null) {
                    return false;
                }
            } else if (!this.f7677B.equals(zzcmeVar.f7677B)) {
                return false;
            }
            if (this.f7678C == null) {
                if (zzcmeVar.f7678C != null) {
                    return false;
                }
            } else if (!this.f7678C.equals(zzcmeVar.f7678C)) {
                return false;
            }
            if (this.f7683K == null) {
                if (zzcmeVar.f7683K != null) {
                    return false;
                }
            } else if (!this.f7683K.equals(zzcmeVar.f7683K)) {
                return false;
            }
            if (this.f7684L == null) {
                if (zzcmeVar.f7684L != null) {
                    return false;
                }
            } else if (!this.f7684L.equals(zzcmeVar.f7684L)) {
                return false;
            }
            if (this.f7679D == null) {
                if (zzcmeVar.f7679D != null) {
                    return false;
                }
            } else if (!this.f7679D.equals(zzcmeVar.f7679D)) {
                return false;
            }
            if (this.f7680E == null) {
                if (zzcmeVar.f7680E != null) {
                    return false;
                }
            } else if (!this.f7680E.equals(zzcmeVar.f7680E)) {
                return false;
            }
            if (this.f7681F == null) {
                if (zzcmeVar.f7681F != null) {
                    return false;
                }
            } else if (!this.f7681F.equals(zzcmeVar.f7681F)) {
                return false;
            }
            if (this.f7682G == null) {
                if (zzcmeVar.f7682G != null) {
                    return false;
                }
            } else if (!this.f7682G.equals(zzcmeVar.f7682G)) {
                return false;
            }
            return (this.f7951H == null || this.f7951H.m8690b()) ? zzcmeVar.f7951H == null || zzcmeVar.f7951H.m8690b() : this.f7951H.equals(zzcmeVar.f7951H);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = ((this.f7682G == null ? 0 : this.f7682G.hashCode()) + (((this.f7681F == null ? 0 : this.f7681F.hashCode()) + (((this.f7680E == null ? 0 : this.f7680E.hashCode()) + (((this.f7679D == null ? 0 : this.f7679D.hashCode()) + (((this.f7684L == null ? 0 : this.f7684L.hashCode()) + (((this.f7683K == null ? 0 : this.f7683K.hashCode()) + (((this.f7678C == null ? 0 : this.f7678C.hashCode()) + (((this.f7677B == null ? 0 : this.f7677B.hashCode()) + (((((this.f7710z == null ? 0 : this.f7710z.hashCode()) + (((this.f7709y == null ? 0 : this.f7709y.hashCode()) + (((this.f7708x == null ? 0 : this.f7708x.hashCode()) + (((this.f7707w == null ? 0 : this.f7707w.hashCode()) + (((this.f7706v == null ? 0 : this.f7706v.hashCode()) + (((this.f7705u == null ? 0 : this.f7705u.hashCode()) + (((this.f7704t == null ? 0 : this.f7704t.hashCode()) + (((this.f7703s == null ? 0 : this.f7703s.hashCode()) + (((this.f7702r == null ? 0 : this.f7702r.hashCode()) + (((this.f7701q == null ? 0 : this.f7701q.hashCode()) + (((this.f7700p == null ? 0 : this.f7700p.hashCode()) + (((this.f7699o == null ? 0 : this.f7699o.hashCode()) + (((this.f7698n == null ? 0 : this.f7698n.hashCode()) + (((this.f7697m == null ? 0 : this.f7697m.hashCode()) + (((this.f7696l == null ? 0 : this.f7696l.hashCode()) + (((this.f7695k == null ? 0 : this.f7695k.hashCode()) + (((this.f7694j == null ? 0 : this.f7694j.hashCode()) + (((this.f7693i == null ? 0 : this.f7693i.hashCode()) + (((this.f7692h == null ? 0 : this.f7692h.hashCode()) + (((this.f7691g == null ? 0 : this.f7691g.hashCode()) + (((this.f7690f == null ? 0 : this.f7690f.hashCode()) + (((this.f7689e == null ? 0 : this.f7689e.hashCode()) + (((this.f7688d == null ? 0 : this.f7688d.hashCode()) + (((((((this.f7685a == null ? 0 : this.f7685a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzfjq.m8698a(this.f7686b)) * 31) + zzfjq.m8698a(this.f7687c)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + zzfjq.m8698a(this.f7676A)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode2 + iHashCode;
    }
}
