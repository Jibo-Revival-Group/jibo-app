package com.jibo.p019ui.view;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class NoBounceBehavior extends AppBarLayout.Behavior {

    /* JADX INFO: renamed from: b */
    private boolean f11574b;

    /* JADX INFO: renamed from: c */
    private boolean f11575c;

    /* JADX INFO: renamed from: d */
    private boolean f11576d;

    public NoBounceBehavior() {
        this.f11574b = false;
        this.f11575c = false;
        this.f11576d = true;
    }

    public NoBounceBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11574b = false;
        this.f11575c = false;
        this.f11576d = true;
    }

    @Override // android.support.design.widget.HeaderBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean mo510a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        if (this.f11574b) {
            this.f11575c = true;
        }
        return super.mo510a(coordinatorLayout, appBarLayout, motionEvent);
    }

    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public void mo449a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            this.f11574b = true;
        }
        if (!this.f11575c) {
            super.mo449a(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public void mo448a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.f11575c) {
            super.mo448a(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public void mo447a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
        super.mo447a(coordinatorLayout, appBarLayout, view, i);
        this.f11574b = false;
        this.f11575c = false;
    }

    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo457a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        return this.f11576d;
    }

    @Override // android.support.design.widget.HeaderBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean mo539b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        if (this.f11576d) {
            return super.mo539b(coordinatorLayout, appBarLayout, motionEvent);
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m11279a(boolean z) {
        this.f11576d = z;
    }
}
