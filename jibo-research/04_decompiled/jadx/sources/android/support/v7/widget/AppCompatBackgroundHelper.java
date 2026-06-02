package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class AppCompatBackgroundHelper {

    /* JADX INFO: renamed from: a */
    private final View f3646a;

    /* JADX INFO: renamed from: d */
    private TintInfo f3649d;

    /* JADX INFO: renamed from: e */
    private TintInfo f3650e;

    /* JADX INFO: renamed from: f */
    private TintInfo f3651f;

    /* JADX INFO: renamed from: c */
    private int f3648c = -1;

    /* JADX INFO: renamed from: b */
    private final AppCompatDrawableManager f3647b = AppCompatDrawableManager.m3862a();

    AppCompatBackgroundHelper(View view) {
        this.f3646a = view;
    }

    /* JADX INFO: renamed from: a */
    void m3844a(AttributeSet attributeSet, int i) {
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(this.f3646a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (tintTypedArrayM4955a.m4973g(R.styleable.ViewBackgroundHelper_android_background)) {
                this.f3648c = tintTypedArrayM4955a.m4972g(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListM3885b = this.f3647b.m3885b(this.f3646a.getContext(), this.f3648c);
                if (colorStateListM3885b != null) {
                    m3846b(colorStateListM3885b);
                }
            }
            if (tintTypedArrayM4955a.m4973g(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.m2578a(this.f3646a, tintTypedArrayM4955a.m4969e(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (tintTypedArrayM4955a.m4973g(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.m2580a(this.f3646a, DrawableUtils.m4114a(tintTypedArrayM4955a.m4957a(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            tintTypedArrayM4955a.m4960a();
        }
    }

    /* JADX INFO: renamed from: a */
    void m3840a(int i) {
        this.f3648c = i;
        m3846b(this.f3647b != null ? this.f3647b.m3885b(this.f3646a.getContext(), i) : null);
        m3847c();
    }

    /* JADX INFO: renamed from: a */
    void m3843a(Drawable drawable) {
        this.f3648c = -1;
        m3846b((ColorStateList) null);
        m3847c();
    }

    /* JADX INFO: renamed from: a */
    void m3841a(ColorStateList colorStateList) {
        if (this.f3650e == null) {
            this.f3650e = new TintInfo();
        }
        this.f3650e.f4427a = colorStateList;
        this.f3650e.f4430d = true;
        m3847c();
    }

    /* JADX INFO: renamed from: a */
    ColorStateList m3839a() {
        if (this.f3650e != null) {
            return this.f3650e.f4427a;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m3842a(PorterDuff.Mode mode) {
        if (this.f3650e == null) {
            this.f3650e = new TintInfo();
        }
        this.f3650e.f4428b = mode;
        this.f3650e.f4429c = true;
        m3847c();
    }

    /* JADX INFO: renamed from: b */
    PorterDuff.Mode m3845b() {
        if (this.f3650e != null) {
            return this.f3650e.f4428b;
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    void m3847c() {
        Drawable background = this.f3646a.getBackground();
        if (background != null) {
            if (!m3838d() || !m3837b(background)) {
                if (this.f3650e != null) {
                    AppCompatDrawableManager.m3865a(background, this.f3650e, this.f3646a.getDrawableState());
                } else if (this.f3649d != null) {
                    AppCompatDrawableManager.m3865a(background, this.f3649d, this.f3646a.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m3846b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f3649d == null) {
                this.f3649d = new TintInfo();
            }
            this.f3649d.f4427a = colorStateList;
            this.f3649d.f4430d = true;
        } else {
            this.f3649d = null;
        }
        m3847c();
    }

    /* JADX INFO: renamed from: d */
    private boolean m3838d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f3649d != null : i == 21;
    }

    /* JADX INFO: renamed from: b */
    private boolean m3837b(Drawable drawable) {
        if (this.f3651f == null) {
            this.f3651f = new TintInfo();
        }
        TintInfo tintInfo = this.f3651f;
        tintInfo.m4952a();
        ColorStateList colorStateListM2617u = ViewCompat.m2617u(this.f3646a);
        if (colorStateListM2617u != null) {
            tintInfo.f4430d = true;
            tintInfo.f4427a = colorStateListM2617u;
        }
        PorterDuff.Mode modeM2618v = ViewCompat.m2618v(this.f3646a);
        if (modeM2618v != null) {
            tintInfo.f4429c = true;
            tintInfo.f4428b = modeM2618v;
        }
        if (!tintInfo.f4430d && !tintInfo.f4429c) {
            return false;
        }
        AppCompatDrawableManager.m3865a(drawable, tintInfo, this.f3646a.getDrawableState());
        return true;
    }
}
