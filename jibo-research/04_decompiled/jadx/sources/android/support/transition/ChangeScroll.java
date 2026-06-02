package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ChangeScroll extends Transition {

    /* JADX INFO: renamed from: g */
    private static final String[] f1147g = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo406a(TransitionValues transitionValues) {
        m1104d(transitionValues);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo407b(TransitionValues transitionValues) {
        m1104d(transitionValues);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public String[] mo1075a() {
        return f1147g;
    }

    /* JADX INFO: renamed from: d */
    private void m1104d(TransitionValues transitionValues) {
        transitionValues.f1323a.put("android:changeScroll:x", Integer.valueOf(transitionValues.f1324b.getScrollX()));
        transitionValues.f1323a.put("android:changeScroll:y", Integer.valueOf(transitionValues.f1324b.getScrollY()));
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo405a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfInt2;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        View view = transitionValues2.f1324b;
        int iIntValue = ((Integer) transitionValues.f1323a.get("android:changeScroll:x")).intValue();
        int iIntValue2 = ((Integer) transitionValues2.f1323a.get("android:changeScroll:x")).intValue();
        int iIntValue3 = ((Integer) transitionValues.f1323a.get("android:changeScroll:y")).intValue();
        int iIntValue4 = ((Integer) transitionValues2.f1323a.get("android:changeScroll:y")).intValue();
        if (iIntValue != iIntValue2) {
            view.setScrollX(iIntValue);
            objectAnimatorOfInt = ObjectAnimator.ofInt(view, "scrollX", iIntValue, iIntValue2);
        } else {
            objectAnimatorOfInt = null;
        }
        if (iIntValue3 != iIntValue4) {
            view.setScrollY(iIntValue3);
            objectAnimatorOfInt2 = ObjectAnimator.ofInt(view, "scrollY", iIntValue3, iIntValue4);
        } else {
            objectAnimatorOfInt2 = null;
        }
        return TransitionUtils.m1273a(objectAnimatorOfInt, objectAnimatorOfInt2);
    }
}
