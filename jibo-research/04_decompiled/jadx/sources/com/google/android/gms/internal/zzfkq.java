package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkq extends zzfjm<zzfkq> implements Cloneable {

    /* JADX INFO: renamed from: a */
    public long f7994a = 0;

    /* JADX INFO: renamed from: b */
    public long f7995b = 0;

    /* JADX INFO: renamed from: f */
    private long f7999f = 0;

    /* JADX INFO: renamed from: g */
    private String f8000g = "";

    /* JADX INFO: renamed from: h */
    private int f8001h = 0;

    /* JADX INFO: renamed from: i */
    private int f8002i = 0;

    /* JADX INFO: renamed from: j */
    private boolean f8003j = false;

    /* JADX INFO: renamed from: k */
    private zzfkr[] f8004k = zzfkr.m8725a();

    /* JADX INFO: renamed from: l */
    private byte[] f8005l = zzfjv.f7977h;

    /* JADX INFO: renamed from: m */
    private zzfko f8006m = null;

    /* JADX INFO: renamed from: c */
    public byte[] f7996c = zzfjv.f7977h;

    /* JADX INFO: renamed from: n */
    private String f8007n = "";

    /* JADX INFO: renamed from: o */
    private String f8008o = "";

    /* JADX INFO: renamed from: p */
    private zzfkn f8009p = null;

    /* JADX INFO: renamed from: q */
    private String f8010q = "";

    /* JADX INFO: renamed from: d */
    public long f7997d = 180000;

    /* JADX INFO: renamed from: r */
    private zzfkp f8011r = null;

    /* JADX INFO: renamed from: e */
    public byte[] f7998e = zzfjv.f7977h;

    /* JADX INFO: renamed from: s */
    private String f8012s = "";

    /* JADX INFO: renamed from: t */
    private int f8013t = 0;

    /* JADX INFO: renamed from: u */
    private int[] f8014u = zzfjv.f7970a;

    /* JADX INFO: renamed from: v */
    private long f8015v = 0;

    /* JADX INFO: renamed from: w */
    private zzfks f8016w = null;

    public zzfkq() {
        this.f7951H = null;
        this.f7967I = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzfkq clone() {
        try {
            zzfkq zzfkqVar = (zzfkq) super.clone();
            if (this.f8004k != null && this.f8004k.length > 0) {
                zzfkqVar.f8004k = new zzfkr[this.f8004k.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f8004k.length) {
                        break;
                    }
                    if (this.f8004k[i2] != null) {
                        zzfkqVar.f8004k[i2] = (zzfkr) this.f8004k[i2].clone();
                    }
                    i = i2 + 1;
                }
            }
            if (this.f8006m != null) {
                zzfkqVar.f8006m = (zzfko) this.f8006m.clone();
            }
            if (this.f8009p != null) {
                zzfkqVar.f8009p = (zzfkn) this.f8009p.clone();
            }
            if (this.f8011r != null) {
                zzfkqVar.f8011r = (zzfkp) this.f8011r.clone();
            }
            if (this.f8014u != null && this.f8014u.length > 0) {
                zzfkqVar.f8014u = (int[]) this.f8014u.clone();
            }
            if (this.f8016w != null) {
                zzfkqVar.f8016w = (zzfks) this.f8016w.clone();
            }
            return zzfkqVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        return r7;
     */
    @Override // com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.zzfkq mo8446a(com.google.android.gms.internal.zzfjj r8) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfkq.mo8446a(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzfkq");
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: a */
    public final void mo8447a(zzfjk zzfjkVar) throws IOException {
        if (this.f7994a != 0) {
            zzfjkVar.m8674b(1, this.f7994a);
        }
        if (this.f8000g != null && !this.f8000g.equals("")) {
            zzfjkVar.m8670a(2, this.f8000g);
        }
        if (this.f8004k != null && this.f8004k.length > 0) {
            for (int i = 0; i < this.f8004k.length; i++) {
                zzfkr zzfkrVar = this.f8004k[i];
                if (zzfkrVar != null) {
                    zzfjkVar.m8669a(3, zzfkrVar);
                }
            }
        }
        if (!Arrays.equals(this.f8005l, zzfjv.f7977h)) {
            zzfjkVar.m8672a(4, this.f8005l);
        }
        if (!Arrays.equals(this.f7996c, zzfjv.f7977h)) {
            zzfjkVar.m8672a(6, this.f7996c);
        }
        if (this.f8009p != null) {
            zzfjkVar.m8669a(7, this.f8009p);
        }
        if (this.f8007n != null && !this.f8007n.equals("")) {
            zzfjkVar.m8670a(8, this.f8007n);
        }
        if (this.f8006m != null) {
            zzfjkVar.m8669a(9, this.f8006m);
        }
        if (this.f8003j) {
            zzfjkVar.m8671a(10, this.f8003j);
        }
        if (this.f8001h != 0) {
            zzfjkVar.m8667a(11, this.f8001h);
        }
        if (this.f8002i != 0) {
            zzfjkVar.m8667a(12, this.f8002i);
        }
        if (this.f8008o != null && !this.f8008o.equals("")) {
            zzfjkVar.m8670a(13, this.f8008o);
        }
        if (this.f8010q != null && !this.f8010q.equals("")) {
            zzfjkVar.m8670a(14, this.f8010q);
        }
        if (this.f7997d != 180000) {
            zzfjkVar.m8677c(15, this.f7997d);
        }
        if (this.f8011r != null) {
            zzfjkVar.m8669a(16, this.f8011r);
        }
        if (this.f7995b != 0) {
            zzfjkVar.m8674b(17, this.f7995b);
        }
        if (!Arrays.equals(this.f7998e, zzfjv.f7977h)) {
            zzfjkVar.m8672a(18, this.f7998e);
        }
        if (this.f8013t != 0) {
            zzfjkVar.m8667a(19, this.f8013t);
        }
        if (this.f8014u != null && this.f8014u.length > 0) {
            for (int i2 = 0; i2 < this.f8014u.length; i2++) {
                zzfjkVar.m8667a(20, this.f8014u[i2]);
            }
        }
        if (this.f7999f != 0) {
            zzfjkVar.m8674b(21, this.f7999f);
        }
        if (this.f8015v != 0) {
            zzfjkVar.m8674b(22, this.f8015v);
        }
        if (this.f8016w != null) {
            zzfjkVar.m8669a(23, this.f8016w);
        }
        if (this.f8012s != null && !this.f8012s.equals("")) {
            zzfjkVar.m8670a(24, this.f8012s);
        }
        super.mo8447a(zzfjkVar);
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: b */
    protected final int mo8448b() {
        int iMo8448b = super.mo8448b();
        if (this.f7994a != 0) {
            iMo8448b += zzfjk.m8660d(1, this.f7994a);
        }
        if (this.f8000g != null && !this.f8000g.equals("")) {
            iMo8448b += zzfjk.m8653b(2, this.f8000g);
        }
        if (this.f8004k != null && this.f8004k.length > 0) {
            int iM8652b = iMo8448b;
            for (int i = 0; i < this.f8004k.length; i++) {
                zzfkr zzfkrVar = this.f8004k[i];
                if (zzfkrVar != null) {
                    iM8652b += zzfjk.m8652b(3, zzfkrVar);
                }
            }
            iMo8448b = iM8652b;
        }
        if (!Arrays.equals(this.f8005l, zzfjv.f7977h)) {
            iMo8448b += zzfjk.m8654b(4, this.f8005l);
        }
        if (!Arrays.equals(this.f7996c, zzfjv.f7977h)) {
            iMo8448b += zzfjk.m8654b(6, this.f7996c);
        }
        if (this.f8009p != null) {
            iMo8448b += zzfjk.m8652b(7, this.f8009p);
        }
        if (this.f8007n != null && !this.f8007n.equals("")) {
            iMo8448b += zzfjk.m8653b(8, this.f8007n);
        }
        if (this.f8006m != null) {
            iMo8448b += zzfjk.m8652b(9, this.f8006m);
        }
        if (this.f8003j) {
            iMo8448b += zzfjk.m8650b(10) + 1;
        }
        if (this.f8001h != 0) {
            iMo8448b += zzfjk.m8651b(11, this.f8001h);
        }
        if (this.f8002i != 0) {
            iMo8448b += zzfjk.m8651b(12, this.f8002i);
        }
        if (this.f8008o != null && !this.f8008o.equals("")) {
            iMo8448b += zzfjk.m8653b(13, this.f8008o);
        }
        if (this.f8010q != null && !this.f8010q.equals("")) {
            iMo8448b += zzfjk.m8653b(14, this.f8010q);
        }
        if (this.f7997d != 180000) {
            iMo8448b += zzfjk.m8662e(15, this.f7997d);
        }
        if (this.f8011r != null) {
            iMo8448b += zzfjk.m8652b(16, this.f8011r);
        }
        if (this.f7995b != 0) {
            iMo8448b += zzfjk.m8660d(17, this.f7995b);
        }
        if (!Arrays.equals(this.f7998e, zzfjv.f7977h)) {
            iMo8448b += zzfjk.m8654b(18, this.f7998e);
        }
        if (this.f8013t != 0) {
            iMo8448b += zzfjk.m8651b(19, this.f8013t);
        }
        if (this.f8014u != null && this.f8014u.length > 0) {
            int iM8642a = 0;
            for (int i2 = 0; i2 < this.f8014u.length; i2++) {
                iM8642a += zzfjk.m8642a(this.f8014u[i2]);
            }
            iMo8448b = iMo8448b + iM8642a + (this.f8014u.length * 2);
        }
        if (this.f7999f != 0) {
            iMo8448b += zzfjk.m8660d(21, this.f7999f);
        }
        if (this.f8015v != 0) {
            iMo8448b += zzfjk.m8660d(22, this.f8015v);
        }
        if (this.f8016w != null) {
            iMo8448b += zzfjk.m8652b(23, this.f8016w);
        }
        return (this.f8012s == null || this.f8012s.equals("")) ? iMo8448b : iMo8448b + zzfjk.m8653b(24, this.f8012s);
    }

    @Override // com.google.android.gms.internal.zzfjm
    /* JADX INFO: renamed from: c */
    public final /* synthetic */ zzfjm clone() throws CloneNotSupportedException {
        return (zzfkq) clone();
    }

    @Override // com.google.android.gms.internal.zzfjm, com.google.android.gms.internal.zzfjs
    /* JADX INFO: renamed from: d */
    public final /* synthetic */ zzfjs clone() throws CloneNotSupportedException {
        return (zzfkq) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfkq)) {
            return false;
        }
        zzfkq zzfkqVar = (zzfkq) obj;
        if (this.f7994a == zzfkqVar.f7994a && this.f7995b == zzfkqVar.f7995b && this.f7999f == zzfkqVar.f7999f) {
            if (this.f8000g == null) {
                if (zzfkqVar.f8000g != null) {
                    return false;
                }
            } else if (!this.f8000g.equals(zzfkqVar.f8000g)) {
                return false;
            }
            if (this.f8001h == zzfkqVar.f8001h && this.f8002i == zzfkqVar.f8002i && this.f8003j == zzfkqVar.f8003j && zzfjq.m8703a(this.f8004k, zzfkqVar.f8004k) && Arrays.equals(this.f8005l, zzfkqVar.f8005l)) {
                if (this.f8006m == null) {
                    if (zzfkqVar.f8006m != null) {
                        return false;
                    }
                } else if (!this.f8006m.equals(zzfkqVar.f8006m)) {
                    return false;
                }
                if (!Arrays.equals(this.f7996c, zzfkqVar.f7996c)) {
                    return false;
                }
                if (this.f8007n == null) {
                    if (zzfkqVar.f8007n != null) {
                        return false;
                    }
                } else if (!this.f8007n.equals(zzfkqVar.f8007n)) {
                    return false;
                }
                if (this.f8008o == null) {
                    if (zzfkqVar.f8008o != null) {
                        return false;
                    }
                } else if (!this.f8008o.equals(zzfkqVar.f8008o)) {
                    return false;
                }
                if (this.f8009p == null) {
                    if (zzfkqVar.f8009p != null) {
                        return false;
                    }
                } else if (!this.f8009p.equals(zzfkqVar.f8009p)) {
                    return false;
                }
                if (this.f8010q == null) {
                    if (zzfkqVar.f8010q != null) {
                        return false;
                    }
                } else if (!this.f8010q.equals(zzfkqVar.f8010q)) {
                    return false;
                }
                if (this.f7997d != zzfkqVar.f7997d) {
                    return false;
                }
                if (this.f8011r == null) {
                    if (zzfkqVar.f8011r != null) {
                        return false;
                    }
                } else if (!this.f8011r.equals(zzfkqVar.f8011r)) {
                    return false;
                }
                if (!Arrays.equals(this.f7998e, zzfkqVar.f7998e)) {
                    return false;
                }
                if (this.f8012s == null) {
                    if (zzfkqVar.f8012s != null) {
                        return false;
                    }
                } else if (!this.f8012s.equals(zzfkqVar.f8012s)) {
                    return false;
                }
                if (this.f8013t == zzfkqVar.f8013t && zzfjq.m8701a(this.f8014u, zzfkqVar.f8014u) && this.f8015v == zzfkqVar.f8015v) {
                    if (this.f8016w == null) {
                        if (zzfkqVar.f8016w != null) {
                            return false;
                        }
                    } else if (!this.f8016w.equals(zzfkqVar.f8016w)) {
                        return false;
                    }
                    return (this.f7951H == null || this.f7951H.m8690b()) ? zzfkqVar.f7951H == null || zzfkqVar.f7951H.m8690b() : this.f7951H.equals(zzfkqVar.f7951H);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 0;
        int iHashCode2 = (((((this.f8003j ? 1231 : 1237) + (((((((this.f8000g == null ? 0 : this.f8000g.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.f7994a ^ (this.f7994a >>> 32)))) * 31) + ((int) (this.f7995b ^ (this.f7995b >>> 32)))) * 31) + ((int) (this.f7999f ^ (this.f7999f >>> 32)))) * 31)) * 31) + this.f8001h) * 31) + this.f8002i) * 31)) * 31) + zzfjq.m8698a(this.f8004k)) * 31) + Arrays.hashCode(this.f8005l);
        zzfko zzfkoVar = this.f8006m;
        int iHashCode3 = (this.f8008o == null ? 0 : this.f8008o.hashCode()) + (((this.f8007n == null ? 0 : this.f8007n.hashCode()) + (((((zzfkoVar == null ? 0 : zzfkoVar.hashCode()) + (iHashCode2 * 31)) * 31) + Arrays.hashCode(this.f7996c)) * 31)) * 31);
        zzfkn zzfknVar = this.f8009p;
        int iHashCode4 = (((this.f8010q == null ? 0 : this.f8010q.hashCode()) + (((zzfknVar == null ? 0 : zzfknVar.hashCode()) + (iHashCode3 * 31)) * 31)) * 31) + ((int) (this.f7997d ^ (this.f7997d >>> 32)));
        zzfkp zzfkpVar = this.f8011r;
        int iHashCode5 = (((((((this.f8012s == null ? 0 : this.f8012s.hashCode()) + (((((zzfkpVar == null ? 0 : zzfkpVar.hashCode()) + (iHashCode4 * 31)) * 31) + Arrays.hashCode(this.f7998e)) * 31)) * 31) + this.f8013t) * 31) + zzfjq.m8696a(this.f8014u)) * 31) + ((int) (this.f8015v ^ (this.f8015v >>> 32)));
        zzfks zzfksVar = this.f8016w;
        int iHashCode6 = ((zzfksVar == null ? 0 : zzfksVar.hashCode()) + (iHashCode5 * 31)) * 31;
        if (this.f7951H != null && !this.f7951H.m8690b()) {
            iHashCode = this.f7951H.hashCode();
        }
        return iHashCode6 + iHashCode;
    }
}
