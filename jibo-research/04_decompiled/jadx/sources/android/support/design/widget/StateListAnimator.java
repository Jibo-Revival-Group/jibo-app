package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class StateListAnimator {

    /* JADX INFO: renamed from: b */
    private final ArrayList<Tuple> f823b = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    private Tuple f824c = null;

    /* JADX INFO: renamed from: a */
    ValueAnimator f822a = null;

    /* JADX INFO: renamed from: d */
    private final Animator.AnimatorListener f825d = new AnimatorListenerAdapter() { // from class: android.support.design.widget.StateListAnimator.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (StateListAnimator.this.f822a == animator) {
                StateListAnimator.this.f822a = null;
            }
        }
    };

    StateListAnimator() {
    }

    /* JADX INFO: renamed from: a */
    public void m830a(int[] iArr, ValueAnimator valueAnimator) {
        Tuple tuple = new Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.f825d);
        this.f823b.add(tuple);
    }

    /* JADX INFO: renamed from: a */
    void m829a(int[] iArr) {
        Tuple tuple;
        int size = this.f823b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                tuple = null;
                break;
            }
            tuple = this.f823b.get(i);
            if (StateSet.stateSetMatches(tuple.f827a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        if (tuple != this.f824c) {
            if (this.f824c != null) {
                m827b();
            }
            this.f824c = tuple;
            if (tuple != null) {
                m826a(tuple);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m826a(Tuple tuple) {
        this.f822a = tuple.f828b;
        this.f822a.start();
    }

    /* JADX INFO: renamed from: b */
    private void m827b() {
        if (this.f822a != null) {
            this.f822a.cancel();
            this.f822a = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m828a() {
        if (this.f822a != null) {
            this.f822a.end();
            this.f822a = null;
        }
    }

    static class Tuple {

        /* JADX INFO: renamed from: a */
        final int[] f827a;

        /* JADX INFO: renamed from: b */
        final ValueAnimator f828b;

        Tuple(int[] iArr, ValueAnimator valueAnimator) {
            this.f827a = iArr;
            this.f828b = valueAnimator;
        }
    }
}
