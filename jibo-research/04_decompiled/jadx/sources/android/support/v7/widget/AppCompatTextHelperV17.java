package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
class AppCompatTextHelperV17 extends AppCompatTextHelper {

    /* JADX INFO: renamed from: b */
    private TintInfo f3740b;

    /* JADX INFO: renamed from: c */
    private TintInfo f3741c;

    AppCompatTextHelperV17(TextView textView) {
        super(textView);
    }

    @Override // android.support.v7.widget.AppCompatTextHelper
    /* JADX INFO: renamed from: a */
    void mo3935a(AttributeSet attributeSet, int i) {
        super.mo3935a(attributeSet, i);
        Context context = this.f3729a.getContext();
        AppCompatDrawableManager appCompatDrawableManagerM3862a = AppCompatDrawableManager.m3862a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextHelper, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableStart)) {
            this.f3740b = m3924a(context, appCompatDrawableManagerM3862a, typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
            this.f3741c = m3924a(context, appCompatDrawableManagerM3862a, typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.support.v7.widget.AppCompatTextHelper
    /* JADX INFO: renamed from: a */
    void mo3929a() {
        super.mo3929a();
        if (this.f3740b != null || this.f3741c != null) {
            Drawable[] compoundDrawablesRelative = this.f3729a.getCompoundDrawablesRelative();
            m3934a(compoundDrawablesRelative[0], this.f3740b);
            m3934a(compoundDrawablesRelative[2], this.f3741c);
        }
    }
}
