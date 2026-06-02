package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class Explode extends Visibility {

    /* JADX INFO: renamed from: g */
    private static final TimeInterpolator f1179g = new DecelerateInterpolator();

    /* JADX INFO: renamed from: h */
    private static final TimeInterpolator f1180h = new AccelerateInterpolator();

    /* JADX INFO: renamed from: i */
    private int[] f1181i;

    public Explode() {
        this.f1181i = new int[2];
        mo1219a(new CircularPropagation());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1181i = new int[2];
        mo1219a(new CircularPropagation());
    }

    /* JADX INFO: renamed from: d */
    private void m1130d(TransitionValues transitionValues) {
        View view = transitionValues.f1324b;
        view.getLocationOnScreen(this.f1181i);
        int i = this.f1181i[0];
        int i2 = this.f1181i[1];
        transitionValues.f1323a.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    @Override // android.support.transition.Visibility, android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo406a(TransitionValues transitionValues) {
        super.mo406a(transitionValues);
        m1130d(transitionValues);
    }

    @Override // android.support.transition.Visibility, android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo407b(TransitionValues transitionValues) {
        super.mo407b(transitionValues);
        m1130d(transitionValues);
    }

    @Override // android.support.transition.Visibility
    /* JADX INFO: renamed from: a */
    public Animator mo1131a(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.f1323a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        m1129a(viewGroup, rect, this.f1181i);
        return TranslationAnimationCreator.m1277a(view, transitionValues2, rect.left, rect.top, translationX + this.f1181i[0], translationY + this.f1181i[1], translationX, translationY, f1179g);
    }

    @Override // android.support.transition.Visibility
    /* JADX INFO: renamed from: b */
    public Animator mo1132b(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f;
        float f2;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.f1323a.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.f1324b.getTag(R.id.transition_position);
        if (iArr != null) {
            float f3 = translationX + (iArr[0] - rect.left);
            rect.offsetTo(iArr[0], iArr[1]);
            f = (iArr[1] - rect.top) + translationY;
            f2 = f3;
        } else {
            f = translationY;
            f2 = translationX;
        }
        m1129a(viewGroup, rect, this.f1181i);
        return TranslationAnimationCreator.m1277a(view, transitionValues, i, i2, translationX, translationY, f2 + this.f1181i[0], f + this.f1181i[1], f1180h);
    }

    /* JADX INFO: renamed from: a */
    private void m1129a(View view, Rect rect, int[] iArr) {
        int iCenterX;
        int iCenterY;
        view.getLocationOnScreen(this.f1181i);
        int i = this.f1181i[0];
        int i2 = this.f1181i[1];
        Rect rectM = m1246m();
        if (rectM == null) {
            iCenterX = Math.round(view.getTranslationX()) + (view.getWidth() / 2) + i;
            iCenterY = (view.getHeight() / 2) + i2 + Math.round(view.getTranslationY());
        } else {
            iCenterX = rectM.centerX();
            iCenterY = rectM.centerY();
        }
        float fCenterX = rect.centerX() - iCenterX;
        float fCenterY = rect.centerY() - iCenterY;
        if (fCenterX == CropImageView.DEFAULT_ASPECT_RATIO && fCenterY == CropImageView.DEFAULT_ASPECT_RATIO) {
            fCenterX = ((float) (Math.random() * 2.0d)) - 1.0f;
            fCenterY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float fM1127a = m1127a(fCenterX, fCenterY);
        float fM1128a = m1128a(view, iCenterX - i, iCenterY - i2);
        iArr[0] = Math.round((fCenterX / fM1127a) * fM1128a);
        iArr[1] = Math.round(fM1128a * (fCenterY / fM1127a));
    }

    /* JADX INFO: renamed from: a */
    private static float m1128a(View view, int i, int i2) {
        return m1127a(Math.max(i, view.getWidth() - i), Math.max(i2, view.getHeight() - i2));
    }

    /* JADX INFO: renamed from: a */
    private static float m1127a(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }
}
