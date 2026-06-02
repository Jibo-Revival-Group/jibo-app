package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageHelper {

    /* JADX INFO: renamed from: a */
    private final ImageView f3683a;

    /* JADX INFO: renamed from: b */
    private TintInfo f3684b;

    /* JADX INFO: renamed from: c */
    private TintInfo f3685c;

    /* JADX INFO: renamed from: d */
    private TintInfo f3686d;

    public AppCompatImageHelper(ImageView imageView) {
        this.f3683a = imageView;
    }

    /* JADX INFO: renamed from: a */
    public void m3896a(AttributeSet attributeSet, int i) {
        int iM4972g;
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(this.f3683a.getContext(), attributeSet, R.styleable.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f3683a.getDrawable();
            if (drawable == null && (iM4972g = tintTypedArrayM4955a.m4972g(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = AppCompatResources.m3426b(this.f3683a.getContext(), iM4972g)) != null) {
                this.f3683a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.m4116b(drawable);
            }
            if (tintTypedArrayM4955a.m4973g(R.styleable.AppCompatImageView_tint)) {
                ImageViewCompat.m3015a(this.f3683a, tintTypedArrayM4955a.m4969e(R.styleable.AppCompatImageView_tint));
            }
            if (tintTypedArrayM4955a.m4973g(R.styleable.AppCompatImageView_tintMode)) {
                ImageViewCompat.m3016a(this.f3683a, DrawableUtils.m4114a(tintTypedArrayM4955a.m4957a(R.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            tintTypedArrayM4955a.m4960a();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3893a(int i) {
        if (i != 0) {
            Drawable drawableM3426b = AppCompatResources.m3426b(this.f3683a.getContext(), i);
            if (drawableM3426b != null) {
                DrawableUtils.m4116b(drawableM3426b);
            }
            this.f3683a.setImageDrawable(drawableM3426b);
        } else {
            this.f3683a.setImageDrawable(null);
        }
        m3900d();
    }

    /* JADX INFO: renamed from: a */
    boolean m3897a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f3683a.getBackground() instanceof RippleDrawable);
    }

    /* JADX INFO: renamed from: a */
    void m3894a(ColorStateList colorStateList) {
        if (this.f3685c == null) {
            this.f3685c = new TintInfo();
        }
        this.f3685c.f4427a = colorStateList;
        this.f3685c.f4430d = true;
        m3900d();
    }

    /* JADX INFO: renamed from: b */
    ColorStateList m3898b() {
        if (this.f3685c != null) {
            return this.f3685c.f4427a;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m3895a(PorterDuff.Mode mode) {
        if (this.f3685c == null) {
            this.f3685c = new TintInfo();
        }
        this.f3685c.f4428b = mode;
        this.f3685c.f4429c = true;
        m3900d();
    }

    /* JADX INFO: renamed from: c */
    PorterDuff.Mode m3899c() {
        if (this.f3685c != null) {
            return this.f3685c.f4428b;
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    void m3900d() {
        Drawable drawable = this.f3683a.getDrawable();
        if (drawable != null) {
            DrawableUtils.m4116b(drawable);
        }
        if (drawable != null) {
            if (!m3892e() || !m3891a(drawable)) {
                if (this.f3685c != null) {
                    AppCompatDrawableManager.m3865a(drawable, this.f3685c, this.f3683a.getDrawableState());
                } else if (this.f3684b != null) {
                    AppCompatDrawableManager.m3865a(drawable, this.f3684b, this.f3683a.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private boolean m3892e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f3684b != null : i == 21;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3891a(Drawable drawable) {
        if (this.f3686d == null) {
            this.f3686d = new TintInfo();
        }
        TintInfo tintInfo = this.f3686d;
        tintInfo.m4952a();
        ColorStateList colorStateListM3014a = ImageViewCompat.m3014a(this.f3683a);
        if (colorStateListM3014a != null) {
            tintInfo.f4430d = true;
            tintInfo.f4427a = colorStateListM3014a;
        }
        PorterDuff.Mode modeM3017b = ImageViewCompat.m3017b(this.f3683a);
        if (modeM3017b != null) {
            tintInfo.f4429c = true;
            tintInfo.f4428b = modeM3017b;
        }
        if (!tintInfo.f4430d && !tintInfo.f4429c) {
            return false;
        }
        AppCompatDrawableManager.m3865a(drawable, tintInfo, this.f3683a.getDrawableState());
        return true;
    }
}
