package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class LinearSystem {

    /* JADX INFO: renamed from: d */
    private static int f216d = 1000;

    /* JADX INFO: renamed from: c */
    final Cache f219c;

    /* JADX INFO: renamed from: i */
    private ArrayRow[] f224i;

    /* JADX INFO: renamed from: a */
    int f217a = 0;

    /* JADX INFO: renamed from: e */
    private HashMap<String, SolverVariable> f220e = null;

    /* JADX INFO: renamed from: f */
    private Goal f221f = new Goal();

    /* JADX INFO: renamed from: g */
    private int f222g = 32;

    /* JADX INFO: renamed from: h */
    private int f223h = this.f222g;

    /* JADX INFO: renamed from: j */
    private boolean[] f225j = new boolean[this.f222g];

    /* JADX INFO: renamed from: b */
    int f218b = 1;

    /* JADX INFO: renamed from: k */
    private int f226k = 0;

    /* JADX INFO: renamed from: l */
    private int f227l = this.f222g;

    /* JADX INFO: renamed from: m */
    private SolverVariable[] f228m = new SolverVariable[f216d];

    /* JADX INFO: renamed from: n */
    private int f229n = 0;

    /* JADX INFO: renamed from: o */
    private ArrayRow[] f230o = new ArrayRow[this.f222g];

    public LinearSystem() {
        this.f224i = null;
        this.f224i = new ArrayRow[this.f222g];
        m170h();
        this.f219c = new Cache();
    }

    /* JADX INFO: renamed from: g */
    private void m169g() {
        this.f222g *= 2;
        this.f224i = (ArrayRow[]) Arrays.copyOf(this.f224i, this.f222g);
        this.f219c.f214c = (SolverVariable[]) Arrays.copyOf(this.f219c.f214c, this.f222g);
        this.f225j = new boolean[this.f222g];
        this.f223h = this.f222g;
        this.f227l = this.f222g;
        this.f221f.f215a.clear();
    }

    /* JADX INFO: renamed from: h */
    private void m170h() {
        for (int i = 0; i < this.f224i.length; i++) {
            ArrayRow arrayRow = this.f224i[i];
            if (arrayRow != null) {
                this.f219c.f212a.mo190a(arrayRow);
            }
            this.f224i[i] = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m174a() {
        for (int i = 0; i < this.f219c.f214c.length; i++) {
            SolverVariable solverVariable = this.f219c.f214c[i];
            if (solverVariable != null) {
                solverVariable.m196c();
            }
        }
        this.f219c.f213b.mo189a(this.f228m, this.f229n);
        this.f229n = 0;
        Arrays.fill(this.f219c.f214c, (Object) null);
        if (this.f220e != null) {
            this.f220e.clear();
        }
        this.f217a = 0;
        this.f221f.f215a.clear();
        this.f218b = 1;
        for (int i2 = 0; i2 < this.f226k; i2++) {
            this.f224i[i2].f209c = false;
        }
        m170h();
        this.f226k = 0;
    }

    /* JADX INFO: renamed from: a */
    public SolverVariable m173a(Object obj) {
        SolverVariable solverVariableM198a = null;
        if (obj != null) {
            if (this.f218b + 1 >= this.f223h) {
                m169g();
            }
            if (obj instanceof ConstraintAnchor) {
                solverVariableM198a = ((ConstraintAnchor) obj).m198a();
                if (solverVariableM198a == null) {
                    ((ConstraintAnchor) obj).m199a(this.f219c);
                    solverVariableM198a = ((ConstraintAnchor) obj).m198a();
                }
                if (solverVariableM198a.f234a == -1 || solverVariableM198a.f234a > this.f217a || this.f219c.f214c[solverVariableM198a.f234a] == null) {
                    if (solverVariableM198a.f234a != -1) {
                        solverVariableM198a.m196c();
                    }
                    this.f217a++;
                    this.f218b++;
                    solverVariableM198a.f234a = this.f217a;
                    solverVariableM198a.f239f = SolverVariable.Type.UNRESTRICTED;
                    this.f219c.f214c[this.f217a] = solverVariableM198a;
                }
            }
        }
        return solverVariableM198a;
    }

    /* JADX INFO: renamed from: b */
    public ArrayRow m181b() {
        ArrayRow arrayRowMo188a = this.f219c.f212a.mo188a();
        if (arrayRowMo188a == null) {
            return new ArrayRow(this.f219c);
        }
        arrayRowMo188a.m152d();
        return arrayRowMo188a;
    }

    /* JADX INFO: renamed from: c */
    public SolverVariable m184c() {
        if (this.f218b + 1 >= this.f223h) {
            m169g();
        }
        SolverVariable solverVariableM161a = m161a(SolverVariable.Type.SLACK);
        this.f217a++;
        this.f218b++;
        solverVariableM161a.f234a = this.f217a;
        this.f219c.f214c[this.f217a] = solverVariableM161a;
        return solverVariableM161a;
    }

    /* JADX INFO: renamed from: b */
    private void m165b(ArrayRow arrayRow) {
        arrayRow.m137a(m185d(), m185d());
    }

    /* JADX INFO: renamed from: a */
    private void m162a(ArrayRow arrayRow, int i) {
        arrayRow.m150c(m185d(), i);
    }

    /* JADX INFO: renamed from: d */
    public SolverVariable m185d() {
        if (this.f218b + 1 >= this.f223h) {
            m169g();
        }
        SolverVariable solverVariableM161a = m161a(SolverVariable.Type.ERROR);
        this.f217a++;
        this.f218b++;
        solverVariableM161a.f234a = this.f217a;
        this.f219c.f214c[this.f217a] = solverVariableM161a;
        return solverVariableM161a;
    }

    /* JADX INFO: renamed from: a */
    private SolverVariable m161a(SolverVariable.Type type) {
        SolverVariable solverVariable;
        SolverVariable solverVariableMo188a = this.f219c.f213b.mo188a();
        if (solverVariableMo188a == null) {
            solverVariable = new SolverVariable(type);
        } else {
            solverVariableMo188a.m196c();
            solverVariableMo188a.m193a(type);
            solverVariable = solverVariableMo188a;
        }
        if (this.f229n >= f216d) {
            f216d *= 2;
            this.f228m = (SolverVariable[]) Arrays.copyOf(this.f228m, f216d);
        }
        SolverVariable[] solverVariableArr = this.f228m;
        int i = this.f229n;
        this.f229n = i + 1;
        solverVariableArr[i] = solverVariable;
        return solverVariable;
    }

    /* JADX INFO: renamed from: a */
    ArrayRow m172a(int i) {
        return this.f224i[i];
    }

    /* JADX INFO: renamed from: b */
    public int m180b(Object obj) {
        SolverVariable solverVariableM198a = ((ConstraintAnchor) obj).m198a();
        if (solverVariableM198a != null) {
            return (int) (solverVariableM198a.f237d + 0.5f);
        }
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public void m186e() throws Exception {
        m176a(this.f221f);
    }

    /* JADX INFO: renamed from: a */
    void m176a(Goal goal) throws Exception {
        goal.m157a(this);
        m166c(goal);
        m163b(goal);
        m171i();
    }

    /* JADX INFO: renamed from: c */
    private void m168c(ArrayRow arrayRow) {
        if (this.f226k > 0) {
            arrayRow.f210d.m127a(arrayRow, this.f224i);
            if (arrayRow.f210d.f196a == 0) {
                arrayRow.f211e = true;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m175a(ArrayRow arrayRow) {
        if (arrayRow != null) {
            if (this.f226k + 1 >= this.f227l || this.f218b + 1 >= this.f223h) {
                m169g();
            }
            if (!arrayRow.f211e) {
                m168c(arrayRow);
                arrayRow.m153e();
                arrayRow.m154f();
                if (!arrayRow.m149b()) {
                    return;
                }
            }
            if (this.f224i[this.f226k] != null) {
                this.f219c.f212a.mo190a(this.f224i[this.f226k]);
            }
            if (!arrayRow.f211e) {
                arrayRow.m143a();
            }
            this.f224i[this.f226k] = arrayRow;
            arrayRow.f207a.f235b = this.f226k;
            this.f226k++;
            int i = arrayRow.f207a.f241h;
            if (i > 0) {
                while (this.f230o.length < i) {
                    this.f230o = new ArrayRow[this.f230o.length * 2];
                }
                ArrayRow[] arrayRowArr = this.f230o;
                for (int i2 = 0; i2 < i; i2++) {
                    arrayRowArr[i2] = arrayRow.f207a.f240g[i2];
                }
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayRow arrayRow2 = arrayRowArr[i3];
                    if (arrayRow2 != arrayRow) {
                        arrayRow2.f210d.m126a(arrayRow2, arrayRow);
                        arrayRow2.m143a();
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a4 A[PHI: r2
      0x00a4: PHI (r2v3 int) = (r2v2 int), (r2v12 int) binds: [B:9:0x001a, B:21:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int m163b(android.support.constraint.solver.Goal r14) {
        /*
            r13 = this;
            r3 = -1
            r7 = 1
            r1 = 0
            r0 = r1
        L4:
            int r2 = r13.f218b
            if (r0 >= r2) goto Lf
            boolean[] r2 = r13.f225j
            r2[r0] = r1
            int r0 = r0 + 1
            goto L4
        Lf:
            r2 = r1
            r0 = r1
            r6 = r1
        L12:
            if (r6 != 0) goto La3
            int r10 = r0 + 1
            android.support.constraint.solver.SolverVariable r0 = r14.m156a()
            if (r0 == 0) goto La4
            boolean[] r4 = r13.f225j
            int r5 = r0.f234a
            boolean r4 = r4[r5]
            if (r4 == 0) goto L42
            r0 = 0
            r8 = r0
            r9 = r2
        L27:
            if (r8 == 0) goto La1
            r0 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r2 = r3
            r4 = r0
            r0 = r1
        L2f:
            int r5 = r13.f226k
            if (r0 >= r5) goto L6e
            android.support.constraint.solver.ArrayRow[] r5 = r13.f224i
            r5 = r5[r0]
            android.support.constraint.solver.SolverVariable r11 = r5.f207a
            android.support.constraint.solver.SolverVariable$Type r11 = r11.f239f
            android.support.constraint.solver.SolverVariable$Type r12 = android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED
            if (r11 != r12) goto L52
        L3f:
            int r0 = r0 + 1
            goto L2f
        L42:
            boolean[] r4 = r13.f225j
            int r5 = r0.f234a
            r4[r5] = r7
            int r2 = r2 + 1
            int r4 = r13.f218b
            if (r2 < r4) goto La4
            r8 = r0
            r9 = r2
            r6 = r7
            goto L27
        L52:
            boolean r11 = r5.m145a(r8)
            if (r11 == 0) goto L3f
            android.support.constraint.solver.ArrayLinkedVariables r11 = r5.f210d
            float r11 = r11.m133c(r8)
            r12 = 0
            int r12 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r12 >= 0) goto L3f
            float r5 = r5.f208b
            float r5 = -r5
            float r5 = r5 / r11
            int r11 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r11 >= 0) goto L3f
            r2 = r0
            r4 = r5
            goto L3f
        L6e:
            if (r2 <= r3) goto L9f
            android.support.constraint.solver.ArrayRow[] r0 = r13.f224i
            r4 = r0[r2]
            android.support.constraint.solver.SolverVariable r0 = r4.f207a
            r0.f235b = r3
            r4.m148b(r8)
            android.support.constraint.solver.SolverVariable r0 = r4.f207a
            r0.f235b = r2
            r0 = r1
        L80:
            int r2 = r13.f226k
            if (r0 >= r2) goto L8e
            android.support.constraint.solver.ArrayRow[] r2 = r13.f224i
            r2 = r2[r0]
            r2.m144a(r4)
            int r0 = r0 + 1
            goto L80
        L8e:
            r14.m157a(r13)
            r13.m166c(r14)     // Catch: java.lang.Exception -> L9a
        L94:
            r0 = r6
        L95:
            r2 = r9
            r6 = r0
            r0 = r10
            goto L12
        L9a:
            r0 = move-exception
            r0.printStackTrace()
            goto L94
        L9f:
            r0 = r7
            goto L95
        La1:
            r0 = r7
            goto L95
        La3:
            return r0
        La4:
            r8 = r0
            r9 = r2
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.LinearSystem.m163b(android.support.constraint.solver.Goal):int");
    }

    /* JADX INFO: renamed from: c */
    private int m166c(Goal goal) throws Exception {
        boolean z;
        int i;
        boolean z2;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f226k) {
                z = false;
                break;
            }
            if (this.f224i[i2].f207a.f239f == SolverVariable.Type.UNRESTRICTED || this.f224i[i2].f208b >= CropImageView.DEFAULT_ASPECT_RATIO) {
                i2++;
            } else {
                z = true;
                break;
            }
        }
        if (!z) {
            i = 0;
        } else {
            boolean z3 = false;
            i = 0;
            while (!z3) {
                int i3 = i + 1;
                float f = Float.MAX_VALUE;
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                for (int i7 = 0; i7 < this.f226k; i7++) {
                    ArrayRow arrayRow = this.f224i[i7];
                    if (arrayRow.f207a.f239f != SolverVariable.Type.UNRESTRICTED && arrayRow.f208b < CropImageView.DEFAULT_ASPECT_RATIO) {
                        float f2 = f;
                        int i8 = i4;
                        int i9 = i5;
                        int i10 = i6;
                        for (int i11 = 1; i11 < this.f218b; i11++) {
                            SolverVariable solverVariable = this.f219c.f214c[i11];
                            float fM133c = arrayRow.f210d.m133c(solverVariable);
                            if (fM133c > CropImageView.DEFAULT_ASPECT_RATIO) {
                                float f3 = f2;
                                int i12 = 0;
                                while (i12 < 6) {
                                    float f4 = solverVariable.f238e[i12] / fM133c;
                                    if ((f4 >= f3 || i12 != i8) && i12 <= i8) {
                                        f4 = f3;
                                    } else {
                                        i10 = i11;
                                        i9 = i7;
                                        i8 = i12;
                                    }
                                    i12++;
                                    f3 = f4;
                                }
                                f2 = f3;
                            }
                        }
                        i6 = i10;
                        i5 = i9;
                        i4 = i8;
                        f = f2;
                    }
                }
                if (i5 != -1) {
                    ArrayRow arrayRow2 = this.f224i[i5];
                    arrayRow2.f207a.f235b = -1;
                    arrayRow2.m148b(this.f219c.f214c[i6]);
                    arrayRow2.f207a.f235b = i5;
                    for (int i13 = 0; i13 < this.f226k; i13++) {
                        this.f224i[i13].m144a(arrayRow2);
                    }
                    goal.m157a(this);
                    z2 = z3;
                } else {
                    z2 = true;
                }
                z3 = z2;
                i = i3;
            }
        }
        for (int i14 = 0; i14 < this.f226k && (this.f224i[i14].f207a.f239f == SolverVariable.Type.UNRESTRICTED || this.f224i[i14].f208b >= CropImageView.DEFAULT_ASPECT_RATIO); i14++) {
        }
        return i;
    }

    /* JADX INFO: renamed from: i */
    private void m171i() {
        for (int i = 0; i < this.f226k; i++) {
            ArrayRow arrayRow = this.f224i[i];
            arrayRow.f207a.f237d = arrayRow.f208b;
        }
    }

    /* JADX INFO: renamed from: f */
    public Cache m187f() {
        return this.f219c;
    }

    /* JADX INFO: renamed from: a */
    public void m179a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow arrayRowM181b = m181b();
        SolverVariable solverVariableM184c = m184c();
        solverVariableM184c.f236c = i2;
        arrayRowM181b.m141a(solverVariable, solverVariable2, solverVariableM184c, i);
        m175a(arrayRowM181b);
    }

    /* JADX INFO: renamed from: b */
    public void m182b(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow arrayRowM181b = m181b();
        SolverVariable solverVariableM184c = m184c();
        solverVariableM184c.f236c = i2;
        arrayRowM181b.m147b(solverVariable, solverVariable2, solverVariableM184c, i);
        m175a(arrayRowM181b);
    }

    /* JADX INFO: renamed from: a */
    public void m178a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow arrayRowM181b = m181b();
        arrayRowM181b.m139a(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        SolverVariable solverVariableM185d = m185d();
        SolverVariable solverVariableM185d2 = m185d();
        solverVariableM185d.f236c = i3;
        solverVariableM185d2.f236c = i3;
        arrayRowM181b.m137a(solverVariableM185d, solverVariableM185d2);
        m175a(arrayRowM181b);
    }

    /* JADX INFO: renamed from: c */
    public ArrayRow m183c(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow arrayRowM181b = m181b();
        arrayRowM181b.m138a(solverVariable, solverVariable2, i);
        SolverVariable solverVariableM185d = m185d();
        SolverVariable solverVariableM185d2 = m185d();
        solverVariableM185d.f236c = i2;
        solverVariableM185d2.f236c = i2;
        arrayRowM181b.m137a(solverVariableM185d, solverVariableM185d2);
        m175a(arrayRowM181b);
        return arrayRowM181b;
    }

    /* JADX INFO: renamed from: a */
    public void m177a(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.f235b;
        if (solverVariable.f235b != -1) {
            ArrayRow arrayRow = this.f224i[i2];
            if (arrayRow.f211e) {
                arrayRow.f208b = i;
                return;
            }
            ArrayRow arrayRowM181b = m181b();
            arrayRowM181b.m146b(solverVariable, i);
            m175a(arrayRowM181b);
            return;
        }
        ArrayRow arrayRowM181b2 = m181b();
        arrayRowM181b2.m136a(solverVariable, i);
        m175a(arrayRowM181b2);
    }

    /* JADX INFO: renamed from: a */
    public static ArrayRow m159a(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        ArrayRow arrayRowM181b = linearSystem.m181b();
        arrayRowM181b.m138a(solverVariable, solverVariable2, i);
        if (z) {
            linearSystem.m162a(arrayRowM181b, 1);
        }
        return arrayRowM181b;
    }

    /* JADX INFO: renamed from: a */
    public static ArrayRow m160a(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f, boolean z) {
        ArrayRow arrayRowM181b = linearSystem.m181b();
        if (z) {
            linearSystem.m165b(arrayRowM181b);
        }
        return arrayRowM181b.m140a(solverVariable, solverVariable2, solverVariable3, f);
    }

    /* JADX INFO: renamed from: b */
    public static ArrayRow m164b(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        SolverVariable solverVariableM184c = linearSystem.m184c();
        ArrayRow arrayRowM181b = linearSystem.m181b();
        arrayRowM181b.m141a(solverVariable, solverVariable2, solverVariableM184c, i);
        if (z) {
            linearSystem.m162a(arrayRowM181b, (int) (arrayRowM181b.f210d.m133c(solverVariableM184c) * (-1.0f)));
        }
        return arrayRowM181b;
    }

    /* JADX INFO: renamed from: c */
    public static ArrayRow m167c(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        SolverVariable solverVariableM184c = linearSystem.m184c();
        ArrayRow arrayRowM181b = linearSystem.m181b();
        arrayRowM181b.m147b(solverVariable, solverVariable2, solverVariableM184c, i);
        if (z) {
            linearSystem.m162a(arrayRowM181b, (int) (arrayRowM181b.f210d.m133c(solverVariableM184c) * (-1.0f)));
        }
        return arrayRowM181b;
    }

    /* JADX INFO: renamed from: a */
    public static ArrayRow m158a(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, boolean z) {
        ArrayRow arrayRowM181b = linearSystem.m181b();
        arrayRowM181b.m139a(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (z) {
            SolverVariable solverVariableM185d = linearSystem.m185d();
            SolverVariable solverVariableM185d2 = linearSystem.m185d();
            solverVariableM185d.f236c = 4;
            solverVariableM185d2.f236c = 4;
            arrayRowM181b.m137a(solverVariableM185d, solverVariableM185d2);
        }
        return arrayRowM181b;
    }
}
