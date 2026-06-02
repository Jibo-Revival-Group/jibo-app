package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {

    /* JADX INFO: renamed from: ac */
    static boolean f322ac = true;

    /* JADX INFO: renamed from: ad */
    int f325ad;

    /* JADX INFO: renamed from: ae */
    int f326ae;

    /* JADX INFO: renamed from: af */
    int f327af;

    /* JADX INFO: renamed from: ag */
    int f328ag;

    /* JADX INFO: renamed from: ah */
    int f329ah;

    /* JADX INFO: renamed from: ai */
    int f330ai;

    /* JADX INFO: renamed from: ak */
    private Snapshot f331ak;

    /* JADX INFO: renamed from: aa */
    protected LinearSystem f323aa = new LinearSystem();

    /* JADX INFO: renamed from: ab */
    protected LinearSystem f324ab = null;

    /* JADX INFO: renamed from: al */
    private int f332al = 0;

    /* JADX INFO: renamed from: am */
    private int f333am = 0;

    /* JADX INFO: renamed from: an */
    private ConstraintWidget[] f334an = new ConstraintWidget[4];

    /* JADX INFO: renamed from: ao */
    private ConstraintWidget[] f335ao = new ConstraintWidget[4];

    /* JADX INFO: renamed from: ap */
    private ConstraintWidget[] f336ap = new ConstraintWidget[4];

    /* JADX INFO: renamed from: aq */
    private int f337aq = 2;

    /* JADX INFO: renamed from: ar */
    private boolean[] f338ar = new boolean[3];

    /* JADX INFO: renamed from: as */
    private ConstraintWidget[] f339as = new ConstraintWidget[4];

    /* JADX INFO: renamed from: at */
    private boolean f340at = false;

    /* JADX INFO: renamed from: au */
    private boolean f341au = false;

    /* JADX INFO: renamed from: m */
    public void m294m(int i) {
        this.f337aq = i;
    }

    @Override // android.support.constraint.solver.widgets.WidgetContainer, android.support.constraint.solver.widgets.ConstraintWidget
    /* JADX INFO: renamed from: a */
    public void mo219a() {
        this.f323aa.m174a();
        this.f327af = 0;
        this.f329ah = 0;
        this.f328ag = 0;
        this.f330ai = 0;
        super.mo219a();
    }

    /* JADX INFO: renamed from: D */
    public boolean m284D() {
        return this.f340at;
    }

    /* JADX INFO: renamed from: E */
    public boolean m285E() {
        return this.f341au;
    }

    /* JADX INFO: renamed from: c */
    public boolean m293c(LinearSystem linearSystem, int i) {
        boolean z;
        mo226a(linearSystem, i);
        int size = this.f362aj.size();
        if (this.f337aq == 2 || this.f337aq == 4) {
            if (m279a(linearSystem)) {
                return false;
            }
            z = false;
        } else {
            z = true;
        }
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.f362aj.get(i2);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.f260G;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.f261H;
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.m228a(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.m237b(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.mo226a(linearSystem, i);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.m228a(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.m237b(dimensionBehaviour2);
                }
            } else {
                if (z) {
                    Optimizer.m304a(this, linearSystem, constraintWidget);
                }
                constraintWidget.mo226a(linearSystem, i);
            }
        }
        if (this.f332al > 0) {
            m280b(linearSystem);
        }
        if (this.f333am > 0) {
            m281c(linearSystem);
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m279a(LinearSystem linearSystem) {
        boolean z;
        int size = this.f362aj.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.f362aj.get(i);
            constraintWidget.f280a = -1;
            constraintWidget.f296b = -1;
            if (constraintWidget.f260G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.f261H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidget.f280a = 1;
                constraintWidget.f296b = 1;
            }
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        while (!z2) {
            int i5 = i2 + 1;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < size) {
                ConstraintWidget constraintWidget2 = this.f362aj.get(i6);
                if (constraintWidget2.f280a == -1) {
                    if (this.f260G == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget2.f280a = 1;
                    } else {
                        Optimizer.m306b(this, linearSystem, constraintWidget2);
                    }
                }
                if (constraintWidget2.f296b == -1) {
                    if (this.f261H == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget2.f296b = 1;
                    } else {
                        Optimizer.m307c(this, linearSystem, constraintWidget2);
                    }
                }
                if (constraintWidget2.f296b == -1) {
                    i8++;
                }
                i6++;
                i7 = constraintWidget2.f280a == -1 ? i7 + 1 : i7;
            }
            if (i8 == 0 && i7 == 0) {
                z = true;
            } else {
                z = (i4 == i8 && i3 == i7) ? true : z2;
            }
            i3 = i7;
            i4 = i8;
            z2 = z;
            i2 = i5;
        }
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < size) {
            ConstraintWidget constraintWidget3 = this.f362aj.get(i9);
            if (constraintWidget3.f280a == 1 || constraintWidget3.f280a == -1) {
                i11++;
            }
            i9++;
            i10 = (constraintWidget3.f296b == 1 || constraintWidget3.f296b == -1) ? i10 + 1 : i10;
        }
        return i11 == 0 && i10 == 0;
    }

    /* JADX INFO: renamed from: b */
    private void m280b(LinearSystem linearSystem) {
        boolean z;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        int iM206d;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f332al) {
                ConstraintWidget constraintWidget4 = this.f336ap[i2];
                int iM278a = m278a(linearSystem, this.f339as, this.f336ap[i2], 0, this.f338ar);
                ConstraintWidget constraintWidget5 = this.f339as[2];
                if (constraintWidget5 != null) {
                    if (this.f338ar[1]) {
                        int iM264n = constraintWidget4.m264n();
                        while (constraintWidget5 != null) {
                            linearSystem.m177a(constraintWidget5.f303i.f248f, iM264n);
                            ConstraintWidget constraintWidget6 = constraintWidget5.f278Y;
                            iM264n += constraintWidget5.f303i.m206d() + constraintWidget5.m253h() + constraintWidget5.f305k.m206d();
                            constraintWidget5 = constraintWidget6;
                        }
                    } else {
                        boolean z2 = constraintWidget4.f272S == 0;
                        boolean z3 = constraintWidget4.f272S == 2;
                        boolean z4 = this.f260G == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        if ((this.f337aq == 2 || this.f337aq == 8) && this.f338ar[0] && constraintWidget4.f274U && !z3 && !z4 && constraintWidget4.f272S == 0) {
                            Optimizer.m303a(this, linearSystem, iM278a, constraintWidget4);
                        } else if (iM278a == 0 || z3) {
                            ConstraintWidget constraintWidget7 = null;
                            boolean z5 = false;
                            ConstraintWidget constraintWidget8 = null;
                            ConstraintWidget constraintWidget9 = constraintWidget5;
                            while (constraintWidget9 != null) {
                                ConstraintWidget constraintWidget10 = constraintWidget9.f278Y;
                                if (constraintWidget10 == null) {
                                    z = true;
                                    constraintWidget = this.f339as[1];
                                } else {
                                    z = z5;
                                    constraintWidget = constraintWidget7;
                                }
                                if (z3) {
                                    ConstraintAnchor constraintAnchor = constraintWidget9.f303i;
                                    int iM206d2 = constraintAnchor.m206d();
                                    int iM206d3 = constraintWidget8 != null ? iM206d2 + constraintWidget8.f305k.m206d() : iM206d2;
                                    int i3 = 1;
                                    if (constraintWidget5 != constraintWidget9) {
                                        i3 = 3;
                                    }
                                    linearSystem.m179a(constraintAnchor.f248f, constraintAnchor.f245c.f248f, iM206d3, i3);
                                    if (constraintWidget9.f260G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                        ConstraintAnchor constraintAnchor2 = constraintWidget9.f305k;
                                        if (constraintWidget9.f297c == 1) {
                                            linearSystem.m183c(constraintAnchor2.f248f, constraintAnchor.f248f, Math.max(constraintWidget9.f299e, constraintWidget9.m253h()), 3);
                                        } else {
                                            linearSystem.m179a(constraintAnchor.f248f, constraintAnchor.f245c.f248f, constraintAnchor.f246d, 3);
                                            linearSystem.m182b(constraintAnchor2.f248f, constraintAnchor.f248f, constraintWidget9.f299e, 3);
                                        }
                                    }
                                    constraintWidget3 = constraintWidget10;
                                } else if (!z2 && z && constraintWidget8 != null) {
                                    if (constraintWidget9.f305k.f245c == null) {
                                        linearSystem.m177a(constraintWidget9.f305k.f248f, constraintWidget9.m267q());
                                        constraintWidget3 = constraintWidget10;
                                    } else {
                                        linearSystem.m183c(constraintWidget9.f305k.f248f, constraintWidget.f305k.f245c.f248f, -constraintWidget9.f305k.m206d(), 5);
                                        constraintWidget3 = constraintWidget10;
                                    }
                                } else if (!z2 && !z && constraintWidget8 == null) {
                                    if (constraintWidget9.f303i.f245c == null) {
                                        linearSystem.m177a(constraintWidget9.f303i.f248f, constraintWidget9.m264n());
                                        constraintWidget3 = constraintWidget10;
                                    } else {
                                        linearSystem.m183c(constraintWidget9.f303i.f248f, constraintWidget4.f303i.f245c.f248f, constraintWidget9.f303i.m206d(), 5);
                                        constraintWidget3 = constraintWidget10;
                                    }
                                } else {
                                    ConstraintAnchor constraintAnchor3 = constraintWidget9.f303i;
                                    ConstraintAnchor constraintAnchor4 = constraintWidget9.f305k;
                                    int iM206d4 = constraintAnchor3.m206d();
                                    int iM206d5 = constraintAnchor4.m206d();
                                    linearSystem.m179a(constraintAnchor3.f248f, constraintAnchor3.f245c.f248f, iM206d4, 1);
                                    linearSystem.m182b(constraintAnchor4.f248f, constraintAnchor4.f245c.f248f, -iM206d5, 1);
                                    SolverVariable solverVariable = constraintAnchor3.f245c != null ? constraintAnchor3.f245c.f248f : null;
                                    if (constraintWidget8 == null) {
                                        solverVariable = constraintWidget4.f303i.f245c != null ? constraintWidget4.f303i.f245c.f248f : null;
                                    }
                                    if (constraintWidget10 == null) {
                                        constraintWidget2 = constraintWidget.f305k.f245c != null ? constraintWidget.f305k.f245c.f243a : null;
                                    } else {
                                        constraintWidget2 = constraintWidget10;
                                    }
                                    if (constraintWidget2 != null) {
                                        SolverVariable solverVariable2 = constraintWidget2.f303i.f248f;
                                        if (z) {
                                            solverVariable2 = constraintWidget.f305k.f245c != null ? constraintWidget.f305k.f245c.f248f : null;
                                        }
                                        if (solverVariable != null && solverVariable2 != null) {
                                            linearSystem.m178a(constraintAnchor3.f248f, solverVariable, iM206d4, 0.5f, solverVariable2, constraintAnchor4.f248f, iM206d5, 4);
                                        }
                                    }
                                    constraintWidget3 = constraintWidget2;
                                }
                                if (z) {
                                    constraintWidget3 = null;
                                }
                                constraintWidget7 = constraintWidget;
                                constraintWidget8 = constraintWidget9;
                                constraintWidget9 = constraintWidget3;
                                z5 = z;
                            }
                            if (z3) {
                                ConstraintAnchor constraintAnchor5 = constraintWidget5.f303i;
                                ConstraintAnchor constraintAnchor6 = constraintWidget7.f305k;
                                int iM206d6 = constraintAnchor5.m206d();
                                int iM206d7 = constraintAnchor6.m206d();
                                SolverVariable solverVariable3 = constraintWidget4.f303i.f245c != null ? constraintWidget4.f303i.f245c.f248f : null;
                                SolverVariable solverVariable4 = constraintWidget7.f305k.f245c != null ? constraintWidget7.f305k.f245c.f248f : null;
                                if (solverVariable3 != null && solverVariable4 != null) {
                                    linearSystem.m182b(constraintAnchor6.f248f, solverVariable4, -iM206d7, 1);
                                    linearSystem.m178a(constraintAnchor5.f248f, solverVariable3, iM206d6, constraintWidget4.f258E, solverVariable4, constraintAnchor6.f248f, iM206d7, 4);
                                }
                            }
                        } else {
                            float f = CropImageView.DEFAULT_ASPECT_RATIO;
                            ConstraintWidget constraintWidget11 = null;
                            for (ConstraintWidget constraintWidget12 = constraintWidget5; constraintWidget12 != null; constraintWidget12 = constraintWidget12.f278Y) {
                                if (constraintWidget12.f260G != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                    int iM206d8 = constraintWidget12.f303i.m206d();
                                    if (constraintWidget11 != null) {
                                        iM206d8 += constraintWidget11.f305k.m206d();
                                    }
                                    int i4 = 3;
                                    if (constraintWidget12.f303i.f245c.f243a.f260G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                        i4 = 2;
                                    }
                                    linearSystem.m179a(constraintWidget12.f303i.f248f, constraintWidget12.f303i.f245c.f248f, iM206d8, i4);
                                    int iM206d9 = constraintWidget12.f305k.m206d();
                                    if (constraintWidget12.f305k.f245c.f243a.f303i.f245c != null && constraintWidget12.f305k.f245c.f243a.f303i.f245c.f243a == constraintWidget12) {
                                        iM206d9 += constraintWidget12.f305k.f245c.f243a.f303i.m206d();
                                    }
                                    int i5 = 3;
                                    if (constraintWidget12.f305k.f245c.f243a.f260G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                        i5 = 2;
                                    }
                                    linearSystem.m182b(constraintWidget12.f305k.f248f, constraintWidget12.f305k.f245c.f248f, -iM206d9, i5);
                                } else {
                                    f += constraintWidget12.f276W;
                                    int iM206d10 = 0;
                                    if (constraintWidget12.f305k.f245c != null) {
                                        iM206d10 = constraintWidget12.f305k.m206d();
                                        if (constraintWidget12 != this.f339as[3]) {
                                            iM206d10 += constraintWidget12.f305k.f245c.f243a.f303i.m206d();
                                        }
                                    }
                                    linearSystem.m179a(constraintWidget12.f305k.f248f, constraintWidget12.f303i.f248f, 0, 1);
                                    linearSystem.m182b(constraintWidget12.f305k.f248f, constraintWidget12.f305k.f245c.f248f, -iM206d10, 1);
                                }
                                constraintWidget11 = constraintWidget12;
                            }
                            if (iM278a == 1) {
                                ConstraintWidget constraintWidget13 = this.f334an[0];
                                int iM206d11 = constraintWidget13.f303i.m206d();
                                if (constraintWidget13.f303i.f245c != null) {
                                    iM206d11 += constraintWidget13.f303i.f245c.m206d();
                                }
                                int iM206d12 = constraintWidget13.f305k.m206d();
                                if (constraintWidget13.f305k.f245c != null) {
                                    iM206d12 += constraintWidget13.f305k.f245c.m206d();
                                }
                                SolverVariable solverVariable5 = constraintWidget4.f305k.f245c.f248f;
                                if (constraintWidget13 == this.f339as[3]) {
                                    solverVariable5 = this.f339as[1].f305k.f245c.f248f;
                                }
                                if (constraintWidget13.f297c == 1) {
                                    linearSystem.m179a(constraintWidget4.f303i.f248f, constraintWidget4.f303i.f245c.f248f, iM206d11, 1);
                                    linearSystem.m182b(constraintWidget4.f305k.f248f, solverVariable5, -iM206d12, 1);
                                    linearSystem.m183c(constraintWidget4.f305k.f248f, constraintWidget4.f303i.f248f, constraintWidget4.m253h(), 2);
                                } else {
                                    linearSystem.m183c(constraintWidget13.f303i.f248f, constraintWidget13.f303i.f245c.f248f, iM206d11, 1);
                                    linearSystem.m183c(constraintWidget13.f305k.f248f, solverVariable5, -iM206d12, 1);
                                }
                            } else {
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 < iM278a - 1) {
                                        ConstraintWidget constraintWidget14 = this.f334an[i7];
                                        ConstraintWidget constraintWidget15 = this.f334an[i7 + 1];
                                        SolverVariable solverVariable6 = constraintWidget14.f303i.f248f;
                                        SolverVariable solverVariable7 = constraintWidget14.f305k.f248f;
                                        SolverVariable solverVariable8 = constraintWidget15.f303i.f248f;
                                        SolverVariable solverVariable9 = constraintWidget15.f305k.f248f;
                                        if (constraintWidget15 == this.f339as[3]) {
                                            solverVariable9 = this.f339as[1].f305k.f248f;
                                        }
                                        int iM206d13 = constraintWidget14.f303i.m206d();
                                        if (constraintWidget14.f303i.f245c != null && constraintWidget14.f303i.f245c.f243a.f305k.f245c != null && constraintWidget14.f303i.f245c.f243a.f305k.f245c.f243a == constraintWidget14) {
                                            iM206d13 += constraintWidget14.f303i.f245c.f243a.f305k.m206d();
                                        }
                                        linearSystem.m179a(solverVariable6, constraintWidget14.f303i.f245c.f248f, iM206d13, 2);
                                        int iM206d14 = constraintWidget14.f305k.m206d();
                                        if (constraintWidget14.f305k.f245c == null || constraintWidget14.f278Y == null) {
                                            iM206d = iM206d14;
                                        } else {
                                            iM206d = (constraintWidget14.f278Y.f303i.f245c != null ? constraintWidget14.f278Y.f303i.m206d() : 0) + iM206d14;
                                        }
                                        linearSystem.m182b(solverVariable7, constraintWidget14.f305k.f245c.f248f, -iM206d, 2);
                                        if (i7 + 1 == iM278a - 1) {
                                            int iM206d15 = constraintWidget15.f303i.m206d();
                                            if (constraintWidget15.f303i.f245c != null && constraintWidget15.f303i.f245c.f243a.f305k.f245c != null && constraintWidget15.f303i.f245c.f243a.f305k.f245c.f243a == constraintWidget15) {
                                                iM206d15 += constraintWidget15.f303i.f245c.f243a.f305k.m206d();
                                            }
                                            linearSystem.m179a(solverVariable8, constraintWidget15.f303i.f245c.f248f, iM206d15, 2);
                                            ConstraintAnchor constraintAnchor7 = constraintWidget15.f305k;
                                            if (constraintWidget15 == this.f339as[3]) {
                                                constraintAnchor7 = this.f339as[1].f305k;
                                            }
                                            int iM206d16 = constraintAnchor7.m206d();
                                            if (constraintAnchor7.f245c != null && constraintAnchor7.f245c.f243a.f303i.f245c != null && constraintAnchor7.f245c.f243a.f303i.f245c.f243a == constraintWidget15) {
                                                iM206d16 += constraintAnchor7.f245c.f243a.f303i.m206d();
                                            }
                                            linearSystem.m182b(solverVariable9, constraintAnchor7.f245c.f248f, -iM206d16, 2);
                                        }
                                        if (constraintWidget4.f300f > 0) {
                                            linearSystem.m182b(solverVariable7, solverVariable6, constraintWidget4.f300f, 2);
                                        }
                                        ArrayRow arrayRowM181b = linearSystem.m181b();
                                        arrayRowM181b.m135a(constraintWidget14.f276W, f, constraintWidget15.f276W, solverVariable6, constraintWidget14.f303i.m206d(), solverVariable7, constraintWidget14.f305k.m206d(), solverVariable8, constraintWidget15.f303i.m206d(), solverVariable9, constraintWidget15.f305k.m206d());
                                        linearSystem.m175a(arrayRowM181b);
                                        i6 = i7 + 1;
                                    }
                                }
                            }
                        }
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m281c(LinearSystem linearSystem) {
        boolean z;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        int iM206d;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f333am) {
                ConstraintWidget constraintWidget4 = this.f335ao[i2];
                int iM278a = m278a(linearSystem, this.f339as, this.f335ao[i2], 1, this.f338ar);
                ConstraintWidget constraintWidget5 = this.f339as[2];
                if (constraintWidget5 != null) {
                    if (this.f338ar[1]) {
                        int iM265o = constraintWidget4.m265o();
                        while (constraintWidget5 != null) {
                            linearSystem.m177a(constraintWidget5.f304j.f248f, iM265o);
                            ConstraintWidget constraintWidget6 = constraintWidget5.f279Z;
                            iM265o += constraintWidget5.f304j.m206d() + constraintWidget5.m261l() + constraintWidget5.f306l.m206d();
                            constraintWidget5 = constraintWidget6;
                        }
                    } else {
                        boolean z2 = constraintWidget4.f273T == 0;
                        boolean z3 = constraintWidget4.f273T == 2;
                        boolean z4 = this.f261H == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        if ((this.f337aq == 2 || this.f337aq == 8) && this.f338ar[0] && constraintWidget4.f275V && !z3 && !z4 && constraintWidget4.f273T == 0) {
                            Optimizer.m305b(this, linearSystem, iM278a, constraintWidget4);
                        } else if (iM278a == 0 || z3) {
                            ConstraintWidget constraintWidget7 = null;
                            boolean z5 = false;
                            ConstraintWidget constraintWidget8 = null;
                            ConstraintWidget constraintWidget9 = constraintWidget5;
                            while (constraintWidget9 != null) {
                                ConstraintWidget constraintWidget10 = constraintWidget9.f279Z;
                                if (constraintWidget10 == null) {
                                    z = true;
                                    constraintWidget = this.f339as[1];
                                } else {
                                    z = z5;
                                    constraintWidget = constraintWidget7;
                                }
                                if (z3) {
                                    ConstraintAnchor constraintAnchor = constraintWidget9.f304j;
                                    int iM206d2 = constraintAnchor.m206d();
                                    if (constraintWidget8 != null) {
                                        iM206d2 += constraintWidget8.f306l.m206d();
                                    }
                                    int i3 = 1;
                                    if (constraintWidget5 != constraintWidget9) {
                                        i3 = 3;
                                    }
                                    SolverVariable solverVariable = null;
                                    SolverVariable solverVariable2 = null;
                                    if (constraintAnchor.f245c != null) {
                                        solverVariable = constraintAnchor.f248f;
                                        solverVariable2 = constraintAnchor.f245c.f248f;
                                    } else if (constraintWidget9.f307m.f245c != null) {
                                        solverVariable = constraintWidget9.f307m.f248f;
                                        solverVariable2 = constraintWidget9.f307m.f245c.f248f;
                                        iM206d2 -= constraintAnchor.m206d();
                                    }
                                    if (solverVariable != null && solverVariable2 != null) {
                                        linearSystem.m179a(solverVariable, solverVariable2, iM206d2, i3);
                                    }
                                    if (constraintWidget9.f261H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                        ConstraintAnchor constraintAnchor2 = constraintWidget9.f306l;
                                        if (constraintWidget9.f298d == 1) {
                                            linearSystem.m183c(constraintAnchor2.f248f, constraintAnchor.f248f, Math.max(constraintWidget9.f301g, constraintWidget9.m261l()), 3);
                                        } else {
                                            linearSystem.m179a(constraintAnchor.f248f, constraintAnchor.f245c.f248f, constraintAnchor.f246d, 3);
                                            linearSystem.m182b(constraintAnchor2.f248f, constraintAnchor.f248f, constraintWidget9.f301g, 3);
                                        }
                                    }
                                    constraintWidget3 = constraintWidget10;
                                } else if (!z2 && z && constraintWidget8 != null) {
                                    if (constraintWidget9.f306l.f245c == null) {
                                        linearSystem.m177a(constraintWidget9.f306l.f248f, constraintWidget9.m266p());
                                        constraintWidget3 = constraintWidget10;
                                    } else {
                                        linearSystem.m183c(constraintWidget9.f306l.f248f, constraintWidget.f306l.f245c.f248f, -constraintWidget9.f306l.m206d(), 5);
                                        constraintWidget3 = constraintWidget10;
                                    }
                                } else if (!z2 && !z && constraintWidget8 == null) {
                                    if (constraintWidget9.f304j.f245c == null) {
                                        linearSystem.m177a(constraintWidget9.f304j.f248f, constraintWidget9.m265o());
                                        constraintWidget3 = constraintWidget10;
                                    } else {
                                        linearSystem.m183c(constraintWidget9.f304j.f248f, constraintWidget4.f304j.f245c.f248f, constraintWidget9.f304j.m206d(), 5);
                                        constraintWidget3 = constraintWidget10;
                                    }
                                } else {
                                    ConstraintAnchor constraintAnchor3 = constraintWidget9.f304j;
                                    ConstraintAnchor constraintAnchor4 = constraintWidget9.f306l;
                                    int iM206d3 = constraintAnchor3.m206d();
                                    int iM206d4 = constraintAnchor4.m206d();
                                    linearSystem.m179a(constraintAnchor3.f248f, constraintAnchor3.f245c.f248f, iM206d3, 1);
                                    linearSystem.m182b(constraintAnchor4.f248f, constraintAnchor4.f245c.f248f, -iM206d4, 1);
                                    SolverVariable solverVariable3 = constraintAnchor3.f245c != null ? constraintAnchor3.f245c.f248f : null;
                                    if (constraintWidget8 == null) {
                                        solverVariable3 = constraintWidget4.f304j.f245c != null ? constraintWidget4.f304j.f245c.f248f : null;
                                    }
                                    if (constraintWidget10 == null) {
                                        constraintWidget2 = constraintWidget.f306l.f245c != null ? constraintWidget.f306l.f245c.f243a : null;
                                    } else {
                                        constraintWidget2 = constraintWidget10;
                                    }
                                    if (constraintWidget2 != null) {
                                        SolverVariable solverVariable4 = constraintWidget2.f304j.f248f;
                                        if (z) {
                                            solverVariable4 = constraintWidget.f306l.f245c != null ? constraintWidget.f306l.f245c.f248f : null;
                                        }
                                        if (solverVariable3 != null && solverVariable4 != null) {
                                            linearSystem.m178a(constraintAnchor3.f248f, solverVariable3, iM206d3, 0.5f, solverVariable4, constraintAnchor4.f248f, iM206d4, 4);
                                        }
                                    }
                                    constraintWidget3 = constraintWidget2;
                                }
                                if (z) {
                                    constraintWidget3 = null;
                                }
                                constraintWidget7 = constraintWidget;
                                constraintWidget8 = constraintWidget9;
                                constraintWidget9 = constraintWidget3;
                                z5 = z;
                            }
                            if (z3) {
                                ConstraintAnchor constraintAnchor5 = constraintWidget5.f304j;
                                ConstraintAnchor constraintAnchor6 = constraintWidget7.f306l;
                                int iM206d5 = constraintAnchor5.m206d();
                                int iM206d6 = constraintAnchor6.m206d();
                                SolverVariable solverVariable5 = constraintWidget4.f304j.f245c != null ? constraintWidget4.f304j.f245c.f248f : null;
                                SolverVariable solverVariable6 = constraintWidget7.f306l.f245c != null ? constraintWidget7.f306l.f245c.f248f : null;
                                if (solverVariable5 != null && solverVariable6 != null) {
                                    linearSystem.m182b(constraintAnchor6.f248f, solverVariable6, -iM206d6, 1);
                                    linearSystem.m178a(constraintAnchor5.f248f, solverVariable5, iM206d5, constraintWidget4.f259F, solverVariable6, constraintAnchor6.f248f, iM206d6, 4);
                                }
                            }
                        } else {
                            float f = CropImageView.DEFAULT_ASPECT_RATIO;
                            ConstraintWidget constraintWidget11 = null;
                            for (ConstraintWidget constraintWidget12 = constraintWidget5; constraintWidget12 != null; constraintWidget12 = constraintWidget12.f279Z) {
                                if (constraintWidget12.f261H != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                    int iM206d7 = constraintWidget12.f304j.m206d();
                                    if (constraintWidget11 != null) {
                                        iM206d7 += constraintWidget11.f306l.m206d();
                                    }
                                    int i4 = 3;
                                    if (constraintWidget12.f304j.f245c.f243a.f261H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                        i4 = 2;
                                    }
                                    linearSystem.m179a(constraintWidget12.f304j.f248f, constraintWidget12.f304j.f245c.f248f, iM206d7, i4);
                                    int iM206d8 = constraintWidget12.f306l.m206d();
                                    if (constraintWidget12.f306l.f245c.f243a.f304j.f245c != null && constraintWidget12.f306l.f245c.f243a.f304j.f245c.f243a == constraintWidget12) {
                                        iM206d8 += constraintWidget12.f306l.f245c.f243a.f304j.m206d();
                                    }
                                    int i5 = 3;
                                    if (constraintWidget12.f306l.f245c.f243a.f261H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                        i5 = 2;
                                    }
                                    linearSystem.m182b(constraintWidget12.f306l.f248f, constraintWidget12.f306l.f245c.f248f, -iM206d8, i5);
                                } else {
                                    f += constraintWidget12.f277X;
                                    int iM206d9 = 0;
                                    if (constraintWidget12.f306l.f245c != null) {
                                        iM206d9 = constraintWidget12.f306l.m206d();
                                        if (constraintWidget12 != this.f339as[3]) {
                                            iM206d9 += constraintWidget12.f306l.f245c.f243a.f304j.m206d();
                                        }
                                    }
                                    linearSystem.m179a(constraintWidget12.f306l.f248f, constraintWidget12.f304j.f248f, 0, 1);
                                    linearSystem.m182b(constraintWidget12.f306l.f248f, constraintWidget12.f306l.f245c.f248f, -iM206d9, 1);
                                }
                                constraintWidget11 = constraintWidget12;
                            }
                            if (iM278a == 1) {
                                ConstraintWidget constraintWidget13 = this.f334an[0];
                                int iM206d10 = constraintWidget13.f304j.m206d();
                                if (constraintWidget13.f304j.f245c != null) {
                                    iM206d10 += constraintWidget13.f304j.f245c.m206d();
                                }
                                int iM206d11 = constraintWidget13.f306l.m206d();
                                if (constraintWidget13.f306l.f245c != null) {
                                    iM206d11 += constraintWidget13.f306l.f245c.m206d();
                                }
                                SolverVariable solverVariable7 = constraintWidget4.f306l.f245c.f248f;
                                if (constraintWidget13 == this.f339as[3]) {
                                    solverVariable7 = this.f339as[1].f306l.f245c.f248f;
                                }
                                if (constraintWidget13.f298d == 1) {
                                    linearSystem.m179a(constraintWidget4.f304j.f248f, constraintWidget4.f304j.f245c.f248f, iM206d10, 1);
                                    linearSystem.m182b(constraintWidget4.f306l.f248f, solverVariable7, -iM206d11, 1);
                                    linearSystem.m183c(constraintWidget4.f306l.f248f, constraintWidget4.f304j.f248f, constraintWidget4.m261l(), 2);
                                } else {
                                    linearSystem.m183c(constraintWidget13.f304j.f248f, constraintWidget13.f304j.f245c.f248f, iM206d10, 1);
                                    linearSystem.m183c(constraintWidget13.f306l.f248f, solverVariable7, -iM206d11, 1);
                                }
                            } else {
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 < iM278a - 1) {
                                        ConstraintWidget constraintWidget14 = this.f334an[i7];
                                        ConstraintWidget constraintWidget15 = this.f334an[i7 + 1];
                                        SolverVariable solverVariable8 = constraintWidget14.f304j.f248f;
                                        SolverVariable solverVariable9 = constraintWidget14.f306l.f248f;
                                        SolverVariable solverVariable10 = constraintWidget15.f304j.f248f;
                                        SolverVariable solverVariable11 = constraintWidget15.f306l.f248f;
                                        if (constraintWidget15 == this.f339as[3]) {
                                            solverVariable11 = this.f339as[1].f306l.f248f;
                                        }
                                        int iM206d12 = constraintWidget14.f304j.m206d();
                                        if (constraintWidget14.f304j.f245c != null && constraintWidget14.f304j.f245c.f243a.f306l.f245c != null && constraintWidget14.f304j.f245c.f243a.f306l.f245c.f243a == constraintWidget14) {
                                            iM206d12 += constraintWidget14.f304j.f245c.f243a.f306l.m206d();
                                        }
                                        linearSystem.m179a(solverVariable8, constraintWidget14.f304j.f245c.f248f, iM206d12, 2);
                                        int iM206d13 = constraintWidget14.f306l.m206d();
                                        if (constraintWidget14.f306l.f245c == null || constraintWidget14.f279Z == null) {
                                            iM206d = iM206d13;
                                        } else {
                                            iM206d = (constraintWidget14.f279Z.f304j.f245c != null ? constraintWidget14.f279Z.f304j.m206d() : 0) + iM206d13;
                                        }
                                        linearSystem.m182b(solverVariable9, constraintWidget14.f306l.f245c.f248f, -iM206d, 2);
                                        if (i7 + 1 == iM278a - 1) {
                                            int iM206d14 = constraintWidget15.f304j.m206d();
                                            if (constraintWidget15.f304j.f245c != null && constraintWidget15.f304j.f245c.f243a.f306l.f245c != null && constraintWidget15.f304j.f245c.f243a.f306l.f245c.f243a == constraintWidget15) {
                                                iM206d14 += constraintWidget15.f304j.f245c.f243a.f306l.m206d();
                                            }
                                            linearSystem.m179a(solverVariable10, constraintWidget15.f304j.f245c.f248f, iM206d14, 2);
                                            ConstraintAnchor constraintAnchor7 = constraintWidget15.f306l;
                                            if (constraintWidget15 == this.f339as[3]) {
                                                constraintAnchor7 = this.f339as[1].f306l;
                                            }
                                            int iM206d15 = constraintAnchor7.m206d();
                                            if (constraintAnchor7.f245c != null && constraintAnchor7.f245c.f243a.f304j.f245c != null && constraintAnchor7.f245c.f243a.f304j.f245c.f243a == constraintWidget15) {
                                                iM206d15 += constraintAnchor7.f245c.f243a.f304j.m206d();
                                            }
                                            linearSystem.m182b(solverVariable11, constraintAnchor7.f245c.f248f, -iM206d15, 2);
                                        }
                                        if (constraintWidget4.f302h > 0) {
                                            linearSystem.m182b(solverVariable9, solverVariable8, constraintWidget4.f302h, 2);
                                        }
                                        ArrayRow arrayRowM181b = linearSystem.m181b();
                                        arrayRowM181b.m135a(constraintWidget14.f277X, f, constraintWidget15.f277X, solverVariable8, constraintWidget14.f304j.m206d(), solverVariable9, constraintWidget14.f306l.m206d(), solverVariable10, constraintWidget15.f304j.m206d(), solverVariable11, constraintWidget15.f306l.m206d());
                                        linearSystem.m175a(arrayRowM181b);
                                        i6 = i7 + 1;
                                    }
                                }
                            }
                        }
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m288a(LinearSystem linearSystem, int i, boolean[] zArr) {
        zArr[2] = false;
        mo236b(linearSystem, i);
        int size = this.f362aj.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.f362aj.get(i2);
            constraintWidget.mo236b(linearSystem, i);
            if (constraintWidget.f260G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.m253h() < constraintWidget.m259k()) {
                zArr[2] = true;
            }
            if (constraintWidget.f261H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.m261l() < constraintWidget.m263m()) {
                zArr[2] = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0143 A[PHI: r1
      0x0143: PHI (r1v8 boolean) = (r1v7 boolean), (r1v81 boolean), (r1v81 boolean), (r1v81 boolean), (r1v7 boolean) binds: [B:9:0x0074, B:22:0x00ab, B:31:0x00d3, B:45:0x0132, B:13:0x0084] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.support.constraint.solver.widgets.WidgetContainer
    /* JADX INFO: renamed from: F */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo286F() {
        /*
            Method dump skipped, instruction units count: 848
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidgetContainer.mo286F():void");
    }

    /* JADX INFO: renamed from: a */
    public void m290a(ConstraintWidget constraintWidget, boolean[] zArr) {
        ConstraintWidget constraintWidget2;
        int iM255i;
        int iM297F;
        ConstraintWidget constraintWidget3 = null;
        boolean z = false;
        i = 0;
        int i = 0;
        z = false;
        z = false;
        if (constraintWidget.f260G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f261H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f315u > CropImageView.DEFAULT_ASPECT_RATIO) {
            zArr[0] = false;
            return;
        }
        int iM255i2 = constraintWidget.m255i();
        if (constraintWidget.f260G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f261H != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f315u > CropImageView.DEFAULT_ASPECT_RATIO) {
            zArr[0] = false;
            return;
        }
        constraintWidget.f270Q = true;
        if (constraintWidget instanceof Guideline) {
            Guideline guideline = (Guideline) constraintWidget;
            if (guideline.m295D() != 1) {
                iM297F = iM255i2;
                i = iM255i2;
            } else if (guideline.m297F() != -1) {
                iM297F = guideline.m297F();
            } else if (guideline.m298G() != -1) {
                int iM298G = guideline.m298G();
                iM297F = 0;
                i = iM298G;
            } else {
                iM297F = 0;
            }
            iM255i2 = iM297F;
            iM255i = i;
        } else if (!constraintWidget.f305k.m212j() && !constraintWidget.f303i.m212j()) {
            iM255i = iM255i2;
            iM255i2 = constraintWidget.m249f() + iM255i2;
        } else {
            if (constraintWidget.f305k.f245c != null && constraintWidget.f303i.f245c != null && (constraintWidget.f305k.f245c == constraintWidget.f303i.f245c || (constraintWidget.f305k.f245c.f243a == constraintWidget.f303i.f245c.f243a && constraintWidget.f305k.f245c.f243a != constraintWidget.f312r))) {
                zArr[0] = false;
                return;
            }
            if (constraintWidget.f305k.f245c != null) {
                constraintWidget2 = constraintWidget.f305k.f245c.f243a;
                iM255i = constraintWidget.f305k.m206d() + iM255i2;
                if (!constraintWidget2.m238b() && !constraintWidget2.f270Q) {
                    m290a(constraintWidget2, zArr);
                }
            } else {
                constraintWidget2 = null;
                iM255i = iM255i2;
            }
            if (constraintWidget.f303i.f245c != null) {
                constraintWidget3 = constraintWidget.f303i.f245c.f243a;
                iM255i2 += constraintWidget.f303i.m206d();
                if (!constraintWidget3.m238b() && !constraintWidget3.f270Q) {
                    m290a(constraintWidget3, zArr);
                }
            }
            if (constraintWidget.f305k.f245c != null && !constraintWidget2.m238b()) {
                if (constraintWidget.f305k.f245c.f244b == ConstraintAnchor.Type.RIGHT) {
                    iM255i += constraintWidget2.f264K - constraintWidget2.m255i();
                } else if (constraintWidget.f305k.f245c.m205c() == ConstraintAnchor.Type.LEFT) {
                    iM255i += constraintWidget2.f264K;
                }
                constraintWidget.f267N = constraintWidget2.f267N || !(constraintWidget2.f303i.f245c == null || constraintWidget2.f305k.f245c == null || constraintWidget2.f260G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                if (constraintWidget.f267N && (constraintWidget2.f303i.f245c == null || constraintWidget2.f303i.f245c.f243a != constraintWidget)) {
                    iM255i += iM255i - constraintWidget2.f264K;
                }
            }
            if (constraintWidget.f303i.f245c != null && !constraintWidget3.m238b()) {
                if (constraintWidget.f303i.f245c.m205c() == ConstraintAnchor.Type.LEFT) {
                    iM255i2 += constraintWidget3.f263J - constraintWidget3.m255i();
                } else if (constraintWidget.f303i.f245c.m205c() == ConstraintAnchor.Type.RIGHT) {
                    iM255i2 += constraintWidget3.f263J;
                }
                if (constraintWidget3.f266M || (constraintWidget3.f303i.f245c != null && constraintWidget3.f305k.f245c != null && constraintWidget3.f260G != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
                    z = true;
                }
                constraintWidget.f266M = z;
                if (constraintWidget.f266M && (constraintWidget3.f305k.f245c == null || constraintWidget3.f305k.f245c.f243a != constraintWidget)) {
                    iM255i2 += iM255i2 - constraintWidget3.f263J;
                }
            }
        }
        if (constraintWidget.m243d() == 8) {
            iM255i2 -= constraintWidget.f313s;
            iM255i -= constraintWidget.f313s;
        }
        constraintWidget.f263J = iM255i2;
        constraintWidget.f264K = iM255i;
    }

    /* JADX INFO: renamed from: b */
    public void m292b(ConstraintWidget constraintWidget, boolean[] zArr) {
        ConstraintWidget constraintWidgetM204b;
        int iM257j;
        int iM298G;
        ConstraintWidget constraintWidgetM204b2 = null;
        boolean z = false;
        i = 0;
        int i = 0;
        z = false;
        z = false;
        z = false;
        z = false;
        if (constraintWidget.f261H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f260G != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f315u > CropImageView.DEFAULT_ASPECT_RATIO) {
            zArr[0] = false;
            return;
        }
        int iM257j2 = constraintWidget.m257j();
        constraintWidget.f271R = true;
        if (constraintWidget instanceof Guideline) {
            Guideline guideline = (Guideline) constraintWidget;
            if (guideline.m295D() != 0) {
                iM298G = iM257j2;
                i = iM257j2;
            } else if (guideline.m297F() != -1) {
                int iM297F = guideline.m297F();
                iM298G = 0;
                i = iM297F;
            } else {
                iM298G = guideline.m298G() != -1 ? guideline.m298G() : 0;
            }
            iM257j2 = iM298G;
            iM257j = i;
        } else if (constraintWidget.f307m.f245c == null && constraintWidget.f304j.f245c == null && constraintWidget.f306l.f245c == null) {
            iM257j = iM257j2 + constraintWidget.m251g();
        } else {
            if (constraintWidget.f306l.f245c != null && constraintWidget.f304j.f245c != null && (constraintWidget.f306l.f245c == constraintWidget.f304j.f245c || (constraintWidget.f306l.f245c.f243a == constraintWidget.f304j.f245c.f243a && constraintWidget.f306l.f245c.f243a != constraintWidget.f312r))) {
                zArr[0] = false;
                return;
            }
            if (constraintWidget.f307m.m212j()) {
                ConstraintWidget constraintWidgetM204b3 = constraintWidget.f307m.f245c.m204b();
                if (!constraintWidgetM204b3.f271R) {
                    m292b(constraintWidgetM204b3, zArr);
                }
                int iMax = Math.max((constraintWidgetM204b3.f262I - constraintWidgetM204b3.f314t) + iM257j2, iM257j2);
                int iMax2 = Math.max((constraintWidgetM204b3.f265L - constraintWidgetM204b3.f314t) + iM257j2, iM257j2);
                if (constraintWidget.m243d() == 8) {
                    iMax -= constraintWidget.f314t;
                    iMax2 -= constraintWidget.f314t;
                }
                constraintWidget.f262I = iMax;
                constraintWidget.f265L = iMax2;
                return;
            }
            if (constraintWidget.f304j.m212j()) {
                constraintWidgetM204b = constraintWidget.f304j.f245c.m204b();
                iM257j = constraintWidget.f304j.m206d() + iM257j2;
                if (!constraintWidgetM204b.m238b() && !constraintWidgetM204b.f271R) {
                    m292b(constraintWidgetM204b, zArr);
                }
            } else {
                constraintWidgetM204b = null;
                iM257j = iM257j2;
            }
            if (constraintWidget.f306l.m212j()) {
                constraintWidgetM204b2 = constraintWidget.f306l.f245c.m204b();
                iM257j2 += constraintWidget.f306l.m206d();
                if (!constraintWidgetM204b2.m238b() && !constraintWidgetM204b2.f271R) {
                    m292b(constraintWidgetM204b2, zArr);
                }
            }
            if (constraintWidget.f304j.f245c != null && !constraintWidgetM204b.m238b()) {
                if (constraintWidget.f304j.f245c.m205c() == ConstraintAnchor.Type.TOP) {
                    iM257j += constraintWidgetM204b.f262I - constraintWidgetM204b.m257j();
                } else if (constraintWidget.f304j.f245c.m205c() == ConstraintAnchor.Type.BOTTOM) {
                    iM257j += constraintWidgetM204b.f262I;
                }
                constraintWidget.f268O = constraintWidgetM204b.f268O || !(constraintWidgetM204b.f304j.f245c == null || constraintWidgetM204b.f304j.f245c.f243a == constraintWidget || constraintWidgetM204b.f306l.f245c == null || constraintWidgetM204b.f306l.f245c.f243a == constraintWidget || constraintWidgetM204b.f261H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                if (constraintWidget.f268O && (constraintWidgetM204b.f306l.f245c == null || constraintWidgetM204b.f306l.f245c.f243a != constraintWidget)) {
                    iM257j += iM257j - constraintWidgetM204b.f262I;
                }
            }
            if (constraintWidget.f306l.f245c != null && !constraintWidgetM204b2.m238b()) {
                if (constraintWidget.f306l.f245c.m205c() == ConstraintAnchor.Type.BOTTOM) {
                    iM257j2 += constraintWidgetM204b2.f265L - constraintWidgetM204b2.m257j();
                } else if (constraintWidget.f306l.f245c.m205c() == ConstraintAnchor.Type.TOP) {
                    iM257j2 += constraintWidgetM204b2.f265L;
                }
                if (constraintWidgetM204b2.f269P || (constraintWidgetM204b2.f304j.f245c != null && constraintWidgetM204b2.f304j.f245c.f243a != constraintWidget && constraintWidgetM204b2.f306l.f245c != null && constraintWidgetM204b2.f306l.f245c.f243a != constraintWidget && constraintWidgetM204b2.f261H != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
                    z = true;
                }
                constraintWidget.f269P = z;
                if (constraintWidget.f269P && (constraintWidgetM204b2.f304j.f245c == null || constraintWidgetM204b2.f304j.f245c.f243a != constraintWidget)) {
                    iM257j2 += iM257j2 - constraintWidgetM204b2.f265L;
                }
            }
        }
        if (constraintWidget.m243d() == 8) {
            iM257j -= constraintWidget.f314t;
            iM257j2 -= constraintWidget.f314t;
        }
        constraintWidget.f262I = iM257j;
        constraintWidget.f265L = iM257j2;
    }

    /* JADX INFO: renamed from: a */
    public void m291a(ArrayList<ConstraintWidget> arrayList, boolean[] zArr) {
        int iMax;
        int iMax2;
        int iMax3 = 0;
        int iMax4 = 0;
        int iMax5 = 0;
        int iMax6 = 0;
        int i = 0;
        int i2 = 0;
        int size = arrayList.size();
        zArr[0] = true;
        int i3 = 0;
        while (i3 < size) {
            ConstraintWidget constraintWidget = arrayList.get(i3);
            if (constraintWidget.m238b()) {
                iMax2 = i2;
                iMax = i;
            } else {
                if (!constraintWidget.f270Q) {
                    m290a(constraintWidget, zArr);
                }
                if (!constraintWidget.f271R) {
                    m292b(constraintWidget, zArr);
                }
                if (zArr[0]) {
                    int iM253h = (constraintWidget.f263J + constraintWidget.f264K) - constraintWidget.m253h();
                    int iM261l = (constraintWidget.f262I + constraintWidget.f265L) - constraintWidget.m261l();
                    if (constraintWidget.f260G == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        iM253h = constraintWidget.m253h() + constraintWidget.f303i.f246d + constraintWidget.f305k.f246d;
                    }
                    if (constraintWidget.f261H == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        iM261l = constraintWidget.m261l() + constraintWidget.f304j.f246d + constraintWidget.f306l.f246d;
                    }
                    if (constraintWidget.m243d() == 8) {
                        iM253h = 0;
                        iM261l = 0;
                    }
                    iMax4 = Math.max(iMax4, constraintWidget.f263J);
                    iMax5 = Math.max(iMax5, constraintWidget.f264K);
                    iMax6 = Math.max(iMax6, constraintWidget.f265L);
                    iMax3 = Math.max(iMax3, constraintWidget.f262I);
                    iMax = Math.max(i, iM253h);
                    iMax2 = Math.max(i2, iM261l);
                } else {
                    return;
                }
            }
            i3++;
            iMax4 = iMax4;
            iMax3 = iMax3;
            iMax6 = iMax6;
            iMax5 = iMax5;
            i = iMax;
            i2 = iMax2;
        }
        this.f325ad = Math.max(this.f256B, Math.max(Math.max(iMax4, iMax5), i));
        this.f326ae = Math.max(this.f257C, Math.max(Math.max(iMax3, iMax6), i2));
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget2 = arrayList.get(i4);
            constraintWidget2.f270Q = false;
            constraintWidget2.f271R = false;
            constraintWidget2.f266M = false;
            constraintWidget2.f267N = false;
            constraintWidget2.f268O = false;
            constraintWidget2.f269P = false;
        }
    }

    /* JADX INFO: renamed from: G */
    public boolean m287G() {
        return false;
    }

    /* JADX INFO: renamed from: J */
    private void m277J() {
        this.f332al = 0;
        this.f333am = 0;
    }

    /* JADX INFO: renamed from: a */
    void m289a(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            while (constraintWidget.f303i.f245c != null && constraintWidget.f303i.f245c.f243a.f305k.f245c != null && constraintWidget.f303i.f245c.f243a.f305k.f245c == constraintWidget.f303i && constraintWidget.f303i.f245c.f243a != constraintWidget) {
                constraintWidget = constraintWidget.f303i.f245c.f243a;
            }
            m282d(constraintWidget);
            return;
        }
        if (i == 1) {
            while (constraintWidget.f304j.f245c != null && constraintWidget.f304j.f245c.f243a.f306l.f245c != null && constraintWidget.f304j.f245c.f243a.f306l.f245c == constraintWidget.f304j && constraintWidget.f304j.f245c.f243a != constraintWidget) {
                constraintWidget = constraintWidget.f304j.f245c.f243a;
            }
            m283e(constraintWidget);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m282d(ConstraintWidget constraintWidget) {
        for (int i = 0; i < this.f332al; i++) {
            if (this.f336ap[i] == constraintWidget) {
                return;
            }
        }
        if (this.f332al + 1 >= this.f336ap.length) {
            this.f336ap = (ConstraintWidget[]) Arrays.copyOf(this.f336ap, this.f336ap.length * 2);
        }
        this.f336ap[this.f332al] = constraintWidget;
        this.f332al++;
    }

    /* JADX INFO: renamed from: e */
    private void m283e(ConstraintWidget constraintWidget) {
        for (int i = 0; i < this.f333am; i++) {
            if (this.f335ao[i] == constraintWidget) {
                return;
            }
        }
        if (this.f333am + 1 >= this.f335ao.length) {
            this.f335ao = (ConstraintWidget[]) Arrays.copyOf(this.f335ao, this.f335ao.length * 2);
        }
        this.f335ao[this.f333am] = constraintWidget;
        this.f333am++;
    }

    /* JADX INFO: renamed from: a */
    private int m278a(LinearSystem linearSystem, ConstraintWidget[] constraintWidgetArr, ConstraintWidget constraintWidget, int i, boolean[] zArr) {
        boolean z;
        int i2;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        boolean z2;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        zArr[0] = true;
        zArr[1] = false;
        constraintWidgetArr[0] = null;
        constraintWidgetArr[2] = null;
        constraintWidgetArr[1] = null;
        constraintWidgetArr[3] = null;
        if (i == 0) {
            if (constraintWidget.f303i.f245c == null || constraintWidget.f303i.f245c.f243a == this) {
                z2 = true;
            } else {
                z2 = false;
            }
            constraintWidget.f278Y = null;
            ConstraintWidget constraintWidget6 = constraintWidget.m243d() != 8 ? constraintWidget : null;
            ConstraintWidget constraintWidget7 = null;
            i2 = 0;
            ConstraintWidget constraintWidget8 = constraintWidget;
            ConstraintWidget constraintWidget9 = constraintWidget6;
            while (true) {
                if (constraintWidget8.f305k.f245c == null) {
                    constraintWidget4 = constraintWidget9;
                    constraintWidget5 = constraintWidget6;
                    break;
                }
                constraintWidget8.f278Y = null;
                if (constraintWidget8.m243d() != 8) {
                    constraintWidget4 = constraintWidget9 == null ? constraintWidget8 : constraintWidget9;
                    if (constraintWidget6 != null && constraintWidget6 != constraintWidget8) {
                        constraintWidget6.f278Y = constraintWidget8;
                    }
                    constraintWidget5 = constraintWidget8;
                } else {
                    linearSystem.m183c(constraintWidget8.f303i.f248f, constraintWidget8.f303i.f245c.f248f, 0, 5);
                    linearSystem.m183c(constraintWidget8.f305k.f248f, constraintWidget8.f303i.f248f, 0, 5);
                    constraintWidget4 = constraintWidget9;
                    constraintWidget5 = constraintWidget6;
                }
                if (constraintWidget8.m243d() != 8 && constraintWidget8.f260G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget8.f261H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        zArr[0] = false;
                    }
                    if (constraintWidget8.f315u <= CropImageView.DEFAULT_ASPECT_RATIO) {
                        zArr[0] = false;
                        if (i2 + 1 >= this.f334an.length) {
                            this.f334an = (ConstraintWidget[]) Arrays.copyOf(this.f334an, this.f334an.length * 2);
                        }
                        this.f334an[i2] = constraintWidget8;
                        i2++;
                    }
                }
                if (constraintWidget8.f305k.f245c.f243a.f303i.f245c == null || constraintWidget8.f305k.f245c.f243a.f303i.f245c.f243a != constraintWidget8 || constraintWidget8.f305k.f245c.f243a == constraintWidget8) {
                    break;
                }
                ConstraintWidget constraintWidget10 = constraintWidget8.f305k.f245c.f243a;
                constraintWidget7 = constraintWidget10;
                constraintWidget8 = constraintWidget10;
                constraintWidget6 = constraintWidget5;
                constraintWidget9 = constraintWidget4;
            }
            if (constraintWidget8.f305k.f245c != null && constraintWidget8.f305k.f245c.f243a != this) {
                z2 = false;
            }
            if (constraintWidget.f303i.f245c == null || constraintWidget7.f305k.f245c == null) {
                zArr[1] = true;
            }
            constraintWidget.f274U = z2;
            constraintWidget7.f278Y = null;
            constraintWidgetArr[0] = constraintWidget;
            constraintWidgetArr[2] = constraintWidget4;
            constraintWidgetArr[1] = constraintWidget7;
            constraintWidgetArr[3] = constraintWidget5;
        } else {
            if (constraintWidget.f304j.f245c == null || constraintWidget.f304j.f245c.f243a == this) {
                z = true;
            } else {
                z = false;
            }
            constraintWidget.f279Z = null;
            ConstraintWidget constraintWidget11 = constraintWidget.m243d() != 8 ? constraintWidget : null;
            ConstraintWidget constraintWidget12 = null;
            i2 = 0;
            ConstraintWidget constraintWidget13 = constraintWidget;
            ConstraintWidget constraintWidget14 = constraintWidget11;
            while (true) {
                if (constraintWidget13.f306l.f245c == null) {
                    constraintWidget2 = constraintWidget14;
                    constraintWidget3 = constraintWidget11;
                    break;
                }
                constraintWidget13.f279Z = null;
                if (constraintWidget13.m243d() != 8) {
                    constraintWidget2 = constraintWidget14 == null ? constraintWidget13 : constraintWidget14;
                    if (constraintWidget11 != null && constraintWidget11 != constraintWidget13) {
                        constraintWidget11.f279Z = constraintWidget13;
                    }
                    constraintWidget3 = constraintWidget13;
                } else {
                    linearSystem.m183c(constraintWidget13.f304j.f248f, constraintWidget13.f304j.f245c.f248f, 0, 5);
                    linearSystem.m183c(constraintWidget13.f306l.f248f, constraintWidget13.f304j.f248f, 0, 5);
                    constraintWidget2 = constraintWidget14;
                    constraintWidget3 = constraintWidget11;
                }
                if (constraintWidget13.m243d() != 8 && constraintWidget13.f261H == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget13.f260G == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        zArr[0] = false;
                    }
                    if (constraintWidget13.f315u <= CropImageView.DEFAULT_ASPECT_RATIO) {
                        zArr[0] = false;
                        if (i2 + 1 >= this.f334an.length) {
                            this.f334an = (ConstraintWidget[]) Arrays.copyOf(this.f334an, this.f334an.length * 2);
                        }
                        this.f334an[i2] = constraintWidget13;
                        i2++;
                    }
                }
                if (constraintWidget13.f306l.f245c.f243a.f304j.f245c == null || constraintWidget13.f306l.f245c.f243a.f304j.f245c.f243a != constraintWidget13 || constraintWidget13.f306l.f245c.f243a == constraintWidget13) {
                    break;
                }
                ConstraintWidget constraintWidget15 = constraintWidget13.f306l.f245c.f243a;
                constraintWidget12 = constraintWidget15;
                constraintWidget13 = constraintWidget15;
                constraintWidget11 = constraintWidget3;
                constraintWidget14 = constraintWidget2;
            }
            if (constraintWidget13.f306l.f245c != null && constraintWidget13.f306l.f245c.f243a != this) {
                z = false;
            }
            if (constraintWidget.f304j.f245c == null || constraintWidget12.f306l.f245c == null) {
                zArr[1] = true;
            }
            constraintWidget.f275V = z;
            constraintWidget12.f279Z = null;
            constraintWidgetArr[0] = constraintWidget;
            constraintWidgetArr[2] = constraintWidget2;
            constraintWidgetArr[1] = constraintWidget12;
            constraintWidgetArr[3] = constraintWidget3;
        }
        return i2;
    }
}
