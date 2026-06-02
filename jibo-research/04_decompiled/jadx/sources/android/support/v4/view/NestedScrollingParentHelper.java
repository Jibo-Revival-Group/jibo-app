package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollingParentHelper {

    /* JADX INFO: renamed from: a */
    private final ViewGroup f2295a;

    /* JADX INFO: renamed from: b */
    private int f2296b;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
        this.f2295a = viewGroup;
    }

    /* JADX INFO: renamed from: a */
    public void m2548a(View view, View view2, int i) {
        m2549a(view, view2, i, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m2549a(View view, View view2, int i, int i2) {
        this.f2296b = i;
    }

    /* JADX INFO: renamed from: a */
    public int m2545a() {
        return this.f2296b;
    }

    /* JADX INFO: renamed from: a */
    public void m2546a(View view) {
        m2547a(view, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m2547a(View view, int i) {
        this.f2296b = 0;
    }
}
