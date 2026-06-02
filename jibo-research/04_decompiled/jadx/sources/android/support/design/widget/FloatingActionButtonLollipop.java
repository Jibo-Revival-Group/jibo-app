package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.Property;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class FloatingActionButtonLollipop extends FloatingActionButtonImpl {

    /* JADX INFO: renamed from: p */
    private InsetDrawable f770p;

    FloatingActionButtonLollipop(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        super(visibilityAwareImageButton, shadowViewDelegate);
    }

    @Override // android.support.design.widget.FloatingActionButtonImpl
    /* JADX INFO: renamed from: a */
    void mo753a(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.f743d = DrawableCompat.m2000g(m770k());
        DrawableCompat.m1989a(this.f743d, colorStateList);
        if (mode != null) {
            DrawableCompat.m1992a(this.f743d, mode);
        }
        if (i2 > 0) {
            this.f745f = m748a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.f745f, this.f743d});
        } else {
            this.f745f = null;
            layerDrawable = this.f743d;
        }
        this.f744e = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.f746g = this.f744e;
        this.f750o.mo740a(this.f744e);
    }

    @Override // android.support.design.widget.FloatingActionButtonImpl
    /* JADX INFO: renamed from: a */
    void mo751a(int i) {
        if (this.f744e instanceof RippleDrawable) {
            ((RippleDrawable) this.f744e).setColor(ColorStateList.valueOf(i));
        } else {
            super.mo751a(i);
        }
    }

    @Override // android.support.design.widget.FloatingActionButtonImpl
    /* JADX INFO: renamed from: a */
    void mo750a(float f, float f2) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.f749n.isEnabled()) {
                this.f749n.setElevation(f);
                if (this.f749n.isFocused() || this.f749n.isPressed()) {
                    this.f749n.setTranslationZ(f2);
                } else {
                    this.f749n.setTranslationZ(CropImageView.DEFAULT_ASPECT_RATIO);
                }
            } else {
                this.f749n.setElevation(CropImageView.DEFAULT_ASPECT_RATIO);
                this.f749n.setTranslationZ(CropImageView.DEFAULT_ASPECT_RATIO);
            }
        } else {
            android.animation.StateListAnimator stateListAnimator = new android.animation.StateListAnimator();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.f749n, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f749n, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
            animatorSet.setInterpolator(f736a);
            stateListAnimator.addState(f737j, animatorSet);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.play(ObjectAnimator.ofFloat(this.f749n, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f749n, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
            animatorSet2.setInterpolator(f736a);
            stateListAnimator.addState(f738k, animatorSet2);
            AnimatorSet animatorSet3 = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f749n, "elevation", f).setDuration(0L));
            if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.f749n, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, this.f749n.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f749n, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, CropImageView.DEFAULT_ASPECT_RATIO).setDuration(100L));
            animatorSet3.playSequentially((Animator[]) arrayList.toArray(new ObjectAnimator[0]));
            animatorSet3.setInterpolator(f736a);
            stateListAnimator.addState(f739l, animatorSet3);
            AnimatorSet animatorSet4 = new AnimatorSet();
            animatorSet4.play(ObjectAnimator.ofFloat(this.f749n, "elevation", CropImageView.DEFAULT_ASPECT_RATIO).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f749n, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, CropImageView.DEFAULT_ASPECT_RATIO).setDuration(0L));
            animatorSet4.setInterpolator(f736a);
            stateListAnimator.addState(f740m, animatorSet4);
            this.f749n.setStateListAnimator(stateListAnimator);
        }
        if (this.f750o.mo741b()) {
            m764e();
        }
    }

    @Override // android.support.design.widget.FloatingActionButtonImpl
    /* JADX INFO: renamed from: a */
    public float mo747a() {
        return this.f749n.getElevation();
    }

    @Override // android.support.design.widget.FloatingActionButtonImpl
    /* JADX INFO: renamed from: d */
    void mo763d() {
        m764e();
    }

    @Override // android.support.design.widget.FloatingActionButtonImpl
    /* JADX INFO: renamed from: b */
    void mo760b(Rect rect) {
        if (this.f750o.mo741b()) {
            this.f770p = new InsetDrawable(this.f744e, rect.left, rect.top, rect.right, rect.bottom);
            this.f750o.mo740a(this.f770p);
        } else {
            this.f750o.mo740a(this.f744e);
        }
    }

    @Override // android.support.design.widget.FloatingActionButtonImpl
    /* JADX INFO: renamed from: a */
    void mo757a(int[] iArr) {
    }

    @Override // android.support.design.widget.FloatingActionButtonImpl
    /* JADX INFO: renamed from: b */
    void mo758b() {
    }

    @Override // android.support.design.widget.FloatingActionButtonImpl
    /* JADX INFO: renamed from: h */
    boolean mo767h() {
        return false;
    }

    @Override // android.support.design.widget.FloatingActionButtonImpl
    /* JADX INFO: renamed from: i */
    CircularBorderDrawable mo768i() {
        return new CircularBorderDrawableLollipop();
    }

    @Override // android.support.design.widget.FloatingActionButtonImpl
    /* JADX INFO: renamed from: l */
    GradientDrawable mo771l() {
        return new AlwaysStatefulGradientDrawable();
    }

    @Override // android.support.design.widget.FloatingActionButtonImpl
    /* JADX INFO: renamed from: a */
    void mo755a(Rect rect) {
        if (this.f750o.mo741b()) {
            float fMo738a = this.f750o.mo738a();
            float fMo747a = mo747a() + this.f748i;
            int iCeil = (int) Math.ceil(ShadowDrawableWrapper.m795b(fMo747a, fMo738a, false));
            int iCeil2 = (int) Math.ceil(ShadowDrawableWrapper.m792a(fMo747a, fMo738a, false));
            rect.set(iCeil, iCeil2, iCeil, iCeil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    static class AlwaysStatefulGradientDrawable extends GradientDrawable {
        AlwaysStatefulGradientDrawable() {
        }

        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }
}
