package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.SolverVariable;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintAnchor {

    /* JADX INFO: renamed from: a */
    final ConstraintWidget f243a;

    /* JADX INFO: renamed from: b */
    final Type f244b;

    /* JADX INFO: renamed from: c */
    ConstraintAnchor f245c;

    /* JADX INFO: renamed from: f */
    SolverVariable f248f;

    /* JADX INFO: renamed from: d */
    public int f246d = 0;

    /* JADX INFO: renamed from: e */
    int f247e = -1;

    /* JADX INFO: renamed from: h */
    private Strength f250h = Strength.NONE;

    /* JADX INFO: renamed from: i */
    private ConnectionType f251i = ConnectionType.RELAXED;

    /* JADX INFO: renamed from: j */
    private int f252j = 0;

    /* JADX INFO: renamed from: g */
    int f249g = Integer.MAX_VALUE;

    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f243a = constraintWidget;
        this.f244b = type;
    }

    /* JADX INFO: renamed from: a */
    public SolverVariable m198a() {
        return this.f248f;
    }

    /* JADX INFO: renamed from: a */
    public void m199a(Cache cache) {
        if (this.f248f == null) {
            this.f248f = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            this.f248f.m196c();
        }
    }

    /* JADX INFO: renamed from: b */
    public ConstraintWidget m204b() {
        return this.f243a;
    }

    /* JADX INFO: renamed from: c */
    public Type m205c() {
        return this.f244b;
    }

    /* JADX INFO: renamed from: d */
    public int m206d() {
        if (this.f243a.m243d() == 8) {
            return 0;
        }
        if (this.f247e > -1 && this.f245c != null && this.f245c.f243a.m243d() == 8) {
            return this.f247e;
        }
        return this.f246d;
    }

    /* JADX INFO: renamed from: e */
    public Strength m207e() {
        return this.f250h;
    }

    /* JADX INFO: renamed from: f */
    public ConstraintAnchor m208f() {
        return this.f245c;
    }

    /* JADX INFO: renamed from: g */
    public ConnectionType m209g() {
        return this.f251i;
    }

    /* JADX INFO: renamed from: a */
    public void m200a(ConnectionType connectionType) {
        this.f251i = connectionType;
    }

    /* JADX INFO: renamed from: h */
    public int m210h() {
        return this.f252j;
    }

    /* JADX INFO: renamed from: i */
    public void m211i() {
        this.f245c = null;
        this.f246d = 0;
        this.f247e = -1;
        this.f250h = Strength.STRONG;
        this.f252j = 0;
        this.f251i = ConnectionType.RELAXED;
    }

    /* JADX INFO: renamed from: a */
    public boolean m203a(ConstraintAnchor constraintAnchor, int i, Strength strength, int i2) {
        return m202a(constraintAnchor, i, -1, strength, i2, false);
    }

    /* JADX INFO: renamed from: a */
    public boolean m202a(ConstraintAnchor constraintAnchor, int i, int i2, Strength strength, int i3, boolean z) {
        if (constraintAnchor == null) {
            this.f245c = null;
            this.f246d = 0;
            this.f247e = -1;
            this.f250h = Strength.NONE;
            this.f252j = 2;
            return true;
        }
        if (!z && !m201a(constraintAnchor)) {
            return false;
        }
        this.f245c = constraintAnchor;
        if (i > 0) {
            this.f246d = i;
        } else {
            this.f246d = 0;
        }
        this.f247e = i2;
        this.f250h = strength;
        this.f252j = i3;
        return true;
    }

    /* JADX INFO: renamed from: j */
    public boolean m212j() {
        return this.f245c != null;
    }

    /* JADX INFO: renamed from: a */
    public boolean m201a(ConstraintAnchor constraintAnchor) {
        boolean z;
        if (constraintAnchor == null) {
            return false;
        }
        Type typeM205c = constraintAnchor.m205c();
        if (typeM205c == this.f244b) {
            if (this.f244b != Type.CENTER) {
                return this.f244b != Type.BASELINE || (constraintAnchor.m204b().m272v() && m204b().m272v());
            }
            return false;
        }
        switch (this.f244b) {
            case CENTER:
                return (typeM205c == Type.BASELINE || typeM205c == Type.CENTER_X || typeM205c == Type.CENTER_Y) ? false : true;
            case LEFT:
            case RIGHT:
                z = typeM205c == Type.LEFT || typeM205c == Type.RIGHT;
                if (constraintAnchor.m204b() instanceof Guideline) {
                    return z || typeM205c == Type.CENTER_X;
                }
                break;
            case TOP:
            case BOTTOM:
                z = typeM205c == Type.TOP || typeM205c == Type.BOTTOM;
                if (constraintAnchor.m204b() instanceof Guideline) {
                    return z || typeM205c == Type.CENTER_Y;
                }
                break;
            default:
                return false;
        }
        return z;
    }

    public String toString() {
        return this.f243a.m247e() + ":" + this.f244b.toString() + (this.f245c != null ? " connected to " + this.f245c.m197a(new HashSet<>()) : "");
    }

    /* JADX INFO: renamed from: a */
    private String m197a(HashSet<ConstraintAnchor> hashSet) {
        if (hashSet.add(this)) {
            return this.f243a.m247e() + ":" + this.f244b.toString() + (this.f245c != null ? " connected to " + this.f245c.m197a(hashSet) : "");
        }
        return "<-";
    }
}
