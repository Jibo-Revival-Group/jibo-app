package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {

    /* JADX INFO: renamed from: D */
    public static float f254D = 0.5f;

    /* JADX INFO: renamed from: B */
    protected int f256B;

    /* JADX INFO: renamed from: C */
    protected int f257C;

    /* JADX INFO: renamed from: I */
    int f262I;

    /* JADX INFO: renamed from: J */
    int f263J;

    /* JADX INFO: renamed from: K */
    int f264K;

    /* JADX INFO: renamed from: L */
    int f265L;

    /* JADX INFO: renamed from: M */
    boolean f266M;

    /* JADX INFO: renamed from: N */
    boolean f267N;

    /* JADX INFO: renamed from: O */
    boolean f268O;

    /* JADX INFO: renamed from: P */
    boolean f269P;

    /* JADX INFO: renamed from: Q */
    boolean f270Q;

    /* JADX INFO: renamed from: R */
    boolean f271R;

    /* JADX INFO: renamed from: U */
    boolean f274U;

    /* JADX INFO: renamed from: V */
    boolean f275V;

    /* JADX INFO: renamed from: ai */
    private int f289ai;

    /* JADX INFO: renamed from: aj */
    private int f290aj;

    /* JADX INFO: renamed from: ak */
    private Object f291ak;

    /* JADX INFO: renamed from: a */
    public int f280a = -1;

    /* JADX INFO: renamed from: b */
    public int f296b = -1;

    /* JADX INFO: renamed from: c */
    int f297c = 0;

    /* JADX INFO: renamed from: d */
    int f298d = 0;

    /* JADX INFO: renamed from: e */
    int f299e = 0;

    /* JADX INFO: renamed from: f */
    int f300f = 0;

    /* JADX INFO: renamed from: g */
    int f301g = 0;

    /* JADX INFO: renamed from: h */
    int f302h = 0;

    /* JADX INFO: renamed from: i */
    ConstraintAnchor f303i = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);

    /* JADX INFO: renamed from: j */
    ConstraintAnchor f304j = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);

    /* JADX INFO: renamed from: k */
    ConstraintAnchor f305k = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);

    /* JADX INFO: renamed from: l */
    ConstraintAnchor f306l = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);

    /* JADX INFO: renamed from: m */
    ConstraintAnchor f307m = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);

    /* JADX INFO: renamed from: n */
    ConstraintAnchor f308n = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);

    /* JADX INFO: renamed from: o */
    ConstraintAnchor f309o = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);

    /* JADX INFO: renamed from: p */
    ConstraintAnchor f310p = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);

    /* JADX INFO: renamed from: q */
    protected ArrayList<ConstraintAnchor> f311q = new ArrayList<>();

    /* JADX INFO: renamed from: r */
    ConstraintWidget f312r = null;

    /* JADX INFO: renamed from: s */
    int f313s = 0;

    /* JADX INFO: renamed from: t */
    int f314t = 0;

    /* JADX INFO: renamed from: u */
    protected float f315u = CropImageView.DEFAULT_ASPECT_RATIO;

    /* JADX INFO: renamed from: v */
    protected int f316v = -1;

    /* JADX INFO: renamed from: aa */
    private int f281aa = 0;

    /* JADX INFO: renamed from: ab */
    private int f282ab = 0;

    /* JADX INFO: renamed from: ac */
    private int f283ac = 0;

    /* JADX INFO: renamed from: ad */
    private int f284ad = 0;

    /* JADX INFO: renamed from: w */
    protected int f317w = 0;

    /* JADX INFO: renamed from: x */
    protected int f318x = 0;

    /* JADX INFO: renamed from: ae */
    private int f285ae = 0;

    /* JADX INFO: renamed from: af */
    private int f286af = 0;

    /* JADX INFO: renamed from: ag */
    private int f287ag = 0;

    /* JADX INFO: renamed from: ah */
    private int f288ah = 0;

    /* JADX INFO: renamed from: y */
    protected int f319y = 0;

    /* JADX INFO: renamed from: z */
    protected int f320z = 0;

    /* JADX INFO: renamed from: A */
    int f255A = 0;

    /* JADX INFO: renamed from: E */
    float f258E = f254D;

    /* JADX INFO: renamed from: F */
    float f259F = f254D;

    /* JADX INFO: renamed from: G */
    DimensionBehaviour f260G = DimensionBehaviour.FIXED;

    /* JADX INFO: renamed from: H */
    DimensionBehaviour f261H = DimensionBehaviour.FIXED;

    /* JADX INFO: renamed from: al */
    private int f292al = 0;

    /* JADX INFO: renamed from: am */
    private int f293am = 0;

    /* JADX INFO: renamed from: an */
    private String f294an = null;

    /* JADX INFO: renamed from: ao */
    private String f295ao = null;

    /* JADX INFO: renamed from: S */
    int f272S = 0;

    /* JADX INFO: renamed from: T */
    int f273T = 0;

    /* JADX INFO: renamed from: W */
    float f276W = CropImageView.DEFAULT_ASPECT_RATIO;

    /* JADX INFO: renamed from: X */
    float f277X = CropImageView.DEFAULT_ASPECT_RATIO;

    /* JADX INFO: renamed from: Y */
    ConstraintWidget f278Y = null;

    /* JADX INFO: renamed from: Z */
    ConstraintWidget f279Z = null;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    /* JADX INFO: renamed from: a */
    public void mo219a() {
        this.f303i.m211i();
        this.f304j.m211i();
        this.f305k.m211i();
        this.f306l.m211i();
        this.f307m.m211i();
        this.f308n.m211i();
        this.f309o.m211i();
        this.f310p.m211i();
        this.f312r = null;
        this.f313s = 0;
        this.f314t = 0;
        this.f315u = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f316v = -1;
        this.f317w = 0;
        this.f318x = 0;
        this.f285ae = 0;
        this.f286af = 0;
        this.f287ag = 0;
        this.f288ah = 0;
        this.f319y = 0;
        this.f320z = 0;
        this.f255A = 0;
        this.f256B = 0;
        this.f257C = 0;
        this.f289ai = 0;
        this.f290aj = 0;
        this.f258E = f254D;
        this.f259F = f254D;
        this.f260G = DimensionBehaviour.FIXED;
        this.f261H = DimensionBehaviour.FIXED;
        this.f291ak = null;
        this.f292al = 0;
        this.f293am = 0;
        this.f294an = null;
        this.f295ao = null;
        this.f270Q = false;
        this.f271R = false;
        this.f272S = 0;
        this.f273T = 0;
        this.f274U = false;
        this.f275V = false;
        this.f276W = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f277X = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f280a = -1;
        this.f296b = -1;
    }

    public ConstraintWidget() {
        m213D();
    }

    /* JADX INFO: renamed from: a */
    public void mo225a(Cache cache) {
        this.f303i.m199a(cache);
        this.f304j.m199a(cache);
        this.f305k.m199a(cache);
        this.f306l.m199a(cache);
        this.f307m.m199a(cache);
        this.f310p.m199a(cache);
        this.f308n.m199a(cache);
        this.f309o.m199a(cache);
    }

    /* JADX INFO: renamed from: D */
    private void m213D() {
        this.f311q.add(this.f303i);
        this.f311q.add(this.f304j);
        this.f311q.add(this.f305k);
        this.f311q.add(this.f306l);
        this.f311q.add(this.f308n);
        this.f311q.add(this.f309o);
        this.f311q.add(this.f307m);
    }

    /* JADX INFO: renamed from: b */
    public boolean m238b() {
        return this.f312r == null;
    }

    /* JADX INFO: renamed from: c */
    public ConstraintWidget m239c() {
        return this.f312r;
    }

    /* JADX INFO: renamed from: a */
    public void m229a(ConstraintWidget constraintWidget) {
        this.f312r = constraintWidget;
    }

    /* JADX INFO: renamed from: a */
    public void m221a(int i) {
        this.f293am = i;
    }

    /* JADX INFO: renamed from: d */
    public int m243d() {
        return this.f293am;
    }

    /* JADX INFO: renamed from: e */
    public String m247e() {
        return this.f294an;
    }

    public String toString() {
        return (this.f295ao != null ? "type: " + this.f295ao + " " : "") + (this.f294an != null ? "id: " + this.f294an + " " : "") + "(" + this.f317w + ", " + this.f318x + ") - (" + this.f313s + " x " + this.f314t + ") wrap: (" + this.f289ai + " x " + this.f290aj + ")";
    }

    /* JADX INFO: renamed from: f */
    public int m249f() {
        return this.f317w;
    }

    /* JADX INFO: renamed from: g */
    public int m251g() {
        return this.f318x;
    }

    /* JADX INFO: renamed from: h */
    public int m253h() {
        if (this.f293am == 8) {
            return 0;
        }
        return this.f313s;
    }

    /* JADX INFO: renamed from: i */
    public int m255i() {
        int iMax;
        int i = this.f313s;
        if (this.f260G == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.f297c == 1) {
                iMax = Math.max(this.f299e, i);
            } else if (this.f299e > 0) {
                iMax = this.f299e;
                this.f313s = iMax;
            } else {
                iMax = 0;
            }
            if (this.f300f > 0 && this.f300f < iMax) {
                return this.f300f;
            }
            return iMax;
        }
        return i;
    }

    /* JADX INFO: renamed from: j */
    public int m257j() {
        int iMax;
        int i = this.f314t;
        if (this.f261H == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.f298d == 1) {
                iMax = Math.max(this.f301g, i);
            } else if (this.f301g > 0) {
                iMax = this.f301g;
                this.f314t = iMax;
            } else {
                iMax = 0;
            }
            if (this.f302h > 0 && this.f302h < iMax) {
                return this.f302h;
            }
            return iMax;
        }
        return i;
    }

    /* JADX INFO: renamed from: k */
    public int m259k() {
        return this.f289ai;
    }

    /* JADX INFO: renamed from: l */
    public int m261l() {
        if (this.f293am == 8) {
            return 0;
        }
        return this.f314t;
    }

    /* JADX INFO: renamed from: m */
    public int m263m() {
        return this.f290aj;
    }

    /* JADX INFO: renamed from: n */
    public int m264n() {
        return this.f285ae + this.f319y;
    }

    /* JADX INFO: renamed from: o */
    public int m265o() {
        return this.f286af + this.f320z;
    }

    /* JADX INFO: renamed from: p */
    public int m266p() {
        return m265o() + this.f288ah;
    }

    /* JADX INFO: renamed from: q */
    public int m267q() {
        return m264n() + this.f287ag;
    }

    /* JADX INFO: renamed from: r */
    protected int m268r() {
        return this.f317w + this.f319y;
    }

    /* JADX INFO: renamed from: s */
    protected int m269s() {
        return this.f318x + this.f320z;
    }

    /* JADX INFO: renamed from: t */
    public int m270t() {
        return m249f() + this.f313s;
    }

    /* JADX INFO: renamed from: u */
    public int m271u() {
        return m251g() + this.f314t;
    }

    /* JADX INFO: renamed from: v */
    public boolean m272v() {
        return this.f255A > 0;
    }

    /* JADX INFO: renamed from: w */
    public int m273w() {
        return this.f255A;
    }

    /* JADX INFO: renamed from: x */
    public Object m274x() {
        return this.f291ak;
    }

    /* JADX INFO: renamed from: y */
    public ArrayList<ConstraintAnchor> mo275y() {
        return this.f311q;
    }

    /* JADX INFO: renamed from: b */
    public void m233b(int i) {
        this.f317w = i;
    }

    /* JADX INFO: renamed from: c */
    public void m241c(int i) {
        this.f318x = i;
    }

    /* JADX INFO: renamed from: a */
    public void m222a(int i, int i2) {
        this.f317w = i;
        this.f318x = i2;
    }

    /* JADX INFO: renamed from: b */
    public void mo234b(int i, int i2) {
        this.f319y = i;
        this.f320z = i2;
    }

    /* JADX INFO: renamed from: z */
    public void mo276z() {
        int i = this.f317w;
        int i2 = this.f318x;
        int i3 = this.f317w + this.f313s;
        int i4 = this.f318x + this.f314t;
        this.f285ae = i;
        this.f286af = i2;
        this.f287ag = i3 - i;
        this.f288ah = i4 - i2;
    }

    /* JADX INFO: renamed from: d */
    public void m245d(int i) {
        this.f313s = i;
        if (this.f313s < this.f256B) {
            this.f313s = this.f256B;
        }
    }

    /* JADX INFO: renamed from: e */
    public void m248e(int i) {
        this.f314t = i;
        if (this.f314t < this.f257C) {
            this.f314t = this.f257C;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m223a(int i, int i2, int i3) {
        this.f297c = i;
        this.f299e = i2;
        this.f300f = i3;
    }

    /* JADX INFO: renamed from: b */
    public void m235b(int i, int i2, int i3) {
        this.f298d = i;
        this.f301g = i2;
        this.f302h = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m231a(java.lang.String r10) {
        /*
            r9 = this;
            r1 = 1
            r0 = 0
            r3 = 0
            if (r10 == 0) goto Lb
            int r2 = r10.length()
            if (r2 != 0) goto Le
        Lb:
            r9.f315u = r3
        Ld:
            return
        Le:
            r2 = -1
            int r4 = r10.length()
            r5 = 44
            int r5 = r10.indexOf(r5)
            if (r5 <= 0) goto L30
            int r6 = r4 + (-1)
            if (r5 >= r6) goto L30
            java.lang.String r6 = r10.substring(r0, r5)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L73
        L2b:
            int r2 = r5 + 1
            r8 = r2
            r2 = r0
            r0 = r8
        L30:
            r5 = 58
            int r5 = r10.indexOf(r5)
            if (r5 < 0) goto L86
            int r4 = r4 + (-1)
            if (r5 >= r4) goto L86
            java.lang.String r0 = r10.substring(r0, r5)
            int r4 = r5 + 1
            java.lang.String r4 = r10.substring(r4)
            int r5 = r0.length()
            if (r5 <= 0) goto L98
            int r5 = r4.length()
            if (r5 <= 0) goto L98
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> L83
            float r4 = java.lang.Float.parseFloat(r4)     // Catch: java.lang.NumberFormatException -> L83
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 <= 0) goto L98
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 <= 0) goto L98
            if (r2 != r1) goto L7d
            float r0 = r4 / r0
            float r0 = java.lang.Math.abs(r0)     // Catch: java.lang.NumberFormatException -> L83
        L6a:
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 <= 0) goto Ld
            r9.f315u = r0
            r9.f316v = r2
            goto Ld
        L73:
            java.lang.String r0 = "H"
            boolean r0 = r6.equalsIgnoreCase(r0)
            if (r0 == 0) goto L9a
            r0 = r1
            goto L2b
        L7d:
            float r0 = r0 / r4
            float r0 = java.lang.Math.abs(r0)     // Catch: java.lang.NumberFormatException -> L83
            goto L6a
        L83:
            r0 = move-exception
            r0 = r3
            goto L6a
        L86:
            java.lang.String r0 = r10.substring(r0)
            int r1 = r0.length()
            if (r1 <= 0) goto L98
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> L95
            goto L6a
        L95:
            r0 = move-exception
            r0 = r3
            goto L6a
        L98:
            r0 = r3
            goto L6a
        L9a:
            r0 = r2
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.m231a(java.lang.String):void");
    }

    /* JADX INFO: renamed from: a */
    public void m220a(float f) {
        this.f258E = f;
    }

    /* JADX INFO: renamed from: b */
    public void m232b(float f) {
        this.f259F = f;
    }

    /* JADX INFO: renamed from: f */
    public void m250f(int i) {
        if (i < 0) {
            this.f256B = 0;
        } else {
            this.f256B = i;
        }
    }

    /* JADX INFO: renamed from: g */
    public void m252g(int i) {
        if (i < 0) {
            this.f257C = 0;
        } else {
            this.f257C = i;
        }
    }

    /* JADX INFO: renamed from: h */
    public void m254h(int i) {
        this.f289ai = i;
    }

    /* JADX INFO: renamed from: i */
    public void m256i(int i) {
        this.f290aj = i;
    }

    /* JADX INFO: renamed from: a */
    public void m224a(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.f317w = i;
        this.f318x = i2;
        if (this.f293am == 8) {
            this.f313s = 0;
            this.f314t = 0;
            return;
        }
        if (this.f260G == DimensionBehaviour.FIXED && i5 < this.f313s) {
            i5 = this.f313s;
        }
        if (this.f261H == DimensionBehaviour.FIXED && i6 < this.f314t) {
            i6 = this.f314t;
        }
        this.f313s = i5;
        this.f314t = i6;
        if (this.f314t < this.f257C) {
            this.f314t = this.f257C;
        }
        if (this.f313s < this.f256B) {
            this.f313s = this.f256B;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m242c(int i, int i2) {
        this.f317w = i;
        this.f313s = i2 - i;
        if (this.f313s < this.f256B) {
            this.f313s = this.f256B;
        }
    }

    /* JADX INFO: renamed from: d */
    public void m246d(int i, int i2) {
        this.f318x = i;
        this.f314t = i2 - i;
        if (this.f314t < this.f257C) {
            this.f314t = this.f257C;
        }
    }

    /* JADX INFO: renamed from: j */
    public void m258j(int i) {
        this.f255A = i;
    }

    /* JADX INFO: renamed from: a */
    public void m230a(Object obj) {
        this.f291ak = obj;
    }

    /* JADX INFO: renamed from: c */
    public void m240c(float f) {
        this.f276W = f;
    }

    /* JADX INFO: renamed from: d */
    public void m244d(float f) {
        this.f277X = f;
    }

    /* JADX INFO: renamed from: k */
    public void m260k(int i) {
        this.f272S = i;
    }

    /* JADX INFO: renamed from: l */
    public void m262l(int i) {
        this.f273T = i;
    }

    /* JADX INFO: renamed from: a */
    public void m227a(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        mo218a(type).m202a(constraintWidget.mo218a(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    /* JADX INFO: renamed from: A */
    public void m215A() {
        ConstraintWidget constraintWidgetM239c = m239c();
        if (constraintWidgetM239c == null || !(constraintWidgetM239c instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) m239c()).m287G()) {
            int size = this.f311q.size();
            for (int i = 0; i < size; i++) {
                this.f311q.get(i).m211i();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public ConstraintAnchor mo218a(ConstraintAnchor.Type type) {
        switch (type) {
            case LEFT:
                return this.f303i;
            case TOP:
                return this.f304j;
            case RIGHT:
                return this.f305k;
            case BOTTOM:
                return this.f306l;
            case BASELINE:
                return this.f307m;
            case CENTER_X:
                return this.f308n;
            case CENTER_Y:
                return this.f309o;
            case CENTER:
                return this.f310p;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: B */
    public DimensionBehaviour m216B() {
        return this.f260G;
    }

    /* JADX INFO: renamed from: C */
    public DimensionBehaviour m217C() {
        return this.f261H;
    }

    /* JADX INFO: renamed from: a */
    public void m228a(DimensionBehaviour dimensionBehaviour) {
        this.f260G = dimensionBehaviour;
        if (this.f260G == DimensionBehaviour.WRAP_CONTENT) {
            m245d(this.f289ai);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m237b(DimensionBehaviour dimensionBehaviour) {
        this.f261H = dimensionBehaviour;
        if (this.f261H == DimensionBehaviour.WRAP_CONTENT) {
            m248e(this.f290aj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:270:0x0768 A[PHI: r8 r9
      0x0768: PHI (r8v6 int) = (r8v5 int), (r8v5 int), (r8v5 int), (r8v5 int), (r8v5 int), (r8v21 int) binds: [B:114:0x029e, B:116:0x02a6, B:186:0x0459, B:177:0x0417, B:178:0x0419, B:180:0x0421] A[DONT_GENERATE, DONT_INLINE]
      0x0768: PHI (r9v2 boolean) = (r9v1 boolean), (r9v1 boolean), (r9v1 boolean), (r9v14 boolean), (r9v14 boolean), (r9v14 boolean) binds: [B:114:0x029e, B:116:0x02a6, B:186:0x0459, B:177:0x0417, B:178:0x0419, B:180:0x0421] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo226a(android.support.constraint.solver.LinearSystem r32, int r33) {
        /*
            Method dump skipped, instruction units count: 1948
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.mo226a(android.support.constraint.solver.LinearSystem, int):void");
    }

    /* JADX INFO: renamed from: a */
    private void m214a(LinearSystem linearSystem, boolean z, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7) {
        int i8;
        SolverVariable solverVariableM173a = linearSystem.m173a(constraintAnchor);
        SolverVariable solverVariableM173a2 = linearSystem.m173a(constraintAnchor2);
        SolverVariable solverVariableM173a3 = linearSystem.m173a(constraintAnchor.m208f());
        SolverVariable solverVariableM173a4 = linearSystem.m173a(constraintAnchor2.m208f());
        int iM206d = constraintAnchor.m206d();
        int iM206d2 = constraintAnchor2.m206d();
        if (this.f293am == 8) {
            i8 = 0;
            z2 = true;
        } else {
            i8 = i3;
        }
        if (solverVariableM173a3 == null && solverVariableM173a4 == null) {
            linearSystem.m175a(linearSystem.m181b().m146b(solverVariableM173a, i));
            if (!z3) {
                if (z) {
                    linearSystem.m175a(LinearSystem.m159a(linearSystem, solverVariableM173a2, solverVariableM173a, i4, true));
                    return;
                } else if (z2) {
                    linearSystem.m175a(LinearSystem.m159a(linearSystem, solverVariableM173a2, solverVariableM173a, i8, false));
                    return;
                } else {
                    linearSystem.m175a(linearSystem.m181b().m146b(solverVariableM173a2, i2));
                    return;
                }
            }
            return;
        }
        if (solverVariableM173a3 != null && solverVariableM173a4 == null) {
            linearSystem.m175a(linearSystem.m181b().m138a(solverVariableM173a, solverVariableM173a3, iM206d));
            if (z) {
                linearSystem.m175a(LinearSystem.m159a(linearSystem, solverVariableM173a2, solverVariableM173a, i4, true));
                return;
            } else {
                if (!z3) {
                    if (z2) {
                        linearSystem.m175a(linearSystem.m181b().m138a(solverVariableM173a2, solverVariableM173a, i8));
                        return;
                    } else {
                        linearSystem.m175a(linearSystem.m181b().m146b(solverVariableM173a2, i2));
                        return;
                    }
                }
                return;
            }
        }
        if (solverVariableM173a3 == null && solverVariableM173a4 != null) {
            linearSystem.m175a(linearSystem.m181b().m138a(solverVariableM173a2, solverVariableM173a4, iM206d2 * (-1)));
            if (z) {
                linearSystem.m175a(LinearSystem.m159a(linearSystem, solverVariableM173a2, solverVariableM173a, i4, true));
                return;
            } else {
                if (!z3) {
                    if (z2) {
                        linearSystem.m175a(linearSystem.m181b().m138a(solverVariableM173a2, solverVariableM173a, i8));
                        return;
                    } else {
                        linearSystem.m175a(linearSystem.m181b().m146b(solverVariableM173a, i));
                        return;
                    }
                }
                return;
            }
        }
        if (z2) {
            if (z) {
                linearSystem.m175a(LinearSystem.m159a(linearSystem, solverVariableM173a2, solverVariableM173a, i4, true));
            } else {
                linearSystem.m175a(linearSystem.m181b().m138a(solverVariableM173a2, solverVariableM173a, i8));
            }
            if (constraintAnchor.m207e() != constraintAnchor2.m207e()) {
                if (constraintAnchor.m207e() == ConstraintAnchor.Strength.STRONG) {
                    linearSystem.m175a(linearSystem.m181b().m138a(solverVariableM173a, solverVariableM173a3, iM206d));
                    SolverVariable solverVariableM184c = linearSystem.m184c();
                    ArrayRow arrayRowM181b = linearSystem.m181b();
                    arrayRowM181b.m147b(solverVariableM173a2, solverVariableM173a4, solverVariableM184c, iM206d2 * (-1));
                    linearSystem.m175a(arrayRowM181b);
                    return;
                }
                SolverVariable solverVariableM184c2 = linearSystem.m184c();
                ArrayRow arrayRowM181b2 = linearSystem.m181b();
                arrayRowM181b2.m141a(solverVariableM173a, solverVariableM173a3, solverVariableM184c2, iM206d);
                linearSystem.m175a(arrayRowM181b2);
                linearSystem.m175a(linearSystem.m181b().m138a(solverVariableM173a2, solverVariableM173a4, iM206d2 * (-1)));
                return;
            }
            if (solverVariableM173a3 == solverVariableM173a4) {
                linearSystem.m175a(LinearSystem.m158a(linearSystem, solverVariableM173a, solverVariableM173a3, 0, 0.5f, solverVariableM173a4, solverVariableM173a2, 0, true));
                return;
            } else {
                if (!z4) {
                    linearSystem.m175a(LinearSystem.m164b(linearSystem, solverVariableM173a, solverVariableM173a3, iM206d, constraintAnchor.m209g() != ConstraintAnchor.ConnectionType.STRICT));
                    linearSystem.m175a(LinearSystem.m167c(linearSystem, solverVariableM173a2, solverVariableM173a4, iM206d2 * (-1), constraintAnchor2.m209g() != ConstraintAnchor.ConnectionType.STRICT));
                    linearSystem.m175a(LinearSystem.m158a(linearSystem, solverVariableM173a, solverVariableM173a3, iM206d, f, solverVariableM173a4, solverVariableM173a2, iM206d2, false));
                    return;
                }
                return;
            }
        }
        if (z3) {
            linearSystem.m179a(solverVariableM173a, solverVariableM173a3, iM206d, 3);
            linearSystem.m182b(solverVariableM173a2, solverVariableM173a4, iM206d2 * (-1), 3);
            linearSystem.m175a(LinearSystem.m158a(linearSystem, solverVariableM173a, solverVariableM173a3, iM206d, f, solverVariableM173a4, solverVariableM173a2, iM206d2, true));
            return;
        }
        if (!z4) {
            if (i5 == 1) {
                if (i6 > i8) {
                    i8 = i6;
                }
                if (i7 <= 0) {
                    i7 = i8;
                } else if (i7 >= i8) {
                    linearSystem.m182b(solverVariableM173a2, solverVariableM173a, i7, 3);
                    i7 = i8;
                }
                linearSystem.m183c(solverVariableM173a2, solverVariableM173a, i7, 3);
                linearSystem.m179a(solverVariableM173a, solverVariableM173a3, iM206d, 2);
                linearSystem.m182b(solverVariableM173a2, solverVariableM173a4, -iM206d2, 2);
                linearSystem.m178a(solverVariableM173a, solverVariableM173a3, iM206d, f, solverVariableM173a4, solverVariableM173a2, iM206d2, 4);
                return;
            }
            if (i6 == 0 && i7 == 0) {
                linearSystem.m175a(linearSystem.m181b().m138a(solverVariableM173a, solverVariableM173a3, iM206d));
                linearSystem.m175a(linearSystem.m181b().m138a(solverVariableM173a2, solverVariableM173a4, iM206d2 * (-1)));
                return;
            }
            if (i7 > 0) {
                linearSystem.m182b(solverVariableM173a2, solverVariableM173a, i7, 3);
            }
            linearSystem.m179a(solverVariableM173a, solverVariableM173a3, iM206d, 2);
            linearSystem.m182b(solverVariableM173a2, solverVariableM173a4, -iM206d2, 2);
            linearSystem.m178a(solverVariableM173a, solverVariableM173a3, iM206d, f, solverVariableM173a4, solverVariableM173a2, iM206d2, 4);
        }
    }

    /* JADX INFO: renamed from: b */
    public void mo236b(LinearSystem linearSystem, int i) {
        if (i == Integer.MAX_VALUE) {
            m224a(linearSystem.m180b(this.f303i), linearSystem.m180b(this.f304j), linearSystem.m180b(this.f305k), linearSystem.m180b(this.f306l));
            return;
        }
        if (i == -2) {
            m224a(this.f281aa, this.f282ab, this.f283ac, this.f284ad);
            return;
        }
        if (this.f303i.f249g == i) {
            this.f281aa = linearSystem.m180b(this.f303i);
        }
        if (this.f304j.f249g == i) {
            this.f282ab = linearSystem.m180b(this.f304j);
        }
        if (this.f305k.f249g == i) {
            this.f283ac = linearSystem.m180b(this.f305k);
        }
        if (this.f306l.f249g == i) {
            this.f284ad = linearSystem.m180b(this.f306l);
        }
    }
}
