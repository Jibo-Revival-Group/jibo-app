package android.support.design.widget;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
class AnimationUtils {

    /* JADX INFO: renamed from: a */
    static final Interpolator f470a = new LinearInterpolator();

    /* JADX INFO: renamed from: b */
    static final Interpolator f471b = new FastOutSlowInInterpolator();

    /* JADX INFO: renamed from: c */
    static final Interpolator f472c = new FastOutLinearInInterpolator();

    /* JADX INFO: renamed from: d */
    static final Interpolator f473d = new LinearOutSlowInInterpolator();

    /* JADX INFO: renamed from: e */
    static final Interpolator f474e = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a */
    static float m408a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    /* JADX INFO: renamed from: a */
    static int m409a(int i, int i2, float f) {
        return Math.round((i2 - i) * f) + i;
    }
}
