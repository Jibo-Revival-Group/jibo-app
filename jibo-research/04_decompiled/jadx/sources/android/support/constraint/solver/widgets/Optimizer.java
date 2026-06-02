package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintWidget;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class Optimizer {
    /* JADX INFO: renamed from: a */
    static void m303a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, ConstraintWidget constraintWidget) {
        float f;
        float f2;
        float fM253h;
        int i2;
        int iM206d = 0;
        int i3 = 0;
        float f3 = CropImageView.DEFAULT_ASPECT_RATIO;
        ConstraintWidget constraintWidget2 = null;
        ConstraintWidget constraintWidget3 = constraintWidget;
        while (constraintWidget3 != null) {
            if (constraintWidget3.m243d() == 8) {
                i2 = i3;
            } else {
                i2 = i3 + 1;
                if (constraintWidget3.f260G != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    iM206d = (constraintWidget3.f305k.f245c != null ? constraintWidget3.f305k.m206d() : 0) + iM206d + constraintWidget3.m253h() + (constraintWidget3.f303i.f245c != null ? constraintWidget3.f303i.m206d() : 0);
                } else {
                    f3 = constraintWidget3.f276W + f3;
                }
            }
            ConstraintWidget constraintWidget4 = constraintWidget3.f305k.f245c != null ? constraintWidget3.f305k.f245c.f243a : null;
            if (constraintWidget4 != null && (constraintWidget4.f303i.f245c == null || (constraintWidget4.f303i.f245c != null && constraintWidget4.f303i.f245c.f243a != constraintWidget3))) {
                constraintWidget4 = null;
            }
            constraintWidget2 = constraintWidget3;
            constraintWidget3 = constraintWidget4;
            i3 = i2;
        }
        int iM249f = 0;
        if (constraintWidget2 != null) {
            iM249f = constraintWidget2.f305k.f245c != null ? constraintWidget2.f305k.f245c.f243a.m249f() : 0;
            if (constraintWidget2.f305k.f245c != null && constraintWidget2.f305k.f245c.f243a == constraintWidgetContainer) {
                iM249f = constraintWidgetContainer.m270t();
            }
        }
        float f4 = (iM249f - 0) - iM206d;
        float f5 = f4 / (i3 + 1);
        if (i == 0) {
            f = f5;
        } else {
            f = f4 / i;
            f5 = 0.0f;
        }
        while (constraintWidget != null) {
            int iM206d2 = constraintWidget.f303i.f245c != null ? constraintWidget.f303i.m206d() : 0;
            int iM206d3 = constraintWidget.f305k.f245c != null ? constraintWidget.f305k.m206d() : 0;
            if (constraintWidget.m243d() != 8) {
                float f6 = f5 + iM206d2;
                linearSystem.m177a(constraintWidget.f303i.f248f, (int) (0.5f + f6));
                if (constraintWidget.f260G != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    fM253h = constraintWidget.m253h() + f6;
                } else if (f3 == CropImageView.DEFAULT_ASPECT_RATIO) {
                    fM253h = ((f - iM206d2) - iM206d3) + f6;
                } else {
                    fM253h = ((((constraintWidget.f276W * f4) / f3) - iM206d2) - iM206d3) + f6;
                }
                linearSystem.m177a(constraintWidget.f305k.f248f, (int) (0.5f + fM253h));
                if (i == 0) {
                    fM253h += f;
                }
                f2 = fM253h + iM206d3;
            } else {
                float f7 = f5 - (f / 2.0f);
                linearSystem.m177a(constraintWidget.f303i.f248f, (int) (0.5f + f7));
                linearSystem.m177a(constraintWidget.f305k.f248f, (int) (f7 + 0.5f));
                f2 = f5;
            }
            ConstraintWidget constraintWidget5 = constraintWidget.f305k.f245c != null ? constraintWidget.f305k.f245c.f243a : null;
            if (constraintWidget5 != null && constraintWidget5.f303i.f245c != null && constraintWidget5.f303i.f245c.f243a != constraintWidget) {
                constraintWidget5 = null;
            }
            if (constraintWidget5 == constraintWidgetContainer) {
                constraintWidget5 = null;
            }
            f5 = f2;
            constraintWidget = constraintWidget5;
        }
    }

    /* JADX INFO: renamed from: b */
    static void m305b(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, ConstraintWidget constraintWidget) {
        float f;
        float f2;
        float fM261l;
        int i2;
        int iM206d = 0;
        int i3 = 0;
        float f3 = CropImageView.DEFAULT_ASPECT_RATIO;
        ConstraintWidget constraintWidget2 = null;
        ConstraintWidget constraintWidget3 = constraintWidget;
        while (constraintWidget3 != null) {
            if (constraintWidget3.m243d() == 8) {
                i2 = i3;
            } else {
                i2 = i3 + 1;
                if (constraintWidget3.f261H != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    iM206d = (constraintWidget3.f306l.f245c != null ? constraintWidget3.f306l.m206d() : 0) + iM206d + constraintWidget3.m261l() + (constraintWidget3.f304j.f245c != null ? constraintWidget3.f304j.m206d() : 0);
                } else {
                    f3 = constraintWidget3.f277X + f3;
                }
            }
            ConstraintWidget constraintWidget4 = constraintWidget3.f306l.f245c != null ? constraintWidget3.f306l.f245c.f243a : null;
            if (constraintWidget4 != null && (constraintWidget4.f304j.f245c == null || (constraintWidget4.f304j.f245c != null && constraintWidget4.f304j.f245c.f243a != constraintWidget3))) {
                constraintWidget4 = null;
            }
            constraintWidget2 = constraintWidget3;
            constraintWidget3 = constraintWidget4;
            i3 = i2;
        }
        int iM249f = 0;
        if (constraintWidget2 != null) {
            iM249f = constraintWidget2.f306l.f245c != null ? constraintWidget2.f306l.f245c.f243a.m249f() : 0;
            if (constraintWidget2.f306l.f245c != null && constraintWidget2.f306l.f245c.f243a == constraintWidgetContainer) {
                iM249f = constraintWidgetContainer.m271u();
            }
        }
        float f4 = (iM249f - 0) - iM206d;
        float f5 = f4 / (i3 + 1);
        if (i == 0) {
            f = f5;
        } else {
            f = f4 / i;
            f5 = 0.0f;
        }
        while (constraintWidget != null) {
            int iM206d2 = constraintWidget.f304j.f245c != null ? constraintWidget.f304j.m206d() : 0;
            int iM206d3 = constraintWidget.f306l.f245c != null ? constraintWidget.f306l.m206d() : 0;
            if (constraintWidget.m243d() != 8) {
                float f6 = f5 + iM206d2;
                linearSystem.m177a(constraintWidget.f304j.f248f, (int) (0.5f + f6));
                if (constraintWidget.f261H != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    fM261l = constraintWidget.m261l() + f6;
                } else if (f3 == CropImageView.DEFAULT_ASPECT_RATIO) {
                    fM261l = ((f - iM206d2) - iM206d3) + f6;
                } else {
                    fM261l = ((((constraintWidget.f277X * f4) / f3) - iM206d2) - iM206d3) + f6;
                }
                linearSystem.m177a(constraintWidget.f306l.f248f, (int) (0.5f + fM261l));
                if (i == 0) {
                    fM261l += f;
                }
                f2 = fM261l + iM206d3;
            } else {
                float f7 = f5 - (f / 2.0f);
                linearSystem.m177a(constraintWidget.f304j.f248f, (int) (0.5f + f7));
                linearSystem.m177a(constraintWidget.f306l.f248f, (int) (f7 + 0.5f));
                f2 = f5;
            }
            ConstraintWidget constraintWidget5 = constraintWidget.f306l.f245c != null ? constraintWidget.f306l.f245c.f243a : null;
            if (constraintWidget5 != null && constraintWidget5.f304j.f245c != null && constraintWidget5.f304j.f245c.f243a != constraintWidget) {
                constraintWidget5 = null;
            }
            if (constraintWidget5 == constraintWidgetContainer) {
                constraintWidget5 = null;
            }
            f5 = f2;
            constraintWidget = constraintWidget5;
        }
    }

    /* JADX INFO: renamed from: a */
    static void m304a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.f260G != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.f260G == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            constraintWidget.f303i.f248f = linearSystem.m173a(constraintWidget.f303i);
            constraintWidget.f305k.f248f = linearSystem.m173a(constraintWidget.f305k);
            int i = constraintWidget.f303i.f246d;
            int iH = constraintWidgetContainer.m253h() - constraintWidget.f305k.f246d;
            linearSystem.m177a(constraintWidget.f303i.f248f, i);
            linearSystem.m177a(constraintWidget.f305k.f248f, iH);
            constraintWidget.m242c(i, iH);
            constraintWidget.f280a = 2;
        }
        if (constraintWidgetContainer.f261H != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.f261H == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            constraintWidget.f304j.f248f = linearSystem.m173a(constraintWidget.f304j);
            constraintWidget.f306l.f248f = linearSystem.m173a(constraintWidget.f306l);
            int i2 = constraintWidget.f304j.f246d;
            int iL = constraintWidgetContainer.m261l() - constraintWidget.f306l.f246d;
            linearSystem.m177a(constraintWidget.f304j.f248f, i2);
            linearSystem.m177a(constraintWidget.f306l.f248f, iL);
            if (constraintWidget.f255A > 0 || constraintWidget.m243d() == 8) {
                constraintWidget.f307m.f248f = linearSystem.m173a(constraintWidget.f307m);
                linearSystem.m177a(constraintWidget.f307m.f248f, constraintWidget.f255A + i2);
            }
            constraintWidget.m246d(i2, iL);
            constraintWidget.f296b = 2;
        }
    }

    /* JADX INFO: renamed from: b */
    static void m306b(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        float fM296E;
        int iM253h;
        if (constraintWidget.f260G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            constraintWidget.f280a = 1;
            return;
        }
        if (constraintWidgetContainer.f260G != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.f260G == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            constraintWidget.f303i.f248f = linearSystem.m173a(constraintWidget.f303i);
            constraintWidget.f305k.f248f = linearSystem.m173a(constraintWidget.f305k);
            int i = constraintWidget.f303i.f246d;
            int iH = constraintWidgetContainer.m253h() - constraintWidget.f305k.f246d;
            linearSystem.m177a(constraintWidget.f303i.f248f, i);
            linearSystem.m177a(constraintWidget.f305k.f248f, iH);
            constraintWidget.m242c(i, iH);
            constraintWidget.f280a = 2;
            return;
        }
        if (constraintWidget.f303i.f245c != null && constraintWidget.f305k.f245c != null) {
            if (constraintWidget.f303i.f245c.f243a == constraintWidgetContainer && constraintWidget.f305k.f245c.f243a == constraintWidgetContainer) {
                int iM206d = constraintWidget.f303i.m206d();
                int iM206d2 = constraintWidget.f305k.m206d();
                if (constraintWidgetContainer.f260G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    iM253h = constraintWidgetContainer.m253h() - iM206d2;
                } else {
                    iM206d += (int) (((((constraintWidgetContainer.m253h() - iM206d) - iM206d2) - constraintWidget.m253h()) * constraintWidget.f258E) + 0.5f);
                    iM253h = constraintWidget.m253h() + iM206d;
                }
                constraintWidget.f303i.f248f = linearSystem.m173a(constraintWidget.f303i);
                constraintWidget.f305k.f248f = linearSystem.m173a(constraintWidget.f305k);
                linearSystem.m177a(constraintWidget.f303i.f248f, iM206d);
                linearSystem.m177a(constraintWidget.f305k.f248f, iM253h);
                constraintWidget.f280a = 2;
                constraintWidget.m242c(iM206d, iM253h);
                return;
            }
            constraintWidget.f280a = 1;
            return;
        }
        if (constraintWidget.f303i.f245c != null && constraintWidget.f303i.f245c.f243a == constraintWidgetContainer) {
            int iM206d3 = constraintWidget.f303i.m206d();
            int iM253h2 = constraintWidget.m253h() + iM206d3;
            constraintWidget.f303i.f248f = linearSystem.m173a(constraintWidget.f303i);
            constraintWidget.f305k.f248f = linearSystem.m173a(constraintWidget.f305k);
            linearSystem.m177a(constraintWidget.f303i.f248f, iM206d3);
            linearSystem.m177a(constraintWidget.f305k.f248f, iM253h2);
            constraintWidget.f280a = 2;
            constraintWidget.m242c(iM206d3, iM253h2);
            return;
        }
        if (constraintWidget.f305k.f245c != null && constraintWidget.f305k.f245c.f243a == constraintWidgetContainer) {
            constraintWidget.f303i.f248f = linearSystem.m173a(constraintWidget.f303i);
            constraintWidget.f305k.f248f = linearSystem.m173a(constraintWidget.f305k);
            int iH2 = constraintWidgetContainer.m253h() - constraintWidget.f305k.m206d();
            int iM253h3 = iH2 - constraintWidget.m253h();
            linearSystem.m177a(constraintWidget.f303i.f248f, iM253h3);
            linearSystem.m177a(constraintWidget.f305k.f248f, iH2);
            constraintWidget.f280a = 2;
            constraintWidget.m242c(iM253h3, iH2);
            return;
        }
        if (constraintWidget.f303i.f245c != null && constraintWidget.f303i.f245c.f243a.f280a == 2) {
            SolverVariable solverVariable = constraintWidget.f303i.f245c.f248f;
            constraintWidget.f303i.f248f = linearSystem.m173a(constraintWidget.f303i);
            constraintWidget.f305k.f248f = linearSystem.m173a(constraintWidget.f305k);
            int iM206d4 = (int) (solverVariable.f237d + constraintWidget.f303i.m206d() + 0.5f);
            int iM253h4 = constraintWidget.m253h() + iM206d4;
            linearSystem.m177a(constraintWidget.f303i.f248f, iM206d4);
            linearSystem.m177a(constraintWidget.f305k.f248f, iM253h4);
            constraintWidget.f280a = 2;
            constraintWidget.m242c(iM206d4, iM253h4);
            return;
        }
        if (constraintWidget.f305k.f245c != null && constraintWidget.f305k.f245c.f243a.f280a == 2) {
            SolverVariable solverVariable2 = constraintWidget.f305k.f245c.f248f;
            constraintWidget.f303i.f248f = linearSystem.m173a(constraintWidget.f303i);
            constraintWidget.f305k.f248f = linearSystem.m173a(constraintWidget.f305k);
            int iM206d5 = (int) ((solverVariable2.f237d - constraintWidget.f305k.m206d()) + 0.5f);
            int iM253h5 = iM206d5 - constraintWidget.m253h();
            linearSystem.m177a(constraintWidget.f303i.f248f, iM253h5);
            linearSystem.m177a(constraintWidget.f305k.f248f, iM206d5);
            constraintWidget.f280a = 2;
            constraintWidget.m242c(iM253h5, iM206d5);
            return;
        }
        boolean z = constraintWidget.f303i.f245c != null;
        boolean z2 = constraintWidget.f305k.f245c != null;
        if (!z && !z2) {
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.m295D() == 1) {
                    constraintWidget.f303i.f248f = linearSystem.m173a(constraintWidget.f303i);
                    constraintWidget.f305k.f248f = linearSystem.m173a(constraintWidget.f305k);
                    if (guideline.m297F() != -1) {
                        fM296E = guideline.m297F();
                    } else if (guideline.m298G() != -1) {
                        fM296E = constraintWidgetContainer.m253h() - guideline.m298G();
                    } else {
                        fM296E = guideline.m296E() * constraintWidgetContainer.m253h();
                    }
                    int i2 = (int) (fM296E + 0.5f);
                    linearSystem.m177a(constraintWidget.f303i.f248f, i2);
                    linearSystem.m177a(constraintWidget.f305k.f248f, i2);
                    constraintWidget.f280a = 2;
                    constraintWidget.f296b = 2;
                    constraintWidget.m242c(i2, i2);
                    constraintWidget.m246d(0, constraintWidgetContainer.m261l());
                    return;
                }
                return;
            }
            constraintWidget.f303i.f248f = linearSystem.m173a(constraintWidget.f303i);
            constraintWidget.f305k.f248f = linearSystem.m173a(constraintWidget.f305k);
            int iM249f = constraintWidget.m249f();
            int iM253h6 = constraintWidget.m253h() + iM249f;
            linearSystem.m177a(constraintWidget.f303i.f248f, iM249f);
            linearSystem.m177a(constraintWidget.f305k.f248f, iM253h6);
            constraintWidget.f280a = 2;
        }
    }

    /* JADX INFO: renamed from: c */
    static void m307c(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        float fM296E;
        int iM261l;
        if (constraintWidget.f261H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            constraintWidget.f296b = 1;
            return;
        }
        if (constraintWidgetContainer.f261H != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.f261H == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            constraintWidget.f304j.f248f = linearSystem.m173a(constraintWidget.f304j);
            constraintWidget.f306l.f248f = linearSystem.m173a(constraintWidget.f306l);
            int i = constraintWidget.f304j.f246d;
            int iL = constraintWidgetContainer.m261l() - constraintWidget.f306l.f246d;
            linearSystem.m177a(constraintWidget.f304j.f248f, i);
            linearSystem.m177a(constraintWidget.f306l.f248f, iL);
            if (constraintWidget.f255A > 0 || constraintWidget.m243d() == 8) {
                constraintWidget.f307m.f248f = linearSystem.m173a(constraintWidget.f307m);
                linearSystem.m177a(constraintWidget.f307m.f248f, constraintWidget.f255A + i);
            }
            constraintWidget.m246d(i, iL);
            constraintWidget.f296b = 2;
            return;
        }
        if (constraintWidget.f304j.f245c != null && constraintWidget.f306l.f245c != null) {
            if (constraintWidget.f304j.f245c.f243a == constraintWidgetContainer && constraintWidget.f306l.f245c.f243a == constraintWidgetContainer) {
                int iM206d = constraintWidget.f304j.m206d();
                int iM206d2 = constraintWidget.f306l.m206d();
                if (constraintWidgetContainer.f261H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    iM261l = constraintWidget.m261l() + iM206d;
                } else {
                    iM206d = (int) (((((constraintWidgetContainer.m261l() - iM206d) - iM206d2) - constraintWidget.m261l()) * constraintWidget.f259F) + iM206d + 0.5f);
                    iM261l = constraintWidget.m261l() + iM206d;
                }
                constraintWidget.f304j.f248f = linearSystem.m173a(constraintWidget.f304j);
                constraintWidget.f306l.f248f = linearSystem.m173a(constraintWidget.f306l);
                linearSystem.m177a(constraintWidget.f304j.f248f, iM206d);
                linearSystem.m177a(constraintWidget.f306l.f248f, iM261l);
                if (constraintWidget.f255A > 0 || constraintWidget.m243d() == 8) {
                    constraintWidget.f307m.f248f = linearSystem.m173a(constraintWidget.f307m);
                    linearSystem.m177a(constraintWidget.f307m.f248f, constraintWidget.f255A + iM206d);
                }
                constraintWidget.f296b = 2;
                constraintWidget.m246d(iM206d, iM261l);
                return;
            }
            constraintWidget.f296b = 1;
            return;
        }
        if (constraintWidget.f304j.f245c != null && constraintWidget.f304j.f245c.f243a == constraintWidgetContainer) {
            int iM206d3 = constraintWidget.f304j.m206d();
            int iM261l2 = constraintWidget.m261l() + iM206d3;
            constraintWidget.f304j.f248f = linearSystem.m173a(constraintWidget.f304j);
            constraintWidget.f306l.f248f = linearSystem.m173a(constraintWidget.f306l);
            linearSystem.m177a(constraintWidget.f304j.f248f, iM206d3);
            linearSystem.m177a(constraintWidget.f306l.f248f, iM261l2);
            if (constraintWidget.f255A > 0 || constraintWidget.m243d() == 8) {
                constraintWidget.f307m.f248f = linearSystem.m173a(constraintWidget.f307m);
                linearSystem.m177a(constraintWidget.f307m.f248f, constraintWidget.f255A + iM206d3);
            }
            constraintWidget.f296b = 2;
            constraintWidget.m246d(iM206d3, iM261l2);
            return;
        }
        if (constraintWidget.f306l.f245c != null && constraintWidget.f306l.f245c.f243a == constraintWidgetContainer) {
            constraintWidget.f304j.f248f = linearSystem.m173a(constraintWidget.f304j);
            constraintWidget.f306l.f248f = linearSystem.m173a(constraintWidget.f306l);
            int iL2 = constraintWidgetContainer.m261l() - constraintWidget.f306l.m206d();
            int iM261l3 = iL2 - constraintWidget.m261l();
            linearSystem.m177a(constraintWidget.f304j.f248f, iM261l3);
            linearSystem.m177a(constraintWidget.f306l.f248f, iL2);
            if (constraintWidget.f255A > 0 || constraintWidget.m243d() == 8) {
                constraintWidget.f307m.f248f = linearSystem.m173a(constraintWidget.f307m);
                linearSystem.m177a(constraintWidget.f307m.f248f, constraintWidget.f255A + iM261l3);
            }
            constraintWidget.f296b = 2;
            constraintWidget.m246d(iM261l3, iL2);
            return;
        }
        if (constraintWidget.f304j.f245c != null && constraintWidget.f304j.f245c.f243a.f296b == 2) {
            SolverVariable solverVariable = constraintWidget.f304j.f245c.f248f;
            constraintWidget.f304j.f248f = linearSystem.m173a(constraintWidget.f304j);
            constraintWidget.f306l.f248f = linearSystem.m173a(constraintWidget.f306l);
            int iM206d4 = (int) (solverVariable.f237d + constraintWidget.f304j.m206d() + 0.5f);
            int iM261l4 = constraintWidget.m261l() + iM206d4;
            linearSystem.m177a(constraintWidget.f304j.f248f, iM206d4);
            linearSystem.m177a(constraintWidget.f306l.f248f, iM261l4);
            if (constraintWidget.f255A > 0 || constraintWidget.m243d() == 8) {
                constraintWidget.f307m.f248f = linearSystem.m173a(constraintWidget.f307m);
                linearSystem.m177a(constraintWidget.f307m.f248f, constraintWidget.f255A + iM206d4);
            }
            constraintWidget.f296b = 2;
            constraintWidget.m246d(iM206d4, iM261l4);
            return;
        }
        if (constraintWidget.f306l.f245c != null && constraintWidget.f306l.f245c.f243a.f296b == 2) {
            SolverVariable solverVariable2 = constraintWidget.f306l.f245c.f248f;
            constraintWidget.f304j.f248f = linearSystem.m173a(constraintWidget.f304j);
            constraintWidget.f306l.f248f = linearSystem.m173a(constraintWidget.f306l);
            int iM206d5 = (int) ((solverVariable2.f237d - constraintWidget.f306l.m206d()) + 0.5f);
            int iM261l5 = iM206d5 - constraintWidget.m261l();
            linearSystem.m177a(constraintWidget.f304j.f248f, iM261l5);
            linearSystem.m177a(constraintWidget.f306l.f248f, iM206d5);
            if (constraintWidget.f255A > 0 || constraintWidget.m243d() == 8) {
                constraintWidget.f307m.f248f = linearSystem.m173a(constraintWidget.f307m);
                linearSystem.m177a(constraintWidget.f307m.f248f, constraintWidget.f255A + iM261l5);
            }
            constraintWidget.f296b = 2;
            constraintWidget.m246d(iM261l5, iM206d5);
            return;
        }
        if (constraintWidget.f307m.f245c != null && constraintWidget.f307m.f245c.f243a.f296b == 2) {
            SolverVariable solverVariable3 = constraintWidget.f307m.f245c.f248f;
            constraintWidget.f304j.f248f = linearSystem.m173a(constraintWidget.f304j);
            constraintWidget.f306l.f248f = linearSystem.m173a(constraintWidget.f306l);
            int i2 = (int) ((solverVariable3.f237d - constraintWidget.f255A) + 0.5f);
            int iM261l6 = constraintWidget.m261l() + i2;
            linearSystem.m177a(constraintWidget.f304j.f248f, i2);
            linearSystem.m177a(constraintWidget.f306l.f248f, iM261l6);
            constraintWidget.f307m.f248f = linearSystem.m173a(constraintWidget.f307m);
            linearSystem.m177a(constraintWidget.f307m.f248f, constraintWidget.f255A + i2);
            constraintWidget.f296b = 2;
            constraintWidget.m246d(i2, iM261l6);
            return;
        }
        boolean z = constraintWidget.f307m.f245c != null;
        boolean z2 = constraintWidget.f304j.f245c != null;
        boolean z3 = constraintWidget.f306l.f245c != null;
        if (!z && !z2 && !z3) {
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.m295D() == 0) {
                    constraintWidget.f304j.f248f = linearSystem.m173a(constraintWidget.f304j);
                    constraintWidget.f306l.f248f = linearSystem.m173a(constraintWidget.f306l);
                    if (guideline.m297F() != -1) {
                        fM296E = guideline.m297F();
                    } else if (guideline.m298G() != -1) {
                        fM296E = constraintWidgetContainer.m261l() - guideline.m298G();
                    } else {
                        fM296E = guideline.m296E() * constraintWidgetContainer.m261l();
                    }
                    int i3 = (int) (fM296E + 0.5f);
                    linearSystem.m177a(constraintWidget.f304j.f248f, i3);
                    linearSystem.m177a(constraintWidget.f306l.f248f, i3);
                    constraintWidget.f296b = 2;
                    constraintWidget.f280a = 2;
                    constraintWidget.m246d(i3, i3);
                    constraintWidget.m242c(0, constraintWidgetContainer.m253h());
                    return;
                }
                return;
            }
            constraintWidget.f304j.f248f = linearSystem.m173a(constraintWidget.f304j);
            constraintWidget.f306l.f248f = linearSystem.m173a(constraintWidget.f306l);
            int iM251g = constraintWidget.m251g();
            int iM261l7 = constraintWidget.m261l() + iM251g;
            linearSystem.m177a(constraintWidget.f304j.f248f, iM251g);
            linearSystem.m177a(constraintWidget.f306l.f248f, iM261l7);
            if (constraintWidget.f255A > 0 || constraintWidget.m243d() == 8) {
                constraintWidget.f307m.f248f = linearSystem.m173a(constraintWidget.f307m);
                linearSystem.m177a(constraintWidget.f307m.f248f, iM251g + constraintWidget.f255A);
            }
            constraintWidget.f296b = 2;
        }
    }
}
