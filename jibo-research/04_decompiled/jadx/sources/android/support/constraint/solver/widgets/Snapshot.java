package android.support.constraint.solver.widgets;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Snapshot {

    /* JADX INFO: renamed from: a */
    private int f352a;

    /* JADX INFO: renamed from: b */
    private int f353b;

    /* JADX INFO: renamed from: c */
    private int f354c;

    /* JADX INFO: renamed from: d */
    private int f355d;

    /* JADX INFO: renamed from: e */
    private ArrayList<Connection> f356e = new ArrayList<>();

    static class Connection {

        /* JADX INFO: renamed from: a */
        private ConstraintAnchor f357a;

        /* JADX INFO: renamed from: b */
        private ConstraintAnchor f358b;

        /* JADX INFO: renamed from: c */
        private int f359c;

        /* JADX INFO: renamed from: d */
        private ConstraintAnchor.Strength f360d;

        /* JADX INFO: renamed from: e */
        private int f361e;

        public Connection(ConstraintAnchor constraintAnchor) {
            this.f357a = constraintAnchor;
            this.f358b = constraintAnchor.m208f();
            this.f359c = constraintAnchor.m206d();
            this.f360d = constraintAnchor.m207e();
            this.f361e = constraintAnchor.m210h();
        }

        /* JADX INFO: renamed from: a */
        public void m310a(ConstraintWidget constraintWidget) {
            this.f357a = constraintWidget.mo218a(this.f357a.m205c());
            if (this.f357a != null) {
                this.f358b = this.f357a.m208f();
                this.f359c = this.f357a.m206d();
                this.f360d = this.f357a.m207e();
                this.f361e = this.f357a.m210h();
                return;
            }
            this.f358b = null;
            this.f359c = 0;
            this.f360d = ConstraintAnchor.Strength.STRONG;
            this.f361e = 0;
        }

        /* JADX INFO: renamed from: b */
        public void m311b(ConstraintWidget constraintWidget) {
            constraintWidget.mo218a(this.f357a.m205c()).m203a(this.f358b, this.f359c, this.f360d, this.f361e);
        }
    }

    public Snapshot(ConstraintWidget constraintWidget) {
        this.f352a = constraintWidget.m249f();
        this.f353b = constraintWidget.m251g();
        this.f354c = constraintWidget.m253h();
        this.f355d = constraintWidget.m261l();
        ArrayList<ConstraintAnchor> arrayListMo275y = constraintWidget.mo275y();
        int size = arrayListMo275y.size();
        for (int i = 0; i < size; i++) {
            this.f356e.add(new Connection(arrayListMo275y.get(i)));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m308a(ConstraintWidget constraintWidget) {
        this.f352a = constraintWidget.m249f();
        this.f353b = constraintWidget.m251g();
        this.f354c = constraintWidget.m253h();
        this.f355d = constraintWidget.m261l();
        int size = this.f356e.size();
        for (int i = 0; i < size; i++) {
            this.f356e.get(i).m310a(constraintWidget);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m309b(ConstraintWidget constraintWidget) {
        constraintWidget.m233b(this.f352a);
        constraintWidget.m241c(this.f353b);
        constraintWidget.m245d(this.f354c);
        constraintWidget.m248e(this.f355d);
        int size = this.f356e.size();
        for (int i = 0; i < size; i++) {
            this.f356e.get(i).m311b(constraintWidget);
        }
    }
}
