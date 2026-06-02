package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {

    /* JADX INFO: renamed from: aj */
    protected ArrayList<ConstraintWidget> f362aj = new ArrayList<>();

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    /* JADX INFO: renamed from: a */
    public void mo219a() {
        this.f362aj.clear();
        super.mo219a();
    }

    /* JADX INFO: renamed from: b */
    public void m314b(ConstraintWidget constraintWidget) {
        this.f362aj.add(constraintWidget);
        if (constraintWidget.m239c() != null) {
            ((WidgetContainer) constraintWidget.m239c()).m315c(constraintWidget);
        }
        constraintWidget.m229a((ConstraintWidget) this);
    }

    /* JADX INFO: renamed from: c */
    public void m315c(ConstraintWidget constraintWidget) {
        this.f362aj.remove(constraintWidget);
        constraintWidget.m229a((ConstraintWidget) null);
    }

    /* JADX INFO: renamed from: H */
    public ConstraintWidgetContainer m312H() {
        ConstraintWidgetContainer constraintWidgetContainer;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidgetM239c = m239c();
        if (!(this instanceof ConstraintWidgetContainer)) {
            constraintWidgetContainer = null;
            constraintWidget = constraintWidgetM239c;
        } else {
            constraintWidgetContainer = (ConstraintWidgetContainer) this;
            constraintWidget = constraintWidgetM239c;
        }
        while (constraintWidget != null) {
            ConstraintWidget constraintWidgetM239c2 = constraintWidget.m239c();
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget;
                constraintWidget = constraintWidgetM239c2;
            } else {
                constraintWidget = constraintWidgetM239c2;
            }
        }
        return constraintWidgetContainer;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    /* JADX INFO: renamed from: b */
    public void mo234b(int i, int i2) {
        super.mo234b(i, i2);
        int size = this.f362aj.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f362aj.get(i3).mo234b(m268r(), m269s());
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    /* JADX INFO: renamed from: z */
    public void mo276z() {
        super.mo276z();
        if (this.f362aj != null) {
            int size = this.f362aj.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.f362aj.get(i);
                constraintWidget.mo234b(m264n(), m265o());
                if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                    constraintWidget.mo276z();
                }
            }
        }
    }

    /* JADX INFO: renamed from: F */
    public void mo286F() {
        mo276z();
        if (this.f362aj != null) {
            int size = this.f362aj.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.f362aj.get(i);
                if (constraintWidget instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget).mo286F();
                }
            }
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    /* JADX INFO: renamed from: a */
    public void mo225a(Cache cache) {
        super.mo225a(cache);
        int size = this.f362aj.size();
        for (int i = 0; i < size; i++) {
            this.f362aj.get(i).mo225a(cache);
        }
    }

    /* JADX INFO: renamed from: I */
    public void m313I() {
        this.f362aj.clear();
    }
}
