package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ChangeClipBounds extends Transition {

    /* JADX INFO: renamed from: g */
    private static final String[] f1140g = {"android:clipBounds:clip"};

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public String[] mo1075a() {
        return f1140g;
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: renamed from: d */
    private void m1094d(TransitionValues transitionValues) {
        View view = transitionValues.f1324b;
        if (view.getVisibility() != 8) {
            Rect rectM2569A = ViewCompat.m2569A(view);
            transitionValues.f1323a.put("android:clipBounds:clip", rectM2569A);
            if (rectM2569A == null) {
                transitionValues.f1323a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo406a(TransitionValues transitionValues) {
        m1094d(transitionValues);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo407b(TransitionValues transitionValues) {
        m1094d(transitionValues);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo405a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !transitionValues.f1323a.containsKey("android:clipBounds:clip") || !transitionValues2.f1323a.containsKey("android:clipBounds:clip")) {
            return null;
        }
        Rect rect = (Rect) transitionValues.f1323a.get("android:clipBounds:clip");
        Rect rect2 = (Rect) transitionValues2.f1323a.get("android:clipBounds:clip");
        boolean z = rect2 == null;
        if (rect == null && rect2 == null) {
            return null;
        }
        if (rect == null) {
            rect = (Rect) transitionValues.f1323a.get("android:clipBounds:bounds");
        } else if (rect2 == null) {
            rect2 = (Rect) transitionValues2.f1323a.get("android:clipBounds:bounds");
        }
        if (rect.equals(rect2)) {
            return null;
        }
        ViewCompat.m2581a(transitionValues2.f1324b, rect);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(transitionValues2.f1324b, (Property<View, V>) ViewUtils.f1357b, (TypeEvaluator) new RectEvaluator(new Rect()), (Object[]) new Rect[]{rect, rect2});
        if (z) {
            final View view = transitionValues2.f1324b;
            objectAnimatorOfObject.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeClipBounds.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ViewCompat.m2581a(view, (Rect) null);
                }
            });
            return objectAnimatorOfObject;
        }
        return objectAnimatorOfObject;
    }
}
