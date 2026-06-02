package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends ConstraintWidget {

    /* JADX INFO: renamed from: aa */
    protected float f342aa = -1.0f;

    /* JADX INFO: renamed from: ab */
    protected int f343ab = -1;

    /* JADX INFO: renamed from: ac */
    protected int f344ac = -1;

    /* JADX INFO: renamed from: ad */
    private ConstraintAnchor f345ad = this.f304j;

    /* JADX INFO: renamed from: ae */
    private int f346ae = 0;

    /* JADX INFO: renamed from: af */
    private boolean f347af = false;

    /* JADX INFO: renamed from: ag */
    private int f348ag = 0;

    /* JADX INFO: renamed from: ah */
    private Rectangle f349ah = new Rectangle();

    /* JADX INFO: renamed from: ai */
    private int f350ai = 8;

    public Guideline() {
        this.f311q.clear();
        this.f311q.add(this.f345ad);
    }

    /* JADX INFO: renamed from: m */
    public void m300m(int i) {
        if (this.f346ae != i) {
            this.f346ae = i;
            this.f311q.clear();
            if (this.f346ae == 1) {
                this.f345ad = this.f303i;
            } else {
                this.f345ad = this.f304j;
            }
            this.f311q.add(this.f345ad);
        }
    }

    /* JADX INFO: renamed from: D */
    public int m295D() {
        return this.f346ae;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    /* JADX INFO: renamed from: a */
    public ConstraintAnchor mo218a(ConstraintAnchor.Type type) {
        switch (type) {
            case LEFT:
            case RIGHT:
                if (this.f346ae == 1) {
                    return this.f345ad;
                }
                return null;
            case TOP:
            case BOTTOM:
                if (this.f346ae == 0) {
                    return this.f345ad;
                }
                return null;
            default:
                return null;
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    /* JADX INFO: renamed from: y */
    public ArrayList<ConstraintAnchor> mo275y() {
        return this.f311q;
    }

    /* JADX INFO: renamed from: e */
    public void m299e(float f) {
        if (f > -1.0f) {
            this.f342aa = f;
            this.f343ab = -1;
            this.f344ac = -1;
        }
    }

    /* JADX INFO: renamed from: n */
    public void m301n(int i) {
        if (i > -1) {
            this.f342aa = -1.0f;
            this.f343ab = i;
            this.f344ac = -1;
        }
    }

    /* JADX INFO: renamed from: o */
    public void m302o(int i) {
        if (i > -1) {
            this.f342aa = -1.0f;
            this.f343ab = -1;
            this.f344ac = i;
        }
    }

    /* JADX INFO: renamed from: E */
    public float m296E() {
        return this.f342aa;
    }

    /* JADX INFO: renamed from: F */
    public int m297F() {
        return this.f343ab;
    }

    /* JADX INFO: renamed from: G */
    public int m298G() {
        return this.f344ac;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    /* JADX INFO: renamed from: a */
    public void mo226a(LinearSystem linearSystem, int i) {
        ConstraintAnchor constraintAnchorA;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) m239c();
        if (constraintWidgetContainer != null) {
            ConstraintAnchor constraintAnchorA2 = constraintWidgetContainer.mo218a(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor constraintAnchorA3 = constraintWidgetContainer.mo218a(ConstraintAnchor.Type.RIGHT);
            if (this.f346ae == 0) {
                ConstraintAnchor constraintAnchorA4 = constraintWidgetContainer.mo218a(ConstraintAnchor.Type.TOP);
                constraintAnchorA = constraintWidgetContainer.mo218a(ConstraintAnchor.Type.BOTTOM);
                constraintAnchorA2 = constraintAnchorA4;
            } else {
                constraintAnchorA = constraintAnchorA3;
            }
            if (this.f343ab != -1) {
                linearSystem.m175a(LinearSystem.m159a(linearSystem, linearSystem.m173a(this.f345ad), linearSystem.m173a(constraintAnchorA2), this.f343ab, false));
            } else if (this.f344ac != -1) {
                linearSystem.m175a(LinearSystem.m159a(linearSystem, linearSystem.m173a(this.f345ad), linearSystem.m173a(constraintAnchorA), -this.f344ac, false));
            } else if (this.f342aa != -1.0f) {
                linearSystem.m175a(LinearSystem.m160a(linearSystem, linearSystem.m173a(this.f345ad), linearSystem.m173a(constraintAnchorA2), linearSystem.m173a(constraintAnchorA), this.f342aa, this.f347af));
            }
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    /* JADX INFO: renamed from: b */
    public void mo236b(LinearSystem linearSystem, int i) {
        if (m239c() != null) {
            int iM180b = linearSystem.m180b(this.f345ad);
            if (this.f346ae == 1) {
                m233b(iM180b);
                m241c(0);
                m248e(m239c().m261l());
                m245d(0);
                return;
            }
            m233b(0);
            m241c(iM180b);
            m245d(m239c().m253h());
            m248e(0);
        }
    }
}
