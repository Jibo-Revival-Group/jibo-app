package com.salesforce.android.cases.p020ui.internal.utils;

import android.animation.Animator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class QuickReturnFabBehavior extends CoordinatorLayout.Behavior<View> {

    /* JADX INFO: renamed from: a */
    private static final Interpolator f12856a = new FastOutSlowInInterpolator();

    /* JADX INFO: renamed from: b */
    private int f12857b;

    /* JADX INFO: renamed from: c */
    private boolean f12858c;

    /* JADX INFO: renamed from: d */
    private boolean f12859d;

    /* JADX INFO: renamed from: e */
    private boolean f12860e;

    /* JADX INFO: renamed from: f */
    private float f12861f;

    public QuickReturnFabBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo478a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return super.mo478a(coordinatorLayout, view, view2) || (view2 instanceof Snackbar.SnackbarLayout);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: d */
    public void mo685d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        super.mo685d(coordinatorLayout, view, view2);
        if (view2 instanceof Snackbar.SnackbarLayout) {
            float fMin = Math.min(0, coordinatorLayout.getBottom() - view.getBottom());
            this.f12861f = fMin;
            if (!this.f12860e) {
                view.animate().translationY(fMin).start();
            }
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: b */
    public boolean mo481b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (!(view2 instanceof Snackbar.SnackbarLayout)) {
            return false;
        }
        float fMin = Math.min(CropImageView.DEFAULT_ASPECT_RATIO, view2.getTranslationY() - view2.getHeight());
        this.f12861f = fMin;
        if (!this.f12860e) {
            view.setTranslationY(fMin);
        }
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo535a(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
        return (i & 2) != 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public void mo531a(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr) {
        if ((i2 > 0 && this.f12857b < 0) || (i2 < 0 && this.f12857b > 0)) {
            view.animate().cancel();
            this.f12857b = 0;
        }
        this.f12857b += i2;
        if (this.f12857b >= 200 && !this.f12860e && !this.f12859d && this.f12861f == CropImageView.DEFAULT_ASPECT_RATIO) {
            m13048a(view);
        } else if (this.f12857b < 0 && this.f12860e && !this.f12858c) {
            m13052b(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m13048a(final View view) {
        this.f12859d = true;
        this.f12860e = true;
        ViewPropertyAnimator duration = view.animate().translationY(view.getHeight() * 2).setInterpolator(f12856a).setDuration(200L);
        duration.setListener(new Animator.AnimatorListener() { // from class: com.salesforce.android.cases.ui.internal.utils.QuickReturnFabBehavior.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QuickReturnFabBehavior.this.f12859d = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                QuickReturnFabBehavior.this.f12859d = false;
                if (!QuickReturnFabBehavior.this.f12858c) {
                    QuickReturnFabBehavior.this.m13052b(view);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m13052b(final View view) {
        this.f12858c = true;
        this.f12860e = false;
        ViewPropertyAnimator duration = view.animate().translationY(this.f12861f).setInterpolator(f12856a).setDuration(200L);
        duration.setListener(new Animator.AnimatorListener() { // from class: com.salesforce.android.cases.ui.internal.utils.QuickReturnFabBehavior.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QuickReturnFabBehavior.this.f12858c = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                QuickReturnFabBehavior.this.f12858c = false;
                if (!QuickReturnFabBehavior.this.f12859d) {
                    QuickReturnFabBehavior.this.m13048a(view);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        duration.start();
    }
}
