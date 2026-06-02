package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ViewOffsetHelper {

    /* JADX INFO: renamed from: a */
    private final View f973a;

    /* JADX INFO: renamed from: b */
    private int f974b;

    /* JADX INFO: renamed from: c */
    private int f975c;

    /* JADX INFO: renamed from: d */
    private int f976d;

    /* JADX INFO: renamed from: e */
    private int f977e;

    public ViewOffsetHelper(View view) {
        this.f973a = view;
    }

    /* JADX INFO: renamed from: a */
    public void m942a() {
        this.f974b = this.f973a.getTop();
        this.f975c = this.f973a.getLeft();
        m941d();
    }

    /* JADX INFO: renamed from: d */
    private void m941d() {
        ViewCompat.m2598c(this.f973a, this.f976d - (this.f973a.getTop() - this.f974b));
        ViewCompat.m2600d(this.f973a, this.f977e - (this.f973a.getLeft() - this.f975c));
    }

    /* JADX INFO: renamed from: a */
    public boolean m943a(int i) {
        if (this.f976d == i) {
            return false;
        }
        this.f976d = i;
        m941d();
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean m945b(int i) {
        if (this.f977e == i) {
            return false;
        }
        this.f977e = i;
        m941d();
        return true;
    }

    /* JADX INFO: renamed from: b */
    public int m944b() {
        return this.f976d;
    }

    /* JADX INFO: renamed from: c */
    public int m946c() {
        return this.f974b;
    }
}
