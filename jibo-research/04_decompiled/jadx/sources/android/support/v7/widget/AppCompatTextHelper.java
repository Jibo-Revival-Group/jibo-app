package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v7.appcompat.R;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AppCompatTextHelper {

    /* JADX INFO: renamed from: a */
    final TextView f3729a;

    /* JADX INFO: renamed from: b */
    private TintInfo f3730b;

    /* JADX INFO: renamed from: c */
    private TintInfo f3731c;

    /* JADX INFO: renamed from: d */
    private TintInfo f3732d;

    /* JADX INFO: renamed from: e */
    private TintInfo f3733e;

    /* JADX INFO: renamed from: f */
    private final AppCompatTextViewAutoSizeHelper f3734f;

    /* JADX INFO: renamed from: g */
    private int f3735g = 0;

    /* JADX INFO: renamed from: h */
    private Typeface f3736h;

    /* JADX INFO: renamed from: i */
    private boolean f3737i;

    /* JADX INFO: renamed from: a */
    static AppCompatTextHelper m3923a(TextView textView) {
        return Build.VERSION.SDK_INT >= 17 ? new AppCompatTextHelperV17(textView) : new AppCompatTextHelper(textView);
    }

    AppCompatTextHelper(TextView textView) {
        this.f3729a = textView;
        this.f3734f = new AppCompatTextViewAutoSizeHelper(this.f3729a);
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    void mo3935a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListM4969e;
        ColorStateList colorStateListM4969e2;
        boolean z;
        boolean zM4961a;
        ColorStateList colorStateListM4969e3 = null;
        Context context = this.f3729a.getContext();
        AppCompatDrawableManager appCompatDrawableManagerM3862a = AppCompatDrawableManager.m3862a();
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(context, attributeSet, R.styleable.AppCompatTextHelper, i, 0);
        int iM4972g = tintTypedArrayM4955a.m4972g(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (tintTypedArrayM4955a.m4973g(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f3730b = m3924a(context, appCompatDrawableManagerM3862a, tintTypedArrayM4955a.m4972g(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (tintTypedArrayM4955a.m4973g(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f3731c = m3924a(context, appCompatDrawableManagerM3862a, tintTypedArrayM4955a.m4972g(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (tintTypedArrayM4955a.m4973g(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f3732d = m3924a(context, appCompatDrawableManagerM3862a, tintTypedArrayM4955a.m4972g(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (tintTypedArrayM4955a.m4973g(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.f3733e = m3924a(context, appCompatDrawableManagerM3862a, tintTypedArrayM4955a.m4972g(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        tintTypedArrayM4955a.m4960a();
        boolean z2 = this.f3729a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iM4972g != -1) {
            TintTypedArray tintTypedArrayM4953a = TintTypedArray.m4953a(context, iM4972g, R.styleable.TextAppearance);
            if (z2 || !tintTypedArrayM4953a.m4973g(R.styleable.TextAppearance_textAllCaps)) {
                z = false;
                zM4961a = false;
            } else {
                zM4961a = tintTypedArrayM4953a.m4961a(R.styleable.TextAppearance_textAllCaps, false);
                z = true;
            }
            m3925a(context, tintTypedArrayM4953a);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateListM4969e2 = tintTypedArrayM4953a.m4973g(R.styleable.TextAppearance_android_textColor) ? tintTypedArrayM4953a.m4969e(R.styleable.TextAppearance_android_textColor) : null;
                colorStateListM4969e = tintTypedArrayM4953a.m4973g(R.styleable.TextAppearance_android_textColorHint) ? tintTypedArrayM4953a.m4969e(R.styleable.TextAppearance_android_textColorHint) : null;
                if (tintTypedArrayM4953a.m4973g(R.styleable.TextAppearance_android_textColorLink)) {
                    colorStateListM4969e3 = tintTypedArrayM4953a.m4969e(R.styleable.TextAppearance_android_textColorLink);
                }
            } else {
                colorStateListM4969e = null;
                colorStateListM4969e2 = null;
            }
            tintTypedArrayM4953a.m4960a();
        } else {
            colorStateListM4969e = null;
            colorStateListM4969e2 = null;
            z = false;
            zM4961a = false;
        }
        TintTypedArray tintTypedArrayM4955a2 = TintTypedArray.m4955a(context, attributeSet, R.styleable.TextAppearance, i, 0);
        if (!z2 && tintTypedArrayM4955a2.m4973g(R.styleable.TextAppearance_textAllCaps)) {
            zM4961a = tintTypedArrayM4955a2.m4961a(R.styleable.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (tintTypedArrayM4955a2.m4973g(R.styleable.TextAppearance_android_textColor)) {
                colorStateListM4969e2 = tintTypedArrayM4955a2.m4969e(R.styleable.TextAppearance_android_textColor);
            }
            if (tintTypedArrayM4955a2.m4973g(R.styleable.TextAppearance_android_textColorHint)) {
                colorStateListM4969e = tintTypedArrayM4955a2.m4969e(R.styleable.TextAppearance_android_textColorHint);
            }
            if (tintTypedArrayM4955a2.m4973g(R.styleable.TextAppearance_android_textColorLink)) {
                colorStateListM4969e3 = tintTypedArrayM4955a2.m4969e(R.styleable.TextAppearance_android_textColorLink);
            }
        }
        m3925a(context, tintTypedArrayM4955a2);
        tintTypedArrayM4955a2.m4960a();
        if (colorStateListM4969e2 != null) {
            this.f3729a.setTextColor(colorStateListM4969e2);
        }
        if (colorStateListM4969e != null) {
            this.f3729a.setHintTextColor(colorStateListM4969e);
        }
        if (colorStateListM4969e3 != null) {
            this.f3729a.setLinkTextColor(colorStateListM4969e3);
        }
        if (!z2 && z) {
            m3936a(zM4961a);
        }
        if (this.f3736h != null) {
            this.f3729a.setTypeface(this.f3736h, this.f3735g);
        }
        this.f3734f.m3964a(attributeSet, i);
        if (AutoSizeableTextView.f2518a && this.f3734f.m3960a() != 0) {
            int[] iArrM3969e = this.f3734f.m3969e();
            if (iArrM3969e.length > 0) {
                if (this.f3729a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f3729a.setAutoSizeTextTypeUniformWithConfiguration(this.f3734f.m3967c(), this.f3734f.m3968d(), this.f3734f.m3966b(), 0);
                } else {
                    this.f3729a.setAutoSizeTextTypeUniformWithPresetSizes(iArrM3969e, 0);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3925a(Context context, TintTypedArray tintTypedArray) {
        String strM4967d;
        this.f3735g = tintTypedArray.m4957a(R.styleable.TextAppearance_android_textStyle, this.f3735g);
        if (tintTypedArray.m4973g(R.styleable.TextAppearance_android_fontFamily) || tintTypedArray.m4973g(R.styleable.TextAppearance_fontFamily)) {
            this.f3736h = null;
            int i = tintTypedArray.m4973g(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.f3729a);
                try {
                    this.f3736h = tintTypedArray.m4958a(i, this.f3735g, new ResourcesCompat.FontCallback() { // from class: android.support.v7.widget.AppCompatTextHelper.1
                        @Override // android.support.v4.content.res.ResourcesCompat.FontCallback
                        /* JADX INFO: renamed from: a */
                        public void mo1922a(Typeface typeface) {
                            AppCompatTextHelper.this.m3927a((WeakReference<TextView>) weakReference, typeface);
                        }

                        @Override // android.support.v4.content.res.ResourcesCompat.FontCallback
                        /* JADX INFO: renamed from: a */
                        public void mo1920a(int i2) {
                        }
                    });
                    this.f3737i = this.f3736h == null;
                } catch (Resources.NotFoundException e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
            if (this.f3736h == null && (strM4967d = tintTypedArray.m4967d(i)) != null) {
                this.f3736h = Typeface.create(strM4967d, this.f3735g);
            }
            return;
        }
        if (tintTypedArray.m4973g(R.styleable.TextAppearance_android_typeface)) {
            this.f3737i = false;
            switch (tintTypedArray.m4957a(R.styleable.TextAppearance_android_typeface, 1)) {
                case 1:
                    this.f3736h = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.f3736h = Typeface.SERIF;
                    break;
                case 3:
                    this.f3736h = Typeface.MONOSPACE;
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m3927a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f3737i) {
            this.f3736h = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f3735g);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m3933a(Context context, int i) {
        ColorStateList colorStateListM4969e;
        TintTypedArray tintTypedArrayM4953a = TintTypedArray.m4953a(context, i, R.styleable.TextAppearance);
        if (tintTypedArrayM4953a.m4973g(R.styleable.TextAppearance_textAllCaps)) {
            m3936a(tintTypedArrayM4953a.m4961a(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && tintTypedArrayM4953a.m4973g(R.styleable.TextAppearance_android_textColor) && (colorStateListM4969e = tintTypedArrayM4953a.m4969e(R.styleable.TextAppearance_android_textColor)) != null) {
            this.f3729a.setTextColor(colorStateListM4969e);
        }
        m3925a(context, tintTypedArrayM4953a);
        tintTypedArrayM4953a.m4960a();
        if (this.f3736h != null) {
            this.f3729a.setTypeface(this.f3736h, this.f3735g);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3936a(boolean z) {
        this.f3729a.setAllCaps(z);
    }

    /* JADX INFO: renamed from: a */
    void mo3929a() {
        if (this.f3730b != null || this.f3731c != null || this.f3732d != null || this.f3733e != null) {
            Drawable[] compoundDrawables = this.f3729a.getCompoundDrawables();
            m3934a(compoundDrawables[0], this.f3730b);
            m3934a(compoundDrawables[1], this.f3731c);
            m3934a(compoundDrawables[2], this.f3732d);
            m3934a(compoundDrawables[3], this.f3733e);
        }
    }

    /* JADX INFO: renamed from: a */
    final void m3934a(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.m3865a(drawable, tintInfo, this.f3729a.getDrawableState());
        }
    }

    /* JADX INFO: renamed from: a */
    protected static TintInfo m3924a(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList colorStateListM3885b = appCompatDrawableManager.m3885b(context, i);
        if (colorStateListM3885b == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.f4430d = true;
        tintInfo.f4427a = colorStateListM3885b;
        return tintInfo;
    }

    /* JADX INFO: renamed from: a */
    void m3937a(boolean z, int i, int i2, int i3, int i4) {
        if (!AutoSizeableTextView.f2518a) {
            m3939b();
        }
    }

    /* JADX INFO: renamed from: a */
    void m3931a(int i, float f) {
        if (!AutoSizeableTextView.f2518a && !m3940c()) {
            m3928b(i, f);
        }
    }

    /* JADX INFO: renamed from: b */
    void m3939b() {
        this.f3734f.m3970f();
    }

    /* JADX INFO: renamed from: c */
    boolean m3940c() {
        return this.f3734f.m3971g();
    }

    /* JADX INFO: renamed from: b */
    private void m3928b(int i, float f) {
        this.f3734f.m3962a(i, f);
    }

    /* JADX INFO: renamed from: a */
    void m3930a(int i) {
        this.f3734f.m3961a(i);
    }

    /* JADX INFO: renamed from: a */
    void m3932a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        this.f3734f.m3963a(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: a */
    void m3938a(int[] iArr, int i) throws IllegalArgumentException {
        this.f3734f.m3965a(iArr, i);
    }

    /* JADX INFO: renamed from: d */
    int m3941d() {
        return this.f3734f.m3960a();
    }

    /* JADX INFO: renamed from: e */
    int m3942e() {
        return this.f3734f.m3966b();
    }

    /* JADX INFO: renamed from: f */
    int m3943f() {
        return this.f3734f.m3967c();
    }

    /* JADX INFO: renamed from: g */
    int m3944g() {
        return this.f3734f.m3968d();
    }

    /* JADX INFO: renamed from: h */
    int[] m3945h() {
        return this.f3734f.m3969e();
    }
}
