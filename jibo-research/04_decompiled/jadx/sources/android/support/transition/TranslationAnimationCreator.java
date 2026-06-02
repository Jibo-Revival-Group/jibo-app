package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class TranslationAnimationCreator {
    /* JADX INFO: renamed from: a */
    static Animator m1277a(View view, TransitionValues transitionValues, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) transitionValues.f1324b.getTag(R.id.transition_position)) != null) {
            f = (r1[0] - i) + translationX;
            f2 = (r1[1] - i2) + translationY;
        }
        int iRound = i + Math.round(f - translationX);
        int iRound2 = i2 + Math.round(f2 - translationY);
        view.setTranslationX(f);
        view.setTranslationY(f2);
        if (f == f3 && f2 == f4) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f, f3), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f2, f4));
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.f1324b, iRound, iRound2, translationX, translationY);
        objectAnimatorOfPropertyValuesHolder.addListener(transitionPositionListener);
        AnimatorUtils.m1061a(objectAnimatorOfPropertyValuesHolder, transitionPositionListener);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(timeInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }

    private static class TransitionPositionListener extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        private final View f1330a;

        /* JADX INFO: renamed from: b */
        private final View f1331b;

        /* JADX INFO: renamed from: c */
        private final int f1332c;

        /* JADX INFO: renamed from: d */
        private final int f1333d;

        /* JADX INFO: renamed from: e */
        private int[] f1334e;

        /* JADX INFO: renamed from: f */
        private float f1335f;

        /* JADX INFO: renamed from: g */
        private float f1336g;

        /* JADX INFO: renamed from: h */
        private final float f1337h;

        /* JADX INFO: renamed from: i */
        private final float f1338i;

        private TransitionPositionListener(View view, View view2, int i, int i2, float f, float f2) {
            this.f1331b = view;
            this.f1330a = view2;
            this.f1332c = i - Math.round(this.f1331b.getTranslationX());
            this.f1333d = i2 - Math.round(this.f1331b.getTranslationY());
            this.f1337h = f;
            this.f1338i = f2;
            this.f1334e = (int[]) this.f1330a.getTag(R.id.transition_position);
            if (this.f1334e != null) {
                this.f1330a.setTag(R.id.transition_position, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f1334e == null) {
                this.f1334e = new int[2];
            }
            this.f1334e[0] = Math.round(this.f1332c + this.f1331b.getTranslationX());
            this.f1334e[1] = Math.round(this.f1333d + this.f1331b.getTranslationY());
            this.f1330a.setTag(R.id.transition_position, this.f1334e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1331b.setTranslationX(this.f1337h);
            this.f1331b.setTranslationY(this.f1338i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f1335f = this.f1331b.getTranslationX();
            this.f1336g = this.f1331b.getTranslationY();
            this.f1331b.setTranslationX(this.f1337h);
            this.f1331b.setTranslationY(this.f1338i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f1331b.setTranslationX(this.f1335f);
            this.f1331b.setTranslationY(this.f1336g);
        }
    }
}
