package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class Slide extends Visibility {

    /* JADX INFO: renamed from: g */
    private static final TimeInterpolator f1241g = new DecelerateInterpolator();

    /* JADX INFO: renamed from: h */
    private static final TimeInterpolator f1242h = new AccelerateInterpolator();

    /* JADX INFO: renamed from: k */
    private static final CalculateSlide f1243k = new CalculateSlideHorizontal() { // from class: android.support.transition.Slide.1
        @Override // android.support.transition.Slide.CalculateSlide
        /* JADX INFO: renamed from: a */
        public float mo1195a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    };

    /* JADX INFO: renamed from: l */
    private static final CalculateSlide f1244l = new CalculateSlideHorizontal() { // from class: android.support.transition.Slide.2
        @Override // android.support.transition.Slide.CalculateSlide
        /* JADX INFO: renamed from: a */
        public float mo1195a(ViewGroup viewGroup, View view) {
            if (ViewCompat.m2601e(viewGroup) == 1) {
                return view.getTranslationX() + viewGroup.getWidth();
            }
            return view.getTranslationX() - viewGroup.getWidth();
        }
    };

    /* JADX INFO: renamed from: m */
    private static final CalculateSlide f1245m = new CalculateSlideVertical() { // from class: android.support.transition.Slide.3
        @Override // android.support.transition.Slide.CalculateSlide
        /* JADX INFO: renamed from: b */
        public float mo1196b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    };

    /* JADX INFO: renamed from: n */
    private static final CalculateSlide f1246n = new CalculateSlideHorizontal() { // from class: android.support.transition.Slide.4
        @Override // android.support.transition.Slide.CalculateSlide
        /* JADX INFO: renamed from: a */
        public float mo1195a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    };

    /* JADX INFO: renamed from: o */
    private static final CalculateSlide f1247o = new CalculateSlideHorizontal() { // from class: android.support.transition.Slide.5
        @Override // android.support.transition.Slide.CalculateSlide
        /* JADX INFO: renamed from: a */
        public float mo1195a(ViewGroup viewGroup, View view) {
            if (ViewCompat.m2601e(viewGroup) == 1) {
                return view.getTranslationX() - viewGroup.getWidth();
            }
            return view.getTranslationX() + viewGroup.getWidth();
        }
    };

    /* JADX INFO: renamed from: p */
    private static final CalculateSlide f1248p = new CalculateSlideVertical() { // from class: android.support.transition.Slide.6
        @Override // android.support.transition.Slide.CalculateSlide
        /* JADX INFO: renamed from: b */
        public float mo1196b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    };

    /* JADX INFO: renamed from: i */
    private CalculateSlide f1249i;

    /* JADX INFO: renamed from: j */
    private int f1250j;

    private interface CalculateSlide {
        /* JADX INFO: renamed from: a */
        float mo1195a(ViewGroup viewGroup, View view);

        /* JADX INFO: renamed from: b */
        float mo1196b(ViewGroup viewGroup, View view);
    }

    private static abstract class CalculateSlideHorizontal implements CalculateSlide {
        private CalculateSlideHorizontal() {
        }

        @Override // android.support.transition.Slide.CalculateSlide
        /* JADX INFO: renamed from: b */
        public float mo1196b(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    private static abstract class CalculateSlideVertical implements CalculateSlide {
        private CalculateSlideVertical() {
        }

        @Override // android.support.transition.Slide.CalculateSlide
        /* JADX INFO: renamed from: a */
        public float mo1195a(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public Slide() {
        this.f1249i = f1248p;
        this.f1250j = 80;
        m1194a(80);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1249i = f1248p;
        this.f1250j = 80;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f1258h);
        int iM1925a = TypedArrayUtils.m1925a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        typedArrayObtainStyledAttributes.recycle();
        m1194a(iM1925a);
    }

    /* JADX INFO: renamed from: d */
    private void m1193d(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.f1324b.getLocationOnScreen(iArr);
        transitionValues.f1323a.put("android:slide:screenPosition", iArr);
    }

    @Override // android.support.transition.Visibility, android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo406a(TransitionValues transitionValues) {
        super.mo406a(transitionValues);
        m1193d(transitionValues);
    }

    @Override // android.support.transition.Visibility, android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo407b(TransitionValues transitionValues) {
        super.mo407b(transitionValues);
        m1193d(transitionValues);
    }

    /* JADX INFO: renamed from: a */
    public void m1194a(int i) {
        switch (i) {
            case 3:
                this.f1249i = f1243k;
                break;
            case 5:
                this.f1249i = f1246n;
                break;
            case 48:
                this.f1249i = f1245m;
                break;
            case 80:
                this.f1249i = f1248p;
                break;
            case 8388611:
                this.f1249i = f1244l;
                break;
            case 8388613:
                this.f1249i = f1247o;
                break;
            default:
                throw new IllegalArgumentException("Invalid slide direction");
        }
        this.f1250j = i;
        SidePropagation sidePropagation = new SidePropagation();
        sidePropagation.m1192a(i);
        mo1219a(sidePropagation);
    }

    @Override // android.support.transition.Visibility
    /* JADX INFO: renamed from: a */
    public Animator mo1131a(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.f1323a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return TranslationAnimationCreator.m1277a(view, transitionValues2, iArr[0], iArr[1], this.f1249i.mo1195a(viewGroup, view), this.f1249i.mo1196b(viewGroup, view), translationX, translationY, f1241g);
    }

    @Override // android.support.transition.Visibility
    /* JADX INFO: renamed from: b */
    public Animator mo1132b(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.f1323a.get("android:slide:screenPosition");
        return TranslationAnimationCreator.m1277a(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f1249i.mo1195a(viewGroup, view), this.f1249i.mo1196b(viewGroup, view), f1242h);
    }
}
