package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class AnimatorUtilsApi19 implements AnimatorUtilsImpl {
    AnimatorUtilsApi19() {
    }

    @Override // android.support.transition.AnimatorUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1064a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    @Override // android.support.transition.AnimatorUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1063a(Animator animator) {
        animator.pause();
    }

    @Override // android.support.transition.AnimatorUtilsImpl
    /* JADX INFO: renamed from: b */
    public void mo1065b(Animator animator) {
        animator.resume();
    }
}
