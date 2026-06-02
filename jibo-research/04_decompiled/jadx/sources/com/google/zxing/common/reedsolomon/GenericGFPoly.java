package com.google.zxing.common.reedsolomon;

/* JADX INFO: loaded from: classes.dex */
final class GenericGFPoly {

    /* JADX INFO: renamed from: a */
    private final GenericGF f9096a;

    /* JADX INFO: renamed from: b */
    private final int[] f9097b;

    GenericGFPoly(GenericGF genericGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f9096a = genericGF;
        int length = iArr.length;
        if (length > 1 && iArr[0] == 0) {
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f9097b = new int[]{0};
                return;
            } else {
                this.f9097b = new int[length - i];
                System.arraycopy(iArr, i, this.f9097b, 0, this.f9097b.length);
                return;
            }
        }
        this.f9097b = iArr;
    }

    /* JADX INFO: renamed from: a */
    int[] m9692a() {
        return this.f9097b;
    }

    /* JADX INFO: renamed from: b */
    int m9693b() {
        return this.f9097b.length - 1;
    }

    /* JADX INFO: renamed from: c */
    boolean m9695c() {
        return this.f9097b[0] == 0;
    }

    /* JADX INFO: renamed from: a */
    int m9689a(int i) {
        return this.f9097b[(this.f9097b.length - 1) - i];
    }

    /* JADX INFO: renamed from: a */
    GenericGFPoly m9691a(GenericGFPoly genericGFPoly) {
        if (!this.f9096a.equals(genericGFPoly.f9096a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (!m9695c()) {
            if (genericGFPoly.m9695c()) {
                return this;
            }
            int[] iArr = this.f9097b;
            int[] iArr2 = genericGFPoly.f9097b;
            if (iArr.length <= iArr2.length) {
                iArr2 = iArr;
                iArr = iArr2;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = GenericGF.m9681b(iArr2[i - length], iArr[i]);
            }
            return new GenericGFPoly(this.f9096a, iArr3);
        }
        return genericGFPoly;
    }

    /* JADX INFO: renamed from: b */
    GenericGFPoly m9694b(GenericGFPoly genericGFPoly) {
        if (!this.f9096a.equals(genericGFPoly.f9096a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (m9695c() || genericGFPoly.m9695c()) {
            return this.f9096a.m9683a();
        }
        int[] iArr = this.f9097b;
        int length = iArr.length;
        int[] iArr2 = genericGFPoly.f9097b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                iArr3[i + i3] = GenericGF.m9681b(iArr3[i + i3], this.f9096a.m9688c(i2, iArr2[i3]));
            }
        }
        return new GenericGFPoly(this.f9096a, iArr3);
    }

    /* JADX INFO: renamed from: a */
    GenericGFPoly m9690a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f9096a.m9683a();
        }
        int length = this.f9097b.length;
        int[] iArr = new int[length + i];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f9096a.m9688c(this.f9097b[i3], i2);
        }
        return new GenericGFPoly(this.f9096a, iArr);
    }

    /* JADX INFO: renamed from: c */
    GenericGFPoly[] m9696c(GenericGFPoly genericGFPoly) {
        if (!this.f9096a.equals(genericGFPoly.f9096a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (genericGFPoly.m9695c()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        GenericGFPoly genericGFPolyM9683a = this.f9096a.m9683a();
        int iM9687c = this.f9096a.m9687c(genericGFPoly.m9689a(genericGFPoly.m9693b()));
        GenericGFPoly genericGFPolyM9691a = genericGFPolyM9683a;
        GenericGFPoly genericGFPolyM9691a2 = this;
        while (genericGFPolyM9691a2.m9693b() >= genericGFPoly.m9693b() && !genericGFPolyM9691a2.m9695c()) {
            int iM9693b = genericGFPolyM9691a2.m9693b() - genericGFPoly.m9693b();
            int iM9688c = this.f9096a.m9688c(genericGFPolyM9691a2.m9689a(genericGFPolyM9691a2.m9693b()), iM9687c);
            GenericGFPoly genericGFPolyM9690a = genericGFPoly.m9690a(iM9693b, iM9688c);
            genericGFPolyM9691a = genericGFPolyM9691a.m9691a(this.f9096a.m9684a(iM9693b, iM9688c));
            genericGFPolyM9691a2 = genericGFPolyM9691a2.m9691a(genericGFPolyM9690a);
        }
        return new GenericGFPoly[]{genericGFPolyM9691a, genericGFPolyM9691a2};
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(m9693b() * 8);
        for (int iM9693b = m9693b(); iM9693b >= 0; iM9693b--) {
            int iM9689a = m9689a(iM9693b);
            if (iM9689a != 0) {
                if (iM9689a < 0) {
                    sb.append(" - ");
                    iM9689a = -iM9689a;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iM9693b == 0 || iM9689a != 1) {
                    int iM9686b = this.f9096a.m9686b(iM9689a);
                    if (iM9686b == 0) {
                        sb.append('1');
                    } else if (iM9686b == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(iM9686b);
                    }
                }
                if (iM9693b != 0) {
                    if (iM9693b == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iM9693b);
                    }
                }
            }
        }
        return sb.toString();
    }
}
