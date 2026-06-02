package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TextScale extends Transition {
    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo406a(TransitionValues transitionValues) {
        m404d(transitionValues);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo407b(TransitionValues transitionValues) {
        m404d(transitionValues);
    }

    /* JADX INFO: renamed from: d */
    private void m404d(TransitionValues transitionValues) {
        if (transitionValues.f1324b instanceof TextView) {
            transitionValues.f1323a.put("android:textscale:scale", Float.valueOf(((TextView) transitionValues.f1324b).getScaleX()));
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo405a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.f1324b instanceof TextView) || !(transitionValues2.f1324b instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) transitionValues2.f1324b;
        Map<String, Object> map = transitionValues.f1323a;
        Map<String, Object> map2 = transitionValues2.f1323a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.internal.TextScale.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(fFloatValue3);
                textView.setScaleY(fFloatValue3);
            }
        });
        return valueAnimatorOfFloat;
    }
}
