package android.support.constraint.solver;

import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArrayLinkedVariables {

    /* JADX INFO: renamed from: b */
    private final ArrayRow f197b;

    /* JADX INFO: renamed from: c */
    private final Cache f198c;

    /* JADX INFO: renamed from: a */
    int f196a = 0;

    /* JADX INFO: renamed from: d */
    private int f199d = 8;

    /* JADX INFO: renamed from: e */
    private SolverVariable f200e = null;

    /* JADX INFO: renamed from: f */
    private int[] f201f = new int[this.f199d];

    /* JADX INFO: renamed from: g */
    private int[] f202g = new int[this.f199d];

    /* JADX INFO: renamed from: h */
    private float[] f203h = new float[this.f199d];

    /* JADX INFO: renamed from: i */
    private int f204i = -1;

    /* JADX INFO: renamed from: j */
    private int f205j = -1;

    /* JADX INFO: renamed from: k */
    private boolean f206k = false;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.f197b = arrayRow;
        this.f198c = cache;
    }

    /* JADX INFO: renamed from: a */
    public final void m128a(SolverVariable solverVariable, float f) {
        if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
            m121a(solverVariable);
            return;
        }
        if (this.f204i == -1) {
            this.f204i = 0;
            this.f203h[this.f204i] = f;
            this.f201f[this.f204i] = solverVariable.f234a;
            this.f202g[this.f204i] = -1;
            this.f196a++;
            if (!this.f206k) {
                this.f205j++;
                return;
            }
            return;
        }
        int i = this.f204i;
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f196a) {
            if (this.f201f[i] == solverVariable.f234a) {
                this.f203h[i] = f;
                return;
            }
            if (this.f201f[i] < solverVariable.f234a) {
                i3 = i;
            }
            i2++;
            i = this.f202g[i];
        }
        int length = this.f205j + 1;
        if (this.f206k) {
            if (this.f201f[this.f205j] == -1) {
                length = this.f205j;
            } else {
                length = this.f201f.length;
            }
        }
        if (length >= this.f201f.length && this.f196a < this.f201f.length) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.f201f.length) {
                    break;
                }
                if (this.f201f[i4] == -1) {
                    length = i4;
                    break;
                }
                i4++;
            }
        }
        if (length >= this.f201f.length) {
            length = this.f201f.length;
            this.f199d *= 2;
            this.f206k = false;
            this.f205j = length - 1;
            this.f203h = Arrays.copyOf(this.f203h, this.f199d);
            this.f201f = Arrays.copyOf(this.f201f, this.f199d);
            this.f202g = Arrays.copyOf(this.f202g, this.f199d);
        }
        this.f201f[length] = solverVariable.f234a;
        this.f203h[length] = f;
        if (i3 != -1) {
            this.f202g[length] = this.f202g[i3];
            this.f202g[i3] = length;
        } else {
            this.f202g[length] = this.f204i;
            this.f204i = length;
        }
        this.f196a++;
        if (!this.f206k) {
            this.f205j++;
        }
        if (this.f196a >= this.f201f.length) {
            this.f206k = true;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m131b(SolverVariable solverVariable, float f) {
        if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
            if (this.f204i == -1) {
                this.f204i = 0;
                this.f203h[this.f204i] = f;
                this.f201f[this.f204i] = solverVariable.f234a;
                this.f202g[this.f204i] = -1;
                this.f196a++;
                if (!this.f206k) {
                    this.f205j++;
                    return;
                }
                return;
            }
            int i = this.f204i;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.f196a) {
                int i4 = this.f201f[i];
                if (i4 == solverVariable.f234a) {
                    float[] fArr = this.f203h;
                    fArr[i] = fArr[i] + f;
                    if (this.f203h[i] == CropImageView.DEFAULT_ASPECT_RATIO) {
                        if (i == this.f204i) {
                            this.f204i = this.f202g[i];
                        } else {
                            this.f202g[i3] = this.f202g[i];
                        }
                        this.f198c.f214c[i4].m195b(this.f197b);
                        if (this.f206k) {
                            this.f205j = i;
                        }
                        this.f196a--;
                        return;
                    }
                    return;
                }
                if (this.f201f[i] < solverVariable.f234a) {
                    i3 = i;
                }
                i2++;
                i = this.f202g[i];
            }
            int length = this.f205j + 1;
            if (this.f206k) {
                if (this.f201f[this.f205j] == -1) {
                    length = this.f205j;
                } else {
                    length = this.f201f.length;
                }
            }
            if (length >= this.f201f.length && this.f196a < this.f201f.length) {
                int i5 = 0;
                while (true) {
                    if (i5 >= this.f201f.length) {
                        break;
                    }
                    if (this.f201f[i5] == -1) {
                        length = i5;
                        break;
                    }
                    i5++;
                }
            }
            if (length >= this.f201f.length) {
                length = this.f201f.length;
                this.f199d *= 2;
                this.f206k = false;
                this.f205j = length - 1;
                this.f203h = Arrays.copyOf(this.f203h, this.f199d);
                this.f201f = Arrays.copyOf(this.f201f, this.f199d);
                this.f202g = Arrays.copyOf(this.f202g, this.f199d);
            }
            this.f201f[length] = solverVariable.f234a;
            this.f203h[length] = f;
            if (i3 != -1) {
                this.f202g[length] = this.f202g[i3];
                this.f202g[i3] = length;
            } else {
                this.f202g[length] = this.f204i;
                this.f204i = length;
            }
            this.f196a++;
            if (!this.f206k) {
                this.f205j++;
            }
            if (this.f205j >= this.f201f.length) {
                this.f206k = true;
                this.f205j = this.f201f.length - 1;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final float m121a(SolverVariable solverVariable) {
        if (this.f200e == solverVariable) {
            this.f200e = null;
        }
        if (this.f204i == -1) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        int i = this.f204i;
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f196a) {
            int i4 = this.f201f[i];
            if (i4 == solverVariable.f234a) {
                if (i == this.f204i) {
                    this.f204i = this.f202g[i];
                } else {
                    this.f202g[i3] = this.f202g[i];
                }
                this.f198c.f214c[i4].m195b(this.f197b);
                this.f196a--;
                this.f201f[i] = -1;
                if (this.f206k) {
                    this.f205j = i;
                }
                return this.f203h[i];
            }
            i2++;
            int i5 = i;
            i = this.f202g[i];
            i3 = i5;
        }
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX INFO: renamed from: a */
    public final void m123a() {
        this.f204i = -1;
        this.f205j = -1;
        this.f206k = false;
        this.f196a = 0;
    }

    /* JADX INFO: renamed from: b */
    final boolean m132b(SolverVariable solverVariable) {
        if (this.f204i == -1) {
            return false;
        }
        int i = this.f204i;
        for (int i2 = 0; i != -1 && i2 < this.f196a; i2++) {
            if (this.f201f[i] == solverVariable.f234a) {
                return true;
            }
            i = this.f202g[i];
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    void m130b() {
        int i = this.f204i;
        for (int i2 = 0; i != -1 && i2 < this.f196a; i2++) {
            float[] fArr = this.f203h;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.f202g[i];
        }
    }

    /* JADX INFO: renamed from: a */
    void m124a(float f) {
        int i = this.f204i;
        for (int i2 = 0; i != -1 && i2 < this.f196a; i2++) {
            float[] fArr = this.f203h;
            fArr[i] = fArr[i] / f;
            i = this.f202g[i];
        }
    }

    /* JADX INFO: renamed from: a */
    void m125a(ArrayRow arrayRow) {
        int i = this.f204i;
        for (int i2 = 0; i != -1 && i2 < this.f196a; i2++) {
            this.f198c.f214c[this.f201f[i]].m192a(arrayRow);
            i = this.f202g[i];
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006e  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.support.constraint.solver.SolverVariable m134c() {
        /*
            r10 = this;
            r2 = 0
            r4 = 0
            int r1 = r10.f204i
            r0 = 0
            r5 = r0
            r6 = r1
            r1 = r2
        L8:
            r0 = -1
            if (r6 == r0) goto L65
            int r0 = r10.f196a
            if (r5 >= r0) goto L65
            float[] r0 = r10.f203h
            r0 = r0[r6]
            r3 = 981668463(0x3a83126f, float:0.001)
            int r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r7 >= 0) goto L3d
            float r3 = -r3
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 <= 0) goto L6e
            float[] r0 = r10.f203h
            r0[r6] = r4
            r3 = r4
        L24:
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 == 0) goto L6b
            android.support.constraint.solver.Cache r0 = r10.f198c
            android.support.constraint.solver.SolverVariable[] r0 = r0.f214c
            int[] r7 = r10.f201f
            r7 = r7[r6]
            r0 = r0[r7]
            android.support.constraint.solver.SolverVariable$Type r7 = r0.f239f
            android.support.constraint.solver.SolverVariable$Type r8 = android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED
            if (r7 != r8) goto L55
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L47
        L3c:
            return r0
        L3d:
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L6e
            float[] r0 = r10.f203h
            r0[r6] = r4
            r3 = r4
            goto L24
        L47:
            if (r1 != 0) goto L6b
            r1 = r2
        L4a:
            int[] r2 = r10.f202g
            r3 = r2[r6]
            int r2 = r5 + 1
            r5 = r2
            r6 = r3
            r2 = r1
            r1 = r0
            goto L8
        L55:
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L6b
            if (r2 == 0) goto L61
            int r3 = r0.f236c
            int r7 = r2.f236c
            if (r3 >= r7) goto L6b
        L61:
            r9 = r1
            r1 = r0
            r0 = r9
            goto L4a
        L65:
            if (r1 == 0) goto L69
            r0 = r1
            goto L3c
        L69:
            r0 = r2
            goto L3c
        L6b:
            r0 = r1
            r1 = r2
            goto L4a
        L6e:
            r3 = r0
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.ArrayLinkedVariables.m134c():android.support.constraint.solver.SolverVariable");
    }

    /* JADX INFO: renamed from: a */
    void m126a(ArrayRow arrayRow, ArrayRow arrayRow2) {
        int i = this.f204i;
        int i2 = 0;
        while (i != -1 && i2 < this.f196a) {
            if (this.f201f[i] == arrayRow2.f207a.f234a) {
                float f = this.f203h[i];
                m121a(arrayRow2.f207a);
                ArrayLinkedVariables arrayLinkedVariables = arrayRow2.f210d;
                int i3 = arrayLinkedVariables.f204i;
                for (int i4 = 0; i3 != -1 && i4 < arrayLinkedVariables.f196a; i4++) {
                    m131b(this.f198c.f214c[arrayLinkedVariables.f201f[i3]], arrayLinkedVariables.f203h[i3] * f);
                    i3 = arrayLinkedVariables.f202g[i3];
                }
                arrayRow.f208b += arrayRow2.f208b * f;
                arrayRow2.f207a.m195b(arrayRow);
                i = this.f204i;
                i2 = 0;
            } else {
                i = this.f202g[i];
                i2++;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m127a(ArrayRow arrayRow, ArrayRow[] arrayRowArr) {
        int i = this.f204i;
        int i2 = 0;
        while (i != -1 && i2 < this.f196a) {
            SolverVariable solverVariable = this.f198c.f214c[this.f201f[i]];
            if (solverVariable.f235b != -1) {
                float f = this.f203h[i];
                m121a(solverVariable);
                ArrayRow arrayRow2 = arrayRowArr[solverVariable.f235b];
                if (!arrayRow2.f211e) {
                    ArrayLinkedVariables arrayLinkedVariables = arrayRow2.f210d;
                    int i3 = arrayLinkedVariables.f204i;
                    for (int i4 = 0; i3 != -1 && i4 < arrayLinkedVariables.f196a; i4++) {
                        m131b(this.f198c.f214c[arrayLinkedVariables.f201f[i3]], arrayLinkedVariables.f203h[i3] * f);
                        i3 = arrayLinkedVariables.f202g[i3];
                    }
                }
                arrayRow.f208b += arrayRow2.f208b * f;
                arrayRow2.f207a.m195b(arrayRow);
                i = this.f204i;
                i2 = 0;
            } else {
                i = this.f202g[i];
                i2++;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final SolverVariable m122a(int i) {
        int i2 = this.f204i;
        for (int i3 = 0; i2 != -1 && i3 < this.f196a; i3++) {
            if (i3 == i) {
                return this.f198c.f214c[this.f201f[i2]];
            }
            i2 = this.f202g[i2];
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    final float m129b(int i) {
        int i2 = this.f204i;
        for (int i3 = 0; i2 != -1 && i3 < this.f196a; i3++) {
            if (i3 == i) {
                return this.f203h[i2];
            }
            i2 = this.f202g[i2];
        }
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX INFO: renamed from: c */
    public final float m133c(SolverVariable solverVariable) {
        int i = this.f204i;
        for (int i2 = 0; i != -1 && i2 < this.f196a; i2++) {
            if (this.f201f[i] == solverVariable.f234a) {
                return this.f203h[i];
            }
            i = this.f202g[i];
        }
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public String toString() {
        String str = "";
        int i = this.f204i;
        for (int i2 = 0; i != -1 && i2 < this.f196a; i2++) {
            str = ((str + " -> ") + this.f203h[i] + " : ") + this.f198c.f214c[this.f201f[i]];
            i = this.f202g[i];
        }
        return str;
    }
}
