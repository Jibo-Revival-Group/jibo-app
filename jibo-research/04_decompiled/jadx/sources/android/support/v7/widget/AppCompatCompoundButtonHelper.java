package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
class AppCompatCompoundButtonHelper {

    /* JADX INFO: renamed from: a */
    private final CompoundButton f3657a;

    /* JADX INFO: renamed from: b */
    private ColorStateList f3658b = null;

    /* JADX INFO: renamed from: c */
    private PorterDuff.Mode f3659c = null;

    /* JADX INFO: renamed from: d */
    private boolean f3660d = false;

    /* JADX INFO: renamed from: e */
    private boolean f3661e = false;

    /* JADX INFO: renamed from: f */
    private boolean f3662f;

    AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.f3657a = compoundButton;
    }

    /* JADX INFO: renamed from: a */
    void m3852a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f3657a.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0)) != 0) {
                this.f3657a.setButtonDrawable(AppCompatResources.m3426b(this.f3657a.getContext(), resourceId));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.m2929a(this.f3657a, typedArrayObtainStyledAttributes.getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.m2930a(this.f3657a, DrawableUtils.m4114a(typedArrayObtainStyledAttributes.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    void m3850a(ColorStateList colorStateList) {
        this.f3658b = colorStateList;
        this.f3660d = true;
        m3855d();
    }

    /* JADX INFO: renamed from: a */
    ColorStateList m3849a() {
        return this.f3658b;
    }

    /* JADX INFO: renamed from: a */
    void m3851a(PorterDuff.Mode mode) {
        this.f3659c = mode;
        this.f3661e = true;
        m3855d();
    }

    /* JADX INFO: renamed from: b */
    PorterDuff.Mode m3853b() {
        return this.f3659c;
    }

    /* JADX INFO: renamed from: c */
    void m3854c() {
        if (this.f3662f) {
            this.f3662f = false;
        } else {
            this.f3662f = true;
            m3855d();
        }
    }

    /* JADX INFO: renamed from: d */
    void m3855d() {
        Drawable drawableM2928a = CompoundButtonCompat.m2928a(this.f3657a);
        if (drawableM2928a != null) {
            if (this.f3660d || this.f3661e) {
                Drawable drawableMutate = DrawableCompat.m2000g(drawableM2928a).mutate();
                if (this.f3660d) {
                    DrawableCompat.m1989a(drawableMutate, this.f3658b);
                }
                if (this.f3661e) {
                    DrawableCompat.m1992a(drawableMutate, this.f3659c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f3657a.getDrawableState());
                }
                this.f3657a.setButtonDrawable(drawableMutate);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    int m3848a(int i) {
        Drawable drawableM2928a;
        if (Build.VERSION.SDK_INT < 17 && (drawableM2928a = CompoundButtonCompat.m2928a(this.f3657a)) != null) {
            return i + drawableM2928a.getIntrinsicWidth();
        }
        return i;
    }
}
