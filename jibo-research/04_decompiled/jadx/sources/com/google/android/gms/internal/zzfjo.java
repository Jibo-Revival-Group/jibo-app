package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzfjo implements Cloneable {

    /* JADX INFO: renamed from: a */
    private static final zzfjp f7956a = new zzfjp();

    /* JADX INFO: renamed from: b */
    private boolean f7957b;

    /* JADX INFO: renamed from: c */
    private int[] f7958c;

    /* JADX INFO: renamed from: d */
    private zzfjp[] f7959d;

    /* JADX INFO: renamed from: e */
    private int f7960e;

    zzfjo() {
        this(10);
    }

    private zzfjo(int i) {
        this.f7957b = false;
        int iM8684c = m8684c(i);
        this.f7958c = new int[iM8684c];
        this.f7959d = new zzfjp[iM8684c];
        this.f7960e = 0;
    }

    /* JADX INFO: renamed from: c */
    private static int m8684c(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    /* JADX INFO: renamed from: d */
    private final int m8685d(int i) {
        int i2 = 0;
        int i3 = this.f7960e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.f7958c[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else {
                if (i5 <= i) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return i2 ^ (-1);
    }

    /* JADX INFO: renamed from: a */
    final int m8686a() {
        return this.f7960e;
    }

    /* JADX INFO: renamed from: a */
    final zzfjp m8687a(int i) {
        int iM8685d = m8685d(i);
        if (iM8685d < 0 || this.f7959d[iM8685d] == f7956a) {
            return null;
        }
        return this.f7959d[iM8685d];
    }

    /* JADX INFO: renamed from: a */
    final void m8688a(int i, zzfjp zzfjpVar) {
        int iM8685d = m8685d(i);
        if (iM8685d >= 0) {
            this.f7959d[iM8685d] = zzfjpVar;
            return;
        }
        int i2 = iM8685d ^ (-1);
        if (i2 < this.f7960e && this.f7959d[i2] == f7956a) {
            this.f7958c[i2] = i;
            this.f7959d[i2] = zzfjpVar;
            return;
        }
        if (this.f7960e >= this.f7958c.length) {
            int iM8684c = m8684c(this.f7960e + 1);
            int[] iArr = new int[iM8684c];
            zzfjp[] zzfjpVarArr = new zzfjp[iM8684c];
            System.arraycopy(this.f7958c, 0, iArr, 0, this.f7958c.length);
            System.arraycopy(this.f7959d, 0, zzfjpVarArr, 0, this.f7959d.length);
            this.f7958c = iArr;
            this.f7959d = zzfjpVarArr;
        }
        if (this.f7960e - i2 != 0) {
            System.arraycopy(this.f7958c, i2, this.f7958c, i2 + 1, this.f7960e - i2);
            System.arraycopy(this.f7959d, i2, this.f7959d, i2 + 1, this.f7960e - i2);
        }
        this.f7958c[i2] = i;
        this.f7959d[i2] = zzfjpVar;
        this.f7960e++;
    }

    /* JADX INFO: renamed from: b */
    final zzfjp m8689b(int i) {
        return this.f7959d[i];
    }

    /* JADX INFO: renamed from: b */
    public final boolean m8690b() {
        return this.f7960e == 0;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.f7960e;
        zzfjo zzfjoVar = new zzfjo(i);
        System.arraycopy(this.f7958c, 0, zzfjoVar.f7958c, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f7959d[i2] != null) {
                zzfjoVar.f7959d[i2] = (zzfjp) this.f7959d[i2].clone();
            }
        }
        zzfjoVar.f7960e = i;
        return zzfjoVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfjo)) {
            return false;
        }
        zzfjo zzfjoVar = (zzfjo) obj;
        if (this.f7960e != zzfjoVar.f7960e) {
            return false;
        }
        int[] iArr = this.f7958c;
        int[] iArr2 = zzfjoVar.f7958c;
        int i = this.f7960e;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            }
            if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            }
            i2++;
        }
        if (z) {
            zzfjp[] zzfjpVarArr = this.f7959d;
            zzfjp[] zzfjpVarArr2 = zzfjoVar.f7959d;
            int i3 = this.f7960e;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!zzfjpVarArr[i4].equals(zzfjpVarArr2[i4])) {
                    z2 = false;
                    break;
                }
                i4++;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 17;
        for (int i = 0; i < this.f7960e; i++) {
            iHashCode = (((iHashCode * 31) + this.f7958c[i]) * 31) + this.f7959d[i].hashCode();
        }
        return iHashCode;
    }
}
