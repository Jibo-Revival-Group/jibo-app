package com.salesforce.android.knowledge.p022ui.internal.home;

import android.animation.ObjectAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class RotateAnimation {
    /* JADX INFO: renamed from: a */
    public static void m13585a(View view, float f) {
        view.setPivotY(view.getHeight() / 2);
        view.setPivotX(view.getWidth() / 2);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "rotation", f);
        objectAnimatorOfFloat.setDuration(400L);
        objectAnimatorOfFloat.start();
    }
}
