package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.yalantis.ucrop.view.CropImageView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class Fade extends Visibility {
    public Fade(int i) {
        m1333b(i);
    }

    public Fade() {
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f1256f);
        m1333b(TypedArrayUtils.m1925a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "fadingMode", 0, m1334p()));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.support.transition.Visibility, android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo406a(TransitionValues transitionValues) {
        super.mo406a(transitionValues);
        transitionValues.f1323a.put("android:fade:transitionAlpha", Float.valueOf(ViewUtils.m1305c(transitionValues.f1324b)));
    }

    /* JADX INFO: renamed from: a */
    private Animator m1134a(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ViewUtils.m1299a(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, ViewUtils.f1356a, f2);
        objectAnimatorOfFloat.addListener(new FadeAnimatorListener(view));
        mo1214a(new TransitionListenerAdapter() { // from class: android.support.transition.Fade.1
            @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
            /* JADX INFO: renamed from: a */
            public void mo1088a(Transition transition) {
                ViewUtils.m1299a(view, 1.0f);
                ViewUtils.m1308e(view);
                transition.mo1227b(this);
            }
        });
        return objectAnimatorOfFloat;
    }

    @Override // android.support.transition.Visibility
    /* JADX INFO: renamed from: a */
    public Animator mo1131a(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        float fM1133a = m1133a(transitionValues, CropImageView.DEFAULT_ASPECT_RATIO);
        if (fM1133a != 1.0f) {
            f = fM1133a;
        }
        return m1134a(view, f, 1.0f);
    }

    @Override // android.support.transition.Visibility
    /* JADX INFO: renamed from: b */
    public Animator mo1132b(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.m1307d(view);
        return m1134a(view, m1133a(transitionValues, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO);
    }

    /* JADX INFO: renamed from: a */
    private static float m1133a(TransitionValues transitionValues, float f) {
        Float f2;
        if (transitionValues != null && (f2 = (Float) transitionValues.f1323a.get("android:fade:transitionAlpha")) != null) {
            return f2.floatValue();
        }
        return f;
    }

    private static class FadeAnimatorListener extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        private final View f1184a;

        /* JADX INFO: renamed from: b */
        private boolean f1185b = false;

        FadeAnimatorListener(View view) {
            this.f1184a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewCompat.m2615s(this.f1184a) && this.f1184a.getLayerType() == 0) {
                this.f1185b = true;
                this.f1184a.setLayerType(2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewUtils.m1299a(this.f1184a, 1.0f);
            if (this.f1185b) {
                this.f1184a.setLayerType(0, null);
            }
        }
    }
}
