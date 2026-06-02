package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
class AnimatorUtils {

    /* JADX INFO: renamed from: a */
    private static final AnimatorUtilsImpl f1095a;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f1095a = new AnimatorUtilsApi19();
        } else {
            f1095a = new AnimatorUtilsApi14();
        }
    }

    /* JADX INFO: renamed from: a */
    static void m1061a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        f1095a.mo1064a(animator, animatorListenerAdapter);
    }

    /* JADX INFO: renamed from: a */
    static void m1060a(Animator animator) {
        f1095a.mo1063a(animator);
    }

    /* JADX INFO: renamed from: b */
    static void m1062b(Animator animator) {
        f1095a.mo1065b(animator);
    }
}
